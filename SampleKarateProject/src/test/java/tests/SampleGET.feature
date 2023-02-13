Feature: Sample optimal API testing

  Background: 
    * url baseURL
    * header Accept = 'application/json'

  @smoke
  Scenario: Sample GET request
    Given path '/users'
    And param page = 2
    When method GET
    Then status 200
    And print name
    And print response
    And print responseStatus
    And print responseTime
    And print responseHeaders
    And print responseCookies
    And match response.data[0].first_name != null
    And assert response.data.length == 6
    And match $.data[3].id == 10
    And match response.data[4].last_name == 'Edwards'

  Scenario: Sample no tag GET request
    Given path '/users?page=2'
    When method GET
    Then print response
    And print 'If you use quary param in the path, the url might change, check in the reports under method'
    And print 'displying as https://reqres.in/api/users%3Fpage=2 instead of https://reqres.in/api/users?page=2'
