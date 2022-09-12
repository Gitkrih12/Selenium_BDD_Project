package Automation.StepDefinitions;

import Automation.PageObjects.MOOPLedgerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MOOPLedgerStepDef extends MOOPLedgerPage {

    @When("user clicks on MOOP Ledger under Member Management")
    public void user_clicks_on_moop_ledger_under_member_management() throws InterruptedException {
        userClicksMemberManagement();
        userClickOnMoopLedger();
    }

    @Then("user navigates to the {string} page successfully")
    public void user_navigates_to_the_page_successfully(String expTab) {
        userNavigatesToMoopLedgerPage(expTab);
    }

    @Then("user able to view the below mentioned column fields under MOOP Ledger")
    public void user_able_to_view_the_below_mentioned_column_fields_under_moop_ledger(DataTable expFields) {
        verifyFieldsUnderMoopLedger(expFields);
    }

    @Then("user able to view the Search criteria in Moop Ledger")
    public void user_able_to_view_the_search_criteria_in_moop_ledger() {
        verifySearchCriteriaInMoopLedgerPage();
    }

    @When("user clicks on Member ID")
    public void user_clicks_on_member_id() throws InterruptedException {
        userClicksOnMemberId();
    }

    @Then("user navigates to the Moop Transaction tabs")
    public void user_navigates_to_the_moop_transaction_tabs() {
        userNavigatesToMoopTransactionScreen();
        userNavigatesToMoopAccumulatorSummary();
    }

    @Then("user able to view the below mentioned fields under Moop Transaction page")
    public void user_able_to_view_the_below_mentioned_fields_under_moop_transaction_page(DataTable expFields) {
        verifyFieldsUnderMoopTransaction(expFields);
    }

    @Then("user able view the field values under Moop Transaction page")
    public void user_able_view_the_field_values_under_moop_transaction_page() {
        verifyFieldValuesUnderMoopTransaction();
    }

    @Then("user able to view the Search criteria under Moop Transaction page")
    public void user_able_to_view_the_search_criteria_under_moop_transaction_page() {
        verifySearchCriteriaInMoopTransaction();
    }
}
