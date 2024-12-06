@SDT1EPR-13
Feature: Add and Update Address Information
  As a user, I want to add and update the address information by clicking the Addresses tab under "My Account".

  Background:
    Given The user navigates to the "My account" on the website
    When The user enters valid credentials

  @SDT1EPR-134
  Scenario Outline: Add a new address
    When The user enters valid information "<firstName>","<lastName>","<email>","<companyName>","<country>","<state>""<city>","<address1>","<address2>","<zip>","<phoneNumber>","<faxNumber>"
    Then The user should be able to save
    Examples:
      | firstName | lastName | email         | companyName | country | state  | city      | address1    | address2 | zip   | phoneNumber | faxNumber |
      | Edel      | Kastrat  | edel@gmail.de | eurutech    | Germany | Hessen | Wiesbaden | zoll strase | numer 1  | 42343 | 0173456765  | 785634    |


  @SDT1EPR-136
  Scenario Outline: Update an existing address

    When The user enters valid information "<firstName>","<lastName>","<email>","<country>","<state>""<city>","<address1>","<zip>","<phoneNumber>"
    Then The user should be able to save updates
    Examples:
      | firstName | lastName | email         | country | state  | city      | address1    | zip   | phoneNumber |
      | John      | Paul     | edel@gmail.de | Germany | Hessen | Wiesbaden | zoll strase | 42343 | 0173456765  |


