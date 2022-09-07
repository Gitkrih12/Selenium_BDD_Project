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
    @When("user clicks on On Hold bucket")
    public void user_clicks_on_on_hold_bucket() {
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



}
