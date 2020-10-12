package com.pages;

import com.shared.log;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;

public class LoginPage extends MainPage {


    String testName = "";
    String browserName = "";

    public LoginPage(RemoteWebDriver driver, String test, String browser) {
        super(driver);
        browserName = browser;
        testName = test;
    }


    By inpEmail = By.id("txtUserName");
    By inpSifre = By.id("txtPassword");
    By btnGirisYap = By.id("btnLogin");



    public LoginPage girisYapPageAlanKontrolleri(){
        controlElement(inpEmail, "Giriş yap sayfasın E-posta alan kontrolü başarılı");
        controlElement(inpSifre, "Giriş yap sayfasın Şifre alan kontrolü başarılı");
        controlElement(inpEmail, "Giriş yap sayfasın Giriş yap buton alan kontrolü başarılı");
        return this;
    }


    public LoginPage emailDoldur(String email) {
        sendKeys(inpEmail, email);
        log.info(browserName + " " + testName + " Login ekranın Email : " + email + " olarak doldurulur");
        return this;
    }

    public LoginPage sifreDoldur(String sifre) {
        sendKeys(inpSifre, sifre);
        log.info(browserName + " " + testName + " Login ekranın Sifre  : " + sifre + " olarak doldurulur");
        return this;
    }

    public LoginPage girisYapBtn() {
        click(btnGirisYap);
        log.info(browserName + " " + testName + " Login ekranın giriş yap butonu tıklanır");
        return this;
    }


}
