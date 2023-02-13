@tag
Feature: Purchase the order from Ecommerce website
  I want to use this template for my feature file
  
  Background: 
  Given I landed on Ecommerce page

  @Regression
  Scenario Outline: Positive Testcase for submitting the oder
  
    Given Logged in with <username> and <password>
    When I add product <productName> to cart
    And checkout <productName> and submit order
    Then "THANKYOU FOR THE ORDER."message is displayed on confirmation page

    Examples: 
      | username              | password  | productName  |
      | santhoshaug@gmail.com | Test@1234 | ZARA COAT 3   |
