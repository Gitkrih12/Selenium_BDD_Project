Feature: Edits

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @44549
  Scenario: Verify user able to navigate to Edits tab from Global Search and validate the fields
    When user clicking on Claim Number in Global Search page
    And user clicks on Edits tab
    Then user navigates to "Edits" tab in View page
    And user able to view two sub tabs as "Service Level Edits" and "Claim Level Edits"

  @44550
  Scenario: Validate buttons functionality of Edits tab
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on Edits tab
    Then user views the footer section in Edits page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |

  @44553
  Scenario: Verify Service Level Edits Sub tab functionality
    When user clicking on Edits Claim Number in Global Search page
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
    And user able to view all the field values in Service Level Edits

  @44556
  Scenario: Verify Edit & Delete functionality in Service Level Edits Sub tab
    When user clicking on Claim Number in Global Search page
    And user clicks on Edits tab
    Then user should be able to view Delete action item
    And user should be able to view Edit action item

  @44558
  Scenario: Verify Claim Level Edits Sub-tab
    When user clicking on Edits Claim Number in Global Search page
    And user clicks on Edits tab
    And user clicks on Claim Level Edits tab
    Then user should be able to view below columns in Claim Level Edits
      | Edit Number   |
      | Reason Code   |
      | Description   |
      | Workaround    |
      | Resolution    |
      | Status        |
      | Category      |
      | Added By      |
      | Overridden By |
    And user able to view all the field values in Claim Level Edits

  @44561
  Scenario: Verify Edit & Delete functionality in Claim Level Edits Sub tab
    When user clicking on Claim Number in Global Search page
    And user clicks on Edits tab
    And user clicks on Claim Level Edits tab
    Then user should be able to view Delete action item
    And user should be able to view Edit action item