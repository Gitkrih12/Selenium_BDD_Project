package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
    String lstMemberInfoFieldValues = "(//*[@class = 'fsStyle'])[1]//span[contains(@class, 'field-value') and text()!='']";
    String lstAuthFields = "(//*[@class = 'fsStyle'])[2]//label";
    String lstAuthFieldValues = "(//*[@class = 'fsStyle'])[2]//span[contains(@class, 'field-value') and text()!='']";
    String lstRequestingProviderFields = "(//*[@class = 'fsStyle ng-star-inserted'])[1]//label[@class = 'field-name']";
    String lstRequestingProviderValues = "(//*[@class = 'fsStyle ng-star-inserted'])[1]//span[@class = 'field-value' and text()!='']";
    String lstAttendingProviderFields = "(//*[@class = 'fsStyle ng-star-inserted'])[2]//label[@class = 'field-name']";
    String lstAttendingProviderFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[2]//span[@class = 'field-value' and text()!='']";
    String lstAdmittingProviderFields = "(//*[@class = 'fsStyle ng-star-inserted'])[3]//label[@class = 'field-name']";
    String lstAdmittingProviderFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[3]//span[@class = 'field-value' and text()!='']";
    String lstFacilityFields = "(//*[@class = 'fsStyle ng-star-inserted'])[4]//label[@class = 'field-name']";
    String lstFacilityFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[4]//span[@class = 'field-value' and text()!='']";
    String lstAdmissionDcDatesFields = "(//*[@class = 'fsStyle ng-star-inserted'])[5]//label[@class = 'field-name']";
    String lstAdmissionDcDatesFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[5]//span[@class = 'field-value' and text()!='']";
    String lstLengthOfStayFields = "(//*[@class = 'fsStyle ng-star-inserted'])[6]//label[@class = 'field-name']";
    String lstLengthOfStayFieldValues = "(//*[@class = 'fsStyle ng-star-inserted'])[6]//span[@class = 'field-value' and text()!='']";
    String lstPrimaryIcdDetailsAndCptHcpcsCodeFields = "//*[@class = 'col-header']";
    String lstPrimaryIcdDetailsAndCptHcpcsCodeFieldValues = "//*[@class = 'col-value']";
    String lstDocumentsFields = "(//*[@class = 'table table-striped'])[3]//th";
    String lstDocumentsFieldValues = "(//*[@class = 'border-2'])[6]//td";
    String titlePriorAuth = "//h5[contains(text(), 'Prior Authorization')]";
    String btnClear = "//button[contains(text(), 'Cancel')]";
    String lstFieldsResultCriteria = "//*[@ref='eText']";
    String lstPOS = "//span[text()='POS']";
    String lstStatus = "(//span[text()='Status'])[2]";
    String txtAuthorizationNumber = "//*[@aria-label='Authorization Number Filter Input']";
    String txtSubscriberId = "//*[@aria-label='Subscriber ID Filter Input']";
    String txtPriorMemberName = "//*[@aria-label='Member Name Filter Input']";
    String txtProviderNpi = "//*[@aria-label='Provider NPI Filter Input']";
    String eleProviderNpi = "(//*[@col-id='providerNPI']//span[@class = 'ag-cell-value'])[1]";
    String txtTaxID = "//*[@aria-label='Tax ID Filter Input']";
    String eleTaxId = "(//*[@col-id='providerTaxID']//span[@class = 'ag-cell-value'])[1]";
    String txtProviderName = "//*[@aria-label='Provider Name Filter Input']";
    String eleProviderName = "(//*[@col-id='providerName']//span[@class = 'ag-cell-value'])[1]";
    String txtCptUnits = "//*[@aria-label='CPT-Units Filter Input']";
    String eleCptUnits = "(//*[@col-id='cptCode']//span[@class = 'ag-cell-value'])[1]";
    String txtICDCode = "//*[@aria-label='ICD Code Filter Input']";
    String eleICDCode = "(//*[@col-id='icdCode']//span[@class = 'ag-cell-value'])[1]";
    String txtPriorFromDate = "//*[@aria-label='From Date Filter Input']";
    String txtPriorToDate = "//*[@aria-label='To Date Filter Input']";
    String txtReceivedDate = "//*[@aria-label='Received Date Filter Input']";
    String eleReceivedDate = "(//*[@col-id='receivedDate']//span[@class = 'ag-cell-value'])[1]";
    String txtPOS = "//*[@aria-label='POS Filter Input']";
    String elePOS = "(//*[@col-id='posAbb']//span[@class = 'ag-cell-value'])[1]";
    String txtPriorStatus = "//*[@aria-label='Status Filter Input']";

    private static String expAuthorizationNumber = "";
    private static String expMemberID = "";
    private static String expMemberName = "";
    private static String expFromDate = "";
    private static String expToDate = "";
    private static String expStatus = "";
    private static String expValue = "";
    private static String expProviderNpi = "";
    private static String expTaxID = "";
    private static String expProviderName = "";
    private static String expCptUnits = "";
    private static String expIcdCode = "";
    private static String expReceivedDate = "";
    private static String expPOS = "";


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
        explicitTextToBePresentInElementLocatedWait(By.xpath(titlePriorAuth), 20, "Prior Authorization");
        Assert.assertEquals(expTab, findElementByXpath(titlePriorAuth).getText());
    }

    public void verifyPriorAuthorizationFields(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstPriorAuthorization, 20);
        compare2Lists(expFields, lstPriorAuthorization);
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
        explicitElementClickableWaitByXpath(eleAuthorizationNumber, 40);
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
        explicitElementClickableWaitByXpath(eleMemberID, 40);
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
        explicitElementClickableWaitByXpath(eleMemberName, 30);
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
        explicitElementClickableWaitByXpath(eleFromDate, 40);
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
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleToDate), 30, expToDate);
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

    //  //  Scenario: Verify user able to clear the Authorization number entered in search criteria by clicking on cancel button
    public void userEntersAuthorizationNumberAndClicksOnClear() {
        expAuthorizationNumber = prop.getProperty("authNumber");
        explicitElementClickableWaitByXpath(txtAuthNumber, 20);
        findElementAndSendKeys(findElementByXpath(txtAuthNumber), expAuthorizationNumber);
        explicitElementClickableWaitByXpath(btnClear, 30);
        clickElement(btnClear);
    }

    public void verifyAuthorizationNumberCleared() {
        explicitElementClickableWaitByXpath(txtAuthNumber, 20);
        Assert.assertEquals(expValue, findElementByXpath(txtAuthNumber).getAttribute("value"));
    }

    //  Scenario: Verify user able to clear the Member ID entered in search criteria by clicking on cancel button
    public void userEntersMemberIdAndClicksOnClear() {
        expMemberID = prop.getProperty("priorAuthMemberID");
        explicitElementClickableWaitByXpath(txtMemberID, 20);
        findElementAndSendKeys(findElementByXpath(txtMemberID), expMemberID);
        explicitElementClickableWaitByXpath(btnClear, 30);
        clickElement(btnClear);
    }

    public void verifyMemberIdCleared() {
        explicitElementClickableWaitByXpath(txtMemberID, 20);
        Assert.assertEquals(expValue, findElementByXpath(txtMemberID).getAttribute("value"));
    }

    //  Scenario: Verify user able to clear the Member Name entered in search criteria by clicking on cancel button
    public void userEntersMemberNameAndClicksOnClear() {
        expMemberName = prop.getProperty("memberName");
        explicitElementClickableWaitByXpath(txtMemberName, 20);
        findElementAndSendKeys(findElementByXpath(txtMemberName), expMemberName);
        explicitElementClickableWaitByXpath(btnClear, 30);
        clickElement(btnClear);
    }

    public void verifyMemberNameCleared() {
        explicitElementClickableWaitByXpath(txtMemberName, 20);
        Assert.assertEquals(expValue, findElementByXpath(txtMemberName).getAttribute("value"));
    }

    //  Scenario: Verify user able to clear the From Date (DOS) entered in search criteria by clicking on cancel button
    public void userEntersFromDateAndClicksOnClear() {
        expFromDate = prop.getProperty("fromDate");
        explicitElementClickableWaitByXpath(txtFromDate, 20);
        findElementAndSendKeys(findElementByXpath(txtFromDate), expFromDate);
        explicitElementClickableWaitByXpath(btnClear, 30);
        clickElement(btnClear);
    }

    public void verifyFromDateCleared() {
        explicitElementClickableWaitByXpath(txtFromDate, 20);
        Assert.assertEquals(expValue, findElementByXpath(txtFromDate).getAttribute("value"));
    }

    //  Scenario: Verify user able to clear the To Date (DOS) entered in search criteria by clicking on cancel button
    public void userEntersToDateAndClicksOnClear() {
        expToDate = prop.getProperty("toDate");
        explicitElementClickableWaitByXpath(txtToDate, 20);
        findElementAndSendKeys(findElementByXpath(txtToDate), expToDate);
        explicitElementClickableWaitByXpath(btnClear, 30);
        clickElement(btnClear);
    }

    public void verifyToDateCleared() {
        explicitElementClickableWaitByXpath(txtToDate, 20);
        Assert.assertEquals(expValue, findElementByXpath(txtToDate).getAttribute("value"));
    }

    //  Scenario: Verify user able to clear the Status entered in search criteria by clicking on cancel button
    public void userEntersStatusAndClicksOnClear() {
        expStatus = prop.getProperty("priorAuthStatus");
        explicitElementClickableWaitByXpath(txtStatus, 20);
        findElementAndSendKeys(findElementByXpath(txtStatus), expStatus);
        explicitElementClickableWaitByXpath(btnClear, 30);
        clickElement(btnClear);
    }

    public void verifyStatusCleared() {
        explicitElementClickableWaitByXpath(txtStatus, 20);
        Assert.assertEquals(expValue, findElementByXpath(txtStatus).getAttribute("value"));
    }

    //  Scenario: Verify the result criteria fields should display when user searches in any of the fields in Prior Authorization
    public void verifyFieldsResultsCriteria(DataTable expResultsFields) {
        explicitElementClickableWaitByXpath(lstFieldsResultCriteria, 30);
        List<String> fieldsExp = expResultsFields.asList();
        List<WebElement> fields = driver.findElements(By.xpath(lstFieldsResultCriteria));
        List<String> fieldsAct = new ArrayList<>();
        for (WebElement field : fields) {
            scrollIntoView(field, driver);
            explicitElementClickableWait(field, 20);
            fieldsAct.add(field.getText());
        }
        explicitVisibilityOfElementLocatedWaitByXpath(innerScrollBarMemberList, 10);
        WebElement ele = findElementByXpath(innerScrollBarMemberList);
        ele.click();
        moveToElement(ele).clickAndHold().moveByOffset(250, 0).release().perform();
        String fieldName = explicitElementClickableWaitByXpath(lstPOS, 10).getText();
        fieldsAct.add(fieldName);
        String statusFieldName = explicitElementClickableWaitByXpath(lstStatus, 10).getText();
        fieldsAct.add(statusFieldName);
        printStatementInGreenColor("Fields size actual", fieldsAct.size());
        printStatementInGreenColor("Fields size expected", fieldsExp.size());
        printStatementInGreenColor("Fields actual", fieldsAct);
        printStatementInGreenColor("Fields expected", fieldsExp);
        Assert.assertEquals(fieldsExp, fieldsAct);
    }

    public void userEntersTheAuthNumberAndClicksSearchButton() {
        explicitElementClickableWaitByXpath(txtAuthNumber, 20);
        findElementAndSendKeys(findElementByXpath(txtAuthNumber), "12");
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    //  Scenario: Verify user able to search the criteria for Authorization number results fields
    public void userEntersAuthNumberInResultsSearchCriteria() {
        explicitElementClickableWaitByXpath(txtAuthorizationNumber, 20);
        expAuthorizationNumber = prop.getProperty("authorizationNumber");
        findElementAndSendKeys(findElementByXpath(txtAuthorizationNumber), expAuthorizationNumber);
    }

    //  Scenario: Verify user able to search the criteria for Subscriber ID results fields
    public void userEntersSubscriberIdInResultsSearchCriteria() {
        explicitElementClickableWaitByXpath(txtSubscriberId, 20);
        expMemberID = prop.getProperty("subscriberID");
        findElementAndSendKeys(findElementByXpath(txtSubscriberId), expMemberID);
    }

    //  Scenario: Verify user able to search the criteria for Member Name results fields
    public void userEntersTheMemberNameInResultsSearchCriteria() {
        explicitElementClickableWaitByXpath(txtPriorMemberName, 20);
        expMemberName = prop.getProperty("priorMemberName");
        findElementAndSendKeys(findElementByXpath(txtPriorMemberName), expMemberName);
    }

    //  Scenario: Verify user able to search the criteria for Provider NPI results fields
    public void userEntersProviderNPIInResultsSearchCriteria() {
        explicitElementClickableWaitByXpath(txtProviderNpi, 20);
        expProviderNpi = prop.getProperty("providerNPI");
        findElementAndSendKeys(findElementByXpath(txtProviderNpi), expProviderNpi);
    }

    public void verifyProviderNPIFieldValue() {
        explicitElementClickableWaitByXpath(eleProviderNpi, 40);
        Assert.assertEquals(expProviderNpi, findElementByXpath(eleProviderNpi).getText());
    }

    //  Scenario: Verify user able to search the criteria for Tax ID results fields
    public void userEntersTaxIDInResultsSearchCriteria() {
        explicitElementClickableWaitByXpath(txtTaxID, 20);
        expTaxID = prop.getProperty("taxId");
        findElementAndSendKeys(findElementByXpath(txtTaxID), expTaxID);
    }

    public void verifyTaxIDFieldValue() {
        explicitElementClickableWaitByXpath(eleTaxId, 40);
        Assert.assertEquals(expTaxID, findElementByXpath(eleTaxId).getText());
    }

    //  Scenario: Verify user able to search the criteria for Provider Name results fields
    public void userEntersProviderNameInResultsSearchCriteria() {
        explicitElementClickableWaitByXpath(txtProviderName, 20);
        expProviderName = prop.getProperty("providerName");
        findElementAndSendKeys(findElementByXpath(txtProviderName), expProviderName);
    }

    public void verifyProviderNameFieldValue() {
        explicitElementClickableWaitByXpath(eleProviderName, 40);
        Assert.assertEquals(expProviderName, findElementByXpath(eleProviderName).getText());
    }

    //  Scenario: Verify user able to search the criteria for CPT Units results fields
    public void userEntersCPTUnitsInResultsSearchCriteria() {
        explicitElementClickableWaitByXpath(txtCptUnits, 20);
        expCptUnits = prop.getProperty("cptUnits");
        findElementAndSendKeys(findElementByXpath(txtCptUnits), expCptUnits);
    }

    public void verifyCPTUnitsFieldValue() {
        explicitElementClickableWaitByXpath(eleCptUnits, 40);
        Assert.assertEquals(expCptUnits, findElementByXpath(eleCptUnits).getText());
    }

    //  Scenario: Verify user able to search the criteria for ICD Code results fields
    public void userEntersICDCodeInResultsSearchCriteria() {
        explicitElementClickableWaitByXpath(txtICDCode, 20);
        expIcdCode = prop.getProperty("icdCode");
        findElementAndSendKeys(findElementByXpath(txtICDCode), expIcdCode);
    }

    public void verifyICDCodeFieldValue() {
        explicitElementClickableWaitByXpath(eleICDCode, 40);
        Assert.assertEquals(expIcdCode, findElementByXpath(eleICDCode).getText());
    }

    //  Scenario: Verify user able to search the criteria for From Date results fields
    public void userEntersFromDateInResultsSearchCriteria() {
        explicitElementClickableWaitByXpath(txtPriorFromDate, 20);
        expFromDate = prop.getProperty("priorFromDate");
        findElementAndSendKeys(findElementByXpath(txtPriorFromDate), expFromDate);
    }

    //  Scenario: Verify user able to search the criteria for To Date results fields
    public void userEntersToDateInResultsSearchCriteria() {
        scrollToElement(txtPriorToDate);
        explicitElementClickableWaitByXpath(txtPriorToDate, 20);
        expToDate = prop.getProperty("priorToDate");
        findElementAndSendKeys(findElementByXpath(txtPriorToDate), expToDate);
    }

    //  Scenario: Verify user able to search the criteria for Received Date results fields
    public void userEntersReceivedDateInResultsSearchCriteria() {
        scrollToElement(txtReceivedDate);
        explicitElementClickableWaitByXpath(txtReceivedDate, 20);
        expReceivedDate = prop.getProperty("receivedDate");
        findElementAndSendKeys(findElementByXpath(txtReceivedDate), expReceivedDate);
    }

    public void verifyReceivedDateFieldValue() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleReceivedDate), 30, expReceivedDate);
        Assert.assertEquals(expReceivedDate, findElementByXpath(eleReceivedDate).getText());
    }

    //  Scenario: Verify user able to search the criteria for POS results fields
    public void userEntersPOSInResultsSearchCriteria() {
        WebElement ele = findElementByXpath(innerScrollBarMemberList);
        explicitElementClickableWaitByXpath(innerScrollBarMemberList, 30);
        ele.click();
        moveToElement(ele).clickAndHold().moveByOffset(250, 0).release().perform();
        explicitElementClickableWaitByXpath(txtPOS, 20);
        expPOS = prop.getProperty("priorPos");
        findElementAndSendKeys(findElementByXpath(txtPOS), expPOS);
    }

    public void verifyPOSFieldValue() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(elePOS), 30, expPOS);
        Assert.assertEquals(expPOS, findElementByXpath(elePOS).getText());
    }

    //  Scenario: Verify user able to search the criteria for Status results fields
    public void userEntersStatusInResultsSearchCriteria() {
        WebElement ele = findElementByXpath(innerScrollBarMemberList);
        explicitElementClickableWaitByXpath(innerScrollBarMemberList, 30);
        ele.click();
        moveToElement(ele).clickAndHold().moveByOffset(400, 0).release().perform();
        explicitVisibilityOfElementLocatedWaitByXpath(txtPriorStatus, 30);
        explicitElementClickableWaitByXpath(txtPriorStatus, 30);
        expStatus = prop.getProperty("priorStatus");
        findElementAndSendKeys(findElementByXpath(txtPriorStatus), expStatus);
    }
}