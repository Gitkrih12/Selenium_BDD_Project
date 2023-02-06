package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

public class EopLettersPage extends SeleniumUtils {

    String tabEop = "//button[@id='nav-eop-details-tab']";
    String lstEopColumnFields = "//div[@id='nav-eop-details']//span[@ref='eText']";
    String lstEopColumnSearchFields = "//div[@id='nav-eop-details']//span[@ref='eText']//following::div[1]//input[@type='text']";
    String lblEopLettersBatchId = "(//div[@id='nav-eop-details']//following::span[@ref='eText'])[1]";
    String lstEopLettersPageBar = "//div[@id='nav-eop-details']//span[@class='ag-paging-description']";
    String lstEopLettersRecordsBar = "//div[@id='nav-eop-details']//span[@class='ag-paging-row-summary-panel']";
    String btnEopLettersNext = "//div[@id='nav-eop-details']//span[@class='ag-icon ag-icon-next']";
    String btnEopLettersPrevious = "//div[@id='nav-eop-details']//span[@class='ag-icon ag-icon-previous']";
    String txtEopBatchId = "//div[@id='nav-eop-details']//input[@aria-label='Batch ID Filter Input']";
    String eleEopBatchId = "(//div[@id='nav-eop-details']//div[@col-id='batchId']//span[@class='ag-cell-value'])[1]";
    String txtEopCheckNumber = "//div[@id='nav-eop-details']//input[@aria-label='Check Number Filter Input']";
    String eleEopCheckNumber = "(//div[@id='nav-eop-details']//div[@col-id='checkNumber']//span[@class='ag-cell-value'])[1]";
    String txtEopProviderName = "//div[@id='nav-eop-details']//input[@aria-label='Provider Name Filter Input']";
    String eleEopProviderName = "(//div[@id='nav-eop-details']//div[@col-id='providerName']//span[@class='ag-cell-value'])[1]";
    String txtEopMemberId = "//div[@id='nav-eop-details']//input[@aria-label='Member ID Filter Input']";
    String eleEopMemberId = "(//div[@id='nav-eop-details']//div[@col-id='memberId']//span[@class='ag-cell-value'])[1]";
    String txtEopMemberName = "//div[@id='nav-eop-details']//input[@aria-label='Member Name Filter Input']";
    String eleEopMemberName = "(//div[@id='nav-eop-details']//div[@col-id='memberName']//span[@class='ag-cell-value'])[1]";
    String txtEopPlanShareAmount = "//div[@id='nav-eop-details']//input[@aria-label='Plan Share Amount($) Filter Input']";
    String eleEopPlanShareAmount = "(//div[@id='nav-eop-details']//div[@col-id='planShareAmount']//span[@class='ag-cell-value'])[1]";
    String txtEopMemberShareAmount = "//div[@id='nav-eop-details']//input[@aria-label='Member Share Amt($) Filter Input']";
    String eleEopMemberShareAmount = "(//div[@id='nav-eop-details']//div[@col-id='memberShareAmount']//span[@class='ag-cell-value'])[1]";
    String txtEopDateOfCreation = "//div[@id='nav-eop-details']//input[@aria-label='Date of Creation Filter Input']";
    String eleEopDateOfCreation = "(//div[@id='nav-eop-details']//div[@col-id='dateOfCreation']//span[@class='ag-cell-value'])[1]";

    FilesPage fp = new FilesPage();
    private static String batchIdSearchRecordEopExp;
    private static String checkNumberSearchRecordEopExp;
    private static String providerNameSearchRecordEopExp;
    private static String memberIdSearchRecordEopExp;
    private static String memberNameSearchRecordEopExp;
    private static String planShareAmountSearchRecordEopExp;
    private static String memberShareAmountSearchRecordEopExp;
    private static String dateOfCreationSearchRecordEopExp;


    //    Scenario: Verify user navigates to EOP screen
    public void clickOnEopTab() throws InterruptedException {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tabEop), 30, "EOP()");
        clickElement(tabEop);
    }

    public void verifyUserNavigatedToEopScreen() throws InterruptedException {
        boolean status = explicitVisibilityOfElementLocatedWaitByXpath(lblEopLettersBatchId, 10).isDisplayed();
        System.out.println("EOP Letters screen status is: " + status);
        Assert.assertTrue(status);
    }

    //    Scenario: Verify columns fields in EOP screen
    public void verifyColumnFieldsUnderEopLettersTab(DataTable eopLetters) throws InterruptedException {
        compare2Lists(eopLetters, lstEopColumnFields);
    }

    public void verifyEopLettersColumnsSearchFields() {
//        elementsDisplayValidation(lstEopColumnSearchFields);
        scrollToElementsAndValidateDisplayStatus(lstEopColumnSearchFields);
    }

    //    Scenario: Verify results of Member rows count next to "EOP letters" tab name
    public void validateRowCountNextToEopLettersTab() throws InterruptedException {
        fp.validateRowCountNextToFilesTab(tabEop, lstEopLettersRecordsBar);
    }

    //    Scenario: Verify Pagination in EOP screen
    public void validateTheDataExceedsTheDefinedPageSizeUnderEOPLettersTab() {
        fp.validateTheDataExceedsTheDefinedPageSize(lstEopLettersRecordsBar);
    }

    public void verifyEopLettersForwardNavigationThroughPages() {
        fp.verifyForwardNavigationThroughPages(btnEopLettersNext, lstEopLettersPageBar);
    }

    public void verifyEopLettersBackwardNavigationThroughPages() {
        fp.verifyBackwardNavigationThroughPages(btnEopLettersPrevious, lstEopLettersPageBar);
    }

    public void verifyEopLettersForwardNavigationPageSizeAtTheBottomOfTheGrid() {
        fp.verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(btnEopLettersNext, lstEopLettersRecordsBar);
    }

    public void verifyEopLettersBackwardNavigationPageSizeAtTheBottomOfTheGrid() {
        fp.verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(btnEopLettersPrevious, lstEopLettersRecordsBar);
    }

    public void verifyEopLettersTotalNumberOfPagesBasedOnThePerPageRecordCount() {
        fp.verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(lstEopLettersRecordsBar, lstEopLettersPageBar);
    }

    //    Verify user should be able to get results by applying filter on "Batch ID" column under EOP tab
    public void verifyUserEntersEopBatchIdUnderSearchBox() {
        batchIdSearchRecordEopExp = prop.getProperty("EopBatchId");
        explicitElementClickableWaitByXpath(txtEopBatchId, 10).sendKeys(batchIdSearchRecordEopExp);
    }

    public void verifyUserAbleToViewEopBatchIdRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEopBatchId, batchIdSearchRecordEopExp);
    }

    //    Verify user should be able to get results by applying filter on "Check Number" column under EOP tab
    public void verifyUserEntersEopCheckNumberUnderSearchBox() {
        checkNumberSearchRecordEopExp = prop.getProperty("EopCheckNumber");
        explicitElementClickableWaitByXpath(txtEopCheckNumber, 10).sendKeys(checkNumberSearchRecordEopExp);
    }

    public void verifyUserAbleToViewEopCheckNumberRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEopCheckNumber, checkNumberSearchRecordEopExp);
    }

    //    Verify user should be able to get results by applying filter on "Provider Name" column under EOP tab
    public void verifyUserEntersEopProviderNameUnderSearchBox() {
        providerNameSearchRecordEopExp = prop.getProperty("EopProviderName");
        explicitElementClickableWaitByXpath(txtEopProviderName, 10).sendKeys(providerNameSearchRecordEopExp);
    }

    public void verifyUserAbleToViewEopProviderNameRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEopProviderName, providerNameSearchRecordEopExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member ID" column under EOP tab
    public void verifyUserEntersEopMemberIdUnderSearchBox() {
        memberIdSearchRecordEopExp = prop.getProperty("EopMemberId");
        explicitElementClickableWaitByXpath(txtEopMemberId, 10).sendKeys(memberIdSearchRecordEopExp);
    }

    public void verifyUserAbleToViewEopMemberIdRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEopMemberId, memberIdSearchRecordEopExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member Name" column under EOP tab
    public void verifyUserEntersEopMemberNameUnderSearchBox() {
        memberNameSearchRecordEopExp = prop.getProperty("EopMemberName");
        explicitElementClickableWaitByXpath(txtEopMemberName, 10).sendKeys(memberNameSearchRecordEopExp);
    }

    public void verifyUserAbleToViewEopMemberNameRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEopMemberName, memberNameSearchRecordEopExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Plan share amount($)" column under EOP tab
    public void verifyUserEntersEopPlanShareAmountUnderSearchBox() {
        planShareAmountSearchRecordEopExp = prop.getProperty("EopPlanShareAmount");
        explicitElementClickableWaitByXpath(txtEopPlanShareAmount, 10).sendKeys(planShareAmountSearchRecordEopExp);
    }

    public void verifyUserAbleToViewEopPlanShareAmountRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEopPlanShareAmount, planShareAmountSearchRecordEopExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "member share amount($)" column under EOP tab
    public void verifyUserEntersEopMemberShareAmountUnderSearchBox() {
        memberShareAmountSearchRecordEopExp = prop.getProperty("EopMemberShareAmount");
        explicitElementClickableWaitByXpath(txtEopMemberShareAmount, 10).sendKeys(memberShareAmountSearchRecordEopExp);
    }

    public void verifyUserAbleToViewEopMemberShareAmountRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEopMemberShareAmount, memberShareAmountSearchRecordEopExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under EOP tab
    public void verifyUserEntersEopCreatedDateUnderSearchBox() {
        dateOfCreationSearchRecordEopExp = prop.getProperty("EopDateOfCreation");
        scrollToElement(txtEopDateOfCreation);
        explicitElementClickableWaitByXpath(txtEopDateOfCreation, 10).sendKeys(dateOfCreationSearchRecordEopExp);
    }

    public void verifyUserAbleToViewEopCreatedDateRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEopDateOfCreation, dateOfCreationSearchRecordEopExp);
    }

}



