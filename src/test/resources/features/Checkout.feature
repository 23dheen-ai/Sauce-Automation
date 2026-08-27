Feature: Checkout functionality

  Background:
    Given I am logged into SauceDemo


  Scenario: Complete successful checkout

    When I add the first product to the cart
    And I open the shopping cart
    And I proceed to checkout
    And I enter checkout information
    And I continue to order overview
    And I finish the order
    Then the order should be successfully completed


  Scenario: Verify checkout information page

    When I add the first product to the cart
    And I open the shopping cart
    And I proceed to checkout
    Then I should see the checkout information page


  Scenario: Checkout without customer information

    When I add the first product to the cart
    And I open the shopping cart
    And I proceed to checkout
    And I continue to order overview
    Then I should see a checkout error


  Scenario: Cancel checkout

    When I add the first product to the cart
    And I open the shopping cart
    And I proceed to checkout
    And I cancel checkout
    Then I should be on the cart page