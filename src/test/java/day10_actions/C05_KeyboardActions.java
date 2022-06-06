package day10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_KeyboardActions extends TestBase {
    @Test
    public void test01() throws InterruptedException {
        d.get("https://www.amazon.com");
        WebElement aramaKutusu=d.findElement(By.id("twotabsearchtextbox"));
        Actions a=new Actions(d);
        a.click(aramaKutusu).perform();
        a.keyDown(Keys.SHIFT).perform();
        a.sendKeys("n").keyUp(Keys.SHIFT).sendKeys("u").sendKeys("t").sendKeys("e").sendKeys("l").sendKeys("l").sendKeys("a").sendKeys(Keys.ENTER).perform();

        Thread.sleep(5000);


    }

}
