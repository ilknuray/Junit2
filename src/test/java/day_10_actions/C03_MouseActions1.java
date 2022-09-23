package day_10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.List;

public class C03_MouseActions1 extends TestBase {

    @Test
    public void test01() {
        driver.get("https://the-internet.herokuapp.com/context_menu");
        Actions actions = new Actions(driver);
        WebElement cizgiliYer = driver.findElement(By.xpath("//*[@id='hot-spot']"));
        actions.contextClick(cizgiliYer).perform();
        String expectedyazi = "You selected a context menu";
        String actualYazi = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedyazi, actualYazi);

        driver.switchTo().alert().accept();
        String ilkSayfaHandle = driver.getWindowHandle();
        WebElement elemental = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        elemental.click();

        List<String>handles=new ArrayList<String>(driver.getWindowHandles());
        System.out.println(handles);
        driver.switchTo().window(handles.get(1));
        WebElement h1tagi= driver.findElement(By.tagName("h1"));
        String expectedTag="Elemental Selenium";
        String actualTag=h1tagi.getText();
        Assert.assertEquals(expectedTag,actualTag);


    }

}
