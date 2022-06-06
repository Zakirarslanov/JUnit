package day15_writeExcel_screenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JS_Executor extends TestBase {
    @Test
    public void JSExecutorTest() throws InterruptedException {
        // amazon'a gidelim
        d.get("https://www.amazon.com");

        // asagidaki sign in butonu gorununceye kadar js ile scrool yapalim

        JavascriptExecutor jse=(JavascriptExecutor) d;

         WebElement w=d.findElement(By.xpath("(//span[text()='Sign in'])[3]"));


       // jse.executeScript("arguments[0].scrollIntoView(true);",signInButonu);

       // jse.executeScript("arguments[0].click();",signInButonu);




    }
}
