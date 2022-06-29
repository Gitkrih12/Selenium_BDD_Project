package Automation.StepDefinitions;

import Automation.PageObjects.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class LoginStepDef extends LoginPage {


    @Given("the user is in CA Login screen")
    public void the_user_is_in_ca_login_screen() {
        accessLoginScreen();
    }

    //    Scenario: Verify the "Welcome to Claims Adjudication" text along with NG in Login page screen
    @When("user navigates to the Login page UI")
    public void user_navigates_to_the_login_page_ui() {
        verifyWelcomeToClaimsAdjudicationNgText();
    }

    //    Scenario: Verify "User Login" text should display in the Login screen
    @When("user views the Login screen with User Login text")
    public void user_views_the_login_screen_with_user_login_text() {
        verifyUserLoginText();
    }

    //      Scenario: Verify the hospital pictography along with the texts displayed in Login Screen
    @When("user views the hospital pictography and Hospital, Claim Form texts displayed")
    public void user_views_the_hospital_pictography_and_hospital_claim_form_texts_displayed() {
        verifyHospitalImage();
    }

    //    Scenario: Verify user able to login with valid username and password for DSNP adjudicator role
    @When("the user enters the valid username and password and click on login button")
    public void the_user_enters_the_valid_username_and_password_and_click_on_login_button() {
        verifyLoginWithValidUsernameAndPasswordForDsnpAdjudicator();
    }

    //    Scenario: Verify user able to login with valid username and password for DSNP admin role
    @Given("the user enters the valid username and password and click on login button for admin role")
    public void the_user_enters_the_valid_username_and_password_and_click_on_login_button_for_admin_role() {
        verifyLoginWithValidUsernameAndPasswordForDsnpAdmin();
    }

    //    Scenario: Verify user able to login with valid username and password for non DSNP adjudicator role
    @When("the user enters the valid username and password and click on login button for Non DSNP adjudicator role")
    public void the_user_enters_the_valid_username_and_password_and_click_on_login_button_for_non_dsnp_adjudicator_role() {
        verifyLoginWithValidUsernameAndPasswordForNonDsnpAdjudicator();
    }

    //    Scenario: Verify user able to login with valid username and password for non DSNP admin role
    @When("the user enters the valid username and password and click on login button for Non DSNP admin role")
    public void the_user_enters_the_valid_username_and_password_and_click_on_login_button_for_non_dsnp_admin_role() {
        verifyLoginWithValidUsernameAndPasswordForNonDsnpAdmin();
    }

    //    Scenario: Verify user able to view Mirra logo besides User Login text in Login screen
    @When("user views Mirra logo in Login page")
    public void user_views_mirra_logo_in_login_page() {
        verifyMirraLogoOnHomePage();
    }

    //    Scenario: Verify user should be able to view the "Valor Health Plan", "Insurance focused on you." texts one after the other in Login screen
    @When("user views the Valor Health Plan, Insurance focused on you. texts one after the other")
    public void user_views_the_texts_one_after_the_other() {
        verifyValorHealthPlanImage();
    }

    //    Scenario:  Verify user views "Login" button besides rightwards arrow symbol in Login screen
    @When("user views the Login button besides rightwards arrow symbol")
    public void user_views_the_login_button_besides_rightwards_arrow_symbol() {
        verifyLoginButton();
    }

    @When("user lands directly to the page")
    public void user_lands_directly_to_the_page() {
        verifyUserLoginTextForAdmin();
    }

    //    Scenario: Verify user views the "Forgot Password?" text in the Login page
    @When("user views the Forgot Password? text under Password grey field")
    public void user_views_the_forgot_password_text_under_password_grey_field() {
        verifyForgotPasswordMessage();
    }

    //    Scenario: Verify user views the "Password" text besides lock icon with grey field along with the inner text
    @When("user views the Password text beside lock icon in Login page")
    public void user_views_the_password_text_beside_lock_icon_in_login_page() {
        verifyPasswordText();
    }

    @When("user views the grey field under the Password text")
    public void user_views_the_grey_field_under_the_password_text() {
        verifyGreyFieldUnderPasswordText();
    }

    @When("user view the inner text as Enter Password in the grey field")
    public void user_view_the_inner_text_as_enter_password_in_the_grey_field() {
        validateEnterPasswordText();
    }

    //    Scenario: Verify user views the "Username" text besides person icon with grey field along with the inner text
    @When("user views the Username text beside person icon in Login page")
    public void user_views_the_text_beside_person_icon_in_login_page() {
        verifyUsernameText();
    }
    @When("user views the grey field under the Username text")
    public void user_views_the_grey_field_under_the_username_text() {
        verifyGreyFieldUnderUsernameText();
    }
    @When("user views the inner text as Enter Username in the grey field")
    public void user_views_the_inner_text_as_enter_username_in_the_grey_field() {
        validateEnterUsernameText();
    }

    //    Scenario: Verify user lands to the home page when logged in to the CA application
    @Given("the user logged into CA application")
    public void the_user_logged_into_ca_application() {
        verifyUserLoginToApplicationForDsnpAdjAndAdmin();
    }
    @When("user directly lands to the home page")
    public void user_directly_lands_to_the_home_page() {
        verifyIfUserIsOnHomePageForDsnpAdjAndAdmin();
    }

    //    Scenario: Verify user should be able to view the Universal Search Place holder in home page view
    @Given("the user is in Home page view")
    public void the_user_is_in_home_page_view() {
        userLandsOnHomePage();
    }
    @When("user views the Universal Search place holder at the top right corner")
    public void user_views_the_universal_search_place_holder_at_the_top_right_corner() {
        validateUniversalSearchPlaceHolderFromHeaderOptions();
    }

    //    Scenario: Verify user should view the App Drawer icon at the top right corner in the home page view
    @When("user able to view the App drawer icon")
    public void user_able_to_view_the_app_drawer_icon() {
        validateAppDrawerIconFromHeaderOptions();
    }

    //    Scenario: Verify user should view the Notification icon in the home page screen
    @When("user views the notification icon")
    public void user_views_the_notification_icon() {
        validateNotificationIconFromHeaderOptions();
    }

    //    Scenario: Verify user views the User Options on clicking username dropdown in the home page screen
    @When("user views User options under username dropdown")
    public void user_views_user_options_under_username_dropdown() {
        validateUserOptionsUnderUsernameDropdown();
    }
}

