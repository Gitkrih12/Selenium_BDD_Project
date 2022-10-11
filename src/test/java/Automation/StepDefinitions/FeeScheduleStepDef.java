package Automation.StepDefinitions;

import Automation.PageObjects.FeeSchedulePage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FeeScheduleStepDef extends FeeSchedulePage {

   //Scenario: Verify user able to view the Fee schedules side drawer when clicking on See Fee Schedule in Pricing screen
   @When("user clicking on Claim Number in Global Search page for Fee Schedule")
   public void user_clicking_on_claim_number_in_global_search_page_for_fee_schedule() throws InterruptedException {
       clickOnGlobalSearch();
       enterClaimNumberInSearchField();
       clickOnClaimNumber();
   }
    @When("user clicks on service line number")
    public void user_clicks_on_service_line_number() {
        clickOnServiceLine();
    }
    @Then("user should navigates to {string} screen")
    public void user_should_navigates_to_screen(String expText) {
       if(expText.contains("Pricing")){
           verifyPricingScreen(expText);
       }else if(expText.contains("Fee Schedules")){
           verifyFeeSchedules(expText);
       }
    }

    @When("user clicks on See Fee Schedule link")
    public void user_clicks_on_see_fee_schedule_link() {
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

    //Scenario: Verify column fields in Payment Policy Indicators tab
    @When("user clicks on Payment Policy Indicators tab")
    public void user_clicks_on_payment_policy_indicators_tab() {
        clickPaymentPolicyIndicators();
    }
    @Then("user should able to see below mentioned fields")
    public void user_should_able_to_see_below_mentioned_fields(io.cucumber.datatable.DataTable dataTable) {

    }




}
