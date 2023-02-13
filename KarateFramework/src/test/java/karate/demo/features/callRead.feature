Feature: This feature is calling

  Background: 
    * def Output = call read('FeatureCalled.feature')
    
@ignore
  Scenario: Feature is getting calling
    Given print 'This feature is calling'
    And print Output
    * def firstname = Output.response.name
    And print Output.name1

    
     Scenario: request
    Given url 'https://reqres.in/api/users/3'
    When method get
    Then status 200
    * def EmailID = Output.response.data.email
    And print 'Email address --->', EmailID