Feature: CAP Institutional

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  #38961-As an adjudicator, I should be able to view CAP Institutional claims page with all claims details data. So that, I can able to search specific claim id and I can able to add applicable filters.
  @TC_37095
  Scenario: Verify when user clicks on CAP Institutional page on the left navigation pane
    When user clicks on CAP Institutional in left navigation menu
    Then the user should navigate to the CAP Institutional page

  @TC_37096
  Scenario: Verify by default user should be in the Pend state field results page
    When user clicks on CAP Institutional in left navigation menu
    Then the user should navigate to the CAP Institutional page
    And by default user should be in Pend state results page in CAP Institutional page


  @TC_64920
  Scenario: Verify user should able to see Clam List Label in CAP Institutional screen
    When user clicks on CAP Institutional in left navigation menu
    Then the user should navigate to the CAP Institutional page
    And user should be able to view the Clam List Label in the CAP Institutional screen

  @TC_37106
  Scenario: Validate user able to view all the column fields in CAP Institutional screen
    When user clicks on CAP Institutional in left navigation menu
    Then the user should navigate to the CAP Institutional page
    When user views Pend bucket by default should be "active" in CAP Institutional page
    Then user able to view following column fields in Pend bucket in CAP Institutional page
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

  @TC_37104
  Scenario: Verify all the queue field details in the CAP Institutional page
    When user clicks on CAP Institutional in left navigation menu
    Then the user should navigate to the CAP Institutional page
    And user should be able to view following queue detail fields in CAP Institutional page
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

  @TC_37144
  Scenario: Verify user able to view the search fields under each columns in the CAP Institutional screen
    When user clicks on CAP Institutional in left navigation menu
    Then the user should navigate to the CAP Institutional page
    And user able to view the Search fields under each column in CAP Institutional page

  @TC_37147
  Scenario: Validate the pagination field in CAP Institutional page
    When user clicks on CAP Institutional in left navigation menu
    Then the user should navigate to the CAP Institutional page
    When user enters the member id in the search field in CAP Institutional page
    Then user able to view the claim details for given member id in CAP Institutional page
    When user get the total records for the search criteria in CAP Institutional page
    Then user should be able to view the total results count at the bottom of the page in CAP Institutional page

  @TC_65393
  Scenario: Verify user see the page numbers as per the no of data divided by pages size
    When user clicks on CAP Institutional in left navigation menu
    Then the user should navigate to the CAP Institutional page
    When user clicks on On Hold bucket in CAP Institutional
    And user should be able to view the page numbers at bottom of the page in CAP Institutional page
    When user tries to click on next arrow symbol in CAP Institutional
    And user allow to navigates to next page in CAP Institutional
    When user tries to click on back arrow symbol in CAP Institutional
    Then user should allow to navigates to back page in CAP Institutional
