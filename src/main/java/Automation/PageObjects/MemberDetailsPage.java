package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import org.junit.Assert;
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
    String lstClaimsFieldValues = "((//*[@id = 'resultsGrid']//div[@role = 'rowgroup'])[2]//div)[1]//span[@class = 'ag-cell-value' and text()]";
    String lstMoopFieldValues = "(//*[contains(@class, 'ag-theme-alpine')])[7]//span[@class = 'ag-cell-value']";

    private static String expMemberInfoTab = "";
    private static String expClaimNumber = "";


    //  Scenario: Verify user should navigates to Member Details screen on clicking Patient ID/MBR ID
    public void userClicksOnPatientID() throws InterruptedException {
        explicitElementClickableWaitByXpath(lnkPatientID, 40);
        clickElement(lnkPatientID);
        threadSleep(3000);
    }

    public void verifyMemberInfoPage() {
        String actValue[] = findElementByXpath(tabMemberInfoPage).getText().split(" ");
        expMemberInfoTab = prop.getProperty("expMemberInfoScreen");
        Assert.assertEquals(expMemberInfoTab, actValue[0] + actValue[1]);
    }

    //  Scenario: Verify fields in the Member Details page
    public void userViewsFields(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        explicitElementClickableWaitByXpath(lstMemberInfoFields, 40);
        List<String> ActFields = findElementsByXpath(lstMemberInfoFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Member Info Fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    public void verifyFieldValuesUnderMemberDetails() {
        List<WebElement> memberDetailsValues = findElementsByXpath(lstMemberInfoFieldValues);
        System.out.println("Size:" + memberDetailsValues.size());
        for (WebElement value : memberDetailsValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    //  Scenario: Verify Member Details tabs
    public void userViewsTheTabs(DataTable expTabs) {
        List<String> fieldsExp = expTabs.asList();
        explicitElementClickableWaitByXpath(tabsList, 30);
        List<String> ActFields = findElementsByXpath(tabsList)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("All the tabs should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
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

    public void verifyFieldValuesUnderProviderDetails() {
        List<WebElement> providerDetailsValues = findElementsByXpath(lstProviderDetailValues);
        System.out.println("Size:" + providerDetailsValues.size());
        for (WebElement value : providerDetailsValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
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

    public void verifyFieldValuesUnderAddress() {
        List<WebElement> addressValues = findElementsByXpath(lstAddressValues);
        System.out.println("Size:" + addressValues.size());
        for (WebElement value : addressValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    //  Scenario: Verify user should navigate to Membership Information tab in Member Details page
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void enterClaimNumberInSearchField() throws InterruptedException {
        threadSleep(1000);
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

    public void verifyFieldValuesUnderMembershipInformation() {
        List<WebElement> membershipInfoValues = findElementsByXpath(lstMemberShipInfoValues);
        System.out.println("Size:" + membershipInfoValues.size());
        for (WebElement value : membershipInfoValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    //  Scenario: Verify user should able to see Membership History column fields
    public void userViewMemberShipHistoryColumns(DataTable expMemberShipHistoryColumns) {
        explicitElementClickableWaitByXpath(lstMemberShipHistory, 30);
        compare2Lists(expMemberShipHistoryColumns, lstMemberShipHistory);
    }

    public void verifyFieldValuesUnderMembershipHistory() {
        List<WebElement> membershipHistoryValues = findElementsByXpath(lstMemberShipHistoryValues);
        System.out.println("Size:" + membershipHistoryValues.size());
        for (WebElement value : membershipHistoryValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
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
        compare2Lists(expColumns, lstClaimsFields);
    }

    public void verifyFieldValuesUnderClaims() {
        List<WebElement> claimsValues = findElementsByXpath(lstClaimsFieldValues);
        System.out.println("Size:" + claimsValues.size());
        for (WebElement value : claimsValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    //  Scenario: Verify Search functionality in claims subtab
    public void verifySearchBoxForAllFields() {
        List<WebElement> ActSearchFields = findElementsByXpath(txtSearchFields);
        explicitElementClickableWaitByXpath(txtSearchFields, 50);
        for (WebElement column : ActSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
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
        List<String> fieldsExp = expFields.asList();
        explicitElementClickableWaitByXpath(lstMoopFields, 30);
        List<String> actFields = findElementsByXpath(lstMoopFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + actFields.size());
        System.out.println("Moop Fields should display:" + actFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(actFields, fieldsExp);
    }

    public void verifyMoopFieldValues() {
        List<WebElement> moopFieldValues = findElementsByXpath(lstMoopFieldValues);
        System.out.println("Size:" + moopFieldValues.size());
        for (WebElement value : moopFieldValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
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

    public void verifyFieldValuesUnderInstructions() {
        List<WebElement> instructionsFieldValues = findElementsByXpath(lstMoopFieldValues);
        System.out.println("Size:" + instructionsFieldValues.size());
        for (WebElement value : instructionsFieldValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
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
}