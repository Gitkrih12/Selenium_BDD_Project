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

    //    Scenario: Validate Adjudication Menu for admin role
    @Then("user should able to view the Home, Global Search, Claim Reprocess, Claims Assignment Menu under Adjudication Menu")
    public void user_should_able_to_view_the_home_global_search_claim_reprocess_claims_assignment_menu_under_adjudication_menu(DataTable adjList) {
        validateAdjudicationSubMenusForAdmin(adjList);
    }

    //    Scenario: Validate Check Management Menu for admin role
    @Then("user should able to view the Check Refund, Check Void, Check Reissue, Check Register Menu's under Check Management Menu")
    public void user_should_able_to_view_the_check_refund_check_void_check_reissue_check_register_menu_s_under_check_management_menu(DataTable checkManagementList) throws InterruptedException {
        validateCheckManagementSubMenus(checkManagementList);
    }



}
