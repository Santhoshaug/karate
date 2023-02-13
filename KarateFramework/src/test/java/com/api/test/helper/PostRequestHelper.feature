@ignore
Feature: Send the POST request
  Helper feature file to send the POST request to a given endpoint

  Scenario: POST request helper
    Given url _url
    And header Accept = 'application/xml'
    And header Content-Type = 'application/xml'
    And def requestBody = _requestBody
    And request requestBody
    When method post
    Then status 201
    And def responseData = response
    * xmlstring responseDataInString = responseData
