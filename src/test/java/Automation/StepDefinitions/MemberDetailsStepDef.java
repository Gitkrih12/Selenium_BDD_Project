package Automation.StepDefinitions;

import Automation.PageObjects.MemberDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MemberDetailsStepDef extends MemberDetailsPage {


    //  Scenario: Verify user should navigates to Member Information screen on clicking Patient ID/MBR ID
    @When("user clicks on the Patient ID or MBR ID")
    public void user_clicks_on_the_patient_id_or_mbr_id() throws InterruptedException {
        userClicksOnPatientID();
    }

    @Then("user navigates to the Member Information page")
    public void user_navigates_to_the_member_information_page() {
        verifyMemberInfoPage();
    }

    //  Scenario: Verify fields in the Member Information page
    @Then("user should be able to view the below fields")
    public void user_should_be_able_to_view_the_below_fields(DataTable expFields) {
        userViewsFields(expFields);
    }

    //  Scenario: Verify Member Information tabs
    @Then("user should be able to view the below tabs")
    public void user_should_be_able_to_view_the_below_tabs(DataTable expTabs) {
        userViewsTheTabs(expTabs);
    }

    @Then("user navigates to the Provider Details tab by default should be {string}")
    public void user_navigates_to_the_provider_details_tab_by_default_should_be(String expValue) {
        userNavigatesDefaultToProviderDetails(expValue);
    }

    @Then("user should be able to view the below column fields under Provider Details tab")
    public void user_should_be_able_to_view_the_below_column_fields_under_provider_details_tab(DataTable expFields) {
        userViewsFieldsUnderProviderDetails(expFields);
    }
}