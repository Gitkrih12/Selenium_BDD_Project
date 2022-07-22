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
}