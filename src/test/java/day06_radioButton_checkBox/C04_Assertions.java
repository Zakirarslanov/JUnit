package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {


    // url'in https://www.facebook.com oldugunu test edin

    WebDriver d;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        d.close();
    }
    @Test

    public void test01(){
        d.get("https://www.amazon.com");

        // url'in https://www.facebook.com oldugunu test edin

      /*  if (d.getCurrentUrl().equals("https://www.facebook.com")){
            System.out.println(" URL test PASSED");
        }else{
            System.out.println(" URL test FAİLED");
        }*/


        String expectedUrl="https://www.facebook.com";
        String actualUrl=d.getCurrentUrl();

        Assert.assertEquals("hata şekli : ",expectedUrl,actualUrl);

    }



}
