package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;

import java.util.ArrayList;
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
    String lstColumnFieldsExtra = "//ag-grid-angular[@id='pendGrid']//div[@class='ag-header-cell-label']//span[text()]";
    String tabPendState = "(//button[@class='nav-link active'])[1]";
    String lstQueues = "//div[@id='nav-tab']//button";
    String elePendQueuePage = "(//span[@class='ag-cell-value']//app-view-claim-render)[1]";
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
    String tabViewClaim = "//div[@class='col ng-star-inserted active-tab']";
    String eleClaimSummary = "//div[@class='claim-summary']";
    String tabFFSProfessionalDefault = "//div[@class='col ng-star-inserted default-tab' and contains(text(),'FFS Professional')]";
    String tabViewClaimDefault = "//div[@class='col ng-star-inserted default-tab' and contains(text(),'View')]";







    private static String expClaimNumber = "";




    //Verify color code for corrected claims in FFS Professional page
    public void clickOnFFSProfessional(){
        explicitVisibilityOfWait(findElementByXpath(lnkFFSProfessional), 5);
        clickElement(lnkFFSProfessional);
    }
    public void verifyFFSProfessionalPage(){
        boolean value = isDisplayed(tabFFSProfessional);
        Assert.assertTrue(value);

    }
    public void enterCorrectedClaimNumberInFFSProfessionalSearchField() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("ffsProfessionalCorrectedClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void validateClaimNumberResult() {
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

    //Verify color code for COB Not In Member House in FFS Professional page
    public void enterCOBInMemberHouseClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("cobInMemberHouse");
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

    //Scenario: Verify color code for COB Not In Member House in FFS Professional page
    public void enterCOBNotInMemberHouseClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("cobNotInMemberHouse");
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
        threadSleep(20000);
        clickElement(eleClaimNumber);
    }
    public void clickOnFFSProfessionalDefaultTab(){
        clickElement(tabFFSProfessionalDefault);
    }
    public void verifyViewClaimDetailsTab(){
        Assert.assertTrue(isDisplayed(tabViewClaim));
    }
    public void verifyClaimSummaryOption(String expOption){
        String actOption=findElementByXpath(eleClaimSummary).getText();
        System.out.println("actOption "+actOption);
        if(actOption.contains(expOption)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }
    public void getOpenedClaimNumber(){
        String viewClaimNumberText=findElementByXpath(tabViewClaim).getText();
        String[] claimData=viewClaimNumberText.split(" ");
        expClaimNumber=claimData[2].substring(1);
        System.out.println("claim number "+expClaimNumber);

    }
    public void verifyUserShouldSeeAlreadyOpenedClaimNumber(){
        clickElement(tabViewClaimDefault);
        String viewClaimNumberTextOnSecondClick=findElementByXpath(tabViewClaim).getText();
        String[] claimData=viewClaimNumberTextOnSecondClick.split(" ");
        String actClaimNumber=claimData[2].substring(1);
        System.out.println("act claim number "+actClaimNumber);
        Assert.assertEquals(expClaimNumber,actClaimNumber);
    }

    //Scenario: Verify user able to navigate to claim summary screen only once when performed multiple clicks on Claim number
    public void enterClaimNumberInPendFFSProfessionalSearchField() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("ffsProfessionalClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    //Scenario:Verify colour coding for Unclean status claims under Pend bucket in FFS professional page
    public void enterUnCleanStatusPendClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("unCleanStatusPendClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }

    public void verifyVerticalColorIndicationForUncleanPendClaim(String expColorIndication){
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanPendClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }
    public void verifyUncleanInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleUncleanInfoTopGrid);
        Assert.assertTrue(value);
    }

    //Scenario: Verify colour coding for Unclean status claims under Payer Review bucket in FFS professional page
    public void clickOnPayerReviewBucket(){
        clickElement(tabPayerReview);
    }

    public void enterUnCleanStatusPayerReviewClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("unCleanStatusPayerReviewClaimNumber");
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
    public void verifyVerticalColorIndicationForUncleanPayerReviewClaim(String expColorIndication){
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanPayerReviewClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }
    //Scenario: Verify colour coding for Unclean status claims under Management Review bucket in FFS professional page
    public void clickOnManagementReviewBucket(){
        clickElement(tabManagementReview);
    }

    public void enterUnCleanStatusManagementReviewClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("unCleanStatusManagementReviewClaimNumber");
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
    public void verifyVerticalColorIndicationForUncleanManagementReviewClaim(String expColorIndication){
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanManagementReviewClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Approved bucket in FFS professional page
    public void clickOnApprovedBucket(){
        clickElement(tabApproved);
    }

    public void enterUnCleanStatusApprovedClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("unCleanStatusApprovedClaimNumber");
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
    public void verifyVerticalColorIndicationForUncleanApprovedClaim(String expColorIndication){
        String actColorCode = getColorCodeForBackground(eleVerticalColorForUncleanApprovedClaim);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    //Scenario: Verify colour coding for Unclean status claims under Denied bucket in FFS professional page
    public void clickOnDeniedBucket(){
        clickElement(tabDenied);
    }

    public void enterUnCleanStatusDeniedClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("unCleanStatusDeniedClaimNumber");
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
    //Scenario: Verify colour coding for Unclean status claims under Pre Batch bucket in FFS professional page
    public void clickOnPreBatchBucket(){
        clickElement(tabPreBatch);
    }

    public void enterUnCleanStatusPreBatchClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("unCleanStatusPreBatchClaimNumber");
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



    //Scenario: Validate user able to view all the column fields for Pend bucket in FFS Professional screen
    public void verifyPendStateByDefault(String expState) throws InterruptedException{
        threadSleep(20000);
        String actState=findElementByXpath(tabPendState).getAttribute("class");
        if(actState.contains(expState)){
            Assert.assertTrue(true);
        }else{
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

    public void verifyQueuesInFFSProfessional(DataTable queueList) throws InterruptedException{
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
            }else{
                actualQueueFieldsForCompare.add(queueData[0].substring(0,8));
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

    public void verifyUserByDefaultInPendStateResultsPage() throws InterruptedException {
        threadSleep(20000);
        boolean value=isDisplayed(elePendQueuePage);
        Assert.assertTrue(value);
    }



}
