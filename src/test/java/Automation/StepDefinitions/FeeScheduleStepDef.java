package Automation.StepDefinitions;

import Automation.PageObjects.FeeSchedulePage;
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


}
