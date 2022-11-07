Feature: Prior Authorization

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    When user clicks on Prior Authorization under Member Management

  @52287
  Scenario: Verify user able to view all the columns when user clicks on Prior Authorization under Member Management
    Then user navigates to the "Prior Authorization" successfully
    And user should be able to view the below column fields under Prior Authorization
      | Authorization Number |
      | Member ID            |
      | Member Name          |
      | From Date (DOS)      |
      | To Date (DOS)        |
      | Status               |

  @52288
  Scenario: Verify user able to search the criteria in the Prior Authorization for Authorization number
    When user enters the Authorization number and clicks on the Search button
    Then user able to view all the field values under Prior Authorization

  @52288-1
  Scenario: Verify user able to search the criteria in the Prior Authorization for Member ID
    When user enters the Member ID and clicks on Search button
    Then user able to view all the field values under Prior Authorization

  @52288-2
  Scenario: Verify user able to search the criteria in the Prior Authorization for Member Name
    When user enters the Member Name and clicks on Search button
    Then user able to view all the field values under Prior Authorization

#  @52288-3
#  Scenario: Verify user able to search the criteria in the Prior Authorization for From Date
#    When user enters the From Date and clicks on Search button
#    Then user able to view all the field values under Prior Authorization

#  @52288-4
#  Scenario: Verify user able to search the criteria in the Prior Authorization for To Date
#    When user enters the To Date and clicks on Search button
#    Then user able to view all the field values under Prior Authorization

  @52288-5
  Scenario: Verify user able to search the criteria in the Prior Authorization for Status
    When user enters the Status and clicks on Search button
    Then user able to view all the field values under Prior Authorization