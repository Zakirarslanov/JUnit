package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public abstract class TestBase {
    protected WebDriver d;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        d=new ChromeDriver();
        d.manage().window().maximize();
      //  d.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

    }
    @After
    public void tearDown() throws InterruptedException {
        //Thread.sleep(3000);
        //d.close();
    }


}
