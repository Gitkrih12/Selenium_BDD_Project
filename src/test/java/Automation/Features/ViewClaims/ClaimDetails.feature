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