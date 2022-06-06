package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
     /* amazon'a gidip
       dropdown'dan books secenegini secip
       Java aratalim
       ve arama sonuclarinin Java icerdigini test edelim
     */

    WebDriver d;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().window().maximize();
        d.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        d.close();
    }

    @Test

    public void test01() throws InterruptedException {

        // dropdown'dan bir option secmek icin 3 adim vardir
        // 1- dropdown'i locate edelim
        d.get("https://www.amazon.com");
        WebElement amazonDropDown=d.findElement(By.xpath("//select[@id='searchDropdownBox']"));


        // 2- bir Select objesi olusturup
        //    parametre olarak bir onceki adimda locate ettigimiz ddm'yu girelim
        Select select=new Select(amazonDropDown);

        // 3- Dropdown'da var olan option'lardan istedigimiz bir taneyi secelim

         select.selectByVisibleText("Books");
        //select.selectByIndex(5);
        //select.selectByValue("search-alias=stripbooks-intl-ship");

        Thread.sleep(3000);


        WebElement aramaKutusu=d.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);
        Thread.sleep(5000);


        WebElement sonucYazi=d.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));

        String sonuc=sonucYazi.getText();

        String arananKelime="Java";

        Assert.assertTrue(sonuc.contains(arananKelime));

    }







}
