Feature: JSON feature testing

Background:
    * def data = read('data/sample.json')

  Scenario:
    * print data
    
#Completed
  Scenario: json reader parser
    * def jsonObject =
      """
      [
      {
      	"name" : "Sushanth",
      	"phone" : 7878737373
      },
      {
      	"name" : "Ajay",
      	"phone" : 7363736373
      }
      ]
      """
    * print jsonObject
    * print jsonObject[0].name
    * print jsonObject[1].name +" "+ jsonObject[1].phone


#Pending
  @sample2
  Scenario: Sample POST2
    #Given def jsonModel == read('file:data/sample.json')
    #* print jsonModel
    And def projectPath = karate.properties['user.dir']
    #And def filePath = projectPath+'/src/test/java/data/sample.json'
    And def filePath = 'D:\\AutomationProject\\SampleKarateProject\\src\\test\\java\\data\\sample.json'
    And print filePath
    And def requestBody1 = filePath
    And print requestBody1
    #And request requestBody = requestBody1
