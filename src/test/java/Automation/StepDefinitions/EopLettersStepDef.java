package Automation.StepDefinitions;

import Automation.PageObjects.EopLettersPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EopLettersStepDef extends EopLettersPage {

    //    Scenario: Verify user navigates to EOP screen
    @When("the user clicks on EOP tab")
    public void the_user_clicks_on_Eop_tab() throws InterruptedException {
        clickOnEopTab();
    }
    @Then("user should be able to view the EOP screen under EOP tab")
    public void user_should_be_able_to_view_the_eop_screen_under_eop_tab() throws InterruptedException {
        verifyUserNavigatedToEopScreen();
    }

    //    Scenario: Verify columns fields in EOP screen
    @Then("the user should be able to view the following column fields under EOP letters tab")
    public void the_user_should_be_able_to_view_the_following_column_fields_under_eop_letters_tab(DataTable eopLetters) throws InterruptedException {
        verifyColumnFieldsUnderEopLettersTab(eopLetters);
    }
    @Then("user should be able to view EOP letters column fields search boxes")
    public void user_should_be_able_to_view_eop_letters_column_fields_search_boxes() {
        verifyEopLettersColumnsSearchFields();
    }

    //    Scenario: Verify results of Member rows count next to "EOP letters" tab name
    @Then("user should be able to see the results of rows count next to EOP letters Tab name")
    public void user_should_be_able_to_see_the_results_of_rows_count_next_to_eop_letters_tab_name() throws InterruptedException {
        validateRowCountNextToEopLettersTab();
    }

    //    Scenario: Verify Pagination in EOP screen
    @When("the data exceeds the defined page size under EOP letters tab")
    public void the_data_exceeds_the_defined_page_size_under_eop_letters_tab() {
        validateTheDataExceedsTheDefinedPageSizeUnderEOPLettersTab();
    }
    @Then("the user should be able to navigate through pages under EOP letters tab")
    public void the_user_should_be_able_to_navigate_through_pages_under_eop_letters_tab() {
        verifyEopLettersForwardNavigationThroughPages();
        verifyEopLettersBackwardNavigationThroughPages();
    }
    @Then("Page size can be defined by the User as per the given option at the bottom of the grid under EOP letters tab")
    public void page_size_can_be_defined_by_the_user_as_per_the_given_option_at_the_bottom_of_the_grid_under_eop_letters_tab() {
        verifyEopLettersForwardNavigationPageSizeAtTheBottomOfTheGrid();
        verifyEopLettersBackwardNavigationPageSizeAtTheBottomOfTheGrid();
    }
    @Then("the user should be able to see the page numbers as per the number of data divided by page size under EOP letters tab")
    public void the_user_should_be_able_to_see_the_page_numbers_as_per_the_number_of_data_divided_by_page_size_under_eop_letters_tab() {
        verifyEopLettersTotalNumberOfPagesBasedOnThePerPageRecordCount();
    }

    //    Verify user should be able to get results by applying filter on "Batch ID" column under EOP tab
    @When("user enters EOP batch id record under batch id search box")
    public void user_enters_eop_batch_id_record_under_batch_id_search_box() {
        verifyUserEntersEopBatchIdUnderSearchBox();
    }
    @Then("user should be able to view EOP batch id under results section")
    public void user_should_be_able_to_view_eop_batch_id_under_results_section() {
        verifyUserAbleToViewEopBatchIdRecordsUnderSearchResultsSection();
    }

    //    Verify user should be able to get results by applying filter on "Check Number" column under EOP tab
    @When("user enters EOP check number record under check number search box")
    public void user_enters_eop_check_number_record_under_check_number_search_box() {
        verifyUserEntersEopCheckNumberUnderSearchBox();
    }
    @Then("user should be able to view EOP check number under results section")
    public void user_should_be_able_to_view_eop_check_number_under_results_section() {
        verifyUserAbleToViewEopCheckNumberRecordsUnderSearchResultsSection();
    }

    //    Verify user should be able to get results by applying filter on "Provider Name" column under EOP tab
    @When("user enters EOP provider name record under provider name search box")
    public void user_enters_eop_provider_name_record_under_provider_name_search_box() {
        verifyUserEntersEopProviderNameUnderSearchBox();
    }
    @Then("user should be able to view EOP provider name under results section")
    public void user_should_be_able_to_view_eop_provider_name_under_results_section() {
        verifyUserAbleToViewEopProviderNameRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member ID" column under EOP tab
    @When("user enters EOP member id record under member id search box")
    public void user_enters_eop_member_id_record_under_member_id_search_box() {
        verifyUserEntersEopMemberIdUnderSearchBox();
    }
    @Then("user should be able to view EOP member id under results section")
    public void user_should_be_able_to_view_eop_member_id_under_results_section() {
        verifyUserAbleToViewEopMemberIdRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member Name" column under EOP tab
    @When("user enters EOP member name record under member name search box")
    public void user_enters_eop_member_name_record_under_member_name_search_box() {
        verifyUserEntersEopMemberNameUnderSearchBox();
    }
    @Then("user should be able to view EOP member name under results section")
    public void user_should_be_able_to_view_eop_member_name_under_results_section() {
        verifyUserAbleToViewEopMemberNameRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Plan share amount($)" column under EOP tab
    @When("user enters EOP plan share amount under plan share amount search box")
    public void user_enters_eop_plan_share_amount_under_plan_share_amount_search_box() {
        verifyUserEntersEopPlanShareAmountUnderSearchBox();
    }
    @Then("user should be able to view EOP plan share amount under results section")
    public void user_should_be_able_to_view_eop_plan_share_amount_under_results_section() {
        verifyUserAbleToViewEopPlanShareAmountRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "member share amount($)" column under EOP tab
    @When("user enters EOP member share amount under member share amount search box")
    public void user_enters_eop_member_share_amount_under_member_share_amount_search_box() {
        verifyUserEntersEopMemberShareAmountUnderSearchBox();
    }
    @Then("user should be able to view EOP member share amount under results section")
    public void user_should_be_able_to_view_eop_member_share_amount_under_results_section() {
        verifyUserAbleToViewEopMemberShareAmountRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under EOP tab
    @When("user enters EOP created date under date of creation search box")
    public void user_enters_eop_created_date_under_date_of_creation_search_box() {
        verifyUserEntersEopCreatedDateUnderSearchBox();
    }
    @Then("user should be able to view EOP created date under results section")
    public void user_should_be_able_to_view_eop_created_date_under_results_section() {
        verifyUserAbleToViewEopCreatedDateRecordsUnderSearchResultsSection();
    }


}
