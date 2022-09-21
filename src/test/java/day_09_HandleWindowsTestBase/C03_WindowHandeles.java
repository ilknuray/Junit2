package day_09_HandleWindowsTestBase;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Set;

public class C03_WindowHandeles {
    /*
    https://the-internet.herokuapp.com/windows adresine gidin
    sayfadaki textin "Opening a new window" oldugunu dogrulayin
    sayfa titlenin "The Internet" oldugunu dogrulayin
    click here butonuna basin
    acilan yeni pencerenin basliginin "New Window" oldugunu dogrulayin
    bir onceki pencereye geri dondukten sonra sayfa basliginin "The Internet" oldugunu dogrulayin
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
        //driver.quit();
    }
    @Test
    public void test(){
        //https://the-internet.herokuapp.com/windows adresine gidin
        driver.get("https://the-internet.herokuapp.com/windows");
        //    sayfadaki textin "Opening a new window" oldugunu dogrulayin
        WebElement text= driver.findElement(By.xpath("//h3"));
        String expectedText="Opening a new window";
        String actual=text.getText();
        Assert.assertEquals(expectedText,actual);

        //    sayfa titlenin "The Internet" oldugunu dogrulayin
        String actualTitle= driver.getTitle();
        String expectedTitle="The Internet";
        Assert.assertTrue(actualTitle.contains(expectedTitle));
        String ilkSayfaHandle=driver.getWindowHandle();
        Set<String>handleDegerleri=driver.getWindowHandles();
        System.out.println(handleDegerleri);
        String ikincisayfaWindowHandle="";
        for (String each:handleDegerleri
             ) {
            if (!each.equals(ilkSayfaHandle)){
               ikincisayfaWindowHandle=each;
            }

        }


        //    click here butonuna basin
        driver.findElement(By.xpath("//*[text()='Click Here']")).click();

        //    acilan yeni pencerenin basliginin "New Window" oldugunu dogrulayin
       WebElement newWindow= driver.findElement(By.xpath("//h3"));
        driver.switchTo().window(ikincisayfaWindowHandle);
        String expectedNewTitle="New Window";
        String actualNewTitle=newWindow.getText();
      //  Assert.assertEquals(expectedNewTitle,actualNewTitle);
        //    bir onceki pencereye geri dondukten sonra sayfa basliginin "The Internet" oldugunu dogrulayin
        driver.switchTo().window(ilkSayfaHandle);
        String expectedEskiSayfaBaslik="The Internet";
        String actualEskiTitle=driver.getTitle();

        Assert.assertEquals(expectedEskiSayfaBaslik,actualEskiTitle);


        /*
        switch to new window demeden link tiklayarak yeni tab veya window olustugunda yeni sayfaya gec demedikce driver eski sayfada kalir
        ve yeni sayfa ile ilgili hic bir islem yapamaz yeni sayfada driveri calistirmak isterseniz once driveri yeni sayfaya yollamalisiniz yeni sayfaya gecebilmek ocin
        oncelikle ikinci sayfanin window handle degerini bulmamaiz gerekir.bunun icin driver.getWindowHandle degerlerini alip bir set e assign ederiz ilk sayfanin
        handle degerini biliyoruz.
        set teki windowx handle degerlerini kontrol edip ilk sayfanin kine esit olmayan ikinci sayfanin handle degeridir deriz.artik ikinci sayfanin windowHandle degerini
        bildigimiz icin sayfalar arasi gecis yapabiliriz

         */


    }
}
