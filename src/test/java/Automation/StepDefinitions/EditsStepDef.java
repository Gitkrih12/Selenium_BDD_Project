package Automation.StepDefinitions;

import Automation.PageObjects.EditsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EditsStepDef extends EditsPage {

    //  Scenario: Verify user able to navigate to Edits tab from Global Search and validate the fields
    @When("user clicks on Edits tab")
    public void user_clicks_on_edits_tab() throws InterruptedException {
        clickOnEditsTab();
    }

    @Then("user navigates to {string} tab in View page")
    public void user_navigates_to_tab_in_view_page(String expTab) {
        verifyUserNavigatesToEditsTab(expTab);
    }

    @Then("user able to view two sub tabs as {string} and {string}")
    public void user_able_to_view_two_sub_tabs_as_and(String expSubTab1, String expSubTab2) {
        verifyUserViewsServiceLevelSubTab(expSubTab1);
        verifyUserViewsClaimLevelSubTab(expSubTab2);
    }

    //  Scenario: Validate buttons functionality of Edits tab
    @Then("user views the footer section in Edits page")
    public void user_views_the_footer_section_in_edits_page(DataTable footerSection) {
        userViewsFooterSectionInEditsPage(footerSection);
    }

    //  Scenario: Verify Service Level Edits Sub tab functionality
    @When("user clicking on Edits Claim Number in Global Search page")
    public void user_clicking_on_edits_claim_number_in_global_search_page() throws InterruptedException {
        clickOnGlobalSearch();
        enterClaimNumberInSearchField();
        clickOnClaimNumber();
    }

    @Then("user should be able to view below columns in Service Level Edits")
    public void user_should_be_able_to_view_below_columns_in_service_level_edits(DataTable columnFields) {
        userViewsServiceLevelEditsFields(columnFields);
    }

    @Then("user able to view all the field values in Service Level Edits")
    public void user_able_to_view_all_the_field_values_in_service_level_edits() {
        verifyFieldValuesUnderServiceLevelEditsTab();
    }

    @Then("user able to view the search box for all the columns in Service Level Edits")
    public void user_able_to_view_the_search_box_for_all_the_columns_in_service_level_edits() {
        verifySearchBoxInServiceLevelEdits();
    }

    //  Scenario: Verify Edit & Delete functionality in Service Level Edits Sub tab
    @Then("user should be able to view Delete action item")
    public void user_should_be_able_to_view_delete_action_item() {
        userViewsDeleteButtonUnderServiceLevelTab();
    }

    @Then("user should be able to view Edit action item")
    public void user_should_be_able_to_view_edit_action_item() {
        userViewsEditButtonUnderServiceLevelTab();
    }

    // Scenario: Verify Claim Level Edits Sub-tab
    @When("user clicks on Claim Level Edits tab")
    public void user_clicks_on_claim_level_edits_tab() throws InterruptedException {
        userClicksOnClaimLevelEditsTab();
    }

    @Then("user should be able to view below columns in Claim Level Edits")
    public void user_should_be_able_to_view_below_columns_in_claim_level_edits(DataTable editLevelColumnFields) {
        userViewsClaimLevelEditsFields(editLevelColumnFields);
    }

    @Then("user able to view all the field values in Claim Level Edits")
    public void user_able_to_view_all_the_field_values_in_claim_level_edits() {
        verifyFieldValuesUnderClaimLevelEditsTab();
    }

    @Then("user able to view the search box for all the columns in Claim Level Edits")
    public void user_able_to_view_the_search_box_for_all_the_columns_in_claim_level_edits() {
        verifySearchBoxInClaimLevelEdits();
    }

    @Then("user should be able to view Delete action item in Claim Level Edits")
    public void user_should_be_able_to_view_delete_action_item_in_claim_level_edits() {
        userViewsDeleteButtonUnderClaimLevelTab();
    }

    @Then("user should be able to view Edit action item in Claim Level Edits")
    public void user_should_be_able_to_view_edit_action_item_in_claim_level_edits() {
        userViewsEditButtonUnderClaimLevelTab();
    }
}