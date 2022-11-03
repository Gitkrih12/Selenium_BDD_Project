Feature: Encounter files

#  Author: Sreenivasulu Boyapati

  Background:
#  DSNP Adjudicator login (Non admin)
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    When user click on Encounter Files in Left Navigation menu
    Then user should navigate to "Encounter Files" page


#  @49961 @Sanity
#  Scenario:Verify user should navigate to Encounter Files
#  Above test case is already covered under background steps

  @49964 @Sanity @beta
  Scenario: Verify column fields in Encounter files page
    Then the user should be able to view the following column fields under encounter files tab
      | File Name     |
      | Sender        |
      | Receiver      |
      | Date Recieved |
      | Age(Days)     |
      | Claim Type    |

  @49973 @Sanity @beta
  Scenario: Verify Search Box should display below on each column in Encounter files
    Then user should able to see Search Box under each column of the encounter files tab

  @50026 @Sanity @beta
  Scenario: Verify user should able to see 'Generated Encounter File' button in Encounter Files Page
    Then user should be able to see 'Generate Encounter File' button

#  68296 is segregated into multiple test cases
  @68296-1
  Scenario: Verify user should be able to get results for applying filter on "File Name" column under generated tab
    When user enters encounter file name record under file name search box
    Then user should be able to see encounter file name record under results section

  @68296-2
  Scenario: Verify user should be able to get results for applying filter on "Sender" column under Encounter files tab
    When user enters encounter sender name under sender search box
    Then user should be able to see encounter sender details under results section

  @68296-3
  Scenario: Verify user should be able to get results for applying filter on "Receiver" column under Encounter files tab
    When user enters encounter receiver name under receiver search box
    Then user should be able to see encounter receiver details under results section

  @68296-4 @Sanity @beta
  Scenario: Verify user should be able to get results for applying filter on "Date Received" column under Encounter files tab
    When user enters encounter received date under date received search box
    Then user should be able to see encounter received date details under results section

  @68296-5 @Sanity @beta
  Scenario: Verify user should be able to get results for applying filter on "Age(Days)" column under Encounter files tab
    When user enters encounter age days under age days search box
    Then user should be able to see encounter age days details under results section

  @68296-6
  Scenario: Verify user should be able to get results for applying filter on "Claim Type" column under Encounter files tab
    When user enters encounter claim type under claim type search box
    Then user should be able to see encounter claim type details under results section
