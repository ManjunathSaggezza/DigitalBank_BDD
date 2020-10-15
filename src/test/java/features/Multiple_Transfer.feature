@Transfer
Feature: Transfer funds to different account with Greater than available balance, Zero funds and to Same Account

@Test4
Scenario: Check the different transfer types
	Given I am on Transfer page
	And I select the FROM and TO Account from drop down
			|		FROM		|		TO		|
			|		Test		|	Aravin		|
	And enter the transfer money and click on submit button
			|Transfer Money |
			| 	1000000		|
	Then verify the error message(The amount <Transfer money> requested for transfer is more than the available balance <Balance amount>)

@Test6
Scenario: Check the user is able to transfer 0 funds to another account
	Given I am on Transfer page3
	And I select the FROM and TO Account from drop down
			|		FROM		|		TO		|
			|		Test		|	Aravin		|
	And enter the transfer money as zero and click on submit button
			|Transfer Money |
			| 	0			|
	Then verify the error message(Please match the format requested)

@Test7
Scenario: Check the user is able to transfer funds to same FROM and TO account
	Given I am on Transfer page4
	And I select the FROM and TO Account as same from drop down
			|		FROM		|		TO		|
			|		Aravin		|	Aravin		|
	And enter the transfer money for same account and click on submit button
			|Transfer Money |
			| 	100		|
	Then verify the error message(Can not transfer from and to the same account).