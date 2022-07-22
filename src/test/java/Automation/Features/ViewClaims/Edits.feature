Feature: Edits

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @44549
  Scenario: Verify user able to navigate to Edits tab from Global Search and validate the fields
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on Edits tab
    Then user navigates to the "Edits" tab
    And user able to view two sub tabs as "ServiceLevelEdits" and "ClaimLevelEdits"

  @44550
  Scenario: Validate buttons functionality of Edits tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on Edits tab
    Then user views the footer section in Edits page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |

  @44553
  Scenario: Verify "Service Level Edits" Sub-tab functionality
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on Edits tab
    Then user should be able to view below columns in Service Level Edits
      | Line Number   |
      | Edit Number   |
      | Description   |
      | Workaround    |
      | Resolution    |
      | Status        |
      | Category      |
      | Added By      |
      | Overridden By |