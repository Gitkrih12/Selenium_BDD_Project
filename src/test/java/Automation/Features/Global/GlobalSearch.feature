Feature: Global Search

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  #40076-As an Adjudicator, When I login with No Admin role privileges to the application, I should be landing on the Global search page
  @TC_38268  @Sanity
  Scenario: Verify adjudicator should land on Global Search Page
    When left navigation loaded
    Then user should land on Global Search page

  #37487-As an Adjudicator, I should be able to get the required filtered data by all Global search grid columns
  @TC_34918 @Sanity @beta
  Scenario: Verify user enters the Claim Number in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Claim Number in the Search field
    Then user able to view the exact claim details

  @TC_37883 @Sanity @beta
  Scenario: Verify user enters the Member ID in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field
    Then user able to view the claim details for given member id

  @TC_37885
  Scenario: Verify user enters the Patient Name in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Patient Name in the Search field
    Then user able to view the claim details for given Patient name

  @TC_37887
  Scenario: Verify user enters the Billing Provider details in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Billing Provider in the Search field
    Then user able to view the claim details for given Billing Provider

  @TC_37893
  Scenario: Verify user enters the State name in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field
    And user enters the State in the Search field
    Then user able to view the claim details for given State

  @TC_37892
  Scenario: Verify user enters the Category value in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field
    And user enters the Category in the Search field
    Then user able to view the claim details for given Category

  @TC_37890
  Scenario: Verify user enters the DOS From details in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field
    And user enters the DOS From in the Search field
    Then user able to view the claim details for given DOS From

  @TC_37891
  Scenario: Verify user enters the DOS To details in the Search field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field
    And user enters the DOS To in the Search field
    Then user able to view the claim details for given DOS To

  @TC_34927 @Sanity @beta
  Scenario: Validate Export Result button should display when the search results are displayed
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    And user not able to view Export Result button when search results are not displayed
    When user enters the Claim Number in the Search field
    Then user able to view the exact claim details
    And user able to view the Export Result button when search results are displayed

  @TC_34939
  Scenario: Verify multiple fields for the Search criteria in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field
    When user enters the Patient Name in the Search field
    Then user able to view the claim details for given Patient name

  @TC_38126 @Sanity @beta
  Scenario: Verify Reprocess button should be available when Paid state is filtered in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field
    When user enters the State in the Search field
    Then user able to view the claim details for given State
    And user should be able view the Reprocess button for Paid state record

  #48151-As an Adjudicator, When I search with more than 6 characters in the Claim Number filter, the application should be able to display claim records in a Global search.
  @TC_49496  @Sanity
  Scenario: Verify user should get records when he search with more than 6 characters in claim number field in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters more than six characters in the Claim Number Search field
    Then user able to view the claim details for given filter criteria

  @TC_49500 @Sanity
  Scenario: Verify user should not get records when he search with less than 7 characters in claim number field in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters less than seven characters in the Claim Number Search field
    Then user not able to view the claim details for given filter criteria.

  #48152-As an Adjudicator, When I search with more than 2 characters in other than Claim Number filter, the application should be able to display claim records in a Global search.
  @TC_50701 @Sanity
  Scenario: Verify user able to search more than 2 characters in Member Id field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user searches more than two characters in Member Id field
    Then user should be able to display the claim records in a Global Search for given Member Id criteria

  @TC_50702 @Sanity
  Scenario: Verify user able to search more than 2 characters in Patient field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user searches more than two characters in Patient field
    Then user should be able to display the claim records in a Global Search for given Patient criteria

  @TC_50703
  Scenario: Verify user able to search more than 2 characters in Billing Provider field
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user searches more than two characters in Billing Provider field
    Then user should be able to display the claim records in a Global Search for given Billing Provider criteria

  @TC_50704
  Scenario: Verify user able to search more than 2 characters in any two fields
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user searches more than two characters in Member Id field
    When user searches more than two characters in State field
    Then user should be able to display the claim records in a Global Search

  #38256-As an Adjudicator, I should be able to view claim details from a Universal search with a valid Claim Number
  @TC_38470  @Sanity @beta
  Scenario: Verify user able to search claims by using universal search
    Then user should be able to view Universal search bar on the top right corner of the page
    And placeholder should read "Enter Valid Claim Number"
    When user provides correct claim number in the search bar
    Then user is able to view claim details page in another tab

  @TC_38471 @Sanity
  Scenario: Verify user able to see error message If the wrong Claim Number is entered in universal search
    When user searches for the claim number with less than ten characters
    Then user should be getting an error message as "Invalid claim number"

  @TC_38492
  Scenario: Verify user able to see error message when search with invalid claim number
    When user searches for any invalid claim number
    Then user should be getting an error message as "Invalid claim number"

  #41480- As an adjudicator, I should be able to view correct color coding on the Global search page so that I can easily identify the claim details
  @TC_42006 @Sanity
  Scenario: Verify color code for corrected claims in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters Corrected claim in search criteria
    Then user should able to view corrected claim
    And user should able to see vertical line beside claim number with color code "#AD71FF"
    And color indication information should be available on top of grid

  @TC_42013 @TC_42026 @TC_42031 @TC_42032 @TC_42044 @TC_42045 @TC_42047 @TC_42048 @TC_42049 @TC_42050
    @Sanity
  Scenario Outline: Verify color code for Pend On Hold Payer Review Management Review Approved Deny Prebatch Batch To Pay Paid Rejected state claim number
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for color code
    When user enters the State "<State>" in the Search field
    Then user able to view the claim details for given State
    And user should able to see the circle with color code "<Color Code>" for given State
    Examples:
      | State             | Color Code |
      | Pend              | #FFAB57    |
      | On Hold           | #E7BD09    |
      | Management Review | #1059E3    |
      | Approved          | #14C600    |
      | Deny              | #ED0303    |
      | Prebatch          | #6F03ED    |
      | Batch To Pay      | #03C0ED    |
      | Paid              | #0E8D00    |
      | Rejected          | #BA0000    |

  @TC_42027  @Sanity
  Scenario: Verify color code for Payer Review state claim number
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for Payer Review State
    When user enters the State "Payer Review" in the Search field
    Then user able to view the claim details for given State
    And user should able to see the circle with color code "#5AB0FF" for given State

  @TC_42053  @Sanity
  Scenario: Verify color code for voided state claim number
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for Voided State
    When user enters the State "Voided" in the Search field
    Then user able to view the claim details for given State
    And user should able to see the circle with color code "#212121" for given State

    #53039-As an Adjudicator, When the claim is in Unclean status I want the claim to be displayed and highlighted in the Orange bar.
  @TC_53445 @Sanity
  Scenario: Verify colour coding for Unclean status professional claims in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters Unclean status professional claim in search criteria
    Then user should able to view Unclean status claim
    And user should able to see vertical line beside unclean status claim number with color code "#FFC33E"
    And color indication information for Unclean should be available on top of grid

  @TC_53521 @Sanity
  Scenario: Verify colour coding for Unclean status Institutional claims in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters Unclean status institutional claim in search criteria
    Then user should able to view Unclean status claim
    And user should able to see vertical line beside unclean status claim number with color code "#FFC33E"
    And color indication information for Unclean should be available on top of grid


    #40024-As an Adjudicator, I should be able to view and perform Customize columns option in Global search grid page
  @TC_48810 @Sanity
  Scenario: Verify user should navigate to Customized Columns window when we click on Customized columns in Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When the user clicks Customize Columns option
    Then the user should able to navigate to Customized Columns window

  @TC_48811 @Sanity @beta
  Scenario:Verify user should able to see the mentioned column fields in the 'Customize Columns' window
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When the user clicks Customize Columns option
    Then user should able to see "Customize Columns" header
    And user should able to see following column fields in Customize Column window
      | Claim Number     |
      | Member Id        |
      | Patient          |
      | Billing Provider |
      | DOS From         |
      | DOS To           |
      | Category         |
      | State            |
      | Provider         |
      | Provider NPI     |
      | BP NPI           |
      | Tax ID           |
      | Total Charge     |
      | Net Pay Amount   |
      | Received Date    |
      | Age              |
      | Ref Id           |
    And user should able to see Save and close buttons

  @TC_55815 @Sanity
  Scenario: Verify claim number order and check box should be selected by default
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When the user clicks Customize Columns option
    Then claim number column should be first and disabled mode
    And claim number check box should be selected by default

  @TC_48814 @Sanity @beta
  Scenario: Verify user should able to see saved/updated fields under Global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When the user clicks Customize Columns option
    And  user select check box for the Provider field
    Then user should able to see the Provider column in the Global search grid page
    When the user clicks Customize Columns option
    And user unselect check box for the Provider field
    Then user should not able to see the Provider column in the Global search grid page


  #37309-As an Adjudicator, I should be able to view the Global search grid with all the finalized search columns
  @TC_37621 @Sanity
  Scenario: Verify user should get no result by default on Global search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    And by default no results should get displayed

  @TC_37667
  Scenario: Verify Filter and Customize Columns buttons in Global search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    And user should able to view the Filter and Customize columns buttons

  @TC_37661  @Sanity @beta
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

  @TC_37663 @Sanity @beta
  Scenario: Verify search field displayed under each column
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    And user able to view the Search fields under each column

  @TC_37754  @Sanity
  Scenario: Validate pagination in global Search page
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for Pagination
    Then user able to view the claim details for given member id
    When user get the total records for the search criteria
    Then user should be able to view the total results count at the bottom of the page

  @TC_37755 @Sanity
  Scenario: Verify user see the page numbers as per the no of data divided by pages size
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for Pagination
    Then user able to view the claim details for given member id
    When user get the total records for the search criteria
    Then user see the page numbers as per the no of data divided by pages size

  @TC_37759 @Sanity
  Scenario: Verify user should allow to navigate to other pages
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field
    Then user able to view the claim details for given member id
    And user should be able to view the page numbers at bottom of the page
    When user tries to click on next arrow symbol
    And user allow to navigates to next page
    When user tries to click on back arrow symbol
    Then user should allow to navigates to back page

  @TC_35347 @Sanity
  Scenario: Verify the user should perform sorting for DOS From field to ascending order
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for sorting
    Then user able to view the claim details for given member id
    And user get the DOS from records before sorting
    When user clicks on sort icon for the DOS From field column
    Then user able to view the field values in the sorted order

  @TC_35352
  Scenario: Verify the user should perform sorting for DOS To field to ascending order
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for sorting
    Then user able to view the claim details for given member id
    And user get the DOS To records before sorting
    When user clicks on sort icon for the DOS To field column
    Then user able to view the field values in the sorted order for DOS To column

  @TC_37685
  Scenario: Verify the user should perform sorting for Claim Number field to ascending order
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for sorting
    Then user able to view the claim details for given member id
    And user get the Claim Numbers records before sorting
    When user clicks on sort icon for the Claim Number field column
    Then user able to view the field values in the sorted order for Claim Number column


  @TC_37740
  Scenario: Verify the user should perform sorting for Billing Provider field to ascending order
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for sorting
    Then user able to view the claim details for given member id
    And user get the Billing Provider records before sorting
    When user clicks on sort icon for the Billing Provider field column
    Then user able to view the field values in the sorted order for Billing Provider column

  @TC_37738
  Scenario: Verify the user should perform sorting for Patient field to ascending order
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for sorting
    Then user able to view the claim details for given member id
    And user get the Patient records before sorting
    When user clicks on sort icon for the Patient field column
    Then user able to view the field values in the sorted order for Patient column

  @TC_37742
  Scenario: Verify the user should perform sorting for Category field to ascending order
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for sorting
    Then user able to view the claim details for given member id
    And user get the Category records before sorting
    When user clicks on sort icon for the Category field column
    Then user able to view the field values in the sorted order for Category column

  @TC_37744
  Scenario: Verify the user should perform sorting for State field to ascending order
    When user clicks on Global Search in left navigation menu
    Then the user should navigate to the Global Search page
    When user enters the Member Id in the Search field for sorting
    Then user able to view the claim details for given member id
    And user get the State records before sorting
    When user clicks on sort icon for the State field column
    Then user able to view the field values in the sorted order for State column