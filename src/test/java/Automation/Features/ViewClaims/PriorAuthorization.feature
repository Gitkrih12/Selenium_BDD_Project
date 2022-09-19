Feature: Prior Authorization

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @46222
  Scenario: Verify user navigate to Prior Authorization tab from Global Search
    When user clicking on Claim Number in Global Search page
    And user clicks on the Prior Authorization tab
    Then user navigated to the "Prior Authorization" tab

  @46229
  @Sanity
  @test
  Scenario: Verify Prior Authorization column fields and member level Prior Authorization details
    When user clicking on Prior Authorization Claim Number in Global Search page
    And user clicks on the Prior Authorization tab
    Then user should be able to view the below column fields under Prior Authorization tab
      | Auth Number   |
      | Provider NPI  |
      | Tax ID        |
      | Provider Name |
      | CPT-Units     |
      | ICD Code      |
      | Received Date |
      | From Date     |
      | To Date       |
      | POS           |
      | Status        |
#    And user able to view all the field values under Prior Authorization tab

  @46231
  Scenario: Verify Search box under each column and able to enter search criteria
    When user clicking on Claim Number in Global Search page
    And user clicks on the Prior Authorization tab
    Then user should be able to view the Search fields under each column


  @46232
  Scenario: Validate footer section in Prior Authorization tab
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on the Prior Authorization tab
    Then user views the footer section in Prior Authorization page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |
      | Deactivate        |