package Automation.StepDefinitions;

import Automation.PageObjects.ActivityLoggerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ActivityLoggerStepDef extends ActivityLoggerPage {


    //  Scenario: Verify user able to navigate to Activity Logger tab
    @When("user clicks on the Activity Logger tab")
    public void user_clicks_on_the_activity_logger_tab() throws InterruptedException {
        userClicksOnActivityLogger();
    }

    @Then("user able to navigate to the {string} tab")
    public void user_able_to_navigate_to_the_tab(String expTab) {
        verifyUserNavigatesToActivityLogger(expTab);
    }

    @Then("user able to view the below mentioned fields in Activity Logger tab")
    public void user_able_to_view_the_below_mentioned_fields_in_activity_logger_tab(DataTable expFields) {
        userViewsActivityLoggerFields(expFields);
    }

    @Then("user able to view all the field values under Activity Logger tab")
    public void user_able_to_view_all_the_field_values_under_activity_logger_tab() throws InterruptedException {
        enterChangesetInSearchField();
        verifyFieldValuesUnderActivityLogger();
    }

    //  Scenario: Verify user able to navigate to Activity Logger tab and validated the buttons
    @Then("user able to view the below footer section in Activity Logger")
    public void user_able_to_view_the_below_footer_section_in_activity_logger(DataTable expFooterSection) {
        userViewsFooterSectionInActivityLogger(expFooterSection);
    }
}