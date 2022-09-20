package Automation.StepDefinitions;

import Automation.PageObjects.FilesPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FilesStepDef extends FilesPage {

    //    Scenario: Verify column fields in '837P Files' tab
    @Given("the user is on the {string} page")
    public void the_user_is_on_the_page(String filesTabTextAct) throws InterruptedException {
        verifyUserIsOnFilesTab(filesTabTextAct);
    }
    @When("the user clicks on the 837P Files tab")
    public void the_user_clicks_on_the_837P_Files_tab() throws InterruptedException {
        clickOn837PFilesTab();
    }
    @Then("user should be able to view the following column fields under 837P Files tab")
    public void user_should_be_able_to_view_the_following_column_fields_under_837p_files_tab(DataTable fieldsList837P) throws InterruptedException {
        verifyUserAbleToSee837PColumnFields(fieldsList837P);
    }
    @Then("user should be able to view the 837P column fields search boxes")
    public void user_should_be_able_to_view_the_837p_column_fields_search_boxes() {
        verifyUserAbleToView837PColumnFieldsSearchBoxes();
    }

    //    Scenario: Verify user should be able to see the results of rows count next to the "837P Files" tab
    @Then("user should be able to see the results of rows count next to the 837PFiles Tab")
    public void user_should_be_able_to_see_the_results_of_rows_count_next_to_the_837p_files_tab() throws InterruptedException {
        validateRowCountNextTo837PFilesTab();
    }

    //    Scenario: Validate pagination functionality in '837P Files' tab
    @Given("the user applies a filter to any field in the 837P Files tab")
    public void the_user_applies_a_filter_to_any_field_in_the_837P_Files_tab() throws InterruptedException {
        applyFilterToControlNumberFieldOn837PFilesTab();
    }
    @When("the data exceeds the defined page size under 837P files tab")
    public void the_data_exceeds_the_defined_page_size_under_837P_files_tab() {
        validateTheDataExceedsTheDefinedPageSizeUnder837PFilesTab();
    }
    @Then("the user should be able to navigate through pages under 837P files tab")
    public void the_user_should_be_able_to_navigate_through_pages_under_837P_files_tab() {
        verify837PForwardNavigationThroughPages();
        verify837PBackwardNavigationThroughPages();
    }
    @Then("Page size can be defined by the User as per the given option at the bottom of the grid under 837P files tab")
    public void page_size_can_be_defined_by_the_user_as_per_the_given_option_at_the_bottom_of_the_grid_under_837P_files_tab() {
        verify837PForwardNavigationPageSizeAtTheBottomOfTheGrid();
        verify837PBackwardNavigationPageSizeAtTheBottomOfTheGrid();
    }
    @Then("the user should be able to see the page numbers as per the number of data divided by page size under 837P files tab")
    public void the_user_should_be_able_to_see_the_page_numbers_as_per_the_number_of_data_divided_by_page_size_under_837P_files_tab() {
        verify837PTotalNumberOfPagesBasedOnThePerPageRecordCount();
    }

    //    Scenario: Verify color code for Status View under '837P Files' tab
    @Then("the user should be able to see 837P {string} results with the {string} indication")
    public void the_user_should_be_able_to_see_837P_results_with_the_indication(String status, String colorCode837PExp) throws InterruptedException {
        verify837PStatusViewColorCoding(status, colorCode837PExp);
    }

    //    Scenario: Verify Sorting functionality for "File Name" column under "837P Files" tab
    @When("user enters 837P control number under search field")
    public void user_enters_837P_control_number_under_search_field() throws InterruptedException {
        enter837PControlNumberUnderSearchField();
    }

    @When("user able to view the 837P control numbers for the entered number")
    public void user_able_to_view_the_837P_control_numbers_for_the_entered_number() throws InterruptedException {
        verify837PControlNumbersForGivenRecord();
    }

    @When("user gets list of records from 837P file name column before sort")
    public void user_gets_list_of_records_from_837P_file_name_column_before_sort() {
        get837PFileNameRecordsBeforeSort();
    }

    @When("user clicks on 837P file name column to sort records in ascending order")
    public void user_clicks_on_837P_file_name_column_to_sort_records_in_ascending_order() throws InterruptedException {
        clickOn837PFileNameColumn();
    }

    @When("user should be able to view the 837P file name records in ascending order")
    public void user_should_be_able_to_view_the_837P_file_name_records_in_ascending_order() {
        verify837PFileNameColumnRecordsInAscendingOrder();
    }
    //  Scenario: Verify Sorting functionality for "Sender" column under "837P Files" tab
    @When("user gets list of records from 837P sender column before sort")
    public void user_gets_list_of_records_from_837P_sender_column_before_sort() {
        get837PSenderRecordsBeforeSort();
    }

    @When("user clicks on 837P sender column to sort records in ascending order")
    public void user_clicks_on_837P_sender_column_to_sort_records_in_ascending_order() throws InterruptedException {
        clickOn837PSenderColumn();
    }

    @When("user should be able to view the 837P sender records in ascending order")
    public void user_should_be_able_to_view_the_837P_sender_records_in_ascending_order() {
        verify837PSenderColumnRecordsInAscendingOrder();
    }

    //  Scenario: Verify Sorting functionality for "Receiver" column under "837P Files" tab
    @When("user gets list of records from 837P receiver column before sort")
    public void user_gets_list_of_records_from_837P_receiver_column_before_sort() {
        get837PReceiverRecordsBeforeSort();
    }

    @When("user clicks on 837P receiver column to sort records in ascending order")
    public void user_clicks_on_837P_receiver_column_to_sort_records_in_ascending_order() throws InterruptedException {
        clickOn837PReceiverColumn();
    }

    @When("user should be able to view the 837P receiver records in ascending order")
    public void user_should_be_able_to_view_the_837P_receiver_records_in_ascending_order() {
        verify837PReceiverColumnRecordsInAscendingOrder();
    }

    //  Scenario: Verify Sorting functionality for "Date received" column under "837P Files" tab
    @When("user gets list of records from 837P date received column before sort in descending order")
    public void user_gets_list_of_records_from_837P_date_received_column_before_sort_in_descending_order() {
        get837PDateReceivedRecordsBeforeSort();
    }

    @When("user should be able to view the 837P date received records in descending order")
    public void user_should_be_able_to_view_the_837P_date_received_records_in_descending_order() {
        verify837PDateReceivedColumnRecordsInDescendingOrder();
    }

    //  Scenario: Verify Sorting functionality for "Age(Days)" column under "837P Files" tab
    @When("user gets list of records from 837P age days column before sort in ascending order")
    public void user_gets_list_of_records_from_837P_age_days_column_before_sort_in_ascending_order() {
        get837PAgeDaysRecordsBeforeSort();
    }

    @When("user should be able to view the 837P age days records in ascending order")
    public void user_should_be_able_to_view_the_837P_age_days_records_in_ascending_order() {
        verify837PAgeDaysColumnRecordsInAscendingOrder();
    }

    //  Scenario: Verify Sorting functionality for "Status" column under "837P Files" tab
    @When("user gets list of records from 837P status column before sort")
    public void user_gets_list_of_records_from_837P_status_column_before_sort() {
        get837PStatusRecordsBeforeSort();
    }

    @When("user clicks on 837P status column to sort records in ascending order")
    public void user_clicks_on_837P_status_column_to_sort_records_in_ascending_order() throws InterruptedException {
        clickOn837PStatusColumn();
    }

    @When("user should be able to view the 837P status records in ascending order")
    public void user_should_be_able_to_view_the_837P_status_records_in_ascending_order() {
        verify837PStatusColumnRecordsInAscendingOrder();
    }

    //  Scenario: Verify Sorting functionality for "File Type" column under "837P Files" tab
    @When("user gets list of records from 837P file type column before sort")
    public void user_gets_list_of_records_from_837P_file_type_column_before_sort() {
        get837PFileTypeRecordsBeforeSort();
    }

    @When("user clicks on 837P file type column to sort records in ascending order")
    public void user_clicks_on_837P_file_type_column_to_sort_records_in_ascending_order() throws InterruptedException {
        clickOn837PFileTypeColumn();
    }

    @When("user should be able to view the 837P file type records in ascending order")
    public void user_should_be_able_to_view_the_837P_file_type_records_in_ascending_order() {
        verify837PFileTypeColumnRecordsInAscendingOrder();
    }

    //    Scenario: Verify Sorting functionality for "Control Number" column under "837P Files" tab
    @When("user enters 837P date under date received search field")
    public void user_enters_837P_date_under_date_received_search_field() throws InterruptedException {
        enter837PReceivedDateUnderSearchField();
    }

    @When("user able to view the 837P received dates for the entered date")
    public void user_able_to_view_the_837P_received_dates_for_the_entered_date() {
        verifyUserAbleToView837PReceivedDates();
    }

    @When("user gets list of records from 837P control number column before sort")
    public void user_gets_list_of_records_from_837P_control_number_column_before_sort() {
        get837PControlNumberRecordsBeforeSort();
    }

    @When("user clicks on 837P control number column to sort records in ascending order")
    public void user_clicks_on_837P_control_number_column_to_sort_records_in_ascending_order() throws InterruptedException {
        clickOn837PControlNumberColumn();
    }

    @Then("user should be able to view the 837P control number records in ascending order")
    public void user_should_be_able_to_view_the_837P_control_number_records_in_ascending_order() {
        verify837PControlNumberColumnRecordsInAscendingOrder();
    }

    //    Scenario: Verify column fields in '837I Files' tab
    @When("the user clicks on the 837I Files tab")
    public void the_user_clicks_on_the_837i_files_tab() throws InterruptedException {
        clickOn837IFilesTab();
    }
    @Then("user should be able to view the following column fields under 837I Files tab")
    public void user_should_be_able_to_view_the_following_column_fields_under_837I_files_tab(DataTable fieldsList837I) throws InterruptedException {
        verifyUserAbleToSee837IColumnFields(fieldsList837I);
    }
    @Then("user should be able to view the 837I column fields search boxes")
    public void user_should_be_able_to_view_the_837i_column_fields_search_boxes() {
        verifyUserAbleToView837IColumnFieldsSearchBoxes();
    }

    //    Scenario: Validate pagination functionality in '837I Files' tab
    @Given("the user applies a filter to any field in the 837I Files tab")
    public void the_user_applies_a_filter_to_any_field_in_the_837I_Files_tab() throws InterruptedException {
        applyFilterToControlNumberFieldOn837IFilesTab();
    }
    @When("the data exceeds the defined page size under 837I files tab")
    public void the_data_exceeds_the_defined_page_size_under_837I_files_tab() {
        validateTheDataExceedsTheDefinedPageSizeUnder837IFilesTab();
    }
    @Then("the user should be able to navigate through pages under 837I files tab")
    public void the_user_should_be_able_to_navigate_through_pages_under_837I_files_tab() {
        verify837IForwardNavigationThroughPages();
        verify837IBackwardNavigationThroughPages();
    }
    @Then("Page size can be defined by the User as per the given option at the bottom of the grid under 837I files tab")
    public void page_size_can_be_defined_by_the_user_as_per_the_given_option_at_the_bottom_of_the_grid_under_837I_files_tab() {
        verify837IForwardNavigationPageSizeAtTheBottomOfTheGrid();
        verify837IBackwardNavigationPageSizeAtTheBottomOfTheGrid();
    }
    @Then("the user should be able to see the page numbers as per the number of data divided by page size under 837I files tab")
    public void the_user_should_be_able_to_see_the_page_numbers_as_per_the_number_of_data_divided_by_page_size_under_837I_files_tab() {
        verify837ITotalNumberOfPagesBasedOnThePerPageRecordCount();
    }

    //    Scenario Outline: Verify color code for Status View under 837I files tab
    @Then("the user should be able to see 837I {string} results with the {string} indication")
    public void the_user_should_be_able_to_see_837I_results_with_the_indication(String status, String colorCode837IExp) throws InterruptedException {
        verify837IStatusViewColorCoding(status, colorCode837IExp);
    }

    //    Scenario: Verify column fields in '837D Files' tab
    @When("the user clicks on the 837D Files tab")
    public void the_user_clicks_on_the_837d_files_tab() throws InterruptedException {
        clickOn837DFilesTab();
    }
    @Then("user should be able to view the following column fields under 837D Files tab")
    public void user_should_be_able_to_view_the_following_column_fields_under_837D_files_tab(DataTable fieldsList837D) throws InterruptedException {
        verifyUserAbleToSee837DColumnFields(fieldsList837D);
    }
    @Then("user should be able to view the 837D column fields search boxes")
    public void user_should_be_able_to_view_the_837d_column_fields_search_boxes() {
        verifyUserAbleToView837DColumnFieldsSearchBoxes();
    }

    //    Scenario: Verify column fields in '999' tab
    @When("the user clicks on the 999 tab")
    public void the_user_clicks_on_the_999_tab() throws InterruptedException {
        clickOn999FilesTab();
    }
    @Then("user should be able to view the following column fields under 999 Files tab")
    public void user_should_be_able_to_view_the_following_column_fields_under_999_files_tab(DataTable fieldsList999) throws InterruptedException {
        verifyUserAbleToSee999ColumnFields(fieldsList999);
    }
    @Then("user should be able to view the 999 column fields search boxes")
    public void user_should_be_able_to_view_the_999_column_fields_search_boxes() {
        verifyUserAbleToView999ColumnFieldsSearchBoxes();
    }

    //    Scenario: Validate pagination functionality in '999 Files' tab
    @When("the data exceeds the defined page size under 999 files tab")
    public void the_data_exceeds_the_defined_page_size_under_999_files_tab() {
        validateTheDataExceedsTheDefinedPageSizeUnder999FilesTab();
    }
    @Then("the user should be able to navigate through pages under 999 files tab")
    public void the_user_should_be_able_to_navigate_through_pages_under_999_files_tab() {
        verify999ForwardNavigationThroughPages();
        verify999BackwardNavigationThroughPages();
    }
    @Then("Page size can be defined by the User as per the given option at the bottom of the grid under 999 files tab")
    public void page_size_can_be_defined_by_the_user_as_per_the_given_option_at_the_bottom_of_the_grid_under_999_files_tab() {
        verify999ForwardNavigationPageSizeAtTheBottomOfTheGrid();
        verify999BackwardNavigationPageSizeAtTheBottomOfTheGrid();
    }
    @Then("the user should be able to see the page numbers as per the number of data divided by page size under 999 files tab")
    public void the_user_should_be_able_to_see_the_page_numbers_as_per_the_number_of_data_divided_by_page_size_under_999_files_tab() {
        verify999TotalNumberOfPagesBasedOnThePerPageRecordCount();
    }

    //    Scenario Outline: Verify color code for Status View under 999 files tab
    @Then("the user should be able to see 999 {string} results with the {string} indication")
    public void the_user_should_be_able_to_see_999_results_with_the_indication(String status, String colorCode999Exp) throws InterruptedException {
        verify999StatusViewColorCoding(status, colorCode999Exp);
    }

    //    Scenario: Verify column fields in '277CA' tab
    @When("the user clicks on the 277CA tab")
    public void the_user_clicks_on_the_277CA_tab() throws InterruptedException {
        clickOn277CAFilesTab();
    }
    @Then("user should be able to view the following column fields under 277CA Files tab")
    public void user_should_be_able_to_view_the_following_column_fields_under_277CA_files_tab(DataTable fieldsList277CA) throws InterruptedException {
        verifyUserAbleToSee277CAColumnFields(fieldsList277CA);
    }
    @Then("user should be able to view the 277CA column fields search boxes")
    public void user_should_be_able_to_view_the_277ca_column_fields_search_boxes() {
        verifyUserAbleToView277CAColumnFieldsSearchBoxes();
    }

    //    Scenario: Validate pagination functionality in '277CA Files' tab
    @When("the data exceeds the defined page size under 277CA files tab")
    public void the_data_exceeds_the_defined_page_size_under_277CA_files_tab() {
        validateTheDataExceedsTheDefinedPageSizeUnder277CAFilesTab();
    }
    @Then("the user should be able to navigate through pages under 277CA files tab")
    public void the_user_should_be_able_to_navigate_through_pages_under_277CA_files_tab() {
        verify277CAForwardNavigationThroughPages();
        verify277CABackwardNavigationThroughPages();
    }
    @Then("Page size can be defined by the User as per the given option at the bottom of the grid under 277CA files tab")
    public void page_size_can_be_defined_by_the_user_as_per_the_given_option_at_the_bottom_of_the_grid_under_277CA_files_tab() {
        verify277CAForwardNavigationPageSizeAtTheBottomOfTheGrid();
        verify277CABackwardNavigationPageSizeAtTheBottomOfTheGrid();
    }
    @Then("the user should be able to see the page numbers as per the number of data divided by page size under 277CA files tab")
    public void the_user_should_be_able_to_see_the_page_numbers_as_per_the_number_of_data_divided_by_page_size_under_277CA_files_tab() {
        verify277CATotalNumberOfPagesBasedOnThePerPageRecordCount();
    }

    //    Scenario Outline: Verify color code for Status View under 277CA files tab
    @Then("the user should be able to see 277CA {string} results with the {string} indication")
    public void the_user_should_be_able_to_see_277CA_results_with_the_indication(String status, String colorCode277CAExp) throws InterruptedException {
        verify277CAStatusViewColorCoding(status, colorCode277CAExp);
    }

    //    Scenario: Validate pagination functionality in '835' tab
    @When("the user clicks on the 835 tab")
    public void the_user_clicks_on_the_835_tab() throws InterruptedException {
        clickOn835FilesTab();
    }

    @When("the data exceeds the defined page size under 835 files tab")
    public void the_data_exceeds_the_defined_page_size_under_835_files_tab() {
        validateTheDataExceedsTheDefinedPageSizeUnder835FilesTab();
    }
    @Then("the user should be able to navigate through pages under 835 files tab")
    public void the_user_should_be_able_to_navigate_through_pages_under_835_files_tab() {
        verify835ForwardNavigationThroughPages();
        verify835BackwardNavigationThroughPages();
    }
    @Then("Page size can be defined by the User as per the given option at the bottom of the grid under 835 files tab")
    public void page_size_can_be_defined_by_the_user_as_per_the_given_option_at_the_bottom_of_the_grid_under_835_files_tab() {
        verify835ForwardNavigationPageSizeAtTheBottomOfTheGrid();
        verify835BackwardNavigationPageSizeAtTheBottomOfTheGrid();
    }
    @Then("the user should be able to see the page numbers as per the number of data divided by page size under 835 files tab")
    public void the_user_should_be_able_to_see_the_page_numbers_as_per_the_number_of_data_divided_by_page_size_under_835_files_tab() {
        verify835TotalNumberOfPagesBasedOnThePerPageRecordCount();
    }

    //    Scenario Outline: Verify color code for Status View under 835 files tab
    @Then("the user should be able to see 835 {string} results with the {string} indication")
    public void the_user_should_be_able_to_see_835_results_with_the_indication(String status, String colorCode835Exp) throws InterruptedException {
        verify835StatusViewColorCoding(status, colorCode835Exp);
    }

    //    Scenario: Verify column fields in '835' tab
    @Then("user should be able to view the following column fields under 835 Files tab")
    public void user_should_be_able_to_view_the_following_column_fields_under_835_files_tab(DataTable fieldsList835) throws InterruptedException {
        verifyUserAbleToSee835ColumnFields(fieldsList835);
    }
    @Then("user should be able to view the 835 column fields search boxes")
    public void user_should_be_able_to_view_the_835_column_fields_search_boxes() {
        verifyUserAbleToView835ColumnFieldsSearchBoxes();
    }


}
