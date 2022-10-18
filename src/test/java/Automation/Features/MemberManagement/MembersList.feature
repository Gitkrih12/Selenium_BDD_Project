Feature: Members List

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @52275
  Scenario: Verify user able to view all the columns on clicking Members List from Member Management
    When user clicks on Members List under Member Management
    Then user navigates to Members List page
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
    When user clicks on Members List under Member Management
    And user enters Member ID in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters Last Name in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters First Name in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters Middle Name in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters DOB in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters Gender in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters MBI in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters Provider ID in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters PCP in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters Plan in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters Eff Date in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters Term Date in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters Address in the Search criteria
    Then user able to view the appropriate results on Members List screen
    When user enters Status in the Search criteria
    Then user able to view the appropriate results on Members List screen