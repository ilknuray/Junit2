package day_15_writeExcelScreenshot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.*;
import utilities.TestBase;

import java.io.File;
import java.io.IOException;

public class C03_IstenenWebelementScreeshot extends TestBase {
    @Test
    public void webelementsScreenshot() throws IOException {
        //amazondan nutella arat sonuc sayisinin oldugu webelementin fotosunu cekelim
        driver.get("https://www.amazon.com");
        WebElement aramakutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramakutusu.sendKeys("Nutella" + Keys.ENTER);
        WebElement sonucYazisi = driver.findElement(By.xpath("//*[@class=\"a-section a-spacing-small a-spacing-top-small\"]"));


        File fileSS = new File("target/ekranGoruntuleri/sonucyazisiSS.jpeg");
        File temp=sonucYazisi.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(temp,fileSS);
    }
}
