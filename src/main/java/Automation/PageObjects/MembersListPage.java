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
    String lastName = "(//*[@col-id = 'lastName']//span)[1]";
    String innerScrollBarMemberList = "//div[@class='ag-body-horizontal-scroll-viewport']";


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
        String abc = explicitElementClickableWaitByXpath("//span[text()='Status']", 10).getText();
        fieldsAct.add(abc);
        printStatementInGreenColor("Fields size actual", fieldsAct.size());
        printStatementInGreenColor("Fields size expected", fieldsExp.size());
        printStatementInGreenColor("Fields actual", fieldsAct);
        printStatementInGreenColor("Fields expected", fieldsExp);
        Assert.assertEquals(fieldsExp, fieldsAct);

//        explicitElementClickableWaitByXpath(lstMembersListFields, 30);
//        scrollToElementsAndCompare2Lists(expFields, lstMembersListFields);
    }

    public void userEntersMemberIDInSearchCriteria() {
        expMemberID = prop.getProperty("membersListMemberID");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberID);
    }

    public void verifyAppropriateResultsOnMembersListScreen() {
        explicitElementClickableWaitByXpath(lstMemberListValues, 50);
        scrollToElementsAndValidateDisplayStatus(lstMemberListValues);
    }

    public void userEntersLastNameInSearchCriteria() {
        driver.findElement(By.xpath(txtMemberId)).clear();
        expLastName = prop.getProperty("membersListLastName");
        findElementAndSendKeys(findElementByXpath(txtLastName), expLastName);
    }

    public void userEntersFirstNameInSearchCriteria() {
        driver.findElement(By.xpath(txtLastName)).clear();
        expFirstName = prop.getProperty("membersListFirstName");
        findElementAndSendKeys(findElementByXpath(txtFirstName), expFirstName);
    }

    public void userEntersMiddleNameInSearchCriteria() {
        driver.findElement(By.xpath(txtFirstName)).clear();
        expMiddleName = prop.getProperty("membersListMiddleName");
        findElementAndSendKeys(findElementByXpath(txtMiddleName), expMiddleName);
    }

    public void userEntersDOBInSearchCriteria() {
        driver.findElement(By.xpath(txtMiddleName)).clear();
        expDOB = prop.getProperty("membersListDOB");
        findElementAndSendKeys(findElementByXpath(txtDOB), expDOB);
    }

    public void userEntersGenderInSearchCriteria() {
        driver.findElement(By.xpath(txtDOB)).clear();
        expGender = prop.getProperty("membersListGender");
        findElementAndSendKeys(findElementByXpath(txtGender), expGender);
    }

    public void userEntersMBIInSearchCriteria() {
        driver.findElement(By.xpath(txtGender)).clear();
        expMBI = prop.getProperty("membersListMBI");
        findElementAndSendKeys(findElementByXpath(txtMBI), expMBI);
    }

    public void userEntersProviderIDInSearchCriteria() {
        driver.findElement(By.xpath(txtMBI)).clear();
        expProviderID = prop.getProperty("membersListProviderID");
        findElementAndSendKeys(findElementByXpath(txtProviderId), expProviderID);
    }

    public void userEntersPCPInSearchCriteria() {
        driver.findElement(By.xpath(txtProviderId)).clear();
        expPCP = prop.getProperty("membersListPCP");
        scrollToElement(txtPCP);
        findElementAndSendKeys(findElementByXpath(txtPCP), expPCP);
    }

    public void userEntersPlanInSearchCriteria() {
        driver.findElement(By.xpath(txtPCP)).clear();
        expPlan = prop.getProperty("membersListPlan");
        WebElement planField = findElementByXpath(txtPlan);
        scrollIntoView(planField, driver);
        findElementAndSendKeys(findElementByXpath(txtPlan), expPlan);
    }

    public void userEntersEffDateInSearchCriteria() {
        driver.findElement(By.xpath(txtPlan)).clear();
        expEffDate = prop.getProperty("membersListEffDate");
        WebElement effDateField = findElementByXpath(txtEffDate);
        scrollIntoView(effDateField, driver);
        findElementAndSendKeys(findElementByXpath(txtEffDate), expEffDate);
    }

    public void userEntersTermDateInSearchCriteria() {
        driver.findElement(By.xpath(txtEffDate)).clear();
        expTermDate = prop.getProperty("membersListTermDate");
        WebElement termDateField = findElementByXpath(txtTermDate);
        scrollIntoView(termDateField, driver);
        findElementAndSendKeys(findElementByXpath(txtTermDate), expTermDate);
    }

    public void userEntersAddressInSearchCriteria() {
        driver.findElement(By.xpath(txtTermDate)).clear();
        expAddress = prop.getProperty("membersListAddress");
        WebElement addressField = findElementByXpath(txtAddress);
        scrollIntoView(addressField, driver);
        findElementAndSendKeys(findElementByXpath(txtAddress), expAddress);
    }

    public void userEntersStatusInSearchCriteria() {
        expStatus = prop.getProperty("membersListStatus");
        explicitElementClickableWaitByID(txtStatus, 30);
        scrollIntoView(findElementByXpath(txtStatus), driver);
        findElementAndSendKeys(findElementByXpath(txtStatus), expStatus);
    }
}