package day_13_cookies_webtable;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C01_Cookies extends TestBase {
    @Test
    public void test() {
        driver.get("https://www.amazon.com");
        //tum cookieleri listeleyin
        //sayfadaki ccokie sayisiin 5ten buyuk oldugunu test edin
        Set<Cookie> allCookies = driver.manage().getCookies();
        System.out.println(allCookies);
        int sayac = 1;
        for (Cookie w : allCookies) {
            System.out.println(sayac + ".cookie" + w);
            System.out.println("name :" + w.getName());
            System.out.println("value :" + w.getValue());
            sayac++;


        }
        int cookieSyisi = allCookies.size();
        Assert.assertTrue(cookieSyisi > 5);

        //4ismi i18n-prefs olan cookie degerinin USD oldugunu test edin
        for (Cookie w : allCookies) {
            if (w.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", w.getValue());
            }

        }
        //5- ismi “en sevdigim cookie” ve degeri “cikolatali” olan bir cookie
        Cookie cookie = new Cookie("ensevdigim cookie", "cikolatali");
        allCookies.add(cookie);
        System.out.println("eklendikten sonra :" + allCookies);

        //6 eklediginiz cookie’nin sayfaya eklendigini test edin
        Assert.assertTrue(allCookies.contains(cookie));
        //7 ismi skin olan cookie’yi silin ve silindigini test edin
        driver.manage().deleteCookieNamed("skin");
        //8 tum cookie’leri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        allCookies = driver.manage().getCookies();
        Assert.assertTrue(allCookies.isEmpty());

    }
}
