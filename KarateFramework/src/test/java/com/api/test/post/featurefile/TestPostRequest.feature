Feature: Verify the Post endpoint

  Background: Setup the test variables
    * def applicationUrl = appUrl


  Scenario: To verify the response of the https://reqres.in/api
    Given def requestBody = read('data/requestBodyy.xml')
    # parameterization
    When def aResponse = call read('classpath:com/api/test/helper/PostRequestHelper.feature') { _url: '#(applicationUrl)', _requestBody: '#(requestBody)' }
    * karate.log("===>", aResponse)
    And xmlstring postResponseBody = aResponse.responseDataInString
    And def isTagNodePresent = call read('classpath:com/api/test/helper/xml-tag-validator.js') { _xmlcontent: '#(postResponseBody)', _xpath: '/Document/CstmrDrctDbtInitn/GrpHdr' }
    And match isTagNodePresent == false
    
    Scenario: To verify node value in the response of the https://verifye.co.za/response.php
    # test data
    Given def requestBody = read('data/requestBodyy.xml')
    When def aResponse = call read('classpath:com/api/test/helper/PostRequestHelper.feature') { _url: '#(applicationUrl)', _requestBody: '#(requestBody)' }
    And xmlstring postResponseBody = aResponse.responseDataInString
    # repeatable and reusable functions
    And def isValuePresent = call read('classpath:com/api/test/helper/xml-tag-validator.js') { _xmlcontent: '#(postResponseBody)', _xpath: '/Document/CstmrDrctDbtInitn/PmtInf/PmtInfId', _expectedValue: 'PULENG2005'}
    # validation for values.
    And match isValuePresent == true
   
