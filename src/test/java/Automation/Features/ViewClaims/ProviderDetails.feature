Feature: Provider Details

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @39950
  Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    Then user navigates to the Provider Details tab

  @39953
  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    Then user able to view the below sections under Provider Details tab
      | Pay to Provider Details          |
      | Group/Rendering Provider Details |

  @39958
  Scenario: Verify user able to view all the fields under Pay to Provider Details section
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    Then user able to view all the fields under Pay to Provider Details section
      | Pay to Provider ID   |
      | Pay to Provider Name |
      | Tax ID/SSN           |
      | NPI                  |
      | Vendor ID            |
      | Vendor Validated     |
      | Address Line 1       |
      | City                 |
      | State                |
      | Zipcode              |

  @39961
  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    Then user able to view all the fields under Group Rendering Provider Details section
      | NPI              |
      | Name             |
      | Address          |
      | Effective Date   |
      | Termination Date |
      | Timely Filling   |
      | Sequestration    |
      | ProviderID       |
      | Contact Name     |

  @39974
  Scenario: Validate all the buttons available at the footer section under Provider Details tab
    When user clicking on Claim Number "P0020021100018" in Global Search page
    And user clicks on the Provider Details tab
    Then user views the footer section in Provider Details page
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Deny              |
      | Approve           |
      | Update Auth       |