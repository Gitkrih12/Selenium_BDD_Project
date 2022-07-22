package Automation.StepDefinitions;

import Automation.PageObjects.LeftNavigationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LeftNavigationStepDef extends LeftNavigationPage {

    @When("left navigation loaded")
    public void left_navigation_loaded() {
        leftNavigationValidation();
    }

    //    Verify Adjudication section should be in expanded mode by default in left navigation mode for Admin role
    @Then("user can able to see the Adjudication section expandable mode by default")
    public void user_can_able_to_see_the_adjudication_section_expandable_mode_by_default() {
        verifyAdjudicationMenuByDefaultInExpandableMode();
    }

    //    Scenario: Verify Queue Management section should be expanded mode by default in left navigation mode for Admin role
    @Then("user can able to see the Queue Management section expandable mode by default")
    public void user_can_able_to_see_the_queue_management_section_expandable_mode_by_default() {
        verifyQueueManagementMenuByDefaultInExpandableMode();
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

    //    Scenario: Validate expanding collapsing left navigation menu on clicking Menu Toggle for admin role
    @When("user clicks on Menu Toggle in left navigation menu")
    public void user_clicks_on_menu_toggle_in_left_navigation_menu() {
        clickOnClaimsAdjudicationToggleMenu();
    }
    @Then("left navigation menu should be changed to Collapsible mode")
    public void left_navigation_menu_should_be_changed_to_collapsible_mode() {
        verifyCollapsedStatusForClaimsAdjudicationToggleMenu();
    }
    @Then("user clicks on Menu Toggle when left navigation menu in collapsible mode")
    public void user_clicks_on_menu_toggle_when_left_navigation_menu_in_collapsible_mode() {
        clickOnClaimsAdjudicationToggleMenuInCollapsableMode();
    }
    @Then("Left navigation menu should be changed to expandable mode")
    public void left_navigation_menu_should_be_changed_to_expandable_mode() {
        verifyExpandedStatusForClaimsAdjudicationToggleMenu();
    }

    //    Scenario: Validate Fee Schedule Menu for admin role
    @Then("user should able to view the Medicare and Medicaid Menu's under Fee Schedule Menu")
    public void user_should_able_to_view_the_medicare_and_medicaid_menu_s_under_fee_schedule_menu() {
        validateFeeScheduleSubMenus();
    }

    //    Scenario: Validate File Management Menu for admin role
    @Then("user should be able to view the following sub menus under File Management main menu")
    public void user_should_be_able_to_view_the_following_sub_menus_under_file_management_main_menu(DataTable fileManagementList) {
        validateFileManagementSubMenus(fileManagementList);
    }


}
