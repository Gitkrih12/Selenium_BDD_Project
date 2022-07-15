package Automation.StepDefinitions;

import Automation.PageObjects.ProviderDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ProviderDetailsStepDef extends ProviderDetailsPage {

    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    @When("user clicks on the Provider Details tab")
    public void user_clicks_on_the_provider_details_tab() {
        clickOnProviderDetails();
    }

    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    @Then("user navigates to the Provider Details tab")
    public void user_navigates_to_the_provider_details_tab() {
        userNavigatedToProvideDetails();
    }

    //  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    @Then("user able to view the below sections under Provider Details tab")
    public void user_able_to_view_the_below_sections_under_provider_details_tab(DataTable providerDetailsSection) {
        userShouldViewProviderDetailsSection(providerDetailsSection);
    }

    //  Scenario: Verify user able to view all the fields under Pay to Provider Details section
    @Then("user able to view all the fields under Pay to Provider Details section")
    public void user_able_to_view_all_the_fields_under_pay_to_provider_details_section(DataTable fieldsUnderPayToProviderDetails){
        userViewsFieldsUnderPayToProviderDetailsSection(fieldsUnderPayToProviderDetails);
    }

    //  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    @Then("user able to view all the fields under Group Rendering Provider Details section")
    public void user_able_to_view_all_the_fields_under_group_rendering_provider_details_section(DataTable fieldsUnderGroupRendering) {
        userViewsFieldsUnderGroupRenderingProviderDetailsSection(fieldsUnderGroupRendering);
    }

    //  Scenario: Validate all the buttons available at the footer section under Provider Details tab
    @Then("user views the footer section in Provider Details page")
    public void user_views_the_footer_section_in_provider_details_page(DataTable footerSection) {
        userViewsFooterSectionInServiceDetails(footerSection);
    }

    @When("clicking on Vendor ID in Provider Details")
    public void clicking_on_vendor_id_in_provider_details() {
        clickOnVendorId();
    }

    @Then("user navigates to the AR Transactions page")
    public void user_navigates_to_the_a_r_transactions_page() {
        userNavigatesToARTransactionsPage();
    }

    @Then("user able to view Credit Overpaid and Debit Underpaid status")
    public void user_able_to_view_credit_overpaid_and_debit_underpaid_status() {
        userViewsCreditOverPaidAndDebitUnderPaidStatus();
    }
}