package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

public class EobConsolidatedLettersPage extends SeleniumUtils {

    //    EOb Consolidated Letters locators
    String mnuFileManagement = "//div[contains(text(),'File Management')]";
    String mnuLetters = "(//div[contains(text(), 'Letters')])[1]";
    String tabLetters = "(//div[contains(text(), 'Letters')])[2]";
    String tabEobConsolidated = "//button[@id='nav-eobconsolidated-details-tab']";
    String lblConsolidatedLettersMemberId = "(//button[@id='nav-eobconsolidated-details-tab']//following::span[@ref='eText'])[1]";
    String lstEobConsolidatedColumnFields = "//div[@id='nav-eobconsolidated-details']//span[@ref='eText']";
    String lstEobConsolidatedColumnSearchFields = "//div[@id='nav-eobconsolidated-details']//span[@ref='eText']//following::div[1]//input[@type='text']";
    String lstEobConsolidatedLettersPageBar = "//div[@id='nav-eobconsolidated-details']//span[@class='ag-paging-description']";
    String lstEobConsolidatedLettersRecordsBar = "//div[@id='nav-eobconsolidated-details']//span[@class='ag-paging-row-summary-panel']";
    String btnEobConsolidatedLettersNext = "//div[@id='nav-eobconsolidated-details']//span[@class='ag-icon ag-icon-next']";
    String btnEobConsolidatedLettersPrevious = "//div[@id='nav-eobconsolidated-details']//span[@class='ag-icon ag-icon-previous']";
    String txtEobConsolidatedMemberId = "//div[@id='nav-eobconsolidated-details']//input[@aria-label='Member ID Filter Input']";
    String eleEobConsolidatedMemberId = "(//div[@id='nav-eobconsolidated-details']//div[@col-id='memberId']//span[@class='ag-cell-value'])[1]";
    String txtEobConsolidatedMemberName = "//div[@id='nav-eobconsolidated-details']//input[@aria-label='Member Name Filter Input']";
    String eleEobConsolidatedMemberName = "(//div[@id='nav-eobconsolidated-details']//div[@col-id='memberName']//span[@class='ag-cell-value'])[1]";
    String txtEobConsolidatedPlanShareAmount = "//div[@id='nav-eobconsolidated-details']//input[@aria-label='Plan Share Amount($) Filter Input']";
    String eleEobConsolidatedPlanShareAmount = "(//div[@id='nav-eobconsolidated-details']//div[@col-id='planShareAmount']//span[@class='ag-cell-value'])[1]";
    String txtEobConsolidatedMemberShareAmount = "//div[@id='nav-eobconsolidated-details']//input[@aria-label='Member Share Amt($) Filter Input']";
    String eleEobConsolidatedMemberShareAmount = "(//div[@id='nav-eobconsolidated-details']//div[@col-id='memberShareAmount']//span[@class='ag-cell-value'])[1]";
    String txtEobConsolidatedDateOfCreation = "//div[@id='nav-eobconsolidated-details']//input[@aria-label='Date of Creation Filter Input']";
    String eleEobConsolidatedDateOfCreation = "(//div[@id='nav-eobconsolidated-details']//div[@col-id='dateOfCreation']//span[@class='ag-cell-value'])[1]";


    private static String memberIdSearchRecordEobConsolidatedExp;
    private static String memberNameSearchRecordEobConsolidatedExp;
    private static String planShareAmountSearchRecordEobConsolidatedExp;
    private static String memberShareAmountSearchRecordEobConsolidatedExp;
    private static String createdDateSearchRecordEobConsolidatedExp;

    FilesPage fp = new FilesPage();


    //    Scenario: Verify user navigates to EOB Consolidated screen
    public void clickOnLettersMenu(String lettersExp) {
        clickElement(mnuFileManagement);
        moveToElement(mnuLetters).perform();
        clickElement(mnuLetters);
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabLetters), 20, "Letters");
        explicitElementClickableWaitByXpath(tabLetters, 20);
        String[] letters = getText(tabLetters).split(" ");
        String lettersAct = letters[0];
        Assert.assertEquals(lettersExp, lettersAct);
    }

    public void clickOnEobConsolidatedTab() {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tabEobConsolidated), 40, "EOB-Consolidated () ");
        explicitElementClickableWaitByXpath(tabEobConsolidated, 20);
        clickElement(tabEobConsolidated);
    }

    public void verifyUserNavigatedToEobConsolidatedScreen() {
        boolean status = explicitVisibilityOfElementLocatedWaitByXpath(lblConsolidatedLettersMemberId, 10).isDisplayed();
        Assert.assertTrue(status);
    }

    //    Scenario: Verify column fields in EOB Consolidated letters page
    public void verifyColumnFieldsUnderEobConsolidatedLettersTab(DataTable eobConsolidatedLetters) {
        explicitElementClickableWaitByXpath(lstEobConsolidatedColumnFields, 10);
        compare2Lists(eobConsolidatedLetters, lstEobConsolidatedColumnFields);
    }

    public void verifyEobConsolidatedLettersColumnsSearchFields() {
        elementsDisplayValidation(lstEobConsolidatedColumnSearchFields);
    }

    //    Scenario: Verify Pagination in EOB Consolidated screen
    public void validateTheDataExceedsTheDefinedPageSizeUnderEobConsolidatedLettersTab() {
        fp.validateTheDataExceedsTheDefinedPageSize(lstEobConsolidatedLettersRecordsBar);
    }

    public void verifyEobConsolidatedLettersForwardNavigationThroughPages() {
        fp.verifyForwardNavigationThroughPages(btnEobConsolidatedLettersNext, lstEobConsolidatedLettersPageBar);
    }

    public void verifyEobConsolidatedLettersBackwardNavigationThroughPages() {
        fp.verifyBackwardNavigationThroughPages(btnEobConsolidatedLettersPrevious, lstEobConsolidatedLettersPageBar);
    }

    public void verifyEobConsolidatedLettersForwardNavigationPageSizeAtTheBottomOfTheGrid() {
        fp.verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(btnEobConsolidatedLettersNext, lstEobConsolidatedLettersRecordsBar);
    }

    public void verifyEobConsolidatedLettersBackwardNavigationPageSizeAtTheBottomOfTheGrid() {
        fp.verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(btnEobConsolidatedLettersPrevious, lstEobConsolidatedLettersRecordsBar);
    }

    public void verifyEobConsolidatedLettersTotalNumberOfPagesBasedOnThePerPageRecordCount() {
        fp.verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(lstEobConsolidatedLettersRecordsBar, lstEobConsolidatedLettersPageBar);
    }

    //    Scenario: Verify results of Member rows count next to "EOB-Consolidated letters" tab name
    public void validateRowCountNextToEobConsolidatedLettersTab() throws InterruptedException {
        fp.validateRowCountNextToFilesTab(tabEobConsolidated, lstEobConsolidatedLettersRecordsBar);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member ID" column under EOB-Consolidated tab
    public void verifyUserEntersEobConsolidatedMemberIdUnderSearchBox() {
        memberIdSearchRecordEobConsolidatedExp = prop.getProperty("EobConsolidatedMemberId");
        explicitElementClickableWaitByXpath(txtEobConsolidatedMemberId, 10).sendKeys(memberIdSearchRecordEobConsolidatedExp);
    }

    public void verifyUserAbleToViewEobConsolidatedMemberIdRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobConsolidatedMemberId, memberIdSearchRecordEobConsolidatedExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member Name" column under EOB-Consolidated tab
    public void verifyUserEntersEobConsolidatedMemberNameUnderSearchBox() {
        memberNameSearchRecordEobConsolidatedExp = prop.getProperty("EobConsolidatedMemberName");
        explicitElementClickableWaitByXpath(txtEobConsolidatedMemberName, 10).sendKeys(memberNameSearchRecordEobConsolidatedExp);
    }

    public void verifyUserAbleToViewEobConsolidatedMemberNameRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobConsolidatedMemberName, memberNameSearchRecordEobConsolidatedExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Plan share amount($)" column under EOB-Consolidated tab
    public void verifyUserEntersEobConsolidatedPlanShareAmountUnderSearchBox() {
        planShareAmountSearchRecordEobConsolidatedExp = prop.getProperty("EobConsolidatedPlanShareAmount");
        explicitElementClickableWaitByXpath(txtEobConsolidatedPlanShareAmount, 10).sendKeys(planShareAmountSearchRecordEobConsolidatedExp);
    }

    public void verifyUserAbleToViewEobConsolidatedPlanShareAmountRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobConsolidatedPlanShareAmount, planShareAmountSearchRecordEobConsolidatedExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "member share amount($)" column under EOB-Consolidated tab
    public void verifyUserEntersEobConsolidatedMemberShareAmountUnderSearchBox() {
        memberShareAmountSearchRecordEobConsolidatedExp = prop.getProperty("EobConsolidatedMemberShareAmount");
        explicitElementClickableWaitByXpath(txtEobConsolidatedMemberShareAmount, 10).sendKeys(memberShareAmountSearchRecordEobConsolidatedExp);
    }

    public void verifyUserAbleToViewEobConsolidatedMemberShareAmountRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobConsolidatedMemberShareAmount, memberShareAmountSearchRecordEobConsolidatedExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under EOB-Consolidated tab
    public void verifyUserEntersEobConsolidatedCreatedDateUnderSearchBox() {
        createdDateSearchRecordEobConsolidatedExp = prop.getProperty("EobConsolidatedDateOfCreation");
        explicitElementClickableWaitByXpath(txtEobConsolidatedDateOfCreation, 10).sendKeys(createdDateSearchRecordEobConsolidatedExp);
    }

    public void verifyUserAbleToViewEobConsolidatedCreatedDateRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobConsolidatedDateOfCreation, createdDateSearchRecordEobConsolidatedExp);
    }


}

