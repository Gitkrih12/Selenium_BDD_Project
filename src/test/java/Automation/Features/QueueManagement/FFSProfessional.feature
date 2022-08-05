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


  #38954-As an adjudicator, I should be able to view FFS professional claims page with all claims details data so that I can search specific claim id details adding applicable filters
  @TC_58787
  Scenario: Verify by default user should be in the Pend state in FFS Professional screen
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    And by default user should be in Pend state results page

  @TC_39049
  Scenario: Validate user able to view all the column fields for Pend bucket in FFS Professional screen
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user views Pend bucket by default should be "active"
    Then user able to view following column fields
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




