#Author: santhosha.ug173@gmail.com

@sample
Feature: Sample POST request
  I want to use this template for my feature file

Background:
       * url baseURL
       * header Accept = 'application/json'
       * def actualInput == read("request1.json")
       * def expectedOutput = read("response1.json")

#pending       
  @sample1
  Scenario: Sample POST1
    Given path '/users'
    And request == actualInput
    And print request
    When method POST
    Then status 201
    And match response == expectedOutput
    And print response

  #@sample2
 # Scenario: Sample POST2
  #Scenario Outline: Sample POST2
   #Given I want to write a step with <name>
    #When I check for the <value> in step
    #Then I verify the <status> in step
   # Given def jsonModel == read('classpath:response1.json')
   # * print jsonModel

    #Examples: 
     # | name  | value | status  |
      #| name1 |     5 | success |
      #| name2 |     7 | Fail    |
