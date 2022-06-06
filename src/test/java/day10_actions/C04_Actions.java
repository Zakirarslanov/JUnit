package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions extends TestBase {
    //Yeni bir class olusturalim: MouseActions2
    //1- https://demoqa.com/droppable adresine gidelim

    @Test
    public void test01() {
        d.get("https://demoqa.com/droppable");

        //2- “Drag me” butonunu tutup “Drop here” kutusunun ustune birakalim
        Actions actions = new Actions(d);
        WebElement drugMe = d.findElement(By.xpath("//div[@id='draggable']"));
        WebElement DropHere = d.findElement(By.xpath("(//div[@id='droppable'])[1]"));
        actions.dragAndDrop(drugMe,DropHere).perform();

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
        WebElement sonucyazi=d.findElement(By.xpath("//*[text()='Dropped!']"));
        String expcy="Dropped!";
        String actualyazi=sonucyazi.getText();
        Assert.assertEquals(expcy,actualyazi);


    }
}
