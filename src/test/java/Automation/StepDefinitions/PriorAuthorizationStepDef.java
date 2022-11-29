package Automation.StepDefinitions;

import Automation.PageObjects.PriorAuthorizationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriorAuthorizationStepDef extends PriorAuthorizationPage {

    //  Scenario: Verify user able to view all the columns when user clicks on Prior Authorization under Member Management
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

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for Authorization number
    @When("user enters the Authorization number and clicks on the Search button")
    public void user_enters_the_authorization_number_and_clicks_on_the_search_button() {
        userEntersAuthorizationNumber();
    }

    @Then("user able to view the Authorization field value under Prior Authorization")
    public void user_able_to_view_the_authorization_field_value_under_prior_authorization() {
        verifyAuthorizationFieldValueUnderPriorAuthorization();
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for Member ID
    @When("user enters the Member ID and clicks on Search button")
    public void user_enters_the_member_id_and_clicks_on_search_button() {
        userEntersMemberID();
    }

    @Then("user able to view the Member ID field value under Prior Authorization")
    public void user_able_to_view_the_member_id_field_value_under_prior_authorization() {
        verifyMemberIDFieldValueUnderPriorAuthorization();
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for Member Name
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

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for From Date
    @Then("user able to view the From Date field value under Prior Authorization")
    public void user_able_to_view_the_from_date_field_value_under_prior_authorization() {
        verifyFromDateFieldValue();
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for To Date
    @When("user enters the To Date and clicks on Search button")
    public void user_enters_the_to_date_and_clicks_on_search_button() {
        userEntersToDate();
    }

    @Then("user able to view the To Date field value under Prior Authorization")
    public void user_able_to_view_the_to_date_field_value_under_prior_authorization() {
        verifyToDateFieldValue();
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for Status
    @When("user enters the Status and clicks on Search button")
    public void user_enters_the_status_and_clicks_on_search_button() {
        userEntersStatus();
    }

    @Then("user able to view the Status field value under Prior Authorization")
    public void user_able_to_view_the_status_field_value_under_prior_authorization() {
        verifyStatusFieldValue();
    }

    //  Scenario: Verify Authorization summary pop up should display on clicking Authorization number
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

    //  Scenario: Verify all the legends should display in the Authorization summary pop up
    @Then("user able to view all the below legends in Authorization summary pop up")
    public void user_able_to_view_all_the_below_legends_in_authorization_summary_pop_up(DataTable expLegends) {
        verifyAllLegends(expLegends);
    }

    //  Scenario: Verify all fields under Member Information section
    @Then("user able to view the below fields under Member Information section in Authorization Summary")
    public void user_able_to_view_the_below_fields_under_member_information_section_in_authorization_summary(DataTable expFields) {
        verifyMemberInformationSection(expFields);
    }

    @Then("user able to view all the field values under Member Information section in Authorization summary")
    public void user_able_to_view_all_the_field_values_under_member_information_section_in_authorization_summary() {
        verifyFieldValuesUnderMemberInfo();
    }

    //  Scenario: Verify user able to view all the fields under Auth Details section
    @Then("user able to view the below fields under Auth Details section")
    public void user_able_to_view_the_below_fields_under_auth_details_section(DataTable expFields) {
        verifyFieldsUnderAuthDetails(expFields);
    }

    @Then("user able to view all the field values under Auth Details section")
    public void user_able_to_view_all_the_field_values_under_auth_details_section() {
        verifyFieldValuesUnderAuthDetails();
    }

    //  Scenario: Verify user able to view all the fields mentioned under Requesting Provider (IN) Section
    @Then("user able to view the below fields under Requesting Provider section")
    public void user_able_to_view_the_below_fields_under_requesting_provider_section(DataTable expFields) {
        verifyFieldsUnderRequestingProvider(expFields);
    }

    @Then("user able to view all the field values under Requesting Provider section")
    public void user_able_to_view_all_the_field_values_under_requesting_provider_section() {
        verifyFieldValuesUnderRequestingProvider();
    }

    //  Scenario: Verify user able to view all the fields under Attending Provider (IN) section
    @Then("user able to view the below fields under Attending Provider section")
    public void user_able_to_view_the_below_fields_under_attending_provider_section(DataTable expFields) {
        verifyFieldsUnderAttendingProvider(expFields);
    }

    @Then("user able to view all the field values under Attending Provider section")
    public void user_able_to_view_all_the_field_values_under_attending_provider_section() {
        verifyFieldValuesUnderAttendingProvider();
    }

    //  Scenario: Verify user able to view all the fields under Admitting Provider (IN)
    @Then("user able to view the below fields under Admitting Provider section")
    public void user_able_to_view_the_below_fields_under_admitting_provider_section(DataTable expFields) {
        verifyFieldsUnderAdmittingProvider(expFields);
    }

    @Then("user able to view all the field values under Admitting Provider section")
    public void user_able_to_view_all_the_field_values_under_admitting_provider_section() {
        verifyFieldValuesUnderAdmittingProvider();
    }

    //  Scenario: Verify user able to view all the fields under Facility (IN) section
    @Then("user able to view the below fields under Facility section")
    public void user_able_to_view_the_below_fields_under_facility_section(DataTable expFields) {
        verifyFieldsUnderFacility(expFields);
    }

    @Then("user able to view all the field values under Facility section")
    public void user_able_to_view_all_the_field_values_under_facility_section() {
        verifyFieldValuesUnderFacility();
    }

    //  Scenario: Verify user able to view all the fields under Admission/DC Dates
    @Then("user able to view the below fields under Admission DC Dates section")
    public void user_able_to_view_the_below_fields_under_admission_dc_dates_section(DataTable expFields) {
        verifyFieldsUnderAdmissionDCDates(expFields);
    }

    @Then("user able to view all the field values under Admission DC Dates section")
    public void user_able_to_view_all_the_field_values_under_admission_dc_dates_section() {
        verifyFieldValuesUnderAdmissionDcDates();
    }

    //  Scenario: Verify user able to view all the fields under Length Of Stay section
    @Then("user able to view the below fields under Length Of Stay section")
    public void user_able_to_view_the_below_fields_under_length_of_stay_section(DataTable expFields) {
        verifyFieldsUnderLengthOfStay(expFields);
    }

    @Then("user able to view all the field values under Length Of Stay section")
    public void user_able_to_view_all_the_field_values_under_length_of_stay_section() {
        verifyFieldValuesUnderLengthOfStay();
    }

    //  Scenario: Verify user able to view all the fields under Primary ICD Details and CPT/HCPCS Code Table
    @Then("user able to view the below fields under Primary ICD Details and CPT HCPCS Code table")
    public void user_able_to_view_the_below_fields_under_primary_icd_details_and_cpt_hcpcs_code_table(DataTable expFields) {
        verifyFieldsUnderPrimaryICDDetailsAndCptHcpcsCode(expFields);
    }

    @Then("user able to view all the field values under Primary ICD Details and CPT HCPCS Code table")
    public void user_able_to_view_all_the_field_values_under_primary_icd_details_table() {
        verifyFieldValuesUnderPrimaryICDDetailsAndCptHcpcsCode();
    }

    //  Scenario: Verify user able to view all the fields under Documents Table
    @Then("user able to view the below fields under Documents table")
    public void user_able_to_view_the_below_fields_under_documents_table(DataTable expFields) {
        verifyFieldsUnderDocuments(expFields);
    }

    @Then("user able to view all the field values under Documents table")
    public void user_able_to_view_all_the_field_values_under_documents_table() {
        verifyFieldValuesUnderDocuments();
    }
}
