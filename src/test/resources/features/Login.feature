Feature: Login functionality

  Scenario: Login with valid credentials

    Given I am on the SauceDemo login page
    When I login with valid credentials
    Then I should be logged into the application