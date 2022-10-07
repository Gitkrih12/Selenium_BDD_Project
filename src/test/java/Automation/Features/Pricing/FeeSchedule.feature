Feature: Fee Schedule

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @TC_63169
  Scenario: Verify user able to view the Fee schedules side drawer when clicking on See Fee Schedule in Pricing screen
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user clicking on Claim Number in Global Search page for Fee Schedule
    And user clicks on Service Details tab
    And user clicks on service line number
    Then user should navigates to "Pricing" screen
    When user clicks on See Fee Schedule link
    Then user should navigates to "Fee Schedules" screen
