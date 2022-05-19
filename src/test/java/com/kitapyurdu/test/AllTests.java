package com.kitapyurdu.test;

import com.kitapyurdu.driver.BaseTest;
import com.kitapyurdu.page.Pages;
import org.junit.Test;

public class AllTests extends BaseTest {
    @Test
    public void loginTest(){
        Pages allTests = new Pages();
        allTests.login();
        allTests.search();
        allTests.scroll();
        allTests.favEkleme();
        allTests.homePage();
        allTests.puanaGitturkKlasikSec();
        allTests.filtreYuksekOylama();
        allTests.tumKitaplarHobi();
        allTests.randomProductSelect();
        allTests.listFav();
        allTests.favSilme();
        allTests.sepeteGit();
        allTests.urunArtir();
        allTests.satinAl();
        allTests.yeniAdres();
        allTests.kartileUrunAl();
        allTests.hataMesaji();




    }

}
