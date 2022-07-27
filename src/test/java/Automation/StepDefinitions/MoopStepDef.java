package Automation.StepDefinitions;

import Automation.PageObjects.MoopPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MoopStepDef extends MoopPage {

    //  Scenario: Verify user should be able to navigate to the MOOP page through view claims from Global Search page
    @When("user clicks on Moop tab")
    public void user_clicks_on_moop_tab() {
        userClicksOnMoopTab();
    }

    @Then("user navigates to {string} tab")
    public void user_navigates_to_tab(String expTab) {
        verifyUserNavigatesToMoop(expTab);
    }

    //  Scenario: Verify user should be able to view the appropriate table with all the fields in MOOP page
    @Then("user able to view the below fields under Moop tab")
    public void user_able_to_view_the_below_fields_under_moop_tab(DataTable columnFields) {
        userViewsAllColumnFieldsInMoop(columnFields);
    }

    //  Scenario: Verify the footer section should display in MOOP page
    @Then("user views the footer section in Moop page")
    public void user_views_the_footer_section_in_moop_page(DataTable footerFields) {
        userViewsFooterSectionInMoopPage(footerFields);
    }

    //  Scenario: Verify Deny button should highlight in Red color in footer section
    @Then("Deny button should highlight in Red color {string} in footer section")
    public void deny_button_should_highlight_in_red_color_in_footer_section(String expColor) {
        denyButtonHighlightsInRedColor(expColor);
    }
}
