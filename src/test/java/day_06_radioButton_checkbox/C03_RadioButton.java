package day_06_radioButton_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
    //https://www.facebook.com
    //cookiesi kabul et
    // create an account a bas
    //radio button elementlerini locate et
    //cinsiyet secili degilse sec

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
        driver.close();
    }

    @Test
    public void test() throws InterruptedException {
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//button[@data-cookiebanner='accept_button']")).click();
        driver.findElement(By.xpath("//*[text()='Créer nouveau compte']")).click();
        // driver.findElement(By.xpath("//*[@id='u_0_0_4W']")).click();
        WebElement female = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement male = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement custom = driver.findElement(By.xpath("//input[@value='-1']"));
        if (!female.isSelected()) {
            female.click();
            Thread.sleep(3000);
        }
    }
}
