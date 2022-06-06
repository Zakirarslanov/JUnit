package day13_coockies_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Map;
import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test01() {

        // 1- Amazon anasayfaya gidin
        d.get("https://www.amazon.com");

        //2- tum cookie’leri listeleyin
        Set<Cookie> cookiesSet=d.manage().getCookies();
        System.out.println(cookiesSet);
        int sayac=1;
        for (Cookie each: cookiesSet
             ) {
            System.out.println(sayac+ ".ci cookie: " + each);
            System.out.println("name :  "+each.getName());
            System.out.println("value : "+ each.getValue());
            sayac++;

        }


        //3- Sayfadaki cookies sayisinin 5’den buyuk oldugunu test edin
        int cookeSayac=cookiesSet.size();
        Assert.assertTrue(cookeSayac>5);

        //4- ismi i18n-prefs olan cookie degerinin USD oldugunu test edin

        for (Cookie each:cookiesSet
             ) {if (each.getName().equals("i18n-prefs")){
                Assert.assertEquals("USD",each.getValue());
        }

        }



        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan
        // bir cookie olusturun ve sayfaya ekleyin

        Cookie cookie=new Cookie("en sevdigim cookie","cikolatali");
        d.manage().addCookie(cookie);

        Set<Cookie> cookiesSet1=d.manage().getCookies();
        int sayac1=1;
        for (Cookie each: cookiesSet1
        ) {
            System.out.println(sayac1+ ".ci cookie: " + each.getName());

            sayac1++;

        }




        //6- eklediginiz cookie’nin sayfaya eklendigini test edin

        //7- ismi skin olan cookie’yi silin ve silindigini test edin




    }
}
