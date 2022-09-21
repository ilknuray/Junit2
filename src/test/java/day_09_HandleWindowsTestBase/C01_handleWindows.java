package day_09_HandleWindowsTestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_handleWindows {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        //driver.close();
    }

    @Test
    public void test() {
        //amazon anasayfaya gidin
        driver.get("https://www.amazon.com");
        String ilkSayfaHandle=driver.getWindowHandle();

        //sonra nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);

        //ilk  urunun resmini farkli bir tab olarak acin
        WebElement ilkUrun= driver.findElement(By.xpath("//*[@class='s-image']"));
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella"+ Keys.ENTER);
        driver.findElement(By.xpath("//*[@class='s-image']")).click();
        /*
        bu komutu kullandigimizda driver yeni tab a gecer ancak yeni tab da gorevi gerceklestirmek icin
        adimlari bastan almamiz gerekir.
         */



        //yeni tabda acilan urunun fiyatini yazin
        WebElement urunTitle= driver.findElement(By.xpath("//span[@id='productTitle']"));
        System.out.println(urunTitle.getText());
        System.out.println(driver.getCurrentUrl());


        //bu kod acilan sayfanin unique hash kodudur.selenium sayfalar arasi geciste bu degeri kullanir.CDwindow-CA3FA6F4E6B273FB3392897DD714B4BD
        //eger sayfalar arasinda driverimizi gezdiriyorsak ve herhangi bir sayfadan suan icinde bulundugumuz sayfaa
        // gecmek istiyorsak driver.switchto.window(CDwindow-CA3FA6F4E6B273FB3392897DD714B4BD)seklinde yazarim.bunu yazarak  u sayfaya gecis saglariz.

        //ilk sayfaya gecip url i yazdiralim
        driver.switchTo().window(ilkSayfaHandle);
        System.out.println(driver.getCurrentUrl());
    }
}
