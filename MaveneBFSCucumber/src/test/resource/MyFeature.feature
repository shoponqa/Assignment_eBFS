Feature: Test cases for eBFS website

  Background: 
    Given Navigate to eBFS site

  Scenario: Create New Account with Invalid Email Address
    When Click on SignIn link
    Then Input Invalid email address under create an account
    And Click on Create an account button
    And Close browser

  Scenario: Create New Account with Already Registered Email Address
    When Click on SignIn link
    Then Input Alredy Registered email address under create an account
    And Click on Create an account button
    And Close browser

  Scenario: Create New Account with valid new Email Address
    When Click on SignIn link
    Then Input New email address under create an account
    And Click on Create an New account button
      | Fields      | Value   |
      | FirstName   | kelly   |
      | LastName    | John    |
      | Password    | abcd123 |
      | SelectDay   | 10      |
      | SelectMonth | MAY     |
      | SelectYear  | 2000    |
    And Click on Register
    And Click on Personal Link
      | Fields        | Value    |
      | UpdateLN      | George   |
      | CurrentPass   | abcd123  |
      | UPdateNewPass | abcd6543 |
      | ConfirmPass   | abcd6543 |
    And Click on save
    And Close browser

  Scenario: Product Search
    When Input Shirt in search field
    Then Click on searh button
    And Validate Top Seller Product in left side
    And Close browser

  Scenario: Add to cart validation
    When Hover over mouse on any product & 'Quick View' Button
    Then Change product quantity & Change size
    And Click 'Add to Cart' button
    And Click 'Proceed to checkout button'
    And Close browser
