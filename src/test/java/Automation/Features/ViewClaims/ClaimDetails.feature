Feature: Claim Details

  Background:
    Given the user enters the valid username and password and click on login button for admin role
    When user lands directly to the page

@37332
  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the Claim Summary page
    And user should view hide option besides Claim Summary

@37392
  Scenario: Verify View Claim in CMS 1500 and Self Assign buttons in Claim Summary details page
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the Claim Summary page
    And user should view CMS 1500 and Self Assign buttons in Claim Summary details page

@37393
  Scenario: Verify column fields in Claim Summary details page
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the Claim Summary page
    And user should be able to view all the column fields in Claim Summary Details page

@37394
  Scenario: Verify Claim Information tabs
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the Claim Summary page
    And user views the Claim Information section

@37397
  Scenario: Verify footer section in Claim Summary details page
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the Claim Summary page
    And user views the footer section in Claim Summary details page

@37402
  Scenario: Verify Claim Details sections
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the Claim Summary page
    And user view Claim Details sections