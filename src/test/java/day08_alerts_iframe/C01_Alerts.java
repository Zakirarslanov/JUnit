package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Alerts {
    WebDriver d;

    @Before

    public void setUp(){

        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        //d.close();
    }

    @Test
    public void test01(){
         /* herhangi bir web sitesine gidince veya
           bir websitesinde herhangi bir islem yaptigimizda ortaya cikan uyarilara alert diyoruz
           Eger bir alert inspect yapilabiliyorsa, o alert otomasyon ile kullanilanilabilir,
           bu tur alert'lere HTML alert denir ve bunlar icin ekstra bir islme yapmaya gerek yoktur
           tum webelementler gibi locate edip istedigimiz islemleri yapabiliriz
           driver.get("https://www.facebook.com"); da cikan alert vb..
           Ancak web uygulamalarinda HTML alert yaninda java script alert de bulunabilir
           js alert'ler locate edilemez
           Selenium'da JS alert'ler icin ozel bir yontem gelistirmistir
         */
        d.get("https://the-internet.herokuapp.com/javascript_alerts");

        d.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        d.switchTo().alert().accept();

        // result kisminda "You successfully clicked an alert" yazdigini test edin
        String expectedResult = "You successfully clicked an alert";
        WebElement sonuc=d.findElement(By.xpath("//p[@id='result']"));
        String actualResult=sonuc.getText();

        Assert.assertEquals(expectedResult,actualResult);









    }

}
