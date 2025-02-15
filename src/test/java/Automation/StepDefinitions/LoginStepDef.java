package Automation.StepDefinitions;

import Automation.PageObjects.LoginPage;
import io.cucumber.java.en.*;

public class LoginStepDef extends LoginPage {


    @Given("enter username")
    public void enter_username() throws InterruptedException {
        enter_app_username();
    }

    @When("enter password")
    public void enter_password() throws InterruptedException {
        enter_app_password();
    }

    @When("click login")
    public void click_login() throws InterruptedException {
        click_login_button();
    }
    @When("click create")
    public void click_create() throws InterruptedException {
        // Write code here that turns the phrase above into concrete actions
        click_create_btn();

    }
    @Then("click user button")
    public void click_user_button() throws InterruptedException {
        click_user_btn();
    }


}
//
//    @When("click administration")
//    public void click_administration() {
//        enter_app_password();
//    }
//
//    @Then("click claims module")
//    public void click_claims_module() throws InterruptedException {
//        click_login_button();
//
//    }
//
//    @When("enter claim number")
//    public void enter_claim_number() throws Exception {
//        // Write code here that turns the phrase above into concrete actions
//        enter_clm_number();
//    }
//    @Then("click search button")
//    public void click_search_button() {
//        // Write code here that turns the phrase above into concrete actions
//        click_claimsearch_button();
//    }

//    }

//    @Given("enter username")
//    public void enter_username() throws InterruptedException {
//        enter_app_username();
//    }
//
//    @Given("enter wrong username")
//    public void enter_wrong_username() throws InterruptedException {
//        enter_app_wrong_username();
//    }
//
//
//    @When("enter password")
//    public void enter_password() throws InterruptedException {
//        enter_app_password();
//    }
//
//    @Then("click login")
//    public void click_login() {
//        click_login_button();
//    }




