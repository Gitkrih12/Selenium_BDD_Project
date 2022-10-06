package Automation.StepDefinitions;

import Automation.PageObjects.ProviderDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;

public class ProviderDetailsStepDef extends ProviderDetailsPage {

    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    @When("user clicks on the Provider Details tab")
    public void user_clicks_on_the_provider_details_tab() throws InterruptedException {
        clickOnProviderDetails();
    }

    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    @Then("user navigates to the Provider Details tab")
    public void user_navigates_to_the_provider_details_tab() {
        userNavigatedToProviderDetails();
    }

    //  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    @Then("user able to view the below sections under Provider Details tab")
    public void user_able_to_view_the_below_sections_under_provider_details_tab(DataTable providerDetailsSection) {
        userShouldViewProviderDetailsSection(providerDetailsSection);
    }

    //  Scenario: Verify user able to view all the fields under Pay to Provider Details section
    @Then("user able to view all the fields under Pay to Provider Details section")
    public void user_able_to_view_all_the_fields_under_pay_to_provider_details_section(DataTable fieldsUnderPayToProviderDetails) {
        userViewsFieldsUnderPayToProviderDetailsSection(fieldsUnderPayToProviderDetails);
    }

    @Then("user able to view all the field values under Pay to Provider Details section")
    public void user_able_to_view_all_the_field_values_under_pay_to_provider_details_section() throws InterruptedException {
        userViewsFieldValuesUnderPayToProviderDetails();
    }

    //  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    @Then("user able to view all the fields under Group Rendering Provider Details section")
    public void user_able_to_view_all_the_fields_under_group_rendering_provider_details_section(DataTable fieldsUnderGroupRendering) {
        userViewsFieldsUnderGroupRenderingProviderDetailsSection(fieldsUnderGroupRendering);
    }

    @Then("user able view all the field values under Group Rendering Provider Details section")
    public void user_able_view_all_the_field_values_under_group_rendering_provider_details_section() throws InterruptedException {
        userViewsFieldValuesUnderGroupRenderingProviderDetails();
    }

    //  Scenario: Validate all the buttons available at the footer section under Provider Details tab
    @Then("user views the footer section in Provider Details page")
    public void user_views_the_footer_section_in_provider_details_page(DataTable footerSection) {
        userViewsFooterSectionInServiceDetails(footerSection);
    }

    //  Scenario: Verify the user able to navigate to the A/R Transactions page on clicking Vendor ID in Provider details tab view
    @When("clicking on Vendor ID in Provider Details")
    public void clicking_on_vendor_id_in_provider_details() throws InterruptedException {
        clickOnVendorId();
    }

    @Then("user navigates to the AR Transactions page")
    public void user_navigates_to_the_ar_transactions_page() {
        userNavigatesToARTransactionsPage();
    }

    //  Scenario: Verify user able to view the Credit/Overpaid and Debit/Underpaid status at the middle of the A/R Ledger
    @Then("user able to view Credit Overpaid and Debit Underpaid status as {string} {string}")
    public void user_able_to_view_credit_overpaid_and_debit_underpaid_status_as(String expCreditStatus, String expDebitStatus) {
        userViewsCreditOverPaidStatus(expCreditStatus);
        userViewsDebitUnderPaidStatus(expDebitStatus);
    }

    //  Scenario: Verify user able to view the available Account Review Transactions and all the columns in the A/R transaction details page
    @Then("user able to view all the below mentioned columns in Account Review Transactions page")
    public void user_able_to_view_all_the_below_mentioned_columns_in_account_review_transactions_page(DataTable arTransactionFields) {
        userViewsAccountReviewTransactionColumns(arTransactionFields);
    }

    //  Scenario: Verify Search box should display for all the columns on the A/R Transactions grid
    @Then("user able to view the search box for all the column on AR Transactions grid")
    public void user_able_to_view_the_search_box_for_all_the_column_on_ar_transactions_grid() {
        verifySearchFieldsUnderEachColumn();
    }

    @When("user clicks on Hold claim number in FFS Institutional page")
    public void user_clicks_on_hold_claim_number_in_ffs_institutional_page() {
        userClicksOnHoldClaimNumber();
    }

    @Then("user able to view Map Pay To Provider button")
    public void user_able_to_view_map_pay_to_provider_button() {
        verifyMapPayToProviderButton();
    }

    @When("user clicks on Map Pay To Provider button")
    public void user_clicks_on_map_pay_to_provider_button() {
        userClicksOnMapPayToProviderButton();
    }

    @Then("user navigates to the Map Pay To Provider side drawer")
    public void user_navigates_to_the_map_pay_to_provider_side_drawer() {
        verifyUserNavigatesToMapPayToProvider();
    }

    @Then("user able to view the below headers under Map Pay To Provider side drawer")
    public void user_able_to_view_the_below_headers_under_map_pay_to_provider_side_drawer(DataTable expHeaders) {
        verifyHeadersUnderMapPayToProvider(expHeaders);
    }

    @Then("user able to view the below fields under Map Pay To Provider")
    public void user_able_to_view_the_below_fields_under_map_pay_to_provider(DataTable expFields) {
        verifyFieldsUnderMapPayToProvider(expFields);
    }

    @When("user clicks on Hold Muliple Vendor claim number in FFS Institutional page")
    public void user_clicks_on_hold_muliple_vendor_claim_number_in_ffs_institutional_page() {
        userClicksOnHoldMultipleVendorClaim();
    }

    @When("user views the multiple Vendors for the claim")
    public void user_views_the_multiple_vendors_for_the_claim() {
        userHasMultipleVendors();
    }

    @Then("user able to view the select button for all the Vendor ID except for the default Vendor ID")
    public void user_able_to_view_the_select_button_for_all_the_vendor_id_except_for_the_default_vendor_id() {
        userViewsSelectButton();
    }

    @Then("green bar should display for the default Vendor ID")
    public void green_bar_should_display_for_the_default_vendor_id() {
        verifyGreenBar();
    }

    @When("user clicks on Select button for the other Vendor ID")
    public void user_clicks_on_select_button_for_the_other_vendor_id() {
        userClicksOnSelectButtonForOtherVendorID();
    }

    @Then("user able to view the Vendor ID by default after selected")
    public void user_able_to_view_the_vendor_id_by_default_after_selected() {
        verifyVendorShouldBeDefaultAfterSelected();
    }

    @Then("user able to view the cancel, close buttons at the bottom and top of the side drawer")
    public void user_able_to_view_the_cancel_close_buttons_at_the_bottom_and_top_of_the_side_drawer() {
        verifyCancelCloseButtons();
    }

    @Then("user able to view the Pagination buttons")
    public void user_able_to_view_the_pagination_buttons() {
        verifyPaginationButtons();
    }

    @When("user clicks on Close button")
    public void user_clicks_on_close_button() {
        userClicksOnCloseButton();
    }

    @Then("user navigates back to the Provider details")
    public void user_navigates_back_to_the_provider_details() {
        verifyUserNavigatesToMapPayToProvider();
    }

    @When("user clicks on Cancel button")
    public void user_clicks_on_cancel_button() {
       userClicksOnCancelButton();
    }
}