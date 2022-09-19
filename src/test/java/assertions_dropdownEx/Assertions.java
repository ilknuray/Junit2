package assertions_dropdownEx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Assertions {
    /*
    ) Bir class oluşturun: YoutubeAssertions
2) https://www.youtube.com adresine gidin
3) Aşağıdaki adları kullanarak 3 test metodu oluşturun ve gerekli testleri yapin
○ titleTest
○ imageTest
=> Sayfa başlığının “YouTube” oldugunu test edin
=> YouTube resminin görüntülendiğini (isDisplayed()) test edin
○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
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
        // driver.close();
    }

    @Test
    public void test01() {
        //https://www.youtube.com adresine gidin
        driver.get("https://www.youtube.com");
        driver.findElement(By.xpath("(//*[@class='style-scope ytd-button-renderer style-primary size-default'])[3]")).click();
        //Sayfa başlığının “YouTube” oldugunu test edin
        //=> YouTube resminin görüntülendiğini (isDisplayed()) test edin

        String actualTitle = driver.getTitle();
        String expectedTitle = "YouTube";

        Assert.assertEquals(expectedTitle, actualTitle);

        WebElement logo= driver.findElement(By.xpath("//*[@id='logo-icon']"));
        Assert.assertTrue(logo.isDisplayed());

        // Search Box 'in erisilebilir oldugunu test edin (isEnabled())
        WebElement searchBox= driver.findElement(By.xpath("//input[@id='search']"));
        Assert.assertTrue(searchBox.isEnabled());

        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin

        String expectedTitle2="youtube";

        Assert.assertFalse(expectedTitle2.equals(actualTitle));


    }

}
