package Automation.StepDefinitions;

import Automation.PageObjects.UploadFilesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.awt.*;

public class UploadFilesStepDef extends UploadFilesPage {

    //    Scenario: Verify user navigates to Upload files section on clicking Upload Files in Left Navigation Menu
    @When("user click on Upload files in left navigation menu")
    public void user_click_on_upload_files_in_left_navigation_menu() {
        clickOnUploadFiles();
    }
    @Given("the user is on the {string} tab")
    public void the_user_is_on_the_upload_files_tab(String uploadFilesTitleExp) {
        verifyUserIsOnUploadFilesTab(uploadFilesTitleExp);
    }
    @Then("user should navigate to Upload files screen successfully and view message {string}")
    public void user_should_navigate_to_upload_files_screen_successfully_and_view_message(String uploadFilesExp) throws InterruptedException {
        verifyUserNavigatedToUploadFilesScreen(uploadFilesExp);
    }

    //    Scenario: Verify user should see Drag Files Here (or) Choose File option and able to upload file
    @Then("the user should be able to choose 837 file or files from the system")
    public void the_user_should_be_able_to_choose_837_file_or_files_from_the_system() throws InterruptedException, AWTException {
        verifyUserAbleToChoose837FilesFromSystem();
    }

    //    Scenario: Verify Total File Selected section
    @Then("the user should be able to choose multiple 837 files from the system")
    public void the_user_should_be_able_to_choose_837_files_from_the_system() throws InterruptedException, AWTException {
        verifyUserAbleToChooseMultiple837FilesFromSystem();
    }
    @Then("the user should be able to see the list of the files in the Total File section")
    public void the_user_should_be_able_to_see_the_list_of_the_files_in_the_total_file_section() {
        validateSelectedFileCountOnFileUploadPage();
    }



    //    Scenario: Verify user should see chosen files/dragged files in the 'Total File Selected' Grid
    @Then("the user should be able to see chosen files or dragged files in the Total File Grid")
    public void the_user_should_be_able_to_see_chosen_files_or_dragged_files_in_the_total_file_grid() throws InterruptedException, AWTException {
        verifyUserAbleToViewSelectedFilesUnderTotalFileSection();
    }
    @Then("the user should be able to enter the Plan Received Date")
    public void the_user_should_be_able_to_enter_the_plan_received_date() throws Exception {
        verifyUserAbleToEnterPlanReceivedDate();
    }
    @Then("the user should be able to click on upload file button to upload files")
    public void the_user_should_be_able_to_click_on_upload_file_button_to_upload_files() {
        clickOnUploadFileButton();
    }

    //    Scenario: Verify Invalid Payer ID File message Identified by system in red color
    @Then("the user should be able to choose invalid 837 file or files from the system")
    public void the_user_should_be_able_to_choose_invalid_837_file_or_files_from_the_system() throws InterruptedException, AWTException {
        verifyUserAbleToChooseInvalid837FilesFromSystem();
    }
    @Then("the user should be able to click on upload file button to upload invalid files")
    public void the_user_should_be_able_to_click_on_upload_file_button_to_upload_invalid_files() {
        clickOnUploadFileButtonToUploadInvalidFiles();
    }
    @Then("user should view invalid payer id error message")
    public void user_should_view_invalid_payer_id_error_message() {
        validateInvalidPayerIdMessage();
    }

    //    Scenario: Verify user able to see Total File, File Name and Plan Received Date fields on upload files page
    @Then("user should be able to see following fields on file upload page")
    public void user_should_be_able_to_see_following_fields_on_file_upload_page(DataTable fileUploadColumnFields) {
        verifyUserAbleToSeeColumnFieldsOnFileUploadPage(fileUploadColumnFields);
    }

    //    Scenario: Verify Plan Received Date field in total File Selected section
    @Then("the user should be able to enter Plan Received date on or before today's date")
    public void the_user_should_be_able_to_enter_plan_received_date_on_or_before_today_s_date() throws Exception {
        verifyUserAbleToEnterCurrentPlanReceivedDate();
        verifyUserAbleToEnterPastPlanReceivedDate();
    }

    //    Scenario: verify user able to delete the selected file on file upload page
    @Then("user should be able to delete the selected file from the file upload page")
    public void user_should_be_able_to_delete_the_selected_file_from_the_file_upload_page() {
        verifyUserAbleToDeleteSelectedFileOnUploadFilesPage();
    }

    //    Scenario: verify user able to cancel the selected files on file upload page
    @Then("user should be able to cancel all the selected files on files upload page")
    public void user_should_be_able_to_cancel_all_the_selected_files_on_files_upload_page() {
        verifyUserAbleToCancelSelectedFilesOnUploadFilesPage();
    }

    //    Scenario: verify user should NOT be able to upload any file with future date
    @Then("the user enters future plan received date on file upload page")
    public void the_user_enters_future_plan_received_date_on_file_upload_page() throws Exception {
        enterFuturePlanReceivedDateOnFileUploadPage();
    }
    @Then("user should be able to view {string} error message")
    public void user_should_be_able_to_view_error_message(String futurePlanReceivedDateExp) {
        verifyUserShouldNotBeAbleToUploadFilesWithFuturePlanReceivedDate(futurePlanReceivedDateExp);
    }

}
