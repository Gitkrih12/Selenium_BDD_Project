package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

public class IdnLettersPage extends SeleniumUtils {

    String tabIdn = "//button[@id='nav-idn-details-tab']";
    String lstIdnColumnFields = "//div[@id='nav-idn-details']//span[@ref='eText']";
    String lstIdnColumnSearchFields = "//div[@id='nav-idn-details']//span[@ref='eText']//following::div[1]//input[@type='text']";
    String lblIdnBatchId = "(//div[@id='nav-idn-details']//following::span[@ref='eText'])[1]";
    String lstIdnLettersPageBar = "//div[@id='nav-idn-details']//span[@class='ag-paging-description']";
    String lstIdnLettersRecordsBar = "//div[@id='nav-idn-details']//span[@class='ag-paging-row-summary-panel']";
    String btnIdnLettersNext = "//div[@id='nav-idn-details']//span[@class='ag-icon ag-icon-next']";
    String btnIdnLettersPrevious = "//div[@id='nav-idn-details']//span[@class='ag-icon ag-icon-previous']";
    String txtIdnBatchId = "//div[@id='nav-idn-details']//input[@aria-label='Batch ID Filter Input']";
    String eleIdnBatchId = "(//div[@id='nav-idn-details']//div[@col-id='batchId']//span[@class='ag-cell-value'])[1]";
    String txtIdnClaimNumber = "//div[@id='nav-idn-details']//input[@aria-label='Claim Number Filter Input']";
    String eleIdnClaimNumber = "(//div[@id='nav-idn-details']//div[@col-id='claimNumber']//span[@class='ag-cell-value'])[1]";
    String txtIdnProviderName = "//div[@id='nav-idn-details']//input[@aria-label='Provider Name Filter Input']";
    String eleIdnProviderName = "(//div[@id='nav-idn-details']//div[@col-id='providerName']//span[@class='ag-cell-value'])[1]";
    String txtIdnMemberId = "//div[@id='nav-idn-details']//input[@aria-label='Member ID Filter Input']";
    String eleIdnMemberId = "(//div[@id='nav-idn-details']//div[@col-id='memberId']//span[@class='ag-cell-value'])[1]";
    String txtIdnMemberName = "//div[@id='nav-idn-details']//input[@aria-label='Member Name Filter Input']";
    String eleIdnMemberName = "(//div[@id='nav-idn-details']//div[@col-id='memberName']//span[@class='ag-cell-value'])[1]";
    String txtIdnDateOfCreation = "//div[@id='nav-idn-details']//input[@aria-label='Date of Creation Filter Input']";
    String eleIdnDateOfCreation = "(//div[@id='nav-idn-details']//div[@col-id='dateOfCreation']//span[@class='ag-cell-value'])[1]";

    FilesPage fp = new FilesPage();

    private static String batchIdSearchRecordIdnExp;
    private static String claimNumberSearchRecordIdnExp;
    private static String providerNameSearchRecordIdnExp;
    private static String memberIdSearchRecordIdnExp;
    private static String memberNameSearchRecordIdnExp;
    private static String dateOfCreationSearchRecordIdnExp;


    //    Scenario: Verify user able to navigate to IDN screen under Letters tab
    public void clickOnIdnTab() {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tabIdn), 30, "IDN()");
        clickElement(tabIdn);
    }

    public void verifyUserIsOnIdnScreen() {
        boolean status = explicitVisibilityOfElementLocatedWaitByXpath(lblIdnBatchId, 10).isDisplayed();
        printStatementInGreenColor("IDN screen status is ", status);
        Assert.assertTrue(status);
    }

    //    Scenario: Verify column fields under IDN screen
    public void verifyColumnFieldsUnderIdnLettersTab(DataTable idnLetters) {
        compare2Lists(idnLetters, lstIdnColumnFields);
    }

    //    Scenario: Verify column search fields under IDN screen
    public void verifyIdnLettersColumnsSearchFields() {
        elementsDisplayValidation(lstIdnColumnSearchFields);
    }

    //    Scenario: Verify results of Member rows count next to "IDN" tab name
    public void validateRowCountNextToIdnLettersTab() throws InterruptedException {
        fp.validateRowCountNextToFilesTab(tabIdn, lstIdnLettersRecordsBar);
    }

    //    Verify user should be able to get results by applying filter on "Batch ID" column under Letters IDN tab
    public void verifyUserEntersIdnBatchIdUnderSearchBox() {
        batchIdSearchRecordIdnExp = prop.getProperty("IdnBatchId");
        explicitElementClickableWaitByXpath(txtIdnBatchId, 10).sendKeys(batchIdSearchRecordIdnExp);
    }

    public void verifyUserAbleToViewIdnBatchIdRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleIdnBatchId, batchIdSearchRecordIdnExp);
    }

    //    Verify user should be able to get results by applying filter on "Claim Number" column under Letters IDN tab
    public void verifyUserEntersIdnClaimNumberUnderSearchBox() {
        claimNumberSearchRecordIdnExp = prop.getProperty("IdnClaimNumber");
        explicitElementClickableWaitByXpath(txtIdnClaimNumber, 10).sendKeys(claimNumberSearchRecordIdnExp);
    }

    public void verifyUserAbleToViewIdnClaimNumberRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleIdnClaimNumber, claimNumberSearchRecordIdnExp);
    }

    //    Verify user should be able to get results by applying filter on "Provider Name" column under Letters IDN tab
    public void verifyUserEntersIdnProviderNameUnderSearchBox() {
        providerNameSearchRecordIdnExp = prop.getProperty("IdnProviderName");
        explicitElementClickableWaitByXpath(txtIdnProviderName, 10).sendKeys(providerNameSearchRecordIdnExp);
    }

    public void verifyUserAbleToViewIdnProviderNameRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleIdnProviderName, providerNameSearchRecordIdnExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member ID" column under Letters IDN tab
    public void verifyUserEntersIdnMemberIdUnderSearchBox() {
        memberIdSearchRecordIdnExp = prop.getProperty("IdnMemberId");
        explicitElementClickableWaitByXpath(txtIdnMemberId, 10).sendKeys(memberIdSearchRecordIdnExp);
    }

    public void verifyUserAbleToViewIdnMemberIdRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleIdnMemberId, memberIdSearchRecordIdnExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Member Name" column under Letters IDN tab
    public void verifyUserEntersIdnMemberNameUnderSearchBox() {
        memberNameSearchRecordIdnExp = prop.getProperty("IdnMemberName");
        explicitElementClickableWaitByXpath(txtIdnMemberName, 10).sendKeys(memberNameSearchRecordIdnExp);
    }

    public void verifyUserAbleToViewIdnMemberNameRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleIdnMemberName, memberNameSearchRecordIdnExp);
    }

    //    Scenario: Verify user should be able to get results by applying filter on "Date of creation" column under Letters IDN tab
    public void verifyUserEntersIdnCreatedDateUnderSearchBox() {
        dateOfCreationSearchRecordIdnExp = prop.getProperty("IdnDateOfCreation");
        explicitElementClickableWaitByXpath(txtIdnDateOfCreation, 10).sendKeys(dateOfCreationSearchRecordIdnExp);
    }

    public void verifyUserAbleToViewIdnCreatedDateRecordsUnderSearchResultsSection() {
        fp.verifyUserAbleToViewRequiredRecordsUnderSearchResultsSection(eleIdnDateOfCreation, dateOfCreationSearchRecordIdnExp);
    }


}
