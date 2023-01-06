package Automation.StepDefinitions;

import Automation.PageObjects.EobClaimLevelLettersPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EobClaimLevelLettersStepDef extends EobClaimLevelLettersPage {

    //    Scenario: Verify user navigates to EOB-Claim Level screen
    @When("the user clicks on the EOB Claim Level tab")
    public void the_user_clicks_on_the_eob_claim_level_tab() {
        clickOnEobClaimLevelTab();
    }
    @Then("user should navigate to EOB Claim Level screen")
    public void user_should_navigate_to_eob_claim_level_screen() {
        verifyUserNavigatedToEobClaimLevelScreen();
    }

    //    Scenario: Verify column fields in EOB-Claim Level screen
    @Then("the user should be able to view the following column fields under EOB claim level letters tab")
    public void the_user_should_be_able_to_view_the_following_column_fields_under_eob_claim_level_letters_tab(DataTable eobClaimLevelColumnFields) throws InterruptedException {
        verifyColumnFieldsUnderEobClaimLevelLettersTab(eobClaimLevelColumnFields);
    }

    //    Scenario: Verify column search fields under EOB claim level screen
    @Then("user should be able to view EOB claim level letters column fields search boxes")
    public void user_should_be_able_to_view_eob_claim_level_letters_column_fields_search_boxes() {
        verifyEobClaimLevelLettersColumnsSearchFields();
    }

    //    Scenario: Verify Pagination in EOB-Claim Level screen
    @When("the data exceeds the defined page size under EOB claim level letters tab")
    public void the_data_exceeds_the_defined_page_size_under_eob_claim_level_letters_tab() {
        validateTheDataExceedsTheDefinedPageSizeUnderEobClaimLevelLettersTab();
    }
    @Then("the user should be able to navigate through pages under EOB claim level letters tab")
    public void the_user_should_be_able_to_navigate_through_pages_under_eob_claim_level_letters_tab() {
        verifyEobClaimLevelLettersForwardNavigationThroughPages();
        verifyEobClaimLevelLettersBackwardNavigationThroughPages();
    }
    @Then("Page size can be defined by the User as per the given option at the bottom of the grid under EOB claim level letters tab")
    public void page_size_can_be_defined_by_the_user_as_per_the_given_option_at_the_bottom_of_the_grid_under_eob_claim_level_letters_tab() {
        verifyEobClaimLevelLettersForwardNavigationPageSizeAtTheBottomOfTheGrid();
        verifyEobClaimLevelLettersBackwardNavigationPageSizeAtTheBottomOfTheGrid();
    }
    @Then("the user should be able to see the page numbers as per the number of data divided by page size under EOB claim level letters tab")
    public void the_user_should_be_able_to_see_the_page_numbers_as_per_the_number_of_data_divided_by_page_size_under_eob_claim_level_letters_tab() {
        verifyEobClaimLevelLettersTotalNumberOfPagesBasedOnThePerPageRecordCount();
    }

    //    Scenario: Verify results of Member rows count next to "EOB-Claim Level" tab name
    @Then("user should be able to see the results of rows count next to EOB claim level letters Tab")
    public void user_should_be_able_to_see_the_results_of_rows_count_next_to_eob_claim_level_letters_tab() throws InterruptedException {
        validateRowCountNextToEobClaimLevelLettersTab();
    }

    //    Verify user should be able to get results by applying filter on "Claim Number" column under EOB-Claim level tab
    @When("user enters EOB claim level claim number record under claim number search box")
    public void user_enters_eob_claim_level_claim_number_record_under_claim_number_search_box() {
        verifyUserEntersEobClaimLevelClaimNumberUnderSearchBox();
    }
    @Then("user should be able to view EOB claim level claim number under results section")
    public void user_should_be_able_to_view_eob_claim_level_claim_number_under_results_section() {
        verifyUserAbleToViewEobClaimLevelClaimNumberRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member ID" column under EOB-Claim level tab
    @When("user enters EOB claim level member id record under member id search box")
    public void user_enters_eob_claim_level_member_id_record_under_member_id_search_box() {
        verifyUserEntersEobClaimLevelMemberIdUnderSearchBox();
    }
    @Then("user should be able to view EOB claim level member id under results section")
    public void user_should_be_able_to_view_eob_claim_level_member_id_under_results_section() {
        verifyUserAbleToViewEobClaimLevelMemberIdRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member Name" column under EOB-Claim level tab
    @When("user enters EOB claim level member name record under member name search box")
    public void user_enters_eob_claim_level_member_name_record_under_member_name_search_box() {
        verifyUserEntersEobClaimLevelMemberNameUnderSearchBox();
    }
    @Then("user should be able to view EOB claim level member name under results section")
    public void user_should_be_able_to_view_eob_claim_level_member_name_under_results_section() {
        verifyUserAbleToViewEobClaimLevelMemberNameRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Plan share amount($)" column under EOB-Claim level tab
    @When("user enters EOB claim level plan share amount under plan share amount search box")
    public void user_enters_eob_claim_level_plan_share_amount_under_plan_share_amount_search_box() {
        verifyUserEntersEobClaimLevelPlanShareAmountUnderSearchBox();
    }
    @Then("user should be able to view EOB claim level plan share amount under results section")
    public void user_should_be_able_to_view_eob_claim_level_plan_share_amount_under_results_section() {
        verifyUserAbleToViewEobClaimLevelPlanShareAmountRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "member share amount($)" column under EOB-Claim level tab
    @When("user enters EOB claim level member share amount under member share amount search box")
    public void user_enters_eob_claim_level_member_share_amount_under_member_share_amount_search_box() {
        verifyUserEntersEobClaimLevelMemberShareAmountUnderSearchBox();
    }
    @Then("user should be able to view EOB claim level member share amount under results section")
    public void user_should_be_able_to_view_eob_claim_level_member_share_amount_under_results_section() {
        verifyUserAbleToViewEobClaimLevelMemberShareAmountRecordsUnderSearchResultsSection();
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under EOB-Claim level tab
    @When("user enters EOB claim level created date under date of creation search box")
    public void user_enters_eob_claim_level_created_date_under_date_of_creation_search_box() {
        verifyUserEntersEobClaimLevelCreatedDateUnderSearchBox();
    }
    @Then("user should be able to view EOB claim level created date under results section")
    public void user_should_be_able_to_view_eob_claim_level_created_date_under_results_section() {
        verifyUserAbleToViewEobClaimLevelCreatedDateRecordsUnderSearchResultsSection();
    }


}
