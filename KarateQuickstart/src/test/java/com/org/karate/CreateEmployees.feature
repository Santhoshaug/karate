Feature: To create employee records

  @ignore
  Scenario: To create an employee
    Given url 'https://dummy.restapiexample.com'
    And path '/api/v1/create'
    And request {"name":"test","salary":"123","age":"23"}
    When method post
    Then status 200
    And print response

  @ignore
  Scenario Outline: To create an employee
    Given url 'https://dummy.restapiexample.com'
    And path '/api/v1/create'
    And request {"name":<name>,"salary":<salary>,"age":<age>}
    When method post
    Then status 200
    And print response

    Examples: 
      | name | salary | age |
      | test |    123 |  23 |

  Scenario Outline: To create an employee
    Given url 'https://dummy.restapiexample.com'
    And path '/api/v1/create'
    And request {"name":<name>,"salary":<salary>,"age":<age>}
    When method post
    Then status 200
    And print response

    Examples: 
      | read('testdata/inputdata.csv') |
