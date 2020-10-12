package com.pages;

import com.shared.log;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class IndexPage extends MainPage {
    String testName = "";
    String browserName = "";

    public IndexPage(RemoteWebDriver driver, String test, String browser) {
        super(driver);
        browserName = browser;
        testName = test;
    }


    By homePage = By.cssSelector("[class=\"desktop widget Voltran\"]");
    By btnGirisYapNav = By.id("myAccount");
    By btnGirisYap = By.cssSelector("[class*='OldMyAccount'] a[id='login']");
    By inpAramaYap = By.cssSelector("[class='SearchBoxOld-root'] input[class='desktopOldAutosuggestTheme-input']");
    By btnAra = By.cssSelector("[class='SearchBoxOld-root'] [class=\"SearchBoxOld-buttonContainer\"]");



    public IndexPage anaSayfaEkranKontrol() {
        Assert.assertEquals(isElementExist(homePage), true);
        log.info(browserName + " " + testName + " Ana sayfa ekranının açıldığı logonun geldiği doğrulanır");
        return this;
    }


    public IndexPage girisYapNavKontrol() {
        Assert.assertEquals(isElementExist(btnGirisYapNav), true);
        log.info(browserName + " " + testName + " Ekranın sağ üstünde üyelik işlemleri giriş yap açılır menu bulunduğu doğrulanır");
        return this;
    }

    public IndexPage accountNav()  {
        moveToElement(btnGirisYapNav);
        log.info(browserName + " " + testName + " Ekranın sağ üstünde üyelik işlemleri açılır menu");
        return this;
    }

    public IndexPage girisYapBtn(){
        click(btnGirisYap);
        log.info(browserName + " " + testName + " Giriş yap butonu tıklanır");
        return this;
    }

    public IndexPage aramaDoldur(String arama) throws InterruptedException {
        waitForLoad();
        sendKeys(inpAramaYap,arama);
        log.info(browserName + " " + testName + " Arama alanında " + arama + " yazdırılır");
        return this;
    }

    public IndexPage btnAra(){
        clickJS(btnAra);
        log.info(browserName + " " + testName + " Ara butonu tıklanır");
        return this;
    }

    public IndexPage sepetim(){
        log.info(browserName + " " + testName + " Sepete Git butonu tıklanır");
        return this;
    }



}
