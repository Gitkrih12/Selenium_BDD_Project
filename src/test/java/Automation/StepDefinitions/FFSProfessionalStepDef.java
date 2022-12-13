package Automation.StepDefinitions;

import Automation.PageObjects.FFSProfessionalPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FFSProfessionalStepDef extends FFSProfessionalPage {

    //Scenario: Verify user should navigates to FFS Professional screen
    @When("user clicks on FFS Professional in left navigation menu")
    public void user_clicks_on_ffs_professional_in_left_navigation_menu() {
        clickOnFFSProfessional();

    }
    @Then("the user should navigate to the FFS Professional page")
    public void the_user_should_navigate_to_the_ffs_professional_page() throws InterruptedException {
        verifyFFSProfessionalPage();
    }
    //Scenario: Validate user able to view all the column fields for Pend bucket in FFS Professional screen
    @When("user views Pend bucket by default should be {string}")
    public void user_views_pend_bucket_by_default_should_be(String state) throws InterruptedException{
        verifyPendStateByDefault(state);
    }
    @Then("user able to view following column fields in Pend bucket")
    public void user_able_to_view_following_column_fields_in_pend_bucket(DataTable columnList) throws InterruptedException {
        verifyFFSProfessionalPendColumnFields(columnList);
    }

    //Scenario: Verify all the queue field details in the FFS Professional page
    @Then("user should be able to view following queue detail fields")
    public void user_should_be_able_to_view_following_queue_detail_fields(DataTable queueList) throws InterruptedException{
        verifyQueuesInFFSProfessional(queueList);
    }

    //Scenario: Verify by default user should be in the Pend state in FFS Professional screen
    @Then("by default user should be in Pend state results page")
    public void by_default_user_should_be_in_pend_state_results_page() throws InterruptedException {
        verifyUserByDefaultInPendStateResultsPage();
    }

    //Scenario: Verify user should able to see Clam List Label in FFS Professional screen
    @Then("user should be able to view the Clam List Label in the FFS Professional screen")
    public void user_should_be_able_to_view_the_clam_list_label_in_the_ffs_professional_screen() {
        verifyClaimListLabel();
    }
    //Scenario: Verify user able to view the search fields under each columns in the FFS Professional screen
    @Then("user able to view the Search fields under each column in FFS Professional page")
    public void user_able_to_view_the_search_fields_under_each_column_in_ffs_professional_page() {
        verifySearchFieldsUnderEachColumnInFFSProfessional();
    }

    //Scenario: Validate pagination in FFS Professional page
    @When("user enters the member id in the search field in FFS Professional page")
    public void user_enters_the_member_id_in_the_search_field_in_ffs_professional_page() throws InterruptedException {
        enterMemberIdInSearchFieldForPaginationInFFSProfessional();
    }
    @Then("user able to view the claim details for given member id in FFS Professional page")
    public void user_able_to_view_the_claim_details_for_given_member_id_in_ffs_professional_page() {
        validateMemberIDResultInFFSProfessional();
    }
    @When("user get the total records for the search criteria in FFS Professional page")
    public void user_get_the_total_records_for_the_search_criteria_in_ffs_professional_page() {
        getAllMemberIdResults();
    }
    @Then("user should be able to view the total results count at the bottom of the page in FFS Professional page")
    public void user_should_be_able_to_view_the_total_results_count_at_the_bottom_of_the_page_in_ffs_professional_page() {
        verifyTotalResultsForGivenSearch();
    }

    //Scenario: Verify user see the page numbers as per the no of data divided by pages size
    @Then("user see the page numbers as per the no of data divided by pages size in FFS Professional page")
    public void user_see_the_page_numbers_as_per_the_no_of_data_divided_by_pages_size_in_ffs_professional_page() {
        verifyPageSizeDividedByNoOfRecordsInTheGrid();
    }

    //Scenario: Verify user able to navigate through pages by using Pagination functionality
    @When("user clicks on Hold bucket")
    public void user_clicks_on_hold_bucket() {
        clickOnOnHold();
    }
    @When("user should be able to view the page numbers at bottom of the page in FFS Professional page")
    public void user_should_be_able_to_view_the_page_numbers_at_bottom_of_the_page_in_ffs_professional_page() throws InterruptedException {
        verifyPageNumbersAtBottomOfPage();
    }
    @When("user tries to click on next arrow symbol in FFS Professional")
    public void user_tries_to_click_on_next_arrow_symbol_in_ffs_professional() {
        clickOnNextButton();
    }
    @When("user allow to navigates to next page in FFS Professional")
    public void user_allow_to_navigates_to_next_page_in_ffs_professional() {
        verifyUserNavigatesToNextPage();
    }
    @When("user tries to click on back arrow symbol in FFS Professional")
    public void user_tries_to_click_on_back_arrow_symbol_in_ffs_professional() {
        clickOnPreviousButton();
    }
    @Then("user should allow to navigates to back page in FFS Professional")
    public void user_should_allow_to_navigates_to_back_page_in_ffs_professional() {
        verifyUserNavigatesToPreviousPage();
    }

    //Scenario:Verify user able to navigate to claim summary screen on clicking claim number in FFS Professional Queue page
    @When("user clicks on claim number in FFS Professional page")
    public void user_clicks_on_claim_number_in_ffs_professional_page() throws InterruptedException {
        clickOnFFSProfessionalClaim();
    }

    @Then("user should be able to navigate to View Claim Details page")
    public void user_should_be_able_to_navigate_to_view_claim_details_page() {
        verifyViewClaimDetailsTab();
    }

    @Then("User should see {string} option with Claim summary")
    public void user_should_see_option_with_claim_summary(String option) throws InterruptedException {
        verifyClaimSummaryOption(option);
    }

    //Scenario: Verify user able to navigate to claim summary screen only once when performed multiple clicks on Claim number
    @When("user searches for claim number in pend bucket")
    public void user_searches_for_claim_number_in_pend_bucket() throws InterruptedException {
        enterClaimNumberInPendFFSProfessionalSearchField();
    }
    @When("user clicks on claim number")
    public void user_clicks_on_claim_number() throws InterruptedException {
        clickOnFFSProfessionalClaim();
    }
    @Then("user should be able to navigate to View Claim Details page and get the claim details")
    public void user_should_be_able_to_navigate_to_view_claim_details_page_and_get_the_claim_details() {
        verifyViewClaimDetailsTab();
        getOpenedClaimNumber();
    }
    @When("user clicks on the same claim number again in pend bucket")
    public void user_clicks_on_the_same_claim_number_again_in_pend_bucket() throws InterruptedException {
        clickOnFFSProfessionalDefaultTab();
        clickOnFFSProfessionalClaim();
    }
    @Then("user should be able to see already opened claim details")
    public void user_should_be_able_to_see_already_opened_claim_details() {
        verifyUserShouldSeeAlreadyOpenedClaimNumber();
    }

    //Scenario: Verify color code for corrected claims in FFS Professional page
    @When("user enters Corrected claim in FFS Professional search criteria")
    public void user_enters_corrected_claim_in_ffs_professional_search_criteria() throws InterruptedException {
        enterCorrectedClaimNumberInFFSProfessionalSearchField();
    }
    @Then("user should able to view corrected claim in FFS Professional Grid")
    public void user_should_able_to_view_corrected_claim_in_ffs_professional_grid() throws InterruptedException {
        validateClaimNumberResult();
    }
    @Then("user should able to see vertical line beside claim number with color code {string} in FFS Professional page")
    public void user_should_able_to_see_vertical_line_beside_claim_number_with_color_code_in_ffs_professional_page(String colorIndication) {
        verifyVerticalColorIndicationForCorrectedClaim(colorIndication);
    }
    @Then("color indication information should be available on top of grid in FFS Professional page")
    public void color_indication_information_should_be_available_on_top_of_grid_in_ffs_professional_page() {
        verifyCorrectedInformationOnTopOfGrid();
    }

    //Scenario: Verify color code for COB In Member House in FFS Professional page
    @When("user enters COB In Member House claim in search criteria")
    public void user_enters_cob_in_member_house_claim_in_search_criteria() throws InterruptedException {
        enterCOBInMemberHouseClaimNumber();
    }
    @Then("user should able to view COB In Member House claim")
    public void user_should_able_to_view_cob_in_member_house_claim() throws InterruptedException {
        validateClaimNumberResult();
    }
    @Then("user should able to view patient name with color code {string} in FFS Professional page")
    public void user_should_able_to_view_patient_name_with_color_code_in_ffs_professional_page(String colorCode) {
        verifyPatientNameColorCode(colorCode);
    }
    @Then("color indication information for COB In Member House should be available on top of grid")
    public void color_indication_information_for_cob_in_member_house_should_be_available_on_top_of_grid() {
        verifyCOBInMemberHouseInformationOnTopOfGrid();
    }

    //Scenario: Verify color code for COB Not In Member House in FFS Professional page
    @When("user enters COB Not In Member House claim in search criteria")
    public void user_enters_cob_not_in_member_house_claim_in_search_criteria() throws InterruptedException {
        enterCOBNotInMemberHouseClaimNumber();
    }
    @Then("user should able to view COB Not In Member House claim")
    public void user_should_able_to_view_cob_not_in_member_house_claim() throws InterruptedException {
        validateClaimNumberResult();
    }
    @Then("color indication information for COB Not In Member House should be available on top of grid")
    public void color_indication_information_for_cob_not_in_member_house_should_be_available_on_top_of_grid() {
        verifyCOBNotInMemberHouseInformationOnTopOfGrid();
    }

    //Scenario:Verify colour coding for Unclean status claims under Pend bucket in FFS professional page
    @When("user enters Unclean status claim in search criteria in Pend bucket")
    public void user_enters_unclean_status_claim_in_search_criteria_in_pend_bucket() throws InterruptedException {
        enterUnCleanStatusPendClaimNumber();
    }
    @Then("user should able to view Unclean status claim in FFS Professional Grid")
    public void user_should_able_to_view_unclean_status_claim_in_ffs_professional_grid() throws InterruptedException {
        validateClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Pend claim number with color code {string} in FFS Professional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_Pend_claim_number_with_color_code_in_ffs_professional(String colorCode) throws InterruptedException {
        verifyVerticalColorIndicationForUncleanPendClaim(colorCode);
    }
    @Then("color indication information for Unclean should be available on top of grid in FFS Professional")
    public void color_indication_information_for_unclean_should_be_available_on_top_of_grid_in_ffs_professional() {
        verifyUncleanInformationOnTopOfGrid();
    }

    //Scenario: Verify colour coding for Unclean status claims under Payer Review bucket in FFS professional page
    @When("user clicks on Payer Review bucket")
    public void user_clicks_on_payer_review_bucket() {
        clickOnPayerReviewBucket();
    }
    @When("user enters Unclean status claim in search criteria in Payer Review bucket")
    public void user_enters_unclean_status_claim_in_search_criteria_in_payer_review_bucket() throws InterruptedException {
        enterUnCleanStatusPayerReviewClaimNumber();
    }
    @Then("user should able to view Unclean status Payer Review claim in FFS Professional Grid")
    public void user_should_able_to_view_unclean_status_payer_review_claim_in_ffs_professional_grid() {
        validatePayerReviewClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Payer Review claim number with color code {string} in FFS Professional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_payer_review_claim_number_with_color_code_in_ffs_professional(String colorCode) {
        verifyVerticalColorIndicationForUncleanPayerReviewClaim(colorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Management Review bucket in FFS professional page
    @When("user clicks on Management Review bucket")
    public void user_clicks_on_management_review_bucket() {
        clickOnManagementReviewBucket();
    }
    @When("user enters Unclean status claim in search criteria in Management Review bucket")
    public void user_enters_unclean_status_claim_in_search_criteria_in_management_review_bucket() throws InterruptedException {
        enterUnCleanStatusManagementReviewClaimNumber();
    }
    @Then("user should able to view Unclean status Management Review claim in FFS Professional Grid")
    public void user_should_able_to_view_unclean_status_management_review_claim_in_ffs_professional_grid() {
        validateManagementReviewClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Management Review claim number with color code {string} in FFS Professional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_management_review_claim_number_with_color_code_in_ffs_professional(String colorCode) {
        verifyVerticalColorIndicationForUncleanManagementReviewClaim(colorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Approved bucket in FFS professional page
    @When("user clicks on Approved bucket")
    public void user_clicks_on_approved_bucket() {
        clickOnApprovedBucket();
    }
    @When("user enters Unclean status claim in search criteria in Approved bucket")
    public void user_enters_unclean_status_claim_in_search_criteria_in_approved_bucket() throws InterruptedException {
        enterUnCleanStatusApprovedClaimNumber();
    }
    @Then("user should able to view Unclean status Approved claim in FFS Professional Grid")
    public void user_should_able_to_view_unclean_status_approved_claim_in_ffs_professional_grid() {
        validateApprovedClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Approved claim number with color code {string} in FFS Professional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_approved_claim_number_with_color_code_in_ffs_professional(String colorCode) {
        verifyVerticalColorIndicationForUncleanApprovedClaim(colorCode);
    }
    //Scenario: Verify colour coding for Unclean status claims under Denied bucket in FFS professional page
    @When("user clicks on Denied bucket")
    public void user_clicks_on_denied_bucket() {
        clickOnDeniedBucket();
    }
    @When("user enters Unclean status claim in search criteria in Denied bucket")
    public void user_enters_unclean_status_claim_in_search_criteria_in_denied_bucket() throws InterruptedException {
        enterUnCleanStatusDeniedClaimNumber();
    }
    @Then("user should able to view Unclean status Denied claim in FFS Professional Grid")
    public void user_should_able_to_view_unclean_status_denied_claim_in_ffs_professional_grid() {
        validateDeniedClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Denied claim number with color code {string} in FFS Professional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_denied_claim_number_with_color_code_in_ffs_professional(String colorCode) {
        verifyVerticalColorIndicationForUncleanDeniedClaim(colorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Pre Batch bucket in FFS professional page
    @When("user clicks on Pre Batch bucket")
    public void user_clicks_on_pre_batch_bucket() {
        clickOnPreBatchBucket();
    }
    @When("user enters Unclean status claim in search criteria in Pre Batch bucket")
    public void user_enters_unclean_status_claim_in_search_criteria_in_pre_batch_bucket() throws InterruptedException {
        enterUnCleanStatusPreBatchClaimNumber();
    }
    @Then("user should able to view Unclean status Pre Batch claim in FFS Professional Grid")
    public void user_should_able_to_view_unclean_status_pre_batch_claim_in_ffs_professional_grid() {
        validatePreBatchClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Pre Batch claim number with color code {string} in FFS Professional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_pre_batch_claim_number_with_color_code_in_ffs_professional(String colorCode) {
        verifyVerticalColorIndicationForUncleanPreBatchClaim(colorCode);
    }

    //Scenario: Verify all tabs should display when clicking on Batch ID under Paid tab in FFS Professional page
    @When("user clicks on Paid bucket")
    public void user_clicks_on_paid_bucket() {
        clickOnPaidBucket();
    }
    @When("user enters Batch Id in search criteria")
    public void user_enters_batch_id_in_search_criteria() throws InterruptedException {
        enterBatchId();
    }

    @When("user clicks on Batch Id")
    public void user_clicks_on_batch_id() throws InterruptedException {
        clickOnBatchId();
    }
    @When("user clicks on Batch Id for check void")
    public void user_clicks_on_batch_id_for_check_void() throws InterruptedException {
        clickOnBatchIdForCheckVoid();
    }

    @Then("user views Claim List tab by default should be {string}")
    public void user_views_claim_list_tab_by_default_should_be(String state) throws InterruptedException {
        verifyClaimListByDefault(state);
    }

    @Then("user should be able to see below tabs")
    public void user_should_be_able_to_see_below_tabs(DataTable tabList) throws InterruptedException {
        verifyTabsInBatchIDInFFSProfessional(tabList);
    }

    //Scenario: Verify by default user navigates to the View Claims List page
    @Then("by default user navigates to the Claim List page")
    public void by_default_user_navigates_to_the_claim_list_page() {

    }
    @Then("displays all the list of claims for that Batch ID")
    public void displays_all_the_list_of_claims_for_that_batch_id() throws InterruptedException {
        verifyClaimsCount();
    }
    @Then("user should able to see {string}")
    public void user_should_able_to_see(String claimListLabel) {
        verifyClaimListInTheSelectedBatchLabel(claimListLabel);

    }

    //Scenario: Verify user should navigates to the Provider List page on clicking Provider List tab
    @When("user clicks on the Provider List tab")
    public void user_clicks_on_the_provider_list_tab() {
        clickOnProviderList();
    }
    @When("displays all the list of provider list for that Batch ID")
    public void displays_all_the_list_of_provider_list_for_that_batch_id() throws InterruptedException {
        verifyProviderCount();
    }
    @When("user should be able to see {string} label in Provider List screen")
    public void user_should_be_able_to_see_label_in_provider_list_screen(String providerListLabel) {
        verifyProviderListInTheSelectedBatchLabel(providerListLabel);
    }

    //Scenario: Verify user should navigates to the Check Info page on clicking Check Info tab
    @When("user clicks on the Check Info tab")
    public void user_clicks_on_the_check_info_tab() {
        clickOnCheckInfoList();
    }
    @When("displays all the list of Check Info for that Batch ID")
    public void displays_all_the_list_of_check_info_for_that_batch_id() throws InterruptedException {
        verifyCheckInfoCount();
    }
    @When("user should be able to see {string} label in Check Info screen")
    public void user_should_be_able_to_see_label_in_check_info_screen(String checkInfoLabel) {
        verifyCheckInfoLabel(checkInfoLabel);
    }

    //Scenario: Verify user able to view the check reissue information in Check Info page
    @Then("user should able to see Check Type as {string}")
    public void user_should_able_to_see_check_type_as(String checkType) throws InterruptedException {
        verifyCheckType(checkType);

    }

    //Scenario: Verify user able to view the check void information in Check Info page
    @When("user enters Batch Id in search criteria for Check Void")
    public void user_enters_batch_id_in_search_criteria_for_check_void() throws InterruptedException {
        enterBatchIdForVoided();
    }
    @Then("user should able to see Check Type as {string} for voided batch")
    public void user_should_able_to_see_check_type_as_for_voided_batch(String checkType) throws InterruptedException {
        verifyCheckType(checkType);
    }

    //Scenario: Verify user able to view Check Type as Regular if its not void or reissue in Check Info page
    @When("user enters Batch Id in search criteria for Normal Check")
    public void user_enters_batch_id_in_search_criteria_for_normal_check() throws InterruptedException {
        enterBatchIdForNormalCheck();
    }

    @Then("user should able to see Check Type as {string} for Normal Check")
    public void user_should_able_to_see_check_type_as_for_normal_check(String checkType) throws InterruptedException {
        verifyCheckType(checkType);
    }

    //Scenario: Verify user able to navigate to the History Doc page on clicking History Doc tab
    @When("user clicks on History Doc")
    public void user_clicks_on_history_doc() {
        clickOnHistoryDoc();
    }

    @When("displays all the list of History Doc for that Batch ID")
    public void displays_all_the_list_of_history_doc_for_that_batch_id() throws InterruptedException {
        verifyHistoryDocCount();
    }

    @When("user should be able to see {string} label in History Doc screen")
    public void user_should_be_able_to_see_label_in_history_doc_screen(String HistoryDocLabel) {
        verifyHistoryDocLabel(HistoryDocLabel);
    }

    //Scenario:Verify user able to navigate to the Downloads tab on clicking Downloads tab and verify the files when there are any files
    @When("user clicks on Downloads")
    public void user_clicks_on_downloads() {
        clickOnDownloads();
    }
    @Then("user able to view the {string} and {string}")
    public void user_able_to_view_the_and(String eopLetter, String fileName) {
        verifyEOPLetter(eopLetter);
        verify835File(fileName);
    }

    //Scenario: Verify Add Note button in Paid Bucket
    @Then("user should see the Add Note button for given batch id")
    public void user_should_see_the_add_note_button_for_given_batch_id() {
        verifyAddNoteButton();
    }

    //  Scenario: Verify fields in Add Note window
    @When("user click on the Add Note button")
    public void user_click_on_the_add_note_button() {
        clickOnAddNoteButton();
    }
    @Then("user should see the {string} {string} and {string} fields")
    public void user_should_see_the_and_fields(String title, String category, String description) {
        verifyTitle(title);
        verifyCategory(category);
        verifyDescription(description);
    }

    @Then("user should see the {string} and {string} buttons")
    public void user_should_see_the_and_buttons(String add, String cancel) {
        verifyAddButton(add);
        verifyCancelButton(cancel);
    }

    //Scenario: Verify user should be able to view all the Claim notes that are updated for that specific Batch results
    @When("user enters values in the Title Category and Description fields")
    public void user_enters_values_in_the_title_category_and_description_fields() throws InterruptedException {
        enterTitle();
        selectCategory();
        enterDescription();
    }
    @When("user click on the Add button")
    public void user_click_on_the_add_button() {
        clickAdd();
    }
    @Then("user should able to see {string} message")
    public void user_should_able_to_see_message(String toasterMsg) throws InterruptedException {
        verifyAddNoteSuccessfullyMsg(toasterMsg);
    }

    @When("user clicks on claim number and navigates to Notes section")
    public void user_clicks_on_claim_number_and_navigates_to_notes_section() {
        clickOnClaimNumber();
        NavigateToNotesScreen();
    }
    @Then("user should able see the added note in the Notes section")
    public void user_should_able_see_the_added_note_in_the_notes_section() throws InterruptedException {
        verifyNotesAddedInNotesSection();
    }

    //Scenario: Verify error message when user enters Category and Description fields and Title field should leave as empty
    @When("user enters values in the Category and Description fields")
    public void user_enters_values_in_the_category_and_description_fields() throws InterruptedException {
        selectCategory();
        enterDescription();
    }
    @Then("user should able to see error message as {string} message")
    public void user_should_able_to_see_error_message_as_message(String toasterMsg) throws InterruptedException {
        verifyErrorMsg(toasterMsg);
    }

    //Scenario: Verify error message when user enters Title and Description fields and Category field should leave as empty
    @When("user enters values in the Title and Description fields")
    public void user_enters_values_in_the_title_and_description_fields() {
        enterTitle();
        enterDescription();
    }

    //Scenario: Verify error message when user enters Title and Category fields and Description field should leave as empty
    @When("user enters values in the Title and Category fields")
    public void user_enters_values_in_the_title_and_category_fields() throws InterruptedException {
        enterTitle();
        selectCategory();
    }

    //Scenario: Validate user able to view all the column fields under On Hold bucket in FFS Professional screen
    @Then("user able to view following column fields in On Hold bucket")
    public void user_able_to_view_following_column_fields_in_on_hold_bucket(DataTable columnList) {
        verifyFFSProfessionalOnHoldColumnFields(columnList);
    }

    //Scenario: Validate user able to view all the column fields under Payer Review bucket in FFS Professional screen
    @Then("user able to view following column fields in Payer Review bucket")
    public void user_able_to_view_following_column_fields_in_payer_review_bucket(DataTable columnList) {
        verifyFFSProfessionalPayerReviewColumnFields(columnList);
    }

    //Scenario: Validate user able to view all the column fields under Management Review bucket in FFS Professional screen
    @Then("user able to view following column fields in Management Review bucket")
    public void user_able_to_view_following_column_fields_in_management_review_bucket(DataTable columnList) {
        verifyFFSProfessionalManagementReviewColumnFields(columnList);
    }

    //Scenario: Validate user able to view all the column fields under Approved bucket in FFS Professional screen
    @Then("user able to view following column fields in Approved bucket")
    public void user_able_to_view_following_column_fields_in_approved_bucket(DataTable columnList) {
        verifyFFSProfessionalApprovedColumnFields(columnList);
    }

    //Scenario: Validate user able to view all the column fields under Denied bucket in FFS Professional screen
    @Then("user able to view following column fields in Denied bucket")
    public void user_able_to_view_following_column_fields_in_denied_bucket(DataTable columnList) {
        verifyFFSProfessionalDeniedColumnFields(columnList);
    }

    //Scenario: Validate user able to view all the column fields under Pre-Batch bucket in FFS Professional screen
    @Then("user able to view following column fields in Pre Batch bucket")
    public void user_able_to_view_following_column_fields_in_pre_batch_bucket(DataTable columnList) {
        verifyFFSProfessionalPreBatchColumnFields(columnList);
    }

    //Scenario: Verify Batch Claims To Pay button when select claim number from Prebatch bucket
    @Then("user should able to see Batch Claims To Pay button in disabled mode")
    public void user_should_able_to_see_batch_claims_to_pay_button_in_disabled_mode() {
        verifyBatchClaimsToPayButtonInDisabledMode();
    }
    @When("user selects claim number in Pre Batch bucket")
    public void user_selects_claim_number_in_pre_batch_bucket() {
        clickClaimNumberChkBoxOnPreBatchBucket();
    }

    @Then("user should able to see Batch Claims To Pay button in enabled mode")
    public void user_should_able_to_see_batch_claims_to_pay_button_in_enabled_mode() {
        verifyBatchClaimsToPayButtonInEnabledMode();
    }

    //Scenario: Verify Batch Claims To Pay button when select multiple claim numbers from Pre Batch bucket
    @When("user selects all claim numbers in Pre Batch bucket")
    public void user_selects_all_claim_numbers_in_pre_batch_bucket() {
        clickSelectAllClaimNumberChkBoxOnPreBatchBucket();
    }


    //Scenario: Verify Pre Batch Pay button when select claim number from Approved bucket
    @Then("user should able to see Pre Batch Pay button in disabled mode")
    public void user_should_able_to_see_pre_batch_pay_button_in_disabled_mode() {
        verifyPreBatchPayButtonInDisabledMode();
    }
    @When("user selects claim number")
    public void user_selects_claim_number() {
        clickClaimNumberChkBoxOnApprovedBucket();
    }
    @Then("user should able to see Pre Batch Pay button in enabled mode")
    public void user_should_able_to_see_pre_batch_pay_button_in_enabled_mode() {
        verifyPreBatchPayButtonInEnabledMode();
    }

    @When("user un selects claim number")
    public void user_un_selects_claim_number() {
        clickClaimNumberChkBoxOnApprovedBucket();
    }

    //Scenario: Verify Pre batch Pay button when select multiple claim numbers from Approved bucket
    @When("user selects all claim numbers")
    public void user_selects_all_claim_numbers() {
        clickSelectAllClaimNumberChkBox();
    }
    @When("user un selects all claim numbers")
    public void user_un_selects_all_claim_numbers() {
        clickSelectAllClaimNumberChkBox();
    }

    //Scenario: Verify user should be able to see  PreBatch To Pay Validation screen on clicking Pre Batch Pay button
    @When("user clicks on Pre Batch Pay button")
    public void user_clicks_on_pre_batch_pay_button() {
        clickOnPreBachPayButton();
    }
    @Then("user should able to see {string} screen")
    public void user_should_able_to_see_screen(String preBatchToPayValidation) {
        verifyPreBatchPayValidationScreen(preBatchToPayValidation);
    }

    //Scenario: Verify buttons in Valid tab under PreBatch To Pay Validation screen
    @When("user is in {string} tab")
    public void user_is_in_tab(String expText) {
        verifyValidTab(expText);
    }

    @Then("user should able to see {string} and {string} buttons")
    public void user_should_able_to_see_and_buttons(String expRemove, String expConfirmPreBatchPay) {
        verifyRemoveAndConfirmPreBatchPayButtons(expRemove,expConfirmPreBatchPay);
    }

    //Scenario: Verify buttons in Invalid tab under PreBatch To Pay Validation screen
    @When("user clicks on Invalid tab")
    public void user_clicks_on_invalid_tab() throws InterruptedException {
       clickOnInvalidTab();
    }
    @Then("user should able to see {string} {string} and {string} buttons")
    public void user_should_able_to_see_and_buttons(String expPend, String expOnHold, String expManagementReview) {
        verifyPendOnHoldAndManagementReviewButtons(expPend, expOnHold, expManagementReview);
    }



    //Scenario: Validate user able to view all the column fields under PreBatch Pay validation bucket in FFS Professional screen
    @Then("user able to view following column fields in PreBatch To Pay Validation bucket")
    public void user_able_to_view_following_column_fields_in_pre_batch_to_pay_validation_bucket(DataTable columnList) {
        verifyFFSProfessionalPreBatchToPayValidationColumnFields(columnList);
    }

    //Scenario: Verify tabs in PreBatch To Pay Validation screen
    @Then("user should able to see following tabs in PreBatch To Pay Validation screen")
    public void user_should_able_to_see_following_tabs_in_pre_batch_to_pay_validation_screen(DataTable tabList) throws InterruptedException {
        verifyTabsInPreBatchToPayValidationInFFSProfessional(tabList);
    }



    //Scenario: Verify Pre batch Deny button when select claim number from Denied bucket
    @Then("user should able to see Pre Batch Deny button in disabled mode")
    public void user_should_able_to_see_pre_batch_deny_button_in_disabled_mode() {
        verifyPreBatchDenyButtonInDisabledMode();
    }

    @When("user selects claim number in Denied bucket")
    public void user_selects_claim_number_in_denied_bucket() {
        clickClaimNumberChkBoxOnDeniedBucket();
    }

    @Then("user should able to see Pre Batch Deny button in enabled mode")
    public void user_should_able_to_see_pre_batch_deny_button_in_enabled_mode() {
        verifyPreBatchDenyButtonInEnabledMode();
    }

    @When("user un selects claim number in Denied bucket")
    public void user_un_selects_claim_number_in_denied_bucket() {
        clickClaimNumberChkBoxOnDeniedBucket();
    }


    //Scenario: Verify Pre batch Pay button when select multiple claim numbers from Denied bucket
    @When("user selects all claim numbers in Denied bucket")
    public void user_selects_all_claim_numbers_in_denied_bucket() {
        clickSelectAllClaimNumberChkBoxOnDeniedBucket();
    }
    @When("user un selects all claim numbers in Denied bucket")
    public void user_un_selects_all_claim_numbers_in_denied_bucket() {
        clickSelectAllClaimNumberChkBoxOnDeniedBucket();
    }

    //Scenario: Verify tabs in Batch To Pay Validation screen
    @When("user clicks on Batch To Pay bucket")
    public void user_clicks_on_batch_to_pay_bucket() {
        clickOnBatchToPayBucket();
    }
    @Then("user should be able to see following tabs in Batch To Pay bucket")
    public void user_should_be_able_to_see_following_tabs_in_batch_to_pay_bucket(DataTable tabList) throws InterruptedException {
        verifyTabsInBatchBatchToPayInFFSProfessional(tabList);
    }

    //Scenario: Validate user able to view all the column fields in To Be Signed Off under Batch To Pay bucket in FFS Professional screen
    @When("user is on {string} tab")
    public void user_is_on_bucket(String expText) {
        verifyToBeSignedOffTab(expText);
    }

    @Then("user should be see following column fields in To Be Signed Off")
    public void user_should_be_see_following_column_fields_in_to_be_signed_off(DataTable columnList) {
        verifyFFSProfessionalToBeSignedOffColumnFields(columnList);
    }

    //Scenario: Verify buttons in To Be Signed Off tab under Batch To Pay bucket
    @Then("user should able to see Unbatch EFT Payment Signed Off buttons in disabled mode")
    public void user_should_able_to_see_unbatch_eft_payment_signed_off_buttons_in_disabled_mode() {
        verifyUnBatchButtonInDisabledMode();
        verifyEFTPaymentButtonInDisabledMode();
        verifySignOffButtonInDisabledMode();
    }
    @When("user selects Batch ID")
    public void user_selects_batch_id() {
        clickOnBatchIdCheckBox();
    }
    @Then("user should able to see Unbatch EFT Payment Signed Off buttons in enabled mode")
    public void user_should_able_to_see_unbatch_eft_payment_signed_off_buttons_in_enabled_mode() {
        verifyUnBatchButtonInEnabledMode();
        verifyEFTPaymentButtonInEnabledMode();
        verifySignOffButtonInEnabledMode();
    }


    //Scenario: Validate user able to view all the column fields in Signed Off under Batch To Pay bucket in FFS Professional screen
    @When("user clicks on Signed Off tab")
    public void user_clicks_on_signed_off_tab() {
        clickOnSignedOffTab();
    }
    @Then("user should be see following column fields in Signed Off")
    public void user_should_be_see_following_column_fields_in_signed_off(DataTable columnList) {
        verifyFFSProfessionalSignedOffColumnFields(columnList);
    }

    //Scenario: Validate user able to view all the column fields in Sent for Payment under Batch To Pay bucket in FFS Professional screen
    @When("user clicks on Sent for Payment tab")
    public void user_clicks_on_sent_for_payment_tab() {
        clickOnSentForPaymentTab();
    }
    @Then("user should be see following column fields in Sent for Payment")
    public void user_should_be_see_following_column_fields_in_sent_for_payment(DataTable columnList) {
        verifyFFSProfessionalSentForPaymentColumnFields(columnList);
    }

    //Scenario: Verify user should be able to see Upload Great Plains File button in Sent for Payment tab under Batch to Pay bucket
    @Then("user should able to see {string} button")
    public void user_should_able_to_see_button(String expText) {
        verifyUploadGreatPlainsFileButton(expText);
    }

    //Scenario: Validate user able to view all the column fields in EFT Payment under Batch To Pay bucket in FFS Professional screen
    @When("user clicks on EFT Payment tab")
    public void user_clicks_on_eft_payment_tab() {
        clickOnEFTPaymentTab();
    }

    @Then("user should be see following column fields in EFT Payment")
    public void user_should_be_see_following_column_fields_in_eft_payment(DataTable columnList) {
        verifyFFSProfessionalEFTPaymentColumnFields(columnList);
    }

    //Scenario: Verify buttons in EFT Payment tab under Batch To Pay bucket
    @Then("user should be able to see Move To Paid and To Be Signed Off buttons in disabled mode")
    public void user_should_be_able_to_see_move_to_paid_and_to_be_signed_off_buttons_in_disabled_mode() {
        verifyMoveToPaidButtonInDisabledMode();
        verifyToBeSignedOffButtonInDisabledMode();
    }

    @Then("user should be able to see Re Generate EFT button in enabled mode")
    public void user_should_be_able_to_see_re_generate_eft_button_in_enabled_mode() {
        verifyReGenerateButtonInDisabledMode();
    }

    @When("user selects Batch ID in EFT Payment tab")
    public void user_selects_batch_id_in_eft_payment_tab() {
        clickOnBatchIdCheckBoxInEFTPayment();
    }

    @Then("user should be able to see Move To Paid and To Be Signed Off buttons in enabled mode")
    public void user_should_be_able_to_see_move_to_paid_and_to_be_signed_off_buttons_in_enabled_mode() {
        verifyMoveToPaidButtonInEnabledMode();
        verifyToBeSignedOffButtonInEnabledMode();
    }

    //Scenario: Verify user should be able to see Claims List on clicking on Batch Id in To Be Signed Off tab
    @When("user clicks on Batch Id in To Be Signed Off tab")
    public void user_clicks_on_batch_id_in_to_be_signed_off_tab() {
        clickOnBatchIdToBeSignedOffTab();
    }

    @Then("user should be able to see {string} for the selected Batch Id")
    public void user_should_be_able_to_see_for_the_selected_batch_id(String expText) {
        verifyClaimListInBatchID(expText);
    }

    //Scenario: Verify user should be able to see Claims List on clicking on Batch Id in Signed Off tab
    @When("user clicks on Batch Id in Signed Off tab")
    public void user_clicks_on_batch_id_in_signed_off_tab() {
        clickOnBatchIdSignedOffTab();
    }

    //Scenario: Verify user should be able to see Claims List on clicking on Batch Id in Sent for Payment tab
    @When("user clicks on Batch Id in Sent for Payment tab")
    public void user_clicks_on_batch_id_in_sent_for_payment_tab() {
        clickOnBatchIdSentForPaymentTab();
    }

    //Scenario: Verify user should be able to see Claims List on clicking on Batch Id in EFT Payment tab
    @When("user clicks on Batch Id in EFT Payment tab")
    public void user_clicks_on_batch_id_in_eft_payment_tab() {
        clickOnBatchIdEFTPaymentTab();
    }

    //Scenario: Validate user able to view all the column fields under Paid bucket in FFS Professional screen
    @Then("user able to view following column fields in Paid bucket")
    public void user_able_to_view_following_column_fields_in_paid_bucket(DataTable columnList) {
        verifyFFSProfessionalPaidColumnFields(columnList);
    }

    //Scenario: Validate user able to view all the column fields under Draft bucket in FFS Professional screen
    @When("user clicks on Draft bucket")
    public void user_clicks_on_draft_bucket() {
        clickOnDraftBucket();
    }
    @Then("user able to view following column fields in Draft bucket")
    public void user_able_to_view_following_column_fields_in_draft_bucket(DataTable columnList) {
        verifyFFSProfessionalDraftColumnFields(columnList);
    }

    //Scenario: Validate user able to view all the column fields under Draft bucket in FFS Professional screen
    @When("user clicks on Reject bucket")
    public void user_clicks_on_reject_bucket() {
        clickOnRejectBucket();
    }
    @Then("user able to view following column fields in Reject bucket")
    public void user_able_to_view_following_column_fields_in_reject_bucket(DataTable columnList) {
        verifyFFSProfessionalRejectColumnFields(columnList);
    }


























}
