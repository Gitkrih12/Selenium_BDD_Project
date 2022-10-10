Feature: Documents

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @47215 @beta
  Scenario: Verify user should be able to see attached files and EDI files in Documents tab
    When user clicking on Claim Number in Global Search page
    And user clicks on the Documents tab
    Then user navigates to "Documents" tab
    And user able to view the two sub tabs as "EDI Files" and "Attachments"

  @47240 @beta
  Scenario: Verify user should be able to see footer section buttons
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
      | Deactivate        |

  @49610
  @Sanity @beta
  Scenario: Verify column fields in Attachments sub tab
    When user clicking on Attachments Claim Number in Global Search page
    And user clicks on the Documents tab
    And user clicks on Attachments sub tab
    Then user able to view the below column fields under Attachments sub tab
      | File Name   |
      | Title       |
      | Uploaded By |
      | Uploaded On |
    And user able to view the field values under Attachments sub tab

  @49613
  @Sanity @beta
  Scenario: Verify column fields in EDI files sub tab
    When user clicking on Claim Number in Global Search page
    And user clicks on the Documents tab
    Then user able to view the below column fields under EDI Files sub tab
      | File Name   |
      | File Type   |
      | Uploaded By |
      | Uploaded On |
    And user able to view the field values under EDI Files sub tab