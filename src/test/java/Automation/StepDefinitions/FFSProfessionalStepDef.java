package Automation.StepDefinitions;

import Automation.PageObjects.FFSProfessionalPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FFSProfessionalStepDef extends FFSProfessionalPage {
    //Verify color code for corrected claims in FFS Professional page
    @When("user clicks on FFS Professional in left navigation menu")
    public void user_clicks_on_ffs_professional_in_left_navigation_menu() {
        clickOnFFSProfessional();

    }
    @Then("the user should navigate to the FFS Professional page")
    public void the_user_should_navigate_to_the_ffs_professional_page() {
        verifyFFSProfessionalPage();
    }
    @When("user enters Corrected claim in FFS Professional search criteria")
    public void user_enters_corrected_claim_in_ffs_professional_search_criteria() throws InterruptedException {
        enterCorrectedClaimNumberInFFSProfessionalSearchField();
    }
    @Then("user should able to view corrected claim in FFS Professional Grid")
    public void user_should_able_to_view_corrected_claim_in_ffs_professional_grid() {
        validateClaimNumberResult();
    }
    @Then("user should able to see vertical line beside claim number with color code {string} in FFS Professional page")
    public void user_should_able_to_see_vertical_line_beside_claim_number_with_color_code_in_ffs_professional_page(String colorIndication) {
        verifyVerticalColorIndicationForCorrectedClaim(colorIndication);
    }
    @Then("color indication information should be available on top of grid in FFS Professional page")
    public void color_indication_information_should_be_available_on_top_of_grid_in_ffs_professional_page() {
        verifyCorrectedInformationOnTopOfGrid();
    }

    //Scenario: Verify color code for COB In Member House in FFS Professional page
    @When("user enters COB In Member House claim in search criteria")
    public void user_enters_cob_in_member_house_claim_in_search_criteria() throws InterruptedException {
        enterCOBInMemberHouseClaimNumber();
    }
    @Then("user should able to view COB In Member House claim")
    public void user_should_able_to_view_cob_in_member_house_claim() {
        validateClaimNumberResult();
    }
    @Then("user should able to view patient name with color code {string} in FFS Professional page")
    public void user_should_able_to_view_patient_name_with_color_code_in_ffs_professional_page(String colorCode) {
        verifyPatientNameColorCode(colorCode);
    }
    @Then("color indication information for COB In Member House should be available on top of grid")
    public void color_indication_information_for_cob_in_member_house_should_be_available_on_top_of_grid() {
        verifyCOBInMemberHouseInformationOnTopOfGrid();
    }

    //Verify color code for COB Not In Member House in FFS Professional page
    @When("user enters COB Not In Member House claim in search criteria")
    public void user_enters_cob_not_in_member_house_claim_in_search_criteria() throws InterruptedException {
        enterCOBNotInMemberHouseClaimNumber();
    }
    @Then("user should able to view COB Not In Member House claim")
    public void user_should_able_to_view_cob_not_in_member_house_claim() {
        validateClaimNumberResult();
    }
    @Then("color indication information for COB Not In Member House should be available on top of grid")
    public void color_indication_information_for_cob_not_in_member_house_should_be_available_on_top_of_grid() {
        verifyCOBNotInMemberHouseInformationOnTopOfGrid();
    }
}
