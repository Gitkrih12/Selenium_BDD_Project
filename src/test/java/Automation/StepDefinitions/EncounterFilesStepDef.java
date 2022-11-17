package Automation.StepDefinitions;

import Automation.PageObjects.EncounterFilesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class EncounterFilesStepDef extends EncounterFilesPage {

    //    Scenario:Verify user should navigate to Encounter Files
    @When("user click on Encounter Files in Left Navigation menu")
    public void user_click_on_encounter_files_in_left_navigation_menu() {
        clickOnEncounterFilesMenu();
    }
    @Then("user should navigate to {string} page")
    public void user_should_navigate_to_encounter_files_page(String encounterFilesExp) {
        verifyUserNavigatedToEncounterFilesPage(encounterFilesExp);
    }

    //    Scenario: Verify column fields in Encounter files page
    @Then("the user should be able to view the following column fields under encounter files tab")
    public void the_user_should_be_able_to_view_the_following_column_fields_under_encounter_files_tab(DataTable encounterFilesColumnFields) throws InterruptedException {
        verifyColumnFieldsUnderEncounterFilesTab(encounterFilesColumnFields);
    }

    //    Scenario: Verify Search Box should display below on each column in Encounter files
    @Then("user should able to see Search Box under each column of the encounter files tab")
    public void user_should_able_to_see_search_box_under_each_column_of_the_encounter_files_tab() {
        validateEncounterFilesColumnFieldsSearchBoxes();
    }

    //    Scenario: Verify user should be able to see 'Generated Encounter File' button in Encounter Files Page
    @Then("user should be able to see {string} button")
    public void user_should_be_able_to_see_button(String generateEncounterFileExp) {
        verifyUserShouldBeAbleToViewGenerateEncounterFileButton();
    }

    //    Scenario: Verify user should be able to get results for applying filter on "File Name" column under Encounter files tab
    @When("user enters encounter file name record under file name search box")
    public void user_enters_encounter_file_name_record_under_file_name_search_box() {
        enterFileNameRecordUnderEncounterFileNameSearchBox();
    }
    @Then("user should be able to see encounter file name record under results section")
    public void user_should_be_able_to_see_encounter_file_name_record_under_results_section() {
        verifyUserAbleToViewEncounterFileNameRecordsUnderResultsSection();
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Sender" column under Encounter files tab
    @When("user enters encounter sender name under sender search box")
    public void user_enters_encounter_sender_name_under_sender_search_box() {
        enterSenderNameUnderEncounterSenderSearchBox();
    }
    @Then("user should be able to see encounter sender details under results section")
    public void user_should_be_able_to_see_encounter_sender_details_under_results_section() {
        verifyUserAbleToViewEncounterSenderNameUnderResultsSection();
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Receiver" column under Encounter files tab
    @When("user enters encounter receiver name under receiver search box")
    public void user_enters_encounter_receiver_name_under_receiver_search_box() {
        enterReceiverNameUnderEncounterSenderSearchBox();
    }
    @Then("user should be able to see encounter receiver details under results section")
    public void user_should_be_able_to_see_encounter_receiver_details_under_results_section() {
        verifyUserAbleToViewEncounterReceiverNameUnderResultsSection();
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Date Received" column under Encounter files tab
    @When("user enters encounter received date under date received search box")
    public void user_enters_encounter_received_date_name_under_date_received_search_box() {
        enterReceivedDateUnderEncounterDateReceivedSearchBox();
    }
    @Then("user should be able to see encounter received date details under results section")
    public void user_should_be_able_to_see_encounter_received_date_details_under_results_section() {
        verifyUserAbleToViewEncounterReceivedDateUnderResultsSection();
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Age(Days)" column under Encounter files tab
    @When("user enters encounter age days under age days search box")
    public void user_enters_encounter_age_days_under_age_days_search_box() {
        enterAgeDaysUnderEncounterAgeDaysSearchBox();
    }
    @Then("user should be able to see encounter age days details under results section")
    public void user_should_be_able_to_see_encounter_age_days_details_under_results_section() {
        verifyUserAbleToViewEncounterAgeDaysUnderResultsSection();
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Claim Type" column under Encounter files tab
    @When("user enters encounter claim type under claim type search box")
    public void user_enters_encounter_claim_type_under_claim_type_search_box() {
        enterClaimTypeUnderEncounterClaimTypeSearchBox();
    }
    @Then("user should be able to see encounter claim type details under results section")
    public void user_should_be_able_to_see_encounter_claim_type_details_under_results_section() {
        verifyUserAbleToViewEncounterClaimTypeUnderResultsSection();
    }


}
