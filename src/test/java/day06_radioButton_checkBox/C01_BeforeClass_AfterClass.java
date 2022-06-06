package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_BeforeClass_AfterClass {
    static WebDriver d;

    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
    public static void tearDown(){
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


