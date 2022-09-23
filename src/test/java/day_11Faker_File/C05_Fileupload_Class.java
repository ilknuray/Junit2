package day_11Faker_File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_Fileupload_Class extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/upload");
        //choosefile butonuna basalim
        //1.adim choose file i locate edelim
        WebElement chooseFile= driver.findElement(By.xpath("//input[@id='file-upload']"));
        //2.adim yuklenecek dosyanin dosya yolunu olusturalim
        String f="\\Desktop\\Nouveau Document texte";
        String a=System.getProperty("user.home");
        String dosyaYolu=a+f;
        //3.adim sendKeys ile dosya yolunu secme butonuna yollayalim
        chooseFile.sendKeys(dosyaYolu);
        Thread.sleep(5000);



        //yuklemek istedigimiz dosyayi secelim
        /*
        bu islemi selenium ile yapamayiz.cunku web tabanli degil sendKeys imdadimiza yetisir.
        eger chooseFile abutonuna var olan bir dosyanin dosya yolunu bulup yollarsaniz
        secme islemi otomatik olarak gerceklesir
         */

        //upload butonuna basalim
        //file Uploaded! i gordugumuzu test edelim

    }
}
