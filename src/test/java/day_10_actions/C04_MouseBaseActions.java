package day_10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_MouseBaseActions extends TestBase {

    @Test
    public void test(){
        driver.get("https://demoqa.com/droppable");
        WebElement drag= driver.findElement(By.xpath("//*[@id='draggable']"));
        WebElement drop=driver.findElement(By.xpath("//*[@id='droppable']"));
        Actions actions=new Actions(driver);
        actions.dragAndDrop(drag,drop).perform();
        WebElement dropped=driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String actualD=dropped.getText();
        String expectedD="Dropped!";
        Assert.assertEquals(expectedD,actualD);
    }
}
