package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C05_DropDownOptions {
    /*
        Amazon anasayfaya gidip
        dropdown menuden books'u secelim
        sectigimiz option'i yazdiralim
        dropdown'daki opsiyonlarin toplam sayisinin
        28 oldugunu test edin
     */
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
       d.close();
    }

    @Test

    public void test01(){
        d.get("https://www.amazon.com");
        WebElement dropDown=d.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        Select select=new Select(dropDown);

        select.selectByVisibleText("Books");
        System.out.println(select.getFirstSelectedOption().getText());

        int optlist=select.getOptions().size();

        Assert.assertEquals(28,optlist);


    }



}
