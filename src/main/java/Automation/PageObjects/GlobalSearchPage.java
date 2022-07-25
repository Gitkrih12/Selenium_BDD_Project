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
    String eleCustomizeColumnWindow = "//div[contains(@class,'offcanvas offcanvas-end show')]";
    String eleCustomizeColumnHeader = "//div[@class='offcanvas-header']";
    String eleCustomizeColumnFields = "//div[@class='form-check ng-star-inserted']//label";
    String btnSave = "//button[text()='Save']";
    String btnClose = "//button[@aria-label='Close']";
    String eleClaimNumberDisabled = "//input[@disabled]";
    String eleClaimNumberColumnOrder = "(//div[@class='offcanvas-header']//following::label)[1]";
    String inputClaimNumberCheckBox = "//input[@id='claimNumber']";
    String inputProviderCheckBox = "//input[@id='providerFullName']";
    String inputProvider = "//input[@aria-label='Provider Filter Input']";
    String elePagination = "//div[@class='ag-paging-panel ag-unselectable']";
    String eleTotalMemberIdRecords = "//div[@col-id='subscriberId']//span[@class='ag-cell-value']";
    String eleTotalResults = "//span[@class='ag-paging-row-summary-panel']";
    String elePaginationDescription = "//span[@class='ag-paging-description']";
    String eleSortIcon = "(//div//span[text()='DOS From']//following::span[@ref='eSortAsc'])[1]";
    String eleTotalDOSFromRecords = "//div[@col-id='dosFrom']//span[@class='ag-cell-value']";
    String eleTotalDOSFromRecordsAfterSorting = "//div[@col-id='dosFrom']//span[@class='ag-cell-value']";
    String btnNextPage = "//span[@class='ag-icon ag-icon-next']";
    String btnPreviousPage = "//span[@class='ag-icon ag-icon-previous']";


    private static String expClaimNumber = "";
    private static String expMemberId = "";
    private static String expPatientName = "";
    private static String expState = "";
    private static String expCategory = "";
    private static String expDOSFrom = "";
    private static String expDOSTo = "";
    private static String expBillingProvider = "";
    private static int totalRecords=0;
    private static ArrayList<String> sortedList;
    private static int pageNumber=0;
    private static int pageNumberNextNavigation=0;


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
    public void verifyGlobalSearchColumnFields(DataTable columnList) throws InterruptedException {
        List<String> expColumnList = columnList.asList();
        List<WebElement> actColumnFields = findElementsByXpath(columnFeilds);
        List<String> actualColumnFieldsForCompare = new ArrayList<>();

        for (WebElement column : actColumnFields) {
            threadSleep(1000);
            scrollIntoView(column, driver);
            String text = column.getText();
            actualColumnFieldsForCompare.add(text);
        }
        System.out.println("actual column fields " + actualColumnFieldsForCompare);
        System.out.println("expected column fields " + expColumnList);
            for(String expColumn:expColumnList){
                if(actualColumnFieldsForCompare.contains(expColumn)){
                    Assert.assertTrue(true);
                }
                else{
                    Assert.fail(expColumn + " column is not as expected");
                }
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
        threadSleep(5000);
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

    //Scenario: Verify user enters the DOS To details in the Search field
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

    // Scenario: Verify user able to search more than 2 characters in Member Id field
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

    //Scenario: Verify user able to search more than 2 characters in Billing Provider field
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

    //  Scenario: Verify user able to search more than 2 characters in any two fields
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
        if (expPlaceholderValue.contains(actPlaceholder)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

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
        Assert.assertTrue(actClaimNumber.contains(expClaimNumber));
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

    //Scenario: Verify user should navigate to Customized Columns window when we click on Customized columns in Global Search page
    public void clickOnCustomiseColumn(){
        clickElement(btnCustomisedColumns);
    }

    public void verifyCustomizeColumnWindow(){
        explicitVisibilityOfWait(findElementByXpath(eleCustomizeColumnWindow), 5);
        boolean value=isDisplayed(eleCustomizeColumnWindow);
        Assert.assertTrue(value);
    }

    //Scenario:Verify user should able to see the mentioned column fields in the 'Customize Columns' window
    public void verifyCustomizeColumnHeader(String expCustomizeColumnHeader){
        explicitVisibilityOfWait(findElementByXpath(eleCustomizeColumnHeader), 5);
        String actCustomizeColumnHeader=findElementByXpath(eleCustomizeColumnHeader).getText();
        System.out.println("Actual Header : "+actCustomizeColumnHeader);
        Assert.assertEquals(expCustomizeColumnHeader,actCustomizeColumnHeader);
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
        for(String expCustomizeColumn:expCustomizeColumnList){
            if(actualColumnFieldsForCompare.contains(expCustomizeColumn)){
                Assert.assertTrue(true);
            }
            else{
                Assert.fail(expCustomizeColumn + " column is not as expected");
            }
        }
    }

    public void verifySaveButton(){
        boolean value = isDisplayed(btnSave);
        Assert.assertTrue(value);
    }
    public void verifyCloseButton(){
        boolean value = isDisplayed(btnClose);
        Assert.assertTrue(value);
    }

    //  Scenario: Verify claim number order and check box should be selected by default
    public void verifyClaimNumberColumnOrder(){
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumberColumnOrder), 5);
        boolean value= isDisplayed(eleClaimNumberColumnOrder);
        Assert.assertTrue(value);
    }

    public void verifyClaimNumberInDisbaledMode(){
        boolean value= isDisplayed(eleClaimNumberDisabled);
        Assert.assertTrue(value);
    }

    public void verifyClaimNumberCheckBox(){
        boolean actchkValue= findElementByXpath(inputClaimNumberCheckBox).isSelected();
        Assert.assertTrue(actchkValue);
    }

    //Scenario: Verify user should able to see saved/updated fields the Global Search page
    public void clickProviderCheckBox(){
        explicitVisibilityOfWait(findElementByXpath(inputProviderCheckBox), 5);
        clickElement(inputProviderCheckBox);
        boolean actChkValue= findElementByXpath(inputProviderCheckBox).isSelected();
        Assert.assertTrue(actChkValue);
        clickElement(btnClose);
    }
    public void unSelectProviderCheckBox() {
        explicitVisibilityOfWait(findElementByXpath(inputProviderCheckBox), 5);
        clickElement(inputProviderCheckBox);
        boolean actChkValue= findElementByXpath(inputProviderCheckBox).isSelected();
        Assert.assertFalse(actChkValue);
        clickElement(btnClose);
    }

    public void verifyProviderColumnDisplayInGlobalSearch() throws InterruptedException {
        scrollIntoView(findElementByXpath(inputProvider),driver);
        boolean value = isDisplayed(inputProvider);
        Assert.assertTrue(value);
        threadSleep(1000);
    }
    public void verifyProviderColumnNotDisplayedInGlobalSearch(){
        scrollIntoView(findElementByXpath(inputState),driver);
        boolean value = isDisplayed(inputProvider);
        Assert.assertFalse(value);
    }

    //Scenario: Validate pagination in global Search page
    public void getAllMemberIdResults(){
        List<WebElement> memberIDResults = findElementsByXpath(eleTotalMemberIdRecords);
        totalRecords = memberIDResults.size();
        System.out.println("Total records "+memberIDResults.size());
    }

    public void verifyTotalResultsForGivenSearch(){
        String paginationText = findElementByXpath(eleTotalResults).getText();
        System.out.println("Pagination text "+paginationText);
        String [] totalResultsCount=paginationText.split(" ");
        System.out.println(totalResultsCount[4]);
        if(totalRecords==Integer.parseInt(totalResultsCount[4])){
            Assert.assertTrue(true);
            System.out.println("Pagination text is having the total no of records in the grid");
        }else{
            Assert.assertTrue(false);
        }
    }
    public void verifyPageNumbersAtBottomOfPage(){
        String pagination=findElementByXpath(elePaginationDescription).getText();
        String [] paginationCount=pagination.split(" ");
        System.out.println("Page count "+Integer.parseInt(paginationCount[3]));
        pageNumber=Integer.parseInt(paginationCount[1]);
        if(Integer.parseInt(paginationCount[3])>=1){
            Assert.assertTrue(true);
        }
    }
    public void clickOnNextButton(){
        clickElement(btnNextPage);
    }

    public void verifyUserNavigatesToNextPage(){
        String pagination=findElementByXpath(elePaginationDescription).getText();
        String [] paginationCount=pagination.split(" ");
       pageNumberNextNavigation= Integer.parseInt(paginationCount[1]);
        System.out.println("Page number "+pageNumberNextNavigation);
        if(pageNumberNextNavigation>pageNumber){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }

    public void clickOnPreviousButton(){
        clickElement(btnPreviousPage);
    }

    public void verifyUserNavigatesToPreviousPage(){
        String pagination=findElementByXpath(elePaginationDescription).getText();
        String [] paginationCount=pagination.split(" ");
        int pageNumberPreviousNavigation= Integer.parseInt(paginationCount[1]);
        System.out.println("Page number "+pageNumberPreviousNavigation);
        if(pageNumberNextNavigation>pageNumberPreviousNavigation){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }

    public void verifyPageSizeDividedByNoOfRecordsInTheGrid(){
        String pagination=findElementByXpath(elePaginationDescription).getText();
        String [] paginationCount=pagination.split(" ");
        System.out.println("Page count "+paginationCount[3]);
        if(totalRecords<=50){
            Assert.assertEquals(1,Integer.parseInt(paginationCount[3]));
            System.out.println("Page count defined as per no of records : "+Integer.parseInt(paginationCount[3]));
        }
    }

    //  Scenario: Verify the user should perform sorting for DOS From field to ascending order
    public void getAllDOSFromRecordsBeforeSort(){
        ArrayList<String> dosFromRecordsBeforeSort = new ArrayList<>();
        List<WebElement> elementList= findElementsByXpath(eleTotalDOSFromRecords);
        for(WebElement dosFromValue:elementList){
            dosFromRecordsBeforeSort.add(dosFromValue.getText());
        }
        System.out.println("DOS From records befor sort "+dosFromRecordsBeforeSort);
        //Sorting for the list which are stored before applying Sorting technique
         sortedList = new ArrayList<>();
        for(String s:dosFromRecordsBeforeSort){
            sortedList.add(s);
        }
        Collections.sort(sortedList);
        System.out.println("Sorted list :"+sortedList);
    }
    public void clickSortIconDOSFrom(){
        clickOnElementByJS(findElementByXpath(eleSortIcon),driver);
    }

    public void verifyDOSFromInSortedOrder(){
        ArrayList<String> dosFromRecordsAfterSort = new ArrayList<>();
        List<WebElement> elementsList= findElementsByXpath(eleTotalDOSFromRecordsAfterSorting);
        for(WebElement dosFromValue:elementsList){
            dosFromRecordsAfterSort.add(dosFromValue.getText());
        }
        System.out.println("DOS records after sorting :"+dosFromRecordsAfterSort);
        //Sorting for the list which are stored after applying Sorting technique
        ArrayList<String> sortedListAfterSorting = new ArrayList<>();
        for(String s:dosFromRecordsAfterSort){
            sortedListAfterSorting.add(s);
        }
        Collections.sort(sortedListAfterSorting);
        System.out.println("Sorted list after sorting :"+sortedListAfterSorting);

        Assert.assertTrue(sortedList.equals(sortedListAfterSorting));

    }



}
