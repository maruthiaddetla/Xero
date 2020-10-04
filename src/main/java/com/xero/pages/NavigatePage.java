package com.xero.pages;

import com.xero.utils.PageUtil;
import org.openqa.selenium.By;

public class NavigatePage {

    PageUtil pageUtil = new PageUtil();

    private static final By MENU_ACCOUNTING = By.xpath("//button[@name='navigation-menu/accounting']");
    private static final By MENU_BANKACCOUNTS = By.linkText("Bank accounts");

    /*
     * navigates to Bank accounts page
     */
    public void navigateToBankAccountsPage()
    {
        pageUtil.clickElement(MENU_ACCOUNTING);
        pageUtil.clickElement(MENU_BANKACCOUNTS);
    }
}
