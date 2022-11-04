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
    String titleMembersList = "//h6";
    String lstMembersListFields = "//*[@class = 'ag-header-cell-label']//span[@ref = 'eText']";
    String txtMemberId = "//*[@aria-label = 'Member ID Filter Input']";
    String lstMemberListValues = "((//*[@id='nav-pend-details']//div[@ref = 'eContainer'])[2]//div)[1]//span";
    String txtLastName = "//*[@aria-label = 'LastName Filter Input']";
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


    private static String expMembersListTab = "";
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


    public void userClicksOnMembersList() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(lnkMemberManagement), 20);
        clickElement(lnkMemberManagement);
        explicitVisibilityOfWait(findElementByXpath(lnkMembersList), 20);
        clickElement(lnkMembersList);
        threadSleep(2000);
    }

    public void verifyUserNavigatesToMembersListPage(){
        expMembersListTab = prop.getProperty("membersListTab");
        Assert.assertEquals(expMembersListTab, findElementByXpath(titleMembersList).getText());
    }

    public void verifyFieldsUnderMembersList(DataTable expFields){
        explicitElementClickableWaitByXpath(lstMembersListFields, 30);
        scrollToElementsAndCompare2Lists(expFields, lstMembersListFields);
    }

    public void userEntersMemberIDInSearchCriteria() throws InterruptedException {
        expMemberID = prop.getProperty("membersListMemberID");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberID);
        sendKeysUsingKeyboardInput(txtMemberId);
        threadSleep(1000);
    }

    public void verifyAppropriateResultsOnMembersListScreen(){
        scrollToElementsAndValidateDisplayStatus(lstMemberListValues);
    }

    public void userEntersLastNameInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtMemberId)).clear();
        expLastName = prop.getProperty("membersListLastName");
        findElementAndSendKeys(findElementByXpath(txtLastName), expLastName);
        sendKeysUsingKeyboardInput(txtLastName);
        threadSleep(1000);
    }

    public void userEntersFirstNameInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtLastName)).clear();
        expFirstName = prop.getProperty("membersListFirstName");
        findElementAndSendKeys(findElementByXpath(txtFirstName), expFirstName);
        sendKeysUsingKeyboardInput(txtFirstName);
        threadSleep(1000);
    }

    public void userEntersMiddleNameInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtFirstName)).clear();
        expMiddleName = prop.getProperty("membersListMiddleName");
        findElementAndSendKeys(findElementByXpath(txtMiddleName), expMiddleName);
        sendKeysUsingKeyboardInput(txtMiddleName);
        threadSleep(1000);
    }

    public void userEntersDOBInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtMiddleName)).clear();
        expDOB = prop.getProperty("membersListDOB");
        findElementAndSendKeys(findElementByXpath(txtDOB), expDOB);
        sendKeysUsingKeyboardInput(txtDOB);
        threadSleep(1000);
    }

    public void userEntersGenderInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtDOB)).clear();
        expGender = prop.getProperty("membersListGender");
        findElementAndSendKeys(findElementByXpath(txtGender), expGender);
        sendKeysUsingKeyboardInput(txtGender);
        threadSleep(1000);
    }

    public void userEntersMBIInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtGender)).clear();
        expMBI = prop.getProperty("membersListMBI");
        findElementAndSendKeys(findElementByXpath(txtMBI), expMBI);
        sendKeysUsingKeyboardInput(txtMBI);
        threadSleep(1000);
    }

    public void userEntersProviderIDInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtMBI)).clear();
        expProviderID = prop.getProperty("membersListProviderID");
        findElementAndSendKeys(findElementByXpath(txtProviderId), expProviderID);
        sendKeysUsingKeyboardInput(txtProviderId);
        threadSleep(1000);
    }

    public void userEntersPCPInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtProviderId)).clear();
        expPCP = prop.getProperty("membersListPCP");
        scrollToElement(txtPCP);
        findElementAndSendKeys(findElementByXpath(txtPCP), expPCP);
        sendKeysUsingKeyboardInput(txtPCP);
        threadSleep(1000);
    }

    public void userEntersPlanInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtPCP)).clear();
        expPlan = prop.getProperty("membersListPlan");
        WebElement planField = findElementByXpath(txtPlan);
        scrollIntoView(planField, driver);
        findElementAndSendKeys(findElementByXpath(txtPlan), expPlan);
        sendKeysUsingKeyboardInput(txtPlan);
        threadSleep(1000);
    }

    public void userEntersEffDateInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtPlan)).clear();
        expEffDate = prop.getProperty("membersListEffDate");
        WebElement effDateField = findElementByXpath(txtEffDate);
        scrollIntoView(effDateField, driver);
        findElementAndSendKeys(findElementByXpath(txtEffDate), expEffDate);
        sendKeysUsingKeyboardInput(txtEffDate);
        threadSleep(1000);
    }

    public void userEntersTermDateInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtEffDate)).clear();
        expTermDate = prop.getProperty("membersListTermDate");
        WebElement termDateField = findElementByXpath(txtTermDate);
        scrollIntoView(termDateField, driver);
        findElementAndSendKeys(findElementByXpath(txtTermDate), expTermDate);
        sendKeysUsingKeyboardInput(txtTermDate);
        threadSleep(1000);
    }

    public void userEntersAddressInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtTermDate)).clear();
        expAddress = prop.getProperty("membersListAddress");
        WebElement addressField = findElementByXpath(txtAddress);
        scrollIntoView(addressField, driver);
        findElementAndSendKeys(findElementByXpath(txtAddress), expAddress);
        sendKeysUsingKeyboardInput(txtAddress);
        threadSleep(1000);
    }

    public void userEntersStatusInSearchCriteria() throws InterruptedException {
        driver.findElement(By.xpath(txtAddress)).clear();
        expStatus = prop.getProperty("membersListStatus");
        explicitElementClickableWaitByID(txtStatus, 30);
        scrollIntoView(findElementByXpath(txtStatus), driver);
        findElementAndSendKeys(findElementByXpath(txtStatus), expStatus);
        sendKeysUsingKeyboardInput(txtStatus);
        threadSleep(1000);
    }
}