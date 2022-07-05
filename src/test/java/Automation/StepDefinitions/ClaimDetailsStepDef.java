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

    //  Scenario: Verify View Claim in CMS 1500 and Self Assign buttons in Claim Summary details page
    @Then("user should view CMS {int} and Self Assign buttons in Claim Summary details page")
    public void user_should_view_cms_and_self_assign_buttons_in_claim_summary_details_page(Integer int1) {
        userViewsSelfAssignAndCMSButtons();
    }

    //  Scenario: Verify column fields in Claim Summary details page
    @Then("user should be able to view all the column fields in Claim Summary Details page")
    public void user_should_be_able_to_view_all_the_column_fields_in_claim_summary_details_page() {
        userViewsAllColumnFieldsInClaimSummaryDetails();
    }

    //  Scenario: Verify Claim Information section
    @Then("user views the Claim Information section")
    public void user_views_the_claim_information_section() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //  Scenario: Verify footer section in Claim Summary details page
    @Then("user views the footer section in Claim Summary details page")
    public void user_views_the_footer_section_in_claim_summary_details_page() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

    //  Scenario: Verify Claim Details sections
    @Then("user view Claim Details sections")
    public void user_view_claim_details_sections() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
}
