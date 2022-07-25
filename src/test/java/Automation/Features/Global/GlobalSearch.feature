Feature: Global Search

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

    #40076-As an Adjudicator, When I login with No Admin role privileges to the application, I should be landing on the Global search page
  @TC_38268
  Scenario: Verify adjudicator should land on Global Search Page
    When left navigation loaded
    Then user should land on Global Search page

    #37309-As an Adjudicator, I should be able to view the Global search grid with all the finalized search columns
  @TC_37621
  Scenario: Verify user should get no result by default on Global search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    And by default no results should get displayed

  @TC_37667
  Scenario: Verify Filter and Customize Columns buttons in Global search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    And user should able to view the Filter and Customize columns buttons

  @TC_37661
  Scenario: Verify column fields in grid level on Global Search
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    And user should able to see column fields in global Search page
      | Claim Number     |
      | Member Id        |
      | Patient          |
      | Billing Provider |
      | DOS From         |
      | DOS To           |
      | Category         |
      | State            |

  @TC_37663
  Scenario: Verify search field displayed under each column except follow up column
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    And user able to view the Search fields under each column except follow up column

     #37487-As an Adjudicator, I should be able to get the required filtered data by all Global search grid columns
  @TC_34918
  Scenario: Verify user enters the Claim Number in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Claim Number "P0020021100018" in the Search field
    Then user able to view the exact claim details

  @TC_37883
  Scenario: Verify user enters the Member ID in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id "2183336VF" in the Search field
    Then user able to view the claim details for given member id

  @TC_37885
  Scenario: Verify user enters the Patient Name in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Patient Name "dbkgmdc vskq" in the Search field
    Then user able to view the claim details for given Patient name

  @TC_37887
  Scenario: Verify user enters the Billing Provider details in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Billing Provider "MXS COMSDMKBZ OBKM IBKWSBZ IDSCBOFSXE" in the Search field
    Then user able to view the claim details for given Billing Provider

  @TC_37893
  Scenario: Verify user enters the State name in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id "2183336VF" in the Search field
    When user enters the State "Paid" in the Search field
    Then user able to view the claim details for given State

  @TC_37892
  Scenario: Verify user enters the Category value in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id "2183336VF" in the Search field
    When user enters the Category "Normal" in the Search field
    Then user able to view the claim details for given Category

  @TC_37890
  Scenario: Verify user enters the DOS From details in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id "2183336VF" in the Search field
    When user enters the DOS From "01/03/2021" in the Search field
    Then user able to view the claim details for given DOS From

  @TC_37891  @37309_PR2
  Scenario: Verify user enters the DOS To details in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id "2183336VF" in the Search field
    When user enters the DOS To "01/12/2021" in the Search field
    Then user able to view the claim details for given DOS To

  @TC_34927 @37309_PR2
  Scenario: Validate Export Result button should display when the search results are displayed
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    And user not able to view Export Result button when search results are not displayed
    When user enters the Claim Number "P0020021100018" in the Search field
    Then user able to view the exact claim details
    And user able to view the Export Result button when search results are displayed

  @TC_34939  @37309_PR2
  Scenario: Verify multiple fields for the Search criteria in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id "2183336VF" in the Search field
    When user enters the Patient Name "dbkgmdc vskq" in the Search field
    Then user able to view the claim details for given Patient name

  @TC_38126  @37309_PR2
  Scenario: Verify Reprocess button should be available when Paid state is filtered in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id "2183336VF" in the Search field
    When user enters the State "Paid" in the Search field
    Then user able to view the claim details for given State
    And user should be able view the Reprocess button for Paid state record

    #48151-As an Adjudicator, When I search with more than 6 characters in the Claim Number filter, the application should be able to display claim records in a Global search.
  @TC_49496 @37309_PR2
  Scenario: Verify user should get records when he search with more than 6 characters in claim number field in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Claim Number "P002002" in the Search field
    Then user able to view the claim details for given filter criteria

  @TC_49500 @37309_PR2
  Scenario: Verify user should not get records when he search with less than 7 characters in claim number field in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Claim Number "P00200" in the Search field
    Then user not able to view the claim details for given filter criteria.

    #48152-As an Adjudicator, When I search with more than 2 characters in other than Claim Number filter, the application should be able to display claim records in a Global search.
  @TC_50701 @37309_PR2
  Scenario: Verify user able to search more than 2 characters in Member Id field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user searches more than two characters in Member Id "218" field
    Then user should be able to display the claim records in a Global Search for given Member Id criteria

  @TC_50702 @37309_PR2
  Scenario: Verify user able to search more than 2 characters in Patient field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user searches more than two characters in Patient "dbk" field
    Then user should be able to display the claim records in a Global Search for given Patient criteria

  @TC_50703  @37309_PR2
  Scenario: Verify user able to search more than 2 characters in Billing Provider field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user searches more than two characters in Billing Provider "MXS COMSDMKBZ" field
    Then user should be able to display the claim records in a Global Search for given Billing Provider criteria

  @TC_50704 @37309_PR2
  Scenario: Verify user able to search more than 2 characters in any two fields
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user searches more than two characters in Member Id "218" field
    When user searches more than two characters in State "Pai" field
    Then user should be able to display the claim records in a Global Search