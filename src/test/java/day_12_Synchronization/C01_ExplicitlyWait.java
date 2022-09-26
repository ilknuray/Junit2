package day_12_Synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitlyWait extends TestBase {
    @Test
    public void test() {

        //https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //remove tusuna basin
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        //it s gone gorunuyormu
        WebElement text = driver.findElement(By.xpath("//*[@id='message']"));
        Assert.assertTrue(text.isDisplayed());
        //add butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //it's back mesajinin gorundugunu test edin
        WebElement text2 = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(text2.isDisplayed());

    }

    @Test
    public void test02() {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //remove tusuna basin
        driver.findElement(By.xpath("//button[text()='Remove']")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        // WebElement text= driver.findElement(By.xpath("//*[@id='message']"));
        WebElement text = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='message']")));
        Assert.assertTrue(text.isDisplayed());
        /*
        yazinin gorunur olmasini beklerken yazinin locateni beklemek sorun olur
        henuz gorunmyn bir yazinin locate edilmesi de mumkun olmayabilir.
        (html kodlari yazan dev farkli uygulamakar yapabilir)bu yuzden locate ve bekleme isini birlikte yapmaliyiz
         */
        //add butonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        //it's back mesajinin gorundugunu test edin
        WebElement text2=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));
        Assert.assertTrue(text2.isDisplayed());
    }
}
