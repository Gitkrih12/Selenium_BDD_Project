Feature: Service Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @37693 @beta
  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    When user clicking on Claim Number in Global Search page
    And user clicks on Service Details tab
    Then user should view all the column fields in Service Details page
      | Adjustment             |
      | Deductible             |
      | Coinsurance            |
      | Copay                  |
      | Total Payment Amount   |
      | Recovery Amount        |
      | Interest Paid          |
      | Is A/R Amount Eligible |
      | A/R Balance            |
      | Payable Amount         |
      | Net Payment Amount     |
      | ICD Indicator          |
      | ICD Codes              |
    And user able to view all the field values in Service Details page

  @37694
  @Sanity @beta
  Scenario: Verify Service Lines fields
    When user clicking on Claim Number in Global Search page
    And user clicks on Service Details tab
    Then user able to view the below Service Line Fields
      | DOS                 |
      | Modifiers           |
      | Diagnosis Pointer   |
      | Line#               |
      | Code                |
      | From                |
      | To                  |
      | POS                 |
      | A                   |
      | B                   |
      | C                   |
      | D                   |
      | A                   |
      | B                   |
      | C                   |
      | D                   |
      | Unit                |
      | Unit Count          |
      | Total Charges($)    |
      | Adjudication Status |
      | Status              |
      | PBP                 |
    And user able to view all the field values in Service Line fields

  @37695 @beta
  Scenario: Verify footer section available in Service details tab
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on Service Details tab
    Then user views the footer section in Service Details page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |

  @38099
  Scenario: Verify user able to navigate to Pricing page upon clicking Line number
    When user clicking on Claim Number in Global Search page
    And user clicks on Service Details tab
    And user clicking on Line number
    Then user able to navigate to the Pricing page