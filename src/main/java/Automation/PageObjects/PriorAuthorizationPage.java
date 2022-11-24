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

    private static String expAuthorizationNumber = "";
    private static String expMemberID = "";
    private static String expMemberName = "";
    private static String expFromDate = "";
    private static String expToDate = "";
    private static String expStatus = "";

    public void userClicksMemberManagement(){
        explicitVisibilityOfWait(findElementByXpath(lnkMemberManagement), 20);
        clickElement(lnkMemberManagement);
    }

    public void userClickOnPriorAuthorization(){
        explicitVisibilityOfWait(findElementByXpath(lnkPriorAuthorization), 20);
        clickElement(lnkPriorAuthorization);
    }

    public void verifyPriorAuthorizationPage(String expTab){
        Assert.assertEquals(expTab, findElementByXpath(lnkPriorAuthorization).getText());
    }

    public void verifyPriorAuthorizationFields(DataTable expFields){
        explicitElementClickableWaitByXpath(lstPriorAuthorization, 20);
        scrollToElementsAndCompare2Lists(expFields, lstPriorAuthorization);
    }

    public void userEntersAuthorizationNumber(){
        expAuthorizationNumber = prop.getProperty("authNumber");
        explicitElementClickableWaitByXpath(txtAuthNumber, 20);
        findElementAndSendKeys(findElementByXpath(txtAuthNumber), expAuthorizationNumber);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyAuthorizationFieldValueUnderPriorAuthorization(){
        explicitElementClickableWaitByXpath(eleAuthorizationNumber, 20);
        Assert.assertEquals(expAuthorizationNumber, findElementByXpath(eleAuthorizationNumber).getText());
    }

    public void userEntersMemberID(){
        expMemberID = prop.getProperty("priorAuthMemberID");
        explicitElementClickableWaitByXpath(txtMemberID, 20);
        findElementAndSendKeys(findElementByXpath(txtMemberID), expMemberID);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyMemberIDFieldValueUnderPriorAuthorization(){
        explicitElementClickableWaitByXpath(eleMemberID, 20);
        Assert.assertEquals(expMemberID, findElementByXpath(eleMemberID).getText());
    }

    public void userEntersMemberName(){
        expMemberName = prop.getProperty("memberName");
        explicitElementClickableWaitByXpath(txtMemberName, 20);
        findElementAndSendKeys(findElementByXpath(txtMemberName), expMemberName);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyMemberNameFieldValue(){
        explicitElementClickableWaitByXpath(eleMemberName, 20);
        Assert.assertEquals(expMemberName, findElementByXpath(eleMemberName).getText());
    }

    public void userEntersFromDate(){
        expFromDate = prop.getProperty("fromDate");
        explicitElementClickableWaitByXpath(txtFromDate, 20);
        findElementAndSendKeys(findElementByXpath(txtFromDate), expFromDate);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyFromDateFieldValue(){
        explicitElementClickableWaitByXpath(eleFromDate, 20);
        Assert.assertEquals(expFromDate, findElementByXpath(eleFromDate).getText());
    }

    public void userEntersToDate(){
        expToDate = prop.getProperty("toDate");
        explicitElementClickableWaitByXpath(txtToDate, 20);
        findElementAndSendKeys(findElementByXpath(txtToDate), expToDate);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyToDateFieldValue(){
        explicitElementClickableWaitByXpath(eleToDate, 20);
        Assert.assertEquals(expToDate, findElementByXpath(eleToDate).getText());
    }

    public void userEntersStatus(){
        expStatus = prop.getProperty("priorAuthStatus");
        explicitElementClickableWaitByXpath(txtStatus, 20);
        findElementAndSendKeys(findElementByXpath(txtStatus), expStatus);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void verifyStatusFieldValue(){
        WebElement ele = findElementByXpath(innerScrollBarMemberList);
        ele.click();
        moveToElement(ele).clickAndHold().moveByOffset(300, 0).release().perform();
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleStatus), 40, expStatus);
        Assert.assertEquals(expStatus, findElementByXpath(eleStatus).getText());
    }

    public void userClicksOnAuthorizationNumber(){
        explicitElementClickableWaitByXpath(eleAuthorizationNumber, 20);
        clickElement(eleAuthorizationNumber);
        explicitTextToBePresentInElementLocatedWait(By.xpath(elePlanAuthNumber), 20, "PLAN AUTH NUMBER");
    }

    public void verifyAuthorizationSummaryPopUpDisplayed(String expPopUp){
        Assert.assertEquals(expPopUp, findElementByXpath(titleAuthSummary).getText());
    }

    public void verifyPlanAuthNumber(String expField){
        Assert.assertEquals(expField, findElementByXpath(elePlanAuthNumber).getText());
    }

    public void verifyAllLegends(DataTable expLegends){
//        explicitElementClickableWaitByXpath(lstLegends, 20);
        scrollToElementsAndCompare2Lists(expLegends, lstLegends);
    }
}