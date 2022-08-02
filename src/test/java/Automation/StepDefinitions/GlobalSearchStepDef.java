package Automation.StepDefinitions;

import Automation.PageObjects.GlobalSearchPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GlobalSearchStepDef extends GlobalSearchPage {

    //Scenario: Verify user should get no result by default on Global search page
    @When("user clicks on Global Search in left navigation menu")
    public void user_clicks_on_global_search_in_left_navigation_menu() {
        clickOnGlobalSearch();
    }

    @Then("the user should navigate to the Global Search page")
    public void the_user_should_navigate_to_the_global_search_page() {
        verifyGlobalSearchPage();
    }

    @Then("by default no results should get displayed")
    public void by_default_no_results_should_get_displayed() {
        verifyNoDataDisplayMessage();
    }

    //Scenario: Verify Filter and Customize Columns buttons in Global search page
    @Then("user should able to view the Filter and Customize columns buttons")
    public void user_should_able_to_view_the_filter_and_customize_columns_buttons() {
        verifyFilterButton();
        verifyCustomisedColumn();
    }

    //Scenario: Verify column fields in grid level on Global Search
    @Then("user should able to see column fields in global Search page")
    public void user_should_able_to_see_column_fields(DataTable columnList) throws InterruptedException {
        verifyGlobalSearchColumnFields(columnList);
    }

    //Scenario: Verify search field displayed under each column
    @Then("user able to view the Search fields under each column")
    public void user_able_to_view_the_search_fields_under_each_column() {
        verifySearchFieldsUnderEachColumn();
    }

    //Scenario: Verify adjudicator should land on Global Search Page
    @Then("user should land on Global Search page")
    public void user_should_land_on_global_search_page() {
        verifyAdjudicatorLandsOnGlobalSearchPage();
    }

    //Scenario: Verify user enters the Claim Number in the Search field
    /*@When("user enters the Claim Number {string} in the Search field")
    public void user_enters_the_in_the_search_field(String claimNumber) throws InterruptedException {
        enterClaimNumberInSearchField(claimNumber);
    }*/
    @When("user enters the Claim Number in the Search field")
    public void user_enters_the_claim_number_in_the_search_field() throws InterruptedException {
        enterClaimNumberInSearchField();
    }


    @Then("user able to view the exact claim details")
    public void user_able_to_view_the_exact_claim_details() {
        validateClaimNumberResult();
    }

    //Scenario: Verify user should get records when he search with more than 6 characters in claim number field in Global Search page
    @When("user enters more than six characters in the Claim Number Search field")
    public void user_enters_more_than_six_characters_in_the_claim_number_search_field() throws InterruptedException {
        enterSevenCharactersInClaimNumberSearchField();
    }

    @Then("user able to view the claim details for given filter criteria")
    public void user_able_to_view_the_claim_details_for_given_filter_criteria() {
        validateClaimNumberResultForCharacterLimit();
    }

    //Scenario: Verify user should not get records when he search with less than 7 characters in claim number field in Global Search page
    @When("user enters less than seven characters in the Claim Number Search field")
    public void user_enters_less_than_seven_characters_in_the_claim_number_search_field() throws InterruptedException {
        enterSixCharactersInClaimNumberSearchField();
    }

    @Then("user not able to view the claim details for given filter criteria.")
    public void user_not_able_to_view_the_claim_details_for_given_filter_criteria() {
        verifyNoDataDisplayMessage();
    }

    //Scenario: Verify user enters the Member ID in the Search field
    @When("user enters the Member Id in the Search field")
    public void user_enters_the_member_id_in_the_search_field() throws InterruptedException {
        enterMemberIdInSearchField();
    }

    @Then("user able to view the claim details for given member id")
    public void user_able_to_view_the_exact_member_details() {
        validateMemberIDResult();
    }

    //Scenario: Verify user enters the Patient Name in the Search field
    @When("user enters the Patient Name in the Search field")
    public void user_enters_the_patient_name_in_the_search_field() throws InterruptedException {
        enterPatientNameInSearchField();
    }

    @Then("user able to view the claim details for given Patient name")
    public void user_able_to_view_the_exact_patient_details() {
        validatePatientNameResult();
    }

    // Scenario: Verify user enters the State name in the Search field
    @When("user enters the State in the Search field")
    public void user_enters_the_state_in_the_search_field() throws InterruptedException {
        enterStateInSearchField();
    }

    @Then("user able to view the claim details for given State")
    public void user_able_to_view_the_claim_details_for_given_state() {
        validateStateResult();
    }

    //Scenario: Verify user enters the Category value in the Search field
    @When("user enters the Category in the Search field")
    public void user_enters_the_category_in_the_search_field() throws InterruptedException {
        enterCategoryInSearchField();
    }

    @Then("user able to view the claim details for given Category")
    public void user_able_to_view_the_claim_details_for_given_category() {
        validateCategoryResult();
    }

    //  Scenario: Verify user enters the DOS From details in the Search field
    @When("user enters the DOS From in the Search field")
    public void user_enters_the_dos_from_in_the_search_field() throws InterruptedException {
        enterDOSFromInSearchField();
    }

    @Then("user able to view the claim details for given DOS From")
    public void user_able_to_view_the_claim_details_for_given_dos_from() {
        validateDOSFromResult();
    }

    //Scenario: Verify user enters the DOS To details in the Search field
    @When("user enters the DOS To in the Search field")
    public void user_enters_the_dos_to_in_the_search_field() throws InterruptedException {
        enterDOSToInSearchField();
    }


    @Then("user able to view the claim details for given DOS To")
    public void user_able_to_view_the_claim_details_for_given_dos_to() {
        validateDOSToResult();
    }

    // Scenario: Verify user enters the Billing Provider details in the Search field
    @When("user enters the Billing Provider in the Search field")
    public void user_enters_the_billing_provider_in_the_search_field() throws InterruptedException {
        enterBillingProviderInSearchField();
    }

    @Then("user able to view the claim details for given Billing Provider")
    public void user_able_to_view_the_claim_details_for_given_billing_provider() {
        validateBillingProviderResult();
    }

    //Scenario: Validate Export Result button should display when the search results are displayed
    @Then("user not able to view Export Result button when search results are not displayed")
    public void user_not_able_to_view_export_result_button_when_search_results_are_not_displayed() {
        verifyExportResultButtonWhenNoSearchResultsDisplayed();
    }

    @Then("user able to view the Export Result button when search results are displayed")
    public void user_able_to_view_the_export_result_button_when_search_results_are_displayed() {
        verifyExportResultButtonWhenSearchResultsDisplayed();
    }

    //Scenario: Verify Reprocess button should be available when Paid state is filtered in Global Search page
    @Then("user should be able view the Reprocess button for Paid state record")
    public void user_should_be_able_view_the_reprocess_button_for_paid_state_record() throws InterruptedException {
        verifyReprocessButton();
    }

    // Scenario: Verify user able to search more than 2 characters in Member Id field
    @When("user searches more than two characters in Member Id field")
    public void user_searches_more_than_two_characters_in_member_id_field() throws InterruptedException {
        enterThreeCharMemberIdInSearchField();
    }

    @Then("user should be able to display the claim records in a Global Search for given Member Id criteria")
    public void user_should_be_able_to_display_the_claim_records_in_a_global_search_for_given_Member_criteria() {
        validateMemberIDResultForCharacterLimit();
    }

    //Scenario: Verify user able to search more than 2 characters in Patient field
    @When("user searches more than two characters in Patient field")
    public void user_searches_more_than_two_characters_in_patient_field() throws InterruptedException {
        enterThreeCharPatientNameInSearchField();
    }

    @Then("user should be able to display the claim records in a Global Search for given Patient criteria")
    public void user_should_be_able_to_display_the_claim_records_in_a_global_search_for_given_patient_criteria() {
        validatePatientResultForCharacterLimit();
    }

    //Scenario: Verify user able to search more than 2 characters in Billing Provider field
    @When("user searches more than two characters in Billing Provider field")
    public void user_searches_more_than_two_characters_in_billing_provider_field() throws InterruptedException {
        enterMoreThanTwoCharactersInBillingProviderSearchField();
    }

    @Then("user should be able to display the claim records in a Global Search for given Billing Provider criteria")
    public void user_should_be_able_to_display_the_claim_records_in_a_global_search_for_given_billing_provider_criteria() {
        validateBillingProviderResultForCharacterLimit();
    }

    //  Scenario: Verify user able to search more than 2 characters in any two fields
    @When("user searches more than two characters in State field")
    public void user_searches_more_than_two_characters_in_state_field() throws InterruptedException {
        enterThreeCharStateInSearchField();
    }

    @Then("user should be able to display the claim records in a Global Search")
    public void user_should_be_able_to_display_the_claim_records_in_a_global_search() {
        validateStateResultForCharacterLimit();
    }

    //Scenario: Verify user able to search claims by using universal search
    @Then("user should be able to view Universal search bar on the top right corner of the page")
    public void the_user_should_be_able_to_view_universal_search_bar_on_the_top_right_corner_of_the_page() {
        verifyUniversalSearchBar();
    }

    @Then("placeholder should read {string}")
    public void the_placeholder_should_read(String placeholderValue) {
        verifyPlaceHolderForUniversalSearch(placeholderValue);
    }

    @When("user provides correct claim number in the search bar")
    public void user_provides_correct_claim_number_in_the_search_bar() {
        enterClaimNumberInUniversalSearch();
    }

    @Then("user is able to view claim details page in another tab")
    public void user_is_able_to_view_claim_details_page_in_another_tab() {
        verifyViewClaimDetailsAnotherTab();
    }

    // Scenario: Verify user able to see error message If the wrong Claim Number is entered in universal search
    @When("user searches for the claim number with less than ten characters")
    public void user_searches_for_the_claim_number_with_less_than_ten_characters() {
        enterLessThanTenCharClaimNumberInUniversalSearch();
    }

    //Scenario: Verify user able to see error message If the wrong Claim Number is entered in universal search
    @Then("user should be getting an error message as {string}")
    public void the_user_should_be_getting_an_error_message_as(String errorMessage) throws InterruptedException {
        verifyErrorMessage(errorMessage);
    }

    //  Scenario: Verify user able to see error message when search with invalid claim number
    @When("user searches for any invalid claim number")
    public void user_searches_for_any_invalid_claim_number() {
        enterInvalidCharClaimNumberInUniversalSearch();
    }

    //Scenario: Verify color code for corrected claims in Global Search page
    @When("user enters Corrected claim in search criteria")
    public void user_enters_corrected_claim_in_search_criteria() throws InterruptedException {
        enterCorrectedClaimNumberInSearchField();
    }

    @Then("user should able to view corrected claim")
    public void user_should_able_to_view_corrected_claim() {
        validateClaimNumberResult();
    }

    @Then("user should able to see vertical line beside claim number with color code {string}")
    public void user_should_able_to_see_vertical_line_beside_claim_number_with_color_code(String colorIndication) {
        verifyVerticalColorIndicationForCorrectedClaim(colorIndication);
    }

    @Then("color indication information should be available on top of grid")
    public void color_indication_information_should_be_available_on_top_of_grid() {
        verifyCorrectedInformationOnTopOfGrid();
    }

    //Scenario Outline: Verify color code for Pend On Hold Payer Review Management Review Approved Deny Prebatch Batch To Pay Paid Rejected state claim number
    @When("user enters the State {string} in the Search field")
    public void user_enters_the_state_in_the_search_field(String state) throws InterruptedException {
        enterStateInSearchField(state);
    }

    @Then("user should able to see the circle with color code {string} for given State")
    public void user_should_able_to_see_the_circle_with_color_code_for_paid_state_claim_number(String colorCode) {
        verifyCircleWithColorCodeForState(colorCode);
    }

    //Scenario: Verify color code for voided state claim number
    @When("user enters the Member Id in the Search field for Voided State")
    public void user_enters_the_member_id_in_the_search_field_for_voided_state() throws InterruptedException {
        enterMemberIdInSearchFieldForVoid();
    }

    //Scenario: Verify colour coding for Unclean status professional claims in Global Search page
    @When("user enters Unclean status professional claim in search criteria")
    public void user_enters_unclean_status_professional_claim_in_search_criteria() throws InterruptedException {
        enterUnCleanProfessionalClaimNumberInSearchField();
    }
    //Scenario: Verify colour coding for Unclean status Institutional claims in Global Search page
    @When("user enters Unclean status institutional claim in search criteria")
    public void user_enters_unclean_status_institutional_claim_in_search_criteria() throws InterruptedException {
        enterUnCleanInstitutionalClaimNumberInSearchField();
    }

    @Then("user should able to view Unclean status claim")
    public void user_should_able_to_view_unclean_status_claim() {
        validateClaimNumberResult();
    }

    @Then("user should able to see vertical line beside unclean status claim number with color code {string}")
    public void user_should_able_to_see_vertical_line_beside_unclean_status_claim_number_with_color_code(String colorCode) {
        verifyVerticalColorIndicationForUncleanClaim(colorCode);
    }

    @Then("color indication information for Unclean should be available on top of grid")
    public void color_indication_information_for_unclean_should_be_available_on_top_of_grid() {
        verifyUncleanInformationOnTopOfGrid();
    }

    //Scenario: Verify user should navigate to Customized Columns window when we click on Customized columns in Global Search page
    @When("the user clicks Customize Columns option")
    public void the_user_clicks_customize_columns_option() {
        clickOnCustomiseColumn();
    }
    @Then("the user should able to navigate to Customized Columns window")
    public void the_user_should_able_to_navigate_to_customized_columns_window() {
        verifyCustomizeColumnWindow();
    }

    //Scenario:Verify user should able to see the mentioned column fields in the 'Customize Columns' window
    @Then("user should able to see {string} header")
    public void user_should_able_to_see_header(String customizeColumn) {
        verifyCustomizeColumnHeader(customizeColumn);
    }

    @Then("user should able to see following column fields in Customize Column window")
    public void user_should_able_to_see_following_column_fields_in_customize_column_window(DataTable customizeColumnList) throws InterruptedException {
        verifyCustomizeColumnFields(customizeColumnList);
    }
    @Then("user should able to see Save and close buttons")
    public void user_should_able_to_see_save_and_close_buttons() {
        verifySaveButton();
        verifyCloseButton();

    }

    //Scenario: Verify claim number order and check box should be selected by default
    @Then("claim number column should be first and disabled mode")
    public void claim_number_column_should_be_first_and_disabled_mode() {
        verifyClaimNumberColumnOrder();
        verifyClaimNumberInDisabledMode();
    }

    @Then("claim number check box should be selected by default")
    public void claim_number_check_box_should_be_selected_by_default() {
        verifyClaimNumberCheckBox();
    }

    //Scenario: Verify user should able to see saved/updated fields under Global Search page
    @When("user select check box for the Provider field")
    public void user_select_check_box_for_the_provider_field() {
        clickProviderCheckBox();
    }
    @Then("user should able to see the Provider column in the Global search grid page")
    public void user_should_able_to_see_the_provider_column_in_the_global_search_grid_page() throws InterruptedException {
        verifyProviderColumnDisplayInGlobalSearch();
    }

    @Then("user unselect check box for the Provider field")
    public void user_unselect_check_box_for_the_provider_field() throws InterruptedException {
        unSelectProviderCheckBox();
    }
    @Then("user should not able to see the Provider column in the Global search grid page")
    public void user_should_not_able_to_see_the_provider_column_in_the_global_search_grid_page() {
        verifyProviderColumnNotDisplayedInGlobalSearch();
    }

    // Scenario: Validate pagination in global Search page
    @When("user enters the Member Id in the Search field for Pagination")
    public void user_enters_the_member_id_in_the_search_field_for_pagination() throws InterruptedException {
        enterMemberIdInSearchFieldForPagination();
    }
    @When("user get the total records for the search criteria")
    public void user_get_the_total_records_for_the_search_criteria() {
        getAllMemberIdResults();
    }
    @Then("user should be able to view the total results count at the bottom of the page")
    public void user_should_be_able_to_view_the_total_results_count_at_the_bottom_of_the_page() {
        verifyTotalResultsForGivenSearch();
    }

    @Then("user should be able to view the page numbers at bottom of the page")
    public void user_should_be_able_to_view_the_page_numbers_at_bottom_of_the_page() {
        verifyPageNumbersAtBottomOfPage();
    }

    //Scenario: Verify user should allow to navigate to other pages
    @When("user tries to click on next arrow symbol")
    public void user_tries_to_click_on_next_arrow_symbol() {
        clickOnNextButton();
    }

    @When("user allow to navigates to next page")
    public void user_allow_to_navigates_to_next_page() {
        verifyUserNavigatesToNextPage();
    }

    @When("user tries to click on back arrow symbol")
    public void user_tries_to_click_on_back_arrow_symbol() {
        clickOnPreviousButton();
    }

    @Then("user should allow to navigates to back page")
    public void user_should_allow_to_navigates_to_back_page() {
        verifyUserNavigatesToPreviousPage();
    }


    //Scenario: Verify user see the page numbers as per the no of data divided by pages size
    @Then("user see the page numbers as per the no of data divided by pages size")
    public void user_see_the_page_numbers_as_per_the_no_of_data_divided_by_pages_size() {
        verifyPageSizeDividedByNoOfRecordsInTheGrid();
    }

    //  Scenario: Verify the user should perform sorting for DOS From field to ascending order
    @When("user enters the Member Id in the Search field for sorting")
    public void user_enters_the_member_id_in_the_search_field_for_sorting() throws InterruptedException {
        enterMemberIdInSearchFieldForSorting();
    }
    @Then("user get the DOS from records before sorting")
    public void user_get_the_dos_from_records_before_sorting() {
        getAllDOSFromRecordsBeforeSort();
    }
    @When("user clicks on sort icon for the DOS From field column")
    public void user_clicks_on_sort_icon_for_the_dos_from_field_column() {
        clickSortIconDOSFrom();
    }
    @Then("user able to view the field values in the sorted order")
    public void user_able_to_view_the_field_values_in_the_sorted_order() {
        verifyDOSFromInSortedAscendingOrder();
    }

    //Scenario: Verify the user should perform sorting for DOS To field to ascending order
    @Then("user get the DOS To records before sorting")
    public void user_get_the_dos_to_records_before_sorting() {
        getAllDOSToRecordsBeforeSort();
    }
    @When("user clicks on sort icon for the DOS To field column")
    public void user_clicks_on_sort_icon_for_the_dos_to_field_column() {
        clickSortIconDOSTo();
    }
    @Then("user able to view the field values in the sorted order for DOS To column")
    public void user_able_to_view_the_field_values_in_the_sorted_order_for_dos_to_column() {
        verifyDOSToInSortedAscendingOrder();
    }

    //Scenario: Verify the user should perform sorting for Claim Number field to ascending order
    @Then("user get the Claim Numbers records before sorting")
    public void user_get_the_claim_numbers_records_before_sorting() {
        getAllClaimNumberRecordsBeforeSort();
    }
    @When("user clicks on sort icon for the Claim Number field column")
    public void user_clicks_on_sort_icon_for_the_claim_number_field_column() {
        clickSortIconClaimNumber();
    }
    @Then("user able to view the field values in the sorted order for Claim Number column")
    public void user_able_to_view_the_field_values_in_the_sorted_order_for_claim_number_column() {
        verifyClaimNumbersInSortedAscendingOrder();
    }

    //Scenario: Verify the user should perform sorting for Billing Provider field to ascending order
    @Then("user get the Billing Provider records before sorting")
    public void user_get_the_billing_provider_records_before_sorting() {
        getAllBillingProviderRecordsBeforeSort();
    }
    @When("user clicks on sort icon for the Billing Provider field column")
    public void user_clicks_on_sort_icon_for_the_billing_provider_field_column() {
        clickSortIconBillingProvider();
    }
    @Then("user able to view the field values in the sorted order for Billing Provider column")
    public void user_able_to_view_the_field_values_in_the_sorted_order_for_billing_provider_column() {
        verifyBillingProviderInSortedAscendingOrder();
    }

    //Scenario: Verify the user should perform sorting for Patient field to ascending order
    @Then("user get the Patient records before sorting")
    public void user_get_the_patient_records_before_sorting() {
        getAllPatientRecordsBeforeSort();
    }
    @When("user clicks on sort icon for the Patient field column")
    public void user_clicks_on_sort_icon_for_the_patient_field_column() {
        clickSortIconPatient();
    }
    @Then("user able to view the field values in the sorted order for Patient column")
    public void user_able_to_view_the_field_values_in_the_sorted_order_for_patient_column() {
        verifyPatientInSortedAscendingOrder();
    }

    //Scenario: Verify the user should perform sorting for Category field to ascending order
    @Then("user get the Category records before sorting")
    public void user_get_the_category_records_before_sorting() {
        getAllCategoryRecordsBeforeSort();
    }
    @When("user clicks on sort icon for the Category field column")
    public void user_clicks_on_sort_icon_for_the_category_field_column() {
        clickSortIconCategory();
    }
    @Then("user able to view the field values in the sorted order for Category column")
    public void user_able_to_view_the_field_values_in_the_sorted_order_for_category_column() {
        verifyCategoryInSortedAscendingOrder();
    }

    //Scenario: Verify the user should perform sorting for State field to ascending order
    @Then("user get the State records before sorting")
    public void user_get_the_state_records_before_sorting() {
        getAllStateRecordsBeforeSort();
    }
    @When("user clicks on sort icon for the State field column")
    public void user_clicks_on_sort_icon_for_the_state_field_column() {
        clickSortIconState();
    }
    @Then("user able to view the field values in the sorted order for State column")
    public void user_able_to_view_the_field_values_in_the_sorted_order_for_state_column() {
        verifyStateInSortedAscendingOrder();
    }

}
