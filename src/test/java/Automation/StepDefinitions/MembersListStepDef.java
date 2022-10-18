package Automation.StepDefinitions;

import Automation.PageObjects.MembersListPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MembersListStepDef extends MembersListPage {

    @When("user clicks on Members List under Member Management")
    public void user_clicks_on_members_list_under_member_management() throws InterruptedException {
        userClicksOnMembersList();
    }

    @Then("user navigates to Members List page")
    public void user_navigates_to_members_list_page() {
        verifyUserNavigatesToMembersListPage();
    }

    @Then("user able to view all the below mentioned columns under Members List")
    public void user_able_to_view_all_the_below_mentioned_columns_under_members_list(DataTable expFields) {
        verifyFieldsUnderMembersList(expFields);
    }

    @When("user enters Member ID in the Search criteria")
    public void user_enters_member_id_in_the_search_criteria() throws InterruptedException {
        userEntersMemberIDInSearchCriteria();
    }
    @Then("user able to view the appropriate results on Members List screen")
    public void user_able_to_view_the_appropriate_results_on_members_list_screen() {
        verifyAppropriateResultsOnMembersListScreen();
    }
    @When("user enters Last Name in the Search criteria")
    public void user_enters_last_name_in_the_search_criteria() throws InterruptedException {
        userEntersLastNameInSearchCriteria();
    }
    @When("user enters First Name in the Search criteria")
    public void user_enters_first_name_in_the_search_criteria() throws InterruptedException {
        userEntersFirstNameInSearchCriteria();
    }
    @When("user enters Middle Name in the Search criteria")
    public void user_enters_middle_name_in_the_search_criteria() throws InterruptedException {
        userEntersMiddleNameInSearchCriteria();
    }
    @When("user enters DOB in the Search criteria")
    public void user_enters_dob_in_the_search_criteria() throws InterruptedException {
        userEntersDOBInSearchCriteria();
    }
    @When("user enters Gender in the Search criteria")
    public void user_enters_gender_in_the_search_criteria() throws InterruptedException {
        userEntersGenderInSearchCriteria();
    }
    @When("user enters MBI in the Search criteria")
    public void user_enters_mbi_in_the_search_criteria() throws InterruptedException {
        userEntersMBIInSearchCriteria();
    }
    @When("user enters Provider ID in the Search criteria")
    public void user_enters_provider_id_in_the_search_criteria() throws InterruptedException {
        userEntersProviderIDInSearchCriteria();
    }
    @When("user enters PCP in the Search criteria")
    public void user_enters_pcp_in_the_search_criteria() throws InterruptedException {
        userEntersPCPInSearchCriteria();
    }

    @When("user enters Plan in the Search criteria")
    public void user_enters_plan_in_the_search_criteria() throws InterruptedException {
        userEntersPlanInSearchCriteria();
    }
    @When("user enters Eff Date in the Search criteria")
    public void user_enters_eff_date_in_the_search_criteria() throws InterruptedException {
        userEntersEffDateInSearchCriteria();
    }
    @When("user enters Term Date in the Search criteria")
    public void user_enters_term_date_in_the_search_criteria() throws InterruptedException {
        userEntersTermDateInSearchCriteria();
    }
    @When("user enters Address in the Search criteria")
    public void user_enters_address_in_the_search_criteria() throws InterruptedException {
        userEntersAddressInSearchCriteria();
    }
    @When("user enters Status in the Search criteria")
    public void user_enters_status_in_the_search_criteria() throws InterruptedException {
        userEntersStatusInSearchCriteria();
    }
}