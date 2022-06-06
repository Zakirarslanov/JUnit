package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
    // Bir Class olusturalim YanlisEmailTesti
    //http://automationpractice.com/index.php sayfasina gidelim
    //Sign in butonuna basalim
    //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
    //“Invalid email address” uyarisi ciktigini test edelim

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
        //http://automationpractice.com/index.php sayfasina gidelim
        d.get("http://automationpractice.com/index.php");

        //Sign in butonuna basalim
        WebElement signInButton=d.findElement(By.xpath("//a[@class='login']"));
        signInButton.click();

        //Email kutusuna @isareti olmayan bir mail yazip enter’a bastigimizda
        //“Invalid email address” uyarisi ciktigini test edelim
        WebElement emailSignIn=d.findElement(By.xpath("//input[@id='email']"));
        emailSignIn.sendKeys("zakir"+ Keys.ENTER);

        WebElement uyariYazisi=d.findElement(By.xpath("//*[text()='Invalid email address.']"));

        Assert.assertTrue(uyariYazisi.isDisplayed());







    }



}
