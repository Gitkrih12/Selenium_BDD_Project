Feature: CAP Professional

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    When user clicks on CAP Professional in left navigation menu
    Then the user should navigate to the CAP Professional page

  #38959-As an adjudicator, I should be able to view CAP professional claims page with all claims details data so that I can search specific claim id details adding applicable filters
  @TC_39033 @Sanity
  #Scenario: Verify user should navigates to CAP Professional screen
    # This scenario is already covered under background section

  @TC_39056
  Scenario: Verify by default user should be in the Pend state in CAP Professional screen
    And by default user should be in Pend state results page in CAP Professional page

  @TC_39061
  Scenario: Verify user should able to see Clam List Label in CAP Professional screen
    And user should be able to view the Clam List Label in the CAP Professional screen

  @TC_39051 @Sanity @beta
  Scenario: Validate user able to view all the column fields for Pend bucket in CAP Professional screen
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

  @TC_39054 @Sanity @beta
  Scenario: Verify all the queue field details in the CAP Professional page
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

  @TC_39059 @Sanity @beta
  Scenario: Verify user able to view the search fields under each columns in the CAP Professional screen
    And user able to view the Search fields under each column in CAP Professional page

  @TC_39228 @Sanity
  Scenario: Verify Pagination in CAP Professional page
    When user enters the member id in the search field in CAP Professional page
    Then user able to view the claim details for given member id in CAP Professional page
    When user get the total records for the search criteria in CAP Professional page
    Then user should be able to view the total results count at the bottom of the page in CAP Professional page

  @TC_60882
  Scenario: Verify user see the page numbers as per the no of data divided by pages size
    When user enters the member id in the search field in CAP Professional page
    Then user able to view the claim details for given member id in CAP Professional page
    When user get the total records for the search criteria in CAP Professional page
    Then user see the page numbers as per the no of data divided by pages size in CAP Professional page

  @TC_60884 @Sanity
  Scenario: Verify user able to navigate through pages by using Pagination functionality
    When user clicks on On Hold bucket in CAP Professional
    And user should be able to view the page numbers at bottom of the page in CAP Professional page
    When user tries to click on next arrow symbol in CAP Professional
    And user allow to navigates to next page in CAP Professional
    When user tries to click on back arrow symbol in CAP Professional
    Then user should allow to navigates to back page in CAP Professional

    #40715-As an adjudicator, I should be able to click on any Claim number from CAP Professional queue and get navigated to appropriate claims details page
  @TC_37332 @Sanity
  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    When user clicks on claim number in CAP Professional page
    Then user should be able to navigate to View Claim Details page
    And  User should see "Hide" option with Claim summary

  @TC_46249 @Sanity
  Scenario: Verify user able to navigate to claim summary screen only once when performed multiple clicks on Claim number
    When user searches for claim number in pend bucket in CAP Professional
    And user clicks on claim number
    Then user should be able to navigate to View Claim Details page and get the claim details
    When user clicks on the same claim number again in pend bucket in CAP Professional
    Then user should be able to see already opened claim details
    And  User should see "Hide" option with Claim summary

  #41736-As an adjudicator, I should be able to view Corrected colour codings in the CAP Professional page so that I can easily identify the corrected claims details
  @TC_45620 @Sanity
  Scenario: Verify color code for corrected claims in CAP Professional page
    When user enters Corrected claim in CAP Professional search criteria
    Then user should able to view corrected claim in CAP Professional Grid
    And user should able to see vertical line beside claim number with color code "#AD71FF" in CAP Professional page
    And color indication information should be available on top of grid in CAP Professional page

  @TC_45617 @Sanity
  Scenario: Verify color code for COB In Member House in CAP Professional page
    When user enters COB In Member House claim in search criteria in CAP Professional page
    Then user should able to view COB In Member House claim in CAP Professional page
    And user should able to view patient name with color code "#008000" in CAP Professional page
    And color indication information for COB In Member House should be available on top of grid in CAP Professional page

  @TC_45618 @Sanity
  Scenario: Verify color code for COB Not In Member House in CAP Professional page
    When user enters COB Not In Member House claim in search criteria in CAP Professional page
    Then user should able to view COB Not In Member House claim in CAP Professional page
    And user should able to view patient name with color code "#FF0000" in CAP Professional page
    And color indication information for COB Not In Member House should be available on top of grid in CAP Professional page

   #60637-As an Adjudicator, When the claim is in Unclean status I want the claim to be displayed and highlighted in the Orange bar.
  @TC_60653 @Sanity
  Scenario: Verify colour coding for Unclean status claims under Pend bucket in CAP professional page
    When user enters Unclean status claim in search criteria in Pend bucket in CAP Professional
    Then user should able to view Unclean status claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Pend claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60654
  Scenario: Verify colour coding for Unclean status claims under Payer Review bucket in CAP professional page
    When user clicks on Payer Review bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Payer Review bucket in CAP Professional
    Then user should able to view Unclean status Payer Review claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Payer Review claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60656
  Scenario: Verify colour coding for Unclean status claims under Management Review bucket in CAP professional page
    When user clicks on Management Review bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Management Review bucket in CAP Professional
    Then user should able to view Unclean status Management Review claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Management Review claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60658
  Scenario: Verify colour coding for Unclean status claims under Approved bucket in CAP professional page
    When user clicks on Approved bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Approved bucket in CAP Professional
    Then user should able to view Unclean status Approved claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Approved claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60660
  Scenario: Verify colour coding for Unclean status claims under Denied bucket in CAP professional page
    When user clicks on Denied bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Denied bucket in CAP Professional
    Then user should able to view Unclean status Denied claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Denied claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  @TC_60662
  Scenario: Verify colour coding for Unclean status claims under Pre Batch bucket in CAP professional page
    When user clicks on Pre Batch bucket in CAP Professional page
    When user enters Unclean status claim in search criteria in Pre Batch bucket in CAP Professional
    Then user should able to view Unclean status Pre Batch claim in CAP Professional Grid
    And user should able to see vertical line beside unclean status Pre Batch claim number with color code "#FFC33E" in CAP Professional
    And color indication information for Unclean should be available on top of grid in CAP Professional

  #50010-As an adjudicator, When I click on the 'Batch ID' from Paid tab for CAP professional So I can be able to View the Claims list, Provider List, Check Info, History Doc, and Downloads sub-tabs under Claims for Batch Tab
  @TC_51975 @beta
  Scenario: Verify all tabs should display when clicking on Batch ID under Paid tab in CAP Professional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in CAP Professional page
    And user clicks on Batch Id
    Then user should be able to see below tabs
      | Claim List    |
      | Provider List |
      | Check Info    |
      | History Doc   |
      | Downloads     |

  @TC_51980 @Sanity
  Scenario: Verify by default user navigates to the View Claims List page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in CAP Professional page
    And user clicks on Batch Id
    Then user views Claim List tab by default should be "active"
    And displays all the list of claims for that Batch ID
    And user should able to see "Claim List in the Selected Batch"

  @TC_51989
  Scenario: Verify user should navigates to the Provider List page on clicking Provider List tab
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Provider List tab
    And displays all the list of provider list for that Batch ID
    And user should be able to see "Providers in the Selected Batch" label in Provider List screen


  @TC_67897 @Sanity @beta
  Scenario: Verify user should navigates to the Check Info page on clicking Check Info tab
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    And displays all the list of Check Info for that Batch ID
    And user should be able to see "Check Information" label in Check Info screen

  @TC_68570
  Scenario: Verify user able to view Check Type as Regular if its not void or reissue in Check Info page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    Then user should able to see Check Type as "Regular" for Normal Check

  @TC_68574
  Scenario: Verify user able to view the check reissue information in Check Info page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for issued check in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    Then user should able to see Check Type as "ReIssue"

  @TC_68575
  Scenario: Verify user able to view the check void information in Check Info page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Check Void in CAP Professional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    Then user should able to see Check Type as "Void" for voided batch

  @TC_51996 @Sanity
  Scenario: Verify user able to navigate to the History Doc tab on clicking History Doc tab
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for issued check in CAP Professional page
    And user clicks on Batch Id
    And user clicks on History Doc
    And displays all the list of History Doc for that Batch ID
    And user should be able to see "History Of Doc in the Selected Batch" label in History Doc screen

  @TC_51998 @Sanity @beta
  Scenario: Verify user able to navigate to the Downloads tab on clicking Downloads tab and verify the files when there are any files
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Check Void in CAP Professional page
    And user clicks on Batch Id
    And user clicks on Downloads
    Then user able to view the "Download EOP Letter" and "Download 835 File"

  #71862-As an Adjudicator when I click on the “Add Note on the ‘Batch ID of One claim in CAP Professional. So that I can be able to view all the claims/Batch ID notes got updated or not.
  @TC_71864
  Scenario: Verify Add Note button in Paid Bucket
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in CAP Professional page
    Then user should see the Add Note button for given batch id

  @TC_71865 @Sanity
  Scenario: Verify fields in Add Note window
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in CAP Professional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    Then user should see the "Title" "Category" and "Description" fields
    And user should see the "Add" and "Cancel" buttons

  @TC_71868 @Sanity
  Scenario: Verify user should be able to view all the Claim notes that are updated for that specific Batch results
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in CAP Professional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    When user enters values in the Title Category and Description fields
    And user click on the Add button
    Then user should able to see "Added note saved successfully" message
    And user clicks on Batch Id
    When user clicks on claim number and navigates to Notes section
    Then user should able see the added note in the Notes section

  @TC_72837 @Sanity
  Scenario: Verify error message when user enters Category and Description fields and Title field should leave as empty
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in CAP Professional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    When user enters values in the Category and Description fields
    And user click on the Add button
    Then user should able to see error message as "Please enter Title" message

  @TC_72838 @Sanity
  Scenario: Verify error message when user enters Title and Description fields and Category field should leave as empty
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in CAP Professional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    When user enters values in the Title and Description fields
    And user click on the Add button
    Then user should able to see error message as "Please select Category" message

  @TC_72840 @Sanity
  Scenario: Verify error message when user enters Title and Category fields and Description field should leave as empty
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in CAP Professional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    When user enters values in the Title and Category fields
    And user click on the Add button
    Then user should able to see error message as "Please enter Description" message

  #41943- As an adjudicator, I should be able to view On Hold tab of CAP professional claims page with all claims details data
  @TC_81009
  Scenario: Validate user able to view all the column fields under On Hold bucket in CAP Professional screen
    When user clicks on On Hold bucket in CAP Professional
    Then user able to view following column fields in On Hold bucket
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

  #41946-As an adjudicator, I should be able to view Payer Review tab of CAP professional claims page with all claims details data
  @TC_81010
  Scenario: Validate user able to view all the column fields under Payer Review bucket in CAP Professional screen
    When user clicks on Payer Review bucket in CAP Professional page
    Then user able to view following column fields in Payer Review bucket
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

  #41949-As an adjudicator, I should be able to view Management Review tab of CAP professional claims page with all claims details data
  @TC_81011
  Scenario: Validate user able to view all the column fields under Management Review bucket in CAP Professional screen
    When user clicks on Management Review bucket in CAP Professional page
    Then user able to view following column fields in Management Review bucket
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

  #41952-As an adjudicator, I should be able to view Approved tab of CAP professional claims page with all claims details data
  @TC_81012
  Scenario: Validate user able to view all the column fields under Approved bucket in CAP Professional screen
    When user clicks on Approved bucket in CAP Professional page
    Then user able to view following column fields in Approved bucket
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

  #41955- As an adjudicator, I should be able to view Denied tab of CAP professional claims page with all claims details data
  @TC_81013
  Scenario: Validate user able to view all the column fields under Denied bucket in CAP Professional screen
    When user clicks on Denied bucket in CAP Professional page
    Then user able to view following column fields in Denied bucket
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

  #41958- As an adjudicator, I should be able to view Pre Batch tab of CAP professional claims page with all claims details data
  @TC-81014
  Scenario: Validate user able to view all the column fields under Pre-Batch bucket in CAP Professional screen
    When user clicks on Pre Batch bucket in CAP Professional page
    Then user able to view following column fields in Pre Batch bucket
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

  @TC_81015
  Scenario: Verify Batch Claims To Pay button when select claim number from Pre Batch bucket
    When user clicks on Pre Batch bucket in CAP Professional page
    Then user should able to see Batch Claims To Pay button in disabled mode
    When user selects claim number in Pre Batch bucket
    Then user should able to see Batch Claims To Pay button in enabled mode

  @TC_81016
  Scenario: Verify Batch Claims To Pay button when select multiple claim numbers from Pre Batch bucket
    When user clicks on Pre Batch bucket in CAP Professional page
    Then user should able to see Batch Claims To Pay button in disabled mode
    When user selects all claim numbers in Pre Batch bucket
    Then user should able to see Batch Claims To Pay button in enabled mode

  #81017 - As an adjudicator, when I select the claim from Approved bucket and click on the 'Pre-Batch Pay' button so that the claim will be moved from Approved to Pre Batch
  @TC_81018
  Scenario: Verify Pre batch Pay button when select claim number from Approved bucket
    When user clicks on Approved bucket in CAP Professional page
    Then user should able to see Pre Batch Pay button in disabled mode
    When user selects claim number
    Then user should able to see Pre Batch Pay button in enabled mode
    When user un selects claim number
    Then user should able to see Pre Batch Pay button in disabled mode

  @TC_81019
  Scenario: Verify Pre batch Pay button when select multiple claim numbers from Approved bucket
    When user clicks on Approved bucket in CAP Professional page
    Then user should able to see Pre Batch Pay button in disabled mode
    When user selects all claim numbers
    Then user should able to see Pre Batch Pay button in enabled mode
    When user un selects all claim numbers
    Then user should able to see Pre Batch Pay button in disabled mode

  @TC_81020
  Scenario: Verify user should be able to see  PreBatch To Pay Validation screen on clicking Pre Batch Pay button
    When user clicks on Approved bucket in CAP Professional page
    When user selects claim number
    When user clicks on Pre Batch Pay button
    Then user should able to see "PreBatch To Pay Validation" screen

  @TC_81021
  Scenario: Validate user able to view all the column fields under PreBatch Pay validation bucket in CAP Professional screen
    When user clicks on Approved bucket in CAP Professional page
    Then user should able to see Pre Batch Pay button in disabled mode
    When user selects claim number
    Then user should able to see Pre Batch Pay button in enabled mode
    When user clicks on Pre Batch Pay button
    Then user should able to see "PreBatch To Pay Validation" screen
    And user able to view following column fields in PreBatch To Pay Validation bucket
      | Claim Number           |
      | Member ID              |
      | Rendering Provider NPI |
      | DOS From               |
      | DOS To                 |
      | Total Charges($)       |
      | Net Pay Amt($)         |
      | Received Date          |
      | Validation Description |

  @TC_81022
  Scenario: Verify tabs in PreBatch To Pay Validation screen
    When user clicks on Approved bucket in CAP Professional page
    And user selects claim number
    When user clicks on Pre Batch Pay button
    Then user should able to see "PreBatch To Pay Validation" screen
    And user should able to see following tabs in PreBatch To Pay Validation screen
      | Valid   |
      | Invalid |

  @TC_81023
  Scenario: Verify buttons in Valid tab under PreBatch To Pay Validation screen
    When user clicks on Approved bucket in CAP Professional page
    When user selects claim number
    When user clicks on Pre Batch Pay button
    Then user should able to see "PreBatch To Pay Validation" screen
    When user is in "Valid" tab
    Then user should able to see "Remove" and "Confirm Pre-Batch Pay" buttons

  @TC_81024
  Scenario: Verify buttons in Invalid tab under PreBatch To Pay Validation screen
    When user clicks on Approved bucket in CAP Professional page
    When user selects claim number
    When user clicks on Pre Batch Pay button
    Then user should able to see "PreBatch To Pay Validation" screen
    When user clicks on Invalid tab
    Then user should able to see "Pend" "On Hold" and "Management Review" buttons

  #81025- As Claims Adjudicator, I should have the ability to select a claim or set of claims in denied status and add to pre-batch list, so that claims can be batched together for pay out.
  @TC_81026
  Scenario: Verify Pre batch Deny button when select claim number from Denied bucket
    When user clicks on Denied bucket in CAP Professional page
    Then user should able to see Pre Batch Deny button in disabled mode
    When user selects claim number in Denied bucket
    Then user should able to see Pre Batch Deny button in enabled mode
    When user un selects claim number in Denied bucket
    Then user should able to see Pre Batch Deny button in disabled mode

  @TC_81027
  Scenario: Verify Pre batch Pay button when select multiple claim numbers from Denied bucket
    When user clicks on Denied bucket in CAP Professional page
    Then user should able to see Pre Batch Deny button in disabled mode
    When user selects all claim numbers in Denied bucket
    Then user should able to see Pre Batch Deny button in enabled mode
    When user un selects all claim numbers in Denied bucket
    Then user should able to see Pre Batch Deny button in disabled mode

  #81297-As an adjudicator, I should be able to view Batch To Pay tab of CAP professional claims page with all claims details data
  @TC_81298
  Scenario: Verify tabs in Batch To Pay Validation screen
    When user clicks on Batch To Pay bucket
    Then user should be able to see following tabs in Batch To Pay bucket
      | To Be Signed Off |
      | Signed Off       |
      | Sent for Payment |
      | EFT Payment      |

  @TC_81317
  Scenario: Validate user able to view all the column fields in To Be Signed Off under Batch To Pay bucket in CAP Professional screen
    When user clicks on Batch To Pay bucket
    And user is on "To Be Signed Off" tab
    Then user should be see following column fields in To Be Signed Off
      | Batch ID               |
      | Payee ID               |
      | Payee                  |
      | Payer                  |
      | Net Paid Amount($)     |
      | Total Billed Amount($) |

  @TC_81318
  Scenario: Verify buttons in To Be Signed Off tab under Batch To Pay bucket
    When user clicks on Batch To Pay bucket
    And user is on "To Be Signed Off" tab
    Then user should able to see Unbatch EFT Payment Signed Off buttons in disabled mode
    When user selects Batch ID
    Then user should able to see Unbatch EFT Payment Signed Off buttons in enabled mode

  @TC_81319
  Scenario: Validate user able to view all the column fields in Signed Off under Batch To Pay bucket in CAP Professional screen
    When user clicks on Batch To Pay bucket
    And user clicks on Signed Off tab
    Then user should be see following column fields in Signed Off
      | Batch ID               |
      | Payee ID               |
      | Payee                  |
      | Payer                  |
      | Net Paid Amount($)     |
      | Total Billed Amount($) |
      | Signed Off Date        |

  @TC_81320
  Scenario: Validate user able to view all the column fields in Sent for Payment under Batch To Pay bucket in CAP Professional screen
    When user clicks on Batch To Pay bucket
    And user clicks on Sent for Payment tab
    Then user should be see following column fields in Sent for Payment
      | Batch ID               |
      | Payee ID               |
      | Payee                  |
      | Payer                  |
      | Net Paid Amount($)     |
      | Total Billed Amount($) |
      | Date Sent To Acc.      |

  @TC_81321
  Scenario: Verify user should be able to see Upload Great Plains File button in Sent for Payment tab under Batch to Pay bucket
    When user clicks on Batch To Pay bucket
    And user clicks on Sent for Payment tab
    Then user should able to see "Upload Great Plains File" button

  @TC_81323
  Scenario: Validate user able to view all the column fields in EFT Payment under Batch To Pay bucket in CAP Professional screen
    When user clicks on Batch To Pay bucket
    And user clicks on EFT Payment tab
    Then user should be see following column fields in EFT Payment
      | Batch ID           |
      | Payee ID           |
      | Payee              |
      | Payer              |
      | Net Paid Amount($) |
      | Check Number       |
      | Check Issue Date   |

  @TC_85235
  Scenario: Verify buttons in EFT Payment tab under Batch To Pay bucket
    When user clicks on Batch To Pay bucket
    And user clicks on EFT Payment tab
    Then user should be able to see Move To Paid and To Be Signed Off buttons in disabled mode
    And user should be able to see Re Generate EFT button in enabled mode
    When user selects Batch ID in EFT Payment tab
    Then user should be able to see Move To Paid and To Be Signed Off buttons in enabled mode

  #79189-As an adjudicator, When I click on the 'Batch ID' from Batch to Pay tab(To Be Signed Off, Signed Off, Sent for Payment, EFT Payment) for CAP professional So I can be able to View the Claims list  for Batch Tab
  @TC_85236
  Scenario: Verify user should be able to see Claims List on clicking on Batch Id in To Be Signed Off tab
    When user clicks on Batch To Pay bucket
    And user is on "To Be Signed Off" tab
    And user clicks on Batch Id in To Be Signed Off tab
    Then user should be able to see "Claim List in the Selected Batch - " for the selected Batch Id

  @TC_85237
  Scenario: Verify user should be able to see Claims List on clicking on Batch Id in Signed Off tab
    When user clicks on Batch To Pay bucket
    And user clicks on Signed Off tab
    And user clicks on Batch Id in Signed Off tab
    Then user should be able to see "Claim List in the Selected Batch - " for the selected Batch Id

  @TC_85240
  Scenario: Verify user should be able to see Claims List on clicking on Batch Id in Sent for Payment tab
    When user clicks on Batch To Pay bucket
    And user clicks on Sent for Payment tab
    And user clicks on Batch Id in Sent for Payment tab
    Then user should be able to see "Claim List in the Selected Batch - " for the selected Batch Id

  @TC_85241
  Scenario: Verify user should be able to see Claims List on clicking on Batch Id in EFT Payment tab
    When user clicks on Batch To Pay bucket
    And user clicks on EFT Payment tab
    And user clicks on Batch Id in EFT Payment tab
    Then user should be able to see "Claim List in the Selected Batch - " for the selected Batch Id

  #85788-As an adjudicator, I should be able to view Paid tab of CAP professional claims page with all claims details data
  @TC_85789
  Scenario: Validate user able to view all the column fields under Paid bucket in CAP Professional screen
    When user clicks on Paid bucket
    Then user able to view following column fields in Paid bucket
      | Batch ID           |
      | Payee ID           |
      | Payee              |
      | Payer              |
      | Net Paid Amount($) |
      | Check Number       |
      | Check Issue Date   |
      | Action             |

  #85791-As an adjudicator, I should be able to view Draft tab of CAP professional claims page with all claims details data
  @TC_85792
  Scenario: Validate user able to view all the column fields under Draft bucket in CAP Professional screen
    When user clicks on Draft bucket
    Then user able to view following column fields in Draft bucket
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

  #85802-As an adjudicator, I should be able to view Rejected tab of CAP professional claims page with all claims details data
  @TC_85976
  Scenario: Validate user able to view all the column fields under Rejected bucket in CAP Professional screen
    When user clicks on Reject bucket
    Then user able to view following column fields in Reject bucket
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







