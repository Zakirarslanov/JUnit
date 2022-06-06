package day09_handleWindows_testBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_windowHandles {

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

        // 1- https://the-internet.herokuapp.com/windows adresine gidin.
        d.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaWindowHandleDegeri=d.getWindowHandle();

        // 2- Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        WebElement textYazisi=d.findElement(By.xpath("//*[text()='Opening a new window']"));
        String expectedText="Opening a new window";
        Assert.assertTrue(textYazisi.getText().equals(expectedText));

        // 3- Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String expectedTittleText="The Internet";
        String actualTittleText=d.getTitle();
        Assert.assertEquals(expectedTittleText,actualTittleText);

        // 4- Click Here butonuna basın.
        d.findElement(By.linkText("Click Here")).click();

        // 5- Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        Set<String> windowHandleSet=d.getWindowHandles();
        System.out.println(windowHandleSet);

        String ikinciSayfaWindowHandleDegeri="";
        for (String each: windowHandleSet
             ) {
            if (!each.equals(ilkSayfaWindowHandleDegeri)){
                ikinciSayfaWindowHandleDegeri=each;
            }

        }
        d.switchTo().window(ikinciSayfaWindowHandleDegeri);
        String expectedIkinciTitle="New Window";
        String actual= d.getTitle();
        Assert.assertEquals(expectedIkinciTitle,actual);

        // 6- Bir önceki pencereye geri döndükten sonra sayfa başlığının
        // “The Internet” olduğunu doğrulayın.

        d.getWindowHandle();









    }
}



















