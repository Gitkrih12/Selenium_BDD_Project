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
    @Then("user able to view all the field values under Prior Authorization")
    public void user_able_to_view_all_the_field_values_under_prior_authorization() {
        verifyFieldValuesUnderPriorAuthorization();
    }
    @When("user enters the Member ID and clicks on Search button")
    public void user_enters_the_member_id_and_clicks_on_search_button() {
        userEntersMemberID();
    }
    @When("user enters the Member Name and clicks on Search button")
    public void user_enters_the_member_name_and_clicks_on_search_button() {
        userEntersMemberName();
    }
    @When("user enters the From Date and clicks on Search button")
    public void user_enters_the_from_date_and_clicks_on_search_button() {
        userEntersFromDate();
    }
    @When("user enters the To Date and clicks on Search button")
    public void user_enters_the_to_date_and_clicks_on_search_button() {
        userEntersToDate();
    }
    @When("user enters the Status and clicks on Search button")
    public void user_enters_the_status_and_clicks_on_search_button() {
        userEntersStatus();
    }
}
