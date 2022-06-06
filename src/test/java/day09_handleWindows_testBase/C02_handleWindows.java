package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_handleWindows {

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
    public void test01() {

        // 1- amazon anasayfaya gidelim
        d.get("https://www.amazon.com");
        String amazonWindowHandle=d.getWindowHandle();

        // 2- url'in  amazon icerdigini test edelim
        String amazonUrl=d.getCurrentUrl();
        String expectedWord="amazon";
        Assert.assertTrue(amazonUrl.contains(expectedWord));

        // 3- yeni bir pencere acip bestbuy ana sayfaya gidelim
        d.switchTo().newWindow(WindowType.WINDOW);
        d.get("https://www.bestbuy.com");
        String bestBuyWindowHandle=d.getWindowHandle();

        // 4- title'in Best Buy icerdigini test edelim
        String bestbuyTittle=d.getTitle();
        String expectedWordb="Best Buy";
        Assert.assertTrue(bestbuyTittle.contains(expectedWordb));

        // 5- ilk sayfaya donup sayfada java aratalim
        d.switchTo().window(amazonWindowHandle);
        d.findElement(By.id("twotabsearchtextbox")).sendKeys("java"+ Keys.ENTER);

        // 6- arama sonuclarinin Java icerdigini test edelim
        WebElement aramaSonuc=d.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String actualResult=aramaSonuc.getText();
        String expectedString="java";
        Assert.assertTrue(actualResult.contains(expectedString));

        // 7- yeniden bestbuy'in acik oldugu sayfaya gidelim
        d.switchTo().window(bestBuyWindowHandle);

        // 8- logonun gorundugunu test edelim
        WebElement logo=d.findElement(By.xpath("//img[@class='logo']"));
        Assert.assertTrue(logo.isDisplayed());





    }

    }
