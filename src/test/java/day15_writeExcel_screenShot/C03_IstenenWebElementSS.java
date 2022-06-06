package day15_writeExcel_screenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebElementSS extends TestBase {
    @Test
    public void webElementSS() throws IOException {
        // amazon'a gidip Nutella aratalim
        // ve sonuc sayisinin oldugu web elemntin fotografini cekelim
        d.get("https://www.amazon.com");
        WebElement aramaKutusu=d.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        WebElement sonucYazisi=d.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        File sonucYazisiSS=new File("target/ekranGoruntuleri/sonucYazisi.jpg");
        File tepm = sonucYazisi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(tepm,sonucYazisiSS);







    }
}
