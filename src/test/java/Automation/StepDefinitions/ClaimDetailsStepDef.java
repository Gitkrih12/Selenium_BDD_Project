package Automation.StepDefinitions;

import Automation.PageObjects.ClaimDetailsPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ClaimDetailsStepDef extends ClaimDetailsPage {

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    @Given("the user is in FFS Professional page")
    public void the_user_is_in_ffs_professional_page() {
        accessFFSProfessionalPage();
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    @When("user clicks on the Claim Number")
    public void user_clicks_on_the_claim_number() {
        userClicksOnClaimNumber();
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    @Then("user navigates to the Claim Summary page")
    public void user_navigates_to_the_claim_summary_page() {
        userNavigatesToClaimSummaryPage();
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    @Then("user should view hide option besides Claim Summary")
    public void user_should_view_hide_option_besides_claim_summary() {
        userViewsHideOptionBesideClaimSummary();
    }

    //  Scenario: Verify View Claim in CMS 1500 and Self Assign buttons in Claim Summary details page
    @Then("user should view CMS {int} and Self Assign buttons in Claim Summary details page")
    public void user_should_view_cms_and_self_assign_buttons_in_claim_summary_details_page(Integer int1) {
        userViewsSelfAssignAndCMSButtons();
    }

    //  Scenario: Verify column fields in Claim Summary details page
    @Then("user should be able to view all the column fields in Claim Summary Details page")
    public void user_should_be_able_to_view_all_the_column_fields_in_claim_summary_details_page(DataTable columnList) {
        userViewsAllColumnFieldsInClaimSummaryDetails(columnList);
    }

    //  Scenario: Verify Claim Information section
    @Then("user views the Claim Summary Tab list")
    public void user_views_the_claim_summary_tab_list(DataTable fieldList) {
        userViewsClaimSummaryTabList(fieldList);
    }

    //  Scenario: Verify footer section in Claim Summary details page
    @Then("user views the footer section in Claim Summary details page")
    public void user_views_the_footer_section_in_claim_summary_details_page(DataTable footerFields) {
        userViewsFooterSectionInClaimSummaryDetails(footerFields);
    }

    //  Scenario: Verify Claim Details sections
    @Then("user views Claim Details by default")
    public void user_views_claim_details_by_default() {
        userViewClaimDetailsByDefault();
    }

    //  Scenario: Verify Claim Details sections
    @Then("user view Claim Details sections as below")
    public void user_view_claim_details_sections_as_below(DataTable claimDetailsSections) {
        userViewsClaimDetailsSections(claimDetailsSections);
    }

    //  Scenario: Validate Claim Information section
    @Then("user able to view the below fields under claim information section")
    public void user_able_to_view_the_below_fields_under_claim_information_section(DataTable claimInfoFields) {
        userViewsClaimInformationFields(claimInfoFields);
    }

    //  Scenario: Validate Payment Information section
    @Then("user able to view the below fields under Payment Information section")
    public void user_able_to_view_the_below_fields_under_payment_information_section(DataTable paymentInfoFields) {
        userViewsPaymentInformationFields(paymentInfoFields);
    }

    //  Validate Clean status
    @Then("user can check the claim status as Clean")
    public void user_can_check_the_claim_status_as_clean() {
        verifyClaimStatusAsClean();
    }

    //  Validate Unclean status
    @Then("user claim status as Un-Clean is unchecked by default")
    public void user_claim_status_as_un_clean_is_unchecked_by_default() {
        verifyClaimStatusforUncleanIsUnchecked();
    }

    //  Validate Member Information section
    @Then("user able to view the below fields under Member Information section")
    public void user_able_to_view_the_below_fields_under_member_information_section(DataTable memberInfoSection) {
        verifyFieldsUnderMemberInformationSection(memberInfoSection);
    }

    //  Validate Rendering Provider Information section
    @Then("user able to view the below fields under Rendering Provider information section")
    public void user_able_to_view_the_below_fields_under_rendering_provider_information_section(DataTable renderingProviderInfoSection) {
        verifyFieldsUnderRenderingProviderInformationSection(renderingProviderInfoSection);
    }
}