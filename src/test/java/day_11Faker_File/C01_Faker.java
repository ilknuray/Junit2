package day_11Faker_File;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Faker extends TestBase {
    @Test
    public void test(){
        //face book anasayfatya git
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("(//button[@value='1'])[3]")).click();
        //yeni kayita bas
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //isim kutusunu locate et
        WebElement nameBox = driver.findElement(By.xpath("//input[@name='firstname']"));
        //nameBox.sendKeys("Ilknur"+ Keys.ENTER);

        //geri kalanlari tab ile doldur
        Actions actions = new Actions(driver);
        Faker faker=new Faker();
        String fakeMail=faker.internet().emailAddress();

        actions.click(nameBox).
                sendKeys(faker.name().firstName()).sendKeys(Keys.TAB).sendKeys(faker.name().lastName()).
                sendKeys(Keys.TAB).
                sendKeys("Ilknur").
                sendKeys(Keys.TAB).
                sendKeys("Ay").
                sendKeys(Keys.TAB).
                sendKeys("asdddf@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("asdddf@gmail.com").
                sendKeys(Keys.TAB).
                sendKeys("12345").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys("01").
                sendKeys(Keys.TAB).
                sendKeys("jan").
                sendKeys(Keys.TAB).
                sendKeys("1988").
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.TAB).
                sendKeys(Keys.ENTER).
                perform();

    }
}
