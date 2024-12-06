@update
Feature: My Account-Customer Info Functionality
  As a user I should change some info in My Account-Customer Info Functionality

  Background:
    Given The user navigates to the "My account" on the website
    When The user enters valid credentials

  Scenario Outline: User can update their account information.
    When The user enters valid information "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>"
    Then And the updated "<firstName>" should reflect the new values in the Customer Info section
    And The user enters valid information "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>"
    Then And the updated "<email>" should reflect the new value in the Customer Info section

    Examples:
      | gender | firstName | lastName | day | month    | year | email            | companyName |
      | male   | Murat     | Kocer    | 10  | February | 2001 | murat3@gmail.com | nimet       |
      | female | Emine     | Kocer    | 10  | February | 2001 | emine3@gmail.de  | nimet       |

  Scenario: Verify error messages for missing required fields

    When The user leaves the firstName field empty
    Then The error message for First Name "First name is required." should be displayed

    And The user leaves the lastName field empty
    Then The error message for Last Name "Last name is required." should be displayed

    And The user leaves the email field empty
    Then The error message for Email "Email is required." should be displayed

  Scenario Outline: Display error message for invalid email

    When The user enters valid information "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>"
    Then The user should see an error message "Wrong email"

    Examples:
      | gender | firstName | lastName | day | month    | year | email           | companyName |
      | male   | Murat     | Kocer    | 10  | February | 2001 | murat3gmail.com | nimet       |
      | female | Emine     | Kocer    | 10  | February | 2001 | emine3@.com     | nimet       |


  Scenario Outline: User can not choose  invalid date

    When The user enters valid information "<gender>","<firstName>","<lastName>","<day>","<month>","<year>","<email>","<companyName>"
    Then The user should not be able to choose invalid "<day>"

    Examples:
      | gender | firstName | lastName | day | month    | year | email            | companyName |
      | male   | Murat     | Kocer    | 29  | February | 2001 | murat3@gmail.com | nimet       |
      | female | Emine     | Kocer    | 31  | November | 2011 | emine3@gmail.de  | nimet       |

