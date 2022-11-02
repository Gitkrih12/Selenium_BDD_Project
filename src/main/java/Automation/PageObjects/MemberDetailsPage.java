package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MemberDetailsPage extends SeleniumUtils {


    String lnkPatientID = "//*[@class='subscribeid']/a";
    String tabMemberInfoPage = "//*[contains(@class,'active-tab')]";
    String lstMemberInfoFields = "//app-memberdetails//th";
    String tabsList = "//*[@class = 'nav nav-tabs']/button";
    String tabProviderDetails = "//*[@class= 'nav-link active']";
    String lstProviderDetails = "//*[@id='nav-providerDetails-details']//span[@ref = 'eText']";
    String tabAddress = "//*[@id='nav-address-details-tab']";
    String lstAddressColumns = "//*[@id='nav-address-details']//span[@ref = 'eText']";
    String tabMemberShipInformation = "//*[@id='nav-membershipInformation-details-tab']";
    String lstMemberShipInfoFields = "(//*[@class='grid-membership']//div[@class = 'ag-header-container'])[1]//span[@ref = 'eText']";
    String lstMemberShipHistory = "(//*[@class='grid-membership']//div[@class = 'ag-header-container'])[2]//span[@ref = 'eText']";
    String tabClaims = "//*[@id = 'nav-claims-details-tab']";
    String lstClaimsFields = "//*[@id = 'resultsGrid']//span[@ref = 'eText']";
    String txtSearchFields = "//*[@id = 'resultsGrid']//input[@type = 'text']";
    String tabCOB = "//*[@id = 'nav-cob-details-tab']";
    String lstCOBFields = "//*[@id = 'nav-cob-details']//span[@ref = 'eText']";
    String tabMOOP = "//*[@id = 'nav-moop-details-tab']";
    String lstMoopFields = "(//*[contains(@class, 'ag-theme-alpine')])[7]//span[@ref = 'eText']";
    String tabInstructions = "//*[@id = 'nav-adjudicatorInstructions-details-tab']";
    String lstInstructionFields = "//*[@id = 'nav-adjudicatorInstructions-details']//span[@ref = 'eText']";
    String tabHospice = "//*[@id = 'nav-hospice-details-tab']";
    String lstHospiceFields = "//*[@id = 'nav-hospice-details']//span[@ref = 'eText']";
    String lstMemberInfoFieldValues = "//app-memberdetails//td";
    String lstProviderDetailValues = "//*[@id='nav-providerDetails-details']//span[@class = 'ag-cell-value']";
    String lstAddressValues = "(//*[@id='nav-address-details']//div[contains(@class, 'ag-row-first')])[2]//span[@class = 'ag-cell-value' and text()]";
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String lstMemberShipInfoValues = "(//*[@class='grid-membership']//div[@ref='eBodyViewport'])[1]//div[@role = 'gridcell']";
    String lstMemberShipHistoryValues = "(//*[@class='grid-membership']//div[@ref='eBodyViewport'])[2]//div[@role = 'gridcell']";
    String lstClaimsFieldValues = "(//div[@id='nav-claims-details']//div[1]//a)[1] | (//div[@id='nav-claims-details']//div[@ref='eViewport']//div[@role='row'])[5]//span[text()]";
    String lstMoopFieldValues = "((//div[@id='nav-moop-details']//div[@role='rowgroup'])[2]//div[@role='row'])[1]//span";
    String inputHospice = "//*[@id = 'nav-hospice-details']//div[@class = 'ag-floating-filter-input']//input";
    String inputInstructions = "//*[@id = 'nav-adjudicatorInstructions-details']//div[@class = 'ag-floating-filter-input']//input";
    String inputMoop = "//*[@id = 'nav-moop-details']//div[@class = 'ag-floating-filter-input']//input";
    String inputCob = "//*[@id = 'nav-cob-details']//div[@class = 'ag-floating-filter-input']//input";
    String inputMemberShipHistory = "(//*[@class='grid-membership']//div[@class = 'ag-header-container'])[2]//div[@class = 'ag-floating-filter-input']//input";
    String inputMembershipInfo = "(//*[@class='grid-membership']//div[@class = 'ag-header-container'])[1]//div[@class = 'ag-floating-filter-input']//input";
    String inputAddress = "//*[@id='nav-address-details']//div[@class = 'ag-floating-filter-input']//input";
    String inputProviderDetails = "//*[@id='nav-providerDetails-details']//div[@class = 'ag-floating-filter-input']//input";

    private static String expMemberInfoTab = "";
    private static String expClaimNumber = "";


    //  Scenario: Verify user should navigates to Member Details screen on clicking Patient ID/MBR ID
    public void userClicksOnPatientID() {
        explicitElementClickableWaitByXpath(lnkPatientID, 40);
        clickElement(lnkPatientID);
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabProviderDetails), 20, "Provider Details");
    }

    public void verifyMemberInfoPage() {
        String actValue[] = findElementByXpath(tabMemberInfoPage).getText().split(" ");
        expMemberInfoTab = prop.getProperty("expMemberInfoScreen");
        Assert.assertEquals(expMemberInfoTab, actValue[0] + " " + actValue[1]);
    }

    //  Scenario: Verify fields in the Member Details page
    public void userViewsFields(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstMemberInfoFields, 40);
        compare2Lists(expFields, lstMemberInfoFields);
    }

    public void verifyFieldValuesUnderMemberDetails() {
        elementsDisplayValidation(lstMemberInfoFieldValues);
    }

    //  Scenario: Verify Member Details tabs
    public void userViewsTheTabs(DataTable expTabs) {
        explicitElementClickableWaitByXpath(tabsList, 30);
        compare2Lists(expTabs, tabsList);
    }

    //  Scenario: Verify user should navigate to Provider Details on Clicking Patient ID/MBR ID in View claim Details page
    public void userNavigatesDefaultToProviderDetails(String expValue) {
        String actualValue = findElementByXpath(tabProviderDetails).getAttribute("class");
        if (actualValue.contains(expValue)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //  Scenario: Verify column fields in Provider Details tab
    public void userViewsFieldsUnderProviderDetails(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstProviderDetails, 30);
        compare2Lists(expFields, lstProviderDetails);
    }

    public void verifySearchCriteriaInProviderDetails(){
        scrollToElementsAndValidateDisplayStatus(inputProviderDetails);
    }

    public void verifyFieldValuesUnderProviderDetails() {
        elementsDisplayValidation(lstProviderDetailValues);
    }

    //  Scenario: Verify user navigates to Address subtab in Member Details page
    public void userClicksOnAddressSubTab() throws InterruptedException {
        explicitElementClickableWaitByXpath(tabAddress, 30);
        clickElement(tabAddress);
    }

    public void userNavigatesToAddressSubTab(String expSubTab) {
        Assert.assertEquals(expSubTab, findElementByXpath(tabAddress).getText());
    }

    //  Scenario: Verify column fields in Address sub tab in Member Details page
    public void userViewAddressSubTabColumns(DataTable expColumns) {
        explicitElementClickableWaitByXpath(lstAddressColumns, 30);
        compare2Lists(expColumns, lstAddressColumns);
    }

    public void verifySearchCriteriaInAddress(){
        scrollToElementsAndValidateDisplayStatus(inputAddress);
    }

    public void verifyFieldValuesUnderAddress() {
        elementsDisplayValidation(lstAddressValues);
    }

    //  Scenario: Verify user should navigate to Membership Information tab in Member Details page
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void enterClaimNumberInSearchField() throws InterruptedException {
        explicitElementClickableWaitByXpath(inputClaimNumber, 20);
        expClaimNumber = prop.getProperty("membershipClaimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void clickOnClaimNumber() throws InterruptedException {
//        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 30);
        explicitElementClickableWaitByXpath(eleClaimNumber, 50);
        clickElement(eleClaimNumber);
    }

    public void userClicksOnMemberShipInfoSubTab() throws InterruptedException {
        explicitElementClickableWaitByXpath(tabMemberShipInformation, 30);
        clickElement(tabMemberShipInformation);
    }

    public void userNavigatesToMemberShipInformation(String expSubTab) {
        Assert.assertEquals(expSubTab, findElementByXpath(tabMemberShipInformation).getText());
    }

    //  Scenario: Verify column fields in Membership Information tab
    public void userViewMemberShipInfoColumns(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstMemberShipInfoFields, 40);
        compare2Lists(expFields, lstMemberShipInfoFields);
    }

    public void verifySearchCriteriaInMembershipInfo(){
        scrollToElementsAndValidateDisplayStatus(inputMembershipInfo);
    }

    public void verifyFieldValuesUnderMembershipInformation() {
        elementsDisplayValidation(lstMemberShipInfoValues);
    }

    //  Scenario: Verify user should able to see Membership History column fields
    public void userViewMemberShipHistoryColumns(DataTable expMemberShipHistoryColumns) {
        explicitElementClickableWaitByXpath(lstMemberShipHistory, 30);
        compare2Lists(expMemberShipHistoryColumns, lstMemberShipHistory);
    }

    public void verifySearchCriteriaInMembershipHistory(){
        scrollToElementsAndValidateDisplayStatus(inputMemberShipHistory);
    }

    public void verifyFieldValuesUnderMembershipHistory() {
        elementsDisplayValidation(lstMemberShipHistoryValues);
    }

    //  Scenario: Verify column fields in Claims subtab
    public void userClicksOnClaimsSubTab() {
        explicitElementClickableWaitByXpath(tabClaims, 40);
        clickElement(tabClaims);
    }

    public void userNavigatesToClaimsSubTab(String expClaimsSubTab) {
        Assert.assertEquals(expClaimsSubTab, findElementByXpath(tabClaims).getText());
    }

    public void userViewsAllFieldsUnderClaimsSubTab(DataTable expColumns) {
        explicitElementClickableWaitByXpath(lstClaimsFields, 50);
        scrollToElementsAndCompare2Lists(expColumns, lstClaimsFields);
    }

    public void verifyFieldValuesUnderClaims() {
        elementsDisplayValidation(lstClaimsFieldValues);
    }

    //  Scenario: Verify Search functionality in claims subtab
    public void verifySearchBoxForAllFields() {
        scrollToElementsAndValidateDisplayStatus(txtSearchFields);
    }

    public void userClicksOnCOB() throws InterruptedException {
        explicitElementClickableWaitByXpath(tabCOB, 30);
        clickElement(tabCOB);
    }

    // Scenario: Verify user should navigate to COB tab and view column fields in Member Details page
    public void userNavigatesToCOBSubTab(String expSubTab) {
        Assert.assertEquals(expSubTab, findElementByXpath(tabCOB).getText());
    }

    public void verifyCOBFields(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstCOBFields, 30);
        compare2Lists(expFields, lstCOBFields);
    }

    public void verifySearchCriteriaInCob(){
        scrollToElementsAndValidateDisplayStatus(inputCob);
    }

    /*public void verifyCOBFieldValues(){
        List<WebElement> claimsValues = findElementsByXpath();
        System.out.println("Size:" + claimsValues.size());
        for (WebElement value : claimsValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }*/

    //  Scenario: Verify user should navigate to MOOP tab and view column fields in Member Details page
    public void userClicksOnMOOPSubtab() throws InterruptedException {
        explicitElementClickableWaitByXpath(tabMOOP, 30);
        clickElement(tabMOOP);
    }

    public void userNavigatesToMOOPSubtab(String expSubtab) {
        Assert.assertEquals(expSubtab, findElementByXpath(tabMOOP).getText());
    }

    public void verifyFieldsUnderMOOPSubtab(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstMoopFields, 30);
        compare2Lists(expFields, lstMoopFields);
    }

    public void verifySearchCriteriaInMoop(){
        scrollToElementsAndValidateDisplayStatus(inputMoop);
    }

    public void verifyMoopFieldValues() {
        elementsDisplayValidation(lstMoopFieldValues);
    }

    //  Scenario: Verify user should navigate to Instructions tab and view column fields in Member Details page
    public void userClicksOnInstructionsSubtab() throws InterruptedException {
        explicitElementClickableWaitByXpath(tabInstructions, 30);
        clickElement(tabInstructions);
    }

    public void verifyUserNavigatesToInstructions(String expSubtab) {
        Assert.assertEquals(expSubtab, findElementByXpath(tabInstructions).getText());
    }

    public void verifyColumnsUnderInstructions(DataTable expColumns) {
        explicitElementClickableWaitByXpath(lstInstructionFields, 30);
        compare2Lists(expColumns, lstInstructionFields);
    }

    public void verifySearchCriteriaInInstructions(){
        scrollToElementsAndValidateDisplayStatus(inputInstructions);
    }

    public void verifyFieldValuesUnderInstructions() {
        elementsDisplayValidation(lstMoopFieldValues);
    }

    //  Scenario: Verify user should navigate to HOSPICE tab and view column fields in Member Details page
    public void userClicksOnHospiceSubtab() throws InterruptedException {
        explicitElementClickableWaitByXpath(tabHospice, 30);
        clickElement(tabHospice);
    }

    public void userNavigatesToHospiceSubtab(String expSubtab) {
        Assert.assertEquals(expSubtab, findElementByXpath(tabHospice).getText());
    }

    public void verifyFieldsUnderHospice(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstHospiceFields, 30);
        compare2Lists(expFields, lstHospiceFields);
    }

    public void verifySearchCriteriaInHospice(){
        scrollToElementsAndValidateDisplayStatus(inputHospice);
    }
}