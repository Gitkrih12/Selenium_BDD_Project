package Automation.StepDefinitions;

import Automation.PageObjects.ValidationHistoryPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ValidationHistoryStepDef extends ValidationHistoryPage {

    //  Scenario: Verify user able to navigate to the Validation History tab
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

    //  Scenario: Verify user able to view all the column fields under Validation History subtab
    @Then("user able to view the below mentioned fields under Validation History subtab")
    public void user_able_to_view_the_below_mentioned_fields_under_validation_history_subtab(DataTable expFields) {
        verifyFieldsUnderValidationHistory(expFields);
    }

    //  Scenario: Verify user able to view the search criteria for Date and Time
    @When("user searches for Date and Time in the field")
    public void user_searches_for_date_and_time_in_the_field() {
        userEntersDateAndTime();
    }

    @Then("user able to view the Date and Time field value")
    public void user_able_to_view_the_date_and_time_field_value() {
        verifyDateAndTimeFieldValue();
    }

    //  Scenario: Verify user able to view the search criteria for Service Line No.
    @When("user searches for Service Line No in the field")
    public void user_searches_for_service_line_no_in_the_field() {
        userEntersServiceLineNo();
    }

    @Then("user able to view the Service Line No field value")
    public void user_able_to_view_the_service_line_no_field_value() {
        verifyServiceLineNoFieldValue();
    }

    //  Scenario: Verify user able to view the search criteria for Activity
    @When("user searches for Activity in the field")
    public void user_searches_for_activity_in_the_field() {
        userEntersActivity();
    }

    @Then("user able to view the Activity field value")
    public void user_able_to_view_the_activity_field_value() {
        verifyActivityFieldValue();
    }

    //  Scenario: Verify user able to view the search criteria for Description
    @When("user searches for Description in the field")
    public void user_searches_for_description_in_the_field() {
        userEntersDescription();
    }

    @Then("user able to view the Description field value")
    public void user_able_to_view_the_description_field_value() {
        verifyDescriptionFieldValue();
    }

    //  Scenario: Verify user able to view the search criteria for Performed By
    @When("user searches for Performed By in the field")
    public void user_searches_for_performed_by_in_the_field() {
        userEntersPerformedBy();
    }

    @Then("user able to view the Performed By field value")
    public void user_able_to_view_the_performed_by_field_value() {
        verifyPerformedByFieldValue();
    }

    //  Scenario: Verify footer section available in Validation History tab
    @Then("user views the footer section in Validation History tab")
    public void user_views_the_footer_section_in_validation_history_tab(DataTable expFields) {
        verifyFooterFieldsInValidationHistory(expFields);
    }
}