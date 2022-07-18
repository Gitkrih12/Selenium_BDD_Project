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

    @Then("user able to view the exact claim details.")
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

    @Then("user able to view the claim details for given member id.")
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
    public void user_enters_the_state_in_the_search_field(String State) throws InterruptedException {
        enterStateInSearchField(State);
    }

    @Then("user able to view the claim details for given State.")
    public void user_able_to_view_the_claim_details_for_given_state() {
        validateStateResult();
    }

    //Scenario: Verify user enters the Category value in the Search field
    @When("user enters the Category {string} in the Search field")
    public void user_enters_the_category_in_the_search_field(String category) throws InterruptedException {
        enterCategoryInSearchField(category);
    }

    @Then("user able to view the claim details for given Category.")
    public void user_able_to_view_the_claim_details_for_given_category() {
        validateCategoryResult();
    }

    //  Scenario: Verify user enters the DOS From details in the Search field
    @When("user enters the DOS From {string} in the Search field")
    public void user_enters_the_dos_from_in_the_search_field(String DOSFrom) throws InterruptedException {
        enterDOSFromInSearchField(DOSFrom);
    }

    @Then("user able to view the claim details for given DOS From")
    public void user_able_to_view_the_claim_details_for_given_dos_from() {
        validateDOSFromResult();
    }

    //Scenario: Verify user enters the DOS To details in the Search field
    @When("user enters the DOS To {string} in the Search field")
    public void user_enters_the_dos_to_in_the_search_field(String DOSTo) throws InterruptedException {
        enterDOSToInSearchField(DOSTo);
    }

    @Then("user able to view the claim details for given DOS To")
    public void user_able_to_view_the_claim_details_for_given_dos_to() {
        validateDOSToResult();
    }

    // Scenario: Verify user enters the Billing Provider details in the Search field
    @When("user enters the Billing Provider {string} in the Search field")
    public void user_enters_the_billing_provider_in_the_search_field(String BillingProvider) throws InterruptedException {
        enterBillingProviderInSearchField(BillingProvider);
    }

    @Then("user able to view the claim details for given Billing Provider.")
    public void user_able_to_view_the_claim_details_for_given_billing_provider() {
        validateBillingProviderResult();
    }

}
