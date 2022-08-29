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
    @When("user clicks on Attachments sub tab")
    public void user_clicks_on_attachments_sub_tab() throws InterruptedException {
        userClicksOnAttachmentsSubTab();
    }

    @Then("user able to view the below column fields under Attachments sub tab")
    public void user_able_to_view_the_below_column_fields_under_attachments_sub_tab(DataTable columnsUnderAttachments) {
        verifyUserViewsColumnsUnderAttachmentsSection(columnsUnderAttachments);
    }

    @Then("user able to view the field values under Attachments sub tab")
    public void user_able_to_view_the_field_values_under_attachments_sub_tab() throws InterruptedException {
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

    @When("user sorts File Name column to ascending on EDI Files table")
    public void user_sorts_file_name_column_to_ascending_on_edi_files_table() {
        setSortOrder("File Name", true);
    }

    @Then("File Name column data should display ascending order on EDI Files table")
    public void file_name_column_data_should_display_ascending_order_on_edi_files_table() throws InterruptedException {
        verifySortOrder("File Name", true);
    }

    @When("user sorts File Name column to descending on EDI Files table")
    public void user_sorts_file_name_column_to_descending_on_edi_files_table() {
        setSortOrder("File Name", false);
    }

    @Then("File Name column data should display descending order on EDI Files table")
    public void file_name_column_data_should_display_descending_order_on_edi_files_table() throws InterruptedException {
        verifySortOrder("File Name", false);
    }

    @When("user sorts File Type column to ascending on EDI Files table")
    public void user_sorts_file_type_column_to_ascending_on_edi_files_table() {
        setSortOrder("File Type", true);
    }

    @Then("File Type column data should display ascending order on EDI Files table")
    public void file_type_column_data_should_display_ascending_order_on_edi_files_table() throws InterruptedException {
        verifySortOrder("File Type", true);
    }

    @When("user sorts File Type column to descending on EDI Files table")
    public void user_sorts_file_type_column_to_descending_on_edi_files_table() {
        setSortOrder("File Type", false);
    }

    @Then("File Type column data should display descending order on EDI Files table")
    public void file_type_column_data_should_display_descending_order_on_edi_files_table() throws InterruptedException {
        verifySortOrder("File Type", false);
    }

    @When("user sorts Uploaded By column to ascending on EDI Files table")
    public void user_sorts_uploaded_by_column_to_ascending_on_edi_files_table() {
        setSortOrder("Uploaded By", true);
    }

    @Then("Uploaded By column data should display ascending order on EDI Files table")
    public void uploaded_by_column_data_should_display_ascending_order_on_edi_files_table() throws InterruptedException {
        verifySortOrder("Uploaded By", true);
    }

    @When("user sorts Uploaded By column to descending on EDI Files table")
    public void user_sorts_uploaded_by_column_to_descending_on_edi_files_table() {
        setSortOrder("Uploaded By", false);
    }

    @Then("Uploaded By column data should display descending order on EDI Files table")
    public void uploaded_by_column_data_should_display_descending_order_on_edi_files_table() throws InterruptedException {
        verifySortOrder("Uploaded By", false);
    }

    @When("user sorts Uploaded On column to ascending on EDI Files table")
    public void user_sorts_uploaded_on_column_to_ascending_on_edi_files_table() {
        setSortOrder("Uploaded On", true);
    }

    @Then("Uploaded On column data should display ascending order on EDI Files table")
    public void uploaded_on_column_data_should_display_ascending_order_on_edi_files_table() throws InterruptedException {
        verifySortOrder("Uploaded On", true);
    }

    @When("user sorts Uploaded On column to descending on EDI Files table")
    public void user_sorts_uploaded_on_column_to_descending_on_edi_files_table() {
        setSortOrder("Uploaded On", false);
    }

    @Then("Uploaded On column data should display descending order on EDI Files table")
    public void uploaded_on_column_data_should_display_descending_order_on_edi_files_table() throws InterruptedException {
        verifySortOrder("Uploaded On", false);
    }
}