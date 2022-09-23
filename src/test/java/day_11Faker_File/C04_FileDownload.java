package day_11Faker_File;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test
    public void test() throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/download");
        WebElement link= driver.findElement(By.xpath("//a[text()='test.txt']"));
        link.click();
        Thread.sleep(5000);
        //DOSYA downloada iner bize downloads in path i lazim
        String farkliKisim=System.getProperty("user.home");
        String ortakKisim="\\Télechargements\\test.txt";
        //geriye o dosyanin varligini asert edelim
        String dosyaYolu=farkliKisim+ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }
}
