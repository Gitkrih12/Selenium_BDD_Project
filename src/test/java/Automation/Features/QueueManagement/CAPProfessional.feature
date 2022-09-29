Feature: CAP Professional

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button

  @TC_39033 @Sanity
  Scenario: Verify user should navigates to CAP Professional screen
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page

  @TC_39056
  Scenario: Verify by default user should be in the Pend state in CAP Professional screen
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    And by default user should be in Pend state results page in CAP Professional page

  @TC_39061
  Scenario: Verify user should able to see Clam List Label in CAP Professional screen
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    And user should be able to view the Clam List Label in the CAP Professional screen

  @TC_39051 @Sanity
  Scenario: Validate user able to view all the column fields for Pend bucket in CAP Professional screen
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user views Pend bucket by default should be "active" in CAP Professional page
    Then user able to view following column fields in Pend bucket in CAP Professional page
      | Claim Number           |
      | Patient                |
      | Member ID              |
      | Billing Provider       |
      | Rendering Provider     |
      | Rendering Provider NPI |
      | DOS From               |
      | DOS To                 |
      | Total Charges($)       |
      | Net Pay Amt($)         |
      | Received Date          |
      | Age                    |
      | Assigned To            |

  @TC_39054 @Sanity
  Scenario: Verify all the queue field details in the CAP Professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    And user should be able to view following queue detail fields in CAP Professional page
      | Pend              |
      | On Hold           |
      | Payer Review      |
      | Management Review |
      | Approved          |
      | Denied            |
      | Pre Batch         |
      | Batch to Pay      |
      | Paid              |
      | Draft             |
      | Rejected          |

  @TC_39059 @Sanity
  Scenario: Verify user able to view the search fields under each columns in the CAP Professional screen
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    And user able to view the Search fields under each column in CAP Professional page

  @TC_39228 @Sanity
  Scenario: Verify Pagination in CAP Professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user enters the member id in the search field in CAP Professional page
    Then user able to view the claim details for given member id in CAP Professional page
    When user get the total records for the search criteria in CAP Professional page
    Then user should be able to view the total results count at the bottom of the page in CAP Professional page

  @TC_60882
  Scenario: Verify user see the page numbers as per the no of data divided by pages size
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user enters the member id in the search field in CAP Professional page
    Then user able to view the claim details for given member id in CAP Professional page
    When user get the total records for the search criteria in CAP Professional page
    Then user see the page numbers as per the no of data divided by pages size in CAP Professional page

  @TC_60884 @Sanity
  Scenario: Verify user able to navigate through pages by using Pagination functionality
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on On Hold bucket in CAP Professional
    And user should be able to view the page numbers at bottom of the page in CAP Professional page
    When user tries to click on next arrow symbol in CAP Professional
    And user allow to navigates to next page in CAP Professional
    When user tries to click on back arrow symbol in CAP Professional
    Then user should allow to navigates to back page in CAP Professional

    #40715-As an adjudicator, I should be able to click on any Claim number from CAP Professional queue and get navigated to appropriate claims details page
  @TC_37332 @Sanity
  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on claim number in CAP Professional page
    Then user should be able to navigate to View Claim Details page
    And  User should see "Hide" option with Claim summary

  @TC_46249 @Sanity
  Scenario: Verify user able to navigate to claim summary screen only once when performed multiple clicks on Claim number
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user searches for claim number in pend bucket in CAP Professional
    And user clicks on claim number
    Then user should be able to navigate to View Claim Details page and get the claim details
    When user clicks on the same claim number again in pend bucket in CAP Professional
    Then user should be able to see already opened claim details
    And  User should see "Hide" option with Claim summary

  #41736-As an adjudicator, I should be able to view Corrected colour codings in the CAP Professional page so that I can easily identify the corrected claims details
  @TC_45620 @Sanity
  Scenario: Verify color code for corrected claims in CAP Professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user enters Corrected claim in CAP Professional search criteria
    Then user should able to view corrected claim in CAP Professional Grid
    And user should able to see vertical line beside claim number with color code "#AD71FF" in CAP Professional page
    And color indication information should be available on top of grid in CAP Professional page

  @TC_45617 @Sanity
  Scenario: Verify color code for COB In Member House in CAP Professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user enters COB In Member House claim in search criteria in CAP Professional page
    Then user should able to view COB In Member House claim in CAP Professional page
    And user should able to view patient name with color code "#008000" in CAP Professional page
    And color indication information for COB In Member House should be available on top of grid in CAP Professional page

  @TC_45618 @Sanity
  Scenario: Verify color code for COB Not In Member House in CAP Professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user enters COB Not In Member House claim in search criteria in CAP Professional page
    Then user should able to view COB Not In Member House claim in CAP Professional page
    And user should able to view patient name with color code "#FF0000" in CAP Professional page
    And color indication information for COB Not In Member House should be available on top of grid in CAP Professional page

   #60637-As an Adjudicator, When the claim is in Unclean status I want the claim to be displayed and highlighted in the Orange bar.
  @TC_60653 @Sanity
  Scenario: Verify colour coding for Unclean status claims under Pend bucket in CAP professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user enters Unclean status claim in search criteria in Pend bucket in CAP Professional
    Then user should able to view Unclean status claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Pend claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60654
  Scenario: Verify colour coding for Unclean status claims under Payer Review bucket in CAP professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Payer Review bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Payer Review bucket in CAP Professional
    Then user should able to view Unclean status Payer Review claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Payer Review claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60656
  Scenario: Verify colour coding for Unclean status claims under Management Review bucket in CAP professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Management Review bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Management Review bucket in CAP Professional
    Then user should able to view Unclean status Management Review claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Management Review claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60658
  Scenario: Verify colour coding for Unclean status claims under Approved bucket in CAP professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Approved bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Approved bucket in CAP Professional
    Then user should able to view Unclean status Approved claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Approved claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60660
  Scenario: Verify colour coding for Unclean status claims under Denied bucket in CAP professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Denied bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Denied bucket in CAP Professional
    Then user should able to view Unclean status Denied claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Denied claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60662
  Scenario: Verify colour coding for Unclean status claims under Pre Batch bucket in CAP professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Pre Batch bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Pre Batch bucket in CAP Professional
    Then user should able to view Unclean status Pre Batch claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Pre Batch claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  #50010-As an adjudicator, When I click on the 'Batch ID' from Paid tab for CAP professional So I can be able to View the Claims list, Provider List, Check Info, History Doc, and Downloads sub-tabs under Claims for Batch Tab
  @TC_51975
  Scenario: Verify all tabs should display when clicking on Batch ID under Paid tab in CAP Professional page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in CAP Professional page
    And user clicks on Batch Id
    Then user should be able to see below tabs
      | Claim List    |
      | Provider List |
      | Check Info    |
      | History Doc   |
      | Downloads     |

  @TC_51910
  Scenario: Verify by default user navigates to the View Claims List page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in CAP Professional page
    And user clicks on Batch Id
    Then user views Claim List tab by default should be "active"
    And displays all the list of claims for that Batch ID
    And user should able to see "Claim List in the Selected Batch"

  @TC_51989
  Scenario: Verify user should navigates to the Provider List page on clicking Provider List tab
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Provider List tab
    And displays all the list of provider list for that Batch ID
    And user should be able to see "Providers in the Selected Batch" label in Provider List screen

  @TC_67897
  Scenario: Verify user should navigates to the Check Info page on clicking Check Info tab
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    And displays all the list of Check Info for that Batch ID
    And user should be able to see "Check Information" label in Check Info screen

  @TC_68570
  Scenario: Verify user able to view Check Type as Regular if its not void or reissue in Check Info page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    Then user should able to see Check Type as "Regular" for Normal Check

  @TC_68574
  Scenario: Verify user able to view the check reissue information in Check Info page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for issued check in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    Then user should able to see Check Type as "ReIssue"

  @TC_68575
  Scenario: Then user able to view the check void information of that batch in Check Info page
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Check Void in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    Then user should able to see Check Type as "Void" for voided batch

  @TC_51996
  Scenario: Verify user able to navigate to the History Doc tab on clicking History Doc tab
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for issued check in CAP Professional page
    And user clicks on Batch Id
    And user clicks on History Doc
    And displays all the list of History Doc for that Batch ID
    And user should be able to see "History Of Doc in the Selected Batch" label in History Doc screen

  @TC_51998
  Scenario: Verify user able to navigate to the Downloads tab on clicking Downloads tab and verify the files when there are any files
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Check Void in CAP Professional page
    And user clicks on Batch Id
    And user clicks on Downloads
    Then user able to view the "Download EOP Letter" and "Download 835 File"

