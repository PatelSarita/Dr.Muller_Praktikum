@SDT1EPR-14
Feature: Purchase Function
  As a user  I should be able to complete the purchase with selected product



  @SDT1EPR-84
  Scenario Outline: Verify that the user can add a product to the cart
    When The user is on Home page and clicks on "<productCategory>"
    And select the "<product>" and "<quantity>" and clicks on Add to cart
    Then The Product added to your shopping cart message "<productAddedMessage>" should be displayed
    Examples:
      | productCategory | product                     | quantity | productAddedMessage                              |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart |


  @SDT1EPR-85
  Scenario Outline: Verify the user can view the product details in the cart
    Given The user is on Home page and clicks on "<productCategory>"
    And select the "<product>" and "<quantity>" and clicks on Add to cart
    Then The Product added to your shopping cart message "<productAddedMessage>" should be displayed
    When The user hover over on the Cart icon and clicks on The Go to cart button
    Then The user should be able to see details "<Product name>" and "<Product quantity>" and "<Product price>"
    Examples:
      | productCategory | product                     | quantity | productAddedMessage                              | Product name                | Product quantity | Product price |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        |


  @SDT1EPR-97
  Scenario Outline: Verify that the user can proceed to the checkout
    Given The user is on Home page and clicks on "<productCategory>"
    And select the "<product>" and "<quantity>" and clicks on Add to cart
    Then The Product added to your shopping cart message "<productAddedMessage>" should be displayed
    When The user hover over on the Cart icon and clicks on The Go to cart button
    Then The user should be able to see details "<Product name>" and "<Product quantity>" and "<Product price>"
    When The user clicks on Checkout button from Shopping Cart page
    Then The user should be able to navigate to "Returning Customer" page and continue " Checkout as Guest "
    Examples:
      | productCategory | product                     | quantity | productAddedMessage                              | Product name                | Product quantity | Product price |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        |


  @SDT1EPR-98
  Scenario Outline: Verify that the user can complete purchase with adding new address from  Billing section
    Given The user is on Home page and clicks on "<productCategory>"
    And select the "<product>" and "<quantity>" and clicks on Add to cart
    Then The Product added to your shopping cart message "<productAddedMessage>" should be displayed
    When The user hover over on the Cart icon and clicks on The Go to cart button
    Then The user should be able to see details "<Product name>" and "<Product quantity>" and "<Product price>"
    And The user clicks on Checkout button from Shopping Cart page
    Then The user should be able to navigate to "Returning Customer" page and continue " Checkout as Guest "
    When The user click on "Billing address" dropdown and click New Address and edit "<First Name>", "<Last Name>", "<Email>", "<Country>", "<State>", "<City>", "<Address>", "<ZipCode>", "<Phone>" and clicks "Billing" continue button
    And The user is navigated to "Shipping method" section and click "ShippingMethod" continue button
    Then The user is navigated to "Confirm order" section and click "ConfirmOrder" continue button
    Then The user is able to see order confirmation "<Message>"
    Examples:
      | productCategory | product                     | quantity | productAddedMessage                              | Product name                | Product quantity | Product price | First Name | Last Name | Email          | Country | State  | City      | Address     | ZipCode | Phone       | Message                                     |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Germany | Hessen | Frankfurt | nue strasse | 48002   | 17654645346 | Your order has been successfully processed! |


  @SDT1EPR-99
  Scenario Outline: Verify that the user can not complete purchase when user does not fill mandatory fields in new address section
    Given The user is on Home page and clicks on "<productCategory>"
    And select the "<product>" and "<quantity>" and clicks on Add to cart
    Then The Product added to your shopping cart message "<productAddedMessage>" should be displayed
    When The user hover over on the Cart icon and clicks on The Go to cart button
    Then The user should be able to see details "<Product name>" and "<Product quantity>" and "<Product price>"
    When The user clicks on Checkout button from Shopping Cart page
    Then The user should be able to navigate to "Returning Customer" page and continue " Checkout as Guest "
    When The user click on "Billing address" dropdown and click New Address and edit "<First Name>", "<Last Name>", "<Email>", "<Country>", "<State>", "<City>", "<Address>", "<ZipCode>", "<Phone>" and clicks "Billing" continue button
    Then The user is able to see order confirmation "<Error Message>"
    Examples:
      | productCategory | product                     | quantity | productAddedMessage                              | Product name                | Product quantity | Product price | First Name | Last Name | Email          | Country        | State        | City      | Address      | ZipCode | Phone       | Error Message                 |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        |            | Paul      | maya@gmail.com | Germany        | Hessen       | Frankfurt | neue strasse | 48002   | 17654645346 | First name is required.       |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       |           | maya@gmail.com | Germany        | Hessen       | Frankfurt | neue strasse | 48002   | 17654645346 | Last name is required.        |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      |                | Germany        | Hessen       | Frankfurt | neue strasse | 48002   | 17654645346 | Email is required.            |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Select country | Select state | Frankfurt | neue strasse | 48002   | 17654645346 | Country is required.          |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Germany        | Select state | Frankfurt | neue strasse | 48002   | 17654645346 | State / province is required. |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Germany        | Hessen       |           | neue strasse | 48002   | 17654645346 | City is required              |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Germany        | Hessen       | Frankfurt |              | 48002   | 17654645346 | Street address is required    |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Germany        | Hessen       | Frankfurt | neue strasse |         | 17654645346 | Zip / postal code is required |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Germany        | Hessen       | Frankfurt | neue strasse | 48002   |             | Phone is required             |

  @SDT1EPR-100
  Scenario Outline: Verify that the user get the "Error massage" if only "Spaces" entered mandatory fields in the new Address section on Billing Page.
    Given The user is on Home page and clicks on "<productCategory>"
    And select the "<product>" and "<quantity>" and clicks on Add to cart
    Then The Product added to your shopping cart message "<productAddedMessage>" should be displayed
    When The user hover over on the Cart icon and clicks on The Go to cart button
    Then The user should be able to see details "<Product name>" and "<Product quantity>" and "<Product price>"
    When The user clicks on Checkout button from Shopping Cart page
    Then The user should be able to navigate to "Returning Customer" page and continue " Checkout as Guest "
    When The user click on "Billing address" dropdown and click New Address and edit "<First Name>", "<Last Name>", "<Email>", "<City>", "<Address>", "<Zip>", "<Phone>","<Field>" and clicks "Billing" continue button
    Then The user is able to see order confirmation "<Error Message>"
    Examples:
      | productCategory | product                     | quantity | productAddedMessage                              | Product name                | Product quantity | Product price | First Name | Last Name | Email          | City      | Address      | Zip   | Phone       | Field      | Error Message                 |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Frankfurt | neue strasse | 48002 | 17654645346 | First Name | First name is required.       |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Frankfurt | neue strasse | 48002 | 17654645346 | Last Name  | Last name is required.        |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Frankfurt | neue strasse | 48002 | 17654645346 | Email      | Email is required.            |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Frankfurt | neue strasse | 48002 | 17654645346 | City       | City is required              |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Frankfurt | neue strasse | 48002 | 17654645346 | Address    | Street address is required    |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Frankfurt | neue strasse | 48002 | 17654645346 | Zip        | Zip / postal code is required |
      | Bleaching       | Muller After Bleaching Care | 5        | The product has been added to your shopping cart | Muller After Bleaching Care | 5                | 0.00 €        | Maya       | Paul      | maya@gmail.com | Frankfurt | neue strasse | 48002 | 17654645346 | Phone      | Phone is required             |







