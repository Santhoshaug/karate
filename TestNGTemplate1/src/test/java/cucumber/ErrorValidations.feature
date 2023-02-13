@tag
Feature: Error validation
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
     Given I landed on Ecommerce page
     Given Logged in with <username> and <password>
     Then "Incorrect email or password." message is displayed

    Examples: 
      | username              | password  |
      | santhoshaug@gmail.com | Test@12 |
