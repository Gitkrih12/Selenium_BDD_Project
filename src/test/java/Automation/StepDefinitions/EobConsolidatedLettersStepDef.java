package Automation.StepDefinitions;

import Automation.PageObjects.EobConsolidatedLettersPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EobConsolidatedLettersStepDef extends EobConsolidatedLettersPage {

    //    Scenario: Verify user navigates to EOB Consolidated screen
    @Given("the user is on {string} page")
    public void the_user_is_on_page(String lettersExp) {
        clickOnLettersMenu(lettersExp);
    }
    @When("the user clicks on EOB Consolidated tab")
    public void the_user_clicks_on_EOB_Consolidated_tab() {
        clickOnEobConsolidatedTab();
    }
    @Then("user should be able to view the EOB Consolidated screen")
    public void user_should_be_able_to_view_the_eob_consolidated_screen() {
        verifyUserNavigatedToEobConsolidatedScreen();
    }

    //    Scenario: Verify column fields in EOB Consolidated letters page
    @Then("the user should be able to view the following column fields under EOB consolidated letters tab")
    public void the_user_should_be_able_to_view_the_following_column_fields_under_EOB_consolidated_letters_tab(DataTable eobConsolidatedLetters) throws InterruptedException {
        verifyColumnFieldsUnderEobConsolidatedLettersTab(eobConsolidatedLetters);
    }
    @Then("user should be able to view EOB consolidated letters column fields search boxes")
    public void user_should_be_able_to_view_eob_consolidated_letters_column_fields_search_boxes() {
        verifyEobConsolidatedLettersColumnsSearchFields();
    }

    //    Scenario: Verify Pagination in EOB Consolidated screen
    @When("the data exceeds the defined page size under EOB consolidated letters tab")
    public void the_data_exceeds_the_defined_page_size_under_eob_consolidated_letters_tab() {
        validateTheDataExceedsTheDefinedPageSizeUnderEobConsolidatedLettersTab();
    }
    @Then("the user should be able to navigate through pages under EOB consolidated letters tab")
    public void the_user_should_be_able_to_navigate_through_pages_under_eob_consolidated_letters_tab() {
        verifyEobConsolidatedLettersForwardNavigationThroughPages();
        verifyEobConsolidatedLettersBackwardNavigationThroughPages();
    }
    @Then("Page size can be defined by the User as per the given option at the bottom of the grid under EOB consolidated letters tab")
    public void page_size_can_be_defined_by_the_user_as_per_the_given_option_at_the_bottom_of_the_grid_under_eob_consolidated_letters_tab() {
        verifyEobConsolidatedLettersForwardNavigationPageSizeAtTheBottomOfTheGrid();
        verifyEobConsolidatedLettersBackwardNavigationPageSizeAtTheBottomOfTheGrid();
    }
    @Then("the user should be able to see the page numbers as per the number of data divided by page size under EOB consolidated letters tab")
    public void the_user_should_be_able_to_see_the_page_numbers_as_per_the_number_of_data_divided_by_page_size_under_eob_consolidated_letters_tab() {
        verifyEobConsolidatedLettersTotalNumberOfPagesBasedOnThePerPageRecordCount();
    }

    //    Scenario: Verify results of Member rows count next to "EOB-Consolidated letters" tab name
    @Then("user should be able to see the results of rows count next to EOB consolidated letters Tab")
    public void user_should_be_able_to_see_the_results_of_rows_count_next_to_eob_consolidated_letters_tab() throws InterruptedException {
        validateRowCountNextToEobConsolidatedLettersTab();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member ID" column under EOB-Consolidated tab
    @When("user enters EOB consolidated member id record under member id search box")
    public void user_enters_eob_consolidated_member_id_record_under_member_id_search_box() {
        verifyUserEntersEobConsolidatedMemberIdUnderSearchBox();
    }
    @Then("user should be able to view EOB consolidated member id under results section")
    public void user_should_be_able_to_view_eob_consolidated_member_id_under_results_section() {
        verifyUserAbleToViewEobConsolidatedMemberIdRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member Name" column under EOB-Consolidated tab
    @When("user enters EOB consolidated member name record under member name search box")
    public void user_enters_eob_consolidated_member_name_record_under_member_name_search_box() {
        verifyUserEntersEobConsolidatedMemberNameUnderSearchBox();
    }
    @Then("user should be able to view EOB consolidated member name under results section")
    public void user_should_be_able_to_view_eob_consolidated_member_name_under_results_section() {
        verifyUserAbleToViewEobConsolidatedMemberNameRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Plan share amount($)" column under EOB-Consolidated tab
    @When("user enters EOB consolidated plan share amount under plan share amount search box")
    public void user_enters_eob_consolidated_plan_share_amount_under_plan_share_amount_search_box() {
        verifyUserEntersEobConsolidatedPlanShareAmountUnderSearchBox();
    }
    @Then("user should be able to view EOB consolidated plan share amount under results section")
    public void user_should_be_able_to_view_eob_consolidated_plan_share_amount_under_results_section() {
        verifyUserAbleToViewEobConsolidatedPlanShareAmountRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "member share amount($)" column under EOB-Consolidated tab
    @When("user enters EOB consolidated member share amount under member share amount search box")
    public void user_enters_eob_consolidated_member_share_amount_under_member_share_amount_search_box() {
        verifyUserEntersEobConsolidatedMemberShareAmountUnderSearchBox();
    }
    @Then("user should be able to view EOB consolidated member share amount under results section")
    public void user_should_be_able_to_view_eob_consolidated_member_share_amount_under_results_section() {
        verifyUserAbleToViewEobConsolidatedMemberShareAmountRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under EOB-Consolidated tab
    @When("user enters EOB consolidated created date under date of creation search box")
    public void user_enters_eob_consolidated_created_date_under_date_of_creation_search_box() {
        verifyUserEntersEobConsolidatedCreatedDateUnderSearchBox();
    }
    @Then("user should be able to view EOB consolidated created date under results section")
    public void user_should_be_able_to_view_eob_consolidated_created_date_under_results_section() {
        verifyUserAbleToViewEobConsolidatedCreatedDateRecordsUnderSearchResultsSection();
    }



}
