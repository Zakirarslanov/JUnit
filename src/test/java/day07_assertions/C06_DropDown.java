package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropDown {
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
        // ● https://the-internet.herokuapp.com/dropdown adresine gidin.

        d.get("https://the-internet.herokuapp.com/dropdown");

        //  1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın

        WebElement ddE=d.findElement(By.xpath("//select[@id='dropdown']"));
        Select sel=new Select(ddE);
        sel.selectByIndex(1);
        System.out.println(sel.getFirstSelectedOption().getText());

        //  2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        sel.selectByValue("2");
        System.out.println(sel.getFirstSelectedOption().getText());


        //  3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        sel.selectByVisibleText("Option 1");
        System.out.println(sel.getFirstSelectedOption().getText());

        //  4.Tüm dropdown options'i yazdırın
        List<WebElement> tumOpsiyonlar=sel.getOptions();
        for (WebElement each: tumOpsiyonlar
             ) {
            System.out.println(each.getText()+", ");

        }


        //  5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True ,
        //  degilse False yazdırın.

        int ddEsayisi=sel.getOptions().size();

        if (ddEsayisi==4){
            System.out.println("True");
        }else{
            System.out.println("False");
        }

    }
}



