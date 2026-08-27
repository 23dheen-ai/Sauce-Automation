Feature: Product functionality

  Background:
    Given I am logged into SauceDemo

  Scenario: Verify products are displayed

    Then I should see the products page
    And I should see multiple products


  Scenario Outline: Sort products

    When I sort products by "<sorting>"
    Then the products should be sorted by "<sorting>"

    Examples:
      | sorting                |
      | Name (A to Z)          |
      | Name (Z to A)          |
      | Price (low to high)    |
      | Price (high to low)    |


  Scenario: Open product details

    When I open the first product
    Then I should see the product details


 