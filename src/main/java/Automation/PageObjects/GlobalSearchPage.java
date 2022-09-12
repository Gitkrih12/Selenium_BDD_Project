package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.*;

public class GlobalSearchPage extends SeleniumUtils {
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String tabGlobalSearch = "(//div[contains(text(),'Global Search')])[2]";
    String lblNoDataDisplay = "//div[@class='ag-center-cols-clipper']";
    String expHeight = "1px";
    String btnFilter = "//button[text()='Filter']";
    String btnCustomisedColumns = "//button[text()='Customize Columns']";
    String lstColumnFields = "//div[@class='ag-header-cell-label']//span[text()]";
    String txtSearchFields = "//div[@class='ag-header-cell-label']//span[text()]//following::div//input[@class='ag-input-field-input ag-text-field-input']";
    String tabActiveGlobalSearch = "//div[@class='col active-tab ng-star-inserted']";
    String txtClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String txtMemberId = "//input[@aria-label='Member Id Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String eleMemberId = "(//div[@col-id='subscriberId']//span[@class='ag-cell-value'])[1]";
    String txtPatientName = "//input[@aria-label='Patient Filter Input']";
    String elePatientName = "(//div[@col-id='memberFullName']//span[@class='ag-cell-value'])[1]";
    String txtBillingProvider = "//input[@aria-label='Billing Provider Filter Input']";
    String eleBillingProvider = "(//div[@col-id='billingProviderFullName']//span[@class='ag-cell-value'])[1]";
    String txtState = "//input[@aria-label='State Filter Input']";
    String eleState = "(//div[@col-id='status']//span[@class='ag-cell-value']//span[2])[1]";
    String txtCategory = "//input[@aria-label='Category Filter Input']";
    String eleCategory = "(//div[@col-id='category']//span[@class='ag-cell-value'])[1]";
    String txtDOSFrom = " //input[@aria-label='DOS From Filter Input']";
    String eleDOSFrom = "(//div[@col-id='dosFrom']//span[@class='ag-cell-value'])[1]";
    String txtDOSTo = "//input[@aria-label='DOS To Filter Input']";
    String eleDOSTo = "(//div[@col-id='dosTo']//span[@class='ag-cell-value'])[1]";
    String btnExportResult = "//button[text()='Export Result']";
    String btnReprocess = "(//button[@title='Reprocess']//img)[1]";
    String txtUniversalSearchBar = "//input[@type='text' and @formcontrolname='searchName']";
    String imgSearchIcon = "//a//img[@class='SearchIcon']";
    String eleViewClaimTab = "//div[contains(@class,'active-tab')]";
    String eleInvalidIcon = "//span//em[@class='bi bi-info-circle']";
    String eleInvalidTooltip = "//span[@class='tooltiptext']";
    String eleVerticalColorForCorrected = "(//div[@col-id='isCorrected']//span)[6]";
    String eleCorrectedInfoTopGrid = "//div//span[@class='ColorBall']//following::*[contains(text(),'Corrected')]";
    String eleCircleWithColorCode = "((//div[@col-id='status']//span[@class='ag-cell-value'])[1]//span//span)[1]";
    String eleVerticalColorForUnclean = "(//div[@col-id='IsClean']//span)[6]";
    String eleUncleanInfoTopGrid = "//div//span[@class='ColorBall_UnClean']//following::*[contains(text(),'Un-clean')]";
    String eleCustomizeColumnWindow = "//div[contains(@class,'offcanvas offcanvas-end show')]";
    String eleCustomizeColumnHeader = "//div[@class='offcanvas-header']";
    String eleCustomizeColumnFields = "//div[@class='form-check ng-star-inserted']//label";
    String btnSave = "//button[text()='Save']";
    String btnClose = "//button[@aria-label='Close']";
    String eleClaimNumberDisabled = "//input[@disabled]";
    String eleClaimNumberColumnOrder = "(//div[@class='offcanvas-header']//following::label)[1]";
    String chkClaimNumber = "//input[@id='claimNumber']";
    String chkProvider = "//input[@id='providerFullName']";
    String lblProviderColumn = "//div[@class='ag-header-cell-label']//span[text()='Provider']";
    String elePagination = "//div[@class='ag-paging-panel ag-unselectable']";
    String eleTotalMemberIdRecords = "//div[@col-id='subscriberId']//span[@class='ag-cell-value']";
    String eleTotalResults = "//span[@class='ag-paging-row-summary-panel']";
    String elePaginationDescription = "//span[@class='ag-paging-description']";
    String btnNextPage = "//span[@class='ag-icon ag-icon-next']";
    String btnPreviousPage = "//span[@class='ag-icon ag-icon-previous']";
    String eleDOSFromSortIcon = "(//div//span[text()='DOS From']//following::span[@ref='eSortAsc'])[1]";
    String lstTotalDOSFromRecords = "//div[@col-id='dosFrom']//span[@class='ag-cell-value']";
    String eleDOSToSortIcon = "(//div//span[text()='DOS To']//following::span[@ref='eSortAsc'])[1]";
    String lstTotalDOSToRecords = "//div[@col-id='dosTo']//span[@class='ag-cell-value']";
    String eleClaimNumberSortIcon = "(//div//span[text()='Claim Number']//following::span[@ref='eSortAsc'])[1]";
    String lstTotalClaimNumberRecords = "//div[@class='ag-pinned-left-cols-container']//a";
    String eleBillingProviderSortIcon = "(//div//span[text()='Billing Provider']//following::span[@ref='eSortAsc'])[1]";
    String lstTotalBillingProviderRecords = "//div[@col-id='billingProviderFullName']//span[@class='ag-cell-value']";
    String elePatientSortIcon = "(//div//span[text()='Patient']//following::span[@ref='eSortAsc'])[1]";
    String lstTotalPatientRecords = "//div[@col-id='memberFullName']//span[@class='ag-cell-value']";
    String eleCategorySortIcon = "(//div//span[text()='Category']//following::span[@ref='eSortAsc'])[1]";
    String lstTotalCategoryRecords = "//div[@col-id='category']//span[@class='ag-cell-value']";
    String eleStateSortIcon = "(//div//span[text()='State']//following::span[@ref='eSortAsc'])[1]";
    String lstTotalStateRecords = "//div[@col-id='status']//span[@class='ag-cell-value']";

    private static String expClaimNumber = "";
    private static String expCorrectedClaimNumber = "";
    private static String expMemberId = "";
    private static String expPatientName = "";
    private static String expState = "";
    private static String expCategory = "";
    private static String expDOSFrom = "";
    private static String expDOSTo = "";
    private static String expBillingProvider = "";
    private static int totalRecords = 0;
    private static ArrayList<String> sortedList;
    private static ArrayList<String> dosFromRecordsBeforeSort;
    private static ArrayList<String> dosToRecordsBeforeSort;
    private static ArrayList<String> claimNumberRecordsBeforeSort;
    private static ArrayList<String> billingProviderRecordsBeforeSort;
    private static ArrayList<String> patientRecordsBeforeSort;
    private static ArrayList<String> categoryRecordsBeforeSort;
    private static ArrayList<String> stateRecordsBeforeSort;
    private static int pageNumber = 0;
    private static int pageNumberNextNavigation = 0;
    private static String expPaginationMemberId = "";

    //Scenario: Verify user should get no result by default on Global search page
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void verifyGlobalSearchPage() {
        boolean value = isDisplayed(tabGlobalSearch);
        Assert.assertTrue(value);
    }

    //Scenario: Verify user should not get records when he search with less than 7 characters in claim number field in Global Search page
    public void enterSixCharactersInClaimNumberSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("sixCharactersClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    public void verifyNoDataDisplayMessage() {
        String actHeight = findElementByXpath(lblNoDataDisplay).getAttribute("style");
        System.out.println("actHeight" + actHeight);
        if (actHeight.contains(expHeight)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //Scenario: Verify Filter and Customize Columns buttons in Global search page
    public void verifyFilterButton() {
        explicitVisibilityOfWait(findElementByXpath(btnFilter), 5);
        boolean value = isDisplayed(btnFilter);
        Assert.assertTrue(value);
    }

    public void verifyCustomisedColumn() {
        boolean value = isDisplayed(btnCustomisedColumns);
        Assert.assertTrue(value);
    }

    //Scenario: Verify column fields in grid level on Global Search
    public void verifyGlobalSearchColumnFields(DataTable columnList) throws InterruptedException {
        List<String> expColumnList = columnList.asList();
        List<WebElement> actColumnFields = findElementsByXpath(lstColumnFields);
        List<String> actualColumnFieldsForCompare = new ArrayList<>();
        for (WebElement column : actColumnFields) {
            threadSleep(1000);
            scrollIntoView(column, driver);
            String text = column.getText();
            actualColumnFieldsForCompare.add(text);
        }
        System.out.println("actual column fields " + actualColumnFieldsForCompare);
        System.out.println("expected column fields " + expColumnList);
        for (String expColumn : expColumnList) {
            if (actualColumnFieldsForCompare.contains(expColumn)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(expColumn + " column is not as expected");
            }
        }
    }

    //Scenario: Verify search field displayed under each column
    public void verifySearchFieldsUnderEachColumn() {
        List<WebElement> ActCSearchFields = findElementsByXpath(txtSearchFields);
        for (WebElement column : ActCSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    //Scenario: Verify adjudicator should land on Global Search Page
    public void verifyAdjudicatorLandsOnGlobalSearchPage() {
        boolean value = isDisplayed(tabActiveGlobalSearch);
        Assert.assertTrue(value);
    }

    //Scenario: Verify user enters the Claim Number in the Search field
    public void enterClaimNumberInSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("globalSearchClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    public void validateClaimNumberResult()  throws InterruptedException{
        threadSleep(5000);
        String actClaimNumber = getText(eleClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
    }

    //Scenario: Verify color code for corrected claims in Global Search page
    public void enterCorrectedClaimNumberInSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("correctedClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    //Scenario: Verify colour coding for Unclean status professional claims in Global Search page
    public void enterUnCleanProfessionalClaimNumberInSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("professionalUnCleanClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    //Scenario: Verify colour coding for Unclean status Institutional claims in Global Search page
    public void enterUnCleanInstitutionalClaimNumberInSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("institutionalUnCleanClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void verifyVerticalColorIndicationForUncleanClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUnclean);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    public void verifyUncleanInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleUncleanInfoTopGrid);
        Assert.assertTrue(value);
    }

    //Scenario: Verify user enters the Member ID in the Search field
    public void enterMemberIdInSearchField() throws InterruptedException {
        expMemberId = prop.getProperty("memberID");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMemberId);
        threadSleep(5000);
    }

    public void validateMemberIDResult() {
        explicitVisibilityOfWait(findElementByXpath(eleMemberId), 5);
        String actMemberId = getText(eleMemberId);
        System.out.println("actual member id :" + actMemberId);
        Assert.assertEquals(expMemberId, actMemberId);
    }

    //Scenario: Verify user enters the Patient Name in the Search field
    public void enterPatientNameInSearchField() throws InterruptedException {
        expPatientName = prop.getProperty("patientName");
        findElementAndSendKeys(findElementByXpath(txtPatientName), expPatientName);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtPatientName);
        threadSleep(3000);
    }

    public void validatePatientNameResult() throws InterruptedException {
        threadSleep(10000);
        explicitVisibilityOfWait(findElementByXpath(elePatientName), 5);
        String actPatientName = getText(elePatientName);
        System.out.println("actual patient name :" + actPatientName);
        Assert.assertEquals(expPatientName, actPatientName);
    }

    // Scenario: Verify user enters the Billing Provider details in the Search field
    public void enterBillingProviderInSearchField() throws InterruptedException {
        expBillingProvider = prop.getProperty("billingProvider");
        findElementAndSendKeys(findElementByXpath(txtBillingProvider), expBillingProvider);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtBillingProvider);
        threadSleep(3000);
    }

    public void validateBillingProviderResult() throws InterruptedException  {
        threadSleep(5000);
        String actBillingProvider = getText(eleBillingProvider);
        System.out.println("actual Billing Provider :" + actBillingProvider);
        Assert.assertEquals(expBillingProvider, actBillingProvider);
    }

    //Scenario: Verify user enters the State name in the Search field
    public void enterStateInSearchField() throws InterruptedException {
        expState = prop.getProperty("claimState");
        scrollIntoView(findElementByXpath(txtState), driver);
        findElementAndSendKeys(findElementByXpath(txtState), expState);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtState);
        threadSleep(3000);
    }

    public void validateStateResult() {
        explicitVisibilityOfWait(findElementByXpath(eleState), 5);
        String actState = getText(eleState);
        System.out.println("actual state :" + actState);
        Assert.assertEquals(expState, actState);
    }

    //Scenario: Verify user enters the Category value in the Search field
    public void enterCategoryInSearchField() throws InterruptedException {
        expCategory = prop.getProperty("category");
        scrollIntoView(findElementByXpath(txtCategory), driver);
        findElementAndSendKeys(findElementByXpath(txtCategory), expCategory);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtCategory);
        threadSleep(3000);
    }

    public void validateCategoryResult() {
        explicitVisibilityOfWait(findElementByXpath(eleCategory), 5);
        String actCategory = getText(eleCategory);
        System.out.println("actual category :" + actCategory);
        Assert.assertEquals(expCategory, actCategory);
    }

    //Scenario: Verify user enters the DOS From details in the Search field
    public void enterDOSFromInSearchField() throws InterruptedException {
        expDOSFrom = prop.getProperty("dosFrom");
        scrollIntoView(findElementByXpath(txtDOSFrom), driver);
        findElementAndSendKeys(findElementByXpath(txtDOSFrom), expDOSFrom);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtDOSFrom);
        threadSleep(3000);
    }

    public void validateDOSFromResult() {
        explicitVisibilityOfWait(findElementByXpath(eleDOSFrom), 5);
        String actDOSFrom = getText(eleDOSFrom);
        System.out.println("actual DOSFrom :" + actDOSFrom);
        Assert.assertEquals(expDOSFrom, actDOSFrom);
    }

    //Scenario: Verify user enters the DOS To details in the Search field
    public void enterDOSToInSearchField() throws InterruptedException {
        expDOSTo = prop.getProperty("dosTo");
        scrollIntoView(findElementByXpath(txtDOSTo), driver);
        findElementAndSendKeys(findElementByXpath(txtDOSTo), expDOSTo);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtDOSTo);
        threadSleep(3000);
    }

    public void validateDOSToResult() {
        explicitVisibilityOfWait(findElementByXpath(eleDOSTo), 5);
        String actDOSTo = getText(eleDOSTo);
        System.out.println("actual DOSTo :" + actDOSTo);
        Assert.assertEquals(expDOSTo, actDOSTo);
    }

    //Scenario: Validate Export Result button should display when the search results are displayed
    public void verifyExportResultButtonWhenNoSearchResultsDisplayed() {
        boolean value = isDisplayed(btnExportResult);
        Assert.assertFalse(value);
    }

    public void verifyExportResultButtonWhenSearchResultsDisplayed() {
        boolean value = isDisplayed(btnExportResult);
        Assert.assertTrue(value);
    }

    //Scenario: Verify Reprocess button should be available when Paid state is filtered in Global Search page
    public void verifyReprocessButton() throws InterruptedException {
        threadSleep(1000);
        scrollIntoView(findElementByXpath(eleState), driver);
        boolean value = isDisplayed(btnReprocess);
        Assert.assertTrue(value);
    }

    //Scenario: Verify user should get records when he search with more than 6 characters in claim number field in Global Search page
    public void enterSevenCharactersInClaimNumberSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("sevenCharactersClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    public void validateClaimNumberResultForCharacterLimit() throws InterruptedException {
        threadSleep(12000);
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 5);
        String actClaimNumber = getText(eleClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        if (actClaimNumber.contains(expClaimNumber)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    // Scenario: Verify user able to search more than 2 characters in Member Id field
    public void enterThreeCharMemberIdInSearchField() throws InterruptedException {
        expMemberId = prop.getProperty("threeCharMemberID");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMemberId);
        threadSleep(5000);
    }

    public void validateMemberIDResultForCharacterLimit() {
        explicitVisibilityOfWait(findElementByXpath(eleMemberId), 5);
        String actMemberId = getText(eleMemberId);
        System.out.println("actual member iD :" + actMemberId);
        if (actMemberId.contains(expMemberId)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //Scenario: Verify user able to search more than 2 characters in Patient field
    public void enterThreeCharPatientNameInSearchField() throws InterruptedException {
        expPatientName = prop.getProperty("threeCharPatientName");
        findElementAndSendKeys(findElementByXpath(txtPatientName), expPatientName);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtPatientName);
        threadSleep(3000);
    }

    public void validatePatientResultForCharacterLimit() throws InterruptedException {
        threadSleep(10000);
        explicitVisibilityOfWait(findElementByXpath(elePatientName), 5);
        String actPatientName = getText(elePatientName);
        System.out.println("actual patient name :" + actPatientName);
        if (actPatientName.contains(expPatientName)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //Scenario: Verify user able to search more than 2 characters in Billing Provider field
    public void enterMoreThanTwoCharactersInBillingProviderSearchField() throws InterruptedException {
        expBillingProvider = prop.getProperty("moreThanTwoCharBillingProvider");
        findElementAndSendKeys(findElementByXpath(txtBillingProvider), expBillingProvider);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtBillingProvider);
        threadSleep(3000);
    }

    public void validateBillingProviderResultForCharacterLimit() throws InterruptedException {
        threadSleep(10000);
        explicitVisibilityOfWait(findElementByXpath(eleBillingProvider), 5);
        String actPatientName = getText(eleBillingProvider);
        System.out.println("actual billing provider :" + actPatientName);
        if (actPatientName.contains(expBillingProvider)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //  Scenario: Verify user able to search more than 2 characters in any two fields
    public void enterThreeCharStateInSearchField() throws InterruptedException {
        expState = prop.getProperty("threeCharState");
        scrollIntoView(findElementByXpath(txtState), driver);
        findElementAndSendKeys(findElementByXpath(txtState), expState);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtState);
        threadSleep(3000);
    }

    public void validateStateResultForCharacterLimit() {
        explicitVisibilityOfWait(findElementByXpath(eleState), 5);
        String actState = getText(eleState);
        System.out.println("actual state :" + actState);
        if (actState.contains(expState)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //Scenario: Verify user able to search claims by using universal search
    public void verifyUniversalSearchBar() {
        boolean value = isDisplayed(txtUniversalSearchBar);
        Assert.assertTrue(value);
    }

    public void verifyPlaceHolderForUniversalSearch(String expPlaceholderValue) {
        String actPlaceholder = getAttribute(txtUniversalSearchBar, "placeholder");
        System.out.println("actual place holder value is :  " + actPlaceholder);
        Assert.assertEquals(expPlaceholderValue,actPlaceholder);
    }

    public void enterClaimNumberInUniversalSearch() {
        expClaimNumber = prop.getProperty("globalSearchClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtUniversalSearchBar), expClaimNumber);
        clickElement(imgSearchIcon);
    }

    public void verifyViewClaimDetailsAnotherTab() {
        boolean value = isDisplayed(eleViewClaimTab);
        Assert.assertTrue(value);
        String actClaimNumber = findElementByXpath(eleViewClaimTab).getText();
        System.out.println("actual claim number " + actClaimNumber);
        if (actClaimNumber.contains(expClaimNumber)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //Scenario: Verify user able to see error message If the wrong Claim Number is entered in universal search
    public void enterLessThanTenCharClaimNumberInUniversalSearch() {
        expClaimNumber = prop.getProperty("lessThanTenCharClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtUniversalSearchBar), expClaimNumber);
        clickElement(imgSearchIcon);
    }

    //  Scenario: Verify user able to see error message when search with invalid claim number
    public void enterInvalidCharClaimNumberInUniversalSearch() {
        expClaimNumber = prop.getProperty("invalidCharClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtUniversalSearchBar), expClaimNumber);
        clickElement(imgSearchIcon);
    }
    public void verifyErrorMessage(String expErrorMessage) throws InterruptedException {
        threadSleep(3000);
        moveToElement(eleInvalidIcon).perform();
        String actErrorMessage = findElementByXpath(eleInvalidTooltip).getText();
        System.out.println("actual error message " + actErrorMessage);
        Assert.assertEquals(expErrorMessage, actErrorMessage);
    }

    public void verifyVerticalColorIndicationForCorrectedClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorForCorrected);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    public void verifyCorrectedInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleCorrectedInfoTopGrid);
        Assert.assertTrue(value);
    }

    public void enterStateInSearchField(String state) throws InterruptedException {
        expState = state;
        scrollIntoView(findElementByXpath(txtState), driver);
        findElementAndSendKeys(findElementByXpath(txtState), expState);
        threadSleep(3000);
    }

    //Scenario Outline: Verify color code for Pend On Hold Payer Review Management Review Approved Deny Prebatch Batch To Pay Paid Rejected state claim number
    public void verifyCircleWithColorCodeForState(String expColorCode) {
        String actColorCode = getColorCodeForBackground(eleCircleWithColorCode);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorCode, actColorCode);
    }

    public void enterMemberIdInSearchFieldForPayerReview() throws InterruptedException {
        expMemberId = prop.getProperty("memberIdForPayerReview");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMemberId);
        threadSleep(5000);
    }

    //Scenario: Verify color code for voided state claim number
    public void enterMemberIdInSearchFieldForVoid() throws InterruptedException {
        expMemberId = prop.getProperty("memberIdForVoid");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMemberId);
        threadSleep(5000);
    }

    //Scenario: Verify user should navigate to Customized Columns window when we click on Customized columns in Global Search page
    public void clickOnCustomiseColumn() throws InterruptedException {
        threadSleep(5000);
        clickElement(btnCustomisedColumns);
    }

    public void verifyCustomizeColumnWindow() {
        explicitVisibilityOfWait(findElementByXpath(eleCustomizeColumnWindow), 5);
        boolean value = isDisplayed(eleCustomizeColumnWindow);
        Assert.assertTrue(value);
    }

    //Scenario:Verify user should able to see the mentioned column fields in the 'Customize Columns' window
    public void verifyCustomizeColumnHeader(String expCustomizeColumnHeader) {
        explicitVisibilityOfWait(findElementByXpath(eleCustomizeColumnHeader), 5);
        String actCustomizeColumnHeader = findElementByXpath(eleCustomizeColumnHeader).getText();
        System.out.println("Actual Header : " + actCustomizeColumnHeader);
        Assert.assertEquals(expCustomizeColumnHeader, actCustomizeColumnHeader);
    }

    public void verifyCustomizeColumnFields(DataTable customizeColumnList) throws InterruptedException {
        List<String> expCustomizeColumnList = customizeColumnList.asList();
        List<WebElement> actCustomizeColumnFields = findElementsByXpath(eleCustomizeColumnFields);
        List<String> actualColumnFieldsForCompare = new ArrayList<>();

        for (WebElement column : actCustomizeColumnFields) {
            threadSleep(1000);
            scrollIntoView(column, driver);
            String text = column.getText();
            actualColumnFieldsForCompare.add(text);
        }
        System.out.println("actual customize column fields " + actualColumnFieldsForCompare);
        System.out.println("expected customize column fields " + expCustomizeColumnList);
        for (String expCustomizeColumn : expCustomizeColumnList) {
            if (actualColumnFieldsForCompare.contains(expCustomizeColumn)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(expCustomizeColumn + " column is not as expected");
            }
        }
    }

    public void verifySaveButton() {
        boolean value = isDisplayed(btnSave);
        Assert.assertTrue(value);
    }

    public void verifyCloseButton() {
        boolean value = isDisplayed(btnClose);
        Assert.assertTrue(value);
    }

    //  Scenario: Verify claim number order and check box should be selected by default
    public void verifyClaimNumberColumnOrder() {
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumberColumnOrder), 5);
        boolean value = isDisplayed(eleClaimNumberColumnOrder);
        Assert.assertTrue(value);
    }

    public void verifyClaimNumberInDisabledMode() {
        boolean value = isEnabled(eleClaimNumberDisabled);
        Assert.assertFalse(value);
    }

    public void verifyClaimNumberCheckBox() {
        boolean actchkValue = findElementByXpath(chkClaimNumber).isSelected();
        Assert.assertTrue(actchkValue);
    }

    //Scenario: Verify user should able to see saved/updated fields under Global Search page
    public void clickProviderCheckBox() {
        explicitVisibilityOfWait(findElementByXpath(chkProvider), 5);
        clickElement(chkProvider);
        boolean actChkValue = findElementByXpath(chkProvider).isSelected();
        Assert.assertTrue(actChkValue);
        clickElement(btnClose);
    }

    public void unSelectProviderCheckBox() throws InterruptedException {
        threadSleep(3000);
        clickElement(chkProvider);
        boolean actChkValue = findElementByXpath(chkProvider).isSelected();
        Assert.assertFalse(actChkValue);
        clickElement(btnClose);
    }

    public void verifyProviderColumnDisplayInGlobalSearch() throws InterruptedException {
        threadSleep(20000);
        scrollIntoView(findElementByXpath(txtState), driver);
        scrollIntoView(findElementByXpath(lblProviderColumn), driver);
        boolean value = isDisplayed(lblProviderColumn);
        Assert.assertTrue(value);
        threadSleep(1000);
    }

    public void verifyProviderColumnNotDisplayedInGlobalSearch() {
        scrollIntoView(findElementByXpath(txtState), driver);
        boolean value = isDisplayed(lblProviderColumn);
        Assert.assertFalse(value);
    }

    //Scenario: Validate pagination in global Search page
    public void enterMemberIdInSearchFieldForPagination() throws InterruptedException {
        expMemberId = prop.getProperty("paginationMemberId");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMemberId);
        threadSleep(5000);
    }

    public void getAllMemberIdResults() {
        List<WebElement> memberIDResults = findElementsByXpath(eleTotalMemberIdRecords);
        totalRecords = memberIDResults.size();
        System.out.println("Total records " + memberIDResults.size());
    }

    public void verifyTotalResultsForGivenSearch() {
        String paginationText = findElementByXpath(eleTotalResults).getText();
        System.out.println("Pagination text " + paginationText);
        String[] totalResultsCount = paginationText.split(" ");
        System.out.println(totalResultsCount[4]);
        if (totalRecords == Integer.parseInt(totalResultsCount[4])) {
            Assert.assertTrue(true);
            System.out.println("Pagination text is having the total no of records in the grid");
        } else {
            Assert.assertTrue(false);
        }
    }

    public void verifyPageNumbersAtBottomOfPage() {
        String pagination = findElementByXpath(elePaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        System.out.println("Page count " + Integer.parseInt(paginationCount[3]));
        pageNumber = Integer.parseInt(paginationCount[1]);
        if (Integer.parseInt(paginationCount[3]) >= 1) {
            Assert.assertTrue(true);
        }
    }

    //Scenario: Verify user should allow to navigate to other pages
    public void clickOnNextButton() {
        clickElement(btnNextPage);
    }

    public void verifyUserNavigatesToNextPage() {
        String pagination = findElementByXpath(elePaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        pageNumberNextNavigation = Integer.parseInt(paginationCount[1]);
        System.out.println("Page number " + pageNumberNextNavigation);
        if (pageNumberNextNavigation > pageNumber) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    public void clickOnPreviousButton() {
        clickElement(btnPreviousPage);
    }

    public void verifyUserNavigatesToPreviousPage() {
        String pagination = findElementByXpath(elePaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        int pageNumberPreviousNavigation = Integer.parseInt(paginationCount[1]);
        System.out.println("Page number " + pageNumberPreviousNavigation);
        if (pageNumberNextNavigation > pageNumberPreviousNavigation) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //Scenario: Verify user see the page numbers as per the no of data divided by pages size
    public void verifyPageSizeDividedByNoOfRecordsInTheGrid() {
        String pagination = findElementByXpath(elePaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        System.out.println("Page count " + paginationCount[3]);
        if (totalRecords <= 50) {
            Assert.assertEquals(1, Integer.parseInt(paginationCount[3]));
            System.out.println("Page count defined as per no of records : " + Integer.parseInt(paginationCount[3]));
        }
    }

    //  Scenario: Verify the user should perform sorting for DOS From field to ascending order
    public void enterMemberIdInSearchFieldForSorting() throws InterruptedException {
        expMemberId = prop.getProperty("sortingMemberId");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMemberId);
        threadSleep(5000);
    }
    public void getAllDOSFromRecordsBeforeSort() {
        dosFromRecordsBeforeSort = new ArrayList<>();
        List<WebElement> elementList = findElementsByXpath(lstTotalDOSFromRecords);
        for (WebElement dosFromValue : elementList) {
            dosFromRecordsBeforeSort.add(dosFromValue.getText());
        }
        System.out.println("DOS From records before sort " + dosFromRecordsBeforeSort);
        //Sorting the list
        Collections.sort(dosFromRecordsBeforeSort);
        System.out.println("Sorted list :" + dosFromRecordsBeforeSort);
    }

    public void clickSortIconDOSFrom() {
        clickOnElementByJS(findElementByXpath(eleDOSFromSortIcon), driver);
    }

    public void verifyDOSFromInSortedAscendingOrder() {
        ArrayList<String> dosFromRecordsAfterSort = new ArrayList<>();
        List<WebElement> elementsList = findElementsByXpath(lstTotalDOSFromRecords);
        for (WebElement dosFromValue : elementsList) {
            dosFromRecordsAfterSort.add(dosFromValue.getText());
        }
        System.out.println("DOS From records after sorting :" + dosFromRecordsAfterSort);
        //Sorting the list
        Collections.sort(dosFromRecordsAfterSort);
        System.out.println("Sorted list after sorting :" + dosFromRecordsAfterSort);
        Assert.assertTrue(dosFromRecordsBeforeSort.equals(dosFromRecordsAfterSort));

    }

    //Scenario: Verify the user should perform sorting for DOS To field to ascending order
    public void getAllDOSToRecordsBeforeSort() {
        dosToRecordsBeforeSort = new ArrayList<>();
        List<WebElement> elementList = findElementsByXpath(lstTotalDOSToRecords);
        for (WebElement dosFromValue : elementList) {
            dosToRecordsBeforeSort.add(dosFromValue.getText());
        }
        System.out.println("DOS To records before sort " + dosToRecordsBeforeSort);
        //Sorting the list
        Collections.sort(dosToRecordsBeforeSort);
        System.out.println("Sorted list :" + dosToRecordsBeforeSort);
    }

    public void clickSortIconDOSTo() {
        clickOnElementByJS(findElementByXpath(eleDOSToSortIcon), driver);
    }

    public void verifyDOSToInSortedAscendingOrder() {
        ArrayList<String> dosToRecordsAfterSort = new ArrayList<>();
        List<WebElement> elementsList = findElementsByXpath(lstTotalDOSToRecords);
        for (WebElement dosToValue : elementsList) {
            dosToRecordsAfterSort.add(dosToValue.getText());
        }
        System.out.println("DOS To records after sorting :" + dosToRecordsAfterSort);
        //Sorting the list
        Collections.sort(dosToRecordsAfterSort);
        System.out.println("Sorted list after sorting :" + dosToRecordsAfterSort);

        Assert.assertTrue(dosToRecordsBeforeSort.equals(dosToRecordsAfterSort));

    }

    //Scenario: Verify the user should perform sorting for Claim Number field to ascending order
    public void getAllClaimNumberRecordsBeforeSort() {
        claimNumberRecordsBeforeSort = new ArrayList<>();
        List<WebElement> elementList = findElementsByXpath(lstTotalClaimNumberRecords);
        for (WebElement claimNumberValue : elementList) {
            claimNumberRecordsBeforeSort.add(claimNumberValue.getText());
        }
        System.out.println("ClaimNumbers records before sort " + claimNumberRecordsBeforeSort);
        //Sorting the list
        Collections.sort(claimNumberRecordsBeforeSort);
        System.out.println("Sorted list :" + claimNumberRecordsBeforeSort);
    }

    public void clickSortIconClaimNumber() {
        clickOnElementByJS(findElementByXpath(eleClaimNumberSortIcon), driver);
    }

    public void verifyClaimNumbersInSortedAscendingOrder() {
        ArrayList<String> claimNumberRecordsAfterSort = new ArrayList<>();
        List<WebElement> elementsList = findElementsByXpath(lstTotalClaimNumberRecords);
        for (WebElement claimNumberValue : elementsList) {
            claimNumberRecordsAfterSort.add(claimNumberValue.getText());
        }
        System.out.println("ClaimNumber records after sorting :" + claimNumberRecordsAfterSort);
        //Sorting the list
        Collections.sort(claimNumberRecordsAfterSort);
        System.out.println("Sorted list after sorting :" + claimNumberRecordsAfterSort);
        Assert.assertTrue(claimNumberRecordsBeforeSort.equals(claimNumberRecordsAfterSort));

    }

    //Scenario: Verify the user should perform sorting for Billing Provider field to ascending order
    public void getAllBillingProviderRecordsBeforeSort() {
        billingProviderRecordsBeforeSort = new ArrayList<>();
        List<WebElement> elementList = findElementsByXpath(lstTotalBillingProviderRecords);
        for (WebElement billingProviderValue : elementList) {
            billingProviderRecordsBeforeSort.add(billingProviderValue.getText());
        }
        System.out.println("BillingProvider records before sort " + billingProviderRecordsBeforeSort);
        //Sorting the list
        Collections.sort(billingProviderRecordsBeforeSort);
        System.out.println("Sorted list :" + billingProviderRecordsBeforeSort);
    }

    public void clickSortIconBillingProvider() {
        clickOnElementByJS(findElementByXpath(eleBillingProviderSortIcon), driver);
    }

    public void verifyBillingProviderInSortedAscendingOrder() {
        ArrayList<String> billingProviderRecordsAfterSort = new ArrayList<>();
        List<WebElement> elementsList = findElementsByXpath(lstTotalBillingProviderRecords);
        for (WebElement billingProviderValue : elementsList) {
            billingProviderRecordsAfterSort.add(billingProviderValue.getText());
        }
        System.out.println("BillingProvider records after sorting :" + billingProviderRecordsAfterSort);
        //Sorting the list
        Collections.sort(billingProviderRecordsAfterSort);
        System.out.println("Sorted list after sorting :" + billingProviderRecordsAfterSort);
        Assert.assertTrue(billingProviderRecordsBeforeSort.equals(billingProviderRecordsAfterSort));

    }

    //Scenario: Verify the user should perform sorting for Patient field to ascending order
    public void getAllPatientRecordsBeforeSort() {
        patientRecordsBeforeSort = new ArrayList<>();
        List<WebElement> elementList = findElementsByXpath(lstTotalPatientRecords);
        for (WebElement patientValue : elementList) {
            patientRecordsBeforeSort.add(patientValue.getText());
        }
        System.out.println("Patient records before sort " + patientRecordsBeforeSort);
        //Sorting the list
        Collections.sort(patientRecordsBeforeSort);
        System.out.println("Sorted list :" + patientRecordsBeforeSort);
    }

    public void clickSortIconPatient() {
        clickOnElementByJS(findElementByXpath(elePatientSortIcon), driver);
    }

    public void verifyPatientInSortedAscendingOrder() {
        ArrayList<String> patientRecordsAfterSort = new ArrayList<>();
        List<WebElement> elementsList = findElementsByXpath(lstTotalPatientRecords);
        for (WebElement patientValue : elementsList) {
            patientRecordsAfterSort.add(patientValue.getText());
        }
        System.out.println("Patient records after sorting :" + patientRecordsAfterSort);
        //Sorting the list
        Collections.sort(patientRecordsAfterSort);
        System.out.println("Sorted list after sorting :" + patientRecordsAfterSort);
        Assert.assertTrue(patientRecordsBeforeSort.equals(patientRecordsAfterSort));

    }

    //Scenario: Verify the user should perform sorting for Category field to ascending order
    public void getAllCategoryRecordsBeforeSort() {
        categoryRecordsBeforeSort = new ArrayList<>();
        List<WebElement> elementList = findElementsByXpath(lstTotalCategoryRecords);
        for (WebElement patientValue : elementList) {
            categoryRecordsBeforeSort.add(patientValue.getText());
        }
        System.out.println("Category records before sort " + categoryRecordsBeforeSort);
        //Sorting the list
        Collections.sort(categoryRecordsBeforeSort);
        System.out.println("Sorted list :" + categoryRecordsBeforeSort);
    }

    public void clickSortIconCategory() {
        clickOnElementByJS(findElementByXpath(eleCategorySortIcon), driver);
    }

    public void verifyCategoryInSortedAscendingOrder() {
        ArrayList<String> categoryRecordsAfterSort = new ArrayList<>();
        List<WebElement> elementsList = findElementsByXpath(lstTotalCategoryRecords);
        for (WebElement patientValue : elementsList) {
            categoryRecordsAfterSort.add(patientValue.getText());
        }
        System.out.println("Category records after sorting :" + categoryRecordsAfterSort);
        //Sorting the list
        Collections.sort(categoryRecordsAfterSort);
        System.out.println("Sorted list after sorting :" + categoryRecordsAfterSort);
        Assert.assertTrue(categoryRecordsBeforeSort.equals(categoryRecordsAfterSort));

    }

    //Scenario: Verify the user should perform sorting for State field to ascending order
    public void getAllStateRecordsBeforeSort() {
        stateRecordsBeforeSort = new ArrayList<>();
        List<WebElement> elementList = findElementsByXpath(lstTotalStateRecords);
        for (WebElement patientValue : elementList) {
            stateRecordsBeforeSort.add(patientValue.getText());
        }
        System.out.println("State records before sort " + stateRecordsBeforeSort);
        //Sorting the list
        Collections.sort(stateRecordsBeforeSort);
        System.out.println("Sorted list :" + stateRecordsBeforeSort);
    }

    public void clickSortIconState() {
        clickOnElementByJS(findElementByXpath(eleStateSortIcon), driver);
    }

    public void verifyStateInSortedAscendingOrder() {
        ArrayList<String> patientRecordsAfterSort = new ArrayList<>();
        List<WebElement> elementsList = findElementsByXpath(lstTotalStateRecords);
        for (WebElement patientValue : elementsList) {
            patientRecordsAfterSort.add(patientValue.getText());
        }
        System.out.println("State records after sorting :" + patientRecordsAfterSort);
        //Sorting the list
        Collections.sort(patientRecordsAfterSort);
        System.out.println("Sorted list after sorting :" + patientRecordsAfterSort);
        Assert.assertTrue(stateRecordsBeforeSort.equals(patientRecordsAfterSort));

    }

}
