@SDT1EPR-7
Feature: As a user,I want to change my password

  Background:
    Given The user navigates to the "My account" on the website
    When The user enters valid credentials

  @SDT1EPR-117
  Scenario Outline: Verify validation errors while changing the password
    Given The user clicks on the Change Password icon
    When The user enters "<OldPassword>" and "<NewPassword>" and "<ConfirmPassword>"
    Then Verify that the user sees an "<OldErrorMessage>" and "<NewErrorMessage>" and "<ConfirmErrorMessage>"

    Examples:
      | OldPassword | NewPassword   | ConfirmPassword | OldErrorMessage           | NewErrorMessage                | ConfirmErrorMessage                                      |
      |             |               |                 | Old password is required. | Password is required.          | Password is required.                                    |
      | cev123      | 12345         | 12345           |                           | must meet the following rules: |                                                          |
      | cev123      | StrongPass123 | StrongPass124   |                           |                                | The new password and confirmation password do not match. |

  @SDT1EPR-118
  Scenario Outline: Verify valid password change functionality
    Given The user clicks on the Change Password icon
    When The user enters valid "<NewPassword>" and "<ConfirmPassword>"
    Then Verify that the user sees a message: "<ValidMessage>"

    Examples:
      | NewPassword   | ConfirmPassword | ValidMessage         |
      | StrongPass123 | StrongPass123   | Password was changed |