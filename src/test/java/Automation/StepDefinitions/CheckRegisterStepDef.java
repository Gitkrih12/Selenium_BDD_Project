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

    @When("user select value from Facility dropdown field")
    public void user_select_value_from_facility_dropdown_field() throws InterruptedException {
        userSelectsValuesFromFacilityDropDown();
    }

    @Then("user able to view the result for the facility dropdown search criteria")
    public void user_able_to_view_the_result_for_the_facility_dropdown_search_criteria() {
        verifyTheResultForTheFacilitySearchCriteria();
    }

    @When("user select dates from Created Date From and To dropdown field")
    public void user_select_dates_from_created_date_from_and_to_dropdown_field() throws InterruptedException {
        userSelectsValuesFromCreatedDateFromField();
        userSelectsValuesFromCreatedDateToField();
    }

    @Then("user able to view the result for the Created Date dropdown search criteria")
    public void user_able_to_view_the_result_for_the_created_date_dropdown_search_criteria(){
        verifyTheResultForTheCreatedDateSearchCriteria();
    }

    @When("user select dates from Date of Service From and To dropdown field")
    public void user_select_dates_from_date_of_service_from_and_to_dropdown_field() throws InterruptedException {
        userSelectsValuesFromDateOfServiceFromField();
        userSelectsValuesFromDateOfServiceToField();
    }

    @Then("user able to view the result for the Date of Service dropdown search criteria")
    public void user_able_to_view_the_result_for_the_date_of_service_dropdown_search_criteria() {
        verifyTheResultForTheDateOfServiceSearchCriteria();
    }

    @When("user select value from State dropdown field")
    public void user_select_value_from_state_dropdown_field() throws InterruptedException {
        userSelectsValuesFromStateField();
    }

    @Then("user able to view the result for the State dropdown search criteria")
    public void user_able_to_view_the_result_for_the_state_dropdown_search_criteria() {
        verifyTheResultForTheStateSearchCriteria();
    }

    @When("user select value from Place of Service dropdown field")
    public void user_select_value_from_place_of_service_dropdown_field() throws InterruptedException {
        userSelectsValuesFromPlaceOfServiceDropdownField();
    }

    @Then("user able to view the result for the Place of Service dropdown search criteria")
    public void user_able_to_view_the_result_for_the_place_of_service_dropdown_search_criteria() {
        verifyTheResultForThePlaceOfServiceSearchCriteria();
    }
}
