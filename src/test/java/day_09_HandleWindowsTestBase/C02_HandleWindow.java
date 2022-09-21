package day_09_HandleWindowsTestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleWindow {
    /*
    amazona gidelim
    url amazon iceriyormi
    yeni pencere acalim
    bestbuy anasayfaya gidelim
    title in BestBuy icerdigini test edelim
    ilk sayfaya donup sayfada java aratalim
    arama sonuclarinin java icerdigini test edelim
    yeniden bestbuyin acik oldugu sayfaya gelip logonun gorundugunu test edelim
     */
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
        driver.quit();
    }

    @Test
    public void test() {
        //  amazona gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaHandle = driver.getWindowHandle();

        //    url amazon iceriyormi
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "amazon";
        Assert.assertTrue(actualUrl.contains(expectedUrl));

        //    yeni pencere acalim
        driver.switchTo().newWindow(WindowType.WINDOW);

        //    bestbuy anasayfaya gidelim
        driver.get("https://www.bestbuy.com");
        String ikinciSayfaHandle = driver.getWindowHandle();

        //    title in BestBuy icerdigini test edelim
        String actualTitle = driver.getTitle();
        String expectedTitle = "Best Buy";
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //    ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaHandle);
        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);


        //    arama sonuclarinin java icerdigini test edelim
        WebElement sonucYaziElementi = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr = sonucYaziElementi.getText();
        String aranan = "Java";
        Assert.assertTrue(sonucYazisiStr.contains(aranan));
        //    yeniden bestbuyin acik oldugu sayfaya gelip logonun gorundugunu test edelim
        driver.switchTo().window(ikinciSayfaHandle);

    }
}
