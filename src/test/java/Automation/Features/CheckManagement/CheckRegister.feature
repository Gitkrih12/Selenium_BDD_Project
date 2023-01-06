Feature: Check Register

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @60694
  @Sanity
  Scenario: Verify user navigates to Check Register page
    When user clicks on Check Register under Check Management
    Then user able to navigate to the Check Register page

  @60696
  @Sanity @beta
  Scenario: Verify fields in Check Register page
    When user clicks on Check Register under Check Management
    Then user able to view all the below mentioned fields under Check Register
      | Billing Details  |
      | Billing Provider |
      | Created Date     |
      | Service Details  |
      | Place of Service |
      | Date Of Service  |
      | Location Details |
      | Facility         |
      | City             |
      | State            |
      | Zip              |

  @60701
  @Sanity @beta
  Scenario: Verify user should get result on selecting value from Billing Provider drop down field
    When user clicks on Check Register under Check Management
    And user select value from Billing Provider dropdown field
    Then user able to view the result for the search criteria

  @60703
  @Sanity @beta
  Scenario: Verify user should get result on selecting value from Facility drop down field
    When user clicks on Check Register under Check Management
    And user select value from Facility dropdown field
    Then user able to view the result for the facility dropdown search criteria

  @60710
  @Sanity
  Scenario: Verify user should get result on selecting dates from Created Date From and To fields
    When user clicks on Check Register under Check Management
    And user select dates from Created Date From and To dropdown field
    Then user able to view the result for the Created Date dropdown search criteria

  @60711
  @Sanity @test
  Scenario: Verify user should get result on selecting dates from the Date of Service From and To values
    When user clicks on Check Register under Check Management
    And user select dates from Date of Service From and To dropdown field
    Then user able to view the result for the Date of Service dropdown search criteria

  @60713
  @Sanity
  Scenario: Verify user should get result on selecting value from State drop down field
    When user clicks on Check Register under Check Management
    And user select value from State dropdown field
    Then user able to view the result for the State dropdown search criteria