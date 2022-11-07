Feature: Claim Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    Then user should be able to login to the CA screen successfully

  @37332
  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    And user should view "(Hide)" option besides Claim Summary

  @37392 @beta
  Scenario: Verify View Claim in CMS 1500 and Self Assign buttons in Claim Summary details page
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    And user should view Claim in CMS "View Claim in CMS 1500" and self assign "Self-Assign" buttons in Claim Summary details page

  @37393
  @Sanity @beta
  Scenario: Verify column fields in Claim Summary details page
    When user clicks on the Claim Number in Universal Search
    Then user navigates to the "Claim Summary" page
    And user should be able to view all the column fields in Claim Summary Details page
      | Claim Number      |
      | Patient           |
      | Patient ID/MBR ID |
      | PCP               |
      | Billing Provider  |
      | DOS From          |
      | DOS To            |
      | Billed Amount     |
      | POS               |
      | PBP               |
      | Age               |
      | Received Date     |
      | Ref ID            |
    And user able to view all the field values in Claim Summary Details page

  @37394 @beta
  Scenario: Verify Claim Summary Tab List
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    And user views the Claim Summary Tab list
      | Claim Details (EDI) |
      | Service Details     |
      | Provider Details    |
      | Edits               |
      | Documents           |
      | Notes               |
      | MOOP                |
      | Prior Authorization |
      | Follow-Up           |
      | Activity Logger     |
      | AR Transaction      |

  @37397 @beta
  Scenario: Verify footer section in Claim Summary details page
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    And user views the footer section in Claim Summary details page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |

  @37402
  @Sanity @beta
  Scenario: Verify Claim Details sections
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    And user views Claim Details by default should be "active"
    Then user view Claim Details sections as below
      | Claim Information               |
      | Payment Information             |
      | Member Information              |
      | Rendering Provider Information  |
      | Billing Provider Information    |
      | Payer                           |
      | Date of Service                 |
      | Is Patient Condition Related To |

  @37403 @beta
  Scenario: Validate Claim Information section
    When user clicks on the Claim Number in Universal Search
    Then user navigates to the "Claim Summary" page
    And user able to view the below fields under claim information section
      | Claim Number         |
      | Reference Number     |
      | State                |
      | Claim Status         |
      | Claim Type           |
      | Form Type            |
      | Claim Submission     |
      | Clean/Unclean Status |
    And user able to view all the field values under claim information section

  @37405 @beta
  Scenario: Validate Payment Information section
    When user clicks on the Claim Number in Universal Search
    Then user navigates to the "Claim Summary" page
    And user able to view the below fields under Payment Information section
      | OK Pay Date     |
      | Paid Date       |
      | Check Number    |
      | Reference Check |
      | Plan CRN        |
      | Adjustment      |
      | Deductible      |
      | Coinsurance     |
      | Copay           |
      | Recovery Amount |
      | Payment Amount  |
      | Mailing date    |
      | Payment Type    |
      | Payment ID      |
    And user able to view all the field values under Payment Information section


  @37406
  Scenario: Validate Clean status
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    And user can check the claim status as Clean

  @37407
  Scenario: Validate Unclean status
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    And user claim status as Un-Clean is unchecked by default

  @37413 @beta
  Scenario: Validate Member Information section
    When user clicks on the Claim Number in Universal Search
    Then user navigates to the "Claim Summary" page
    And user able to view the below fields under Member Information section
      | Patient Name                      |
      | Address Line 1                    |
      | Address Line 2                    |
      | City                              |
      | State                             |
      | Country                           |
      | Zip Code                          |
      | Gender                            |
      | Date of Birth                     |
      | Insured Name                      |
      | Patient's Relationship to Insured |
      | Insured's Unique Identifier       |
      | Insured's Group Name              |
      | Insured's Group Number            |
    And user able to view all the field values under Member Information section

  @37414 @beta
  Scenario: Validate Rendering Provider Information section
    When user clicks on the Claim Number in Universal Search
    Then user navigates to the "Claim Summary" page
    And user able to view the below fields under Rendering Provider information section
      | Rendering Provider Name |
      | Rendering Provider NPI  |
      | Taxonomy                |
    And user able to view all the field values under Rendering Provider Information section

  @37415 @beta
  Scenario: Validate Billing Provider Information section
    When user clicks on the Claim Number in Universal Search
    Then user navigates to the "Claim Summary" page
    And user able to view the below fields under Billing Provider Information section
      | Billing Provider Name |
      | Tax ID                |
      | Address Line 1        |
      | Address Line 2        |
      | City                  |
      | State                 |
      | Zip                   |
      | Taxonomy              |
      | SSN                   |
      | Telephone             |
      | Network Affiliation   |
    And user able to view all the field values under Billing Provider Information section

  @37416 @beta
  Scenario: Validate Payer section
    When user clicks on the Claim Number in Universal Search
    Then user navigates to the "Claim Summary" page
    And user able to view the below fields under Payer section
      | Payer name     |
      | Payer ID       |
      | Address Line 1 |
      | Address Line 2 |
      | City           |
      | State          |
      | Zip Code       |
    And user able to view all the field values under Payer section

  @37418 @beta
  Scenario: Validate Date of Service section
    When user clicks on the Claim Number in Universal Search
    Then user navigates to the "Claim Summary" page
    And user able to view the below fields under Date of Service section
      | From Date              |
      | To Date                |
      | Prior Auth             |
      | Patient Control Number |
    And user able to view all the field values under Date of Service section

  @37421 @beta
  Scenario: Validate Is Patient Condition Related To section
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    And user able to view the below fields under Is Patient Condition Related To section
      | Employment                      |
      | Auto Accident                   |
      | Other Accident                  |
      | Accident Date                   |
      | Date of Onset / Current Illness |
    And user should be able to view checkboxes for Employment Auto Accident and Other Accident fields

  @40613
  Scenario: Validate Hide action for claim summary section
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    When user clicks on Hide link
    Then user should hide the claim summary section

  @40618
  Scenario: Validate Show action for claim summary section
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    When user clicks on Hide link
    Then user able to view the show link
    When user clicks on Show link
    Then user able to view the Claim Summary section

  @42125
  Scenario: Verify user able to view 1-New Claim Submission type in Claim details page
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user views Claim Submission type as New

  @42127
  Scenario: Verify user able to view 7-Corrected claim submission type in Claim Details page
    When user clicks on FFS Professional in left navigation menu
    Then the user should navigate to the FFS Professional page
    When user enters Corrected claim in FFS Professional search criteria
    And user clicks on the Claim Number
    Then user views Claim Submission type as Corrected

  @42125-1
  Scenario: Verify user able to view 1-New Claim Submission type in CAP Professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on the Claim Number
    Then user views Claim Submission type as New

  @42127-1
  Scenario: Verify user able to view 7-Corrected claim submission type in CAP Professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user enters Corrected claim in CAP Professional search criteria
    And user clicks on the Claim Number
    Then user views Claim Submission type as Corrected

  @42196
  Scenario Outline: Verify user able to view different types of claim submission from FFS Institutional page
    When user clicks on FFS Institutional in left navigation menu
    When user enters and clicks on the "<claim number>" in FFS Institutional Universal Search
    Then user views the Claim Submission "<type>"
    Examples:
      | claim number   | type                       |
      | I0021120320003 | 0-NON-PAYMENT/ZERO CLAIM   |
      | I01MR22042700I | 1-ADMIT THROUGH DISCHARGE  |
      | I0119040400004 | 2-INTERIM-FIRST CLAIM      |
      | I0020121200014 | 3-INTERIM-CONTINUING CLAIM |
      | I00MR211230002 | 4-INTERIM-LAST CLAIM       |
      | I00MR220916005 | 5-LATE CHARGE ONLY         |
      | I0020082700004 | 7-CORRECTED                |
      | I00MR211229006 | 8-VOID/CANCEL              |
      | I00MR220113001 | 9-FINAL CLAIM              |
      | I00MR220309006 | A-NOTICE OF ADMISSION      |

  @42197
  Scenario Outline: Verify user able to view different types of claim submission from CAP Institutional page
    When user clicks on CAP Institutional in left navigation menu
    Then the user should navigate to the CAP Institutional page
    When user enters and clicks on the "<claim number>" in CAP Institutional Universal Search
    Then user views the Claim Submission "<type>"
    Examples:
      | claim number   | type                       |
      | I0121120300007 | 0-NON-PAYMENT/ZERO CLAIM   |
      | I0021061400032 | 1-ADMIT THROUGH DISCHARGE  |
      | I0021062800002 | 2-INTERIM-FIRST CLAIM      |
      | I00MR22042200D | 3-INTERIM-CONTINUING CLAIM |
      | I0121101200001 | 4-INTERIM-LAST CLAIM       |
      | I00MR220421002 | 5-LATE CHARGE ONLY         |
      | I00MR220725009 | 7-CORRECTED                |
      | I0021122300001 | 8-VOID/CANCEL              |
      | I00MR220113003 | 9-FINAL CLAIM              |

  #71368-As an Adjudicator when I click on “Self-Assign” on the Claim details tab then the claim should assign to me. So that I can be able to handle/assign the claim.
  @73992
  Scenario: Verify self assign claim functionality
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    Then user navigates to the "Claim Summary" page
    When user clicks on "Self Assign" button
    Then user should able to see validation message as "CLAIM UPDATED SUCCESSFULLY" and  "CLAIM ASSIGNED"
    And user should able to see Assigned To value should updated to respective user
