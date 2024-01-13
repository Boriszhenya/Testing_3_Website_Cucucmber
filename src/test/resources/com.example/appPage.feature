Feature: A test of the banking system

  @positive
  Scenario: Test_1 - check if there is an entry in the alert list
    Given user is on the maim page
    When the user will go to the Alert page
    And will go to the Alert history tab
    Then then the list will contain an entry with a specific date

  @positive
  Scenario: Test_2 - check if there is an entry in the alert list
    Given user is on the maim page
    When user will go to the Accounts Overview page
    And will go to the Special Offers & Deals tab
    Then  it have text  "Because you're a valued customer, we've selected some special offers just for you."

  @positive
  Scenario: Test_3 - Check if there is a transaction in the list with a balance amount of $3,556.39
    Given user is on the maim page
    When user will go to the Accounts Overview page
    And will go to the Customized Cash Rewards Visa Signature
    And Go to the Accounts tab
    Then  Check if there is a transaction with a balance amount of "$3,556.39" in the list.

  @positive
  Scenario: Test_4 - Check that there are 8 records in the table
    Given user is on the maim page
    When user will go to the Accounts Overview page
    And will go to the Customized Cash Rewards Visa Signature
    And will Go to the Statements & Documents tab
    Then  Check that there are 8 records in the table

  @positive
  Scenario: Test_5 - Check that "Primary email" contains "Robin.Smith@bankofamerica.com".
    Given user is on the maim page
    When user will go to the Accounts Overview page
    And will go to the Update Profile
    Then  Check that Primary email contains "Robin.Smith@bankofamerica.com".

  @positive
  Scenario: Test_6 - Checking who the money came from in the "Send Money" window
    Given user is on the maim page
    When user will go to the Go to Accounts Overview page
    And user will go to the Pay Transfer page
    When Click on the Zelle button
    And In the window Send Money make a transfer
    Then  Check  that in the new window there should be the inscription "    Adv Plus Banking 2322.56".

  @positive
  Scenario: Test_7 - Check if "Ready to use" appears on the "Rewards & Deals" page.
    Given user is on the maim page
    When user will go to the Go to Accounts Overview page
    And user will go to the Rewards & Deals page
    And Click on the plus sign on the Bayside block
    Then  Check  if the inscription "Ready to use" has appeared

  @positive
  Scenario: Test_8 - Check if "Ready to use" appears on the "Rewards & Deals" page
    Given user is on the maim page
    When user will go to the Transfers page
    And user will go to the Between my accounts at Bank of America
    When user will Make a transfer in the amount of "1000"
    And Click on the Transfer
    Then  Check the text: "Your transfer is confirmed." has appeared

  @positive
  Scenario: Test_9 - Check whether the electricity bill has appeared in the "Activity" block
    Given user is on the maim page
    When user will go to the Go to Accounts Overview page
    And user will go to the Pay Transfer page
    Then  Check whether the electricity bill has appeared in the Activity block

  @positive
  Scenario: Test_10 - Check the "Security Center" tab
    Given user is on the maim page
    When user will go to the Go to Accounts Overview page
    And user will go to the Pay Security Center tab
    Then  Check if there is text in the box "Strengthen your Password now to help maximize defense against hackers."