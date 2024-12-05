Feature: Register Functionality
  As a user should be able to register on the web site

  Background:
    Given The user navigates to the "My account" on the website
    When The user clicks on the register button


  Scenario Outline: User can register successfully with valid information.
    When The user enters valid information "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>","<password>" and "<confirmPassword>"
    Then The user should see the message "Your registration completed"
    Examples:
      | gender | firstName | lastName | day | month    | year | email             | companyName | password  | confirmPassword |
      | male   | John      | Angel    | 1   | February | 2012 | j.angel@gmail.com | google      | qwerty123 | qwerty123       |


  Scenario Outline: User can receive an error message when registering with an existing email.
    When The user re-enters the existing information as "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>","<password>" and "<confirmPassword>"
    Then The user should see the error message "The specified email already exists"
    Examples:
      | gender | firstName | lastName | day | month    | year | email             | companyName | password  | confirmPassword |
      | male   | John      | Angel    | 1   | February | 2012 | j.angel@gmail.com | google      | qwerty123 | qwerty123       |

  @register
  Scenario: Required fields in Register page
    When The user leaves required fields blank
    Then Verify that the following messages are displayed
      | FirstName       |
      | LastName        |
      | Email           |
      | Password        |
      | ConfirmPassword |


