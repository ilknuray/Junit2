package day_07Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Assertions {
  static   WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("http://automationpractice.com/index.php");
    }
    @AfterClass
    public static void tearDown(){
       // driver.close();
    }
    @Test
    public void test1(){
        //sign in butonuna bas
        driver.findElement(By.xpath("//*[@class='login']")).click();

        //email kutusuna @isareti olmayn bir mail yazip entera bastigimizda invalid uyarisi ciktigini test edelim
        WebElement mailKutusu= driver.findElement(By.xpath("//input[@id='email_create']"));
        mailKutusu.sendKeys("ilknurgmail.com"+Keys.ENTER);
        WebElement hataYazisi= driver.findElement(By.xpath("//*[@id='create_account_error']"));
        Assert.assertFalse(hataYazisi.isDisplayed());

    }
}
