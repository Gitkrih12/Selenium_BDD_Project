package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CAPProfessionalPage extends SeleniumUtils {
    String lnkCAPProfessional = "//div[contains(text(),'CAP Professional')]";
    String tabCAPProfessional = "(//div[contains(text(),'CAP Professional')])[2]";
    String elePendQueuePage = "(//span[@class='ag-cell-value']//app-view-claim-render)[1]";
    String eleClaimList = "//div//*[text()='Claim List']";
    String lstColumnFields = "//ag-grid-angular[@id='Pend_CAP_Professional']//div[@class='ag-header-cell-label']//span[text()]";
    String tabPendState = "(//button[@class='nav-link active'])[1]";
    String lstQueues = "//div[@id='nav-tab']//button";
    String txtSearchFields = "//ag-grid-angular[@id='pendGrid']//div[@class='ag-header-cell-label']//span[text()]//following::div[1]//input[@type='text']";
    String txtClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[1]";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String eleVerticalColorForCorrected = "(//div[@col-id='isCorrected']//span)[6]";
    String eleCorrectedInfoTopGrid = "//div//span[@class='ColorBall']//following::span[contains(text(),'Corrected')]";
    String elePatientNameColorCode = "((//div[contains(@class,'ag-cell ag-cell-not-inline-editing ag-cell-normal-height') and @col-id='memberFullName'])[1]//span)[3]";
    String eleCOBInMemberHouseInfoTopGrid = "//span[@class='ColorBall_COBInMemberHouse']//following::span[contains(text(),'COB (In Member House)')]";
    String eleCOBNotInMemberHouseInfoTopGrid = "//span[@class='ColorBall_COB_NoninMemberHouse']//following::span[contains(text(),'COB (Not in Member House)')]";
    String tabCAPProfessionalDefault = "//div[@class='col ng-star-inserted default-tab' and contains(text(),'CAP Professional')]";
    String eleVerticalColorForUncleanPendClaim = "(//div[@col-id='IsClean']//span)[6]";
    String eleUncleanInfoTopGrid = "//div//span[@class='ColorBall_UnClean']//following::span[contains(text(),'Un-clean')]";
    String tabPayerReview = "//button[@id='nav-payerreview-details-tab']";
    String txtPayerReviewClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[3]";
    String elePayerReviewClaimNumber="//*[@id='payerReviewGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanPayerReviewClaim = "(//*[@id='payerReviewGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String tabManagementReview = "//button[@id='nav-mangementreview-details-tab']";
    String txtManagementReviewClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[4]";
    String eleManagementReviewClaimNumber="//*[@id='mangementReviewGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanManagementReviewClaim = "(//*[@id='mangementReviewGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String tabApproved = "//button[@id='nav-approved-details-tab']";
    String txtApprovedClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[5]";
    String eleApprovedClaimNumber="//*[@id='approvedGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanApprovedClaim = "(//*[@id='approvedGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String tabDenied = "//button[@id='nav-denied-details-tab']";
    String txtDeniedClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[6]";
    String eleDeniedClaimNumber="//*[@id='deniedGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanDeniedClaim = "(//*[@id='deniedGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String tabPreBatch = "//button[@id='nav-perbatch-details-tab']";
    String txtPreBatchClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[7]";
    String elePreBatchClaimNumber="//*[@id='prebatchdGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanPreBatchClaim = "(//*[@id='prebatchdGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String txtMemberId = "//*[@id='Pend_CAP_Professional']//input[@aria-label='Member ID Filter Input']";
    String eleMemberId = "(//*[@id='Pend_CAP_Professional']//div[@col-id='subscriberId']//span[@class='ag-cell-value'])[1]";
    String eleTotalMemberIdRecords = "//*[@id='Pend_CAP_Professional']//div[@col-id='subscriberId']//span[@class='ag-cell-value']";
    String eleTotalResults = "//*[@id='Pend_CAP_Professional']//span[@class='ag-paging-row-summary-panel']";
    String elePaginationDescription = "//*[@id='Pend_CAP_Professional']//span[@class='ag-paging-description']";
    String tabOnHold = "//button[@id='nav-onhold-details-tab']";
    String eleOnHoldPaginationDescription = "//*[@id='onHoldGrid']//span[@class='ag-paging-description']";
    String btnNextPage = "//*[@id='onHoldGrid']//span[@class='ag-icon ag-icon-next']";
    String btnPreviousPage = "//*[@id='onHoldGrid']//span[@class='ag-icon ag-icon-previous']";
    String txtBatchID= "(//input[@aria-label='Batch ID Filter Input'])[5]";
    String eleBatchID= "(//*[@id='paidGrid']//div[@col-id='batchCode']//a)[1]";
    String tabCAPProfessionalPend = "//button[@id='nav-pend-details-tab']";


    private static String expClaimNumber = "";
    private static String expMemberId = "";
    private static int totalRecords = 0;
    private static int pageNumber = 0;
    private static int pageNumberNextNavigation = 0;
    private static String expBatchID ="";

    //Scenario: Verify user should navigates to CAP Professional screen
    public void clickOnCAPProfessional(){
        explicitVisibilityOfWait(findElementByXpath(lnkCAPProfessional), 5);
        clickElement(lnkCAPProfessional);
    }
    public void verifyCAPProfessionalPage() throws InterruptedException {
        boolean value = isDisplayed(tabCAPProfessional);
        Assert.assertTrue(value);
        explicitInvisibilityOfElementWithTextWait(By.xpath(tabCAPProfessionalPend), 60, "Pend ()");
    }

    //Scenario: Verify by default user should be in the Pend state in CAP Professional screen
    public void verifyUserByDefaultInPendStateResultsPage() throws InterruptedException {
        boolean value=isDisplayed(elePendQueuePage);
        Assert.assertTrue(value);
    }

    //Verify user should able to see Clam List Label in CAP Professional screen
    public void verifyClaimListLabel(){
        Assert.assertTrue(isDisplayed(eleClaimList));
    }

    //Scenario: Validate user able to view all the column fields for Pend bucket in CAP Professional screen
    public void verifyPendStateByDefault(String expState) throws InterruptedException{
        String actState=findElementByXpath(tabPendState).getAttribute("class");
        if(actState.contains(expState)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }

    public void verifyCAPProfessionalPendColumnFields(DataTable columnList) throws InterruptedException {
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

    //Scenario: Verify all the queue field details in the CAP Professional page
    public void verifyQueuesInCAPProfessional(DataTable queueList) throws InterruptedException {
        List<String> expQueueList = queueList.asList();
        List<WebElement> actQueueFields = findElementsByXpath(lstQueues);
        List<String> actualQueueFieldsForCompare = new ArrayList<>();
        for (WebElement column : actQueueFields) {
            threadSleep(1000);
            scrollIntoView(column, driver);
            String text = column.getText();
            String[] queueData=text.split(" ");
            if(queueData.length==2) {
                actualQueueFieldsForCompare.add(queueData[0]);
            }else if(queueData.length==3){
                actualQueueFieldsForCompare.add(queueData[0]+" "+queueData[1]);
            }else if(queueData.length==4){
                actualQueueFieldsForCompare.add(queueData[0]+" "+queueData[1]+" "+queueData[2]);
            }
        }
        System.out.println("actual queue fields " + actualQueueFieldsForCompare);
        System.out.println("expected queue fields " + expQueueList);
        for (String expQueue : expQueueList) {
            if (actualQueueFieldsForCompare.contains(expQueue)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(expQueue + " queue is not as expected");
            }
        }
    }

    //Scenario: Verify all the queue field details in the CAP Professional page
    public void verifySearchFieldsUnderEachColumnInCAPProfessional() {
        List<WebElement> actSearchFields = findElementsByXpath(txtSearchFields);
        for (WebElement column : actSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    //Scenario: Verify color code for corrected claims in CAP Professional page
    public void enterCorrectedClaimNumberInCAPProfessionalSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalCorrectedClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void validateClaimNumberResult() throws InterruptedException {
        threadSleep(5000);
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 5);
        String actClaimNumber = getText(eleClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
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

    //  Scenario: Verify color code for COB In Member House in CAP Professional page
    public void enterCOBInMemberHouseClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalCobInMemberHouse");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void verifyPatientNameColorCode(String expColorCode){
        String actColorCode = getColorCodeForText(elePatientNameColorCode);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorCode, actColorCode);
    }
    public void verifyCOBInMemberHouseInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleCOBInMemberHouseInfoTopGrid);
        Assert.assertTrue(value);
    }

    //Scenario: Verify color code for COB Not In Member House in CAP Professional page
    public void enterCOBNotInMemberHouseClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalCobNotInMemberHouse");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void verifyCOBNotInMemberHouseInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleCOBNotInMemberHouseInfoTopGrid);
        Assert.assertTrue(value);
    }

    //Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void clickOnCAPProfessionalClaim() throws InterruptedException {
        threadSleep(5000);
        clickElement(eleClaimNumber);
    }

    //Scenario: Verify user able to navigate to claim summary screen only once when performed multiple clicks on Claim number
    public void enterClaimNumberInPendCAPProfessionalSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void clickOnCAPProfessionalDefaultTab(){
        clickElement(tabCAPProfessionalDefault);
    }

    //Scenario: Verify colour coding for Unclean status claims under Pend bucket in CAP professional page
    public void enterUnCleanStatusPendClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalUnCleanStatusPendClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void verifyVerticalColorIndicationForUncleanPendClaim(String expColorIndication) throws InterruptedException {
        threadSleep(2000);
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanPendClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }
    public void verifyUncleanInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleUncleanInfoTopGrid);
        Assert.assertTrue(value);
    }

    //Scenario: Verify colour coding for Unclean status claims under Payer Review bucket in CAP professional page
    public void clickOnPayerReviewBucket(){
        clickElement(tabPayerReview);
    }
    public void enterUnCleanStatusPayerReviewClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalUnCleanStatusPayerReviewClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtPayerReviewClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtPayerReviewClaimNumber);
    }

    public void validatePayerReviewClaimNumberResult() {
        explicitVisibilityOfWait(findElementByXpath(elePayerReviewClaimNumber), 5);
        String actClaimNumber = getText(elePayerReviewClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
    }

    public void verifyVerticalColorIndicationForUncleanPayerReviewClaim(String expColorIndication) throws InterruptedException {
        threadSleep(2000);
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanPayerReviewClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Management Review bucket in CAP professional page
    public void clickOnManagementReviewBucket(){
        clickElement(tabManagementReview);
    }
    public void enterUnCleanStatusManagementReviewClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalUnCleanStatusManagementReviewClaimNumber");
        explicitVisibilityOfWait(findElementByXpath(txtManagementReviewClaimNumber), 5);
        findElementAndSendKeys(findElementByXpath(txtManagementReviewClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtManagementReviewClaimNumber);
    }
    public void validateManagementReviewClaimNumberResult() {
        explicitVisibilityOfWait(findElementByXpath(eleManagementReviewClaimNumber), 5);
        String actClaimNumber = getText(eleManagementReviewClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
    }
    public void verifyVerticalColorIndicationForUncleanManagementReviewClaim(String expColorIndication) throws InterruptedException {
        threadSleep(2000);
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanManagementReviewClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Approved bucket in CAP professional page
    public void clickOnApprovedBucket(){
        clickElement(tabApproved);
    }
    public void enterUnCleanStatusApprovedClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalUnCleanStatusApprovedClaimNumber");
        explicitVisibilityOfWait(findElementByXpath(txtApprovedClaimNumber), 5);
        findElementAndSendKeys(findElementByXpath(txtApprovedClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtApprovedClaimNumber);
    }
    public void validateApprovedClaimNumberResult() {
        explicitVisibilityOfWait(findElementByXpath(eleApprovedClaimNumber), 5);
        String actClaimNumber = getText(eleApprovedClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
    }
    public void verifyVerticalColorIndicationForUncleanApprovedClaim(String expColorIndication) throws InterruptedException {
        threadSleep(2000);
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanApprovedClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }
    //Scenario: Verify colour coding for Unclean status claims under Denied bucket in CAP professional page
    public void clickOnDeniedBucket(){
        clickElement(tabDenied);
    }

    public void enterUnCleanStatusDeniedClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalUnCleanStatusDeniedClaimNumber");
        explicitVisibilityOfWait(findElementByXpath(txtDeniedClaimNumber), 5);
        findElementAndSendKeys(findElementByXpath(txtDeniedClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtDeniedClaimNumber);
    }
    public void validateDeniedClaimNumberResult() {
        explicitVisibilityOfWait(findElementByXpath(eleDeniedClaimNumber), 5);
        String actClaimNumber = getText(eleDeniedClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
    }
    public void verifyVerticalColorIndicationForUncleanDeniedClaim(String expColorIndication){
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanDeniedClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Pre Batch bucket in CAP professional page
    public void clickOnPreBatchBucket(){
        clickElement(tabPreBatch);
    }

    public void enterUnCleanStatusPreBatchClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("capProfessionalUnCleanStatusPreBatchClaimNumber");
        explicitVisibilityOfWait(findElementByXpath(txtPreBatchClaimNumber), 5);
        findElementAndSendKeys(findElementByXpath(txtPreBatchClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtPreBatchClaimNumber);
    }
    public void validatePreBatchClaimNumberResult() {
        explicitVisibilityOfWait(findElementByXpath(elePreBatchClaimNumber), 5);
        String actClaimNumber = getText(elePreBatchClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
    }
    public void verifyVerticalColorIndicationForUncleanPreBatchClaim(String expColorIndication){
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanPreBatchClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify Pagination in CAP Professional page
    public void enterMemberIdInSearchFieldForPaginationInCAPProfessional() throws InterruptedException {
        expMemberId = prop.getProperty("capProfessionalPaginationMemberId");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberId);
        threadSleep(3000);
    }
    public void validateMemberIDResultInCAPProfessional() {
        explicitVisibilityOfWait(findElementByXpath(eleMemberId), 5);
        String actMemberId = getText(eleMemberId);
        System.out.println("actual member id :" + actMemberId);
        Assert.assertEquals(expMemberId, actMemberId);
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

    //Scenario: Verify user see the page numbers as per the no of data divided by pages size
    public void verifyPageSizeDividedByNoOfRecordsInTheGrid() {
        String pagination = findElementByXpath(elePaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        System.out.println("Page count " + paginationCount[3]);
        if (totalRecords <= 50) {
            Assert.assertEquals(1, Integer.parseInt(paginationCount[3]));
            System.out.println("Page count defined as per no of records : " + Integer.parseInt(paginationCount[3]));
        }else{
            Assert.fail("Page count is not defined as per no of records");
        }
    }

    //Scenario: Verify user able to navigate through pages by using Pagination functionality
    public void clickOnOnHold(){
        clickElement(tabOnHold);
    }
    public void verifyPageNumbersAtBottomOfPage() throws InterruptedException {
        explicitVisibilityOfElementLocatedWaitByXpath(eleOnHoldPaginationDescription,10);
        String pagination = findElementByXpath(eleOnHoldPaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        System.out.println("Page count " + Integer.parseInt(paginationCount[3]));
        pageNumber = Integer.parseInt(paginationCount[1]);
        if (Integer.parseInt(paginationCount[3]) >= 1) {
            Assert.assertTrue(true);
        }else{
            Assert.fail("Unable to navigate to next page");
        }
    }

    public void clickOnNextButton() {
        clickElement(btnNextPage);
    }

    public void verifyUserNavigatesToNextPage() {
        String pagination = findElementByXpath(eleOnHoldPaginationDescription).getText();
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
        String pagination = findElementByXpath(eleOnHoldPaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        int pageNumberPreviousNavigation = Integer.parseInt(paginationCount[1]);
        System.out.println("Page number " + pageNumberPreviousNavigation);
        if (pageNumberNextNavigation > pageNumberPreviousNavigation) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //Scenario: Verify all tabs should display when clicking on Batch ID under Paid tab in CAP Professional page
    public void enterBatchId() throws InterruptedException {
        expBatchID = prop.getProperty("capProfessionalBatchID");
        explicitElementClickableWaitByXpath(txtBatchID, 10);
        findElementAndSendKeys(findElementByXpath(txtBatchID), expBatchID);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleBatchID), 10, expBatchID);
    }

    //Scenario: Verify user able to view Check Type as Regular if its not void or reissue in Check Info page    public void enterBatchIdForNormalCheck() throws InterruptedException {
    public void enterBatchIdForNormalCheck() throws InterruptedException {
        expBatchID = prop.getProperty("capProfessionalBatchIDForNormalCheck");
        explicitElementClickableWaitByXpath(txtBatchID, 10);
        findElementAndSendKeys(findElementByXpath(txtBatchID), expBatchID);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleBatchID), 10, expBatchID);
    }

    //Scenario: Verify user able to view the check reissue information in Check Info page
    public void enterBatchIdForIssuedCheck() throws InterruptedException {
        expBatchID = prop.getProperty("capProfessionalBatchIDForIssuedCheck");
        explicitElementClickableWaitByXpath(txtBatchID, 10);
        findElementAndSendKeys(findElementByXpath(txtBatchID), expBatchID);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleBatchID), 10, expBatchID);
    }

    //Scenario: Then user able to view the check void information of that batch in Check Info page
    public void enterBatchIdForVoided() throws InterruptedException {
        expBatchID = prop.getProperty("capProfessionalBatchIDForVoid");
        explicitElementClickableWaitByXpath(txtBatchID, 10);
        findElementAndSendKeys(findElementByXpath(txtBatchID), expBatchID);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleBatchID), 10, expBatchID);
    }


}
