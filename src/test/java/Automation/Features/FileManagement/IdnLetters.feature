Feature: IDN Letters

#  Author: Sreenivasulu Boyapati

  Background:
#  DSNP Adjudicator login (Non admin)
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    Given the user is on "Letters" page
    When user clicks on IDN tab
    Then user should navigate to IDN screen

#  @45254-1
#  Scenario: Verify user able to navigate to IDN screen under Letters tab
#  Steps for this test case are already covered under back ground

  @45254-2 @Sanity @beta
  Scenario: Verify column fields under IDN screen
    Then the user should be able to view the following column fields under IDN letters tab
      | Batch ID         |
      | Claim Number     |
      | Provider Name    |
      | Member ID        |
      | Member Name      |
      | Date of Creation |
      | Mailing Date    |

  @45254-3 @Sanity @beta
  Scenario: Verify column search fields under IDN screen
    Then user should be able to view IDN letters column fields search boxes

  @45254-4
  Scenario: Verify results of Member rows count next to IDN tab name
    Then user should be able to see the results of rows count next to IDN Tab name

  @77955 @Sanity @beta
  Scenario: Verify user should be able to get results by applying filter on "Batch Id" column under Letters IDN tab
    When user enters IDN batch id record under batch id search box
    Then user should be able to view IDN batch id under results section

  @77956 @Sanity @beta
  Scenario: Verify user should be able to get results by applying filter on "Claim Number" column under Letters IDN tab
    When user enters IDN claim number record under claim number search box
    Then user should be able to view IDN claim number under results section

  @77958
  Scenario: Verify user should be able to get results by applying filter on "Provider Name" column under Letters IDN tab
    When user enters IDN provider name record under provider name search box
    Then user should be able to view IDN provider name under results section

  @77960
  Scenario: Verify user should be able to get results by applying filter on "Member ID" column under Letters IDN tab
    When user enters IDN member id record under member id search box
    Then user should be able to view IDN member id under results section

  @77963
  Scenario: Verify user should be able to get results by applying filter on "Member Name" column under Letters IDN tab
    When user enters IDN member name record under member name search box
    Then user should be able to view IDN member name under results section

  @77965 @Sanity @beta
  Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under Letters IDN tab
    When user enters IDN created date under date of creation search box
    Then user should be able to view IDN created date under results section
