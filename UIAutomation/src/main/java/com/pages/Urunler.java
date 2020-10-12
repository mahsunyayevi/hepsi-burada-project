package com.pages;

import com.shared.log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class Urunler extends MainPage {

    String testName = "";
    String browserName = "";

    public Urunler(RemoteWebDriver driver, String test, String browser) {
        super(driver);
        browserName = browser;
        testName = test;
    }

    public Urunler urunKontrolVeSec(String urun) throws InterruptedException {
        waitForLoad();
        log.info(browserName + " " + testName + " Arama yapılan ürün kontrol edilir");
        WebElement element = urunKontrol(urun);
        log.info(browserName + " " + testName + " Ürünün listelendiği kontrolü başarılı");
        clickJS(element.findElement(By.cssSelector("[class=\"product-image-wrapper\"]")));
        log.info(browserName + " " + testName + " " + urun + " adlı aratılan ürün seçilir");
        return this;
    }


}
