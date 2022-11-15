package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import net.bytebuddy.pool.TypePool;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;

public class FFSProfessionalPage extends SeleniumUtils {
    String lnkFFSProfessional = "//div[contains(text(),'FFS Professional')]";
    String tabFFSProfessional = "(//div[contains(text(),'FFS Professional')])[2]";
    String txtClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[1]";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String eleVerticalColorForCorrected = "(//div[@col-id='isCorrected']//span)[6]";
    String eleCorrectedInfoTopGrid = "//div//span[@class='ColorBall']//following::span[contains(text(),'Corrected')]";
    String elePatientNameColorCode = "((//div[contains(@class,'ag-cell ag-cell-not-inline-editing ag-cell-normal-height') and @col-id='memberFullName'])[1]//span)[3]";
    String eleCOBInMemberHouseInfoTopGrid = "//span[@class='ColorBall_COBInMemberHouse']//following::span[contains(text(),'COB (In Member House)')]";
    String eleCOBNotInMemberHouseInfoTopGrid = "//span[@class='ColorBall_COB_NoninMemberHouse']//following::span[contains(text(),'COB (Not in Member House)')]";
    String lstColumnFields = "//ag-grid-angular[@id='pendGrid']//div[@class='ag-header-cell-label']//span[text()]";
    String tabPendState = "(//button[@class='nav-link active'])[1]";
    String lstQueues = "//div[@id='nav-tab']//button";
    String elePendQueuePage = "(//span[@class='ag-cell-value']//app-view-claim-render)[1]";
    String eleClaimList = "//div//*[text()='Claim List']";
    String eleVerticalColorForUncleanPendClaim = "(//div[@col-id='IsClean']//span)[6]";
    String eleUncleanInfoTopGrid = "//div//span[@class='ColorBall_UnClean']//following::span[contains(text(),'Un-clean')]";
    String tabPayerReview = "//button[@id='nav-payerreview-details-tab']";
    String txtPayerReviewClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[3]";
    String elePayerReviewClaimNumber = "//*[@id='payerReviewGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanPayerReviewClaim = "(//*[@id='payerReviewGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String tabManagementReview = "//button[@id='nav-mangementreview-details-tab']";
    String txtManagementReviewClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[4]";
    String eleManagementReviewClaimNumber = "//*[@id='mangementReviewGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanManagementReviewClaim = "(//*[@id='mangementReviewGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String tabApproved = "//button[@id='nav-approved-details-tab']";
    String txtApprovedClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[5]";
    String eleApprovedClaimNumber = "//*[@id='approvedGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanApprovedClaim = "(//*[@id='approvedGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String tabDenied = "//button[@id='nav-denied-details-tab']";
    String txtDeniedClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[6]";
    String eleDeniedClaimNumber = "//*[@id='deniedGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanDeniedClaim = "(//*[@id='deniedGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String tabPreBatch = "//button[@id='nav-perbatch-details-tab']";
    String txtPreBatchClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[7]";
    String elePreBatchClaimNumber = "//*[@id='prebatchdGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//a";
    String eleVerticalColorForUncleanPreBatchClaim = "(//*[@id='prebatchdGrid']//div[contains(@class,'ag-cell-normal-height')]//span)[4]";
    String tabViewClaim = "//div[@class='col ng-star-inserted active-tab']";
    String eleClaimSummary = "//div//a[@class='link-primary ms-1']";
    String tabFFSProfessionalDefault = "//div[@class='col ng-star-inserted default-tab' and contains(text(),'FFS Professional')]";
    String tabViewClaimDefault = "//div[@class='col ng-star-inserted default-tab' and contains(text(),'View')]";
    String txtMemberId = "//*[@id='pendGrid']//input[@aria-label='Member ID Filter Input']";
    String eleMemberId = "(//*[@id='pendGrid']//div[@col-id='subscriberId']//span[@class='ag-cell-value'])[1]";
    String eleTotalMemberIdRecords = "//*[@id='pendGrid']//div[@col-id='subscriberId']//span[@class='ag-cell-value']";
    String eleTotalResults = "//*[@id='pendGrid']//span[@class='ag-paging-row-summary-panel']";
    String elePaginationDescription = "//*[@id='pendGrid']//span[@class='ag-paging-description']";
    String tabOnHold = "//button[@id='nav-onhold-details-tab']";
    String eleOnHoldPaginationDescription = "//*[@id='onHoldGrid']//span[@class='ag-paging-description']";
    String btnNextPage = "//*[@id='onHoldGrid']//span[@class='ag-icon ag-icon-next']";
    String btnPreviousPage = "//*[@id='onHoldGrid']//span[@class='ag-icon ag-icon-previous']";
    String txtSearchFields = "//ag-grid-angular[@id='pendGrid']//div[@class='ag-header-cell-label']//span[text()]//following::div[1]//input[@type='text']";
    String tabPaid = "//button[@id='nav-paid-details-tab']";
    String lstTabsInBatchID = "//div[@id='nav-tab']//button";
    String txtBatchID = "(//input[@aria-label='Batch ID Filter Input'])[5]";
    String eleBatchID = "(//*[@id='paidGrid']//div[@col-id='batchCode']//a)[1]";
    String tabClaimListState = "(//button[@class='nav-link active'])[1]";
    String lstClaimList = "//div[@col-id='claimNumber']//a";
    String tabClaimList = "//button[@id='nav-view-claim-list-details-tab']";
    String eleClaimListInTheSelectedBatch = "//span[contains(text(),'Claim List in the Selected Batch')]";
    String tabProviderList = "//button[@id='nav-provider-list-details-tab']";
    String lstProviderList = "//div[@col-id='renderingProviderNPI']//div//span[@class='ag-cell-value']";
    String eleProviderListInTheSelectedBatch = "//span[contains(text(),'Providers in the Selected Batch')]";
    String tabCheckInfo = "//button[@id='nav-check-info-details-tab']";
    String lstCheckInfo = "//div[@col-id='checkType']//div//span[@class='ag-cell-value']";
    String eleCheckInformation = "//span[contains(text(),'Check Information')]";
    String eleCheckType = "(//div[@col-id='checkType']//div//span[@class='ag-cell-value'])[1]";
    String tabHistoryDoc = "//button[@id='nav-history-doc-details-tab']";
    String lstHistoryDoc = "//div[@col-id='payeeid']//div//span[@class='ag-cell-value']";
    String eleHistoryDoc = "//span[contains(text(),'History Of Doc in the Selected Batch')]";
    String tabDownloads = "//button[@id='nav-downloads-details-tab']";
    String eleEOPLetter = "//button[text()='Download EOP Letter']";
    String ele835file = "//button[text()='Download 835 File']";
    String tabFFSProfessionalPend = "//button[@id='nav-pend-details-tab']";
    String tabOpenedAllTabs = "//div[@class='mat-tab-labels']";
    String btnAddNote = "//button[text()='Add Note']";
    String eleTitle = "//span[text()='Title']";
    String eleCategory = "//span[text()='Category']";
    String eleDescription = "//label[text()='Description']";
    String btnAdd = "//div[@class='dailog-actions']//button[text()='Add']";
    String btnCancel = "//div[@class='dailog-actions']//button[text()='Cancel']";
    String txtTitle = "//input[@ng-reflect-name='title']";
    String txtCategory = "//select[@name='ddlcategory']";
    String txtDescription = "//textarea[@ng-reflect-name='description']";
    String eleAddNoteToasterMsg = "//div[@role='alertdialog']";
    String tabNotes = "//button[@id='nav-notes-tab']";
    String eleNotes = "(//div[@col-id='title'])[2]/..";
    String eleErrorMsg = "(//div[@id='toast-container']//div//div)[1]";
    String lstOnHoldColumnFields = "//ag-grid-angular[@id='onHoldGrid']//div[@class='ag-header-cell-label']//span[text()]";
    String lstPayerReviewColumnFields = "//ag-grid-angular[@id='payerReviewGrid']//div[@class='ag-header-cell-label']//span[text()]";
    String lstManagementReviewColumnFields = "//ag-grid-angular[@id='mangementReviewGrid']//div[@class='ag-header-cell-label']//span[text()]";
    String lstApprovedColumnFields = "//ag-grid-angular[@id='approvedGrid']//div[@class='ag-header-cell-label']//span[text()]";
    String lstDeniedColumnFields = "//ag-grid-angular[@id='deniedGrid']//div[@class='ag-header-cell-label']//span[text()]";
    String lstPreBatchColumnFields = "//ag-grid-angular[@id='prebatchdGrid']//div[@class='ag-header-cell-label']//span[text()]";
    String btnPreBatchPay = "//button[text()='Pre-Batch Pay']";
    String chkClaimNumber = "(//*[@id='approvedGrid']//div[contains(@class,'ag-cell-last-left-pinned')]//div[@class='ag-selection-checkbox'])[1]";



    private static String expClaimNumber = "";
    private static String expMemberId = "";
    private static int totalRecords = 0;
    private static int pageNumber = 0;
    private static int pageNumberNextNavigation = 0;
    private static String expBatchID = "";
    private static String title = "";
    private static String category = "";
    private static String description = "";


    //Scenario: Verify user should navigates to FFS Professional screen
    public void clickOnFFSProfessional() {
        explicitVisibilityOfWait(findElementByXpath(lnkFFSProfessional), 5);
        clickElement(lnkFFSProfessional);
    }

    public void verifyFFSProfessionalPage() throws InterruptedException {
        boolean value = isDisplayed(tabFFSProfessional);
        Assert.assertTrue(value);
        explicitInvisibilityOfElementWithTextWait(By.xpath(tabFFSProfessionalPend), 60, "Pend ()");
    }

    //Scenario: Verify color code for corrected claims in FFS Professional page
    public void enterCorrectedClaimNumberInFFSProfessionalSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalCorrectedClaimNumber");
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

    //scenario: Verify color code for COB Not In Member House in FFS Professional page
    public void enterCOBInMemberHouseClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalCobInMemberHouse");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    public void verifyPatientNameColorCode(String expColorCode) {
        String actColorCode = getColorCodeForText(elePatientNameColorCode);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorCode, actColorCode);
    }

    public void verifyCOBInMemberHouseInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleCOBInMemberHouseInfoTopGrid);
        Assert.assertTrue(value);
    }

    //Scenario: Verify color code for COB Not In Member House in FFS Professional page
    public void enterCOBNotInMemberHouseClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalCobNotInMemberHouse");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    public void verifyCOBNotInMemberHouseInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleCOBNotInMemberHouseInfoTopGrid);
        Assert.assertTrue(value);
    }

    //Scenario:Verify user able to navigate to claim summary screen on clicking claim number in FFS Professional Queue page
    public void clickOnFFSProfessionalClaim() throws InterruptedException {
        threadSleep(5000);
        clickElement(eleClaimNumber);
    }

    public void clickOnFFSProfessionalDefaultTab() {
        clickElement(tabFFSProfessionalDefault);
    }

    public void verifyViewClaimDetailsTab() {
        Assert.assertTrue(isDisplayed(tabViewClaim));
    }

    public void verifyClaimSummaryOption(String expOption) throws InterruptedException {
        threadSleep(2000);
        String actOption = findElementByXpath(eleClaimSummary).getText();
        System.out.println("actOption " + actOption);
        if (actOption.contains(expOption)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    public void getOpenedClaimNumber() {
        String viewClaimNumberText = findElementByXpath(tabViewClaim).getText();
        String[] claimData = viewClaimNumberText.split(" ");
        expClaimNumber = claimData[2].substring(1);
        System.out.println("claim number " + expClaimNumber);

    }

    public void verifyUserShouldSeeAlreadyOpenedClaimNumber() {
        ArrayList<String> openedTabs = new ArrayList<>();
        List<WebElement> actTabs = findElementByXpath(tabOpenedAllTabs).findElements(By.xpath("*"));
        for (WebElement a : actTabs) {
            if (a.getText().contains("View")) {
                String[] claimValues = a.getText().split(" ");
                openedTabs.add(claimValues[0]);
            } else {
                openedTabs.add(a.getText());
            }
        }
        System.out.println(openedTabs);
        Assert.assertEquals(1, Collections.frequency(openedTabs, "View"));
        clickElement(tabViewClaimDefault);
    }

    //Scenario: Verify user able to navigate to claim summary screen only once when performed multiple clicks on Claim number
    public void enterClaimNumberInPendFFSProfessionalSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    //Scenario:Verify colour coding for Unclean status claims under Pend bucket in FFS professional page
    public void enterUnCleanStatusPendClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalUnCleanStatusPendClaimNumber");
        explicitVisibilityOfWait(findElementByXpath(txtClaimNumber), 5);
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

    //Scenario: Verify colour coding for Unclean status claims under Payer Review bucket in FFS professional page
    public void clickOnPayerReviewBucket() {
        clickElement(tabPayerReview);
    }

    public void enterUnCleanStatusPayerReviewClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalUnCleanStatusPayerReviewClaimNumber");
        explicitVisibilityOfWait(findElementByXpath(txtPayerReviewClaimNumber), 5);
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

    public void verifyVerticalColorIndicationForUncleanPayerReviewClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanPayerReviewClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Management Review bucket in FFS professional page
    public void clickOnManagementReviewBucket() {
        clickElement(tabManagementReview);
    }

    public void enterUnCleanStatusManagementReviewClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalUnCleanStatusManagementReviewClaimNumber");
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

    public void verifyVerticalColorIndicationForUncleanManagementReviewClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanManagementReviewClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Approved bucket in FFS professional page
    public void clickOnApprovedBucket() {
        clickElement(tabApproved);
    }

    public void enterUnCleanStatusApprovedClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalUnCleanStatusApprovedClaimNumber");
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

    public void verifyVerticalColorIndicationForUncleanApprovedClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanApprovedClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Denied bucket in FFS professional page
    public void clickOnDeniedBucket() {
        clickElement(tabDenied);
    }

    public void enterUnCleanStatusDeniedClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalUnCleanStatusDeniedClaimNumber");
        explicitVisibilityOfWait(findElementByXpath(txtDeniedClaimNumber), 5);
        findElementAndSendKeys(findElementByXpath(txtDeniedClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtDeniedClaimNumber);
    }

    public void validateDeniedClaimNumberResult() {
        explicitVisibilityOfWait(findElementByXpath(eleDeniedClaimNumber), 10);
        String actClaimNumber = getText(eleDeniedClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
    }

    public void verifyVerticalColorIndicationForUncleanDeniedClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanDeniedClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Pre Batch bucket in FFS professional page
    public void clickOnPreBatchBucket() {
        clickElement(tabPreBatch);
    }

    public void enterUnCleanStatusPreBatchClaimNumber() throws InterruptedException {
        expClaimNumber = prop.getProperty("ffsProfessionalUnCleanStatusPreBatchClaimNumber");
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

    public void verifyVerticalColorIndicationForUncleanPreBatchClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanPreBatchClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Validate user able to view all the column fields for Pend bucket in FFS Professional screen
    public void verifyPendStateByDefault(String expState) throws InterruptedException {
        String actState = findElementByXpath(tabPendState).getAttribute("class");
        if (actState.contains(expState)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void verifyFFSProfessionalPendColumnFields(DataTable columnList) throws InterruptedException {
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

    //Scenario: Verify all the queue field details in the FFS Professional page
    public void verifyQueuesInFFSProfessional(DataTable queueList) throws InterruptedException {
        List<String> expQueueList = queueList.asList();
        List<WebElement> actQueueFields = findElementsByXpath(lstQueues);
        List<String> actualQueueFieldsForCompare = new ArrayList<>();
        for (WebElement column : actQueueFields) {
            threadSleep(1000);
            scrollIntoView(column, driver);
            String text = column.getText();
            String[] queueData = text.split(" ");
            if (queueData.length == 2) {
                actualQueueFieldsForCompare.add(queueData[0]);
            } else if (queueData.length == 3) {
                actualQueueFieldsForCompare.add(queueData[0] + " " + queueData[1]);
            } else if (queueData.length == 4) {
                actualQueueFieldsForCompare.add(queueData[0] + " " + queueData[1] + " " + queueData[2]);
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

    //Scenario: Verify by default user should be in the Pend state in FFS Professional screen
    public void verifyUserByDefaultInPendStateResultsPage() throws InterruptedException {
        boolean value = isDisplayed(elePendQueuePage);
        Assert.assertTrue(value);
    }

    //Scenario: Verify user should able to see Clam List Label in FFS Professional screen
    public void verifyClaimListLabel() {
        Assert.assertTrue(isDisplayed(eleClaimList));
    }

    //Scenario: Validate pagination in FFS Professional page
    public void enterMemberIdInSearchFieldForPaginationInFFSProfessional() throws InterruptedException {
        expMemberId = prop.getProperty("ffsProfessionalPaginationMemberId");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberId);
        threadSleep(3000);
    }

    public void validateMemberIDResultInFFSProfessional() {
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
        } else {
            Assert.fail("Page count is not defined as per no of records");
        }
    }

    //Scenario: Verify user able to navigate through pages by using Pagination functionality

    public void clickOnOnHold(){
        explicitInvisibilityOfElementWithTextWait(By.xpath(tabOnHold), 60, "On Hold ()");
        clickElement(tabOnHold);
    }

    public void verifyPageNumbersAtBottomOfPage() throws InterruptedException {
        //threadSleep(10000);
        explicitVisibilityOfElementLocatedWaitByXpath(eleOnHoldPaginationDescription, 10);
        String pagination = findElementByXpath(eleOnHoldPaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        System.out.println("Page count " + Integer.parseInt(paginationCount[3]));
        pageNumber = Integer.parseInt(paginationCount[1]);
        if (Integer.parseInt(paginationCount[3]) >= 1) {
            Assert.assertTrue(true);
        } else {
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

    //Scenario: Verify user able to view the search fields under each columns in the FFS Professional screen
    public void verifySearchFieldsUnderEachColumnInFFSProfessional() {
        List<WebElement> actSearchFields = findElementsByXpath(txtSearchFields);
        for (WebElement column : actSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    //Scenario: Verify all tabs should display when clicking on Batch ID under Paid tab in FFS Professional page
    public void clickOnPaidBucket() {
        clickElement(tabPaid);
    }

    public void enterBatchId() throws InterruptedException {
        expBatchID = prop.getProperty("ffsProfessionalBatchID");
        explicitVisibilityOfElementLocatedWaitByXpath(txtBatchID, 10);
        findElementAndSendKeys(findElementByXpath(txtBatchID), expBatchID);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleBatchID), 15, expBatchID);
    }

    public void clickOnBatchId() throws InterruptedException {
        explicitElementClickableWaitByXpath(eleBatchID, 10).click();
        explicitInvisibilityOfElementWithTextWait(By.xpath(tabHistoryDoc), 60, "History Doc ()");
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabDownloads), 20, "Downloads");
        threadSleep(1000);
    }

    public void verifyTabsInBatchIDInFFSProfessional(DataTable tabList) throws InterruptedException {
        List<String> expTabList = tabList.asList();
        List<WebElement> actTabFields = findElementsByXpath(lstTabsInBatchID);
        List<String> actualQueueFieldsForCompare = new ArrayList<>();
        for (WebElement column : actTabFields) {
            threadSleep(1000);
            String text = column.getText();
            String[] queueData = text.split(" ");
            if (queueData.length == 1 || queueData.length == 2) {
                actualQueueFieldsForCompare.add(queueData[0]);
            } else if (queueData.length == 3) {
                actualQueueFieldsForCompare.add(queueData[0] + " " + queueData[1]);
            } else if (queueData.length == 4) {
                actualQueueFieldsForCompare.add(queueData[0] + " " + queueData[1] + " " + queueData[2]);
            }
        }
        System.out.println("actual tab fields " + actualQueueFieldsForCompare);
        System.out.println("expected tab fields " + expTabList);
        for (String expQueue : expTabList) {
            if (actualQueueFieldsForCompare.contains(expQueue)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(expQueue + " tab is not as expected");
            }
        }

    }

    //Scenario: Verify by default user navigates to the View Claims List page
    public void verifyClaimListByDefault(String expState) throws InterruptedException {
        String actState = findElementByXpath(tabClaimListState).getAttribute("class");
        if (actState.contains(expState)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void verifyClaimsCount() throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabClaimList), 15, "Claim List");
        validateRowCountInBatchIDTabs(tabClaimList, lstClaimList);
    }

    public void verifyClaimListInTheSelectedBatchLabel(String expClaimListLabel) {
        String actClaimListLabel = findElementByXpath(eleClaimListInTheSelectedBatch).getText();
        if (actClaimListLabel.contains(expClaimListLabel)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    //Scenario: Verify user should navigates to the Provider List page on clicking Provider List tab
    public void clickOnProviderList() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabProviderList), 10, "Provider List");
        clickElement(tabProviderList);
    }

    public void verifyProviderCount() throws InterruptedException {
        validateRowCountInBatchIDTabs(tabProviderList, lstProviderList);
    }

    public void verifyProviderListInTheSelectedBatchLabel(String expClaimListLabel) {
        String actProviderListLabel = findElementByXpath(eleProviderListInTheSelectedBatch).getText();
        if (actProviderListLabel.contains(expClaimListLabel)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    //Scenario: Verify user should navigates to the Check Info page on clicking Check Info tab
    public void clickOnCheckInfoList() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabCheckInfo), 10, "Check Info");
        clickElement(tabCheckInfo);
    }

    public void verifyCheckInfoCount() throws InterruptedException {
        validateRowCountInBatchIDTabs(tabCheckInfo, lstCheckInfo);
    }

    public void verifyCheckInfoLabel(String expCheckInfoLabel) {
        String actCheckInfoLabel = findElementByXpath(eleCheckInformation).getText();
        if (actCheckInfoLabel.contains(expCheckInfoLabel)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    //Scenario: Verify user able to view the check reissue information in Check Info page
    public void verifyCheckType(String expCheckType) throws InterruptedException {
        if (expCheckType.contains("ReIssue")) {
            explicitTextToBePresentInElementLocatedWait(By.xpath(eleCheckType), 10, "ReIssue");
        } else if (expCheckType.contains("Void")) {
            explicitTextToBePresentInElementLocatedWait(By.xpath(eleCheckType), 10, "Void");
        } else {
            explicitTextToBePresentInElementLocatedWait(By.xpath(eleCheckType), 10, "Regular");
        }
        String actCheckType = findElementByXpath(eleCheckType).getText();
        System.out.println("Check Type is :" + actCheckType);
        Assert.assertEquals(expCheckType, actCheckType);
    }

    //Scenario: Verify user able to view the check void information in Check Info page
    public void enterBatchIdForVoided() throws InterruptedException {
        expBatchID = prop.getProperty("ffsProfessionalBatchIDForVoid");
        explicitElementClickableWaitByXpath(txtBatchID, 10);
        findElementAndSendKeys(findElementByXpath(txtBatchID), expBatchID);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleBatchID), 10, expBatchID);
    }

    //Scenario: Verify user able to view Check Type as Regular if its not void or reissue in Check Info page
    public void enterBatchIdForNormalCheck() throws InterruptedException {
        expBatchID = prop.getProperty("ffsProfessionalBatchIDForNormalCheck");
        explicitElementClickableWaitByXpath(txtBatchID, 10);
        findElementAndSendKeys(findElementByXpath(txtBatchID), expBatchID);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleBatchID), 10, expBatchID);
    }


    //Scenario: Verify user able to navigate to the History Doc page on clicking History Doc tab
    public void clickOnHistoryDoc() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabHistoryDoc), 20, "History Doc");
        clickElement(tabHistoryDoc);
    }

    public void verifyHistoryDocCount() throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleHistoryDoc), 20, "History Of Doc");
        validateRowCountInBatchIDTabs(tabHistoryDoc, lstHistoryDoc);
    }

    public void verifyHistoryDocLabel(String expHistoryDocLabel) {
        String actHistoryDocLabel = findElementByXpath(eleHistoryDoc).getText();
        if (actHistoryDocLabel.contains(expHistoryDocLabel)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    //Scenario:Verify user able to navigate to the Downloads tab on clicking Downloads tab and verify the files when there are any files
    public void clickOnDownloads() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabDownloads), 20, "Downloads");
        clickElement(tabDownloads);
    }

    public void verifyEOPLetter(String expEOPLetter) {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleEOPLetter), 20, "Download EOP Letter");
        String actEOPLetter = findElementByXpath(eleEOPLetter).getText();
        Assert.assertEquals(expEOPLetter, actEOPLetter);
    }

    public void verify835File(String expFileName) {
        String actEOPLetter = findElementByXpath(ele835file).getText();
        Assert.assertEquals(expFileName, actEOPLetter);
    }

    //Generic method to get the Row count next to the tabs
    public void validateRowCountInBatchIDTabs(String fileTabXpath, String lstRecordsXpath) throws InterruptedException {
        String recordsBarText = explicitElementClickableWaitByXpath(fileTabXpath, 10).getText();
        String expRowCount = recordsBarText.substring(recordsBarText.indexOf("(") + 1, recordsBarText.indexOf(")"));
        System.out.println("Expected row count is: " + expRowCount);
        threadSleep(2000);
        List<WebElement> expTabFields = findElementsByXpath(lstRecordsXpath);
        int actRecordCount = expTabFields.size();
        System.out.println("Actual row count is: " + actRecordCount);
        Assert.assertEquals(Integer.parseInt(expRowCount), actRecordCount);
    }

    //Scenario: Verify Add Note button in Paid Bucket
    public void verifyAddNoteButton() {
        Assert.assertTrue(isDisplayed(btnAddNote));
    }

    //  Scenario: Verify fields in Add Note window
    public void clickOnAddNoteButton() {
        clickElement(btnAddNote);
    }

    public void verifyTitle(String expTitle) {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleTitle), 20, "Title");
        String actTitleText = findElementByXpath(eleTitle).getText();
        Assert.assertEquals(expTitle, actTitleText);

    }

    public void verifyCategory(String expCategory) {
        String actCategory = findElementByXpath(eleCategory).getText();
        Assert.assertEquals(expCategory, actCategory);
    }

    public void verifyDescription(String expDescription) {
        String actDescription = findElementByXpath(eleDescription).getText();
        Assert.assertEquals(expDescription, actDescription);
    }

    public void verifyAddButton(String expAdd) {
        String actAdd = findElementByXpath(btnAdd).getText();
        Assert.assertEquals(expAdd, actAdd);
    }

    public void verifyCancelButton(String expCancel) {
        String actCancel = findElementByXpath(btnCancel).getText();
        Assert.assertEquals(expCancel, actCancel);
    }

    //Scenario: Verify user should be able to view all the Claim notes that are updated for that specific Batch results
    public void enterTitle() {
        title = prop.getProperty("Title");
        findElementAndSendKeys(findElementByXpath(txtTitle), title);
    }

    public void selectCategory() {
        category = prop.getProperty("Category");
        explicitVisibilityOfWait(findElementByXpath(txtCategory), 5);
        selectDropdownByVisibleText(txtCategory, category);
    }

    public void enterDescription() {
        description = prop.getProperty("Description");
        findElementAndSendKeys(findElementByXpath(txtDescription), description);
    }

    public void clickAdd() {
        clickElement(btnAdd);
    }

    public void verifyAddNoteSuccessfullyMsg(String expToasterMsg) throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleAddNoteToasterMsg), 15, expToasterMsg);
        String actToasterMsg = findElementByXpath(eleAddNoteToasterMsg).getText();
        System.out.println("expected toaster msg :" + expToasterMsg);
        System.out.println("actual toaster msg :" + actToasterMsg);
        Assert.assertEquals(expToasterMsg, actToasterMsg);
    }

    public void clickOnClaimNumber() {
        clickElement(eleClaimNumber);

    }

    public void NavigateToNotesScreen() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabNotes), 15, "Notes");
        clickElement(tabNotes);
    }

    public void verifyNotesAddedInNotesSection() throws InterruptedException {
        explicitElementClickableWaitByXpath(eleNotes, 20);
        //explicitVisibilityOfWait(findElementByXpath(eleNotes), 10);
        String actNotesText = findElementByXpath(eleNotes).getText();
        System.out.println("Actual Notes :" + actNotesText);
        String[] actNotes = actNotesText.split("\n");
        String actNotesContent = actNotes[0] + " " + actNotes[1] + " " + actNotes[2] + " " + actNotes[3];
        System.out.println("actual notes content :" + actNotesContent);
        if (actNotesContent.contains(title) && actNotesContent.contains(category) && actNotesContent.contains(description)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    //Scenario: Verify error message when user enters Category and Description fields and Title field should leave as empty
    public void verifyErrorMsg(String expToasterMsg) throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleErrorMsg), 15, expToasterMsg);
        String actToasterMsg = findElementByXpath(eleErrorMsg).getText();
        System.out.println("expected toaster msg :" + expToasterMsg);
        System.out.println("actual toaster msg :" + actToasterMsg);
        Assert.assertEquals(expToasterMsg, actToasterMsg);
    }

    //Scenario: Validate user able to view all the column fields under On Hold bucket in FFS Professional screen
    public void verifyFFSProfessionalOnHoldColumnFields(DataTable columnList){
        scrollToElementsAndCompare2Lists(columnList,lstOnHoldColumnFields);
    }

    //Scenario: Validate user able to view all the column fields under Payer Review bucket in FFS Professional screen
    public void verifyFFSProfessionalPayerReviewColumnFields(DataTable columnList){
        scrollToElementsAndCompare2Lists(columnList,lstPayerReviewColumnFields);
    }

    //Scenario: Validate user able to view all the column fields under Management Review bucket in FFS Professional screen
    public void verifyFFSProfessionalManagementReviewColumnFields(DataTable columnList){
        scrollToElementsAndCompare2Lists(columnList,lstManagementReviewColumnFields);
    }

    //Scenario: Validate user able to view all the column fields under Approved bucket in FFS Professional screen
    public void verifyFFSProfessionalApprovedColumnFields(DataTable columnList){
        scrollToElementsAndCompare2Lists(columnList,lstApprovedColumnFields);
    }

    //Scenario: Validate user able to view all the column fields under Denied bucket in FFS Professional screen
    public void verifyFFSProfessionalDeniedColumnFields(DataTable columnList){
        scrollToElementsAndCompare2Lists(columnList,lstDeniedColumnFields);
    }

    //Scenario: Validate user able to view all the column fields under Pre-Batch bucket in FFS Professional screen
    public void verifyFFSProfessionalPreBatchColumnFields(DataTable columnList){
        scrollToElementsAndCompare2Lists(columnList,lstPreBatchColumnFields);
    }

}
