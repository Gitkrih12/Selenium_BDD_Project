package Automation.StepDefinitions;

import Automation.PageObjects.ARLedgerPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ARLedgerStepDef extends ARLedgerPage {

    // Scenario: Verify user able to navigate to A/R Ledger page from the Account Management grid in Left navigation panel
    @When("user clicks on AR Ledger on the left navigation panel")
    public void user_clicks_on_ar_ledger_on_the_left_navigation_panel() throws InterruptedException {
        userClicksARLedger();
    }

    @Then("user able to navigates to the {string} page")
    public void user_able_to_navigates_to_the_page(String expTab) {
        userNavigatesToARLedgerPage(expTab);
    }

    // Scenario: Verify user able to view all the column details in the A/R Ledger page
    @Then("user able to view {string} button")
    public void user_able_to_view_button(String expButton) {
        verifyAddARTransactionButton(expButton);
    }

    @Then("user able to view Search Vendor {string}")
    public void user_able_to_view_search_vendor(String expSearchVendor) {
        verifySearchVendor(expSearchVendor);
    }

    @Then("user able to view the column fields under AR Ledger")
    public void user_able_to_view_the_column_fields_under_ar_ledger(DataTable expColumns) {
        verifyColumnsUnderARLedger(expColumns);
    }

    // Scenario: Verify Search box should display for all the columns on the grid
    @Then("user able to view the Search criteria for all the columns under AR Ledger")
    public void user_able_to_view_the_search_criteria_for_all_the_columns_under_ar_ledger() {
        verifySearchCriteriaForAllColumns();
    }

    // Scenario: Verify when user enters the data in search criteria to display the appropriate results
    @When("user enters the Vendor ID in Search criteria")
    public void user_enters_the_vendor_id_in_search_criteria() throws InterruptedException {
        userEntersVendorIdInSearchCriteria();
    }

    @Then("user able to view the appropriate results")
    public void user_able_to_view_the_appropriate_results() {
        verifyAppropriateResults();
    }

    @When("user enters the Vendor Name in Search criteria")
    public void user_enters_the_vendor_name_in_search_criteria() throws InterruptedException {
        userEntersVendorNameInSearchCriteria();
    }

    @When("user enters the Tax ID in Search criteria")
    public void user_enters_the_tax_id_in_search_criteria() throws InterruptedException {
        userEntersTaxIdInSearchCriteria();
    }

    @When("user enters the Amount in Search criteria")
    public void user_enters_the_amount_in_search_criteria() throws InterruptedException {
        userEntersAmountInSearchCriteria();
    }

    @When("user enters the Created On in Search criteria")
    public void user_enters_the_created_on_in_search_criteria() throws InterruptedException {
        userEntersCreatedOnInSearchCriteria();
    }

    @When("user clicks on Vendor ID in AR Ledger page")
    public void user_clicks_on_vendor_id_in_ar_ledger_page() throws InterruptedException {
        userClicksOnVendorID();
    }
}