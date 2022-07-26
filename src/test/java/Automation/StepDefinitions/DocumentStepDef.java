package Automation.StepDefinitions;

import Automation.PageObjects.DocumentsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class DocumentStepDef extends DocumentsPage {

    @When("user clicks on the Documents tab")
    public void user_clicks_on_the_documents_tab() {
        userClicksOnDocumentsTab();
    }

    @Then("user able to view the below sub tabs under Documents tab")
    public void user_able_to_view_the_below_sub_tabs_under_documents_tab(DataTable subTabView) {
        verifySubTabsUnderDocumentsTab(subTabView);
    }
}
