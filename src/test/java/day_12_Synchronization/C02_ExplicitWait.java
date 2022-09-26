package day_12_Synchronization;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C02_ExplicitWait extends TestBase {
    @Test
    public void test() {
        //https://the-internet.herokuapp.com/dynamic_controls
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //textbox enable mi
        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        Assert.assertFalse(textBox.isEnabled());
        //enable butonuna tiklayinve textbox etkin olucaya kadar bekle
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        driver.findElement(By.xpath("//button[text()='Enable']")).click();
        WebElement enable = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@type='text']")));
        //it's enabled msjini goruntule
        WebElement box = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assert.assertTrue(box.isDisplayed());
        //textbox etkinmi?
        Assert.assertTrue(textBox.isEnabled());

    }
}
