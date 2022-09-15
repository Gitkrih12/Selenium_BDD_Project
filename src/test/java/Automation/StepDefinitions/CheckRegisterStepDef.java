package Automation.StepDefinitions;

import Automation.PageObjects.CheckRegisterPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckRegisterStepDef extends CheckRegisterPage {

    @When("user clicks on Check Register under Check Management")
    public void user_clicks_on_check_register_under_check_management() throws InterruptedException {
        userClicksOnCheckRegister();
    }

    @Then("user able to navigate to the Check Register page")
    public void user_able_to_navigate_to_the_check_register_page() {
        verifyUserNavigatesToCheckRegister();
    }

    @Then("user able to view all the below mentioned fields under Check Register")
    public void user_able_to_view_all_the_below_mentioned_fields_under_check_register(DataTable expFields) {
        verifyFieldsUnderCheckRegister(expFields);
    }

    @When("user select value from Billing Provider dropdown field")
    public void user_select_value_from_billing_provider_dropdown_field() throws InterruptedException {
        userSelectsValuesFromBillingProviderDropDown();
    }

    @Then("user able to view the result for the search criteria")
    public void user_able_to_view_the_result_for_the_search_criteria() {
        verifyTheResultForTheSearchCriteria();
    }
}
