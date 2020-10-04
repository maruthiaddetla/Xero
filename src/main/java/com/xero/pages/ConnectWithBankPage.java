package com.xero.pages;

import com.xero.utils.PageUtil;
import org.openqa.selenium.By;
import org.testng.Assert;

public class ConnectWithBankPage {

     PageUtil pageUtil = new PageUtil();
     private static final By ACCOUNTLIST = By.className("bankaccounts-account--number");

    /*
     * Verifies account details displayed on page
     * @param account is the account number to be verified
     */
     public void isAccountDisplayedOnList(String account){
      Assert.assertTrue(pageUtil.isElementTextPresentInList(ACCOUNTLIST,account));
      pageUtil.closeBrowser();
     }

}
