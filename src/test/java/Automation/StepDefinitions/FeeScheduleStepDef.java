package Automation.StepDefinitions;

import Automation.PageObjects.FeeSchedulePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeeScheduleStepDef extends FeeSchedulePage {

   //Scenario: Verify user able to view the Fee schedules side drawer when clicking on See Fee Schedule in Pricing screen
   @When("user clicking on Claim Number in Global Search page for Fee Schedule")
   public void user_clicking_on_claim_number_in_global_search_page_for_fee_schedule() throws InterruptedException {
       enterClaimNumberInSearchField();
       clickOnClaimNumber();
   }
    @When("user clicks on service line number")
    public void user_clicks_on_service_line_number() {
        clickOnServiceLine();
    }
    @Then("user should navigates to {string} screen")
    public void user_should_navigates_to_screen(String expText) {
        verifyUserNavigatesPricingAndFeeScheduleScreens(expText);
    }

    @When("user clicks on See Fee Schedule link")
    public void user_clicks_on_see_fee_schedule_link() throws Exception {
        clickOnSeeFeeSchedule();
    }

    //Scenario: Verify user able to view the respective tabs under Fee Schedules side drawer
    @Then("user should be able to see below tabs in Fee Schedules screen")
    public void user_should_be_able_to_see_below_tabs_in_fee_schedules_screen(DataTable tabList) throws InterruptedException {
        verifyTabsInFeeSchedules(tabList);
    }

    //Scenario: Verify user able to view the respective tabs under Fee Schedules side drawer
    @Then("user should be able to see below column fields in Fee Schedules screen")
    public void user_should_be_able_to_see_below_column_fields_in_fee_schedules_screen(DataTable columnList) throws InterruptedException {
        verifyFeeSchedulesColumnFields(columnList);
    }
    @Then("user able to view the field values in Fee Schedules screen")
    public void user_able_to_view_the_field_values_in_fee_schedules_screen() {
        verifyFieldValuesInFeeSchedules();
    }


    //Scenario: Verify user navigates to Payment Policy Indicators tab
    @Then("user navigated to {string} tab successfully")
    public void user_navigated_to_tab_successfully(String expText) {
        verifyUserNavigatesToPaymentPolicyIndicatorsRVUAndGeographicScreens(expText);
    }

    //Scenario: Verify column fields in Payment Policy Indicators tab
    @When("user clicks on Payment Policy Indicators tab")
    public void user_clicks_on_payment_policy_indicators_tab() {
        clickPaymentPolicyIndicators();
    }
    @Then("user should able to see below mentioned fields in Payment Policy Indicators screen")
    public void user_should_able_to_see_below_mentioned_fields_in_payment_policy_indicators_screen(DataTable columnList) throws InterruptedException {
        verifyPaymentPolicyIndicatorsColumnFields(columnList);
    }
    @Then("user able to view the field values in Payment Policy Indicators screen")
    public void user_able_to_view_the_field_values_in_payment_policy_indicators_screen() {
        verifyFieldValuesInPaymentPolicyIndicator();
    }


    //Scenario: Verify user navigates to RVU tab
    @When("user clicks on RVU tab")
    public void user_clicks_on_rvu_tab() {
        clickOnRVU();
    }

    //Scenario: Verify column fields in RVU tab
    @Then("user should able to see below mentioned fields in RVU screen")
    public void user_should_able_to_see_below_mentioned_fields_in_rvu_screen(DataTable columnList) throws InterruptedException {
        verifyRVUColumnFields(columnList);
    }
    @Then("user able to view the field values in RVU screen")
    public void user_able_to_view_the_field_values_in_rvu_screen() {
        verifyFieldValuesInRVU();
    }

    //Scenario: Verify user navigates to Geographic Practice Cost tab
    @When("user clicks on Geographic Practice Cost tab")
    public void user_clicks_on_geographic_practice_cost_tab() {
        clickOnGeographicPracticeCost();
    }

    //Scenario: Verify column fields in Geographic Practice Cost tab
    @Then("user should able to see below mentioned fields in Geographic Practice Cost screen")
    public void user_should_able_to_see_below_mentioned_fields_in_geographic_practice_cost_screen(DataTable columnList) throws InterruptedException {
        verifyGeographicPracticeCostColumnFields(columnList);
    }

    @Then("user able to view the field values in Geographic Practice Cost screen")
    public void user_able_to_view_the_field_values_in_geographic_practice_cost_screen() {
        verifyFieldValuesInGeographicPracticeCost();
    }









}
