package com.pages;

import com.core.HepsiBuradaLibrary;
import com.data.BaseData;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import sun.applet.Main;

public class MainPage extends HepsiBuradaLibrary {

    public MainPage() {
    }


    public MainPage(RemoteWebDriver driver) {
        super(driver);
    }


    public MainPage openUrl() {
        navigateTo(BaseData.url);
        return this;
    }


    By navigationBar = By.cssSelector("div[class*='navigationBar'] ");


    public MainPage menuSec(String menu,String altMenu){
        WebElement baseMenu = menuKontrol(navigationBar,menu);
        moveToElement(baseMenu);

        WebElement childMenu = altMenuKontrol(baseMenu,altMenu);
        childMenu.click();
        return this;
    }


}
