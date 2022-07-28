Feature: Provider Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @39950
  Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    Then user navigates to the Provider Details tab

  @39953
  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    Then user able to view the below sections under Provider Details tab
      | Pay to Provider details          |
      | Group/Rendering Provider Details |

  @39958
  Scenario: Verify user able to view all the fields under Pay to Provider Details section
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    Then user able to view all the fields under Pay to Provider Details section
      | Pay to Provider ID   |
      | Pay to Provider Name |
      | Tax ID/SSN           |
      | NPI                  |
      | Vendor ID            |
      | Vendor Validated     |
      | Address Line 1       |
      | City                 |
      | State                |
      | Zipcode              |

  @39961
  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    Then user able to view all the fields under Group Rendering Provider Details section
      | NPI              |
      | Name             |
      | Address          |
      | Effective Date   |
      | Termination Date |
      | Timely Filling   |
      | Sequestration    |
      | ProviderID       |
      | Contact Name     |

  @39974
  Scenario: Validate all the buttons available at the footer section under Provider Details tab
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on the Provider Details tab
    Then user views the footer section in Provider Details page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |

  @48990
  Scenario: Verify the user able to navigate to the A/R Transactions page on clicking Vendor ID in Provider details tab view
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    When clicking on Vendor ID in Provider Details
    Then user navigates to the AR Transactions page

  @47008
  Scenario: Verify user able to view the Credit/Overpaid and Debit/Underpaid status at the middle of the A/R Ledger
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    When clicking on Vendor ID in Provider Details
    Then user able to view Credit Overpaid and Debit Underpaid status as "Added to Account Receivable" "deducted to Account Receivable"

  @47013
  Scenario: Verify user able to view the available Account Review Transactions and all the columns in the A/R transaction details page
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    When clicking on Vendor ID in Provider Details
    Then user able to view all the below mentioned columns in Account Review Transactions page
      | Transaction Type       |
      | Transaction Date       |
      | Transaction Amount ($) |
      | Running Balance ($)    |
      | Transacted By          |
      | Claim Number           |
      | Recovery Claim Number  |
      | Remarks                |

  @47017
  Scenario: Verify Search box should display for all the columns on the A/R Transactions grid
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    When clicking on Vendor ID in Provider Details
    Then user able to view the search box for all the column on AR Transactions grid