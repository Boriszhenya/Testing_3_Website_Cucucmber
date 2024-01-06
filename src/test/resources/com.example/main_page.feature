Feature: Main page functionality

  @positive
  Scenario: User adds product to the cart
    Given user enter login page
    When user enters valid credentials
    And clicks login button
    Then main page opens
    When user adds first product to the cart
    Then amount of products in the cart is 1

  @positive
  Scenario: User adds product with name to the cart
    Given user enter login page
    When user enters valid credentials
    And clicks login button
    Then main page opens
    When user adds product with name "Onesie" to the cart
    Then amount of products in the cart is 1
    Then cart page opens
    Then check the product name in the cart