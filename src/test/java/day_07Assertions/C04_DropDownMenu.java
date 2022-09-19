package day_07Assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C04_DropDownMenu {
    /*
    amazona gidip dropdown dan book secenegini secip java aratalim
    ve arama sonuclarini 500 den fazla oldugunu test edin
     */
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
        driver.quit();
    }

    @Test
    public void test01() {
        driver.get("https://www.amazon.com");
        WebElement dropDownBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        dropDownBox.click();

        //select objesi olusturuyoruz ve dropdown box i isaretleten webelement ismini parametre olarak giriyoruz
        Select select = new Select(dropDownBox);

        //secmek istedigimiz kutuyu 3farkli yolla belirleyebiliriz
        select.selectByVisibleText("Books");
        //select.selectByValue();
        // select.selectByIndex();

        //arma kutusuna istedigimiz kismi aratiyoruz
        WebElement aramaKutusu = driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("(//div[@class='a-section a-spacing-small a-spacing-top-small'])[1]"));
        String sonucYazisi = sonuc.getText();
        String arananKelime = "Java";
        Assert.assertTrue(sonucYazisi.contains(arananKelime));
    }
}
