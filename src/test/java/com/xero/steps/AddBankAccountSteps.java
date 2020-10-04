package com.xero.steps;

import com.xero.pages.*;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class AddBankAccountSteps {

    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();
    NavigatePage navigatePage = new NavigatePage();
    BankAccountsPage bankAccountsPage = new BankAccountsPage();
    ConnectWithBankPage connectWithBankPage = new ConnectWithBankPage();

    @Given("I launch xero application")
    public void iLaunchXeroApplication() {
        loginPage.LaunchXero("aut_url");
    }

    @And("I have logged into xero application")
    public void iHaveLoggedIntoXeroApplication() {
        loginPage.LoginToXero();
    }

    @And("The dashboard screen is displayed")
    public void theDashboardScreenIsDisplayed() {
        dashboardPage.isDashboardPageDisplayed();
    }

    @And("I navigate to Accounting page")
    public void iSelectMenuFromTab() {
        navigatePage.navigateToBankAccountsPage();
    }

    @And("I click on Add Bank Account button")
    public void iClickOnButton() {
        bankAccountsPage.clickOnAddBankAccountButton();
    }

    @And("I select {string} from dropdown")
    public void iSelectFromDropdown(String bankName) {
        bankAccountsPage.selectBankName(bankName);
    }

    @And("I select account type")
    public void iSelectAccountType() {
        bankAccountsPage.selectAccountType();
    }

    @Then("I should see the account number {string} is listed")
    public void iShouldSeeTheAccountIsEnabled(String accountNumber) {
        connectWithBankPage.isAccountDisplayedOnList(accountNumber);
    }

    @And("I enter account name as {string}")
    public void iEnterAccountNameAs(String accountName) {
        bankAccountsPage.enterAccountName(accountName);
    }

    @And("I enter account number as {string}")
    public void iEnterAccountNumberAs(String accountNumber) {
        bankAccountsPage.enterAccountNumber(accountNumber);
    }

    @And("I click on Add bank Account button")
    public void iClickOnAddBankAccountButton() {
        bankAccountsPage.clickOnAddBankAccountButton();
    }

    @When("I click on Submit button")
    public void iClickOnSubmitButton() {
        bankAccountsPage.clickOnSubmit();
    }
}
