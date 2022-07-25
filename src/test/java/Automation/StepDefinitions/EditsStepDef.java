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

    @Then("user navigates to the {string} tab")
    public void user_navigates_to_the_tab(String expTab) {
        verifyUserNavigatesToEditsTab(expTab);
    }

    @Then("user able to view two sub tabs as {string} and {string}")
    public void user_able_to_view_two_sub_tabs_as_and(String expSubTab1, String expSubTab2) {
        verifyUserViewsServiceLevelSubTab(expSubTab1);
        verifyUserViewsClaimLevelSubTab(expSubTab2);
    }

    @Then("user views the footer section in Edits page")
    public void user_views_the_footer_section_in_edits_page(DataTable footerSection) {
        userViewsFooterSectionInEditsPage(footerSection);
    }

    @Then("user should be able to view below columns in Service Level Edits")
    public void user_should_be_able_to_view_below_columns_in_service_level_edits(DataTable columnFields) {
        userViewsServiceLevelEditsTab(columnFields);
    }

    @Then("user should be able to view Delete action item highlighted in blue color")
    public void user_should_be_able_to_view_delete_action_item_highlighted_in_blue_color() {
        userViewsDeleteButtonHighlightedInBlue();
    }

    @Then("user should be able to view below columns in Claim Level Edits")
    public void user_should_be_able_to_view_below_columns_in_claim_level_edits(DataTable editLevelColumnFields) {
        userViewsClaimLevelEditsTab(editLevelColumnFields);
    }

    @Then("user should be able to view Edit action item highlighted in red color")
    public void user_should_be_able_to_view_edit_action_item_highlighted_in_red_color() {
       userViewsEditButtonHighlightedInRed();
    }
}