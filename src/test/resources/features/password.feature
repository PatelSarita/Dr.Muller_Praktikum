@SDT1EPR-117
Feature: As a user,I want to change my password

  Background:
    Given The user navigates to the "My account" on the website
    When The user enters valid credentials
#    And The user clicks on the "Change Password" button

  Scenario Outline: Verify validation errors while changing the password
    Given The user clicks on the "Change Password" icon
    When The user enters  "<OldPassword>" and "<NewPassword>" and "<ConfirmPassword>"
    Then Verify that the user sees an error message: "<ErrorMessage>"
    Then Verify that the user sees an old password error message: "<ErrorMessage>"

    Examples:
      | OldPassword  | NewPassword   | ConfirmPassword | ErrorMessage                                             |
      |              |               |                 | Password is required.                                    |
      | strongOld123 | 12345         | 12345           | must meet the following rules:                           |
      | strongOld123 | StrongPass123 | StrongPass124   | The new password and confirmation password do not match. |
      | wrongOldPass | StrongPass123 | StrongPass123   | "Old password doesn't match"                             |

  Scenario Outline: Verify password change functionality
    Given The user clicks on the "Change Password" icon
    When The user enters valid "<OldPassword>" and "<NewPassword>" and "<ConfirmPassword>"
    Then Verify that the user sees a message: "<Message>"


    Examples:
      | OldPassword    | NewPassword   | ConfirmPassword | Message              |
      | currentPass123 | StrongPass123 | StrongPass123   | Password was changed |