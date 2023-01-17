package Automation.StepDefinitions;

import Automation.PageObjects.DocumentsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocumentStepDef extends DocumentsPage {

    //  Scenario: Verify user should be able to see attached files and EDI files in Documents tab
    @When("user clicks on the Documents tab")
    public void user_clicks_on_the_documents_tab() throws InterruptedException {
        userClicksOnDocumentsTab();
    }

    @Then("user navigates to {string} tab")
    public void user_navigates_to_tab(String expTab) {
        verifyUserNavigatesToDocumentsTab(expTab);
    }

    @Then("user able to view the two sub tabs as {string} and {string}")
    public void user_able_to_view_the_two_sub_tabs_as_and(String expSubTab1, String expSubTab2) {
        verifyUserViewsEDIFilesSubTab(expSubTab1);
        verifyUserViewsAttachmentsSubTab(expSubTab2);
    }

    //  Scenario: Verify user should be able to see footer section buttons
    @Then("user views the footer section in Documents page")
    public void user_views_the_footer_section_in_documents_page(DataTable footerSection) {
        verifyFooterSectionInDocumentsPage(footerSection);
    }

    //  Scenario: Verify column fields in Attachments sub tab
    @When("user clicking on Attachments Claim Number in Global Search page")
    public void user_clicking_on_attachments_claim_number_in_global_search_page() throws InterruptedException {
        clickOnGlobalSearch();
        enterClaimNumberInSearchField();
        clickOnClaimNumber();
    }

    @When("user clicks on Attachments sub tab")
    public void user_clicks_on_attachments_sub_tab() throws InterruptedException {
        userClicksOnAttachmentsSubTab();
    }

    @Then("user able to view the below column fields under Attachments sub tab")
    public void user_able_to_view_the_below_column_fields_under_attachments_sub_tab(DataTable columnsUnderAttachments) {
        verifyUserViewsColumnsUnderAttachmentsSection(columnsUnderAttachments);
    }

    @Then("user able to view the field values under Attachments sub tab")
    public void user_able_to_view_the_field_values_under_attachments_sub_tab() {
        verifyFieldValuesUnderAttachments();
    }

    //  Scenario: Verify column fields in EDI files sub tab
    @Then("user able to view the below column fields under EDI Files sub tab")
    public void user_able_to_view_the_below_column_fields_under_edi_files_sub_tab(DataTable columnFields) {
        verifyUserViewsColumnsUnderEdiFilesSection(columnFields);
    }

    @Then("user able to view the field values under EDI Files sub tab")
    public void user_able_to_view_the_field_values_under_edi_files_sub_tab() {
        verifyFieldValuesUnderEdiFiles();
    }

    @When("user clicks on Upload Document button in Attachments section")
    public void user_clicks_on_upload_document_button_in_attachments_section() {
        userClicksOnUploadDocumentButton();
    }

    @Then("user navigates to the {string} window")
    public void user_navigates_to_the_window(String expWindow) {
        verifyUserNavigatesToUploadDocumentWindow(expWindow);
    }

    @Then("user able to view the below mentioned fields under Upload Document window")
    public void user_able_to_view_the_below_mentioned_fields_under_upload_document_window(DataTable expFields) {
       verifyUploadDocumentFields(expFields);
    }

    @Then("user able to view the below buttons under Upload Document window")
    public void user_able_to_view_the_below_buttons_under_upload_document_window(DataTable expButtons) {
        verifyButtonsUnderUploadDocument(expButtons);
    }

    @When("user enters all the required fields and click on upload button")
    public void user_enters_all_the_required_fields_and_click_on_upload_button() {
        userEntersAllRequiredFields();
        clickOnUploadButton();
    }

    @Then("user able to view the toaster message {string}")
    public void user_able_to_view_the_toaster_message(String expToasterMsg) {

    }

    @Then("user able to display the added document with all the details in the Attachments screen")
    public void user_able_to_display_the_added_document_with_all_the_details_in_the_attachments_screen() {

    }
}