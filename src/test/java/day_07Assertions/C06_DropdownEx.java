package day_07Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C06_DropdownEx {
    /*
    https://the-internet.herokuapp.com/dropdown adresine gidin
    1)index kullanarak option 1 i yazdirin
    2)value ile 2yi
    3)visible ile 3 u
    4)tum dropdown valuleri yazdirin
    5)dropdown boyutunu bulun dropdown da 4 oge varsa true degilse false yazdirin
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
        driver.get("https://the-internet.herokuapp.com/dropdown");
        WebElement dropDown= driver.findElement(By.xpath("//select[@id='dropdown']"));
        Select select=new Select(dropDown);

        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        List<WebElement>tumOpsiyonlar=select.getOptions();
        for (WebElement each:tumOpsiyonlar
             ) {
            System.out.println(each.getText());

        }
        int dropDownBoyut=tumOpsiyonlar.size();

        if(dropDownBoyut==4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}
