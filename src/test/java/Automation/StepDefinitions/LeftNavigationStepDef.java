package Automation.StepDefinitions;

import Automation.PageObjects.LeftNavigationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LeftNavigationStepDef extends LeftNavigationPage {

    @When("left navigation loaded")
    public void left_navigation_loaded() {
        leftNavigationValidation();
    }

    //    Scenario:  Validate expanding collapsing action for all menu's in left navigation for admin role
    @Then("user should be able to perform expanding and collapsing actions for all menus")
    public void user_should_be_able_to_perform_expanding_and_collapsing_actions_for_all_menus() {
        validateExpandAndCollapseActionsForAllLeftNavigationMenus();
    }

    //    Scenario: Validate Account Management Menu for admin role
    @Then("user should able to view the AR Ledger Menu under Account Management Menu")
    public void user_should_able_to_view_the_AR_ledger_menu_under_account_management_menu() {
        validateARLedgerMenu();
    }

}
