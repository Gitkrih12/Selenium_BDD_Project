Feature: Provider Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @39950
  Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    Then user navigates to the Provider Details tab

  @39953
  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    Then user able to view the below sections under Provider Details tab
      | Pay to Provider details          |
      | Group/Rendering Provider Details |

  @39958
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

  @39961
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
      | Deactivate        |

  @48990
#  @Sanity
  Scenario: Verify the user able to navigate to the A/R Transactions page on clicking Vendor ID in Provider details tab view
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    When clicking on Vendor ID in Provider Details
    Then user navigates to the AR Transactions page

  @47008
  Scenario: Verify user able to view the Credit/Overpaid and Debit/Underpaid status at the middle of the A/R Ledger
    When user clicking on Claim Number in Global Search page
    And user clicks on the Provider Details tab
    When clicking on Vendor ID in Provider Details
    Then user able to view Credit Overpaid and Debit Underpaid status as "Credit/Overpaid - Added to Account Receivable" "Debit/Underpaid - deducted to Account Receivable"

  @47013
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

  @60783
  Scenario: Verify user able to view Map Pay To Provider button for ONHOLD Claims only
    Given the user is in FFS Professional page
    Then the user should navigate to the FFS Professional page
    When user clicks on Hold bucket
    And user clicks on Hold claim number in FFS Institutional page
    And user clicks on the Provider Details tab
    Then user able to view Map Pay To Provider button

  @60789
  Scenario: Verify user able to view the Map Pay to Provider side drawer on clicking the Map Pay To Provider button
    Given the user is in FFS Professional page
    Then the user should navigate to the FFS Professional page
    When user clicks on Hold bucket
    And user clicks on Hold claim number in FFS Institutional page
    And user clicks on the Provider Details tab
    When user clicks on Map Pay To Provider button
    Then user navigates to the Map Pay To Provider side drawer

  @60810
  Scenario: Verify user able to view all the fields in Map Pay To Provider Side drawer
    Given the user is in FFS Professional page
    Then the user should navigate to the FFS Professional page
    When user clicks on Hold bucket
    And user clicks on Hold claim number in FFS Institutional page
    And user clicks on the Provider Details tab
    When user clicks on Map Pay To Provider button
    Then user able to view the below headers under Map Pay To Provider side drawer
      | Tax ID          |
      | Pay to Provider |
      | Default Vendor  |
    And user able to view the below fields under Map Pay To Provider
      | Vendor ID       |
      | Pay To Name     |
      | NPI             |
      | Address         |

  @60830
  Scenario: Verify user should not be able to view the select option and Green bar should display for the default Vendor ID
    Given the user is in FFS Professional page
    Then the user should navigate to the FFS Professional page
    When user clicks on Hold bucket
    And user clicks on Hold Muliple Vendor claim number in FFS Institutional page
    And user clicks on the Provider Details tab
    When user clicks on Map Pay To Provider button
    When user views the multiple Vendors for the claim
    Then user able to view the select button for all the Vendor ID except for the default Vendor ID
    And green bar should display for the default Vendor ID

  @60846
  Scenario: Verify user able to select the default Vendor ID on clicking the Select button
    Given the user is in FFS Professional page
    Then the user should navigate to the FFS Professional page
    When user clicks on Hold bucket
    And user clicks on Hold claim number in FFS Institutional page
    And user clicks on the Provider Details tab
    When user clicks on Map Pay To Provider button
    And user clicks on Select button for the other Vendor ID
    Then user able to view the Vendor ID by default after selected

  @60848
  Scenario: Verify user able to view the pagination, cancel and close buttons for Map Pay To Provider Side Drawer
    Given the user is in FFS Professional page
    Then the user should navigate to the FFS Professional page
    When user clicks on Hold bucket
    And user clicks on Hold claim number in FFS Institutional page
    And user clicks on the Provider Details tab
    When user clicks on Map Pay To Provider button
    Then user able to view the cancel, close buttons at the bottom and top of the side drawer
    And user able to view the Pagination buttons

  @60855
  Scenario: Verify user able to perform click functionality on cancel and close buttons
    Given the user is in FFS Professional page
    Then the user should navigate to the FFS Professional page
    When user clicks on Hold bucket
    And user clicks on Hold claim number in FFS Institutional page
    And user clicks on the Provider Details tab
    When user clicks on Map Pay To Provider button
    And user clicks on Close button
    Then user navigates back to the Provider details
    When user clicks on Map Pay To Provider button
    And user clicks on Select button for the other Vendor ID
    And user clicks on Cancel button
    Then user navigates back to the Provider details