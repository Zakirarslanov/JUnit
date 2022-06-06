package day06_radioButton_checkBox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {

    WebDriver d;

    //1. Bir class oluşturun : RadioButtonTest
    //2. Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.


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
    //https://www.facebook.com adresine gidin
    //Cookies’i kabul edin
    @Test
    public void test01() throws InterruptedException {
        d.get("https://www.facebook.com");

        //Cookies’i kabul edin
        d.findElement(By.xpath("//*[text()='Allow essential and optional cookies']")).click();

        //“Create an Account” button’una basin
        d.findElement(By.xpath("//*[text()='Create new account']")).click();

        //“radio buttons” elementlerini locate edin

        WebElement femaleButton=d.findElement(By.xpath("//input[@value='1']"));
        WebElement maleButton=d.findElement(By.xpath("//input[@value='2']"));
        WebElement customButton=d.findElement(By.xpath("//input[@value='-1']"));

        //Secili degilse cinsiyet butonundan size uygun olani secin
        Thread.sleep(3000);

        if (!maleButton.isSelected()){
            maleButton.click();
        };
        Thread.sleep(3000);

        if (!femaleButton.isSelected()){
            femaleButton.click();
        };

        Thread.sleep(3000);






    }





}
