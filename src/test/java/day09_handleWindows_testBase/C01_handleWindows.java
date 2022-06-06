package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
    WebDriver d;

    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        d = new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
       // d.quit();
    }

    @Test
    public void test01(){

        // 1- amazon ana sayfaya gidin
        d.get("https://www.amazon.com");
        String ilkSayfa1=d.getWindowHandle();


        //d.switchTo().window("")
        // 2- nutella icin arama yaptirin
        d.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);


        // 3- ilk urunun resmini tiklayarak farkli bir tab olarak acin

        d.switchTo().newWindow(WindowType.TAB);
        d.get("https://www.amazon.com");
        d.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        WebElement ikinciUrunResmi=d.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[2]"));
        ikinciUrunResmi.click();

        // ilk sayfaya gecip url'i yazdiralim

        d.switchTo().window(ilkSayfa1);
        System.out.println(d.getCurrentUrl());



    }


}
