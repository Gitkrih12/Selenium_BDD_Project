Feature: Notes

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @46153
  Scenario: Verify user should navigate to Notes page on clicking claim number from Global Search page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Notes tab
    Then user navigates to the "Notes" tab

  @46154
  Scenario: Verify column fields in Notes tab
    When user clicking on Claim Number in Global Search page
    And user clicks on the Notes tab
    Then user should be able to view the below column fields
      | Title        |
      | Category     |
      | Description  |
      | Created By   |
      | Created Date |
    And user able to view all the field values under Notes tab

  @46159
  Scenario: Validate footer buttons in Notes Tab
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on the Notes tab
    Then user views the footer section in Notes tab
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |
      | Deactivate        |