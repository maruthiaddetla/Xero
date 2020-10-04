package com.xero.pages;

import com.xero.utils.PageUtil;
import org.openqa.selenium.By;

public class BankAccountsPage extends PageUtil{

    PageUtil pageUtil = new PageUtil();

    private static final By BUTTON_ADDBANKACCOUNT = By.xpath("//span[text()='Add Bank Account']");
    private static final By TEXT_ACCOUNTNAME = By.id("accountname-1037-inputEl");
    private static final By DROPDOWN_ACCOUNTTYPE = By.id("accounttype-1039-inputEl");
    private static final By TEXT_ACCOUNTTYPE = By.xpath("//li[text()='Everyday (day-to-day)']");
    private static final By TEXT_ACCOUNTNUMBER = By.id("accountnumber-1068-inputEl");
    private static final By BUTTON_SUBMIT = By.id("common-button-submit-1015-btnEl");

    /*
     * Clicks on Add Bank Account button
     */
    public void clickOnAddBankAccountButton(){
        pageUtil.clickElement(BUTTON_ADDBANKACCOUNT);
    }

    /*
     * Selects bank name from drop down
     * @param bankName is the name of the bank to select
     */
    public void selectBankName(String bankName){
        pageUtil.clickElement(By.xpath("//li[text()='"+bankName+"']"));
    }

    /*
     * Enters name of the account
     * @param accountName is the name of the bank account
     */
    public void enterAccountName(String accountName){
        pageUtil.enterText(TEXT_ACCOUNTNAME,accountName);
    }

    /*
     * Selects bank account type from drop down
     */
    public void selectAccountType(){
        pageUtil.clickElement(DROPDOWN_ACCOUNTTYPE);
        pageUtil.clickElement(TEXT_ACCOUNTTYPE);
    }

    /*
     * Enters bank account number
     * @param accountNumber is the bank account number
     */
    public void enterAccountNumber(String accountNumber){
        pageUtil.enterText(TEXT_ACCOUNTNUMBER,accountNumber);
    }

    /*
     * Clicks on submit button
     */
    public void clickOnSubmit(){
        pageUtil.clickElement(BUTTON_SUBMIT);
    }

}
