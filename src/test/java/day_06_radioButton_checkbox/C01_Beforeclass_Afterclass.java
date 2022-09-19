package day_06_radioButton_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Beforeclass_Afterclass {
   static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @AfterClass
   public static void tearDown() {
        driver.close();
    }
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
    }
    @Test
    public void test1(){
        driver.get("https://www.hepsiburad" +
                ".com");
    }
}
