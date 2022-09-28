package day_15_writeExcelScreenshot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C04_JSExecutor extends TestBase {
    @Test
    public void JSExcecutorTest() {
        //amazon a gidelim

        driver.get("https://www.amazon.com");
        //en alttaki sign in butonunu gorunceye kadar js ile scrool yapalim
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        WebElement signinButonu = driver.findElement(By.xpath("//*[@class='action-inner']"));
        jse.executeScript("arguments[0].scrollIntoView(true);", signinButonu);
        //sign in e click
        jse.executeScript("arguments[0].click();", signinButonu);
    }
}
