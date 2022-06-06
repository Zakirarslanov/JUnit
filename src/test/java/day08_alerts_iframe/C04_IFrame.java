package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_IFrame {
    static WebDriver d;
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
        //   ● https://the-internet.herokuapp.com/iframe adresine gidin.
        d.get("https://the-internet.herokuapp.com/iframe");

        //   ● Bir metod olusturun: iframeTest
        //      ○ “An IFrame containing….” textinin erisilebilir oldugunu test edin
        //      ve  konsolda    yazdirin.
        WebElement baslikElementi=d.findElement(By.xpath("//h3"));
        Assert.assertTrue(baslikElementi.isEnabled());
        System.out.println(baslikElementi.getText());









    }

}



















