package Automation.StepDefinitions;

import Automation.PageObjects.MembersListPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MembersListStepDef extends MembersListPage {

    //  Scenario: Verify user able to view all the columns on clicking Members List from Member Management
    @When("user clicks on Members List under Member Management")
    public void user_clicks_on_members_list_under_member_management() {
        userClicksOnMembersList();
    }

    @Then("user navigates to {string} page")
    public void user_navigates_to_page(String expTab) {
        verifyUserNavigatesToMembersListPage(expTab);
    }

    @Then("user able to view all the below mentioned columns under Members List")
    public void user_able_to_view_all_the_below_mentioned_columns_under_members_list(DataTable expFields) {
        verifyFieldsUnderMembersList(expFields);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Member ID
    @When("user enters Member ID in the Search criteria")
    public void user_enters_member_id_in_the_search_criteria() {
        userEntersMemberIDInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Member ID")
    public void user_able_to_view_the_appropriate_results_with_member_id() {
        verifyAppropriateResultsWithMemberID();
    }

    //  Verify user able to Search Member in the Search Box for Last Name
    @When("user enters Last Name in the Search criteria")
    public void user_enters_last_name_in_the_search_criteria() {
        userEntersLastNameInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Last Name")
    public void user_able_to_view_the_appropriate_results_with_last_name() {
        verifyAppropriateResultsWithLastName();
    }

    //  Verify user able to Search Member in the Search Box for First Name
    @When("user enters First Name in the Search criteria")
    public void user_enters_first_name_in_the_search_criteria() {
        userEntersFirstNameInSearchCriteria();
    }

    @Then("user able to view the appropriate results with First Name")
    public void user_able_to_view_the_appropriate_results_with_first_name() {
        verifyAppropriateResultsWithFirstName();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Middle Name
    @When("user enters Middle Name in the Search criteria")
    public void user_enters_middle_name_in_the_search_criteria() {
        userEntersMiddleNameInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Middle Name")
    public void user_able_to_view_the_appropriate_results_with_middle_name() {
        verifyAppropriateResultsWithMiddleName();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for DOB
    @When("user enters DOB in the Search criteria")
    public void user_enters_dob_in_the_search_criteria() {
        userEntersDOBInSearchCriteria();
    }

    @Then("user able to view the appropriate results with DOB")
    public void user_able_to_view_the_appropriate_results_with_dob() {
        verifyAppropriateResultsWithDOB();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Gender
    @When("user enters Gender in the Search criteria")
    public void user_enters_gender_in_the_search_criteria() {
        userEntersGenderInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Gender")
    public void user_able_to_view_the_appropriate_results_with_gender() {
        verifyAppropriateResultsWithGender();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for MBI
    @When("user enters MBI in the Search criteria")
    public void user_enters_mbi_in_the_search_criteria() {
        userEntersMBIInSearchCriteria();
    }

    @Then("user able to view the appropriate results with MBI")
    public void user_able_to_view_the_appropriate_results_with_mbi() {
        verifyAppropriateResultsWithMBI();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Provider ID
    @When("user enters Provider ID in the Search criteria")
    public void user_enters_provider_id_in_the_search_criteria() {
        userEntersProviderIDInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Provider ID")
    public void user_able_to_view_the_appropriate_results_with_provider_id() {
        verifyAppropriateResultsWithProviderId();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for PCP
    @When("user enters PCP in the Search criteria")
    public void user_enters_pcp_in_the_search_criteria() {
        userEntersPCPInSearchCriteria();
    }

    @Then("user able to view the appropriate results with PCP")
    public void user_able_to_view_the_appropriate_results_with_pcp() {
        verifyAppropriateResultsWithPCP();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Plan
    @When("user enters Plan in the Search criteria")
    public void user_enters_plan_in_the_search_criteria() {
        userEntersPlanInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Plan")
    public void user_able_to_view_the_appropriate_results_with_plan() {
        verifyAppropriateResultsWithPlan();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Eff Date
    @When("user enters Eff Date in the Search criteria")
    public void user_enters_eff_date_in_the_search_criteria() {
        userEntersEffDateInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Eff Date")
    public void user_able_to_view_the_appropriate_results_with_eff_date() {
        verifyAppropriateResultsWithEffDate();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Term Date
    @When("user enters Term Date in the Search criteria")
    public void user_enters_term_date_in_the_search_criteria() {
        userEntersTermDateInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Term Date")
    public void user_able_to_view_the_appropriate_results_with_term_date() {
        verifyAppropriateResultsWithTermDate();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Address
    @When("user enters Address in the Search criteria")
    public void user_enters_address_in_the_search_criteria() {
        userEntersAddressInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Address")
    public void user_able_to_view_the_appropriate_results_with_address() {
        verifyAppropriateResultsWithAddress();
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Status
    @When("user enters Status in the Search criteria")
    public void user_enters_status_in_the_search_criteria() {
        userEntersStatusInSearchCriteria();
    }

    @Then("user able to view the appropriate results with Status")
    public void user_able_to_view_the_appropriate_results_with_status() {
        verifyAppropriateResultsWithStatus();
    }
}