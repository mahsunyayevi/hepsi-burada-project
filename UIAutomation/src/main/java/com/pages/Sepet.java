package com.pages;

import com.shared.log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class Sepet extends MainPage {


    String testName = "";
    String browserName = "";

    public Sepet(RemoteWebDriver driver, String test, String browser) {
        super(driver);
        browserName = browser;
        testName = test;
    }


    By btnAlisverisiTamamla = By.id("continue_step_btn");
    By listSepetimUrunler = By.id("onboarding_item_list");


    public Sepet alisverisiTamamlaBtn() {
        clickJS(btnAlisverisiTamamla);
        log.info(browserName + " " + testName + " Sepet sayfasında Alışverişi Tamamla butonu tıklandı");
        return this;
    }


    public Sepet urunKontrol(String urun,String satici){
        WebElement element = sepetimUrunKontrol(listSepetimUrunler,urun);
        String sepetUrun = element.getText();
        if (sepetUrun.contains(urun)){
            Assert.assertEquals(sepetUrun.contains(urun),true);
            log.info(browserName + " " + testName + " Sepet ekranında ürün kontrolü başarılı");

            Assert.assertEquals(sepetUrun.contains(satici),true);
            log.info(browserName + " " + testName + " Sepet ekranında satici başarılı");
        }
        return this;
    }


}
