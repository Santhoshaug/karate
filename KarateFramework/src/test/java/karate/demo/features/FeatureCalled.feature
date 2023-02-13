Feature: This feature is getting called by other feature

  Background: 
    Given def expectedOutput = read('../../../Data1/response1.json')

@ignore
  Scenario: Feature is getting called
    Given print 'This feature is getting called by other feature'

@ignore
  # different package Data1 package
  Scenario: Read data from other super package
    Given def expectedOutput = read('../../../Data1/response1.json')
    And print expectedOutput
    And def name1 = expectedOutput.name

  Scenario: request
    Given url 'https://reqres.in/api/users/3'
    When method get
    Then status 200
    And print response
   # And match response == expectedOutput[0]
    Then print 'result --------'
