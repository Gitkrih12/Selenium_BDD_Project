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
    @Then("user should able to view the Filter and Customize columns buttons")
    public void user_should_able_to_view_the_filter_and_customize_columns_buttons() {
        verifyFilterButton();
        verifyCustomisedColumn();

    }
    @Then("user should able to see column fields in global Search page")
    public void user_should_able_to_see_column_fields(DataTable columnList) {
        verifyColumnFields(columnList);
    }

    @Then("user able to view the Search fields under each column except follow up column")
    public void user_able_to_view_the_search_fields_under_each_column_except_follow_up_column() {
        verifySearchFieldUnderEachCoulmn();
    }
    @Then("user should land on Global Search page")
    public void user_should_land_on_global_search_page() {
        verifyAdjudicatorLandsonGlobalSearchPage();
    }

    @When("user enters the {string} in the Search field")
    public void user_enters_the_in_the_search_field(String claimNumber) throws InterruptedException {
        enterClaimNumberInSearchfield(claimNumber);
    }


    @Then("user able to view the exact claim details.")
    public void user_able_to_view_the_exact_claim_details() {
        validateClaimNumberResult();
    }
    @Then("user able to view the claim details for given filter criteria.")
    public void user_able_to_view_the_claim_details_for_given_filter_criteria() {
        validateClaimNumberResultForCharacterLimit();
    }
    @Then("user not able to view the claim details for given filter criteria.")
    public void user_not_able_to_view_the_claim_details_for_given_filter_criteria() {
        verifyNoDataDisplayMessage();
    }

    @When("user enters the member id {string} in the Search field")
    public void user_enters_the_member_id_in_the_search_field(String memberId) throws InterruptedException {
        enterMemberIdInSearchfield(memberId);
    }

    @Then("user able to view the claim details for given member id.")
    public void user_able_to_view_the_exact_member_details() {
        validateMemberIDResult();
    }

    @When("user enters the Patient Name {string} in the Search field")
    public void user_enters_the_patient_name_in_the_search_field(String patientName) throws InterruptedException {
        enterPatientNameInSearchfield(patientName);
    }
    @Then("user able to view the claim details for given Patient name.")
    public void user_able_to_view_the_exact_patient_details() {
        validatePatientNameResult();
    }

    @When("user enters the State {string} in the Search field")
    public void user_enters_the_state_in_the_search_field(String State) throws InterruptedException {
        enterStateInSearchfield(State);
    }
    @Then("user able to view the claim details for given State.")
    public void user_able_to_view_the_claim_details_for_given_state() {
        validateStateResult();
    }

    @When("user enters the Category {string} in the Search field")
    public void user_enters_the_category_in_the_search_field(String category) throws InterruptedException {
        enterCategoryInSearchfield(category);
    }
    @Then("user able to view the claim details for given Category.")
    public void user_able_to_view_the_claim_details_for_given_category() {
        validateCategoryResult();
    }

    @When("user enters the DOS From  {string} in the Search field")
    public void user_enters_the_dos_from_in_the_search_field(String DOSFrom) throws InterruptedException {
        enterDOSFromInSearchfield(DOSFrom);
    }
    @Then("user able to view the claim details for given DOS From.")
    public void user_able_to_view_the_claim_details_for_given_dos_from() {
        validateDOSFromResult();

    }
    @When("user enters the DOS To  {string} in the Search field")
    public void user_enters_the_dos_to_in_the_search_field(String DOSTo) throws InterruptedException {
        enterDOSToInSearchfield(DOSTo);
    }
    @Then("user able to view the claim details for given DOS To.")
    public void user_able_to_view_the_claim_details_for_given_dos_to() {
        validateDOSToResult();
    }
    @When("user enters the Billing Provider {string} in the Search field")
    public void user_enters_the_billing_provider_in_the_search_field(String BillingProvider) throws InterruptedException {
        enterBillingProviderInSearchfield(BillingProvider);
    }
    @Then("user able to view the claim details for given Billing Provider.")
    public void user_able_to_view_the_claim_details_for_given_billing_provider() {
        validateBillingProviderResult();
    }












}
