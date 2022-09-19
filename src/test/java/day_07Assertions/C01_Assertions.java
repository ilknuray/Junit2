package day_07Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    //amazon anasayfaya gidin
    //3 farkli test methodu olusturarark asagidaki gorevleri yapin
    //1)url amazon iceriyormu
    //2)title in facebook icermedigini test edin
    //3)amazon logosunun gorunurlugunu test edin

  static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){

        String expectedUrl="amazon";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(expectedUrl));
    }
    @Test
    public void test02(){
        String istenmeyenTitle="facebook";
        String title= driver.getTitle();

        Assert.assertFalse(title.contains(istenmeyenTitle));
    }
    @Test
    public void test03(){
        WebElement logo= driver.findElement(By.xpath("//*[@id='nav-logo-sprites']"));
        Assert.assertTrue(logo.isDisplayed());
    }


}
