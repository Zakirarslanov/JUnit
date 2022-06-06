package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BestBuyAssertions {
   static WebDriver d;
    // 2) https://www.bestbuy.com/ Adresine gidin
    //    farkli test method’lari olusturarak asagidaki testleri yapin
    //      ○ Sayfa URL’inin https://www.bestbuy.com/‘a esit oldugunu test edin
    //      ○ titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin
    //      ○ logoTest => BestBuy logosunun görüntülendigini test edin
    //      ○ FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin


    @BeforeClass

    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        d.get("https://www.bestbuy.com/");

    }

    @AfterClass
    public static void tearDown(){
        d.close();
    }

    @Test

    public void test01(){
        //Sayfa URL’inin https://www.bestbuy.com/‘a esit oldugunu test edin
       String istenenUrl="https://www.bestbuy.com/";
       String actualUrl=d.getCurrentUrl();

        Assert.assertEquals(actualUrl,istenenUrl);

    }

    @Test

    public void test02(){
        //titleTest => Sayfa başlığının “Rest” içermediğini(contains) test edin

        String istenmeyenKelime="Rest";
        String sayfaBasligi=d.getTitle();

        Assert.assertFalse(sayfaBasligi.contains(istenmeyenKelime));
    }

    @Test

    public void test03(){
        //logoTest => BestBuy logosunun görüntülendigini test edin
        WebElement logoElementi=d.findElement(By.xpath("(//img[@class='logo'])[1]"));

        Assert.assertTrue(logoElementi.isDisplayed());

    }
    @Test

    public void test04(){
        // FrancaisLinkTest => Fransizca Linkin görüntülendiğini test edin
        WebElement francaisElementi=d.findElement(By.xpath("//*[text()='Français']"));

        Assert.assertTrue(francaisElementi.isDisplayed());

    }

}
