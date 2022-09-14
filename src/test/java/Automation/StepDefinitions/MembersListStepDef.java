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
}