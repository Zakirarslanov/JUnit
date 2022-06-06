package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_JUnitIlkTest {

    @Test
    public void method1(){
        WebDriverManager.chromedriver().setup();
        WebDriver a= new ChromeDriver();
        a.manage().window().maximize();
        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        a.get("http://amazon.com");
        a.close();
    }

    @Test
    public void method2(){
        WebDriverManager.chromedriver().setup();
        WebDriver a= new ChromeDriver();
        a.manage().window().maximize();
        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        a.get("http://techproeducation.com");
        a.close();
    }

    @Test
    public void method3(){
        WebDriverManager.chromedriver().setup();
        WebDriver a= new ChromeDriver();
        a.manage().window().maximize();
        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        a.get("http://facebook.com");
        a.close();
    }



}
