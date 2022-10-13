Feature: Upload Files

# Author: Sreenivasulu Boyapati

  Background:
#  DSNP Adjudicator login (Non admin)
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    When user click on Upload files in left navigation menu
    Given the user is on the "Upload Files" tab
    Then user should navigate to Upload files screen successfully and view message "Drag Files Here or Choose File"

#  @56662
#  Scenario: Verify user navigates to Upload files section on clicking Upload Files in Left Navigation Menu
## The steps are covered under background section already

  @56663 @Sanity
  Scenario: Verify user should see Drag Files Here (or) Choose File option and able to select files
    Then the user should be able to choose 837 file or files from the system

  @56664 @Sanity
  Scenario: Verify user should see chosen files/dragged files in the 'Total File Selected' Grid and upload files
    Then the user should be able to choose 837 file or files from the system
    And the user should be able to see chosen files or dragged files in the Total File Grid
    And the user should be able to enter the Plan Received Date
    And the user should be able to click on upload file button to upload files

  @56665 @Sanity
  Scenario: Verify Total File Selected section
    Then the user should be able to choose multiple 837 files from the system
    And the user should be able to see the list of the files in the Total File section

  @55983 @Sanity
  Scenario: Verify Invalid Payer ID File message Identified by system in red color
    Then the user should be able to choose invalid 837 file or files from the system
    And the user should be able to enter the Plan Received Date
    And the user should be able to click on upload file button to upload invalid files
    Then user should view invalid payer id error message

  @67439
  Scenario: Verify user able to see Total File, File Name and Plan Received Date fields on upload files page
    Then the user should be able to choose 837 file or files from the system
    Then user should be able to see following fields on file upload page
      | Total File         |
      | File Name          |
      | Plan Received Date |

  @56666
  Scenario: Verify Plan Received Date field in total File Selected section
    Then the user should be able to choose 837 file or files from the system
    Then the user should be able to enter Plan Received date on or before today's date

  @67749
  Scenario: verify user able to delete the selected file on file upload page
    Then the user should be able to choose 837 file or files from the system
    And user should be able to delete the selected file from the file upload page

  @67755
  Scenario: verify user able to cancel the selected files on file upload page
    Then the user should be able to choose multiple 837 files from the system
    Then user should be able to cancel all the selected files on files upload page

  @68541 @Sanity
  Scenario: verify user should NOT be able to upload any file with future date
    Then the user should be able to choose 837 file or files from the system
    Then the user enters future plan received date on file upload page
    Then user should be able to view "Plan received date should not be greater than to today's date" error message
