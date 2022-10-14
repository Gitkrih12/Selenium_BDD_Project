Feature: Provider Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @39950
  Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    Then user navigates to the Provider Details tab

  @39953 @beta
  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    Then user able to view the below sections under Provider Details tab
      | Pay to Provider details          |
      | Group/Rendering Provider Details |

  @39958 @beta
#  @Sanity
  Scenario: Verify user able to view all the fields under Pay to Provider Details section
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    Then user able to view all the fields under Pay to Provider Details section
      | Pay to Provider ID   |
      | Pay to Provider Name |
      | Tax ID/SSN           |
      | NPI                  |
      | Vendor ID            |
      | Vendor Validated     |
      | Address Line 1       |
      | Address Line 2       |
      | City                 |
      | State                |
      | Zipcode              |
    And user able to view all the field values under Pay to Provider Details section

  @39961 @beta
#  @Sanity
  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    When user clicking on Claim Number in Global Search page
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
      | Contract Name    |
    And user able view all the field values under Group Rendering Provider Details section

  @39974 @beta
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
      | Deactivate        |

  @48990
#  @Sanity
  Scenario: Verify the user able to navigate to the A/R Transactions page on clicking Vendor ID in Provider details tab view
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    When clicking on Vendor ID in Provider Details
    Then user navigates to the AR Transactions page

  @47008 @beta
  Scenario: Verify user able to view the Credit/Overpaid and Debit/Underpaid status at the middle of the A/R Ledger
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    When clicking on Vendor ID in Provider Details
    Then user able to view Credit Overpaid and Debit Underpaid status as "Credit/Overpaid - Added to Account Receivable" "Debit/Underpaid - deducted to Account Receivable"

  @47013 @beta
  Scenario: Verify user able to view the available Account Review Transactions and all the columns in the A/R transaction details page
    When user clicking on Claim Number in Global Search page
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
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    When clicking on Vendor ID in Provider Details
    Then user able to view the search box for all the column on AR Transactions grid


  @55171
  Scenario: Verify Location Information tab in Provider Details screen
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    When user clicks on Provider ID under Group Rendering Provider Details
    And user clicks on Location Information subtab
    Then user navigates to "Location Information" subtab
    And user able to view the following fields under Practice Location List
      | Effective Date    |
      | Term Date         |
      | Practice Name     |
      | Practice Location |
      | City              |
      | ST                |
      | ZIP               |
      | County            |
      | Status            |

  @55200

  @55205
  Scenario: Verify Contract Information tab in Provider Details screen
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    When user clicks on Provider ID under Group Rendering Provider Details
    And user clicks on Contract Information subtab
    Then user navigates to "Contract Information" subtab
    And user able to view the following fields under Contract List
      | Effective Date       |
      | Term                 |
      | Tax ID               |
      | Plan                 |
      | Network ID           |
      | Contract             |
      | Sequestration        |
      | Provider Type        |
      | Timely Filling(Days) |
      | Status               |
