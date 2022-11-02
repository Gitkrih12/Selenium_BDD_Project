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

    @Then("user able to view all the field values under Member Details page")
    public void user_able_to_view_all_the_field_values_under_member_details_page() {
        verifyFieldValuesUnderMemberDetails();
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

    @Then("user able to view the search criteria for all the columns in Provider Details tab")
    public void user_able_to_view_the_search_criteria_for_all_the_columns_in_provider_details_tab() {
        verifySearchCriteriaInProviderDetails();
    }

    @Then("user able to view all the field values under Provider Details tab")
    public void user_able_to_view_all_the_field_values_under_provider_details_tab() {
        verifyFieldValuesUnderProviderDetails();
    }

    //  Scenario: Verify user navigates to Address subtab in Member Details page
    @When("user clicks on Address subtab in Member Details page")
    public void user_clicks_on_address_subtab_in_member_details_page() throws InterruptedException {
        userClicksOnAddressSubTab();
    }

    @Then("user navigates to the {string} subtab successfully")
    public void user_navigates_to_the_subtab_successfully(String expSubTab) {
        userNavigatesToAddressSubTab(expSubTab);
    }

    //  Scenario: Verify column fields in Address sub tab in Member Details page
    @Then("user should be able to view the following columns")
    public void user_should_be_able_to_view_the_following_columns(DataTable expColumns) {
        userViewAddressSubTabColumns(expColumns);
    }

    @Then("user able to view the search criteria for all the columns in Address subtab")
    public void user_able_to_view_the_search_criteria_for_all_the_columns_in_address_subtab() {
        verifySearchCriteriaInAddress();
    }

    @Then("user able to view all the field values under Address subtab")
    public void user_able_to_view_all_the_field_values_under_address_subtab() {
        verifyFieldValuesUnderAddress();
    }

    //  Scenario: Verify user should navigate to Membership Information tab in Member Details page
    @When("user clicking on Membership Claim Number in Global Search page")
    public void user_clicking_on_membership_claim_number_in_global_search_page() throws InterruptedException {
        clickOnGlobalSearch();
        enterClaimNumberInSearchField();
        clickOnClaimNumber();
    }

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

    @Then("user able to view the search criteria for all the columns in Membership Information subtab")
    public void user_able_to_view_the_search_criteria_for_all_the_columns_in_membership_information_subtab() {
        verifySearchCriteriaInMembershipInfo();
    }

    @Then("user able to view all the field values under Membership Information subtab")
    public void user_able_to_view_all_the_field_values_under_membership_information_subtab() {
        verifyFieldValuesUnderMembershipInformation();
    }

    //  Scenario: Verify user should able to see Membership History column fields
    @Then("user should be able to view the following columns in Membership History")
    public void user_should_be_able_to_view_the_following_columns_in_membership_history(DataTable expMemberShipHistoryColumns) {
        userViewMemberShipHistoryColumns(expMemberShipHistoryColumns);
    }

    @Then("user able to view the search criteria for all the columns in Membership History subtab")
    public void user_able_to_view_the_search_criteria_for_all_the_columns_in_membership_history_subtab() {
        verifySearchCriteriaInMembershipHistory();
    }

    @Then("user able to view all the field values under Membership History subtab")
    public void user_able_to_view_all_the_field_values_under_membership_history_subtab() {
        verifyFieldValuesUnderMembershipHistory();
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

    @Then("user able to view all the field values under Claims subtab")
    public void user_able_to_view_all_the_field_values_under_claims_subtab() {
        verifyFieldValuesUnderClaims();
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

    // Scenario: Verify user should navigate to COB tab and view column fields in Member Details page
    @Then("user should be able to navigate to the {string} subtab in Member Details page")
    public void user_should_be_able_to_navigate_to_the_subtab_in_member_details_page(String expSubTab) {
        userNavigatesToCOBSubTab(expSubTab);
    }

    @Then("user able to view the following fields under COB subtab")
    public void user_able_to_view_the_following_fields_under_cob_subtab(DataTable expFields) {
        verifyCOBFields(expFields);
    }

    @Then("user able to view the search criteria for all the columns in COB subtab")
    public void user_able_to_view_the_search_criteria_for_all_the_columns_in_cob_subtab() {
        verifySearchCriteriaInCob();
    }

    /*@Then("user able to view all the field values under COB subtab")
    public void user_able_to_view_all_the_field_values_under_cob_subtab() {
        verifyCOBFieldValues();
    }*/

    //  Scenario: Verify user should navigate to MOOP tab and view column fields in Member Details page
    @When("user clicks on MOOP subtab")
    public void user_clicks_on_moop_subtab() throws InterruptedException {
        userClicksOnMOOPSubtab();
    }

    @Then("user navigates to the {string} subtab under Member Details page")
    public void user_navigates_to_the_subtab_under_member_details_page(String expSubtab) {
        userNavigatesToMOOPSubtab(expSubtab);
    }

    @Then("user able to view the below mentioned fields under MOOP subtab")
    public void user_able_to_view_the_below_mentioned_fields_under_moop_subtab(DataTable expFields) {
        verifyFieldsUnderMOOPSubtab(expFields);
    }

    @Then("user able to view the search criteria for all the columns in Moop subtab")
    public void user_able_to_view_the_search_criteria_for_all_the_columns_in_moop_subtab() {
        verifySearchCriteriaInMoop();
    }

    @Then("user able to view all the field values under Moop subtab")
    public void user_able_to_view_all_the_field_values_under_moop_subtab() {
        verifyMoopFieldValues();
    }

    //  Scenario: Verify user should navigate to Instructions tab and view column fields in Member Details page
    @When("user clicks on Instructions subtab")
    public void user_clicks_on_instructions_subtab() throws InterruptedException {
        userClicksOnInstructionsSubtab();
    }

    @Then("user navigates successfully to the {string} subtab")
    public void user_navigates_successfully_to_the_subtab(String expSubtab) {
        verifyUserNavigatesToInstructions(expSubtab);
    }

    @Then("user able to view the below mentioned fields under Instructions subtab")
    public void user_able_to_view_the_below_mentioned_fields_under_instructions_subtab(DataTable expColumns) {
        verifyColumnsUnderInstructions(expColumns);
    }

    @Then("user able to view the search criteria for all the columns in Instructions subtab")
    public void user_able_to_view_the_search_criteria_for_all_the_columns_in_instructions_subtab() {
        verifySearchCriteriaInInstructions();
    }

    @Then("user able to view all the field values under Instructions subtab")
    public void user_able_to_view_all_the_field_values_under_instructions_subtab() {
        verifyFieldValuesUnderInstructions();
    }

    //  Scenario: Verify user should navigate to HOSPICE tab and view column fields in Member Details page
    @When("user clicks on Hospice subtab")
    public void user_clicks_on_hospice_subtab() throws InterruptedException {
        userClicksOnHospiceSubtab();
    }

    @Then("user navigates to the {string} subtab under Member Details")
    public void user_navigates_to_the_subtab_under_member_details(String expSubtab) {
        userNavigatesToHospiceSubtab(expSubtab);
    }

    @Then("user able to view the below mentioned columns under Hospice subtab")
    public void user_able_to_view_the_below_mentioned_columns_under_hospice_subtab(DataTable expFields) {
        verifyFieldsUnderHospice(expFields);
    }

    @Then("user able to view the search criteria for all the columns in Hospice subtab")
    public void user_able_to_view_the_search_criteria_for_all_the_columns_in_hospice_subtab() {
        verifySearchCriteriaInHospice();
    }

}