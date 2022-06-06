package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {

    @Test
    public void test01() {

        System.out.println(System.getProperty("user.dir"));

        System.out.println(System.getProperty("user.home"));

        //C:\Users\zakir
        //C:\Users\zakir\OneDrive\Desktop
        String dosyaYolu=System.getProperty("user.home")+"\\Desktop\\text.txt";
        System.out.println(dosyaYolu);

        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Desktop\\text.txt";
        String masaustuDosyaYolu="C:\\Users\\zakir\\OneDrive\\Desktop";

       // System.out.println(Files.exists(Paths.get(masaustuDosyaYol
        Assert.assertTrue(Files.exists(Paths.get(masaustuDosyaYolu)));

    }
}
