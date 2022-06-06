package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver a=new ChromeDriver();
        a.manage().window().maximize();
        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        a.get("https://amazon.com");

        a.close();
    }
}
