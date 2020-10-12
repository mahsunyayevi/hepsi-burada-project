package com.core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.List;

public class HepsiBuradaLibrary extends BaseLibrary {

    public HepsiBuradaLibrary(RemoteWebDriver driver) {
        super(driver);
    }

    public HepsiBuradaLibrary() {
    }

    protected WebElement urunKontrol(String columnInput){
        int rowCount = 0;
        WebElement table = findElement(By.cssSelector("ul[class*='product-list']"));
        List<WebElement> allRows = findElements(By.cssSelector("li[class*='search-item']"));
        rowCount = allRows.size();
        if (rowCount == 0)
            return null;
        WebElement elem = null;
        for (WebElement row : allRows) {
            try {
                elem = row;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (elem.findElement(By.cssSelector("[class='product-detail'] p")).getText().contains(columnInput)) {
                return row;
            }
        }
        return null;
    }


    protected WebElement digerSaticiKontrol(By by, String columnInput)  {
        int rowCount = 0;
        WebElement table = findElement(by).findElement(By.tagName("tbody"));
        List<WebElement> allRows = table.findElements(By.tagName("tr"));
        rowCount = allRows.size();
        if (rowCount == 0)
            return null;
        WebElement elem = null;
        for (WebElement row : allRows) {
            try {
                elem = row;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (elem.getText().contains(columnInput)) {
                return row;
            }
        }
        return null;
    }

    protected WebElement menuKontrol(By by, String columnInput)  {
        int rowCount = 0;
        WebElement table = findElement(by).findElement(By.cssSelector("ul[class*='MenuItems-1']"));
        List<WebElement> allRows = table.findElements(By.cssSelector("li[class*='MenuItems-1'] "));
        rowCount = allRows.size();
        if (rowCount == 0)
            return null;
        WebElement elem = null;
        for (WebElement row : allRows) {
            try {
                elem = row;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (elem.getText().contains(columnInput)) {
                return row;
            }
        }
        return null;
    }

    protected WebElement altMenuKontrol(WebElement element, String columnInput)  {
        int rowCount = 0;
        List<WebElement> allRows = element.findElements(By.cssSelector("ul[class*='ChildMenuItems'] a"));
        rowCount = allRows.size();
        if (rowCount == 0)
            return null;
        WebElement elem = null;
        for (WebElement row : allRows) {
            try {
                elem = row;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (elem.getText().contains(columnInput)) {
                return row;
            }
        }
        return null;
    }



    protected WebElement sepetimUrunKontrol(By by,String columnInput){
        int rowCount = 0;
        WebElement table = findElement(by).findElement(By.cssSelector("ul[class*='basket_item_list']"));
        List<WebElement> allRows = table.findElements(By.cssSelector("li[class*='basket_item'] "));
        rowCount = allRows.size();
        if (rowCount == 0)
            return null;
        WebElement elem = null;
        for (WebElement row : allRows) {
            try {
                elem = row;
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (elem.getText().contains(columnInput)) {
                return row;
            }
        }
        return null;
    }



}
