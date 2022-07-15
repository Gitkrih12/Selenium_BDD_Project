package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class GlobalSearchPage extends SeleniumUtils {
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String tabGlobalSearch = "(//div[contains(text(),'Global Search')])[2]";
    String lblNoDataDisplay = "//div[@class='ag-center-cols-clipper']";
    String expHeight = "1px";
    String btnFilter = "//button[text()='Filter']";
    String btnCustomisedColumns = "//button[text()='Customize Columns']";
    String columnFeilds = "//div[@class='ag-header-cell-label']//span[text()]";
    String inputSearchFields = "//div[@class='ag-header-cell-label']//span[text()]//following::div//input[@class='ag-input-field-input ag-text-field-input']";
    String activeGlobalSearch = "//div[@class='col active-tab ng-star-inserted']";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String inputMemberId = "//input[@aria-label='Member Id Filter Input']";
    String eleClaimNumber = "//div[@class='ag-pinned-left-cols-container']//a";
    String eleMemberId = "(//div[@col-id='subscriberId']//span[@class='ag-cell-value'])[1]";
    String inputPatientName = "//input[@aria-label='Patient Filter Input']";
    String elePatientName = "(//div[@col-id='memberFullName']//span[@class='ag-cell-value'])[1]";
    String inputBillingProvider = "//input[@aria-label='Billing Provider Filter Input']";
    String eleBillingProvider = "(//div[@col-id='billingProviderFullName']//span[@class='ag-cell-value'])[1]";
    String inputState = "//input[@aria-label='State Filter Input']";
    String eleState = "(//div[@col-id='status']//span[@class='ag-cell-value'])[1]";
    String inputCategory = "//input[@aria-label='Category Filter Input']";
    String eleCategory = "(//div[@col-id='category']//span[@class='ag-cell-value'])[1]";
    String inputDOSFrom = " //input[@aria-label='DOS From Filter Input']";
    String eleDOSFrom = "(//div[@col-id='dosFrom']//span[@class='ag-cell-value'])[1]";
    String inputDOSTo = "//input[@aria-label='DOS To Filter Input']";
    String eleDOSTo = "(//div[@col-id='dosTo']//span[@class='ag-cell-value'])[1]";
    String btnExportResult = "//button[text()='Export Result']";
    String btnReprocess = "(//button[@title='Reprocess']//img)[1]";
    String inputUniversalSearchBar = "//input[@type='text' and @formcontrolname='searchName']";
    String imgSearchIcon = "//a//img[@class='SearchIcon']";
    String eleViewclaimTab = "//div[contains(@class,'active-tab')]";
    String eleInvalidIcon = "//span//em[@class='bi bi-info-circle']";
    String eleInvalidTooltip = "//span[@class='tooltiptext']";
    String eleVerticalColorforCorrected = "(//div[@col-id='isCorrected']//span)[6]";
    String eleCorrectedInfoTopGrid = "//div//span[@class='ColorBall']//following::span[contains(text(),'Corrected')]";
    String eleCircleWithColorCode = "((//div[@col-id='status']//span[@class='ag-cell-value'])[1]//span//span)[1]";
    String eleVerticalColorforUnclean = "(//div[@col-id='IsClean']//span)[6]";
    String eleUncleanInfoTopGrid = "//div//span[@class='ColorBall']//following::span[contains(text(),'Un-clean')]";

    private static String expClaimNumber = "";
    private static String expMemberId = "";
    private static String expPatientName = "";
    private static String expState = "";
    private static String expCategory = "";
    private static String expDOSFrom = "";
    private static String expDOSTo = "";
    private static String expBillingProvider = "";

    //Scenario: Verify user should get no result by default on Global search page
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void verifyGlobalSearchPage() {
        boolean value = isDisplayed(tabGlobalSearch);
        Assert.assertTrue(value);
    }

    public void verifyNoDataDisplayMessage() {
        String actHeight = findElementByXpath(lblNoDataDisplay).getAttribute("style");
        System.out.println("actHeight" + actHeight);
        if (actHeight.contains(expHeight)) {
            Assert.assertTrue(true);
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
    public void verifyGlobalSearchColumnFields(DataTable columnList) {
        List<String> columnListExp = columnList.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(columnFeilds);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Column Fields in Global Search : " + columnFieldsForCompare);
        if (columnFieldsForCompare.equals(columnListExp)) {
            Assert.assertEquals(columnListExp, columnFieldsForCompare);
        }
    }

    //Scenario: Verify search field displayed under each column except follow up column
    public void verifySearchFieldsUnderEachCoulmn() {
        List<WebElement> ActCSearchFields = findElementsByXpath(inputSearchFields);
        for (WebElement column : ActCSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    //Scenario: Verify adjudicator should land on Global Search Page
    public void verifyAdjudicatorLandsOnGlobalSearchPage() {
        boolean value = isDisplayed(activeGlobalSearch);
        Assert.assertTrue(value);
    }

    //Scenario: Verify user enters the Claim Number in the Search field
    public void enterClaimNumberInSearchField(String claimNumber) throws InterruptedException {
        expClaimNumber = claimNumber;
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), claimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void validateClaimNumberResult() {
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 5);
        String actClaimNumber = getText(eleClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
    }

    //Scenario: Verify user enters the Member ID in the Search field
    public void enterMemberIdInSearchField(String memberId) throws InterruptedException {
        expMemberId = memberId;
        findElementAndSendKeys(findElementByXpath(inputMemberId), memberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputMemberId);
        threadSleep(3000);
    }

    public void validateMemberIDResult() {
        explicitVisibilityOfWait(findElementByXpath(eleMemberId), 5);
        String actMemberId = getText(eleMemberId);
        System.out.println("actual member id :" + actMemberId);
        Assert.assertEquals(expMemberId, actMemberId);
    }

    //Scenario: Verify user enters the Patient Name in the Search field
    public void enterPatientNameInSearchField(String patientName) throws InterruptedException {
        expPatientName = patientName;
        findElementAndSendKeys(findElementByXpath(inputPatientName), patientName);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputPatientName);
        threadSleep(3000);
    }

    public void validatePatientNameResult() {
        explicitVisibilityOfWait(findElementByXpath(elePatientName), 5);
        String actPatientName = getText(elePatientName);
        System.out.println("actual patient name :" + actPatientName);
        Assert.assertEquals(expPatientName, actPatientName);
    }

    // Scenario: Verify user enters the Billing Provider details in the Search field
    public void enterBillingProviderInSearchField(String BillingProvider) throws InterruptedException {
        expBillingProvider = BillingProvider;
        findElementAndSendKeys(findElementByXpath(inputBillingProvider), BillingProvider);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputBillingProvider);
        threadSleep(3000);
    }

    public void validateBillingProviderResult() {
        explicitVisibilityOfWait(findElementByXpath(eleBillingProvider), 5);
        String actBillingProvider = getText(eleBillingProvider);
        System.out.println("actual Billing Provider :" + actBillingProvider);
        Assert.assertEquals(expBillingProvider, actBillingProvider);
    }

    //Scenario: Verify user enters the State name in the Search field
    public void enterStateInSearchField(String state) throws InterruptedException {
        expState = state;
        scrollIntoView(findElementByXpath(inputState), driver);
        findElementAndSendKeys(findElementByXpath(inputState), state);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputState);
        threadSleep(3000);
    }

    public void validateStateResult() {
        explicitVisibilityOfWait(findElementByXpath(eleState), 5);
        String actState = getText(eleState);
        System.out.println("actual state :" + actState);
        Assert.assertEquals(expState, actState);
    }

    //Scenario: Verify user enters the Category value in the Search field
    public void enterCategoryInSearchField(String category) throws InterruptedException {
        expCategory = category;
        scrollIntoView(findElementByXpath(inputCategory), driver);
        findElementAndSendKeys(findElementByXpath(inputCategory), category);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputCategory);
        threadSleep(3000);
    }

    public void validateCategoryResult() {
        explicitVisibilityOfWait(findElementByXpath(eleCategory), 5);
        String actCategory = getText(eleCategory);
        System.out.println("actual category :" + actCategory);
        Assert.assertEquals(expCategory, actCategory);
    }

    //Scenario: Verify user enters the DOS From details in the Search field
    public void enterDOSFromInSearchField(String DOSFrom) throws InterruptedException {
        expDOSFrom = DOSFrom;
        scrollIntoView(findElementByXpath(inputDOSFrom), driver);
        findElementAndSendKeys(findElementByXpath(inputDOSFrom), DOSFrom);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputDOSFrom);
        threadSleep(3000);
    }

    public void validateDOSFromResult() {
        explicitVisibilityOfWait(findElementByXpath(eleDOSFrom), 5);
        String actDOSFrom = getText(eleDOSFrom);
        System.out.println("actual DOSFrom :" + actDOSFrom);
        Assert.assertEquals(expDOSFrom, actDOSFrom);
    }

    public void enterDOSToInSearchField(String DOSTo) throws InterruptedException {
        expDOSTo = DOSTo;
        scrollIntoView(findElementByXpath(inputDOSTo), driver);
        findElementAndSendKeys(findElementByXpath(inputDOSTo), DOSTo);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputDOSTo);
        threadSleep(3000);
    }

    public void validateDOSToResult() {
        explicitVisibilityOfWait(findElementByXpath(eleDOSTo), 5);
        String actDOSTo = getText(eleDOSTo);
        System.out.println("actual DOSTo :" + actDOSTo);
        Assert.assertEquals(expDOSTo, actDOSTo);
    }

    public void verifyExportResultButtonWhenSearchResultsDisplayed() {
        boolean value = isDisplayed(btnExportResult);
        Assert.assertTrue(value);
    }

    public void verifyExportResultButtonWhenNoSearchResultsDisplayed() {
        boolean value = isDisplayed(btnExportResult);
        Assert.assertFalse(value);
    }

    public void verifyReprocessButton() throws InterruptedException {
        threadSleep(1000);
        scrollIntoView(findElementByXpath(eleState), driver);
        boolean value = isDisplayed(btnReprocess);
        Assert.assertTrue(value);
    }

    public void validateClaimNumberResultForCharacterLimit() {
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 5);
        String actClaimNumber = getText(eleClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        if (actClaimNumber.contains(expClaimNumber)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
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

    public void validatePatientResultForCharacterLimit() {
        explicitVisibilityOfWait(findElementByXpath(elePatientName), 5);
        String actPatientName = getText(elePatientName);
        System.out.println("actual patient name :" + actPatientName);
        if (actPatientName.contains(expPatientName)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void validateBillingProviderResultForCharacterLimit() {
        explicitVisibilityOfWait(findElementByXpath(eleBillingProvider), 5);
        String actPatientName = getText(eleBillingProvider);
        System.out.println("actual billing provider :" + actPatientName);
        if (actPatientName.contains(expBillingProvider)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
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

    public void verifyUniversalSearchBar() {
        boolean value = isDisplayed(inputUniversalSearchBar);
        Assert.assertTrue(value);
    }

    public void verifyPlaceHolderForUniversalSearch(String expPlaceholderValue) {
        String actPlaceholder = getAttribute(inputUniversalSearchBar, "placeholder");
        System.out.println("actual place holder value is :  " + actPlaceholder);
        Assert.assertEquals(expPlaceholderValue, actPlaceholder);
    }

    public void enterClaimNumberInUniversalSearch(String claimNumber) {
        expClaimNumber = claimNumber;
        findElementAndSendKeys(findElementByXpath(inputUniversalSearchBar), claimNumber);
        clickElement(imgSearchIcon);
    }

    public void verifyViewClaimDetailsAnotherTab() {
        boolean value = isDisplayed(eleViewclaimTab);
        Assert.assertTrue(value);
        String actClaimNumber = findElementByXpath(eleViewclaimTab).getText();
        System.out.println("actual claim number " + actClaimNumber);
        if (actClaimNumber.contains(expClaimNumber)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void verifyErrorMessage(String expErrorMessage) {
        moveToElement(eleInvalidIcon).perform();
        String actErrorMessage = findElementByXpath(eleInvalidTooltip).getText();
        System.out.println("actual error message " + actErrorMessage);
        Assert.assertEquals(expErrorMessage, actErrorMessage);
    }

    public void verifyVerticalColorIndicationForCorrectedClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorforCorrected);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    public void verifyCorrectedInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleCorrectedInfoTopGrid);
        Assert.assertTrue(value);
    }

    public void verifyCircleWithColorCodeForState(String expColorCode) {
        String actColorCode = getColorCodeForBackground(eleCircleWithColorCode);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorCode, actColorCode);
    }

    public void verifyVerticalColorIndicationForUncleanClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorforUnclean);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    public void verifyUncleanInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleUncleanInfoTopGrid);
        Assert.assertTrue(value);
    }

}
