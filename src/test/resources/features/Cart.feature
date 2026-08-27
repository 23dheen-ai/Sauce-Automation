Feature: Shopping cart functionality

  Background:
    Given I am logged into SauceDemo


  Scenario: Add product and verify cart

    When I add the first product to the cart
    And I open the shopping cart
    Then the cart should contain one product


  Scenario: Verify product information in cart

    When I add the first product to the cart
    And I open the shopping cart
    Then the product name should be displayed
    And the product price should be displayed
    And the product quantity should be 1


  Scenario: Remove product from cart

    When I add the first product to the cart
    And I open the shopping cart
    And I remove the first product
    Then the cart should be empty


  Scenario: Continue shopping from cart

    When I add the first product to the cart
    And I open the shopping cart
    And I continue shopping
    Then I should be on the products page


  Scenario: Add multiple products to cart

    When I add the first product to the cart
    And I add the second product to the cart
    And I open the shopping cart
    Then the cart should contain 2 products