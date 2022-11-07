package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

public class PriorAuthorizationPage extends SeleniumUtils {

    String lnkMemberManagement = "//*[contains(text(), ' Member Management ')]";
    String lnkPriorAuthorization = "//*[contains(text(), ' Prior Authorization ')]";
    String lstPriorAuthorization = "//*[@class = 'row check-top']//span";
    String txtAuthNumber = "//*[@id = 'authorizationNumber']";
    String lstAuthNumberValues = "//span[@class = 'ag-cell-value']";
    String btnSearch = "//button[contains(text(), 'Search')]";
    String txtMemberID = "//*[@id = 'memberID']";
    String txtMemberName = "//*[@id = 'memberName']";
    String txtFromDate = "//*[@id = 'fromDate']";
    String txtToDate = "//*[@id = 'toDate']";
    String txtStatus = "//*[@id = 'status']";

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

    public void verifyFieldValuesUnderPriorAuthorization(){
        explicitElementClickableWaitByXpath(lstAuthNumberValues, 20);
        scrollToElementsAndValidateDisplayStatus(lstAuthNumberValues);
    }

    public void userEntersMemberID(){
        expMemberID = prop.getProperty("priorAuthMemberID");
        explicitElementClickableWaitByXpath(txtMemberID, 20);
        findElementAndSendKeys(findElementByXpath(txtMemberID), expMemberID);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void userEntersMemberName(){
        expMemberName = prop.getProperty("memberName");
        explicitElementClickableWaitByXpath(txtMemberName, 20);
        findElementAndSendKeys(findElementByXpath(txtMemberName), expMemberName);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void userEntersFromDate(){
        expFromDate = prop.getProperty("fromDate");
        explicitElementClickableWaitByXpath(txtFromDate, 20);
        findElementAndSendKeys(findElementByXpath(txtFromDate), expFromDate);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void userEntersToDate(){
        expToDate = prop.getProperty("toDate");
        explicitElementClickableWaitByXpath(txtToDate, 20);
        findElementAndSendKeys(findElementByXpath(txtToDate), expToDate);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }

    public void userEntersStatus(){
        expStatus = prop.getProperty("priorAuthStatus");
        explicitElementClickableWaitByXpath(txtStatus, 20);
        findElementAndSendKeys(findElementByXpath(txtStatus), expStatus);
        explicitElementClickableWaitByXpath(btnSearch, 30);
        clickElement(btnSearch);
    }
}