package day_08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_HandleAlertsClassWork {
   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/javascript_alerts");
    }
    @AfterClass
    public static void tearDown(){
       driver.close();
    }
    @Test
    public void acceptAlert(){
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();
        driver.switchTo().alert().accept();
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@id='result']"));
       String expectedResult="You successfully clicked an alert";
       String actualResult=sonucYazisi.getText();
       Assert.assertEquals(expectedResult,actualResult);

    }
    @Test
    public void dissmissAlert(){
        driver.findElement(By.xpath("//button[text()='Click for JS Confirm']")).click();
        driver.switchTo().alert().dismiss();
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@id='result']"));
        String expectedSonus="You clicked: Cancel";
        String actualSonus=sonucYazisi.getText();
        Assert.assertEquals(expectedSonus,actualSonus);

    }
    @Test
    public void sendKeysAlert(){
        driver.findElement(By.xpath("//button[text()='Click for JS Prompt']")).click();
        driver.switchTo().alert().sendKeys("ilknur");
        driver.switchTo().alert().accept();
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[@id='result']"));
        String sonuc=sonucYazisi.getText();
        String girilen="ilknur";
        Assert.assertTrue(sonuc.contains(girilen));

    }

}
