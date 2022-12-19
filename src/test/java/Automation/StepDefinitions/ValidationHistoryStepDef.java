package Automation.StepDefinitions;

import Automation.PageObjects.ValidationHistoryPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationHistoryStepDef extends ValidationHistoryPage {

    @When("user clicking on Validation History Claim Number")
    public void user_clicking_on_validation_history_claim_number() throws InterruptedException {
        clickOnGlobalSearch();
        enterClaimNumberInSearchField();
        clickOnClaimNumber();
    }

    @When("user clicks on Validation History tab")
    public void user_clicks_on_validation_history_tab() {
        clickOnValidationHistory();
    }

    @Then("user should navigates to the {string} tab successfully")
    public void user_should_navigates_to_the_tab_successfully(String expTab) {
        verifyValidationHistoryTab(expTab);
    }

    @Then("user able to view the below mentioned fields under Validation History subtab")
    public void user_able_to_view_the_below_mentioned_fields_under_validation_history_subtab(DataTable expFields) {
        verifyFieldsUnderValidationHistory(expFields);
    }
}