package com.xero.utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class PageUtil extends init {

    private static RemoteWebDriver driver;

    public static RemoteWebDriver getDriver() {
        if (driver == null) {
            initiateDriver();
        }
        return driver;
    }

    public static void initiateDriver() {
        String browserName = propMap.get("browser_name");
        //Code for all browsers need to be added
        switch (browserName.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
                driver = new ChromeDriver();
                break;
            case "safari":
                driver = new SafariDriver();
                break;
        }
        //maximize browser
        getDriver().manage().window().maximize();
        //set implicit wait
        getDriver().manage().timeouts().implicitlyWait(Long.parseLong(propMap.get("implicit_wait_time_seconds").trim()), TimeUnit.SECONDS);
        getDriver().manage().timeouts().pageLoadTimeout(Long.parseLong(propMap.get("implicit_wait_time_seconds").trim()), TimeUnit.SECONDS);
    }

    public void navigateToUrl(String url) {
        getDriver().get(propMap.get(url));
    }

    private void highlightElement(By locator) {
        WebElement element = driver.findElement(locator);
        for (int i = 0; i < 1; i++) {
            JavascriptExecutor js = driver;
            js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,
                    "border:3px solid red;");
            js.executeScript("arguments[0].setAttribute('style',arguments[1]);", element,
                    "border:3px solid none;");

        }
    }

    public boolean isElementPresent(By locator) {
        if (locator == null) {
            throw new NullPointerException("locator is null");
        } else {
            WebDriverWait wait = new WebDriverWait(driver, 5L);
            ExpectedCondition<WebElement> expected = ExpectedConditions.visibilityOfElementLocated(locator);
            wait.ignoring(StaleElementReferenceException.class, ElementNotVisibleException.class);
            WebElement webElement;
            try {
                webElement = wait.until(expected);
                if (webElement != null) {
                    highlightElement(locator);
                    return true;
                }
            } catch (ElementNotVisibleException ex) {
                return false;
            }
        }
        return false;
    }

    public void clickElement(By locator){
        if(isElementPresent(locator)){
            driver.findElement(locator).click();
        }else{
            throw  new NoSuchElementException(locator+" not found.");
        }
    }

    public void enterText(By locator, String text){
        if(isElementPresent(locator)){
            driver.findElement(locator).sendKeys(text);
        }else{
            throw  new NoSuchElementException(locator+" not found.");
        }
    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public void closeBrowser(){
        getDriver().quit();
        driver = null;
    }

    public boolean isElementTextPresentInList(By locator,String text) {
        List<WebElement> items = driver.findElements(locator);
        for (WebElement item : items) {
            if (item.getText().contains(text)) {
                return true;
            }
        }
        return false;
    }
}
