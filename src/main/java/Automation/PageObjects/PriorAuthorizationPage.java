package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class PriorAuthorizationPage extends SeleniumUtils {

    String lnkMemberManagement = "//*[contains(text(), ' Member Management ')]";
    String lnkPriorAuthorization = "//*[contains(text(), ' Prior Authorization ')]";
    String lstPriorAuthorization = "//*[@class = 'row check-top']//span";
    String txtAuthNumber = "//*[@id = 'authorizationNumber']";
    String btnSearch = "//button[contains(text(), 'Search')]";
    String txtMemberID = "//*[@id = 'memberID']";
    String txtMemberName = "//*[@id = 'memberName']";
    String txtFromDate = "//*[@id = 'fromDate']";
    String txtToDate = "//*[@id = 'toDate']";
    String txtStatus = "//*[@id = 'status']";
    String eleAuthorizationNumber = "(//*[@col-id='referenceNumber']//a)[1]";
    String eleMemberID = "(//*[@col-id='subscriberID']//span[@class = 'ag-cell-value'])[1]";
    String eleMemberName = "(//*[@col-id='memberName']//span[@class = 'ag-cell-value'])[1]";
    String eleFromDate = "(//*[@col-id='fromDate']//span[@class = 'ag-cell-value'])[1]";
    String eleToDate = "(//*[@col-id='toDate']//span[@class = 'ag-cell-value'])[1]";
    String eleStatus = "(//*[@col-id='authStatus']//span[@class = 'ag-cell-value'])[1]";
    String innerScrollBarMemberList = "//div[@class='ag-body-horizontal-scroll-viewport']";
    String titleAuthSummary = "//*[@class = 'dailog-title']//span";
    String elePlanAuthNumber = "//*[contains(text(), 'PLAN AUTH NUMBER')]";
    String lstLegends = "//*[@class = 'legendStyle']//span";
    String lstMemberInfoFields = "(//*[@class = 'fsStyle'])[1]//label";
    String lstMemberInfoFieldValues = "(//*[@class = 'fsStyle'])[1]//span[contains(@class, 'field-value')]";
    String lstAuthFields = "(//*[@class = 'fsStyle'])[2]//label";
    String lstAuthFieldValues = "(//*[@class = 'fsStyle'])[2]//span[contains(@class, 'field-value') and text()]";
    String lstRequestingProviderFields = "(//*[@class = 'fsStyle ng-star-inserted'])[1]//label[@class = 'field-name']";
    String lstRequestingProviderValues = "(//*[@class = 'fsStyle ng-star-inserted'])[1]//span[@class = 'field-value' and text()]";
    String lstAttendingProviderFields = "(//*[@class = 'fsStyle ng-star-inserted'])[2]//label[@class = 'field-name']";
    String lstAttendingProviderFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[2]//span[@class = 'field-value' and text()]";
    String lstAdmittingProviderFields = "(//*[@class = 'fsStyle ng-star-inserted'])[3]//label[@class = 'field-name']";
    String lstAdmittingProviderFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[3]//span[@class = 'field-value' and text()]";
    String lstFacilityFields = "(//*[@class = 'fsStyle ng-star-inserted'])[4]//label[@class = 'field-name']";
    String lstFacilityFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[3]//span[@class = 'field-value' and text()]";
    String lstAdmissionDcDatesFields = "(//*[@class = 'fsStyle ng-star-inserted'])[5]//label[@class = 'field-name']";
    String lstAdmissionDcDatesFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[5]//span[@class = 'field-value' and text()]";
    String lstLengthOfStayFields = "(//*[@class = 'fsStyle ng-star-inserted'])[6]//label[@class = 'field-name']";
    String lstLengthOfStayFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[6]//span[@class = 'field-value' and text()]";
    String lstPrimaryIcdDetailsAndCptHcpcsCodeFields = "//*[@class = 'col-header']";
    String lstPrimaryIcdDetailsAndCptHcpcsCodeFieldValues = "//*[@class = 'col-value']";
    String lstDocumentsFields = "(//*[@class = 'table table-striped'])[3]//th";
    String lstDocumentsFieldValues = "(//*[@class = 'border-2'])[6]//td";

    private static String expAuthorizationNumber = "";
    private static String expMemberID = "";
    private static String expMemberName = "";
    private static String expFromDate = "";
    private static String expToDate = "";
    private static String expStatus = "";

    //  Scenario: Verify user able to view all the columns when user clicks on Prior Authorization under Member Management
    public void userClicksMemberManagement() {
        explicitVisibilityOfWait(findElementByXpath(lnkMemberManagement), 20);
        clickElement(lnkMemberManagement);
    }

    public void userClickOnPriorAuthorization() {
        explicitVisibilityOfWait(findElementByXpath(lnkPriorAuthorization), 20);
        clickElement(lnkPriorAuthorization);
    }

    public void verifyPriorAuthorizationPage(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(lnkPriorAuthorization).getText());
    }

    public void verifyPriorAuthorizationFields(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstPriorAuthorization, 20);
        scrollToElementsAndCompare2Lists(expFields, lstPriorAuthorization);
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for Authorization number
    public void userEntersAuthorizationNumber() {
        expAuthorizationNumber = prop.getProperty("authNumber");
        explicitElementClickableWaitByXpath(txtAuthNumber, 20);
        findElementAndSendKeys(findElementByXpath(txtAuthNumber), expAuthorizationNumber);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyAuthorizationFieldValueUnderPriorAuthorization() {
        explicitElementClickableWaitByXpath(eleAuthorizationNumber, 20);
        Assert.assertEquals(expAuthorizationNumber, findElementByXpath(eleAuthorizationNumber).getText());
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for Member ID
    public void userEntersMemberID() {
        expMemberID = prop.getProperty("priorAuthMemberID");
        explicitElementClickableWaitByXpath(txtMemberID, 20);
        findElementAndSendKeys(findElementByXpath(txtMemberID), expMemberID);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyMemberIDFieldValueUnderPriorAuthorization() {
        explicitElementClickableWaitByXpath(eleMemberID, 20);
        Assert.assertEquals(expMemberID, findElementByXpath(eleMemberID).getText());
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for Member Name
    public void userEntersMemberName() {
        expMemberName = prop.getProperty("memberName");
        explicitElementClickableWaitByXpath(txtMemberName, 20);
        findElementAndSendKeys(findElementByXpath(txtMemberName), expMemberName);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyMemberNameFieldValue() {
        explicitElementClickableWaitByXpath(eleMemberName, 20);
        Assert.assertEquals(expMemberName, findElementByXpath(eleMemberName).getText());
    }

    public void userEntersFromDate() {
        expFromDate = prop.getProperty("fromDate");
        explicitElementClickableWaitByXpath(txtFromDate, 20);
        findElementAndSendKeys(findElementByXpath(txtFromDate), expFromDate);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for From Date
    public void verifyFromDateFieldValue() {
        explicitElementClickableWaitByXpath(eleFromDate, 20);
        Assert.assertEquals(expFromDate, findElementByXpath(eleFromDate).getText());
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for To Date
    public void userEntersToDate() {
        expToDate = prop.getProperty("toDate");
        explicitElementClickableWaitByXpath(txtToDate, 20);
        findElementAndSendKeys(findElementByXpath(txtToDate), expToDate);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyToDateFieldValue() {
        explicitElementClickableWaitByXpath(eleToDate, 20);
        Assert.assertEquals(expToDate, findElementByXpath(eleToDate).getText());
    }

    //  Scenario: Verify user able to search the criteria in the Prior Authorization for Status
    public void userEntersStatus() {
        expStatus = prop.getProperty("priorAuthStatus");
        explicitElementClickableWaitByXpath(txtStatus, 20);
        findElementAndSendKeys(findElementByXpath(txtStatus), expStatus);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyStatusFieldValue() {
        WebElement ele = findElementByXpath(innerScrollBarMemberList);
        ele.click();
        moveToElement(ele).clickAndHold().moveByOffset(300, 0).release().perform();
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleStatus), 40, expStatus);
        Assert.assertEquals(expStatus, findElementByXpath(eleStatus).getText());
    }

    //  Scenario: Verify Authorization summary pop up should display on clicking Authorization number
    public void userClicksOnAuthorizationNumber() {
        explicitElementClickableWaitByXpath(eleAuthorizationNumber, 20);
        clickElement(eleAuthorizationNumber);
        explicitTextToBePresentInElementLocatedWait(By.xpath(elePlanAuthNumber), 20, "PLAN AUTH NUMBER");
    }

    public void verifyAuthorizationSummaryPopUpDisplayed(String expPopUp) {
        Assert.assertEquals(expPopUp, findElementByXpath(titleAuthSummary).getText());
    }

    public void verifyPlanAuthNumber(String expField) {
        Assert.assertEquals(expField, findElementByXpath(elePlanAuthNumber).getText());
    }

    //  Scenario: Verify all the legends should display in the Authorization summary pop up
    public void verifyAllLegends(DataTable expLegends) {
        scrollToElementsAndCompare2Lists(expLegends, lstLegends);
    }

    //  Scenario: Verify all fields under Member Information section
    public void verifyMemberInformationSection(DataTable expFields) {
        compare2Lists(expFields, lstMemberInfoFields);
    }

    public void verifyFieldValuesUnderMemberInfo() {
        elementsDisplayValidation(lstMemberInfoFieldValues);
    }

    //  Scenario: Verify user able to view all the fields under Auth Details section
    public void verifyFieldsUnderAuthDetails(DataTable expFields) {
        compare2Lists(expFields, lstAuthFields);
    }

    public void verifyFieldValuesUnderAuthDetails() {
        elementsDisplayValidation(lstAuthFieldValues);
    }

    //  Scenario: Verify user able to view all the fields mentioned under Requesting Provider (IN) Section
    public void verifyFieldsUnderRequestingProvider(DataTable expFields) {
        compare2Lists(expFields, lstRequestingProviderFields);
    }

    public void verifyFieldValuesUnderRequestingProvider() {
        elementsDisplayValidation(lstRequestingProviderValues);
    }

    //  Scenario: Verify user able to view all the fields under Attending Provider (IN) section
    public void verifyFieldsUnderAttendingProvider(DataTable expFields) {
        compare2Lists(expFields, lstAttendingProviderFields);
    }

    public void verifyFieldValuesUnderAttendingProvider() {
        elementsDisplayValidation(lstAttendingProviderFieldValues);
    }

    //  Scenario: Verify user able to view all the fields under Admitting Provider (IN)
    public void verifyFieldsUnderAdmittingProvider(DataTable expFields) {
        compare2Lists(expFields, lstAdmittingProviderFields);
    }

    public void verifyFieldValuesUnderAdmittingProvider() {
        elementsDisplayValidation(lstAdmittingProviderFieldValues);
    }

    //  Scenario: Verify user able to view all the fields under Facility (IN) section
    public void verifyFieldsUnderFacility(DataTable expFields) {
        compare2Lists(expFields, lstFacilityFields);
    }

    public void verifyFieldValuesUnderFacility() {
        elementsDisplayValidation(lstFacilityFieldValues);
    }

    //  Scenario: Verify user able to view all the fields under Admission/DC Dates
    public void verifyFieldsUnderAdmissionDCDates(DataTable expFields) {
        compare2Lists(expFields, lstAdmissionDcDatesFields);
    }

    public void verifyFieldValuesUnderAdmissionDcDates() {
        elementsDisplayValidation(lstAdmissionDcDatesFieldValues);
    }

    //  Scenario: Verify user able to view all the fields under Length Of Stay section
    public void verifyFieldsUnderLengthOfStay(DataTable expFields) {
        compare2Lists(expFields, lstLengthOfStayFields);
    }

    public void verifyFieldValuesUnderLengthOfStay() {
        elementsDisplayValidation(lstLengthOfStayFieldValues);
    }

    //  Scenario: Verify user able to view all the fields under Primary ICD Details and CPT/HCPCS Code Table
    public void verifyFieldsUnderPrimaryICDDetailsAndCptHcpcsCode(DataTable expFields) {
        compare2Lists(expFields, lstPrimaryIcdDetailsAndCptHcpcsCodeFields);
    }

    public void verifyFieldValuesUnderPrimaryICDDetailsAndCptHcpcsCode() {
        elementsDisplayValidation(lstPrimaryIcdDetailsAndCptHcpcsCodeFieldValues);
    }

    //  Scenario: Verify user able to view all the fields under Documents Table
    public void verifyFieldsUnderDocuments(DataTable expFields) {
        compare2Lists(expFields, lstDocumentsFields);
    }

    public void verifyFieldValuesUnderDocuments() {
        elementsDisplayValidation(lstDocumentsFieldValues);
    }
}