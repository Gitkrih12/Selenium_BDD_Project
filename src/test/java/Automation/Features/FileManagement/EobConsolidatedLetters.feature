Feature: EOB consolidated Letters

#  Author: Sreenivasulu Boyapati

  Background:
#  DSNP Adjudicator login (Non admin)
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    Given the user is on "Letters" page
    When the user clicks on EOB Consolidated tab

  @43655
  Scenario: Verify user navigates to EOB Consolidated screen
    Then user should be able to view the EOB Consolidated screen

  @43661-1 @Sanity @beta
  Scenario: Verify columns fields in EOB Consolidated screen
    Then the user should be able to view the following column fields under EOB consolidated letters tab
      | Member ID            |
      | Member Name          |
      | Plan Share Amount($) |
      | Member Share Amt($)  |
      | Date of Creation     |
      | Mailing Date         |

  @43661-2 @Sanity @beta
  Scenario: Verify column search fields in EOB consolidated letters screen
    And user should be able to view EOB consolidated letters column fields search boxes

#Remove test tag after adding data under uat env
  @43666 @Sanity @test
  Scenario: Verify Pagination in EOB Consolidated screen
    When the data exceeds the defined page size under EOB consolidated letters tab
    Then the user should be able to navigate through pages under EOB consolidated letters tab
    And Page size can be defined by the User as per the given option at the bottom of the grid under EOB consolidated letters tab
    And the user should be able to see the page numbers as per the number of data divided by page size under EOB consolidated letters tab

  @43664
  Scenario: Verify results of Member rows count next to "EOB-Consolidated letters" tab name
    Then user should be able to see the results of rows count next to EOB consolidated letters Tab

  @77074 @Sanity @beta
  Scenario: Verify user should be able to get results by applying filter on "Member ID" column under EOB-Consolidated tab
    When user enters EOB consolidated member id record under member id search box
    Then user should be able to view EOB consolidated member id under results section

  @77102
  Scenario: Verify user should be able to get results by applying filter on "Member Name" column under EOB-Consolidated tab
    When user enters EOB consolidated member name record under member name search box
    Then user should be able to view EOB consolidated member name under results section

  @77210
  Scenario: Verify user should be able to get results by applying filter on "Plan share amount($)" column under EOB-Consolidated tab
    When user enters EOB consolidated plan share amount under plan share amount search box
    Then user should be able to view EOB consolidated plan share amount under results section

  @77373
  Scenario: Verify user should be able to get results by applying filter on "Member share amount($)" column under EOB-Consolidated tab
    When user enters EOB consolidated member share amount under member share amount search box
    Then user should be able to view EOB consolidated member share amount under results section

  @77375 @Sanity @beta
  Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under EOB-Consolidated tab
    When user enters EOB consolidated created date under date of creation search box
    Then user should be able to view EOB consolidated created date under results section
