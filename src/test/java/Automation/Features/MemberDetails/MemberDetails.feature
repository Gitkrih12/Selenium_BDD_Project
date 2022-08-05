Feature: Member Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @52211
  Scenario: Verify user should navigates to Member Details screen on clicking Patient ID/MBR ID
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user navigates to the Member Details page

  @52213
  Scenario: Verify fields in the Member Details page
    When user clicking on Claim Number "P0020021100018" in Global Search page
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

  @52214
  Scenario: Verify Member Details tabs
    When user clicking on Claim Number "P0020021100018" in Global Search page
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
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Patient ID or MBR ID
    Then user navigates to the Provider Details tab by default should be "active"

  @52346
  Scenario: Verify column fields in Provider Details tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
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

  @52363
  Scenario: Verify user navigates to Address subtab in Member Details page
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Address subtab in Member Details page
    Then user navigates to the "Address" subtab

  @52370
  Scenario: Verify column fields in Address sub tab in Member Details page
    When user clicking on Claim Number "P0020021100018" in Global Search page
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

  @52386
  Scenario: Verify user should navigate to Membership Information tab in Member Details page
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Membership Information subtab in Member Details page
    Then user should be able to navigate to "Membership Information" subtab

  @52390
  Scenario: Verify column fields in Membership Information tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
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

  @52392
  Scenario: Verify user should able to see Membership History column fields
    When user clicking on Claim Number "P0020021100018" in Global Search page
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

  @52405
  Scenario: Verify column fields in Claims subtab
    When user clicking on Claim Number "P0020021100018" in Global Search page
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

  @52409
  Scenario: Verify Search functionality in claims subtab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Patient ID or MBR ID
    When user clicks on Claims subtab
    Then the user should be able to view the Search Criteria in Claim fields

  @52442
  Scenario: Verify user should navigate to COB tab and view column fields in Member Details page
    When user clicking on Claim Number "P0020021100018" in Global Search page
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