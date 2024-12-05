Feature: Register Functionality
  As a user should be able to register on the web site

  Background:
    Given The user navigates to the "My account" on the website
    When The user clicks on the register button

  @SDT1EPR-34
  Scenario Outline: User can register successfully with valid information.
    When The user enters valid information "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>","<password>" and "<confirmPassword>"
    Then The user should see the message "Your registration completed"
    Examples:
      | gender | firstName | lastName | day | month    | year | email             | companyName | password  | confirmPassword |
      | male   | John      | Angel    | 1   | February | 2012 | j.angel@gmail.com | google      | qwerty123 | qwerty123       |

  @SDT1EPR-75
  Scenario Outline: User can receive an error message when registering with an existing email.
    When The user re-enters the existing information as "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>","<password>" and "<confirmPassword>"
    Then The user should see the error message "The specified email already exists"
    Examples:
      | gender | firstName | lastName | day | month    | year | email             | companyName | password  | confirmPassword |
      | male   | John      | Angel    | 1   | February | 2012 | j.angel@gmail.com | google      | qwerty123 | qwerty123       |

  @SDT1EPR-25
  Scenario: Required fields in Register page
    When The user leaves required fields blank
    Then Verify that the following messages are displayed
      | FirstName       |
      | LastName        |
      | Email           |
      | Password        |
      | ConfirmPassword |


  @SDT1EPR-53
  Scenario Outline: Entering a space in the Password and Confirm Password fields
    When The user enters valid information in the "<firstName>","<lastName>","<email>" fields and enters spaces in the Password and Confirm Password fields.
    Then Verify that the following messages are displayed
      | Password        |
      | ConfirmPassword |
    Examples:
      | firstName | lastName | email          |
      | John      | Angel    | j.al@gmail.com |

  @SDT1EPR-57
  Scenario Outline: Entering less than 6 characters in the Password and Confirm Password fields.
    When The user enters valid information "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>","<password>" and "<confirmPassword>"
    Then Verify that the following messages are displayed
      | Password |
    Examples:
      | gender | firstName | lastName | day | month    | year | email          | companyName | password | confirmPassword |
      | male   | John      | Angel    | 1   | February | 2012 | j.al@gmail.com | google      | 123      | 123             |

  @SDT1EPR-59
  Scenario Outline: Entering a mismatched value in the Password and Confirm Password fields
    When The user enters valid information "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>","<password>" and "<confirmPassword>"
    Then Verify that the following messages are displayed
      | ConfirmPassword |
    Examples:
      | gender | firstName | lastName | day | month    | year | email          | companyName | password  | confirmPassword |
      | male   | John      | Angel    | 1   | February | 2012 | j.al@gmail.com | google      | qwerty123 | 123             |



