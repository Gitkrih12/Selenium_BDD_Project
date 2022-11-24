package Automation.StepDefinitions;

import Automation.PageObjects.PriorAuthorizationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriorAuthorizationStepDef extends PriorAuthorizationPage {

    @When("user clicks on Prior Authorization under Member Management")
    public void user_clicks_on_prior_authorization_under_member_management() {
        userClicksMemberManagement();
        userClickOnPriorAuthorization();
    }

    @Then("user navigates to the {string} successfully")
    public void user_navigates_to_the_successfully(String expTab) {
        verifyPriorAuthorizationPage(expTab);
    }

    @Then("user should be able to view the below column fields under Prior Authorization")
    public void user_should_be_able_to_view_the_below_column_fields_under_prior_authorization(DataTable expFields) {
        verifyPriorAuthorizationFields(expFields);
    }

    @When("user enters the Authorization number and clicks on the Search button")
    public void user_enters_the_authorization_number_and_clicks_on_the_search_button() {
        userEntersAuthorizationNumber();
    }
    @Then("user able to view the Authorization field value under Prior Authorization")
    public void user_able_to_view_the_authorization_field_value_under_prior_authorization() {
        verifyAuthorizationFieldValueUnderPriorAuthorization();
    }
    @When("user enters the Member ID and clicks on Search button")
    public void user_enters_the_member_id_and_clicks_on_search_button() {
        userEntersMemberID();
    }

    @Then("user able to view the Member ID field value under Prior Authorization")
    public void user_able_to_view_the_member_id_field_value_under_prior_authorization() {
        verifyMemberIDFieldValueUnderPriorAuthorization();
    }

    @When("user enters the Member Name and clicks on Search button")
    public void user_enters_the_member_name_and_clicks_on_search_button() {
        userEntersMemberName();
    }

    @Then("user able to view the Member Name field value under Prior Authorization")
    public void user_able_to_view_the_member_name_field_value_under_prior_authorization() {
        verifyMemberNameFieldValue();
    }

    @When("user enters the From Date and clicks on Search button")
    public void user_enters_the_from_date_and_clicks_on_search_button() {
        userEntersFromDate();
    }

    @Then("user able to view the From Date field value under Prior Authorization")
    public void user_able_to_view_the_from_date_field_value_under_prior_authorization() {
        verifyFromDateFieldValue();
    }

    @When("user enters the To Date and clicks on Search button")
    public void user_enters_the_to_date_and_clicks_on_search_button() {
        userEntersToDate();
    }

    @Then("user able to view the To Date field value under Prior Authorization")
    public void user_able_to_view_the_to_date_field_value_under_prior_authorization() {
        verifyToDateFieldValue();
    }

    @When("user enters the Status and clicks on Search button")
    public void user_enters_the_status_and_clicks_on_search_button() {
        userEntersStatus();
    }

    @Then("user able to view the Status field value under Prior Authorization")
    public void user_able_to_view_the_status_field_value_under_prior_authorization() {
        verifyStatusFieldValue();
    }

    @When("user clicks on Authorization number")
    public void user_clicks_on_authorization_number() {
        userClicksOnAuthorizationNumber();
    }

    @Then("user able to view {string} pop up")
    public void user_able_to_view_pop_up(String expPopUp) {
        verifyAuthorizationSummaryPopUpDisplayed(expPopUp);
    }

    @Then("user able to view the {string}")
    public void user_able_to_view_the(String expField) {
        verifyPlanAuthNumber(expField);
    }

    @Then("user able to view all the below legends in Authorization summary pop up")
    public void user_able_to_view_all_the_below_legends_in_authorization_summary_pop_up(DataTable expLegends) {
        verifyAllLegends(expLegends);
    }

    @Then("user able to view the below fields under Member Information section in Authorization Summary")
    public void user_able_to_view_the_below_fields_under_member_information_section_in_authorization_summary(io.cucumber.datatable.DataTable dataTable) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        throw new io.cucumber.java.PendingException();
    }
    
    @Then("user able to view all the field values under Member Information section in Authorization summary")
    public void user_able_to_view_all_the_field_values_under_member_information_section_in_authorization_summary() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
