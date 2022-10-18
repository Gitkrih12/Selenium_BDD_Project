package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
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
    String txtMiddleName = "//*[@aria-label = 'Middel Name Filter Input']";
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
        threadSleep(1000);
    }

    public void verifyUserNavigatesToMembersListPage(){
        expMembersListTab = prop.getProperty("membersListTab");
        Assert.assertEquals(expMembersListTab, findElementByXpath(titleMembersList).getText());
    }

    public void verifyFieldsUnderMembersList(DataTable expFields){
        List<String> columnListExp = expFields.asList();
        List<WebElement> actColumnFields = findElementsByXpath(lstMembersListFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + actColumnFields.size());
        for (WebElement column : actColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in Members List section :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + columnListExp);
        for (String exp : columnListExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void userEntersMemberIDInSearchCriteria() throws InterruptedException {
        expMemberID = prop.getProperty("membersListMemberID");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberID);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMemberId);
        threadSleep(1000);
    }

    public void verifyAppropriateResultsOnMembersListScreen(){

    }

    public void userEntersLastNameInSearchCriteria() throws InterruptedException {
        expLastName = prop.getProperty("membersListLastName");
        findElementAndSendKeys(findElementByXpath(txtLastName), expLastName);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtLastName);
        threadSleep(1000);
    }

    public void userEntersFirstNameInSearchCriteria() throws InterruptedException {
        expFirstName = prop.getProperty("membersListFirstName");
        findElementAndSendKeys(findElementByXpath(txtFirstName), expFirstName);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtFirstName);
        threadSleep(1000);
    }

    public void userEntersMiddleNameInSearchCriteria() throws InterruptedException {
        expMiddleName = prop.getProperty("membersListMiddleName");
        findElementAndSendKeys(findElementByXpath(txtMiddleName), expMiddleName);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMiddleName);
        threadSleep(1000);
    }

    public void userEntersDOBInSearchCriteria() throws InterruptedException {
        expDOB = prop.getProperty("membersListDOB");
        findElementAndSendKeys(findElementByXpath(txtDOB), expDOB);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtDOB);
        threadSleep(1000);
    }

    public void userEntersGenderInSearchCriteria() throws InterruptedException {
        expGender = prop.getProperty("membersListGender");
        findElementAndSendKeys(findElementByXpath(txtGender), expGender);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtGender);
        threadSleep(1000);
    }

    public void userEntersMBIInSearchCriteria() throws InterruptedException {
        expMBI = prop.getProperty("membersListMBI");
        findElementAndSendKeys(findElementByXpath(txtMBI), expMBI);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMBI);
        threadSleep(1000);
    }

    public void userEntersProviderIDInSearchCriteria() throws InterruptedException {
        expProviderID = prop.getProperty("membersListProviderID");
        findElementAndSendKeys(findElementByXpath(txtProviderId), expProviderID);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtProviderId);
        threadSleep(1000);
    }

    public void userEntersPCPInSearchCriteria() throws InterruptedException {
        expPCP = prop.getProperty("membersListPCP");
        findElementAndSendKeys(findElementByXpath(txtPCP), expPCP);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtPCP);
        threadSleep(1000);
    }

    public void userEntersPlanInSearchCriteria() throws InterruptedException {
        expPlan = prop.getProperty("membersListPlan");
        findElementAndSendKeys(findElementByXpath(txtPlan), expPlan);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtPlan);
        threadSleep(1000);
    }

    public void userEntersEffDateInSearchCriteria() throws InterruptedException {
        expEffDate = prop.getProperty("membersListEffDate");
        findElementAndSendKeys(findElementByXpath(txtEffDate), expEffDate);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtEffDate);
        threadSleep(1000);
    }

    public void userEntersTermDateInSearchCriteria() throws InterruptedException {
        expTermDate = prop.getProperty("membersListTermDate");
        findElementAndSendKeys(findElementByXpath(txtTermDate), expTermDate);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtTermDate);
        threadSleep(1000);
    }

    public void userEntersAddressInSearchCriteria() throws InterruptedException {
        expAddress = prop.getProperty("membersListAddress");
        findElementAndSendKeys(findElementByXpath(txtAddress), expAddress);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtAddress);
        threadSleep(1000);
    }

    public void userEntersStatusInSearchCriteria() throws InterruptedException {
        expStatus = prop.getProperty("membersListStatus");
        findElementAndSendKeys(findElementByXpath(txtStatus), expStatus);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtStatus);
        threadSleep(1000);
    }
}