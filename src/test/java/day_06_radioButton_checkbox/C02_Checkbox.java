package day_06_radioButton_checkbox;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Checkbox {
    //https://theinternet.herokuapp.com/checkboxes
    //checkbox1 ve checkbox2 elementlerini locate edin
    //checkbox1 secili degilse secin
    //checkbox2secili degilse secin
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }

    @After
    public void tearDown() {

        driver.close();
    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement box1 = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement box2 = driver.findElement(By.xpath("(//input[@type=\"checkbox\"])[2]"));

        if (!box1.isSelected()) {
            box1.click();

        }if (!box2.isSelected()){
            box2.click();
        }


    }
}