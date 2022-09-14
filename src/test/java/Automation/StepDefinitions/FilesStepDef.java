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


}
