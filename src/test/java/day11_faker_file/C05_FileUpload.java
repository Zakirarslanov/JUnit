package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {
    @Test
    public void test01() {
        //Tests packagenin altina bir class oluşturun : C05_UploadFile
        //https://the-internet.herokuapp.com/upload adresine gidelim
        d.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim
        WebElement chooseFileButtonuWE=d.findElement(By.id("file-upload"));
        String dosyaYolu="C:\\Users\\zakir\\Downloads\\LambdaTest.txt";

        chooseFileButtonuWE.sendKeys(dosyaYolu);
        d.findElement(By.id("file-submit")).click();

        WebElement sonucYazisi=d.findElement(By.xpath("//*[text()='File Uploaded!']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());




    }
}
