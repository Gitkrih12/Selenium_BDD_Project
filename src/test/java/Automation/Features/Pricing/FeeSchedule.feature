Feature: Fee Schedule

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  #60537-As an adjudicator, when I click on the “See Fee Schedule” from ‘the pricing screen’ So that, I can be able to see the fee schedule details.
  @TC_63169
  Scenario: Verify user able to view the Fee schedules side drawer when clicking on See Fee Schedule in Pricing screen
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user clicking on Claim Number in Global Search page for Fee Schedule
    And user clicks on Service Details tab
    And user clicks on service line number
    Then user should navigates to "Pricing" screen
    When user clicks on See Fee Schedule link
    Then user should navigates to "Fee Schedules" screen

  @TC_63175
  Scenario: Verify user able to view the respective tabs under Fee Schedules side drawer
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user clicking on Claim Number in Global Search page for Fee Schedule
    And user clicks on Service Details tab
    And user clicks on service line number
    Then user should navigates to "Pricing" screen
    When user clicks on See Fee Schedule link
    Then user should navigates to "Fee Schedules" screen
    And user should be able to see below tabs in Fee Schedules screen
      | Fee Schedules             |
      | Payment Policy Indicators |
      | RVU                       |
      | Geographic Practice Cost  |

  #60546-As an adjudicator, when I click on the “Fee Schedules” from ‘See Fee Schedule screen So that, I can be able to see the fee schedule details.
  @TC_63175
  Scenario: Verify user able to view the respective tabs under Fee Schedules side drawer
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user clicking on Claim Number in Global Search page for Fee Schedule
    And user clicks on Service Details tab
    And user clicks on service line number
    Then user should navigates to "Pricing" screen
    When user clicks on See Fee Schedule link
    Then user should navigates to "Fee Schedules" screen
    And user should be able to see below column fields in Fee Schedules screen
      | S.No                |
      | Line                |
      | Code                |
      | DOS From            |
      | DOS To              |
      | FeeScheduleType     |
      | Rate ($)            |
      | Unit Count          |
      | Eligible Amount ($) |

  #60579-As an adjudicator, when I click on the “Payment Policy Indicators” from ‘See Fee Schedules screen’ So that, I can be able to see the Payment Policy Indicators details.
  @TC_63212
  Scenario: Verify column fields in Payment Policy Indicators tab
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user clicking on Claim Number in Global Search page for Fee Schedule
    And user clicks on Service Details tab
    And user clicks on service line number
    Then user should navigates to "Pricing" screen
    When user clicks on See Fee Schedule link
    Then user should navigates to "Fee Schedules" screen
    When user clicks on Payment Policy Indicators tab
    Then user should able to see below mentioned fields
      | HCPCS Code              |
      | Modifier                |
      | PROC Stat               |
      | PCTC                    |
      | ENDO Base               |
      | MULT SURG               |
      | BILT SURG               |
      | ASST SURG               |
      | CO SURG                 |
      | Team SURG               |
      | PHYS SUPV               |
      | DIAG Imaging Family IND |
