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
      | Middel Name |
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