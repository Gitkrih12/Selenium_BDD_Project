package Automation.StepDefinitions;

import Automation.PageObjects.CAPInstitutionalPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CAPInstitutionalStepDef extends CAPInstitutionalPage {

    //Scenario: Verify when user clicks on CAP Institutional page on the left navigation pane
    @When("user clicks on  CAP Institutional in left navigation menu")
    public void user_clicks_on_cap_institutional_in_left_navigation_menu() {
        clickOnCAPInstitutional();
    }
    @Then("the user should navigate to the  CAP Institutional page")
    public void the_user_should_navigate_to_the_cap_institutional_page() throws InterruptedException {
        verifyCAPInstitutionalPage();
    }

}
