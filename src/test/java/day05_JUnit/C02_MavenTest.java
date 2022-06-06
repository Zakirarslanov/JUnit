package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver a= new ChromeDriver();
        a.manage().window().maximize();
        a.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. http://zero.webappsecurity.com sayfasina gidin
        a.get("http://zero.webappsecurity.com");


      //2. Signin buttonuna tiklayın

        a.findElement(By.xpath("//button[@id='signin_button']")).click();

        //3. Login alanine  “username” yazdirin
        a.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");

        //4. Password alanine “password” yazdirin
        a.findElement(By.xpath("//input[@id='user_password']")).sendKeys("password");

        //5. Sign in buttonuna tiklayin
         a.findElement(By.xpath("//input[@name='submit']")).click();
        //(hata mesaji icin back tusuna tiklayin)
         a.navigate().back();

        //6. Online Banking menusunden Pay Bills sayfasina gidin
        a.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        a.findElement(By.xpath("//span[@id='pay_bills_link']")).click();

        //7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        a.findElement(By.xpath("//input[@name='amount']")).sendKeys("500");

        //8. tarih kismina “2020-09-10” yazdirin
        a.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        //9. Pay buttonuna tiklayin
        a.findElement(By.id("pay_saved_payees")).click();

        //10. “The payment was successfully submitted.” mesajinin ciktigini kontrol edin
        WebElement sonucYazisiElementi= a.findElement(By.xpath("//div[@id='alert_content']"));

        if (sonucYazisiElementi.isDisplayed()){
            System.out.println("test PASSED");
        }else{
            System.out.println("test FAİLED");
        }
        Thread.sleep(2000);
        a.close();






        /*driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");

        driver.findElement(By.id("pay_saved_payees")).click();
        //10. “The payment was successfully submitted.” mesajinin ciktigini kontrol edin
        WebElement sonucYazisiElementi= driver.findElement(By.xpath("//div[@id='alert_content']"));
        if (sonucYazisiElementi.isDisplayed()){
            System.out.println("test PASSED");
        } else {
            System.out.println("test FAILED");
        }
        driver.close();*/





















    }
}
