Feature: EOP Letters

  Background:
#  DSNP Adjudicator login (Non admin)
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    Given the user is on "Letters" page
    When the user clicks on EOP tab
    Then user should be able to view the EOP screen under EOP tab

#  @43657-1
#  Scenario: Verify user navigates to EOP screen
#  Steps for this test case are already covered under back ground

  @43657-2 @Sanity @beta
  Scenario: Verify columns fields in "EOP letters" screen
    Then the user should be able to view the following column fields under EOP letters tab
      | Batch ID             |
      | Check Number         |
      | Provider Name        |
      | Member ID            |
      | Member Name          |
      | Plan Share Amount($) |
      | Member Share Amt($)  |
      | Date of Creation     |
      | Mailing Date         |

  @43657-3 @Sanity @beta
  Scenario: Verify column search fields in "EOP letters" screen
    And user should be able to view EOP letters column fields search boxes

  @43657-4
  Scenario: Verify results of Member rows count next to "EOP letters" tab name
    Then user should be able to see the results of rows count next to EOP letters Tab name

  #Remove test tag after adding data under uat env
  @43658 @Sanity @test
  Scenario: Verify Pagination in EOP screen
    When the data exceeds the defined page size under EOP letters tab
    Then the user should be able to navigate through pages under EOP letters tab
    And Page size can be defined by the User as per the given option at the bottom of the grid under EOP letters tab
    And the user should be able to see the page numbers as per the number of data divided by page size under EOP letters tab

  @77849 @Sanity @beta
  Scenario: Verify user should be able to get results by applying filter on "Batch Id" column under EOP tab
    When user enters EOP batch id record under batch id search box
    Then user should be able to view EOP batch id under results section

  @77851 @Sanity @beta
  Scenario: Verify user should be able to get results by applying filter on "Check Number" column under EOP tab
    When user enters EOP check number record under check number search box
    Then user should be able to view EOP check number under results section

  @77853
  Scenario: Verify user should be able to get results by applying filter on "Provider Name" column under EOP tab
    When user enters EOP provider name record under provider name search box
    Then user should be able to view EOP provider name under results section

  @77854
  Scenario: Verify user should be able to get results by applying filter on "Member ID" column under EOP tab
    When user enters EOP member id record under member id search box
    Then user should be able to view EOP member id under results section

  @77857
  Scenario: Verify user should be able to get results by applying filter on "Member Name" column under EOP tab
    When user enters EOP member name record under member name search box
    Then user should be able to view EOP member name under results section

  @77859
  Scenario: Verify user should be able to get results by applying filter on "Plan share amount($)" column under EOP tab
    When user enters EOP plan share amount under plan share amount search box
    Then user should be able to view EOP plan share amount under results section

  @77860
  Scenario: Verify user should be able to get results by applying filter on "Member share amount($)" column under EOP tab
    When user enters EOP member share amount under member share amount search box
    Then user should be able to view EOP member share amount under results section

  @77861 @Sanity @beta
  Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under EOP tab
    When user enters EOP created date under date of creation search box
    Then user should be able to view EOP created date under results section
