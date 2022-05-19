package com.kitapyurdu.page;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.methods.Methods;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;


import java.util.*;

public class Pages extends BaseTest {
    Methods methods;
    Logger logger = LogManager.getLogger(Pages.class);

    public Pages() {
        methods = new Methods();
    }

    public void scroll() {
        methods.waitBySeconds(5);
        methods.scrollWithAction(By.xpath("//div[@id='product-table']/div[7]"));
        methods.waitBySeconds(5);
    }


    public void login() {

        methods.click(By.xpath("//div[@class='menu-top-button login']"));
        methods.waitBySeconds(5);
        methods.click(By.cssSelector(".popupCloseIcon"));
        methods.sendKeys(By.id("login-email"), "kemalelmas03@gmail.com");
        methods.waitBySeconds(3);
        methods.sendKeys(By.xpath("//input[@id='login-password']"), "1q2w3e4r5t");
        methods.waitBySeconds(4);
        methods.click(By.cssSelector(".ky-btn.ky-btn-orange.w-100.ky-login-btn"));
        methods.waitBySeconds(20);
        logger.info("giris yapildi");
        methods.click(By.xpath("//h4[@class='common-sprite']"));
        Assert.assertTrue("element gorunmez", methods.isElementVisible(By.xpath("//*[@class='common-sprite']/b[text()='Kemal Elmas']")));
        methods.waitBySeconds(3);
    }

    public void search() {
        methods.click(By.id("search-input"));
        methods.sendKeys(By.id("search-input"), "Oyuncak");
        methods.click(By.cssSelector(".common-sprite.button-search"));
        methods.waitBySeconds(3);
        logger.info("Oyuncak aratildi");


    }

    public void homePage() {
        methods.click(By.xpath("//img[@src='https://img.kitapyurdu.com/v1/getImage/fn:11453388/wh:44a9b399f']"));
        methods.waitBySeconds(3);
    }

    public void puanaGitturkKlasikSec() {
        methods.click(By.xpath("//div[@class='lvl1catalog']"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//img[@title='Puan Kataloğundaki Türk Klasikleri']"));
        methods.waitBySeconds(3);

    }

    public void filtreYuksekOylama() {
        methods.selectByText(By.cssSelector(".sort>select"), "Yüksek Oylama");
        methods.waitBySeconds(3);


    }

    public void tumKitaplarHobi() {
        methods.click(By.xpath("//ul[@class='js-ajaxCt js-bookCt']/li[3]/span"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[@href='kategori/kitap-hobi/1_212.html']"));
        methods.waitBySeconds(3);
    }


    public void randomProductSelect() {
        Random random = new Random();
        int a = random.nextInt(6);
        while (true) {
            if (a != 0) break;
            a = random.nextInt(6);
        }

        methods.click(By.xpath("//ul[@class='product-grid jcarousel-skin-opencart']/li[" + a + "]"));
        methods.waitBySeconds(3);
        methods.click(By.id("button-cart"));
        methods.waitBySeconds(3);
    }


    public void listFav() {
        methods.click(By.cssSelector(".menu.top.my-list"));
        methods.waitBySeconds(3);
        methods.click(By.xpath("//a[@href='https://www.kitapyurdu.com/index.php?route=account/favorite&selected_tags=0']"));
        methods.waitBySeconds(3);
    }

    public void sepeteGit() {
        methods.click(By.xpath("//h4[@class='common-sprite']"));
        methods.waitBySeconds(3);
        methods.click(By.id("js-cart"));
        methods.waitBySeconds(3);
    }

    public void urunArtir() {
        driver.findElement(By.xpath("//input[@name='quantity']")).clear();
        methods.waitBySeconds(2);
        methods.sendKeys(By.xpath("//input[@name='quantity']"), "2");
        methods.waitBySeconds(2);
    }

    public void favEkleme() {
        for (int a = 7; a < 11; a++) {
            methods.scrollWithAction(By.xpath("//div[@class='product-list']/div[" + a + "]"));
            methods.waitBySeconds(3);
            methods.click(By.xpath("//div[@id='product-table']/div[" + a + "]/div[2]/div[3]/a[4]"));
            methods.waitBySeconds(3);
            Assert.assertFalse("favori eklenmedi", methods.isElementVisible(By.xpath("//div[@class='padding'][text()='Seçili etiketler için ürün bulunamadı!']")));
            methods.waitBySeconds(3);
        }

    }

    public void favSilme() {
        methods.click(By.xpath("//div[@class='product-list']/div[3]/div[2]/div[3]/a[3]"));
        methods.waitBySeconds(3);
    }

    public void satinAl() {
        methods.click(By.cssSelector(".button.red"));
        methods.waitBySeconds(3);
        methods.click(By.cssSelector("swal2-close"));
        methods.waitBySeconds(3);
    }

    public void yeniAdres() {
        methods.click(By.xpath("//a[@href='#tab-shipping-new-adress']"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-firstname-companyname"), "Kemal");
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("address-lastname-title"), "Elmas");
        methods.waitBySeconds(2);
        methods.click(By.id("address-zone-id"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//select[@name='zone_id']/option[@value='3366']"));
        methods.waitBySeconds(1);
        methods.click(By.id("county_id"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("//select[@name='county_id']/option[@value='607']"));
        methods.waitBySeconds(1);
        methods.click(By.xpath("district"));
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-address-text"), "Dogan Mh Seker Sk");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("address-mobile-telephone"), "5414144141");
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(3);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(3);


    }

    public void kartileUrunAl() {
        methods.sendKeys(By.id("credit-card-owner"), "Leonardo Da Vinci");
        methods.waitBySeconds(3);
        methods.sendKeys(By.id("credit_card_number_1"), "1111");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit_card_number_2"), "2222");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit_card_number_3"), "3333");
        methods.waitBySeconds(1);
        methods.sendKeys(By.id("credit_card_number_4"), "4444");
        methods.waitBySeconds(1);
        methods.click(By.id("credit-card-expire-date-month"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//select[@id='credit-card-expire-date-month']/*[3]"));
        methods.waitBySeconds(2);
        methods.click(By.id("credit-card-expire-date-year"));
        methods.waitBySeconds(2);
        methods.click(By.xpath("//select[@id='credit-card-expire-date-year']/*[4]"));
        methods.waitBySeconds(2);
        methods.sendKeys(By.id("credit-card-security-code"), "333");
        methods.waitBySeconds(2);
        methods.click(By.id("button-checkout-continue"));
        methods.waitBySeconds(3);
    }

    public void hataMesaji() {
        if (driver.findElement(By.xpath("//span[@class='error']")).isDisplayed()) {
            System.out.println("Kart numarası gecersiz.Kontrol ediniz!");
        }
    }


}
