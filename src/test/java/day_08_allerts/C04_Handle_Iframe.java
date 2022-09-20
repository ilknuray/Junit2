package day_08_allerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Handle_Iframe {
   static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/iframe");
    }
    @AfterClass
    public static void tearDown(){
        //driver.close();
    }



    @Test
    public void anIframe(){
        WebElement iframe= driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframe.isEnabled());
        System.out.println(iframe.getText());
        WebElement iframeLocate= driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iframeLocate);

        WebElement textBox= driver.findElement(By.xpath("//*[@id='tinymce']"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dunya"+ Keys.ENTER);


        driver.switchTo().defaultContent();
        WebElement sonucYazisi= driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(sonucYazisi.isDisplayed());
        System.out.println(sonucYazisi.getText());

    }

}
