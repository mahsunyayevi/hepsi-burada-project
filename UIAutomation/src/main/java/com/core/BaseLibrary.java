package com.core;

import com.data.BaseData;
import com.runner.TestsRunner;
import com.shared.log;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class BaseLibrary {


    protected RemoteWebDriver driver;

    public <T> BaseLibrary(RemoteWebDriver driver) {
        this.driver = driver;
    }

    public BaseLibrary() {
    }


    public void navigateTo(String url) {
        try {
            driver.get(url);
            driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
            Wait(500);
        } catch (Exception e) {
            log.info("Error while getting app url : " + e);
            throw new RuntimeException(e);
        }
    }


    protected WebElement findElement(By by, int... index)  {
        WebElement element = null;
        try {
            if (index.length == 0)
                element = driver.findElement(by);
            else
                element = driver.findElements(by).get(index[0]);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(false);arguments[0].focus();",
                    element);
        } catch (Exception e) {
            log.error("Error while clicking webelement : " + e);
            throw new RuntimeException(e);
        }
        return element;
    }


    protected List<WebElement> findElements(By by)  {
        List<WebElement> webElements = null;
        try {
            webElements = driver.findElements(by);
        } catch (Exception e) {
            log.error("Error while listing webelements by css selector : " + e);
            log.info("Error while listing webelements by css selector : " + e);

            throw new RuntimeException(e);
        }
        return webElements;
    }


    protected void click(By by) {
        WebElement element;
        try {
            element = driver.findElement(by);
            element.click();
        } catch (Exception e) {
            log.info("Error while clicking webelement : " + e);

            throw new RuntimeException(e);
        }
    }

    protected void click(By by,int size) {
        WebElement element;
        try {
            element = driver.findElements(by).get(size);
            element.click();
        } catch (Exception e) {
            log.info("Error while clicking webelement : " + e);

            throw new RuntimeException(e);
        }
    }

    protected void clickJS(By by)  {
        WebElement element = findElement(by);
        JavascriptExecutor executor = driver;
        executor.executeScript("arguments[0].click();", element);
    }

    protected void clickJS(WebElement element)  {
        JavascriptExecutor executor = driver;
        executor.executeScript("arguments[0].click();", element);
    }



    protected void sendKeys(By by, String text) {
        WebElement element = null;
        try {
            element = findElement(by);
            element.sendKeys(text);
        } catch (Exception e) {
            log.error("Error while filling field : " + e);

            throw new RuntimeException(e);
        }
    }


    protected void sendKeys(By by, String text, boolean pressEnter)  {

        WebElement element = null;
        try {
            element = findElement(by);
                element.sendKeys(text);
                if (pressEnter) {
                    element.sendKeys(Keys.ENTER);
                }
        } catch (Exception e) {
            log.error("Error while filling field : " + e);
            throw new RuntimeException(e);
        }
    }


    protected void moveToElement(By by){
        Actions builder = new Actions(driver);
        WebElement element = findElement(by);
        builder.moveToElement(element).build().perform();
    }
    protected void moveToElement(WebElement element){
        Actions builder = new Actions(driver);
        builder.moveToElement(element).build().perform();
    }

    protected boolean isElementExist(By by) {
        return isElementExist(by, 15);
    }

    protected boolean isElementExist(By by, int timeSeconds) {

        driver.manage().timeouts().implicitlyWait(timeSeconds, TimeUnit.SECONDS);
        boolean isExist = driver.findElements(by).size() > 0;
        driver.manage().timeouts().implicitlyWait(BaseData.DEFAULT_WAIT, TimeUnit.SECONDS);

        return isExist;
    }


    public void Wait(int millisecond) throws InterruptedException {
        Thread.sleep(millisecond);
    }


    protected String getTextOfElement(By by, int... index) {
        String text = null;
        try {
            if (index.length == 0)
                text = driver.findElement(by).getText();
            else
                text = driver.findElements(by).get(index[0]).getText();
        } catch (Exception e) {

            throw new RuntimeException(e);
        }
        return text;
    }



    protected void controlElement(By by, String logMessage) {
        Assert.assertEquals(isElementExist(by), true);
        log.info(logMessage);
    }


    public void waitForLoad() throws InterruptedException {
        ExpectedCondition<Boolean> pageLoadCondition = new
                ExpectedCondition<Boolean>() {
                    public Boolean apply(WebDriver driver) {
                        return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
                    }
                };
        WebDriverWait wait = new WebDriverWait(TestsRunner.getDriver(), 30);
        Thread.sleep(1000);
        wait.until(pageLoadCondition);
    }

}
