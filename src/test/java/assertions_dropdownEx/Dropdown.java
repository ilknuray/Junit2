package assertions_dropdownEx;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class Dropdown {
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass
    public static void tearDown() {
        driver.close();
    }

    /*
    ● Bir class oluşturun: C3_DropDownAmazon
● https://www.amazon.com/ adresine gidin.
- Test 1
Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 45
oldugunu test edin
-Test 2
1. Kategori menusunden Books secenegini secin
2. Arama kutusuna Java yazin ve aratin
3. Bulunan sonuc sayisini yazdirin
4. Sonucun Java kelimesini icerdigini test edin
     */
    @Test
    public void Test01() {
        WebElement dropDownBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownBox);
        List<WebElement> kategori = select.getOptions();
        int actualOptSzyisi = kategori.size();
        int expectedOptSayisi = 45;
        Assert.assertEquals(expectedOptSayisi, actualOptSzyisi);


    }

    @Test
    public void Test02() {
        WebElement dropDownBox = driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        Select select = new Select(dropDownBox);

        select.selectByVisibleText("Books");

        driver.findElement(By.xpath("//input[@id='twotabsearchtextbox']")).sendKeys("Java" + Keys.ENTER);
        WebElement sonuc = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisisi=sonuc.getText();
        System.out.println(sonucYazisisi);

        String aranan="Java";
        Assert.assertTrue(sonucYazisisi.contains(aranan));

    }
}
