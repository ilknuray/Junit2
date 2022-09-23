package day_10_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_actions extends TestBase {
    @Test
    public void test01(){
        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //account menusunden create a liste tiklayalim

        Actions actions=new Actions(driver);
        WebElement accountBox= driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        actions.moveToElement(accountBox).perform();
        driver.findElement(By.xpath("//*[text()='Create a List']")).click();

    }
}
