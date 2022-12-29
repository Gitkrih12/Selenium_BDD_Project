Feature: Validation History

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    When user clicking on Validation History Claim Number
    When user clicks on Validation History tab

  @82280
  Scenario: Verify user able to navigate to the Validation History tab
    Then user should navigates to the "Validation History" tab successfully

  @82283
  Scenario: Verify user able to view all the column fields under Validation History subtab
    Then user able to view the below mentioned fields under Validation History subtab
      | Date & Time      |
      | Service Line No. |
      | Activity         |
      | Description      |
      | Performed By     |

  @82285
  Scenario: Verify user able to view the search criteria for Date and Time
    When user searches for Date and Time in the field
    Then user able to view the Date and Time field value

  @82285-1
  Scenario: Verify user able to view the search criteria for Service Line No.
    When user searches for Service Line No in the field
    Then user able to view the Service Line No field value

  @82285-2
  Scenario: Verify user able to view the search criteria for Activity
    When user searches for Activity in the field
    Then user able to view the Activity field value

  @82285-3
  Scenario: Verify user able to view the search criteria for Description
    When user searches for Description in the field
    Then user able to view the Description field value

  @82285-4
  Scenario: Verify user able to view the search criteria for Performed By
    When user searches for Performed By in the field
    Then user able to view the Performed By field value

  @82902
  Scenario: Verify footer section available in Validation History tab
    Then user views the footer section in Validation History tab
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |