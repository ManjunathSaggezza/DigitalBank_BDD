@Login
Feature: Digital Bank Transfer Details
@Test1
Scenario: Login to Digital Bank and navigate to Transfers Page
	Given user is on DigitalBank home page
	When user enters credentials to Login
			| 			Username				 | Password |
			|aravinthan.srinivasan@saggezza.com  | Test@123 |
	Then user should be navigated to home page
	And I click on Transfer link in that Between account
	And I should be navigated to Transfer page																	

@Test2
Scenario: Transfer funds to a different account.
	Given I am on Transfer page
	And I select the FROM and TO Account from drop down
			|		FROM		|		TO		|
			|		Test		|	Aravin		|
	And enter the transfer money and click on submit button
			|Transfer Money |
			| 		20		|
	Then Money should be transferred successfully with Transaction details.

@Test3
Scenario: Without Transferring the funds click on Reset button.
	Given I am on Transfer page2
	And I select the FROM and TO Account from drop down
			|		FROM		|		TO		|
			|		Test		|	Aravin		|
	And enter the transfer money and click on Reset button
			|Transfer Money |
			| 		20		|
	Then From Account, To account and Transfer Amount filed should be Reset to default values.