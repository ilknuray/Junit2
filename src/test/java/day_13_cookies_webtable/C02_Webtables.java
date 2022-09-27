package day_13_cookies_webtable;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C02_Webtables extends TestBase {
    @Test
    public void test() {

        //● https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        driver.get("https://www.hotelmycamp.com/admin/HotelRoomAdmin");
        //○ Username : manager
        driver.findElement(By.xpath("//input[@id='UserName']")).sendKeys("manager");
        //○ Password : Manager1!
        driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("Manager1!");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();

        //○ Tüm table body’sinin boyutunu(sutun sayisi) bulun. /tbody
        List<WebElement>sutunBasliklari= driver.findElements(By.xpath("//button[text()='Log in']"));
        System.out.println(sutunBasliklari.size());
        //○ Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody= driver.findElement(By.xpath("//tbody"));
        System.out.println(tumBody.getText());
        //tum body i strind olarak yazdirmak isterseniz body webelementini locate edip gettext methodu ile yazdirabilirsiniz

        //○ table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement>satirlarListesi=driver.findElements(By.xpath("//tbody//tr//td[2]"));
        System.out.println(satirlarListesi.size());

        //○ Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement w:satirlarListesi) {
            System.out.println(w.getText());

        }
        //○ 4.satirdaki(row) elementleri konsolda yazdırın
        List<WebElement>asdfList=driver.findElements(By.xpath("//tbody//tr[4]//td"));
        for (WebElement w:asdfList
             ) {
            System.out.println(w.getText());

        }
        //location basligindaki tum elementleri bulup yazdirin
        List<WebElement>basliklar=driver.findElements(By.xpath("//thead//tr//th"));
        int location=0;
        for (int i = 0; i < basliklar.size(); i++) {
          if  (basliklar.get(i).getText().equals("Location")){
                location=i;
            }

        }
        List<WebElement>locationSutunListesi=driver.findElements(By.xpath("//tbody//td["+(location+1)+"]"));
        for (WebElement w:locationSutunListesi) {
            System.out.println(w.getText());

        }

    }
}
