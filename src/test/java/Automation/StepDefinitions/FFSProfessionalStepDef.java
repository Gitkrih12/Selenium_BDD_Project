package Automation.StepDefinitions;

import Automation.PageObjects.FFSProfessionalPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FFSProfessionalStepDef extends FFSProfessionalPage {
    //Verify color code for corrected claims in FFS Professional page
    @When("user clicks on FFS Professional in left navigation menu")
    public void user_clicks_on_ffs_professional_in_left_navigation_menu() {
        clickOnFFSProfessional();

    }
    @Then("the user should navigate to the FFS Professional page")
    public void the_user_should_navigate_to_the_ffs_professional_page() {
        verifyFFSProfessionalPage();
    }
    @When("user enters Corrected claim in FFS Professional search criteria")
    public void user_enters_corrected_claim_in_ffs_professional_search_criteria() throws InterruptedException {
        enterCorrectedClaimNumberInFFSProfessionalSearchField();
    }
    @Then("user should able to view corrected claim in FFS Professional Grid")
    public void user_should_able_to_view_corrected_claim_in_ffs_professional_grid() {
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
    public void user_should_able_to_view_cob_in_member_house_claim() {
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

    //Verify color code for COB Not In Member House in FFS Professional page
    @When("user enters COB Not In Member House claim in search criteria")
    public void user_enters_cob_not_in_member_house_claim_in_search_criteria() throws InterruptedException {
        enterCOBNotInMemberHouseClaimNumber();
    }
    @Then("user should able to view COB Not In Member House claim")
    public void user_should_able_to_view_cob_not_in_member_house_claim() {
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
    public void user_should_able_to_view_unclean_status_claim_in_ffs_professional_grid() {
        validateClaimNumberResult();
    }
    @Then("user should able to see vertical line beside unclean status Pend claim number with color code {string} in FFS Professional")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_Pend_claim_number_with_color_code_in_ffs_professional(String colorCode) {
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



    //Scenario: Validate user able to view all the column fields for Pend bucket in FFS Professional screen
    @When("user views Pend bucket by default should be {string}")
    public void user_views_pend_bucket_by_default_should_be(String state) throws InterruptedException{
        verifyPendStateByDefault(state);
    }
    @Then("user able to view following column fields")
    public void user_able_to_view_following_column_fields(DataTable columnList) throws InterruptedException {
        verifyFFSProfessionalPendColumnFields(columnList);
    }

    @Then("user should be able to view following queue detail fields")
    public void user_should_be_able_to_view_following_queue_detail_fields(DataTable queueList) throws InterruptedException{
        verifyQueuesInFFSProfessional(queueList);
    }

    //Scenario: Verify by default user should be in the Pend state in FFS Professional screen
    @Then("by default user should be in Pend state results page")
    public void by_default_user_should_be_in_pend_state_results_page() throws InterruptedException {
        verifyUserByDefaultInPendStateResultsPage();
    }
}
