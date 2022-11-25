Feature: Members List

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    When user clicks on Members List under Member Management

  @52275
  Scenario: Verify user able to view all the columns on clicking Members List from Member Management
    Then user navigates to "Members List" page
    And user able to view all the below mentioned columns under Members List
      | Member ID   |
      | Last Name   |
      | First Name  |
      | Middle Name |
      | DOB         |
      | Gender      |
      | MBI         |
      | Provider ID |
      | PCP         |
      | PCP Phone   |
      | Plan        |
      | Eff. Date   |
      | Term. Date  |
      | Address     |
      | Status      |

  @52277
  Scenario: Verify user able to Search Member in the Search Box for Member ID
    When user enters Member ID in the Search criteria
    Then user able to view the appropriate results with Member ID

  @52277-1
  Scenario: Verify user able to Search Member in the Search Box for Last Name
    When user enters Last Name in the Search criteria
    Then user able to view the appropriate results with Last Name

  @52277-2
  Scenario: Verify user able to Search Member in the Search Box for First Name
    When user enters First Name in the Search criteria
    Then user able to view the appropriate results with First Name

  @52277-3
  Scenario: Verify user able to Search Member in the Search Box for Middle Name
    When user enters Middle Name in the Search criteria
    Then user able to view the appropriate results with Middle Name

  @52277-4
  Scenario: Verify user able to Search Member in the Search Box for DOB
    When user enters DOB in the Search criteria
    Then user able to view the appropriate results with DOB

  @52277-5
  Scenario: Verify user able to Search Member in the Search Box for Gender
    When user enters Gender in the Search criteria
    Then user able to view the appropriate results with Gender

  @52277-6
  Scenario: Verify user able to Search Member in the Search Box for MBI
    When user enters MBI in the Search criteria
    Then user able to view the appropriate results with MBI

  @52277-7
  Scenario: Verify user able to Search Member in the Search Box for Provider ID
    When user enters Provider ID in the Search criteria
    Then user able to view the appropriate results with Provider ID

  @52277-8
  Scenario: Verify user able to Search Member in the Search Box for PCP
    When user enters PCP in the Search criteria
    Then user able to view the appropriate results with PCP

  @52277-9
  Scenario: Verify user able to Search Member in the Search Box for Plan
    When user enters Plan in the Search criteria
    Then user able to view the appropriate results with Plan

  @52277-10
  Scenario: Verify user able to Search Member in the Search Box for Eff Date
    When user enters Eff Date in the Search criteria
    Then user able to view the appropriate results with Eff Date

  @52277-11
  Scenario: Verify user able to Search Member in the Search Box for Term Date
    When user enters Term Date in the Search criteria
    Then user able to view the appropriate results with Term Date

  @52277-12
  Scenario: Verify user able to Search Member in the Search Box for Address
    When user enters Address in the Search criteria
    Then user able to view the appropriate results with Address

  @52277-13
  Scenario: Verify user able to Search Member in the Search Box for Status
    When user enters Status in the Search criteria
    Then user able to view the appropriate results with Status