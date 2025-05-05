Feature: Place the order for Products

   
   Scenario Outline: Search Experience the product increase the quantity and moved to checkout page
   
    Given User is on Greencart landing page
    When User searched with shortname <name> and extracted actual name of product
    And Add "3" items of the selected part to cart
    Then User proceeds to Checkout and validate the <name> items in checkout page
    And Verify user has ability to enter the promo code and place the order
    Examples:
    | name  |
    | Tom   |
    