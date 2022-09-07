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
        enterClaimNumberInPendCFFSInstitutionalSearchField();
    }
    @When("user clicks on the same claim number again in pend bucket in FFS Institutional")
    public void user_clicks_on_the_same_claim_number_again_in_pend_bucket_in_ffs_institutional() throws InterruptedException {
        clickOnFFSInstitutionalDefaultTab();
        clickOnFFSInstitutionalClaim();
    }








}
