Feature: Add bank account

Scenario: Verify user is able to add bank account successfully
	Given I launch xero application
	And I have logged into xero application
	And The dashboard screen is displayed
	And I navigate to Accounting page
	And I click on Add Bank Account button
	And I select "ANZ (NZ)" from dropdown
	And I enter account name as "Business Account"
	And I select account type
	And I enter account number as "015684265"
	When I click on Submit button
	Then I should see the account number "015684265" is listed




