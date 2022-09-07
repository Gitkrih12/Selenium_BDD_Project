Feature: AR Ledger

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @46714
  Scenario: Verify user able to navigate to A/R Ledger page from the Account Management grid in Left navigation panel
    When user clicks on AR Ledger on the left navigation panel
    Then user able to navigates to the "A/R Ledger" page

  @46716
  @Sanity
  Scenario: Verify user able to view all the column details in the A/R Ledger page
    When user clicks on AR Ledger on the left navigation panel
    Then user able to view "Add A/R Transaction" button
    And user able to view Search Vendor "Enter Claim Number To Search Vendor"
    And user able to view the column fields under AR Ledger
      | Vendor ID    |
      | Vendor Name  |
      | Tax ID / SSN |
      | Amount($)    |
      | Created On   |

  @46720
  Scenario: Verify Search box should display for all the columns on the grid
    When user clicks on AR Ledger on the left navigation panel
    Then user able to view the Search criteria for all the columns under AR Ledger

  @46725
  Scenario: Verify when user enters the data in search criteria to display the appropriate results
    When user clicks on AR Ledger on the left navigation panel
    And user enters the Vendor ID in Search criteria
    Then user able to view the appropriate results
    When user enters the Vendor Name in Search criteria
    Then user able to view the appropriate results
    When user enters the Tax ID in Search criteria
    Then user able to view the appropriate results
    When user enters the Amount in Search criteria
    Then user able to view the appropriate results
    When user enters the Created On in Search criteria
    Then user able to view the appropriate results

  @46979
  Scenario: Verify user navigates to the A/R Transaction claim details on clicking Vendor ID and validates all the fields
    When user clicks on AR Ledger on the left navigation panel
    And user clicks on Vendor ID in AR Ledger page
    Then user navigates to the AR Transactions page
    And user able to view Credit Overpaid and Debit Underpaid status as "Credit/Overpaid - Added to Account Receivable" "Debit/Underpaid - deducted to Account Receivable"
    Then user able to view all the below mentioned columns in Account Review Transactions page
      | Transaction Type       |
      | Transaction Date       |
      | Transaction Amount ($) |
      | Running Balance ($)    |
      | Transacted By          |
      | Claim Number           |
      | Recovery Claim Number  |
      | Remarks                |
    Then user able to view the search box for all the column on AR Transactions grid