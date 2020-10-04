package com.xero.pages;

import com.xero.utils.PageUtil;
import org.testng.Assert;

public class DashboardPage {

    PageUtil pageUtil = new PageUtil();

    /*
     * Verifies title of the page
     */
    public void isDashboardPageDisplayed(){
        Assert.assertTrue(pageUtil.getPageTitle().contains("Dashboard"),"Dashboard page is displayed");
    }
}
