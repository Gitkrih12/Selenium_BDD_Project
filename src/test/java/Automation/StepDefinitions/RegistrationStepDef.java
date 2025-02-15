package Automation.StepDefinitions;

import Automation.PageObjects.RegistrationPage;
import Automation.PageObjects.RegistrationPage;
import io.cucumber.java.en.*;

public class RegistrationStepDef extends RegistrationPage {


    @Given("enter first name")
    public void enter_first_name() throws Exception {
        enter_firstname();

    }
    @When("enter lastname")
    public void enter_lastname() throws InterruptedException{
        enter_lastName();
    }
    @When("enter email")
    public void enter_email() throws InterruptedException{
        enter_emailAddress();

    }
    @When("enter title")
    public void enter_title() throws InterruptedException{
        enter_titleName();

    }
    @Then("click save button")
    public void click_save_button() throws InterruptedException {
        click_saveBtn();

    }



}

