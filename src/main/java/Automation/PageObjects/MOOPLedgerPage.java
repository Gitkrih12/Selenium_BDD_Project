package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MOOPLedgerPage extends SeleniumUtils {

    String lnkMemberManagement = "//*[contains(text(), ' Member Management ')]";
    String lnkMOOPLedger = "(//*[contains(text(), 'MOOP Ledger')])[1]";
    String tabMOOPLedger = "//app-moop-ledger//h6";
    String lstMOOPLedger = "//*[@ref = 'eText']";
    String txtMOOPSearchBox = "//input[@ref='eInput' and @type = 'text']";
    String txtMemberID = "//*[@aria-label = 'Member ID Filter Input']";
    String lnkMemberID = "(//app-view-claim-render//a)[1]";
    String titleMoopTransaction = "(//app-moop-transaction//h6)[1]";
    String lstMoopTransactionFields = "//app-moop-transaction//span[@ref = 'eText']";
    String titleMoopAccumulatorSummary = "(//app-moop-transaction//h6)[2]";
    String lstMoopTransactionFieldValues = "//*[@class = 'ag-cell-value' and text()]";
    String txtSearchFieldsForMoopTransaction = "//*[@ref = 'eInput' and @type = 'text']";


    private static String expMemberId = "";
    private static String expMoopTransactionTab = "";
    private static String expMoopAccumulatorSummaryTab = "";


    public void userClicksMemberManagement() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(lnkMemberManagement), 20);
        clickElement(lnkMemberManagement);
        threadSleep(1000);
    }

    public void userClickOnMoopLedger() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(lnkMOOPLedger), 20);
        clickElement(lnkMOOPLedger);
        threadSleep(2000);
    }

    public void userNavigatesToMoopLedgerPage(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabMOOPLedger).getText());
    }

    public void verifyFieldsUnderMoopLedger(DataTable expFields) {
        List<String> moopFieldsExp = expFields.asList();
        List<WebElement> actFields = findElementsByXpath(lstMOOPLedger);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + actFields.size());
        for (WebElement column : actFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Moop Ledger fields  should display :" + fieldsForCompare);
        System.out.println("Expected fields are : " + moopFieldsExp);
        for (String exp : moopFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifySearchCriteriaInMoopLedgerPage() {
        List<WebElement> ActSearchFields = findElementsByXpath(txtMOOPSearchBox);
        for (WebElement column : ActSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    public void userClicksOnMemberId() throws InterruptedException {
        threadSleep(1000);
        expMemberId = prop.getProperty("moopMemberId");
        findElementAndSendKeys(findElementByXpath(txtMemberID), expMemberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMemberID);
        explicitVisibilityOfWait(findElementByXpath(lnkMemberID), 10);
        clickElement(lnkMemberID);
        threadSleep(1000);
    }

    public void userNavigatesToMoopTransactionScreen() {
        expMoopTransactionTab = prop.getProperty("moopTransactionTab");
        Assert.assertEquals(expMoopTransactionTab, findElementByXpath(titleMoopTransaction).getText());
    }

    public void userNavigatesToMoopAccumulatorSummary() {
        expMoopAccumulatorSummaryTab = prop.getProperty("moopAccumulatorSummaryTab");
        Assert.assertEquals(expMoopAccumulatorSummaryTab, findElementByXpath(titleMoopAccumulatorSummary).getText());
    }

    public void verifyFieldsUnderMoopTransaction(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstMoopTransactionFields, 20);
        scrollToElementsAndCompare2Lists(expFields, lstMoopTransactionFields);
    }

    public void verifyFieldValuesUnderMoopTransaction() {
        explicitElementClickableWaitByXpath(lstMoopTransactionFieldValues, 30);
        scrollToElementsAndValidateDisplayStatus(lstMoopTransactionFieldValues);
    }

    public void verifySearchCriteriaInMoopTransaction() {
        List<WebElement> ActSearchFields = findElementsByXpath(txtSearchFieldsForMoopTransaction);
        for (WebElement column : ActSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }
}