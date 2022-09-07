Feature: FFS Institutional

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

    #38960-As an adjudicator, I should be able to view FFS Institutional claims page with all claims details data so that I can search specific claim id details adding applicable filters

  @TC_39790
  Scenario: Verify user should navigates to FFS Institutional screen
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page

  @TC_63564
  Scenario: Verify by default user should be in the Pend state in FFS Institutional screen
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page
    And by default user should be in Pend state results page in FFS Institutional page

  @TC_39787
  Scenario: Verify user should able to see Clam List Label in FFS Institutional screen
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page
    And user should be able to view the Clam List Label in the FFS Institutional screen

  @TC_39665
  Scenario: Validate user able to view all the column fields in FFS Institutional screen
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page
    When user views Pend bucket by default should be "active" in FFS Institutional page
    Then user able to view following column fields in Pend bucket in FFS Institutional page
      | Claim Number           |
      | Patient                |
      | Member ID              |
      | Billing Provider       |
      | Rendering Provider     |
      | Rendering Provider NPI |
      | DOS From               |
      | DOS To                 |
      | Total Charges($)       |
      | Net Pay Amt($)         |
      | Received Date          |
      | Age                    |
      | Assigned To            |

  @TC_39666
  Scenario: Verify all the queue field details in the FFS Institutional page
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page
    And user should be able to view following queue detail fields in FFS Institutional page
      | Pend              |
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Approved          |
      | Denied            |
      | Pre Batch         |
      | Batch to Pay      |
      | Paid              |
      | Draft             |
      | Rejected          |

  @TC_39786
  Scenario: Verify user able to view the search fields under each columns in the FFS Institutional screen
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page
    And user able to view the Search fields under each column in FFS Institutional page

  @TC_39699
  Scenario: Verify Pagination in FFS Institutional page
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page
    When user enters the member id in the search field in FFS Institutional page
    Then user able to view the claim details for given member id in FFS Institutional page
    When user get the total records for the search criteria in FFS Institutional page
    Then user should be able to view the total results count at the bottom of the page in FFS Institutional page

  @TC_63758
  Scenario: Verify user see the page numbers as per the no of data divided by pages size
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page
    When user enters the member id in the search field in FFS Institutional page
    Then user able to view the claim details for given member id in FFS Institutional page
    When user get the total records for the search criteria in FFS Institutional page
    Then user see the page numbers as per the no of data divided by pages size in FFS Institutional page

  @TC_63813
  Scenario: Verify user able to navigate through pages by using Pagination functionality
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page
    When user clicks on On Hold bucket in FFS Institutional
    And user should be able to view the page numbers at bottom of the page in FFS Institutional page
    When user tries to click on next arrow symbol in FFS Institutional
    And user allow to navigates to next page in FFS Institutional
    When user tries to click on back arrow symbol in FFS Institutional
    Then user should allow to navigates to back page in FFS Institutional