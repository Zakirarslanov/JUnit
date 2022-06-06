package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C03_Actions extends TestBase {
    @Test
    public void test01(){

        // 1- Yeni bir class olusturalim: MouseActions1
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        d.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapalim
        Actions actions=new Actions(d);
        WebElement cizgilianalelementi=d.findElement(By.id("hot-spot"));
        actions.contextClick(cizgilianalelementi).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edelim.

        String expectedYazi= "You selected a context menu";
        String actualYazi=d.switchTo().alert().getText();
        Assert.assertEquals(expectedYazi,actualYazi);

        //5- Tamam diyerek alert’i kapatalim
            d.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
        String ilkSayfaWindowHandleDegeri=d.getWindowHandle();
         d.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

         Set<String> handleSeti=d.getWindowHandles();
         String ikinciwindowHandleDegeri="";
        for (String each: handleSeti
             ) {if (!each.equals(ilkSayfaWindowHandleDegeri)){
                 ikinciwindowHandleDegeri=each;
        }

            //7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
                 d.switchTo().window(ikinciwindowHandleDegeri);
            WebElement yazielementi=d.findElement(By.tagName("h1"));
            String expectedYazison="Elemental Selenium";
            String actualYazison=yazielementi.getText();
            Assert.assertEquals(expectedYazison,actualYazison);

        }






    }
}
