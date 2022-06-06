package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C06_KeyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        // facebook anasayfaya gidip
        d.get("https://www.facebook.com");
        //String WHD=d.getWindowHandle();

        // yeni kayit olustur butonuna basin

       d.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
      // d.switchTo().window(WHD);
       d.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // isim kutusunu locate edip,
        WebElement isimKutusuWE=d.findElement(By.xpath("//input[@name='firstname']"));

        // geriye kalan alanlari TAB ile dolasarak
        // formu doldurun

        Actions a=new Actions(d);
        a.click(isimKutusuWE).perform();
        a.sendKeys("Zakir")
                .sendKeys(Keys.TAB)
                .sendKeys("Ustaoglu")
                .sendKeys(Keys.TAB)
                .sendKeys("ghfdf@gmail.com").perform();

        Thread.sleep(5000);







    }

}
