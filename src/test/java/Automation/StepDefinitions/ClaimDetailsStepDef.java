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

    @When("user clicks on the Claim Number")
    public void user_clicks_on_the_claim_number() {
        userClicksOnClaimNumber();
    }

    @Then("user navigates to the {string} page")
    public void user_navigates_to_the_page(String expPageTitle) {
        userNavigatesToClaimSummaryPage(expPageTitle);
    }

    @Then("user should view {string} option besides Claim Summary")
    public void user_should_view_option_besides_claim_summary(String expOption) {
        userViewsHideOptionBesideClaimSummary(expOption);
    }

    //  Scenario: Verify View Claim in CMS 1500 and Self Assign buttons in Claim Summary details page
    @Then("user should view {string} and {string} buttons in Claim Summary details page")
    public void user_should_view_and_buttons_in_claim_summary_details_page(String expViewClaimValue, String expSelfAssignValue) {
        userViewsCMSButton(expViewClaimValue);
        userViewsSelfAssignButton(expSelfAssignValue);
    }

    //  Scenario: Verify column fields in Claim Summary details page
    @Then("user should be able to view all the column fields in Claim Summary Details page")
    public void user_should_be_able_to_view_all_the_column_fields_in_claim_summary_details_page(DataTable columnList) {
        userViewsAllColumnFieldsInClaimSummaryDetails(columnList);
    }

    //  Scenario: Verify Claim Information section
    @Then("user views the Claim Summary Tab list")
    public void user_views_the_claim_summary_tab_list(DataTable fieldList) throws InterruptedException {
        userViewsClaimSummaryTabList(fieldList);
    }

    //  Scenario: Verify footer section in Claim Summary details page
    @Then("user views the footer section in Claim Summary details page")
    public void user_views_the_footer_section_in_claim_summary_details_page(DataTable footerFields) {
        userViewsFooterSectionInClaimSummaryDetails(footerFields);
    }

    //  Scenario: Verify Claim Details sections
    @Then("user views Claim Details by default should be {string}")
    public void user_views_claim_details_by_default_should_be(String expTabState) {
        userViewClaimDetailsByDefault(expTabState);
    }

    @Then("user view Claim Details sections as below")
    public void user_view_claim_details_sections_as_below(DataTable claimDetailsSections) throws InterruptedException {
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

    //  Scenario: Validate Clean status
    @Then("user can check the claim status as Clean")
    public void user_can_check_the_claim_status_as_clean() {
        verifyClaimStatusAsClean();
    }

    //  Scenario: Validate Unclean status
    @Then("user claim status as Un-Clean is unchecked by default")
    public void user_claim_status_as_un_clean_is_unchecked_by_default() {
        verifyClaimStatusForUncleanIsUnchecked();
    }

    //  Scenario: Validate Member Information section
    @Then("user able to view the below fields under Member Information section")
    public void user_able_to_view_the_below_fields_under_member_information_section(DataTable memberInfoSection) {
        verifyFieldsUnderMemberInformationSection(memberInfoSection);
    }

    //  Scenario: Validate Rendering Provider Information section
    @Then("user able to view the below fields under Rendering Provider information section")
    public void user_able_to_view_the_below_fields_under_rendering_provider_information_section(DataTable renderingProviderInfoSection) {
        verifyFieldsUnderRenderingProviderInformationSection(renderingProviderInfoSection);
    }


    //  Scenario: Validate Billing Provider Information section
    @Then("user able to view the below fields under Billing Provider Information section")
    public void user_able_to_view_the_below_fields_under_billing_provider_information_section(DataTable billingProviderInfoSection) {
        verifyFieldsUnderBillingProviderInformationSection(billingProviderInfoSection);
    }

    //  Scenario: Validate Payer section
    @Then("user able to view the below fields under Payer section")
    public void user_able_to_view_the_below_fields_under_payer_section(DataTable payerSection) {
        verifyFieldsUnderPayerSection(payerSection);
    }

    //  Scenario: Validate Date of Service section
    @Then("user able to view the below fields under Date of Service section")
    public void user_able_to_view_the_below_fields_under_date_of_service_section(DataTable dateOfServiceSection) {
        verifyFieldsUnderDateOfServiceSection(dateOfServiceSection);
    }

    // Scenario: Validate Is Patient Condition Related To section
    @Then("user able to view the below fields under Is Patient Condition Related To section")
    public void user_able_to_view_the_below_fields_under_is_patient_condition_related_to_section(DataTable isPatientConditionRelatedToSection) {
        verifyFieldsUnderIsPatientConditionRelatedToSection(isPatientConditionRelatedToSection);
    }

    //  Scenario: Validate Hide action for claim summary section
    @When("user clicks on Hide link")
    public void user_clicks_on_hide_link() {
        userClicksOnHideLink();
    }

    //  Scenario: Validate Hide action for claim summary section
    @Then("user should hide the claim summary section")
    public void user_should_hide_the_claim_summary_section() {
        verifyClaimSummarySectionShouldHide();
    }

    //  Scenario: Validate Show action for claim summary section
    @Then("user able to view the show link")
    public void user_able_to_view_the_show_link() {
        verifyShowLinkIsDisplayed();
    }

    //  Scenario: Validate Show action for claim summary section
    @When("user clicks on Show link")
    public void user_clicks_on_show_link() {
        userClicksOnShowLink();
    }

    //  Scenario: Validate Show action for claim summary section
    @Then("user able to view the Claim Summary section")
    public void user_able_to_view_the_claim_summary_section() {
        verifyUserViewsClaimSummarySection();
    }
}