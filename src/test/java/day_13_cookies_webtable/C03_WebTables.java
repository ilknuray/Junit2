package day_13_cookies_webtable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C03_WebTables extends TestBase {
    @Test
    public void test() {

        //login yapin
        //input olarak verilen satir ve sutun sayisina sahip cell deki text i yazdirin

        int satir=3;
        int sutun=5;



        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager");
        //○ Password : Manager1!
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        WebElement arananCell= driver.findElement(By.xpath("//tbody//tr//["+satir+"//td"+sutun+"]"));
        System.out.println(arananCell.getText());

    }
}
