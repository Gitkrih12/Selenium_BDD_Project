Feature: Member Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @52211
  Scenario: Verify user should navigates to Member Details screen on clicking Patient ID/MBR ID
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user navigates to the Member Details page

  @52213
  Scenario: Verify fields in the Member Details page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user should be able to view the below fields
      | Member ID     |
      | Member Name   |
      | Date of Birth |
      | MBR Phone     |
      | Gender        |
      | Age           |
      | Plan-Subgroup |
      | County        |
      | Eff.Date      |
      | ELIG          |
      | Provider ID   |
      | PCP           |
      | PCP Phone     |
      | Address       |
      | City          |
      | State         |
      | Phone         |
      | Cell          |
      | Email         |
      | ZIP           |
      | Group/Plan    |
      | Eff.Date      |
      | MBI           |
      | Status        |
    And user able to view all the field values under Member Details page

  @52214
  Scenario: Verify Member Details tabs
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user should be able to view the below tabs
      | Provider Details       |
      | Address                |
      | Membership Information |
      | Claims                 |
      | COB                    |
      | MOOP                   |
      | Instructions           |
      | HOSPICE                |

  @52345
  Scenario: Verify user should navigate to Provider Details on Clicking Patient ID/MBR ID in View claim Details page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user navigates to the Provider Details tab by default should be "active"

  @52346
  Scenario: Verify column fields in Provider Details tab
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user should be able to view the below column fields under Provider Details tab
      | Physician Name |
      | NPI            |
      | Address        |
      | Provider ID    |
      | PCP            |
      | Eff From       |
      | Eff To         |
      | Phone          |
    And user able to view the search criteria for all the columns in Provider Details tab
    And user able to view all the field values under Provider Details tab

  @52363
  Scenario: Verify user navigates to Address subtab in Member Details page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Address subtab in Member Details page
    Then user navigates to the "Address" subtab successfully

  @52370
  Scenario: Verify column fields in Address sub tab in Member Details page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Address subtab in Member Details page
    Then user should be able to view the following columns
      | Address Type |
      | Address1     |
      | Address2     |
      | City         |
      | State        |
      | ZIP Code     |
      | Phone        |
      | Fax          |
    And user able to view the search criteria for all the columns in Address subtab
    And user able to view all the field values under Address subtab

  @52386
  Scenario: Verify user should navigate to Membership Information tab in Member Details page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Membership Information subtab in Member Details page
    Then user should be able to navigate to "Membership Information" subtab

  @52390
  Scenario: Verify column fields in Membership Information tab
    When user clicking on Membership Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Membership Information subtab in Member Details page
    Then user should be able to view the following columns in Membership Information subtab
      | Member ID      |
      | Last Name      |
      | First Name     |
      | Middle Name    |
      | Relationship   |
      | Policy Number  |
      | Payer Name     |
      | Plan Name      |
      | Plan Eff.Date  |
      | PCP Name       |
      | Plan Term Date |
      | Address        |
      | Phone          |
    And user able to view the search criteria for all the columns in Membership Information subtab
    And user able to view all the field values under Membership Information subtab

  @52392
  Scenario: Verify user should able to see Membership History column fields
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Membership Information subtab in Member Details page
    Then user should be able to view the following columns in Membership History
      | Member ID      |
      | Last Name      |
      | First Name     |
      | Middle Name    |
      | Relationship   |
      | Policy Number  |
      | Payer Name     |
      | Plan Name      |
      | Plan Eff.Date  |
      | PCP Name       |
      | Plan Term Date |
      | Address        |
      | Phone          |
    And user able to view the search criteria for all the columns in Membership History subtab
    And user able to view all the field values under Membership History subtab

  @52405
  Scenario: Verify column fields in Claims subtab
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Claims subtab
    Then user navigates to the "Claims" subtab in Member Details page
    And user able to view all the fields under Claims subtab
      | Claim Number     |
      | Billing Provider |
      | Patient Name     |
      | Member ID        |
      | Provider Name    |
      | NPI              |
      | Received Date    |
      | Status           |
      | Amt Approved     |
      | Amt Paid         |
      | Member Cost      |
      | Date Paid        |
      | Check No         |
      | EOB              |
    And user able to view all the field values under Claims subtab

  @52409
  Scenario: Verify Search functionality in claims subtab
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Claims subtab
    Then the user should be able to view the Search Criteria in Claim fields

  @52442
  Scenario: Verify user should navigate to COB tab and view column fields in Member Details page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on COB subtab
    Then user should be able to navigate to the "COB" subtab in Member Details page
    And user able to view the following fields under COB subtab
      | Member ID        |
      | Type             |
      | Eff. Date        |
      | Termination Date |
      | Policy ID        |
      | Carrier          |
    And user able to view the search criteria for all the columns in COB subtab
#    And user able to view all the field values under COB subtab

  @52454
  Scenario: Verify user should navigate to MOOP tab and view column fields in Member Details page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on MOOP subtab
    Then user navigates to the "MOOP" subtab under Member Details page
    And user able to view the below mentioned fields under MOOP subtab
      | Year            |
      | Co-pay($)       |
      | Co-Insurance($) |
      | Deductible($)   |
      | Total($)        |
      | Max Limit($)    |
    And user able to view the search criteria for all the columns in Moop subtab
    And user able to view all the field values under Moop subtab

  @52589
  Scenario: Verify user should navigate to Instructions tab and view column fields in Member Details page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Instructions subtab
    Then user navigates successfully to the "Instructions" subtab
    And user able to view the below mentioned fields under Instructions subtab
      | DOS From     |
      | DOS To       |
      | Tax Number   |
      | NPI          |
      | Member ID    |
      | Code         |
      | Modifiers    |
      | Bill Type    |
      | Revenue Code |
      | Notes        |
    And user able to view the search criteria for all the columns in Instructions subtab
#    And user able to view all the field values under Instructions subtab

  @52592
  Scenario: Verify user should navigate to HOSPICE tab and view column fields in Member Details page
    When user clicking on Claim Number in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Hospice subtab
    Then user navigates to the "HOSPICE" subtab under Member Details
    And user able to view the below mentioned columns under Hospice subtab
      | Member ID          |
      | Member Death Date  |
      | Hospice Begin Date |
      | Hospice End Date   |
    And user able to view the search criteria for all the columns in Hospice subtab
#    And user able to view all the field values under Hospice subtab