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
    Then user able to view the Authorization field value under Prior Authorization

  @52288-1
  Scenario: Verify user able to search the criteria in the Prior Authorization for Member ID
    When user enters the Member ID and clicks on Search button
    Then user able to view the Member ID field value under Prior Authorization

  @52288-2
  Scenario: Verify user able to search the criteria in the Prior Authorization for Member Name
    When user enters the Member Name and clicks on Search button
    Then user able to view the Member Name field value under Prior Authorization

  @52288-3
  Scenario: Verify user able to search the criteria in the Prior Authorization for From Date
    When user enters the From Date and clicks on Search button
    Then user able to view the From Date field value under Prior Authorization

  @52288-4
  Scenario: Verify user able to search the criteria in the Prior Authorization for To Date
    When user enters the To Date and clicks on Search button
    Then user able to view the To Date field value under Prior Authorization

  @52288-5
  Scenario: Verify user able to search the criteria in the Prior Authorization for Status
    When user enters the Status and clicks on Search button
    Then user able to view the Status field value under Prior Authorization

  @74550
  Scenario: Verify Authorization summary pop up should display on clicking Authorization number
    When user enters the Authorization number and clicks on the Search button
    And user clicks on Authorization number
    Then user able to view "AUTHORIZATION SUMMARY" pop up
    And user able to view the "PLAN AUTH NUMBER"

  @74622
  Scenario: Verify all the legends should display in the Authorization summary pop up
    When user enters the Authorization number and clicks on the Search button
    And user clicks on Authorization number
    Then user able to view all the below legends in Authorization summary pop up
      | MEMBER INFORMATION       |
      | AUTH DETAILS             |
      | REQUESTING PROVIDER (IN) |
      | ATTENDING PROVIDER (IN)  |
      | ADMITTING PROVIDER (IN)  |
      | FACILITY (IN)            |
      | ADMISSION/DC DATES       |
      | LENGTH OF STAY           |
      | PRIMARY ICD DETAILS      |
      | CPT/HCPCS Code           |
      | Documents                |

  @74737
  Scenario: Verify all fields under Member Information section
    When user enters the Authorization number and clicks on the Search button
    And user clicks on Authorization number
    Then user able to view the below fields under Member Information section in Authorization Summary
      | REF#     |
      | MBR#     |
      | MBR NAME |
      | DOB      |
      | PH:      |
      | GENDER   |
      | AGE      |
      | PLAN     |
      | CNTY     |
      | EFF DATE |
      | PCP      |
      | PCP PH   |
      | PCP FAX  |
    And user able to view all the field values under Member Information section in Authorization summary