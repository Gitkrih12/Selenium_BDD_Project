Feature: Claim Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @47215
  Scenario: Verify user should able to see attached files and EDI files in Documents tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Documents tab
    Then user able to view the below sub tabs under Documents tab
      | EDI Files   |
      | Attachments |