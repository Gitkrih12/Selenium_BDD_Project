package Automation.StepDefinitions;

import Automation.PageObjects.CAPInstitutionalPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CAPInstitutionalStepDef extends CAPInstitutionalPage {

    //Scenario: Verify when user clicks on CAP Institutional page on the left navigation pane
    @When("user clicks on CAP Institutional in left navigation menu")
    public void user_clicks_on_cap_institutional_in_left_navigation_menu() {
        clickOnCAPInstitutional();
    }
    @Then("the user should navigate to the CAP Institutional page")
    public void the_user_should_navigate_to_the_cap_institutional_page() throws InterruptedException {
        verifyCAPInstitutionalPage();
    }

    //Scenario: Verify by default user should be in the Pend state field results page
    @Then("by default user should be in Pend state results page in CAP Institutional page")
    public void by_default_user_should_be_in_pend_state_results_page_in_cap_institutional_page() throws InterruptedException {
        verifyUserByDefaultInPendStateResultsPage();
    }

    //Scenario: Verify user should able to see Clam List Label in CAP Institutional screen
    @Then("user should be able to view the Clam List Label in the CAP Institutional screen")
    public void user_should_be_able_to_view_the_clam_list_label_in_the_cap_institutional_screen() {
        verifyClaimListLabel();
    }

    //Scenario: Validate user able to view all the column fields in CAP Institutional screen
    @When("user views Pend bucket by default should be {string} in CAP Institutional page")
    public void user_views_pend_bucket_by_default_should_be_in_cap_institutional_page(String state) throws InterruptedException {
        verifyPendStateByDefault(state);
    }
    @Then("user able to view following column fields in Pend bucket in CAP Institutional page")
    public void user_able_to_view_following_column_fields_in_pend_bucket_in_cap_institutional_page(DataTable columnList) throws InterruptedException {
        verifyFFSInstitutionalPendColumnFields(columnList);
    }

    //Scenario: Verify all the queue field details in the CAP Institutional page
    @Then("user should be able to view following queue detail fields in CAP Institutional page")
    public void user_should_be_able_to_view_following_queue_detail_fields_in_cap_institutional_page(DataTable queueList) throws InterruptedException {
        verifyQueuesInFFSInstitutional(queueList);
    }

    //Scenario: Verify user able to view the search fields under each columns in the CAP Institutional screen
    @Then("user able to view the Search fields under each column in CAP Institutional page")
    public void user_able_to_view_the_search_fields_under_each_column_in_cap_institutional_page() {
        verifySearchFieldsUnderEachColumnInCAPInstitutional();
    }

    //Scenario: Validate the pagination field in CAP Institutional page
    @When("user enters the member id in the search field in CAP Institutional page")
    public void user_enters_the_member_id_in_the_search_field_in_cap_institutional_page() throws InterruptedException {
        enterMemberIdInSearchFieldForPaginationInCAPInstitutional();
    }
    @Then("user able to view the claim details for given member id in CAP Institutional page")
    public void user_able_to_view_the_claim_details_for_given_member_id_in_cap_institutional_page() {
        validateMemberIDResultInCAPInstitutional();
    }
    @When("user get the total records for the search criteria in CAP Institutional page")
    public void user_get_the_total_records_for_the_search_criteria_in_cap_institutional_page() {
        getAllMemberIdResults();
    }
    @Then("user should be able to view the total results count at the bottom of the page in CAP Institutional page")
    public void user_should_be_able_to_view_the_total_results_count_at_the_bottom_of_the_page_in_cap_institutional_page() {
        verifyTotalResultsForGivenSearch();
    }

    @When("user clicks on On Hold bucket in CAP Institutional")
    public void user_clicks_on_on_hold_bucket_in_cap_institutional() {
        clickOnOnHold();
    }
    //Scenario: Verify user see the page numbers as per the no of data divided by pages size
    @When("user should be able to view the page numbers at bottom of the page in CAP Institutional page")
    public void user_should_be_able_to_view_the_page_numbers_at_bottom_of_the_page_in_cap_institutional_page() throws InterruptedException {
        verifyPageNumbersAtBottomOfPage();
    }
    @When("user tries to click on next arrow symbol in CAP Institutional")
    public void user_tries_to_click_on_next_arrow_symbol_in_cap_institutional() {
        clickOnNextButton();
    }
    @When("user allow to navigates to next page in CAP Institutional")
    public void user_allow_to_navigates_to_next_page_in_cap_institutional() {
        verifyUserNavigatesToNextPage();
    }
    @When("user tries to click on back arrow symbol in CAP Institutional")
    public void user_tries_to_click_on_back_arrow_symbol_in_cap_institutional() {
        clickOnPreviousButton();
    }
    @Then("user should allow to navigates to back page in CAP Institutional")
    public void user_should_allow_to_navigates_to_back_page_in_cap_institutional() {
        verifyUserNavigatesToPreviousPage();
    }






}
