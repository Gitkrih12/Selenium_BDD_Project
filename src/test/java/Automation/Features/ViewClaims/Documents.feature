Feature: Claim Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @47215
  Scenario: Verify user should able to see attached files and EDI files in Documents tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Documents tab
    Then user navigates to "Documents" tab
    And user able to view the two sub tabs as "EDIFiles" and "Attachments"

  @47240
  Scenario: Verify user should able to see footer section buttons
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on the Documents tab
    Then user views the footer section in Documents page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |

  @49610
  Scenario: Verify column fields in Attachments sub tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Documents tab
    Then user able to view the below column fields under Attachments sub tab
      | File Name   |
      | Title       |
      | Uploaded By |
      | Uploaded On |

  @49613
  Scenario: Verify column fields in EDI files sub tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Documents tab
    Then user able to view the below column fields under EDI Files sub tab
      | File Name   |
      | File Type   |
      | Uploaded By |
      | Uploaded On |