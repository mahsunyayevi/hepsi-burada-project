package com.pages;

import com.shared.log;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.List;

public class UrunDetay extends MainPage{

    String testName = "";
    String browserName = "";

    public UrunDetay(RemoteWebDriver driver, String test, String browser) {
        super(driver);
        browserName = browser;
        testName = test;
    }



    By tblDigerSaticilar = By.cssSelector("[class=\"marketplace-list\"]");
    By btnSepeteDevamEt = By.cssSelector("[id='pcwrapper'] a[class*='deny-text']");
    By btnSepeteEkleDigerSatici = By.cssSelector("[class='addToCart'] [class*='add-to-basket']");
    By btnSepeteEkle = By.cssSelector("[class=\"addToCartButton\"] button[id=\"addToCart\"]");
    By btnPopupSepeteGit = By.cssSelector("[class*='SalesFrontCashProductInfo'][kind=\"primary\"]");
    By imgKargoZamani = By.cssSelector("[class*='SalesFrontCashProductInfo'][kind=\"primary\"]");


    public UrunDetay sepeteEkleDigerSatici(String satici) throws InterruptedException {
        waitForLoad();
        log.info(browserName + " " + testName + " Aynı üründen bulunduran  satici kontrol edilir");
        WebElement element  = digerSaticiKontrol(tblDigerSaticilar,satici);
        Assert.assertEquals(element.getText().contains(satici),true);
        log.info(browserName + " " + testName + " Aynı üründen bulunduran  satici kontrolü başarılı");
        if (element.getText().contains(satici)){
            element.findElement(btnSepeteEkleDigerSatici).click();
            log.info(browserName + " " + testName + " Ürün " + satici +" adlı saticidan  sepete eklendi.");
        }
        return this;
    }


    public UrunDetay popupSepeteDevamEt(){
        clickJS(btnSepeteDevamEt);
        log.info(browserName + " " + testName + "Diğer satıcı alanından sepete ekle butonu tıklandıktan sonra açılan popup Sepete devam et butonu tıklanır");
        return this;
    }


    public ArrayList<String> digerSaticilariGetir() throws InterruptedException {
        waitForLoad();
        int rowCount = 0;
        List<WebElement> allRows = findElements(By.cssSelector("[class='marketplace-list'] tr"));
        rowCount = allRows.size();
        ArrayList<String> saticilar = new ArrayList<String>();
        for (int i = 0; i < rowCount; i++){
            String saticiAdi = allRows.get(i).findElement(By.cssSelector("[class=\"merchant-info\"]")).getText();
            saticilar.add(saticiAdi);
            log.info(browserName + " " + testName + "Aynı Üründem bulunduran Satıcı :  " + saticiAdi );
        }
        return saticilar;
    }


    public UrunDetay sepeteEkle(){
        clickJS(btnSepeteEkle);
        log.info(browserName + " " + testName + " Detay Sayfasındaki ürün sepete eklendi");
        return this;
    }


    public UrunDetay popupSepeteGit(){
        clickJS(btnPopupSepeteGit);
        log.info(browserName + " " + testName + " Sepete Ekle butonuna basıldıktan sonra açılan popup'da Sepeti git butonu tıklanır");
        return this;
    }

    public UrunDetay kargoZamani24saatKontrol(){
        controlElement(imgKargoZamani,browserName + " " + testName + " Ürün 24 saatte kargoya verilebileciği seçeneği geldiği kontrolü başarılı");
        return this;
    }



}
