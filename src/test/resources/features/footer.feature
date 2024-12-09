@SDT1EPR-5
Feature: Footer Functionality
  As a user, I should be able to reach customer info, customer service, my account details in the footer section.

  @SDT1EPR-138
  Scenario: Verifying the existence of footer components
    Given The user should be able to verify that the Footer is visible with the following headers.
      | Information      |
      | Customer service |
      | My account       |
      | Follow us        |

  @SDT1EPR-139
  Scenario: Verify clickability of footer categories
    Then  The user should see that the footer titles are clickable and move on to the following pages.
      | Shipping & returns       |
      | Privacy notice           |
      | Conditions of Use        |
      | About us                 |
      | Contact Us               |
      | Search                   |
      | Recently viewed products |
      | New products             |
      | Returning Customer       |
      | Returning Customer       |
      | Returning Customer       |
      | Shopping Cart            |


  @SDT1EPR-140
  Scenario Outline: Follow Us Functionality
    When The user enters "<email>" in the Follow Us field
    Then The user should see a sign up "<message>"
    Examples:
      | email        | message                                                                                    |
      | gk@gmail.com | Thank you for signing up! A verification email has been sent. We appreciate your interest. |
      | gkgmail.com  | Enter valid email                                                                          |

