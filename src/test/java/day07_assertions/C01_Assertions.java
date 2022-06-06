package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    static WebDriver d;
     /*
    amazon ana sayfaya gidin
    3 farkli test method'u olusturarak asagidaki gorevleri yapin
    1- Url'in amazon icerdigini test edin
    2- title'in facebook icermedigini test edin
    3- sol ust kosede amazon logosunun gorundugunu test edin
     */

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        d.get("https://amazon.com");

    }
    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        d.close();
    }
    @Test
    public void test01(){
        // 1- Url'in amazon icerdigini test edin


        String arananKelime="amazon";
        String actualUrl=d.getCurrentUrl();
        Assert.assertTrue(d.getCurrentUrl().contains(arananKelime));

    }
    @Test
    public void test02(){
        //title'in facebook icermedigini test edin
        String istenmeyenKelime="facebook";
        String actualTitle=d.getTitle();
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));





    }
    @Test
    public void test03(){
        //sol ust kosede amazon logosunun gorundugunu test edin

        WebElement logoElementi=d.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logoElementi.isDisplayed());




    }


}





























