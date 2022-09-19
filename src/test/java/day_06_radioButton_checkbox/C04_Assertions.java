package day_06_radioButton_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
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
      /*  //url in https://www.youtube.com oldugunu test edin
        if (driver.getCurrentUrl().equals(" https://www.youtube.com")){
            System.out.println("test passed");
        }else{
            System.out.println("failed");
        }*/
        /*
        eger testleri if else ile yaparsak test bittiginde ekrani alt kisminda test passed yazacaktir
        Junit bunu degistiriyor
         */
        String expectedUrl= "https://www.youtube.com";
        String actualUrl=driver.getCurrentUrl();
        Assert.assertEquals("test passed",expectedUrl,actualUrl);

    }
}
