package Automation.StepDefinitions;


import Automation.PageObjects.FFSInstitutionalPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FFSInstitutionalStepDef extends FFSInstitutionalPage {

    //Scenario: Verify user should navigates to FFS Institutional screen
    @When("user clicks on FFS Institutional in left navigation menu")
    public void user_clicks_on_ffs_institutional_in_left_navigation_menu() {
        clickOnFFSInstitutional();
    }
    @Then("the user should navigate to the FFS Institutional page")
    public void the_user_should_navigate_to_the_ffs_institutional_page() throws InterruptedException {
        verifyFFSInstitutionalPage();
    }

    //Scenario: Verify by default user should be in the Pend state in FFS Institutional screen
    @Then("by default user should be in Pend state results page in FFS Institutional page")
    public void by_default_user_should_be_in_pend_state_results_page_in_ffs_institutional_page() throws InterruptedException {
        verifyUserByDefaultInPendStateResultsPage();
    }

    //Scenario: Verify user should able to see Clam List Label in FFS Institutional screen
    @Then("user should be able to view the Clam List Label in the FFS Institutional screen")
    public void user_should_be_able_to_view_the_clam_list_label_in_the_ffs_institutional_screen() {
        verifyClaimListLabel();
    }

    //Scenario: Validate user able to view all the column fields in FFS Institutional screen
    @When("user views Pend bucket by default should be {string} in FFS Institutional page")
    public void user_views_pend_bucket_by_default_should_be_in_ffs_institutional_page(String state) throws InterruptedException {
        verifyPendStateByDefault(state);
    }
    @Then("user able to view following column fields in Pend bucket in FFS Institutional page")
    public void user_able_to_view_following_column_fields_in_pend_bucket_in_ffs_institutional_page(DataTable columnList) throws InterruptedException {
        verifyFFSInstitutionalPendColumnFields(columnList);
    }

    //Scenario: Validate user able to view all the column fields in FFS Institutional screen
    @Then("user should be able to view following queue detail fields in FFS Institutional page")
    public void user_should_be_able_to_view_following_queue_detail_fields_in_ffs_institutional_page(DataTable queueList) throws InterruptedException {
        verifyQueuesInFFSInstitutional(queueList);
    }

    //Scenario: Verify all the queue field details in the FFS Institutional page
    @Then("user able to view the Search fields under each column in FFS Institutional page")
    public void user_able_to_view_the_search_fields_under_each_column_in_ffs_institutional_page() {
        verifySearchFieldsUnderEachColumnInFFSInstitutional();
    }

    //Scenario: Verify Pagination in FFS Institutional page
    @When("user enters the member id in the search field in FFS Institutional page")
    public void user_enters_the_member_id_in_the_search_field_in_ffs_institutional_page() throws InterruptedException {
        enterMemberIdInSearchFieldForPaginationInFFSInstitutional();
    }
    @Then("user able to view the claim details for given member id in FFS Institutional page")
    public void user_able_to_view_the_claim_details_for_given_member_id_in_ffs_institutional_page() {
        validateMemberIDResultInFFSInstitutional();
    }
    @When("user get the total records for the search criteria in FFS Institutional page")
    public void user_get_the_total_records_for_the_search_criteria_in_ffs_institutional_page() {
        getAllMemberIdResults();
    }
    @Then("user should be able to view the total results count at the bottom of the page in FFS Institutional page")
    public void user_should_be_able_to_view_the_total_results_count_at_the_bottom_of_the_page_in_ffs_institutional_page() {
        verifyTotalResultsForGivenSearch();
    }

    //Scenario: Verify user see the page numbers as per the no of data divided by pages size
    @Then("user see the page numbers as per the no of data divided by pages size in FFS Institutional page")
    public void user_see_the_page_numbers_as_per_the_no_of_data_divided_by_pages_size_in_ffs_institutional_page() {
        verifyPageSizeDividedByNoOfRecordsInTheGrid();
    }

    //Scenario: Verify user able to navigate through pages by using Pagination functionality
    @When("user clicks on On Hold bucket in FFS Institutional")
    public void user_clicks_on_on_hold_bucket_in_ffs_institutional() {
        clickOnOnHold();
    }
    @When("user should be able to view the page numbers at bottom of the page in FFS Institutional page")
    public void user_should_be_able_to_view_the_page_numbers_at_bottom_of_the_page_in_ffs_institutional_page() throws InterruptedException {
        verifyPageNumbersAtBottomOfPage();
    }
    @When("user tries to click on next arrow symbol in FFS Institutional")
    public void user_tries_to_click_on_next_arrow_symbol_in_ffs_institutional() {
        clickOnNextButton();
    }
    @When("user allow to navigates to next page in FFS Institutional")
    public void user_allow_to_navigates_to_next_page_in_ffs_institutional() {
        verifyUserNavigatesToNextPage();
    }
    @When("user tries to click on back arrow symbol in FFS Institutional")
    public void user_tries_to_click_on_back_arrow_symbol_in_ffs_institutional() {
        clickOnPreviousButton();
    }
    @Then("user should allow to navigates to back page in FFS Institutional")
    public void user_should_allow_to_navigates_to_back_page_in_ffs_institutional() {
        verifyUserNavigatesToPreviousPage();
    }

    //Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    @When("user clicks on claim number in FFS Institutional page")
    public void user_clicks_on_claim_number_in_ffs_institutional_page() throws InterruptedException {
        clickOnFFSInstitutionalClaim();
    }

    //Scenario: Verify user able to navigate to claim summary screen only once when performed multiple clicks on Claim number
    @When("user searches for claim number in pend bucket in FFS Institutional")
    public void user_searches_for_claim_number_in_pend_bucket_in_ffs_institutional() throws InterruptedException {
        enterClaimNumberInPendFFSInstitutionalSearchField();
    }
    @When("user clicks on the same claim number again in pend bucket in FFS Institutional")
    public void user_clicks_on_the_same_claim_number_again_in_pend_bucket_in_ffs_institutional() throws InterruptedException {
        clickOnFFSInstitutionalDefaultTab();
        clickOnFFSInstitutionalClaim();
    }

    //Scenario: Verify user can Identify corrected claims from FFS Institutional page
    @When("user enters Corrected claim in FFS Institutional search criteria")
    public void user_enters_corrected_claim_in_ffs_institutional_search_criteria() throws InterruptedException {
        enterCorrectedClaimNumberInFFSInstitutionalSearchField();
    }
    @Then("user should able to view corrected claim in FFS Institutional Grid")
    public void user_should_able_to_view_corrected_claim_in_ffs_institutional_grid() throws InterruptedException {
        validateClaimNumberResult();
    }
    @Then("user should able to see vertical line beside claim number with color code {string} in FFS Institutional page")
    public void user_should_able_to_see_vertical_line_beside_claim_number_with_color_code_in_ffs_institutional_page(String colorIndication) {
        verifyVerticalColorIndicationForCorrectedClaim(colorIndication);
    }
    @Then("color indication information should be available on top of grid in FFS Institutional page")
    public void color_indication_information_should_be_available_on_top_of_grid_in_ffs_institutional_page() {
        verifyCorrectedInformationOnTopOfGrid();
    }

    //Scenario: Verify user can Identify COB In Member House from FFS Institutional page
    @When("user enters COB In Member House claim in search criteria in FFS Institutional page")
    public void user_enters_cob_in_member_house_claim_in_search_criteria_in_ffs_institutional_page() throws InterruptedException {
        enterCOBInMemberHouseClaimNumber();
    }

    @Then("user should able to view COB In Member House claim in FFS Institutional page")
    public void user_should_able_to_view_cob_in_member_house_claim_in_ffs_institutional_page() throws InterruptedException {
        validateClaimNumberResult();
    }

    @Then("user should able to view patient name with color code {string} in FFS Institutional page")
    public void user_should_able_to_view_patient_name_with_color_code_in_ffs_institutional_page(String colorCode) {
        verifyPatientNameColorCode(colorCode);
    }

    @Then("color indication information for COB In Member House should be available on top of grid in FFS Institutional page")
    public void color_indication_information_for_cob_in_member_house_should_be_available_on_top_of_grid_in_ffs_institutional_page() {
        verifyCOBInMemberHouseInformationOnTopOfGrid();
    }

    //Scenario: Verify user can Identify COB Not In Member House from FFS Institutional page
    @When("user enters COB Not In Member House claim in search criteria in FFS Institutional page")
    public void user_enters_cob_not_in_member_house_claim_in_search_criteria_in_ffs_institutional_page() throws InterruptedException {
        enterCOBNotInMemberHouseClaimNumber();
    }

    @Then("user should able to view COB Not In Member House claim in FFS Institutional page")
    public void user_should_able_to_view_cob_not_in_member_house_claim_in_ffs_institutional_page() throws InterruptedException {
        validateClaimNumberResult();
    }

    @Then("color indication information for COB Not In Member House should be available on top of grid in FFS Institutional page")
    public void color_indication_information_for_cob_not_in_member_house_should_be_available_on_top_of_grid_in_ffs_institutional_page() {
        verifyCOBNotInMemberHouseInformationOnTopOfGrid();
    }

    //Scenario: Verify colour coding for Unclean status claims under Pend bucket in FFS Institutional page
    @When("user enters Unclean status claim in search criteria in Pend bucket in FFS Institutional")
    public void user_enters_unclean_status_claim_in_search_criteria_in_pend_bucket_in_ffs_institutional() throws InterruptedException {
        enterUnCleanStatusPendClaimNumber();
    }

    @Then("user should able to view Unclean status claim in FFS Institutional Grid")
    public void user_should_able_to_view_unclean_status_claim_in_ffs_institutional_grid() throws InterruptedException {
        validateClaimNumberResult();
    }

    @Then("user should able to see vertical line beside unclean status Pend claim number with color code {string} in FFS Institutional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_pend_claim_number_with_color_code_in_ffs_institutional(String colorCode) throws InterruptedException {
        verifyVerticalColorIndicationForUncleanPendClaim(colorCode);
    }

    @Then("color indication information for Unclean should be available on top of grid in FFS Institutional")
    public void color_indication_information_for_unclean_should_be_available_on_top_of_grid_in_ffs_institutional() {
        verifyUncleanInformationOnTopOfGrid();
    }

    //Scenario: Verify colour coding for Unclean status claims under Payer Review bucket in FFS Institutional page
    @When("user clicks on Payer Review bucket in FFS Institutional page")
    public void user_clicks_on_payer_review_bucket_in_ffs_institutional_page() {
        clickOnPayerReviewBucket();
    }

    @When("user enters Unclean status claim in search criteria in Payer Review bucket in FFS Institutional")
    public void user_enters_unclean_status_claim_in_search_criteria_in_payer_review_bucket_in_ffs_institutional() throws InterruptedException {
        enterUnCleanStatusPayerReviewClaimNumber();
    }

    @Then("user should able to view Unclean status Payer Review claim in FFS Institutional Grid")
    public void user_should_able_to_view_unclean_status_payer_review_claim_in_ffs_institutional_grid() {
        validatePayerReviewClaimNumberResult();
    }

    @Then("user should able to see vertical line beside unclean status Payer Review claim number with color code {string} in FFS Institutional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_payer_review_claim_number_with_color_code_in_ffs_institutional(String colorCode) throws InterruptedException {
        verifyVerticalColorIndicationForUncleanPayerReviewClaim(colorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Management Review bucket in FFS Institutional page
    @When("user clicks on Management Review bucket in FFS Institutional page")
    public void user_clicks_on_management_review_bucket_in_ffs_institutional_page() {
        clickOnManagementReviewBucket();
    }
    @When("user enters Unclean status claim in search criteria in Management Review bucket in FFS Institutional")
    public void user_enters_unclean_status_claim_in_search_criteria_in_management_review_bucket_in_ffs_institutional() throws InterruptedException {
        enterUnCleanStatusManagementReviewClaimNumber();
    }
    @Then("user should able to view Unclean status Management Review claim in FFS Institutional Grid")
    public void user_should_able_to_view_unclean_status_management_review_claim_in_ffs_institutional_grid() {
        validateManagementReviewClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Management Review claim number with color code {string} in FFS Institutional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_management_review_claim_number_with_color_code_in_ffs_institutional(String colorCode) throws InterruptedException {
        verifyVerticalColorIndicationForUncleanManagementReviewClaim(colorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Approved bucket in FFS Institutional page
    @When("user clicks on Approved bucket in FFS Institutional page")
    public void user_clicks_on_approved_bucket_in_ffs_institutional_page() {
        clickOnApprovedBucket();
    }
    @When("user enters Unclean status claim in search criteria in Approved bucket in FFS Institutional")
    public void user_enters_unclean_status_claim_in_search_criteria_in_approved_bucket_in_ffs_institutional() throws InterruptedException {
        enterUnCleanStatusApprovedClaimNumber();
    }
    @Then("user should able to view Unclean status Approved claim in FFS Institutional Grid")
    public void user_should_able_to_view_unclean_status_approved_claim_in_ffs_institutional_grid() {
        validateApprovedClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Approved claim number with color code {string} in FFS Institutional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_approved_claim_number_with_color_code_in_ffs_institutional(String colorCode) throws InterruptedException {
        verifyVerticalColorIndicationForUncleanApprovedClaim(colorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Denied bucket in FFS Institutional page
    @When("user clicks on Denied bucket in FFS Institutional page")
    public void user_clicks_on_denied_bucket_in_ffs_institutional_page() {
        clickOnDeniedBucket();
    }
    @When("user enters Unclean status claim in search criteria in Denied bucket in FFS Institutional")
    public void user_enters_unclean_status_claim_in_search_criteria_in_denied_bucket_in_ffs_institutional() throws InterruptedException {
        enterUnCleanStatusDeniedClaimNumber();
    }
    @Then("user should able to view Unclean status Denied claim in FFS Institutional Grid")
    public void user_should_able_to_view_unclean_status_denied_claim_in_ffs_institutional_grid() {
        validateDeniedClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Denied claim number with color code {string} in FFS Institutional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_denied_claim_number_with_color_code_in_ffs_institutional(String colorCode) {
        verifyVerticalColorIndicationForUncleanDeniedClaim(colorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Pre Batch bucket in FFS Institutional page
    @When("user clicks on Pre Batch bucket in FFS Institutional page")
    public void user_clicks_on_pre_batch_bucket_in_ffs_institutional_page() {
        clickOnPreBatchBucket();
    }
    @When("user enters Unclean status claim in search criteria in Pre Batch bucket in FFS Institutional")
    public void user_enters_unclean_status_claim_in_search_criteria_in_pre_batch_bucket_in_ffs_institutional() throws InterruptedException {
        enterUnCleanStatusPreBatchClaimNumber();
    }
    @Then("user should able to view Unclean status Pre Batch claim in FFS Institutional Grid")
    public void user_should_able_to_view_unclean_status_pre_batch_claim_in_ffs_institutional_grid() {
        validatePreBatchClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Pre Batch claim number with color code {string} in FFS Institutional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_pre_batch_claim_number_with_color_code_in_ffs_institutional(String colorCode) {
        verifyVerticalColorIndicationForUncleanPreBatchClaim(colorCode);
    }

    //Scenario: Verify all tabs should display when clicking on Batch ID under Paid tab in FFS Institutional page
    @When("user enters Batch Id in search criteria in FFS Institutional page")
    public void user_enters_batch_id_in_search_criteria_in_ffs_institutional_page() throws InterruptedException {
        enterBatchId();
    }

    //Scenario: Verify user able to view the check reissue information in Check Info page
    @When("user enters Batch Id in search criteria for issued check in FFS Institutional page")
    public void user_enters_batch_id_in_search_criteria_for_issued_check_in_ffs_institutional_page() throws InterruptedException {
        enterBatchIdForIssuedCheck();
    }

    //Scenario: Verify user able to view the check void information in Check Info page
    @When("user enters Batch Id in search criteria for Check Void in FFS Institutional page")
    public void user_enters_batch_id_in_search_criteria_for_check_void_in_ffs_institutional_page() throws InterruptedException {
        enterBatchIdForVoided();
    }

    //Scenario: Verify user able to view Check Type as Regular if its not void or reissue in Check Info page
    @When("user enters Batch Id in search criteria for Normal Check in FFS Institutional page")
    public void user_enters_batch_id_in_search_criteria_for_normal_check_in_ffs_institutional_page() throws InterruptedException {
        enterBatchIdForNormalCheck();
    }














}
