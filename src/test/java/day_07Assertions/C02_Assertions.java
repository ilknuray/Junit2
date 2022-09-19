package day_07Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Assertions {
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");

    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
    @Test
    public void test01(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl=driver.getCurrentUrl();

        Assert.assertEquals(expectedUrl,actualUrl);
    }

    @Test
    public void test02(){
        String expectedTitle="Rest";
        String actualTitle=driver.getTitle();

        Assert.assertFalse(actualTitle.contains(expectedTitle));

    }
    @Test
    public void test03(){
        WebElement logo= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logo.isDisplayed());
    }
    @Test
    public void test04(){
        WebElement francais= driver.findElement(By.xpath("//button[@class='is-active']"));
        Assert.assertTrue(francais.isDisplayed());
    }

}
