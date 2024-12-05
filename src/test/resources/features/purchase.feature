@SDT1EPR-14
  Feature: Purchase Function
    As a user  I should be able to complete the purchase with selected product

    Background: Positive Login Test
      Given The user navigates to the "My account" on the website
      When The user enters valid credentials

      @SDT1EPR-15
      Scenario Outline: Verify that the user can add a product to the cart
        When The user is on Home page and clicks on Composite category
        And select the "product" and "quantity"
        And clicks on Add to cart
        Then The Product added to your shopping cart message "<productAddedMessage>" should be displayed
        Examples:
          | productAddedMessage |
          | The product has been added to your shopping cart |

    @SDT1EPR-16
    Scenario Outline: Verify the user can view the product details in the cart
      When The user hover over on the "Cart" icon
      And clicks on The Go to cart button
      Then The user should be able to see details "<Product name>" and "<Product quantity>" and "<Product price>"
      Examples:
        | Product name | Product quantity | Product price |
        | Muller After Bleaching Care | 5 | 0.00 |



