Feature: CAP Institutional

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  #38961-As an adjudicator, I should be able to view CAP Institutional claims page with all claims details data. So that, I can able to search specific claim id and I can able to add applicable filters.
  @TC_37095
  Scenario: Verify when user clicks on CAP Institutional page on the left navigation pane
    When user clicks on  CAP Institutional in left navigation menu
    Then the user should navigate to the  CAP Institutional page