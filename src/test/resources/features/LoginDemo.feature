Feature: Test login functionality

  Scenario: Check login is successful with valid credentials
    Given browser is open
    And user is on login page
    When user enters username and password
    Then user is navigated to the home page
