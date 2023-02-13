Feature: Validation basic authorization

  @basicAuth1
  Scenario: Validate basic auth for jira and get details
    Given url 'https://santhposhaug.atlassian.net/rest/api/3/user?accountId=63ea590e40d0fe709073db00'
    * header Authorization = call read('Testdata/basic-auth.js') { username: 'santhoshaug@mailinator.com', password: 'ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5' }
    When method get
    Then status 200
    And print response

  @basicAuthPost
  Scenario: POST with basic auth
    Given url 'https://santhposhaug.atlassian.net/rest/api/3/user?accountId=63ea590e40d0fe709073db00'
    * header Authorization = call read('Testdata/basic-auth.js') { username: 'santhoshaug@mailinator.com', password: 'ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5' }
    And request {"emailAddress": "meghana@atlassian.com"}
    When method post
    Then status 201
    And print response

  @basicAuthPost1
  Scenario Outline: : POST with basic auth using csv file
    Given url 'https://santhposhaug.atlassian.net/rest/api/3/user?accountId=63ea590e40d0fe709073db00'
    * header Authorization = call read('Testdata/basic-auth.js') { username: 'santhoshaug@mailinator.com', password: 'ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5' }
    And request {"emailAddress": <emailAddress>}
    When method post
    Then status 201
    And print response

    Examples: 
      | read('testdata/PostbasicAuthorization.csv') |

  @getusersdefault
  Scenario: Get all users default
    Given url appBaseURLJira
    And path '/rest/api/3/users'
    * header Authorization = call read('Testdata/basic-auth.js') { username: 'santhoshaug@mailinator.com', password: 'ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5' }
    When method get
    Then status 200
    And print response
