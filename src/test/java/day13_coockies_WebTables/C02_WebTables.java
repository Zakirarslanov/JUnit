package day13_coockies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {
    @Test
    public void webTable() {
        //● login( ) metodun oluşturun ve oturum açın.
        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        //          ○ Username : manager
        //          ○ Password : Manager1!
        login();

        //● table( ) metodu oluşturun
        //          ○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement> sutunBaslikleri=d.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("Sutun Sayisi : "+sutunBaslikleri.size());

        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        // Tum body'i bir String olarak yazdirmak isterseniz
        // body webElementini locate edip, getText() method'u ile yazdirabilirsiniz
        WebElement tumBody=d.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());

        // printRows( ) metodu oluşturun //tr
        // table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarList=d.findElements(By.xpath("//tbody//tr"));
        System.out.println("Satir sayisi : "+satirlarList.size());


        // Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        List<WebElement>tableSatirlar=d.findElements(By.xpath("//table//tr"));
        for (WebElement each:satirlarList
             ) {
            System.out.println(each.getText());

        }

        // 4.satirdaki(row) elementleri konsolda yazdırın.
        List<WebElement> cellist=d.findElements(By.xpath("//tbody//td"));
        for (WebElement a:cellist
             ) {
            System.out.println("55 : "+a.getText());

        }
        WebElement w= d.findElement(By.xpath("//tbody//td[4]"));
        System.out.println(w.getText());


        // Email basligindaki tum elementleri(sutun) konsolda yazdırın.
        // once email basliginin kacinci sutunda oldugunu bulalim
        List<WebElement> EmailSutunList=d.findElements(By.xpath("//tbody//td[3]"));
        for (WebElement s:EmailSutunList
             ) {
            System.out.println(" : "+s.getText());

        }



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
