package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_Actions extends TestBase {

    @Test
    public void test01(){
        // amazon anasayfa'ya gidip
        // account menusunden create a list linkine tiklayalim
        d.get("https://www.amazon.com");
        Actions action=new Actions(d);
        WebElement accountLink=d.findElement(By.xpath("//*[text()='Account & Lists']"));

        //action.moveToElement(accountLink).perform();
        d.findElement(By.xpath("//*[text()='Create a List']")).click();


    }
}





























