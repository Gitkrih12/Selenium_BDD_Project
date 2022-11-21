package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MembersListPage extends SeleniumUtils {

    String lnkMemberManagement = "//*[contains(text(), ' Member Management ')]";
    String lnkMembersList = "//*[contains(text(), ' Members List ')]";
    String titleMembersList = "//h6[@class = 'claims-list']";
    String lstMembersListFields = "//*[@class = 'ag-header-cell-label']//span[@ref = 'eText']";
    String txtMemberId = "//*[@aria-label = 'Member ID Filter Input']";
    String lstMemberListValues = "((//*[@id='nav-pend-details']//div[@ref = 'eContainer'])[2]//div)[1]//span[@class = 'ag-cell-value' and text()]";
    String txtLastName = "//*[@aria-label = 'Last Name Filter Input']";
    String txtFirstName = "//*[@aria-label = 'First Name Filter Input']";
    String txtMiddleName = "//*[@aria-label = 'Middle Name Filter Input']";
    String txtDOB = "//*[@aria-label = 'DOB Filter Input']";
    String txtGender = "//*[@aria-label = 'Gender Filter Input']";
    String txtMBI = "//*[@aria-label = 'MBI Filter Input']";
    String txtProviderId = "//*[@aria-label = 'Provider ID Filter Input']";
    String txtPCP = "//*[@aria-label = 'PCP Filter Input']";
    String txtPCPPhone = "//*[@aria-label = 'PCP Phone Filter Input']";
    String txtPlan = "//*[@aria-label = 'Plan Filter Input']";
    String txtEffDate = "//*[@aria-label = 'Eff. Date Filter Input']";
    String txtTermDate = "//*[@aria-label = 'Term. Date Filter Input']";
    String txtAddress = "//*[@aria-label = 'Address Filter Input']";
    String txtStatus = "//*[@aria-label = 'Status Filter Input']";
    String lastName = "(//*[@col-id = 'lastName']//span)[1]";
    String innerScrollBarMemberList = "//div[@class='ag-body-horizontal-scroll-viewport']";
    String lstStatus = "//span[text()='Status']";
    String txtMemberIdValue = "(//app-view-claim-render//a)[1]";
    String txtLastNameValue = "(//*[@col-id = 'lastName']//span[@class = 'ag-cell-value'])[1]";
    String txtFirstNameValue = "(//*[@col-id = 'firstName']//span[@class = 'ag-cell-value'])[1]";
    String txtMiddleNameValue = "(//*[@col-id = 'middleName']//span[@class = 'ag-cell-value'])[1]";
    String txtDOBValue = "(//*[@col-id = 'dateofBirth']//span[@class = 'ag-cell-value'])[1]";
    String txtGenderValue = "(//*[@col-id = 'gender']//span[@class = 'ag-cell-value'])[1]";
    String txtMbiValue = "(//*[@col-id = 'mbi']//span[@class = 'ag-cell-value'])[1]";
    String txtProviderIdValue = "(//*[@col-id = 'providerId']//span[@class = 'ag-cell-value'])[1]";
    String txtPCPValue = "(//*[@col-id = 'pcp']//span[@class = 'ag-cell-value'])[1]";
    String txtPlanValue = "(//*[@col-id = 'planName']//span[@class = 'ag-cell-value'])[1]";
    String txtEffDateValue = "(//*[@col-id = 'planEffectiveDate']//span[@class = 'ag-cell-value'])[1]";
    String txtTermDateValue = "(//*[@col-id = 'planTerminationDate']//span[@class = 'ag-cell-value'])[1]";
    String txtAddressValue = "(//*[@col-id = 'addressLine1']//span[@class = 'ag-cell-value'])[1]";
    String txtStatusValue = "(//*[@col-id = 'status']//span[@class = 'ag-cell-value'])[1]";


    private static String expMemberID = "";
    private static String expLastName = "";
    private static String expFirstName = "";
    private static String expMiddleName = "";
    private static String expDOB = "";
    private static String expGender = "";
    private static String expMBI = "";
    private static String expProviderID = "";
    private static String expPCP = "";
    private static String expPCPPhone = "";
    private static String expPlan = "";
    private static String expEffDate = "";
    private static String expTermDate = "";
    private static String expAddress = "";
    private static String expStatus = "";


    public void userClicksOnMembersList() {
        explicitVisibilityOfWait(findElementByXpath(lnkMemberManagement), 20);
        clickElement(lnkMemberManagement);
        explicitVisibilityOfWait(findElementByXpath(lnkMembersList), 20);
        clickElement(lnkMembersList);
        explicitVisibilityOfWait(findElementByXpath(lastName), 50);
    }

    public void verifyUserNavigatesToMembersListPage(String expTab) {
        explicitElementClickableWaitByXpath(titleMembersList, 30);
        Assert.assertEquals(expTab, findElementByXpath(titleMembersList).getText());
    }

    public void verifyFieldsUnderMembersList(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstMembersListFields, 30);
        List<String> fieldsExp = expFields.asList();
        List<WebElement> fields = driver.findElements(By.xpath(lstMembersListFields));
        List<String> fieldsAct = new ArrayList<>();
        for (WebElement field : fields) {
            scrollIntoView(field, driver);
            explicitElementClickableWait(field, 20);
            fieldsAct.add(field.getText());
        }
        explicitVisibilityOfElementLocatedWaitByXpath(innerScrollBarMemberList, 10);
        WebElement ele = findElementByXpath(innerScrollBarMemberList);
        ele.click();
        moveToElement(ele).clickAndHold().moveByOffset(100, 0).release().perform();
        String abc = explicitElementClickableWaitByXpath(lstStatus, 10).getText();
        fieldsAct.add(abc);
        printStatementInGreenColor("Fields size actual", fieldsAct.size());
        printStatementInGreenColor("Fields size expected", fieldsExp.size());
        printStatementInGreenColor("Fields actual", fieldsAct);
        printStatementInGreenColor("Fields expected", fieldsExp);
        Assert.assertEquals(fieldsExp, fieldsAct);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Member ID
    public void userEntersMemberIDInSearchCriteria() {
        expMemberID = prop.getProperty("membersListMemberID");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberID);
    }

    public void verifyAppropriateResultsWithMemberID(){
        explicitElementClickableWaitByXpath(txtMemberIdValue, 10);
        elementsDisplayValidation(txtMemberIdValue);
    }

    //  Verify user able to Search Member in the Search Box for Last Name
    public void userEntersLastNameInSearchCriteria() {
        expLastName = prop.getProperty("membersListLastName");
        findElementAndSendKeys(findElementByXpath(txtLastName), expLastName);
    }

    public void verifyAppropriateResultsWithLastName(){
        explicitElementClickableWaitByXpath(txtLastNameValue, 10);
        elementsDisplayValidation(txtLastNameValue);
    }

    //  Verify user able to Search Member in the Search Box for First Name
    public void userEntersFirstNameInSearchCriteria() {
        expFirstName = prop.getProperty("membersListFirstName");
        findElementAndSendKeys(findElementByXpath(txtFirstName), expFirstName);
    }

    public void verifyAppropriateResultsWithFirstName(){
        explicitElementClickableWaitByXpath(txtFirstNameValue, 10);
        elementsDisplayValidation(txtFirstNameValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Middle Name
    public void userEntersMiddleNameInSearchCriteria() {
        expMiddleName = prop.getProperty("membersListMiddleName");
        findElementAndSendKeys(findElementByXpath(txtMiddleName), expMiddleName);
    }

    public void verifyAppropriateResultsWithMiddleName(){
        explicitElementClickableWaitByXpath(txtMiddleNameValue, 10);
        elementsDisplayValidation(txtMiddleNameValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for DOB
    public void userEntersDOBInSearchCriteria() {
        expDOB = prop.getProperty("membersListDOB");
        findElementAndSendKeys(findElementByXpath(txtDOB), expDOB);
    }

    public void verifyAppropriateResultsWithDOB(){
        explicitElementClickableWaitByXpath(txtDOBValue, 10);
        elementsDisplayValidation(txtDOBValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Gender
    public void userEntersGenderInSearchCriteria() {
        expGender = prop.getProperty("membersListGender");
        findElementAndSendKeys(findElementByXpath(txtGender), expGender);
    }

    public void verifyAppropriateResultsWithGender(){
        explicitElementClickableWaitByXpath(txtGenderValue, 10);
        elementsDisplayValidation(txtGenderValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for MBI
    public void userEntersMBIInSearchCriteria() {
        expMBI = prop.getProperty("membersListMBI");
        findElementAndSendKeys(findElementByXpath(txtMBI), expMBI);
    }

    public void verifyAppropriateResultsWithMBI(){
        explicitElementClickableWaitByXpath(txtMbiValue, 10);
        elementsDisplayValidation(txtMbiValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Provider ID
    public void userEntersProviderIDInSearchCriteria() {
        expProviderID = prop.getProperty("membersListProviderID");
        findElementAndSendKeys(findElementByXpath(txtProviderId), expProviderID);
    }

    public void verifyAppropriateResultsWithProviderId(){
        explicitElementClickableWaitByXpath(txtProviderIdValue, 10);
        elementsDisplayValidation(txtProviderIdValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for PCP
    public void userEntersPCPInSearchCriteria() {
        expPCP = prop.getProperty("membersListPCP");
        scrollToElement(txtPCP);
        findElementAndSendKeys(findElementByXpath(txtPCP), expPCP);
    }

    public void verifyAppropriateResultsWithPCP(){
        explicitElementClickableWaitByXpath(txtPCPValue, 10);
        elementsDisplayValidation(txtPCPValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Plan
    public void userEntersPlanInSearchCriteria() {
        expPlan = prop.getProperty("membersListPlan");
        WebElement planField = findElementByXpath(txtPlan);
        scrollIntoView(planField, driver);
        findElementAndSendKeys(findElementByXpath(txtPlan), expPlan);
    }

    public void verifyAppropriateResultsWithPlan(){
        explicitElementClickableWaitByXpath(txtPlanValue, 10);
        elementsDisplayValidation(txtPlanValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Eff Date
    public void userEntersEffDateInSearchCriteria() {
        expEffDate = prop.getProperty("membersListEffDate");
        WebElement effDateField = findElementByXpath(txtEffDate);
        scrollIntoView(effDateField, driver);
        findElementAndSendKeys(findElementByXpath(txtEffDate), expEffDate);
    }

    public void verifyAppropriateResultsWithEffDate(){
        explicitElementClickableWaitByXpath(txtEffDateValue, 10);
        elementsDisplayValidation(txtEffDateValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Term Date
    public void userEntersTermDateInSearchCriteria() {
        expTermDate = prop.getProperty("membersListTermDate");
        WebElement termDateField = findElementByXpath(txtTermDate);
        scrollIntoView(termDateField, driver);
        findElementAndSendKeys(findElementByXpath(txtTermDate), expTermDate);
    }

    public void verifyAppropriateResultsWithTermDate(){
        explicitElementClickableWaitByXpath(txtTermDateValue, 10);
        elementsDisplayValidation(txtTermDateValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Address
    public void userEntersAddressInSearchCriteria() {
        expAddress = prop.getProperty("membersListAddress");
        WebElement addressField = findElementByXpath(txtAddress);
        scrollIntoView(addressField, driver);
        findElementAndSendKeys(findElementByXpath(txtAddress), expAddress);
    }

    public void verifyAppropriateResultsWithAddress(){
        explicitElementClickableWaitByXpath(txtAddressValue, 10);
        elementsDisplayValidation(txtAddressValue);
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Status
    public void userEntersStatusInSearchCriteria() {
        expStatus = prop.getProperty("membersListStatus");
        explicitElementClickableWaitByID(txtStatus, 30);
        scrollIntoView(findElementByXpath(txtStatus), driver);
        findElementAndSendKeys(findElementByXpath(txtStatus), expStatus);
    }

    public void verifyAppropriateResultsWithStatus(){
        explicitElementClickableWaitByXpath(txtStatusValue, 10);
        elementsDisplayValidation(txtStatusValue);
    }
}