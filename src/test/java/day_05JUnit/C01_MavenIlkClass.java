package day_05JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_MavenIlkClass {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get("http://zero.webappsecurity.com");
        //sign in butonunu tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        //username yazdirin
        WebElement userName= driver.findElement(By.xpath("//input[@id='user_login']"));
        userName.sendKeys("username");
        //pasword yazdirin
        WebElement password= driver.findElement(By.xpath("//input[@id='user_password']"));
        password.sendKeys("password");
        //sign in butonuna tikla
        driver.findElement(By.xpath("//input[@name='submit']")).click();
        driver.navigate().back();
        //online benkinge tikla
        driver.findElement(By.xpath("(//*[text()='Online Banking'])[1]")).click();
        //paybille tikla
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        //amount a para yatirin
        driver.findElement(By.xpath("//input[@id='sp_amount']")).sendKeys("500");
        //tarih kismina yazi yazin
        driver.findElement(By.xpath("//input[@id='sp_date']")).sendKeys("2020-09-10");
        //pay butonuna tiklayin
        driver.findElement(By.xpath("//input[@id='pay_saved_payees']")).click();
        //
      WebElement sonucYazisi=  driver.findElement(By.xpath("//*[@id='alert_content']"));
      if ((sonucYazisi.isDisplayed())){
          System.out.println("Gorunurluk yazisi test PASSED");
      }else{
          System.out.println("test FAILED");
      }
      driver.close();


    }
}
