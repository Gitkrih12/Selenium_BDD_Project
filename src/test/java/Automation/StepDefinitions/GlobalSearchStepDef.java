package Automation.StepDefinitions;

import Automation.PageObjects.GlobalSearchPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalSearchStepDef extends GlobalSearchPage {

    //Scenario: Verify user should get no result by default on Global search page
    @When("user clicks on Global Search in left navigation menu")
    public void user_clicks_on_global_search_in_left_navigation_menu() {
        clickOnGlobalSearch();
    }

    @Then("the user should navigate to the Global Search page")
    public void the_user_should_navigate_to_the_global_search_page() {
        verifyGlobalSearchPage();
    }

    @Then("by default no results should get displayed")
    public void by_default_no_results_should_get_displayed() {
        verifyNoDataDisplayMessage();
    }

    //Scenario: Verify Filter and Customize Columns buttons in Global search page
    @Then("user should able to view the Filter and Customize columns buttons")
    public void user_should_able_to_view_the_filter_and_customize_columns_buttons() {
        verifyFilterButton();
        verifyCustomisedColumn();
    }

    //Scenario: Verify column fields in grid level on Global Search
    @Then("user should able to see column fields in global Search page")
    public void user_should_able_to_see_column_fields(DataTable columnList) throws InterruptedException {
        verifyGlobalSearchColumnFields(columnList);
    }

    //Scenario: Verify search field displayed under each column except follow up column
    @Then("user able to view the Search fields under each column except follow up column")
    public void user_able_to_view_the_search_fields_under_each_column_except_follow_up_column() {
        verifySearchFieldsUnderEachCoulmn();
    }

    //Scenario: Verify adjudicator should land on Global Search Page
    @Then("user should land on Global Search page")
    public void user_should_land_on_global_search_page() {
        verifyAdjudicatorLandsOnGlobalSearchPage();
    }

    //Scenario: Verify user enters the Claim Number in the Search field
    @When("user enters the Claim Number {string} in the Search field")
    public void user_enters_the_in_the_search_field(String claimNumber) throws InterruptedException {
        enterClaimNumberInSearchField(claimNumber);
    }

    @Then("user able to view the exact claim details")
    public void user_able_to_view_the_exact_claim_details() {
        validateClaimNumberResult();
    }

    //Scenario: Verify user should get records when he search with more than 6 characters in claim number field in Global Search page
    @Then("user able to view the claim details for given filter criteria")
    public void user_able_to_view_the_claim_details_for_given_filter_criteria() {
        validateClaimNumberResultForCharacterLimit();
    }

    //Scenario: Verify user should not get records when he search with less than 7 characters in claim number field in Global Search page
    @Then("user not able to view the claim details for given filter criteria.")
    public void user_not_able_to_view_the_claim_details_for_given_filter_criteria() {
        verifyNoDataDisplayMessage();
    }

    //Scenario: Verify user enters the Member ID in the Search field
    @When("user enters the Member Id {string} in the Search field")
    public void user_enters_the_member_id_in_the_search_field(String memberId) throws InterruptedException {
        enterMemberIdInSearchField(memberId);
    }

    @Then("user able to view the claim details for given member id")
    public void user_able_to_view_the_exact_member_details() {
        validateMemberIDResult();
    }

    //Scenario: Verify user enters the Patient Name in the Search field
    @When("user enters the Patient Name {string} in the Search field")
    public void user_enters_the_patient_name_in_the_search_field(String patientName) throws InterruptedException {
        enterPatientNameInSearchField(patientName);
    }

    @Then("user able to view the claim details for given Patient name")
    public void user_able_to_view_the_exact_patient_details() {
        validatePatientNameResult();
    }

    // Scenario: Verify user enters the State name in the Search field
    @When("user enters the State {string} in the Search field")
    public void user_enters_the_state_in_the_search_field(String state) throws InterruptedException {
        enterStateInSearchField(state);
    }

    @Then("user able to view the claim details for given State")
    public void user_able_to_view_the_claim_details_for_given_state() {
        validateStateResult();
    }

    //Scenario: Verify user enters the Category value in the Search field
    @When("user enters the Category {string} in the Search field")
    public void user_enters_the_category_in_the_search_field(String category) throws InterruptedException {
        enterCategoryInSearchField(category);
    }

    @Then("user able to view the claim details for given Category")
    public void user_able_to_view_the_claim_details_for_given_category() {
        validateCategoryResult();
    }

    //  Scenario: Verify user enters the DOS From details in the Search field
    @When("user enters the DOS From {string} in the Search field")
    public void user_enters_the_dos_from_in_the_search_field(String dOSFrom) throws InterruptedException {
        enterDOSFromInSearchField(dOSFrom);
    }

    @Then("user able to view the claim details for given DOS From")
    public void user_able_to_view_the_claim_details_for_given_dos_from() {
        validateDOSFromResult();
    }

    //Scenario: Verify user enters the DOS To details in the Search field
    @When("user enters the DOS To {string} in the Search field")
    public void user_enters_the_dos_to_in_the_search_field(String dOSTo) throws InterruptedException {
        enterDOSToInSearchField(dOSTo);
    }

    @Then("user able to view the claim details for given DOS To")
    public void user_able_to_view_the_claim_details_for_given_dos_to() {
        validateDOSToResult();
    }

    // Scenario: Verify user enters the Billing Provider details in the Search field
    @When("user enters the Billing Provider {string} in the Search field")
    public void user_enters_the_billing_provider_in_the_search_field(String billingProvider) throws InterruptedException {
        enterBillingProviderInSearchField(billingProvider);
    }

    @Then("user able to view the claim details for given Billing Provider")
    public void user_able_to_view_the_claim_details_for_given_billing_provider() {
        validateBillingProviderResult();
    }

    //Scenario: Validate Export Result button should display when the search results are displayed
    @Then("user not able to view Export Result button when search results are not displayed")
    public void user_not_able_to_view_export_result_button_when_search_results_are_not_displayed() {
        verifyExportResultButtonWhenNoSearchResultsDisplayed();
    }

    @Then("user able to view the Export Result button when search results are displayed")
    public void user_able_to_view_the_export_result_button_when_search_results_are_displayed() {
        verifyExportResultButtonWhenSearchResultsDisplayed();
    }

    //Scenario: Verify Reprocess button should be available when Paid state is filtered in Global Search page
    @Then("user should be able view the Reprocess button for Paid state record")
    public void user_should_be_able_view_the_reprocess_button_for_paid_state_record() throws InterruptedException {
        verifyReprocessButton();
    }

    // Scenario: Verify user able to search more than 2 characters in Member Id field
    @When("user searches more than two characters in Member Id {string} field")
    public void user_searches_more_than_two_characters_in_field(String memberID) throws InterruptedException {
        enterMemberIdInSearchField(memberID);
    }

    @Then("user should be able to display the claim records in a Global Search for given Member Id criteria")
    public void user_should_be_able_to_display_the_claim_records_in_a_global_search_for_given_Member_criteria() {
        validateMemberIDResultForCharacterLimit();
    }

    //Scenario: Verify user able to search more than 2 characters in Patient field
    @When("user searches more than two characters in Patient {string} field")
    public void user_searches_more_than_two_characters_in_patient_field(String patientName) throws InterruptedException {
        enterPatientNameInSearchField(patientName);
    }

    @Then("user should be able to display the claim records in a Global Search for given Patient criteria")
    public void user_should_be_able_to_display_the_claim_records_in_a_global_search_for_given_patient_criteria() {
        validatePatientResultForCharacterLimit();
    }

    //Scenario: Verify user able to search more than 2 characters in Billing Provider field
    @When("user searches more than two characters in Billing Provider {string} field")
    public void user_searches_more_than_two_characters_in_billing_provider_field(String billingProvider) throws InterruptedException {
        enterBillingProviderInSearchField(billingProvider);
    }

    @Then("user should be able to display the claim records in a Global Search for given Billing Provider criteria")
    public void user_should_be_able_to_display_the_claim_records_in_a_global_search_for_given_billing_provider_criteria() {
        validateBillingProviderResultForCharacterLimit();
    }

    //  Scenario: Verify user able to search more than 2 characters in any two fields
    @When("user searches more than two characters in State {string} field")
    public void user_searches_more_than_two_characters_in_state_field(String state) throws InterruptedException {
        enterStateInSearchField(state);
    }

    @Then("user should be able to display the claim records in a Global Search")
    public void user_should_be_able_to_display_the_claim_records_in_a_global_search() {
        validateStateResultForCharacterLimit();
    }

}
