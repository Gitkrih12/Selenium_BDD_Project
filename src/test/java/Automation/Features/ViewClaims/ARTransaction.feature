Feature: AR Transaction

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @52209
  Scenario: Verify user able to Navigate to the A/R Transaction tab from Global Search
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the AR Transaction tab
    Then user navigates to the "AR Transaction" tab
    And user able to view the below mentioned fields under AR Transaction tab
      | Transaction Type       |
      | Transaction Date       |
      | Transaction Amount ($) |
      | Running Balance ($)    |
      | Transacted By          |
      | Claim Number           |
      | Recovery Claim Number  |
      | Remarks                |

  @52219
  Scenario: Verify Buttons in A/R Transaction tab
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on the AR Transaction tab
    Then user views the footer section in AR Transactions page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |
      | Deactivate        |