package Automation.StepDefinitions;

import Automation.PageObjects.ClaimDetailsPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClaimDetailsStepDef extends ClaimDetailsPage {

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    @Given("the user is in FFS Professional page")
    public void the_user_is_in_ffs_professional_page() {
        accessFFSProfessionalPage();
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    @When("user clicks on the Claim Number")
    public void user_clicks_on_the_claim_number() {
        userClicksOnClaimNumber();
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    @Then("user navigates to the Claim Summary page")
    public void user_navigates_to_the_claim_summary_page() {
        userNavigatesToClaimSummaryPage();
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    @Then("user should view hide option besides Claim Summary")
    public void user_should_view_hide_option_besides_claim_summary() {
        userViewsHideOptionBesideClaimSummary();
    }
}
