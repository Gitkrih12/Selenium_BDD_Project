Feature: MOOP

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @46276
  Scenario: Verify user should be able to navigate to the MOOP page through view claims from Global Search page
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on Moop tab
    Then user navigates to "MOOP" tab

  @46278
  Scenario: Verify user should be able to view the appropriate table with all the fields in MOOP page
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on Moop tab
    Then user able to view the below fields under Moop tab
      | Year            |
      | Co-pay($)       |
      | Co-Insurance($) |
      | Deductible($)   |
      | Total($)        |
      | Max Limit($)    |

  @46286
  Scenario: Verify the footer section should display in MOOP page
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on Moop tab
    Then user views the footer section in Moop page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |
      | Deactivate        |

  @46287
  Scenario: Verify Deny button should highlight in Red color in footer section
    Given the user is in FFS Professional page
    When user clicks on the Claim Number
    And user clicks on Moop tab
    Then Deny button should highlight in Red color "#FFFFFF" in footer section