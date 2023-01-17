Feature: EOB claim level letters

#  Author: Sreenivasulu Boyapati

  Background:
#  DSNP Adjudicator login (Non admin)
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    Given the user is on "Letters" page
    When the user clicks on the EOB Claim Level tab
    Then user should navigate to EOB Claim Level screen

  @44964
#  Scenario: Verify user navigates to EOB-Claim Level screen
#    Test steps are already covered under background.

  @44967-1 @Sanity @beta
  Scenario: Verify column fields in EOB-Claim Level screen
    And the user should be able to view the following column fields under EOB claim level letters tab
      | Claim Number         |
      | Member ID            |
      | Member Name          |
      | Plan Share Amount($) |
      | Member Share Amt($)  |
      | Date of Creation     |
      | Mailing Date         |

  @44967-2 @Sanity @beta
  Scenario: Verify column search fields in EOB-Claim Level screen
    Then user should be able to view EOB claim level letters column fields search boxes

#Remove test tag after adding data under uat env
#  @44970 @Sanity @test
#  Scenario: Verify Pagination in EOB-Claim Level screen
#    When the data exceeds the defined page size under EOB claim level letters tab
#    Then the user should be able to navigate through pages under EOB claim level letters tab
#    And Page size can be defined by the User as per the given option at the bottom of the grid under EOB claim level letters tab
#    And the user should be able to see the page numbers as per the number of data divided by page size under EOB claim level letters tab

  @44968
  Scenario: Verify results of Member rows count next to "EOB-Claim Level" tab name
    Then user should be able to see the results of rows count next to EOB claim level letters Tab

  @77661 @Sanity @beta @test
  Scenario: Verify user should be able to get results by applying filter on "Claim Number" column under EOB-Claim level tab
    When user enters EOB claim level claim number record under claim number search box
    Then user should be able to view EOB claim level claim number under results section

  @77662
  Scenario: Verify user should be able to get results by applying filter on "Member ID" column under EOB-Claim level tab
    When user enters EOB claim level member id record under member id search box
    Then user should be able to view EOB claim level member id under results section

  @77663
  Scenario: Verify user should be able to get results by applying filter on "Member Name" column under EOB-Claim level tab
    When user enters EOB claim level member name record under member name search box
    Then user should be able to view EOB claim level member name under results section

  @77664
  Scenario: Verify user should be able to get results by applying filter on "Plan share amount($)" column under EOB-Claim level tab
    When user enters EOB claim level plan share amount under plan share amount search box
    Then user should be able to view EOB claim level plan share amount under results section

  @77665
  Scenario: Verify user should be able to get results by applying filter on "Member share amount($)" column under EOB-Claim level tab
    When user enters EOB claim level member share amount under member share amount search box
    Then user should be able to view EOB claim level member share amount under results section

  @77666 @Sanity @beta @test
  Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under EOB-Claim level tab
    When user enters EOB claim level created date under date of creation search box
    Then user should be able to view EOB claim level created date under results section
