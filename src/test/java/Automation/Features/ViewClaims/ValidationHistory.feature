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
    When user searches for Date and Time field
    Then user able to view the search criteria for Date and Time