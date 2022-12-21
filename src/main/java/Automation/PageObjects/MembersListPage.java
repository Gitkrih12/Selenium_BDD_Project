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
    String eleMemberIdValue = "(//app-view-claim-render//a)[1]";
    String eleLastNameValue = "(//*[@col-id = 'lastName']//span[@class = 'ag-cell-value'])[1]";
    String eleFirstNameValue = "(//*[@col-id = 'firstName']//span[@class = 'ag-cell-value'])[1]";
    String eleMiddleNameValue = "(//*[@col-id = 'middleName']//span[@class = 'ag-cell-value'])[1]";
    String eleDOBValue = "(//*[@col-id = 'dateofBirth']//span[@class = 'ag-cell-value'])[1]";
    String eleGenderValue = "(//*[@col-id = 'gender']//span[@class = 'ag-cell-value'])[1]";
    String eleMbiValue = "(//*[@col-id = 'mbi']//span[@class = 'ag-cell-value'])[1]";
    String eleProviderIdValue = "(//*[@col-id = 'providerId']//span[@class = 'ag-cell-value'])[1]";
    String elePCPValue = "(//*[@col-id = 'pcp']//span[@class = 'ag-cell-value'])[1]";
    String elePlanValue = "(//*[@col-id = 'planName']//span[@class = 'ag-cell-value'])[1]";
    String eleEffDateValue = "(//*[@col-id = 'planEffectiveDate']//span[@class = 'ag-cell-value'])[1]";
    String eleTermDateValue = "(//*[@col-id = 'planTerminationDate']//span[@class = 'ag-cell-value'])[1]";
    String eleAddressValue = "(//*[@col-id = 'addressLine1']//span[@class = 'ag-cell-value'])[1]";
    String eleStatusValue = "(//*[@col-id = 'status']//span[@class = 'ag-cell-value'])[1]";


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
        String fieldName = explicitElementClickableWaitByXpath(lstStatus, 10).getText();
        fieldsAct.add(fieldName);
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
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleMemberIdValue), 30, expMemberID);
        Assert.assertEquals(expMemberID, findElementByXpath(eleMemberIdValue).getText());
    }

    //  Verify user able to Search Member in the Search Box for Last Name
    public void userEntersLastNameInSearchCriteria() {
        expLastName = prop.getProperty("membersListLastName");
        findElementAndSendKeys(findElementByXpath(txtLastName), expLastName);
    }

    public void verifyAppropriateResultsWithLastName(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleLastNameValue), 30, expLastName);
        Assert.assertEquals(expLastName, findElementByXpath(eleLastNameValue).getText());
    }

    //  Verify user able to Search Member in the Search Box for First Name
    public void userEntersFirstNameInSearchCriteria() {
        expFirstName = prop.getProperty("membersListFirstName");
        findElementAndSendKeys(findElementByXpath(txtFirstName), expFirstName);
    }

    public void verifyAppropriateResultsWithFirstName(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleFirstNameValue), 30, expFirstName);
        Assert.assertEquals(expFirstName, findElementByXpath(eleFirstNameValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Middle Name
    public void userEntersMiddleNameInSearchCriteria() {
        expMiddleName = prop.getProperty("membersListMiddleName");
        findElementAndSendKeys(findElementByXpath(txtMiddleName), expMiddleName);
    }

    public void verifyAppropriateResultsWithMiddleName(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleMiddleNameValue), 30, expMiddleName);
        Assert.assertEquals(expMiddleName, findElementByXpath(eleMiddleNameValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for DOB
    public void userEntersDOBInSearchCriteria() {
        expDOB = prop.getProperty("membersListDOB");
        findElementAndSendKeys(findElementByXpath(txtDOB), expDOB);
    }

    public void verifyAppropriateResultsWithDOB(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleDOBValue), 30, expDOB);
        Assert.assertEquals(expDOB, findElementByXpath(eleDOBValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Gender
    public void userEntersGenderInSearchCriteria() {
        expGender = prop.getProperty("membersListGender");
        findElementAndSendKeys(findElementByXpath(txtGender), expGender);
    }

    public void verifyAppropriateResultsWithGender(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleGenderValue), 30, expGender);
        Assert.assertEquals(expGender, findElementByXpath(eleGenderValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for MBI
    public void userEntersMBIInSearchCriteria() {
        expMBI = prop.getProperty("membersListMBI");
        findElementAndSendKeys(findElementByXpath(txtMBI), expMBI);
    }

    public void verifyAppropriateResultsWithMBI(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleMbiValue), 30, expMBI);
        Assert.assertEquals(expMBI, findElementByXpath(eleMbiValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Provider ID
    public void userEntersProviderIDInSearchCriteria() {
        expProviderID = prop.getProperty("membersListProviderID");
        findElementAndSendKeys(findElementByXpath(txtProviderId), expProviderID);
    }

    public void verifyAppropriateResultsWithProviderId(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleProviderIdValue), 30, expProviderID);
        Assert.assertEquals(expProviderID, findElementByXpath(eleProviderIdValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for PCP
    public void userEntersPCPInSearchCriteria() {
        expPCP = prop.getProperty("membersListPCP");
        scrollToElement(txtPCP);
        findElementAndSendKeys(findElementByXpath(txtPCP), expPCP);
    }

    public void verifyAppropriateResultsWithPCP(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(elePCPValue), 30, expPCP);
        Assert.assertEquals(expPCP, findElementByXpath(elePCPValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Plan
    public void userEntersPlanInSearchCriteria() {
        expPlan = prop.getProperty("membersListPlan");
        WebElement planField = findElementByXpath(txtPlan);
        scrollIntoView(planField, driver);
        findElementAndSendKeys(findElementByXpath(txtPlan), expPlan);
    }

    public void verifyAppropriateResultsWithPlan(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(elePlanValue), 30, expPlan);
        Assert.assertEquals(expPlan, findElementByXpath(elePlanValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Eff Date
    public void userEntersEffDateInSearchCriteria() {
        expEffDate = prop.getProperty("membersListEffDate");
        WebElement effDateField = findElementByXpath(txtEffDate);
        scrollIntoView(effDateField, driver);
        findElementAndSendKeys(findElementByXpath(txtEffDate), expEffDate);
    }

    public void verifyAppropriateResultsWithEffDate(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleEffDateValue), 30, expEffDate);
        Assert.assertEquals(expEffDate, findElementByXpath(eleEffDateValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Term Date
    public void userEntersTermDateInSearchCriteria() {
        expTermDate = prop.getProperty("membersListTermDate");
        WebElement termDateField = findElementByXpath(txtTermDate);
        scrollIntoView(termDateField, driver);
        findElementAndSendKeys(findElementByXpath(txtTermDate), expTermDate);
    }

    public void verifyAppropriateResultsWithTermDate(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleTermDateValue), 30, expTermDate);
        Assert.assertEquals(expTermDate, findElementByXpath(eleTermDateValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Address
    public void userEntersAddressInSearchCriteria() {
        expAddress = prop.getProperty("membersListAddress");
        WebElement addressField = findElementByXpath(txtAddress);
        scrollIntoView(addressField, driver);
        findElementAndSendKeys(findElementByXpath(txtAddress), expAddress);
    }

    public void verifyAppropriateResultsWithAddress(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleAddressValue), 30, expAddress);
        Assert.assertEquals(expAddress, findElementByXpath(eleAddressValue).getText());
    }

    //  Scenario: Verify user able to Search Member in the Search Box for Status
    public void userEntersStatusInSearchCriteria() {
        expStatus = prop.getProperty("membersListStatus");
        explicitVisibilityOfElementLocatedWaitByXpath(innerScrollBarMemberList, 20);
        WebElement ele = findElementByXpath(innerScrollBarMemberList);
        ele.click();
        moveToElement(ele).clickAndHold().moveByOffset(250, 0).release().perform();
        explicitElementClickableWaitByXpath(txtStatus, 30);
        findElementAndSendKeys(findElementByXpath(txtStatus), expStatus);
    }

    public void verifyAppropriateResultsWithStatus(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleStatusValue), 30, expStatus);
        Assert.assertEquals(expStatus, findElementByXpath(eleStatusValue).getText());
    }
}