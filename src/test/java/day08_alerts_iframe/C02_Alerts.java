package day08_alerts_iframe;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Alerts {
    //  https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    //  Bir metod olusturun: acceptAlert
    //  1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
    //  “You successfully clicked an alert” oldugunu test edin.
    //  Bir metod olusturun: dismissAlert
    //  2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //  “successfuly” icermedigini test edin.
    //  Bir metod olusturun: sendKeysAlert
    //  3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //  OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.

    static WebDriver d;
    @BeforeClass
    public static void setUp(){

        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        d.get("https://the-internet.herokuapp.com/javascript_alerts");

    }
    @AfterClass
    public static void tearDown(){
       d.close();
    }

    @Test

    public void acceptAlert(){
        //  1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının
        //  “You successfully clicked an alert” oldugunu test edin.
        d.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        d.switchTo().alert().accept();
        WebElement sonucyazisi=d.findElement(By.xpath("//*[text()='You successfully clicked an alert']"));
        String expectedResult="You successfully clicked an alert";
        Assert.assertEquals(expectedResult,sonucyazisi.getText());

    }
    //  Bir metod olusturun: dismissAlert
    //  2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının
    //  “successfuly” icermedigini test edin.
    @Test
    public void dismissAlert(){
        d.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();
        d.switchTo().alert().dismiss();
        String notexcepted="successfuly";
        WebElement sonucyazisi=d.findElement(By.xpath("//p[@id='result']"));
        String actualRsult=sonucyazisi.getText();
        Assert.assertFalse(actualRsult.contains(notexcepted));

    }
    //  Bir metod olusturun: sendKeysAlert
    //  3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin,
    //  OK butonuna tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
    @Test
    public void sendKeysAlert(){
        d.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();
        d.switchTo().alert().sendKeys("Zakir");
        d.switchTo().alert().accept();

        WebElement sonucyazisi=d.findElement(By.xpath("//p[@id='result']"));
        String sonucyazisitext=sonucyazisi.getText();
        String expected ="Zakir";
        Assert.assertTrue(sonucyazisitext.contains(expected));



    }






}
