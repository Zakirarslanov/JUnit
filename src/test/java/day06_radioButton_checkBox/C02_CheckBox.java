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

public class C02_CheckBox {
    WebDriver d;

    // 1. Bir class oluşturun : CheckBoxTest
    //2.Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.

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


    //a. Verilen web sayfasına gidin.
    //https://the-internet.herokuapp.com/checkboxes

    @Test
    public void test01(){
        d.get("https://the-internet.herokuapp.com/checkboxes");
           //b. Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement chekbox01=d.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement chekbox02=d.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        //c. Checkbox1 seçili değilse onay kutusunu tıklayın
        if (!chekbox01.isSelected()){
            chekbox01.click();
        }
        //d. Checkbox2 seçili değilse onay kutusunu tıklayın
        if (!chekbox02.isSelected()){
            chekbox02.click();
        }


    }








}
