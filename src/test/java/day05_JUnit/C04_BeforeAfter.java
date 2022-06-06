package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeAfter {
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
    }
    @Test
    public void test02(){
        d.get("https://www.techproeducation.com/");
    }
    @Test
    public void test03(){
        d.get("https://www.facebook.com");
    }




}
