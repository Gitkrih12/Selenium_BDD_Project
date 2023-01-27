Feature: FFS Institutional

  Background:
    Given the user is in CA Login screen
    When the user enters the valid username and password and click on login button
    When user clicks on FFS Institutional in left navigation menu
    Then the user should navigate to the FFS Institutional page

  #38960-As an adjudicator, I should be able to view FFS Institutional claims page with all claims details data so that I can search specific claim id details adding applicable filters

  @TC_39790 @Sanity
  #Scenario: Verify user should navigates to FFS Institutional screen
  #This scenario is already covered under background section


  @TC_63564
  Scenario: Verify by default user should be in the Pend state in FFS Institutional screen
    And by default user should be in Pend state results page in FFS Institutional page

  @TC_39787
  Scenario: Verify user should able to see Clam List Label in FFS Institutional screen
    And user should be able to view the Clam List Label in the FFS Institutional screen

  @TC_39665 @Sanity @beta
  Scenario: Validate user able to view all the column fields in FFS Institutional screen
    When user views Pend bucket by default should be "active" in FFS Institutional page
    Then user able to view following column fields in Pend bucket in FFS Institutional page
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

  @TC_39666 @Sanity @beta
  Scenario: Verify all the queue field details in the FFS Institutional page
    And user should be able to view following queue detail fields in FFS Institutional page
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

  @TC_39786 @Sanity @beta
  Scenario: Verify user able to view the search fields under each columns in the FFS Institutional screen
    And user able to view the Search fields under each column in FFS Institutional page

  @TC_39699 @Sanity
  Scenario: Verify Pagination in FFS Institutional page
    When user enters the member id in the search field in FFS Institutional page
    Then user able to view the claim details for given member id in FFS Institutional page
    When user get the total records for the search criteria in FFS Institutional page
    Then user should be able to view the total results count at the bottom of the page in FFS Institutional page

  @TC_63758
  Scenario: Verify user see the page numbers as per the no of data divided by pages size
    When user enters the member id in the search field in FFS Institutional page
    Then user able to view the claim details for given member id in FFS Institutional page
    When user get the total records for the search criteria in FFS Institutional page
    Then user see the page numbers as per the no of data divided by pages size in FFS Institutional page

  @TC_63813 @Sanity
  Scenario: Verify user able to navigate through pages by using Pagination functionality
    When user clicks on On Hold bucket in FFS Institutional
    And user should be able to view the page numbers at bottom of the page in FFS Institutional page
    When user tries to click on next arrow symbol in FFS Institutional
    And user allow to navigates to next page in FFS Institutional
    When user tries to click on back arrow symbol in FFS Institutional
    Then user should allow to navigates to back page in FFS Institutional

  #40716-As an adjudicator, I should be able to click on any Claim number from FFS Institutional queue and get navigated to appropriate claims details page
  @TC_46258 @Sanity @beta
  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    When user clicks on claim number in FFS Institutional page
    Then user should be able to navigate to View Claim Details page
    And  User should see "Hide" option with Claim summary

  @TC_46259 @Sanity
  Scenario: Verify user able to navigate to claim summary screen only once when performed multiple clicks on Claim number
    When user searches for claim number in pend bucket in FFS Institutional
    And user clicks on claim number
    Then user should be able to navigate to View Claim Details page and get the claim details
    When user clicks on the same claim number again in pend bucket in FFS Institutional
    Then user should be able to see already opened claim details
    And  User should see "Hide" option with Claim summary

  #41735-As an adjudicator, I should be able to view Corrected colour codings in the FFS Institutional page so that I can easily identify the corrected claims details
  @TC_43408  @Sanity
  Scenario: Verify user can Identify corrected claims from FFS Institutional page
    When user enters Corrected claim in FFS Institutional search criteria
    Then user should able to view corrected claim in FFS Institutional Grid
    And user should able to see vertical line beside claim number with color code "#AD71FF" in FFS Institutional page
    And color indication information should be available on top of grid in FFS Institutional page

  @TC_43409
  Scenario: Verify user can Identify COB In Member House from FFS Institutional page
    When user enters COB In Member House claim in search criteria in FFS Institutional page
    Then user should able to view COB In Member House claim in FFS Institutional page
    And user should able to view patient name with color code "#008000" in FFS Institutional page
    And color indication information for COB In Member House should be available on top of grid in FFS Institutional page

  @TC_43410
  Scenario: Verify user can Identify COB Not In Member House from FFS Institutional page
    When user enters COB Not In Member House claim in search criteria in FFS Institutional page
    Then user should able to view COB Not In Member House claim in FFS Institutional page
    And user should able to view patient name with color code "#FF0000" in FFS Institutional page
    And color indication information for COB Not In Member House should be available on top of grid in FFS Institutional page

  #64462-As an Adjudicator, When the claim is in Unclean status I want the claim to be displayed and highlighted in the Orange bar.
  @TC_64463
  Scenario: Verify colour coding for Unclean status claims under Pend bucket in FFS Institutional page
    When user enters Unclean status claim in search criteria in Pend bucket in FFS Institutional
    Then user should able to view Unclean status claim in FFS Institutional Grid
    And user should able to see vertical line beside unclean status Pend claim number with color code "#FFC33E" in FFS Institutional
    And color indication information for Unclean should be available on top of grid in FFS Institutional

  @TC_64464
  Scenario: Verify colour coding for Unclean status claims under Payer Review bucket in FFS Institutional page
    When user clicks on Payer Review bucket in FFS Institutional page
    When user enters Unclean status claim in search criteria in Payer Review bucket in FFS Institutional
    Then user should able to view Unclean status Payer Review claim in FFS Institutional Grid
    And user should able to see vertical line beside unclean status Payer Review claim number with color code "#FFC33E" in FFS Institutional
    And color indication information for Unclean should be available on top of grid in FFS Institutional

  @TC_64465
  Scenario: Verify colour coding for Unclean status claims under Management Review bucket in FFS Institutional page
    When user clicks on Management Review bucket in FFS Institutional page
    When user enters Unclean status claim in search criteria in Management Review bucket in FFS Institutional
    Then user should able to view Unclean status Management Review claim in FFS Institutional Grid
    And user should able to see vertical line beside unclean status Management Review claim number with color code "#FFC33E" in FFS Institutional
    And color indication information for Unclean should be available on top of grid in FFS Institutional

  @TC_64489
  Scenario: Verify colour coding for Unclean status claims under Approved bucket in FFS Institutional page
    When user clicks on Approved bucket in FFS Institutional page
    When user enters Unclean status claim in search criteria in Approved bucket in FFS Institutional
    Then user should able to view Unclean status Approved claim in FFS Institutional Grid
    And user should able to see vertical line beside unclean status Approved claim number with color code "#FFC33E" in FFS Institutional
    And color indication information for Unclean should be available on top of grid in FFS Institutional

  @TC_64490
  Scenario: Verify colour coding for Unclean status claims under Denied bucket in FFS Institutional page
    When user clicks on Denied bucket in FFS Institutional page
    When user enters Unclean status claim in search criteria in Denied bucket in FFS Institutional
    Then user should able to view Unclean status Denied claim in FFS Institutional Grid
    And user should able to see vertical line beside unclean status Denied claim number with color code "#FFC33E" in FFS Institutional
    And color indication information for Unclean should be available on top of grid in FFS Institutional

  @TC_64491
  Scenario: Verify colour coding for Unclean status claims under Pre Batch bucket in FFS Institutional page
    When user clicks on Pre Batch bucket in FFS Institutional page
    When user enters Unclean status claim in search criteria in Pre Batch bucket in FFS Institutional
    Then user should able to view Unclean status Pre Batch claim in FFS Institutional Grid
    And user should able to see vertical line beside unclean status Pre Batch claim number with color code "#FFC33E" in FFS Institutional
    And color indication information for Unclean should be available on top of grid in FFS Institutional

  #50887-As an adjudicator, When I click on the 'Batch ID' from Paid tab for FFS Institutional So I can be able to View the Claims list, Provider List, Check Info, History Doc, and Downloads sub-tabs under Claims for Batch Tab
  @TC_52060
  Scenario: Verify all tabs should display when clicking on Batch ID under Paid tab in FFS Institutional page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in FFS Institutional page
    And user clicks on Batch Id
    Then user should be able to see below tabs
      | Claim List    |
      | Provider List |
      | Check Info    |
      | History Doc   |
      | Downloads     |

  @TC_52157
  Scenario: Verify by default user navigates to the View Claims List page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in FFS Institutional page
    And user clicks on Batch Id
    Then user views Claim List tab by default should be "active"
    And displays all the list of claims for that Batch ID
    And user should able to see "Claim List in the Selected Batch"

  @TC_52169
  Scenario: Verify user navigates to the Provider List page on clicking Provider List tab
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in FFS Institutional page
    And user clicks on Batch Id
    And user clicks on the Provider List tab
    And displays all the list of provider list for that Batch ID
    And user should be able to see "Providers in the Selected Batch" label in Provider List screen

  @TC_69483
  Scenario: Verify user should navigates to the Check Info page on clicking Check Info tab
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria in FFS Institutional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    And displays all the list of Check Info for that Batch ID
    And user should be able to see "Check Information" label in Check Info screen

  @TC_69492
  Scenario: Verify user able to view Check Type as Regular if its not void or reissue in Check Info page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in FFS Institutional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    Then user should able to see Check Type as "Regular" for Normal Check

  @TC_52168
  Scenario: Verify user able to view the check reissue information in Check Info page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for issued check in FFS Institutional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    Then user should able to see Check Type as "ReIssue"

  @TC_69488
  Scenario: Verify user able to view the check void information in Check Info page
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Check Void in FFS Institutional page
    And user clicks on Batch Id
    And user clicks on the Check Info tab
    Then user should able to see Check Type as "Void" for voided batch

  @TC_52159
  Scenario: Verify user able to navigate to the History Doc page on clicking History Doc tab
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for issued check in FFS Institutional page
    And user clicks on Batch Id
    And user clicks on History Doc
    And displays all the list of History Doc for that Batch ID
    And user should be able to see "History Of Doc in the Selected Batch" label in History Doc screen

  @TC_52158
  Scenario: Verify user able to navigate to the Downloads tab on clicking Downloads tab and verify the files when there are any files
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in FFS Institutional page
    And user clicks on Batch Id
    And user clicks on Downloads
    Then user able to view the "Download EOP Letter" and "Download 835 File"

  #71913-As an Adjudicator when I click on the “Add Note on the ‘Batch ID of One claim in FFS Institutional. So that I can be able to view all the claims/Batch ID notes got updated or not
  @TC_71914
  Scenario: Verify Add Note button in Paid Bucket
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in FFS Institutional page
    Then user should see the Add Note button for given batch id

  @TC_71915
  Scenario: Verify fields in Add Note window
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in FFS Institutional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    Then user should see the "Title" "Category" and "Description" fields
    And user should see the "Add" and "Cancel" buttons

  @TC_71916
  Scenario: Verify user should be able to view all the Claim notes that are updated for that specific Batch results
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in FFS Institutional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    When user enters values in the Title Category and Description fields
    And user click on the Add button
    Then user should able to see "Added note saved successfully" message
    And user clicks on Batch Id
    When user clicks on claim number and navigates to Notes section
    Then user should able see the added note in the Notes section

  @TC_72843
  Scenario: Verify error message when user enters Category and Description fields and Title field should leave as empty
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in FFS Institutional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    When user enters values in the Category and Description fields
    And user click on the Add button
    Then user should able to see error message as "Please enter Title" message

  @TC_72847
  Scenario: Verify error message when user enters Title and Description fields and Category field should leave as empty
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in FFS Institutional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    When user enters values in the Title and Description fields
    And user click on the Add button
    Then user should able to see error message as "Please select Category" message

  @TC_72862
  Scenario: Verify error message when user enters Title and Category fields and Description field should leave as empty
    When user clicks on Paid bucket
    And user enters Batch Id in search criteria for Normal Check in FFS Institutional page
    Then user should see the Add Note button for given batch id
    When user click on the Add Note button
    When user enters values in the Title and Category fields
    And user click on the Add button
    Then user should able to see error message as "Please enter Description" message

  #41944-As an adjudicator, I should be able to view On Hold tab of FFS Institutional claims page with all claims details data
  @TC_86888
  Scenario:Validate user able to view all the column fields under On Hold bucket in FFS Institutional screen
    When user clicks on On Hold bucket in FFS Institutional
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

  #41947-As an adjudicator, I should be able to view Payer Review tab of FFS Institutional claims page with all claims details data
  @TC_86889
  Scenario: Validate user able to view all the column fields under Payer Review bucket in FFS Institutional screen
    When user clicks on Payer Review bucket in FFS Institutional page
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

  #41950-As an adjudicator, I should be able to view Management Review tab of FFS Institutional claims page with all claims details data
  @TC_87224
  Scenario: Validate user able to view all the column fields under Management Review bucket in FFS Institutional screen
    When user clicks on Management Review bucket in FFS Institutional page
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

  #41953-As an adjudicator, I should be able to view Approved tab of FFS Institutional claims page with all claims details data
  @TC_87231
  Scenario: Validate user able to view all the column fields under Approved bucket in FFS Institutional screen
    When user clicks on Approved bucket in FFS Institutional page
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

  #41956-As an adjudicator, I should be able to view Denied tab of FFS Institutional claims page with all claims details data
  @TC_87430
  Scenario: Validate user able to view all the column fields under Denied bucket in FFS Institutional screen
    When user clicks on Denied bucket
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

  #41959-As an adjudicator, I should be able to view Pre Batch tab of FFS Institutional claims page with all claims details data
  @TC_87492
  Scenario: Validate user able to view all the column fields under Pre-Batch bucket in FFS Institutional screen
    When user clicks on Pre Batch bucket in FFS Institutional page
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

  @TC_87514
  Scenario: Verify Batch Claims To Pay button when select claim number from Pre Batch bucket
    When user clicks on Pre Batch bucket in FFS Institutional page
    Then user should able to see Batch Claims To Pay button in disabled mode
    When user selects claim number in Pre Batch bucket
    Then user should able to see Batch Claims To Pay button in enabled mode

  @TC_87527
  Scenario: Verify Batch Claims To Pay button when select multiple claim numbers from Pre Batch bucket
    When user clicks on Pre Batch bucket in FFS Institutional page
    Then user should able to see Batch Claims To Pay button in disabled mode
    When user selects all claim numbers in Pre Batch bucket
    Then user should able to see Batch Claims To Pay button in enabled mode

  #87546-As an adjudicator, when I select the claim from Approved bucket and click on the 'Pre-Batch Pay' button so that the claim will be moved from Approved to Pre Batch
  @TC_87547
  Scenario: Verify Pre batch Pay button when select claim number from Approved bucket
    When user clicks on Approved bucket in FFS Institutional page
    Then user should able to see Pre Batch Pay button in disabled mode
    When user selects claim number
    Then user should able to see Pre Batch Pay button in enabled mode
    When user un selects claim number
    Then user should able to see Pre Batch Pay button in disabled mode

  @TC_87549
  Scenario: Verify Pre batch Pay button when select multiple claim numbers from Approved bucket
    When user clicks on Approved bucket in FFS Institutional page
    Then user should able to see Pre Batch Pay button in disabled mode
    When user selects all claim numbers
    Then user should able to see Pre Batch Pay button in enabled mode
    When user un selects all claim numbers
    Then user should able to see Pre Batch Pay button in disabled mode

  @TC_87550
  Scenario: Verify user should be able to see  PreBatch To Pay Validation screen on clicking Pre Batch Pay button
    When user clicks on Approved bucket in FFS Institutional page
    When user selects claim number
    When user clicks on Pre Batch Pay button
    Then user should able to see "PreBatch To Pay Validation" screen

  @TC_87970
  Scenario: Validate user able to view all the column fields under PreBatch Pay validation bucket in FFS Institutional screen
    When user clicks on Approved bucket in FFS Institutional page
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

  @TC_87971
  Scenario: Verify tabs in PreBatch To Pay Validation screen
    When user clicks on Approved bucket in FFS Institutional page
    And user selects claim number
    When user clicks on Pre Batch Pay button
    Then user should able to see "PreBatch To Pay Validation" screen
    And user should able to see following tabs in PreBatch To Pay Validation screen
      | Valid   |
      | Invalid |

  @TC_87976
  Scenario: Verify buttons in Valid tab under PreBatch To Pay Validation screen
    When user clicks on Approved bucket in FFS Institutional page
    When user selects claim number
    When user clicks on Pre Batch Pay button
    Then user should able to see "PreBatch To Pay Validation" screen
    When user is in "Valid" tab
    Then user should able to see "Remove" and "Confirm Pre-Batch Pay" buttons

  @TC_87991
  Scenario: Verify buttons in Invalid tab under PreBatch To Pay Validation screen
    When user clicks on Approved bucket in FFS Institutional page
    When user selects claim number
    When user clicks on Pre Batch Pay button
    Then user should able to see "PreBatch To Pay Validation" screen
    When user clicks on Invalid tab
    Then user should able to see "Pend" "On Hold" and "Management Review" buttons

  #88010-As Claims Adjudicator, I should have the ability to select a claim or set of claims in denied status and add to pre-batch list, so that claims can be batched together for pay out.
  @TC_88021
  Scenario: Verify Pre batch Deny button when select claim number from Denied bucket
    When user clicks on Denied bucket in FFS Institutional page
    Then user should able to see Pre Batch Deny button in disabled mode
    When user selects claim number in Denied bucket
    Then user should able to see Pre Batch Deny button in enabled mode
    When user un selects claim number in Denied bucket
    Then user should able to see Pre Batch Deny button in disabled mode

  @TC_88023
  Scenario: Verify Pre batch Pay button when select multiple claim numbers from Denied bucket
    When user clicks on Denied bucket in FFS Institutional page
    Then user should able to see Pre Batch Deny button in disabled mode
    When user selects all claim numbers in Denied bucket
    Then user should able to see Pre Batch Deny button in enabled mode
    When user un selects all claim numbers in Denied bucket
    Then user should able to see Pre Batch Deny button in disabled mode

  #88025-As an adjudicator, I should be able to view Batch To Pay tab of FFS Institutional claims page with all claims details data
  @TC_88027
  Scenario: Verify tabs in Batch To Pay Validation screen
    When user clicks on Batch To Pay bucket
    Then user should be able to see following tabs in Batch To Pay bucket
      | To Be Signed Off |
      | Signed Off       |
      | Sent for Payment |
      | EFT Payment      |

  @TC_88028
  Scenario: Validate user able to view all the column fields in To Be Signed Off under Batch To Pay bucket in FFS Institutional screen
    When user clicks on Batch To Pay bucket
    And user is on "To Be Signed Off" tab
    Then user should be see following column fields in To Be Signed Off
      | Batch ID               |
      | Payee ID               |
      | Payee                  |
      | Payer                  |
      | Net Paid Amount($)     |
      | Total Billed Amount($) |

  @TC_88029
  Scenario: Verify buttons in To Be Signed Off tab under Batch To Pay bucket
    When user clicks on Batch To Pay bucket
    And user is on "To Be Signed Off" tab
    Then user should able to see Unbatch EFT Payment Signed Off buttons in disabled mode
    When user selects Batch ID
    Then user should able to see Unbatch EFT Payment Signed Off buttons in enabled mode

  @TC_88032
  Scenario: Validate user able to view all the column fields in Signed Off under Batch To Pay bucket in FFS Institutional screen
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

  @TC_88033
  Scenario: Validate user able to view all the column fields in Sent for Payment under Batch To Pay bucket in FFS Institutional screen
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

  @TC_88034
  Scenario: Verify user should be able to see Upload Great Plains File button in Sent for Payment tab under Batch to Pay bucket
    When user clicks on Batch To Pay bucket
    And user clicks on Sent for Payment tab
    Then user should able to see "Upload Great Plains File" button

  @TC_88037
  Scenario: Validate user able to view all the column fields in EFT Payment under Batch To Pay bucket in FFS Institutional screen
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

  @TC_88038
  Scenario: Verify buttons in EFT Payment tab under Batch To Pay bucket
    When user clicks on Batch To Pay bucket
    And user clicks on EFT Payment tab
    Then user should be able to see Move To Paid and To Be Signed Off buttons in disabled mode
    When user selects Batch ID in EFT Payment tab
    Then user should be able to see Move To Paid and To Be Signed Off buttons in enabled mode

  #79191-As an adjudicator, When I click on the 'Batch ID' from Batch to Pay tab(To Be Signed Off, Signed Off, Sent for Payment, EFT Payment) for FFS Institutional So I can be able to View the Claims list  for Batch Tab
  @TC_88296
  Scenario: Verify user should be able to see Claims List on clicking on Batch Id in To Be Signed Off tab
    When user clicks on Batch To Pay bucket
    And user is on "To Be Signed Off" tab
    And user clicks on Batch Id in To Be Signed Off tab
    Then user should be able to see "Claim List in the Selected Batch - " for the selected Batch Id

  @TC_88298
  Scenario: Verify user should be able to see Claims List on clicking on Batch Id in Signed Off tab
    When user clicks on Batch To Pay bucket
    And user clicks on Signed Off tab
    And user clicks on Batch Id in Signed Off tab
    Then user should be able to see "Claim List in the Selected Batch - " for the selected Batch Id

  @TC_88299
  Scenario: Verify user should be able to see Claims List on clicking on Batch Id in Sent for Payment tab
    When user clicks on Batch To Pay bucket
    And user clicks on Sent for Payment tab
    And user clicks on Batch Id in Sent for Payment tab
    Then user should be able to see "Claim List in the Selected Batch - " for the selected Batch Id

  @TC_88300
  Scenario: Verify user should be able to see Claims List on clicking on Batch Id in EFT Payment tab
    When user clicks on Batch To Pay bucket
    And user clicks on EFT Payment tab
    And user clicks on Batch Id in EFT Payment tab
    Then user should be able to see "Claim List in the Selected Batch - " for the selected Batch Id

  #89719-As an adjudicator, I should be able to view Paid tab of FFS Institutional claims page with all claims details data
  @TC_89723
  Scenario: Validate user able to view all the column fields under Paid bucket in FFS Institutional screen
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

  #89736-As an adjudicator, I should be able to view Draft tab of FFS Institutional claims page with all claims details data
  @TC_89747
  Scenario: Validate user able to view all the column fields under Draft bucket in FFS Institutional screen
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

  #89748-As an adjudicator, I should be able to view Rejected tab of FFS Institutional claims page with all claims details data
  @TC_89750
  Scenario: Validate user able to view all the column fields under Rejected bucket in FFS Institutional screen
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




