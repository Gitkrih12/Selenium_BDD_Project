package Automation.StepDefinitions;

import Automation.PageObjects.ServiceDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ServiceDetailsStepDef extends ServiceDetailsPage {

    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    @When("user clicking on Claim Number {string} in Global Search page")
    public void user_clicking_on_claim_number_in_global_search_page(String claimNumber) throws InterruptedException {
        clickOnGlobalSearch();
        enterClaimNumberInSearchfield(claimNumber);
        clickOnClaimNumber();
    }

    @When("user clicks on Service Details tab")
    public void user_clicks_on_service_details_tab() throws InterruptedException {
        clickOnServiceDetails();
    }

    @Then("user should view all the column fields in Service Details page")
    public void user_should_view_all_the_column_fields_in_service_details_page(DataTable columnList) {
        userViewsAllColumnFieldsInServiceDetails(columnList);
    }

    //  Scenario: Verify Service Lines fields
    @Then("user able to view the below Service Line Fields")
    public void user_able_to_view_the_below_service_line_fields(DataTable serviceLineFields) {
        userViewsServiceLineFields(serviceLineFields);
    }

    //  Scenario: Verify footer section available in Service details tab
    @Then("user views the footer section in Service Details page")
    public void user_views_the_footer_section_in_service_details_page(DataTable footerFields) {
        userViewsFooterSectionInServiceDetails(footerFields);
    }

    //  Scenario: Verify user able to navigate to Pricing page upon clicking Line number
    @When("user clicking on Line number")
    public void user_clicking_on_line_number() {
        clickOnLineNumber();
    }

    @Then("user able to navigate to the Pricing page")
    public void user_able_to_navigate_to_the_pricing_page() {
        userNavigatesToPricingPage();
    }
}