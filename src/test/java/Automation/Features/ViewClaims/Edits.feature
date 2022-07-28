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
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on Edits tab
    Then user should be able to view below columns in Service Level Edits
      | Line Number   |
      | Overridden By |
      | Description   |
      | Workaround    |
      | Resolution    |
      | Status        |
      | Category      |
      | Added By      |
      | Edit Number   |

  @44556
  Scenario: Verify Edit & Delete functionality in Service Level Edits Sub tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on Edits tab
    Then user should be able to view Delete action item highlighted in red color
    And user should be able to view Edit action item highlighted in blue color

  @44558
  Scenario: Verify Claim Level Edits Sub-tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
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

  @44561
  Scenario: Verify Edit & Delete functionality in Claim Level Edits Sub tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on Edits tab
    And user clicks on Claim Level Edits tab
    Then user should be able to view Delete action item highlighted in red color
    And user should be able to view Edit action item highlighted in blue color

  @45372
  Scenario: Validate Mouse hovering on the Inverted Exclamation Mark in Service Level Edits sub tab in the Edits tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on Edits tab
    And user hovers over Inverted Exclamation mark in Service Level Edits in Edits tab