package Automation.StepDefinitions;

import Automation.PageObjects.LeftNavigationPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;

public class LeftNavigationStepDef extends LeftNavigationPage {

    @When("left navigation loaded")
    public void left_navigation_loaded() {
        leftNavigationValidation();
    }

    //    Verify Adjudication section should be in expanded mode by default in left navigation pane for both admin and non admin roles
    @Then("user can able to see the Adjudication section expandable mode by default")
    public void user_can_able_to_see_the_adjudication_section_expandable_mode_by_default() {
        verifyAdjudicationMenuByDefaultInExpandableMode();
    }

    //    Scenario: Verify Queue Management section should be expanded mode by default in left navigation pane for admin and non admin roles
    @Then("user can able to see the Queue Management section expandable mode by default")
    public void user_can_able_to_see_the_queue_management_section_expandable_mode_by_default() {
        verifyQueueManagementMenuByDefaultInExpandableMode();
    }


    //    Scenario:  Validate expanding collapsing action for all menu's in left navigation for admin and non admin roles
    @Then("user should be able to perform expanding and collapsing actions for all menus")
    public void user_should_be_able_to_perform_expanding_and_collapsing_actions_for_all_menus() throws InterruptedException {
        validateExpandActionsForAllLeftNavigationMenus();
        validateCollapseActionsForAllLeftNavigationMenus();
    }

    //    Scenario: Validate Account Management Menu for admin and non admin roles
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
        validateCheckManagementSubMenusForAdminRole(checkManagementList);
    }

    //    Scenario: Validate expanding collapsing left navigation menu on clicking Menu Toggle for admin and non admin roles
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

    //    Scenario: Validate Fee Schedule Menu for admin and non admin roles
    @Then("user should able to view the Medicare and Medicaid Menu's under Fee Schedule Menu")
    public void user_should_able_to_view_the_medicare_and_medicaid_menu_s_under_fee_schedule_menu() {
        validateFeeScheduleSubMenus();
    }

    //    Scenario: Validate File Management Menu for admin and non admin roles
    @Then("user should be able to view the following sub menus under File Management main menu")
    public void user_should_be_able_to_view_the_following_sub_menus_under_file_management_main_menu(DataTable fileManagementList) {
        validateFileManagementSubMenus(fileManagementList);
    }

    //    Scenario: Validate Member Management Menu for admin role
    @Then("user should be able to view the following sub menus under Member Management main Menu")
    public void user_should_be_able_to_view_the_following_sub_menus_under_member_management_main_menu(DataTable memberManagementList) {
        validateMemberManagementSubMenusForAdminRole(memberManagementList);
    }

    //    Scenario: Validate Queue Management Menu for admin and non admin roles
    @Then("user should be able to view the following sub menus under Queue Management main menu")
    public void user_should_be_able_to_view_the_following_sub_menus_under_queue_management_main_menu(DataTable queueManagementList) {
        validateQueueManagementSubMenus(queueManagementList);
    }

    //    Scenario: Validate Reports Menu for admin role
    @Then("user should able to view the SSRS Reports Menu under Reports Menu")
    public void user_should_able_to_view_the_ssrs_reports_menu_under_reports_menu() {
        validateReportsSubMenu();
    }

    //    Scenario: Validate Settings Menu for admin and non admin roles
    @Then("user should able to view the Plain Language and Instructions Menus under Settings Menu")
    public void user_should_able_to_view_the_plain_language_and_instructions_menus_under_settings_menu() {
        validateSettingsSubMenus();
    }

    //    Validate User Management Menu for admin role
    @Then("user should be able to view the Manage Users, Manage Role menus under User Management Menu")
    public void user_should_be_able_to_view_the_manage_users_manage_role_menus_under_user_management_menu() {
        validateUserManagementSubMenus();
    }

    //    Scenario: Verify admin should land on Home/Dashboard page
    @Then("user should land on Home and Dashboard page")
    public void user_should_land_on_home_and_dashboard_page() {
        verifyUserIsOnAdminHomePageByDefault();
    }

    //    Scenario: Verify left navigation loaded for admin role
    @Then("user should be able to view the left navigation for his role")
    public void user_should_be_able_to_view_the_left_navigation_for_his_role() {
        verifyLeftNavigation();
    }

    //    Scenario: Verify left navigation menu for admin role
    @Then("user should be able to view the {string} Label, Menu toggle on the top view")
    public void user_should_be_able_to_view_the_claims_adjudication_label_menu_toggle_on_the_top_view(String lblClaimsAdjExp) {
        verifyClaimsAdjudicationLabelAndMenuToggleOnLeftNavigation(lblClaimsAdjExp);
    }
    @Then("user should be able to view the following menu items under left navigation panel")
    public void user_should_be_able_to_view_the_following_menu_items_under_left_navigation_panel(DataTable leftNavMainMenusList) {
        verifyMainMenuItemsFromLeftNavigationForAdmin(leftNavMainMenusList);
    }

    // Scenario: Validate Adjudication Menu for adjudicator role
    @Then("user should be able to view the Global Search Menu under Adjudication Menu")
    public void user_should_be_able_to_view_the_global_search_menu_under_adjudication_menu() {
        verifyAdjudicationMenuForNonAdminRole();
    }

    //    Scenario: Validate Check Management Menu for adjudicator role
    @Then("user should be able to view the following sub menus under Check Management main Menu for non admin role")
    public void user_should_be_able_to_view_the_following_sub_menus_under_check_management_main_menu_for_non_admin_role(DataTable checkManagementList) {
        validateCheckManagementSubMenusForNonAdminRole(checkManagementList);
    }

    //    Scenario: Validate Member Management Menu for adjudicator role
    @Then("user should be able to view the following sub menus under Member Management main Menu for non admin role")
    public void user_should_be_able_to_view_the_following_sub_menus_under_member_management_main_menu_for_non_admin_role(DataTable memberManagementList) {
        validateMemberManagementSubMenusForNonAdminRole(memberManagementList);
    }

    //    Scenario: Verify left navigation menu for adjudicator role
    @Then("user should be able to view the following menu items under left navigation panel for non admin role")
    public void user_should_be_able_to_view_the_following_menu_items_under_left_navigation_panel_for_non_admin_role(DataTable leftNavMainMenusList) {
        verifyMainMenuItemsFromLeftNavigationForNonAdminRole(leftNavMainMenusList);
    }

    // Scenario: Verify user not able to view Reports Menu in Left Navigation for adjudicator role
    @Then("user should not be able to view the Reports Menu in Left Navigation for adjudicator role")
    public void user_should_not_be_able_to_view_the_reports_menu_in_left_navigation_for_adjudicator_role() {
        verifyUserNotAbleToViewReportsMenuFromLeftNavigationForNonAdminRole();
    }

    //    Scenario: Verify user not able to view the few sub menu's under Adjudication Menu for adjudicator role
    @Then("user should see the Global search menu under Adjudication section")
    public void user_should_see_the_global_search_menu_under_adjudication_section() {
        verifyUserAbleToViewGlobalSearchUnderAdjudicationMainMenuForNonAdminRole();
    }
    @Then("user should not be able to view the following sub menus under adjudication main menu")
    public void user_should_not_be_able_to_view_the_following_sub_menus_under_adjudication_main_menu(DataTable otherMenusList) {
        verifyUserNotAbleToViewOtherSubMenusExceptGlobalSearchUnderAdjMainMenuForNonAdminRole(otherMenusList);
    }

    // Scenario: Verify user not able to view User Management Menu in Left Navigation for adjudicator role
    @Then("user not able to view the User Management Menu in Left Navigation for adjudicator role")
    public void user_not_able_to_view_the_user_management_menu_in_left_navigation_for_adjudicator_role() {
        verifyUserNotAbleToViewUserManagementMainMenuForNonAdminRole();
    }


}
