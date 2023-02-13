Feature: Post API demo

@ignore
  # different package but karate.demo is same for both
   Scenario: Read data from other super package
    Given def expectedOutput = read('../data/response1.json')
    And print expectedOutput
    
    @ignore
    # different package Data1 package
    Scenario: Read data from other super package
    Given def expectedOutput = read('../../../Data1/response1.json')
    And print expectedOutput
    
    @ignore
    Scenario: Read data from other child package
    Given def expectedOutput = read('DataNew/response1.json')
    And print expectedOutput
    
    Scenario: Read data from other super package
    Given def expectedOutput = read('../../../../../../testdata/response1.json')
    And print expectedOutput
    