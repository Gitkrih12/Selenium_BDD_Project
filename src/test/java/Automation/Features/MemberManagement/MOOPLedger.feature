Feature: MOOP Ledger

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @52338
  @Sanity
  Scenario: Verify user able to view all the columns when user clicks on MOOP Ledger under Member Management
    When user clicks on MOOP Ledger under Member Management
    Then user navigates to the "Moop Ledger" page successfully
    And user able to view the below mentioned column fields under MOOP Ledger
      | Member ID       |
      | Member Name     |
      | MOOP Year       |
      | Copay ($)       |
      | Coinsurance ($) |
      | Deductible ($)  |
      | Moop Total($)   |
      | Max Moop Limit  |
    And user able to view the Search criteria in Moop Ledger

  @52371
  @Sanity
  Scenario: Verify user clicks on 'Member ID' from the MOOP Ledger
    When user clicks on MOOP Ledger under Member Management
    And user clicks on Member ID
    Then user navigates to the Moop Transaction tabs
    And user able to view the below mentioned fields under Moop Transaction page
      | Claim Number          |
      | Type of coverage      |
      | Network Affiliation   |
      | Member Responsibility |
      | Moop Amount ($)       |
      | Transaction Date      |
      | Transaction By        |
      | Remarks               |
      | Type Of Coverage      |
      | Network Affiliation   |
      | Deductible            |
      | Copay ($)             |
      | Coinsurance ($)       |
      | Total Amount ($)      |
      | Moop Year             |
      | Max Moop Year         |
    Then user able view the field values under Moop Transaction page

  @52401
  Scenario: Verify the search criteria in Claim level 'MOOP Trasaction'
    When user clicks on MOOP Ledger under Member Management
    And user clicks on Member ID
    Then user able to view the Search criteria under Moop Transaction page