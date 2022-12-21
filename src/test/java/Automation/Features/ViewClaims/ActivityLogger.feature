Feature: Activity Logger

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @42356
  @Sanity @beta
  Scenario: Verify user able to navigate to Activity Logger tab
    When user clicking on Claim Number in Global Search page
    And user clicks on the Activity Logger tab
    Then user able to navigate to the "Activity Logger" tab
    And user able to view the below mentioned fields in Activity Logger tab
      | Changeset        |
      | Performed Date   |
      | Status of Claims |
      | Activity         |
      | Description      |
      | Performed By     |
    And user able to view all the field values under Activity Logger tab

  @42359 @beta
  Scenario: Verify user able to navigate to Activity Logger tab and validated the buttons
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on the Activity Logger tab
    Then user able to view the below footer section in Activity Logger
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |