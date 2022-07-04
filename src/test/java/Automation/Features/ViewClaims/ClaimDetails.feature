Feature: Claim Details

  Background:
#    Given the user enters the valid username and password and click on login button for admin role
#    When user lands directly to the page
    Given the user logged into CA application
    When user directly lands to the home page

@37332
  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the Claim Summary page
    And user should view hide option besides Claim Summary