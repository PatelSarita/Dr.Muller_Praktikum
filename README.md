# Dr.Müller Automation - Hybrid (BDD and DDT) Framework With Cucumber

### Codes And Tests Prepared By :
Sarita Patel,Filiz Bagdatli,Gulay Kurt,Cevahir Basibuyuk

QA Automation Engineers

sisterforever@gmail.com
___
### Getting Started
To get start with this framework, you will need to have the following software on your system.

• Java 11 or later \
• Maven 3 or later \
• Chrome or Firefox or Edge Web Browser
1. Open terminal or command prompt and navigate to the root directory of the project.
2. Run the following command to download the required dependencies:
   #### mvn clean install
3. Run the following command to run the tests:
   #### mvn verify
4. Open the project with Intellij IDEA
    - Go to CukesRunner class inside the project
    - Click Run button
   #### Run With CukesRunner
    - Go to CukesRunner
    - Add a tag name
    - Click the "Run" Button
___
### Our framework is a Cucumber and Hybrid Framework which contains BDD and DDT Frameworks.
• We built our framework by using Java Programming Language.\
• We used maven as a build automation tool for this framework.\
• We used Selenium (4.26.0), Cucumber and Junit to orchestrate our tests, and put the dependencies inside pom.xml file.\
• For assertions/verifications, We utilized JUnit assertions to compare expected and actual results.\
• We created a properties file to store related data such as browser and url.\
• We used Page Object Model Design Pattern to enhance test maintenance and reducing code duplication. This is one of the most famous Selenium approaches.\
• Inside pages package; We used Page Classes to store and identify the elements that we worked on.\
• We used the PageFactory class and initElements method to initialize them.\
• Inside runners package; in the CukesRunner class, We used glues to connect feature files to step definitions.\
• We added the report plugin to CukesRunner to generate Json and HTML reports.\
• We also used tags for tests that we want to run in bulk.\
• stepDefs package is the place where our actual test scripts are.\
• Inside stepDefs package we used Hooks class as pre-and post-test implementations.\
• We added a screenshot interface in After method in Hooks class; when the scenario fails, it takes a screenshot.\
• We defined the steps of my scenarios inside StepDef classes.\
• Inside utilities package, utility classes such as BrowserUtils, Driver, and ConfigurationReader were stored.\
• We used the Singleton Design Pattern in Driver class by declaring constructor of class as private, so that no one instantiates class outside of it. And declared a static method with return type as object of class which should check if class is already instantiated once.\
• Inside features directory which is under resources directory we created feature files.\
• In these feature files we used Cucumber and Gherkin language for non-technical people to understand what is going on in testing.\
• We stored my feature files separately in the features directory, and it helped in the re-usability of the codes.\
• We created my test cases as Scenario and Scenario Outline in the feature files as-is.\
• Our framework is easy to maintain since we have elements stored in one centralized place. If any changes happen on the application about the elements, We know where to go and how to fix it to run test scripts correctly.