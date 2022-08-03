Feature: Member Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @52211
  Scenario: Verify user should navigates to Member Information screen on clicking Patient ID/MBR ID
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user navigates to the Member Information page

  @52213
  Scenario: Verify fields in the Member Information page
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user should be able to view the below fields
      | Member ID       |
      | Member Name     |
      | Date of Birth   |
      | MBR Phone       |
      | Gender          |
      | Age             |
      | Plan - Subgroup |
      | County          |
      | Eff.Date        |
      | ELIG            |
      | Provider ID     |
      | PCP             |
      | PCP Phone       |
      | Address         |
      | City            |
      | State           |
      | Phone           |
      | Cell            |
      | Email           |
      | ZIP             |
      | Group/Plan      |
      | Eff.Date        |
      | MBI             |
      | Status          |

  @52214
  Scenario: Verify Member Information tabs
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user should be able to view the below tabs
      | Provider Information     |
      | Address                  |
      | Membership Information   |
      | Claims                   |
      | COB                      |
      | MOOP                     |
      | Adjudicator Instructions |
      | HOSPICE                  |