package day_11Faker_File;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class C03_FileExist {
    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));
        //icinde oldugum path yolunu verir

        System.out.println(System.getProperty("user.home"));
        //bilgisayarimin bana ozel kismini verir
        //"C:\Users\fylmz\Downloads"
        //"C:\Users\fylmz\OneDrive\Masaüstü\Nouveau Document texte.txt"
        //masa ustumuzdeki text dosyasinin varligini test edelim
        String dosyaYolu=System.getProperty("user.home")+("\\Desktop\\Nouveau Document texte");
        System.out.println(dosyaYolu);
        /*bilgisayarimizdaki bir dosyanin varligini test etmemiz icin once o dosyaya ulasmmaiz lazim java da dosyaya erisim icin path adresine
        ihtiyac vardir.her bilgisayarin kullanici adi farkli olacagindan masa ustu dosya yolu da farkli olacaktir.
        testlerimizin tum bilgisayarlarda calismasi icin dosya yolunu dinamik yapmak zorundayiz
        bunu icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin System.getproperty("user.home")bu herkeste farklidir
        herkesin bilgisayarinda ayni olan ise \desktop\text.text
        DOSYA YOLU=farkli kisim+ortakKisim
        */
        String ortakKisim="\\Desktop\\Nouveau Document texte";
        String farkliKisim=System.getProperty("user.home");
        String masaUstu=farkliKisim+ortakKisim;
        System.out.println(Files.exists(Paths.get(masaUstu)));
        Assert.assertFalse(Files.exists(Paths.get(masaUstu)));
    }
}
