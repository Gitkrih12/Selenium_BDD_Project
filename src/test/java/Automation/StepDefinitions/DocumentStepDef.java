package Automation.StepDefinitions;

import Automation.PageObjects.DocumentsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocumentStepDef extends DocumentsPage {

    @When("user clicks on the Documents tab")
    public void user_clicks_on_the_documents_tab() {
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

    @Then("user views the footer section in Documents page")
    public void user_views_the_footer_section_in_documents_page(DataTable footerSection) {
        verifyFooterSectionInDocumentsPage(footerSection);
    }

    @Then("user able to view the below column fields under Attachments sub tab")
    public void user_able_to_view_the_below_column_fields_under_attachments_sub_tab(DataTable columnsUnderAttachments) {
        verifyUserViewsColumnsUnderAttachmentsSection(columnsUnderAttachments);
    }


    @Then("user able to view the below column fields under EDI Files sub tab")
    public void user_able_to_view_the_below_column_fields_under_edi_files_sub_tab(DataTable columnFields) {
        verifyUserViewsColumnsUnderEdiFilesSection(columnFields);
    }
}
