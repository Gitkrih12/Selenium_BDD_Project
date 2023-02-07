package Automation.StepDefinitions;

import Automation.PageObjects.IdnLettersPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class IdnLettersStepDef extends IdnLettersPage {

    //    Scenario: Verify user able to navigate to IDN screen under Letters tab
    @When("user clicks on IDN tab")
    public void user_clicks_on_idn_tab() {
        clickOnIdnTab();
    }

    @Then("user should navigate to IDN screen")
    public void user_should_navigate_to_idn_screen() {
        verifyUserIsOnIdnScreen();
    }

    //    Scenario: Verify column fields under IDN screen
    @Then("the user should be able to view the following column fields under IDN letters tab")
    public void the_user_should_be_able_to_view_the_following_column_fields_under_idn_letters_tab(DataTable idnLetters) throws InterruptedException {
        verifyColumnFieldsUnderIdnLettersTab(idnLetters);
    }

    //    Scenario: Verify column search fields under IDN screen
    @Then("user should be able to view IDN letters column fields search boxes")
    public void user_should_be_able_to_view_idn_letters_column_fields_search_boxes() {
        verifyIdnLettersColumnsSearchFields();
    }

    //    Scenario: Verify results of Member rows count next to "IDN" tab name
    @Then("user should be able to see the results of rows count next to IDN Tab name")
    public void user_should_be_able_to_see_the_results_of_rows_count_next_to_idn_tab_name() throws InterruptedException {
        validateRowCountNextToIdnLettersTab();
    }

    //    Verify user should be able to get results by applying filter on "Batch ID" column under Letters IDN tab
    @When("user enters IDN batch id record under batch id search box")
    public void user_enters_idn_batch_id_record_under_batch_id_search_box() {
        verifyUserEntersIdnBatchIdUnderSearchBox();
    }

    @Then("user should be able to view IDN batch id under results section")
    public void user_should_be_able_to_view_idn_batch_id_under_results_section() {
        verifyUserAbleToViewIdnBatchIdRecordsUnderSearchResultsSection();
    }

    //    Verify user should be able to get results by applying filter on "Claim Number" column under Letters IDN tab
    @When("user enters IDN claim number record under claim number search box")
    public void user_enters_idn_claim_number_record_under_claim_number_search_box() {
        verifyUserEntersIdnClaimNumberUnderSearchBox();
    }

    @Then("user should be able to view IDN claim number under results section")
    public void user_should_be_able_to_view_idn_claim_number_under_results_section() {
        verifyUserAbleToViewIdnClaimNumberRecordsUnderSearchResultsSection();
    }

    //    Verify user should be able to get results by applying filter on "Provider Name" column under Letters IDN tab
    @When("user enters IDN provider name record under provider name search box")
    public void user_enters_idn_provider_name_record_under_provider_name_search_box() {
        verifyUserEntersIdnProviderNameUnderSearchBox();
    }

    @Then("user should be able to view IDN provider name under results section")
    public void user_should_be_able_to_view_idn_provider_name_under_results_section() {
        verifyUserAbleToViewIdnProviderNameRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member ID" column under Letters IDN tab
    @When("user enters IDN member id record under member id search box")
    public void user_enters_idn_member_id_record_under_member_id_search_box() {
        verifyUserEntersIdnMemberIdUnderSearchBox();
    }

    @Then("user should be able to view IDN member id under results section")
    public void user_should_be_able_to_view_idn_member_id_under_results_section() {
        verifyUserAbleToViewIdnMemberIdRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member Name" column under Letters IDN tab
    @When("user enters IDN member name record under member name search box")
    public void user_enters_idn_member_name_record_under_member_name_search_box() {
        verifyUserEntersIdnMemberNameUnderSearchBox();
    }

    @Then("user should be able to view IDN member name under results section")
    public void user_should_be_able_to_view_idn_member_name_under_results_section() {
        verifyUserAbleToViewIdnMemberNameRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under Letters IDN tab
    @When("user enters IDN created date under date of creation search box")
    public void user_enters_idn_created_date_under_date_of_creation_search_box() {
        verifyUserEntersIdnCreatedDateUnderSearchBox();
    }

    @Then("user should be able to view IDN created date under results section")
    public void user_should_be_able_to_view_idn_created_date_under_results_section() {
        verifyUserAbleToViewIdnCreatedDateRecordsUnderSearchResultsSection();
    }


}
