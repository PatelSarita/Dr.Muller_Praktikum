@Login @SDT1EPR-1
Feature: Login Functionality

  #This code may not work due to captcha problem
  Scenario: Positive Login Test
    Given The user navigates to the "My account" on the website
    When The user enters valid credentials
    Then The user should go to the "Customer Info" page


