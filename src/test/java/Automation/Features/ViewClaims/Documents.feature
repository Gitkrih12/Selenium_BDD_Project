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

  @49610
  @Sanity @beta
  Scenario: Verify column fields in Attachments sub tab
    When user clicking on Attachments Claim Number in Global Search page
    And user clicks on the Documents tab
    And user clicks on Attachments sub tab
    Then user able to view the below column fields under Attachments sub tab
      | File Name   |
      | Title       |
      | Description |
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

  @89486
  @Sanity
  Scenario: Verify user should navigate to the Upload Document window on clicking Upload Document button
    When user clicking on Attachments Claim Number in Global Search page
    And user clicks on the Documents tab
    And user clicks on Attachments sub tab
    When user clicks on Upload Document button in Attachments section
    Then user navigates to the "Upload Document" window

  @89502
  @Sanity
  Scenario: Verify user should be able to view all the fields in upload document window
    When user clicking on Attachments Claim Number in Global Search page
    And user clicks on the Documents tab
    And user clicks on Attachments sub tab
    When user clicks on Upload Document button in Attachments section
    Then user able to view the below mentioned fields under Upload Document window
      | Title       |
      | Category    |
      | Description |
    And user able to view the below buttons under Upload Document window
      | Cancel      |
      | Upload      |

  @89503
  @Sanity
  Scenario: Verify user able to upload the document successfully by entering all the required fields
    When user clicking on Attachments Claim Number in Global Search page
    And user clicks on the Documents tab
    And user clicks on Attachments sub tab
    When user clicks on Upload Document button in Attachments section
    When user enters all the required fields and click on upload button
    Then user able to view the toaster message "Success! File saved successfully"
    And user able to display the added document with all the details in the Attachments screen

  @89504
  @Sanity
  Scenario: Verify user throws an error message when Title is not entered
    When user clicking on Attachments Claim Number in Global Search page
    And user clicks on the Documents tab
    And user clicks on Attachments sub tab
    When user clicks on Upload Document button in Attachments section
    When Title is not entered in the Upload Document window
    Then user throws an error message as "Please enter Title"

  @89508
  @Sanity
  Scenario: Verify user throws an error message when Category is not selected
    When user clicking on Attachments Claim Number in Global Search page
    And user clicks on the Documents tab
    And user clicks on Attachments sub tab
    When user clicks on Upload Document button in Attachments section
    When Category is not selected in the Upload Document window
    Then user throws an error message as "Please select Category"

  @89513
  @Sanity
  Scenario: Verify user throws an error message when Description is not entered in field
    When user clicking on Attachments Claim Number in Global Search page
    And user clicks on the Documents tab
    And user clicks on Attachments sub tab
    When user clicks on Upload Document button in Attachments section
    When Description is not entered in the Upload Document window
    Then user throws an error message as "Please enter Description"

  @89514
  @Sanity
  Scenario: Verify user throws an error message when file is not chose
    When user clicking on Attachments Claim Number in Global Search page
    And user clicks on the Documents tab
    And user clicks on Attachments sub tab
    When user clicks on Upload Document button in Attachments section
    When File is not chose in the Upload Document window
    Then user throws an error message as "Please select file Document"