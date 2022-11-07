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
      | LastName    |
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
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Member ID in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-1
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Last Name in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-2
  Scenario: Verify user able to Search Member in the Search Box
    When user enters First Name in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-3
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Middle Name in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-4
  Scenario: Verify user able to Search Member in the Search Box
    When user enters DOB in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-5
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Gender in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-6
  Scenario: Verify user able to Search Member in the Search Box
    When user enters MBI in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-7
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Provider ID in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-8
  Scenario: Verify user able to Search Member in the Search Box
    When user enters PCP in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-9
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Plan in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-10
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Eff Date in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-11
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Term Date in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-12
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Address in the Search criteria
    Then user able to view the appropriate results on Members List screen

  @52277-13
  Scenario: Verify user able to Search Member in the Search Box
    When user enters Status in the Search criteria
    Then user able to view the appropriate results on Members List screen