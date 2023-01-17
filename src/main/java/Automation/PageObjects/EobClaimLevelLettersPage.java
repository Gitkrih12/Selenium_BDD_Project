package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

public class EobClaimLevelLettersPage extends SeleniumUtils {

    String tabEobClaimLevel = "//button[@id='nav-claimlevel-details-tab']";
    String lstEobClaimLevelColumnFields = "//div[@id='nav-claimlevel-details']//span[@ref='eText']";
    String lstEobClaimLevelColumnSearchFields = "//div[@id='nav-claimlevel-details']//span[@ref='eText']//following::div[1]//input[@type='text']";
    String lblEobClaimLevelClaimNumber = "(//div[@id='nav-claimlevel-details']//following::span[@ref='eText'])[1]";
    String lstEobClaimLevelLettersPageBar = "//div[@id='nav-claimlevel-details']//span[@class='ag-paging-description']";
    String lstEobClaimLevelLettersRecordsBar = "//div[@id='nav-claimlevel-details']//span[@class='ag-paging-row-summary-panel']";
    String btnEobClaimLevelLettersNext = "//div[@id='nav-claimlevel-details']//span[@class='ag-icon ag-icon-next']";
    String btnEobClaimLevelLettersPrevious = "//div[@id='nav-claimlevel-details']//span[@class='ag-icon ag-icon-previous']";
    String txtEobClaimLevelClaimNumber = "//div[@id='nav-claimlevel-details']//input[@aria-label='Claim Number Filter Input']";
    String eleEobClaimLevelClaimNumber = "(//div[@id='nav-claimlevel-details']//div[@col-id='claimNumber']//span[@class='ag-cell-value']//a)[1]";
    String txtEobClaimLevelMemberId = "//div[@id='nav-claimlevel-details']//input[@aria-label='Member ID Filter Input']";
    String eleEobClaimLevelMemberId = "(//div[@id='nav-claimlevel-details']//div[@col-id='memberId']//span[@class='ag-cell-value'])[1]";
    String txtEobClaimLevelMemberName = "//div[@id='nav-claimlevel-details']//input[@aria-label='Member Name Filter Input']";
    String eleEobClaimLevelMemberName = "(//div[@id='nav-claimlevel-details']//div[@col-id='memberName']//span[@class='ag-cell-value'])[1]";
    String txtEobClaimLevelPlanShareAmount = "//div[@id='nav-claimlevel-details']//input[@aria-label='Plan Share Amount($) Filter Input']";
    String eleEobClaimLevelPlanShareAmount = "(//div[@id='nav-claimlevel-details']//div[@col-id='planShareAmount']//span[@class='ag-cell-value'])[1]";
    String txtEobClaimLevelMemberShareAmount = "//div[@id='nav-claimlevel-details']//input[@aria-label='Member Share Amt($) Filter Input']";
    String eleEobClaimLevelMemberShareAmount = "(//div[@id='nav-claimlevel-details']//div[@col-id='memberShareAmount']//span[@class='ag-cell-value'])[1]";
    String txtEobClaimLevelDateOfCreation = "//div[@id='nav-claimlevel-details']//input[@aria-label='Date of Creation Filter Input']";
    String eleEobClaimLevelDateOfCreation = "(//div[@id='nav-claimlevel-details']//div[@col-id='dateOfCreation']//span[@class='ag-cell-value'])[1]";

    FilesPage fp = new FilesPage();

    private static String claimNumberSearchRecordEobClaimLevelExp;
    private static String memberIdSearchRecordEobClaimLevelExp;
    private static String memberNameSearchRecordEobClaimLevelExp;
    private static String planShareAmountSearchRecordEobClaimLevelExp;
    private static String memberShareAmountSearchRecordEobClaimLevelExp;
    private static String createdDateSearchRecordEobClaimLevelExp;

    //    Scenario: Verify user navigates to EOB-Claim Level screen
    public void clickOnEobClaimLevelTab() {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tabEobClaimLevel), 30, "EOB-Claim Level()");
        clickElement(tabEobClaimLevel);
    }

    public void verifyUserNavigatedToEobClaimLevelScreen() {
        boolean status = explicitVisibilityOfElementLocatedWaitByXpath(lblEobClaimLevelClaimNumber, 10).isDisplayed();
        System.out.println("EOB claim level screen status is: " + status);
        Assert.assertTrue(status);
    }

    //    Scenario: Verify column fields in EOB-Claim Level screen
    public void verifyColumnFieldsUnderEobClaimLevelLettersTab(DataTable eobClaimLevelColumnFields) {
        compare2Lists(eobClaimLevelColumnFields, lstEobClaimLevelColumnFields);
    }

    //    Scenario: Verify column search fields under EOB claim level screen
    public void verifyEobClaimLevelLettersColumnsSearchFields() {
        elementsDisplayValidation(lstEobClaimLevelColumnSearchFields);
    }

    //    Scenario: Verify Pagination in EOB-Claim Level screen
    public void validateTheDataExceedsTheDefinedPageSizeUnderEobClaimLevelLettersTab() {
        fp.validateTheDataExceedsTheDefinedPageSize(lstEobClaimLevelLettersRecordsBar);
    }

    public void verifyEobClaimLevelLettersForwardNavigationThroughPages() {
        fp.verifyForwardNavigationThroughPages(btnEobClaimLevelLettersNext, lstEobClaimLevelLettersPageBar);
    }

    public void verifyEobClaimLevelLettersBackwardNavigationThroughPages() {
        fp.verifyBackwardNavigationThroughPages(btnEobClaimLevelLettersPrevious, lstEobClaimLevelLettersPageBar);
    }

    public void verifyEobClaimLevelLettersForwardNavigationPageSizeAtTheBottomOfTheGrid() {
        fp.verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(btnEobClaimLevelLettersPrevious, lstEobClaimLevelLettersPageBar);
    }

    public void verifyEobClaimLevelLettersBackwardNavigationPageSizeAtTheBottomOfTheGrid() {
        fp.verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(btnEobClaimLevelLettersPrevious, lstEobClaimLevelLettersPageBar);
    }

    public void verifyEobClaimLevelLettersTotalNumberOfPagesBasedOnThePerPageRecordCount() {
        fp.verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(lstEobClaimLevelLettersRecordsBar, lstEobClaimLevelLettersPageBar);
    }

    //    Scenario: Verify results of Member rows count next to "EOB-Claim Level" tab name
    public void validateRowCountNextToEobClaimLevelLettersTab() throws InterruptedException {
        fp.validateRowCountNextToFilesTab(tabEobClaimLevel, lstEobClaimLevelLettersRecordsBar);
    }

    //    Verify user should be able to get results by applying filter on "Claim Number" column under EOB-Claim level tab
    public void verifyUserEntersEobClaimLevelClaimNumberUnderSearchBox()
    {
        claimNumberSearchRecordEobClaimLevelExp = prop.getProperty("EobClaimLevelClaimNumber");
        explicitElementClickableWaitByXpath(txtEobClaimLevelClaimNumber, 10).sendKeys(claimNumberSearchRecordEobClaimLevelExp);
    }
    public void verifyUserAbleToViewEobClaimLevelClaimNumberRecordsUnderSearchResultsSection()
    {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobClaimLevelClaimNumber, claimNumberSearchRecordEobClaimLevelExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member ID" column under EOB-Claim level tab
    public void verifyUserEntersEobClaimLevelMemberIdUnderSearchBox()
    {
        memberIdSearchRecordEobClaimLevelExp = prop.getProperty("EobClaimLevelMemberId");
        explicitElementClickableWaitByXpath(txtEobClaimLevelMemberId, 10).sendKeys(memberIdSearchRecordEobClaimLevelExp);
    }
    public void verifyUserAbleToViewEobClaimLevelMemberIdRecordsUnderSearchResultsSection()
    {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobClaimLevelMemberId, memberIdSearchRecordEobClaimLevelExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member Name" column under EOB-Claim level tab
    public void verifyUserEntersEobClaimLevelMemberNameUnderSearchBox()
    {
        memberNameSearchRecordEobClaimLevelExp = prop.getProperty("EobClaimLevelMemberName");
        explicitElementClickableWaitByXpath(txtEobClaimLevelMemberName, 10).sendKeys(memberNameSearchRecordEobClaimLevelExp);
    }
    public void verifyUserAbleToViewEobClaimLevelMemberNameRecordsUnderSearchResultsSection()
    {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobClaimLevelMemberName, memberNameSearchRecordEobClaimLevelExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Plan share amount($)" column under EOB-Claim level tab
    public void verifyUserEntersEobClaimLevelPlanShareAmountUnderSearchBox()
    {
        planShareAmountSearchRecordEobClaimLevelExp = prop.getProperty("EobClaimLevelPlanShareAmount");
        explicitElementClickableWaitByXpath(txtEobClaimLevelPlanShareAmount, 10).sendKeys(planShareAmountSearchRecordEobClaimLevelExp);
    }
    public void verifyUserAbleToViewEobClaimLevelPlanShareAmountRecordsUnderSearchResultsSection()
    {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobClaimLevelPlanShareAmount, planShareAmountSearchRecordEobClaimLevelExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "member share amount($)" column under EOB-Claim level tab
    public void verifyUserEntersEobClaimLevelMemberShareAmountUnderSearchBox()
    {
        memberShareAmountSearchRecordEobClaimLevelExp = prop.getProperty("EobClaimLevelMemberShareAmount");
        explicitElementClickableWaitByXpath(txtEobClaimLevelMemberShareAmount, 10).sendKeys(memberShareAmountSearchRecordEobClaimLevelExp);
    }
    public void verifyUserAbleToViewEobClaimLevelMemberShareAmountRecordsUnderSearchResultsSection()
    {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobClaimLevelMemberShareAmount, memberShareAmountSearchRecordEobClaimLevelExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under EOB-Claim level tab
    public void verifyUserEntersEobClaimLevelCreatedDateUnderSearchBox()
    {
        createdDateSearchRecordEobClaimLevelExp = prop.getProperty("EobClaimLevelDateOfCreation");
        explicitElementClickableWaitByXpath(txtEobClaimLevelDateOfCreation, 10).sendKeys(createdDateSearchRecordEobClaimLevelExp);
    }
    public void verifyUserAbleToViewEobClaimLevelCreatedDateRecordsUnderSearchResultsSection()
    {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleEobClaimLevelDateOfCreation, createdDateSearchRecordEobClaimLevelExp);
    }


}
