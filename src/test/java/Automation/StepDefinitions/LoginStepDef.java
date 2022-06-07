package Automation.StepDefinitions;

import Automation.PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends LoginPage {

    @Given("User lands on application home page")
    public void user_lands_on_application_home_page() {

        applicationHomePageValidation();

    }

    @When("User enters UserName as {string} and Password as {string}")
    public void user_enters_user_name_as_and_password_as(String UName, String pwd) {

        applicationLoginValidation(UName, pwd);

    }

    @Then("User sees successful login details")
    public void user_sees_successful_login_details() {

        applicationSignInValidation();
    }

}
