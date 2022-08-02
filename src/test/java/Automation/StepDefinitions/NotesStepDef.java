package Automation.StepDefinitions;

import Automation.PageObjects.NotesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NotesStepDef extends NotesPage {

    @When("user clicks on the Notes tab")
    public void user_clicks_on_the_notes_tab() throws InterruptedException {
        userClicksOnNotesTab();
    }

    @Then("user navigates to the {string} tab")
    public void user_navigates_to_the_tab(String expTab) {
        verifyUserNavigatedToNotesTab(expTab);
    }

    @Then("user should be able to view the below column fields")
    public void user_should_be_able_to_view_the_below_column_fields(DataTable columnFields) {
        verifyColumnsUnderNotesTab(columnFields);
    }

    @Then("user views the footer section in Notes tab")
    public void user_views_the_footer_section_in_notes_tab(DataTable footerFields) {
        userViewsFooterSectionInNotesTab(footerFields);
    }
}