package day_07Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C05_DropdownOptions {
    /*
    amazon anasayfasindan dropdown menu den booksu secelim sectigimiz option u yazdiralim
    dropdown daki optionlarin toplam sayisinin 23 oldugunu gosterin
     */
    WebDriver driver;
    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
        WebElement dropdownBox= driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select=new Select(dropdownBox);
        select.selectByVisibleText("Books");

        //dropdown daki son elemente ulasmak icin bu method kullanilir
        System.out.println(select.getFirstSelectedOption().getText());

        //dropdown daki elementlerin toplam sayisinin 28 oldugunu test edin
        List<WebElement>optionsList=select.getOptions();

        int actualOptionsSayisi=optionsList.size();
        int expectedOptionSayisi=28;

        Assert.assertEquals(expectedOptionSayisi,actualOptionsSayisi);


    }
}
