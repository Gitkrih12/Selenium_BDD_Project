Feature: Validation History

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @82280
  Scenario: Verify user able to navigate to the Validation History tab
    When user clicks on Validation History tab
    Then user should navigates to the "Validation History" tab successfully