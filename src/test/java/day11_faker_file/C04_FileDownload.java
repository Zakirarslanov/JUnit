package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {
    @Test
    public void test01() throws InterruptedException {

    //1. Tests packagenin altina bir class oluşturalim
    //2. https://the-internet.herokuapp.com/download adresine gidelim.
    d.get("https://the-internet.herokuapp.com/download");

    //3. LambdaTest.txt dosyasını indirelim
        WebElement lambdatext=d.findElement(By.xpath("//*[text()='LambdaTest.txt']"));
        lambdatext.click();
        Thread.sleep(5000);

    //4. dosyanın başarıyla indirilip indirilmediğini test edelim

       // String farkliKisim=System.getProperty("user.home");
      //  String ortakKisim="\\Download\\LambdaTest.txt";
        String dosyaYolu="C:\\Users\\zakir\\Downloads\\LambdaTest.txt";

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //String dosyaYolu="C:\\Users\\zakir\\Downloads";


    //5. dosya downloads'a indirilecektir, bize downloads'un dosya yolu lazim





    // 6. geriye o dosya yolundaki dosyanin var oldugunu assert edelim
    }
}
