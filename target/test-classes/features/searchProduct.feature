Feature: Search and Place the order for Products

  #Scenario: Search Experience for product search in both home and offer page
  #Given User is on Greencart landing page
  #When User searched with shortname "Tom" and extracted actual name of product
  #Then User searched for "Tom" shortname in offers page
  #And Validate product name in offers page matches with landing page
  @Smoke
  Scenario Outline: Search Experience for product search in both home and offer page
    Given User is on Greencart landing page
    When User searched with shortname <Name> and extracted actual name of product
    Then User searched for <Name> shortname in offers page
    And Validate product name in offers page matches with landing page
    Examples:
    | Name  |
    | Tom   |
    | Beet  |
    
 
   Scenario: Search the product increase the quantity and moved to checkout page
    Given User is on Greencart landing page
    When User searched with shortname "Pot" and extracted actual name of product
    And Add the items to the cart and click on checkout button
    Then Validate whether the same product is displaying in Checkout page
    