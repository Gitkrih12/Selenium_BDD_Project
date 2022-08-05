package Automation.StepDefinitions;

import Automation.PageObjects.MemberDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MemberDetailsStepDef extends MemberDetailsPage {


    //  Scenario: Verify user should navigates to Member Details screen on clicking Patient ID/MBR ID
    @When("user clicks on the Patient ID or MBR ID")
    public void user_clicks_on_the_patient_id_or_mbr_id() throws InterruptedException {
        userClicksOnPatientID();
    }

    @Then("user navigates to the Member Details page")
    public void user_navigates_to_the_member_details_page() {
        verifyMemberInfoPage();
    }

    //  Scenario: Verify fields in the Member Details page
    @Then("user should be able to view the below fields")
    public void user_should_be_able_to_view_the_below_fields(DataTable expFields) {
        userViewsFields(expFields);
    }

    //  Scenario: Verify Member Details tabs
    @Then("user should be able to view the below tabs")
    public void user_should_be_able_to_view_the_below_tabs(DataTable expTabs) {
        userViewsTheTabs(expTabs);
    }

    //  Scenario: Verify user should navigate to Provider Details on Clicking Patient ID/MBR ID in View claim Details page
    @Then("user navigates to the Provider Details tab by default should be {string}")
    public void user_navigates_to_the_provider_details_tab_by_default_should_be(String expValue) {
        userNavigatesDefaultToProviderDetails(expValue);
    }

    //  Scenario: Verify column fields in Provider Details tab
    @Then("user should be able to view the below column fields under Provider Details tab")
    public void user_should_be_able_to_view_the_below_column_fields_under_provider_details_tab(DataTable expFields) {
        userViewsFieldsUnderProviderDetails(expFields);
    }

    //  Scenario: Verify user navigates to Address subtab in Member Details page
    @When("user clicks on Address subtab in Member Details page")
    public void user_clicks_on_address_subtab_in_member_details_page() throws InterruptedException {
        userClicksOnAddressSubTab();
    }

    @Then("user navigates to the {string} subtab")
    public void user_navigates_to_the_subtab(String expSubTab) {
        userNavigatesToAddressSubTab(expSubTab);
    }

    //  Scenario: Verify column fields in Address sub tab in Member Details page
    @Then("user should be able to view the following columns")
    public void user_should_be_able_to_view_the_following_columns(DataTable expColumns) {
        userViewAddressSubTabColumns(expColumns);
    }

    //  Scenario: Verify user should navigate to Membership Information tab in Member Details page
    @When("user clicks on Membership Information subtab in Member Details page")
    public void user_clicks_on_membership_information_subtab_in_member_details_page() throws InterruptedException {
        userClicksOnMemberShipInfoSubTab();
    }

    @Then("user should be able to navigate to {string} subtab")
    public void user_should_be_able_to_navigate_to_subtab(String expSubTab) {
        userNavigatesToMemberShipInformation(expSubTab);
    }

    //  Scenario: Verify column fields in Membership Information tab
    @Then("user should be able to view the following columns in Membership Information subtab")
    public void user_should_be_able_to_view_the_following_columns_in_membership_information_subtab(DataTable expFields) {
        userViewMemberShipInfoColumns(expFields);
    }

    //  Scenario: Verify user should able to see Membership History column fields
    @Then("user should be able to view the following columns in Membership History")
    public void user_should_be_able_to_view_the_following_columns_in_membership_history(DataTable expMemberShipHistoryColumns) {
        userViewMemberShipHistoryColumns(expMemberShipHistoryColumns);
    }

    //  Scenario: Verify column fields in Claims subtab
    @When("user clicks on Claims subtab")
    public void user_clicks_on_claims_subtab() {
        userClicksOnClaimsSubTab();
    }

    @Then("user navigates to the {string} subtab in Member Details page")
    public void user_navigates_to_the_subtab_in_member_details_page(String expClaimsSubTab) {
        userNavigatesToClaimsSubTab(expClaimsSubTab);
    }

    @Then("user able to view all the fields under Claims subtab")
    public void user_able_to_view_all_the_fields_under_claims_subtab(DataTable expColumns) {
        userViewsAllFieldsUnderClaimsSubTab(expColumns);
    }

    //  Scenario: Verify Search functionality in claims subtab
    @Then("the user should be able to view the Search Criteria in Claim fields")
    public void the_user_should_be_able_to_view_the_search_criteria_in_claim_fields() {
        verifySearchBoxForAllFields();
    }

    @When("user clicks on COB subtab")
    public void user_clicks_on_cob_subtab() throws InterruptedException {
        userClicksOnCOB();
    }

    @Then("user should be able to navigate to the {string} subtab in Member Details page")
    public void user_should_be_able_to_navigate_to_the_subtab_in_member_details_page(String expSubTab) {
        userNavigatesToCOBSubTab(expSubTab);
    }

    @Then("user able to view the following fields under COB subtab")
    public void user_able_to_view_the_following_fields_under_cob_subtab(DataTable expFields) {
        verifyCOBFields(expFields);
    }
}