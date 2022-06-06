package Automation.StepDefinitions;

import Automation.PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef extends LoginPage {

    @Given("User lands on application home page")
    public void user_lands_on_application_home_page() {

        Application_HomePage_Validation();

    }

    @When("User enters UserName as {string} and Password as {string}")
    public void user_enters_user_name_as_and_password_as(String UName, String pwd) {

        Application_Login_Validation(UName, pwd);

    }

    @Then("User sees successful login details")
    public void user_sees_successful_login_details() {

        Application_SignIn_Validation();
    }

    @Then("Users logs out from application")
    public void users_logs_out_from_application() {

        Application_Logout_Validation();

    }

}
