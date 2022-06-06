package day13_coockies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Webtables extends TestBase {

    // onceki class'daki adrese gidip
    // girisYap method'unu kullanarak sayafaya giris yapin
    // input olarak verilen satir sayisi ve sutun sayisi'na sahip
    // cell'deki text'i yazdirin

    @Test
    public void test01() {


    int satir = 3;
    int sutun = 3;

    login();
        WebElement arananCell=
                d.findElement(By.xpath("//tbody//tr["+satir+"]//td["+sutun+"]"));
        System.out.println(arananCell.getText());

}


    public void login() {
        d.get("https://www.hotelmycamp.com");
        d.findElement(By.linkText("Log in")).click();
        Actions actions = new Actions(d);
        WebElement username = d.findElement(By.id("UserName"));
        actions.click(username).
                sendKeys("manager").
                sendKeys(Keys.TAB).
                sendKeys("Manager1!").
                sendKeys(Keys.ENTER).
                perform();

    }
}
