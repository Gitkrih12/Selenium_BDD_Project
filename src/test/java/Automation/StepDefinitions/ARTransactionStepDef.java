package Automation.StepDefinitions;

import Automation.PageObjects.ARTransactionPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ARTransactionStepDef extends ARTransactionPage {


    //  Scenario: Verify user able to Navigate to the A/R Transaction tab from Global Search
    @When("user clicks on the AR Transaction tab")
    public void user_clicks_on_the_ar_transaction_tab() throws InterruptedException {
        userClicksOnARTransaction();
    }

    @Then("user navigates to the {string} tab")
    public void user_navigates_to_the_tab(String expTab) {
        verifyUserNavigatesToARTransaction(expTab);
    }

    @Then("user able to view the below mentioned fields under AR Transaction tab")
    public void user_able_to_view_the_below_mentioned_fields_under_ar_transaction_tab(DataTable expFields) {
        userViewsArTransactionFields(expFields);
    }

    //  Scenario: Verify Buttons in A/R Transaction tab
    @Then("user views the footer section in AR Transactions page")
    public void user_views_the_footer_section_in_ar_transactions_page(DataTable expFooterFields) {
        userViewsFooterSectionInARTransaction(expFooterFields);
    }
}
