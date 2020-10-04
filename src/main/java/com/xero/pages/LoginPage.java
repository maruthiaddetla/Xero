package com.xero.pages;

import com.xero.utils.PageUtil;
import com.xero.utils.init;
import org.openqa.selenium.By;
import org.testng.Assert;

public class LoginPage {

    PageUtil pageUtil = new PageUtil();

    private static final By BUTTON_LOGIN = By.linkText("Login");
    private static final By TEXT_EMAIL = By.id("xl-form-email");
    private static final By TEXT_PASSWORD = By.id("xl-form-password");
    private static final By BUTTON_SUBMIT = By.id("xl-form-submit");

    /*
    * Logins to xero application
     */
    public void LoginToXero()
    {
        pageUtil.clickElement(BUTTON_LOGIN);
        pageUtil.enterText(TEXT_EMAIL,init.propMap.get("userName"));
        pageUtil.enterText(TEXT_PASSWORD,init.propMap.get("password"));
        pageUtil.clickElement(BUTTON_SUBMIT);
        Assert.assertTrue(pageUtil.getPageTitle().contains("Dashboard"));
    }

    /*
    * Launches xero application
    * @param url is the url of the application
     */
    public void LaunchXero(String url){
        PageUtil.initiateDriver();
        pageUtil.navigateToUrl(url);
        Assert.assertTrue(pageUtil.isElementPresent(BUTTON_LOGIN));
    }

}
