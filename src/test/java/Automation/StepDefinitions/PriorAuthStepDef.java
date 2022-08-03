package Automation.StepDefinitions;

import Automation.PageObjects.PriorAuthPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class PriorAuthStepDef extends PriorAuthPage {


    //  Scenario: Verify user navigate to Prior Authorization tab from Global Search
    @When("user clicks on the Prior Authorization tab")
    public void user_clicks_on_the_prior_authorization_tab() throws InterruptedException {
        userClicksPriorAuthorizationTab();
    }

    @Then("user navigated to the {string} tab")
    public void user_navigated_to_the_tab(String expPriorAuthTab) {
        verifyUserNavigatesToPriorAuthTab(expPriorAuthTab);
    }

    //  Scenario: Verify Prior Authorization column fields
    @Then("user should be able to view the below column fields under Prior Authorization tab")
    public void user_should_be_able_to_view_the_below_column_fields_under_prior_authorization_tab(DataTable columnFields) {
        verifyUserViewsColumnFieldsUnderPriorAuth(columnFields);
    }

    //  Scenario: Verify Search box under each column and able to enter search criteria
    @Then("user should be able to view the Search fields under each column")
    public void user_should_be_able_to_view_the_search_fields_under_each_column() {
        verifySearchFieldsUnderEachColumn();
    }

    //  Scenario: Validate footer section in Prior Authorization tab
    @Then("user views the footer section in Prior Authorization page")
    public void user_views_the_footer_section_in_prior_authorization_page(DataTable footerFields) {
        userViewsFooterSectionInPriorAuth(footerFields);
    }
}