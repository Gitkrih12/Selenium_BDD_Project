Feature: FFS Professional

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  #41481- As an adjudicator, I should be able to view Corrected colour codings in the FFS Professional page so that I can easily identify the corrected claims details
  @TC_42519
  Scenario: Verify color code for corrected claims in FFS Professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters Corrected claim in FFS Professional search criteria
    Then user should able to view corrected claim in FFS Professional Grid
    And user should able to see vertical line beside claim number with color code "#AD71FF" in FFS Professional page
    And color indication information should be available on top of grid in FFS Professional page

  @TC_42549
  Scenario: Verify color code for COB In Member House in FFS Professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters COB In Member House claim in search criteria
    Then user should able to view COB In Member House claim
    And user should able to view patient name with color code "#008000" in FFS Professional page
    And color indication information for COB In Member House should be available on top of grid

  @TC_42606
  Scenario: Verify color code for COB Not In Member House in FFS Professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters COB Not In Member House claim in search criteria
    Then user should able to view COB Not In Member House claim
    And user should able to view patient name with color code "#FF0000" in FFS Professional page
    And color indication information for COB Not In Member House should be available on top of grid

  #40714-As an adjudicator, I should be able to click on any Claim number from FFS Professional queue and get navigated to appropriate claims details page
  @TC_46665
  Scenario:Verify user able to navigate to claim summary screen on clicking claim number in FFS Professional Queue page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user clicks on claim number in FFS Professional page
    Then user should be able to navigate to View Claim Details page
    And  User should see "Hide" option with Claim summary

  @TC_46666
  Scenario: Verify user able to navigate to claim summary screen only once when performed multiple clicks on Claim number
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user searches for claim number in pend bucket
    And user clicks on claim number
    Then user should be able to navigate to View Claim Details page and get the claim details
    When user clicks on the same claim number again in pend bucket
    Then user should be able to see already opened claim details
    And  User should see "Hide" option with Claim summary

    #53039-As an Adjudicator, When the claim is in Unclean status I want the claim to be displayed and highlighted in the Orange bar.
  @TC_53451
  Scenario: Verify colour coding for Unclean status claims under Pend bucket in FFS professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters Unclean status claim in search criteria in Pend bucket
    Then user should able to view Unclean status claim in FFS Professional Grid
    And user should able to see vertical line beside unclean status Pend claim number with color code "#FFC33E" in FFS Professional
    And color indication information for Unclean should be available on top of grid in FFS Professional

  @TC_58907
  Scenario: Verify colour coding for Unclean status claims under Payer Review bucket in FFS professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user clicks on Payer Review bucket
    When user enters Unclean status claim in search criteria in Payer Review bucket
    Then user should able to view Unclean status Payer Review claim in FFS Professional Grid
    And user should able to see vertical line beside unclean status Payer Review claim number with color code "#FFC33E" in FFS Professional
    And color indication information for Unclean should be available on top of grid in FFS Professional

  @TC_59185
  Scenario: Verify colour coding for Unclean status claims under Management Review bucket in FFS professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user clicks on Management Review bucket
    When user enters Unclean status claim in search criteria in Management Review bucket
    Then user should able to view Unclean status Management Review claim in FFS Professional Grid
    And user should able to see vertical line beside unclean status Management Review claim number with color code "#FFC33E" in FFS Professional
    And color indication information for Unclean should be available on top of grid in FFS Professional

  @TC_59209
  Scenario: Verify colour coding for Unclean status claims under Approved bucket in FFS professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user clicks on Approved bucket
    When user enters Unclean status claim in search criteria in Approved bucket
    Then user should able to view Unclean status Approved claim in FFS Professional Grid
    And user should able to see vertical line beside unclean status Approved claim number with color code "#FFC33E" in FFS Professional
    And color indication information for Unclean should be available on top of grid in FFS Professional

  @TC_59218
  Scenario: Verify colour coding for Unclean status claims under Denied bucket in FFS professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user clicks on Denied bucket
    When user enters Unclean status claim in search criteria in Denied bucket
    Then user should able to view Unclean status Denied claim in FFS Professional Grid
    And user should able to see vertical line beside unclean status Denied claim number with color code "#FFC33E" in FFS Professional
    And color indication information for Unclean should be available on top of grid in FFS Professional

  @TC_59220
  Scenario: Verify colour coding for Unclean status claims under Pre Batch bucket in FFS professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user clicks on Pre Batch bucket
    When user enters Unclean status claim in search criteria in Pre Batch bucket
    Then user should able to view Unclean status Pre Batch claim in FFS Professional Grid
    And user should able to see vertical line beside unclean status Pre Batch claim number with color code "#FFC33E" in FFS Professional
    And color indication information for Unclean should be available on top of grid in FFS Professional

  #38954-As an adjudicator, I should be able to view FFS professional claims page with all claims details data so that I can search specific claim id details adding applicable filters
  @TC_60398
  Scenario: Verify user should navigates to FFS Professional screen
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page

  @TC_58787
  Scenario: Verify by default user should be in the Pend state in FFS Professional screen
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    And by default user should be in Pend state results page

  @TC_61065
  Scenario: Verify user should able to see Clam List Label in FFS Professional screen
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    And user should be able to view the Clam List Label in the FFS Professional screen

  @TC_39049
  Scenario: Validate user able to view all the column fields for Pend bucket in FFS Professional screen
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user views Pend bucket by default should be "active"
    Then user able to view following column fields in Pend bucket
      | Claim Number           |
      | Patient                |
      | Member ID              |
      | Billing Provider       |
      | Rendering Provider     |
      | Rendering Provider NPI |
      | DOS From               |
      | DOS To                 |
      | Total Charges($)       |
    And user able to view the "Net Pay Amt($)", "Received Date", "Age" and "Assigned To" column fields in FFS Professional pend bucket

  @TC_58744
  Scenario: Verify all the queue field details in the FFS Professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    And user should be able to view following queue detail fields
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

  @TC_39057
  Scenario: Validate pagination in FFS Professional page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters the member id in the search field in FFS Professional page
    Then user able to view the claim details for given member id in FFS Professional page
    When user get the total records for the search criteria in FFS Professional page
    Then user should be able to view the total results count at the bottom of the page in FFS Professional page

  @TC_59656
  Scenario: Verify user see the page numbers as per the no of data divided by pages size
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters the member id in the search field in FFS Professional page
    Then user able to view the claim details for given member id in FFS Professional page
    When user get the total records for the search criteria in FFS Professional page
    Then user see the page numbers as per the no of data divided by pages size in FFS Professional page

  @TC_39435
  Scenario: Verify user able to navigate through pages by using Pagination functionality
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user clicks on On Hold bucket
    And user should be able to view the page numbers at bottom of the page in FFS Professional page
    When user tries to click on next arrow symbol in FFS Professional
    And user allow to navigates to next page in FFS Professional
    When user tries to click on back arrow symbol in FFS Professional
    Then user should allow to navigates to back page in FFS Professional

  @TC_39686
  Scenario: Verify user able to view the search fields under each columns in the FFS Professional screen
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    And user able to view the Search fields under each column in FFS Professional page
    And user able to view the search fields under Received Date, Age and Assigned To column fields

