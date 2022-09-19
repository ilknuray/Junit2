package pourTravaille;

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

public class LogOutUser {
    /*
   1. Launch browser
2. Navigate to url 'http://automationexercise.com'
3. Verify that home page is visible successfully
4. Click on 'Signup / Login' button
5. Verify 'Login to your account' is visible
6. Enter correct email address and password
7. Click 'login' button
8. Verify that 'Logged in as username' is visible
9. Click 'Logout' button
10. Verify that user is navigated to login page
     */
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
        //driver.close()
    }

    @Test
    public void test01() {

        //   1. Launch browser
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement home = driver.findElement(By.xpath("//*[text()=' Home']"));
        Assert.assertTrue(home.isDisplayed());
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[text()=' Signup / Login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement account = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(account.isDisplayed());
        //6. Enter correct email address and password
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys("ilknuray13181@gmail.com");
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("5314x1453");
        //7. Click 'login' button
        driver.findElement(By.xpath("//*[text()='Login']")).click();
        //8. Verify that 'Logged in as username' is visible
        //9. Click 'Logout' button
        //10. Verify that user is navigated to login page
    }
}
