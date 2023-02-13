# karate
##1.Karate
karate core
karate apache
karate junit

##2.responseStatus
responseTime
responseHeaders
responseCookies

##3.space should be given before and after using = operator
"id":"#string"
"createdAt":"#ignore"
"#notNull"


##4.To get file path relative to project
def projectPath = java.lang.System.getProperty('user.dir')
def projectPath = karate.properties['user.dir']

    And def projectPath = karate.properties['user.dir']
    And print projectPath
    And def filePath = projectPath+'/java/data/request1.json'
    And print filePath
    And def requestBody1 = filePath
    And request requestBody = requestBody1


##5.Read the file which is in the same package
And request = read("request1.json")

##6.PUT to Replace the Resources
for partial update use PATCH

##7.run from command prompt
mvn test
mvn test -Dkarate.env=dev
we need to comment the test runner class -> @BeforeClass method then it will take dev url

##8.When you get Compilation error: source option 5 is no longer supported. use 7 or later follow the below steps:
make the java complier to 1.7
In the particular project 
Click on project 
Click on Build path>configure build path>java compiler>
uncheck the javaSE-1.8 that is 2nd check box
Select 1.7 from the dropdown
Apply

##9.To run particular tags select " testTags " and run as junit
To run particular tags from cmd use -> mvn test -Dtest=SampleTest#testTags
SampleTest is class name 

##10.If you dont get the junit option in the sampleTest class Junit5
update the maven project

##11.when checking '2022-01-jan' contains -> navigate to particular data like data[1] and use contains '2022'

##12.Clone the project from the github to the vscode terminal
git clone "https://github.com/intuit/karate.git

##13.Navigate to the folder from the terminal
cd .\karate\examples\ui-test\

##14.To Skip a scenario?
use @ignore at the top of scenario

###15.Parallel execution-> You don't use a JUnit runner
import com.intuit.karate.Results;
import com.intuit.karate.Runner;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class TestParallel {
    @Test
    void testParallel() {
        Results results = Runner.path("classpath:animals").tags("~@skipme").parallel(5);
        assertEquals(0, results.getFailCount(), results.getErrorMessages());
    }
}

Results results = Runner.path("classpath:some/package").tags("@smoke").parallel(5);
tags ~@skipme-> It will skip that scenario
tags @smoke-> Use like this to execute those tags

refer to multiple packages-> Runner.path("classpath:animals", "classpath:some/other/package.feature", "classpath:some/package")
this is an    "AND" operation: tags("@customer", "@smoke")
and this is an "OR" operation: tags("@customer,@smoke")

###16.And header Authorization = "Bearer sjsdioajaso"


###17.archetype for karate
mvn archetype:generate -DgroupId=com.santhoshaug173 -DartifactId=MyKarateProject1 -DarchetypeArtifactId=karate-archetype  -DarchetypeVersion=1.3.1 -DinteractiveMode=false
mvn archetype:generate -DgroupId=ToolsQA -DartifactId=DemoMavenProject -DarchetypeArtifactId=maven-archetype-quickstart -DinteractiveMode=false

###18.archetype for maven quickstart
mvn archetype:generate -DarchetypeGroupId=org.apache.maven.archetypes -DarchetypeArtifactId=maven-archetype-quickstart -DarchetypeVersion=1.4

###19.maven plugin for eclipse
Help>Install new software> add>Maven    url -> https://download.eclipse.org/technology/m2e/releases/latest/
Select Maven intergartion for eclipse
Click on next
Select POM editor using LemMinX

###20.After creating project
add 3.10.1 in maven-compiler-plugin
update maven project

###21.Jira karate API testing
token-> ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5
Account ID-> 63ea590e40d0fe709073db00
url-> https://santhposhaug.atlassian.net/
username->santhoshaug@mailinator.com
password/token-> 
ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5

curl --request GET \
  --url 'https://santhposhaug.atlassian.net/rest/api/3/user?accountId=63ea590e40d0fe709073db00' \
  --user 'santhoshaug@mailinator.com:ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5' \
  --header 'Accept: application/json'

Create user
curl --request POST \
  --url 'https://santhposhaug.atlassian.net/rest/api/3/user' \
  --user 'santhoshaug@mailinator.com:ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5' \
  --header 'Accept: application/json' \
  --header 'Content-Type: application/json' \
  --data '{
  "emailAddress": "manasa@atlassian.com"
}'

Get users
curl --request GET \
 --url 'https://santhposhaug.atlassian.net/rest/api/3/user?accountId=63ea590e40d0fe709073db00' \
  --user 'santhoshaug@mailinator.com:ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5' \
  --header 'Accept: application/json'

Get account IDs for users
curl --request GET \
  --url 'https://santhposhaug.atlassian.net/rest/api/3/users' \
  --user 'santhoshaug@mailinator.com:ATATT3xFfGF0tw0UEPmYbC9lXbk4f63QWeB745UXOxik_vX2ZYc99l2zbPGVee4AzB6YmEMz4Un6UwfG-HCy1enVw4M7pmWwZEMihVTEnw0s_U6_ldtQgcH13e5vc-tVNOJOq3bEV41C44VqJEfjxVxCcgOgJEDRPAx8V4-pGdrCHASNKSQsrXc=477D04E5' \
  --header 'Accept: application/json'




	
	


