package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ARLedgerPage extends SeleniumUtils {

    String lnkAccountManagement = "//*[contains(text(), ' Account Management ')]";
    String lnkARLedger = "//*[contains(text(), ' A/R Ledger ')]";
    String tabARLedger = "//h6";
    String btnAddARTransaction = "//button[contains(text(), 'Add A/R Transaction')]";
    String lstArLedgerColumns = "//*[@id='arLedgersGrid']//div[@class = 'ag-header-cell-label']//span[@ref = 'eText']";
    String txtSearchBoxARLedger = "//ag-grid-angular[@id='arLedgersGrid']//span[@ref='eText']//following::input[@type='text']";
    String txtVendorId = "//input[@aria-label = 'Vendor ID Filter Input']";
    String lstARLedgerValues = "//*[@class = 'ag-cell-value']";
    String txtVendorName = "//input[@aria-label='Vendor Name Filter Input']";
    String txtTaxID = "//input[@aria-label='Tax ID / SSN Filter Input']";
    String txtAmount = "//input[@aria-label='Amount($) Filter Input']";
    String txtCreatedOn = "//input[@aria-label='Created On Filter Input']";
    String lnkVendorId = "(//*[@class = 'ag-cell-value']//a)[1]";
    String txtTransactionType = "//*[@aria-label = 'Transaction Type Filter Input']";
    String lstARTransactionValues = "(//*[@id='arTransacrtionsResultId']//div[@role='rowgroup'])[2]//span";
    String txtTransactionDate = "//*[@aria-label = 'Transaction Date Filter Input']";
    String txtTransactionAmount = "//*[@aria-label = 'Transaction Amount ($) Filter Input']";
    String txtRunningBalance = "//*[@aria-label = 'Running Balance ($) Filter Input']";
    String txtTransactedBy = "//*[@aria-label = 'Transacted By Filter Input']";
    String txtClaimNumber = "//*[@aria-label = 'Claim Number Filter Input']";
    String txtRemarks = "//*[@aria-label = 'Remarks Filter Input']";

    private static String expVendorID = "";
    private static String expVendorName = "";
    private static String expTaxID = "";
    private static String expAmount = "";
    private static String expCreatedOn = "";
    private static String expTransactionType = "";
    private static String expTransactionDate = "";
    private static String expTransactionAmount = "";
    private static String expRunningBalance = "";
    private static String expTransactedBy = "";
    private static String expClaimNumber = "";
    private static String expRemarks = "";


    // Scenario: Verify user able to navigate to A/R Ledger page from the Account Management grid in Left navigation panel
    public void userClicksARLedger() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(lnkAccountManagement), 20);
        clickElement(lnkAccountManagement);
        explicitVisibilityOfWait(findElementByXpath(lnkARLedger), 20);
        clickElement(lnkARLedger);
        threadSleep(1000);
    }

    public void userNavigatesToARLedgerPage(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabARLedger).getText());
    }

    // Scenario: Verify user able to view all the column details in the A/R Ledger page
    public void verifyAddARTransactionButton(String expButton) {
        Assert.assertEquals(expButton, findElementByXpath(btnAddARTransaction).getText());
    }

    public void verifyColumnsUnderARLedger(DataTable expColumns) {
        List<String> arLedgerFieldsExp = expColumns.asList();
        List<WebElement> actFields = findElementsByXpath(lstArLedgerColumns);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + actFields.size());
        for (WebElement column : actFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("AR Ledger Fields should display :" + fieldsForCompare);
        System.out.println("Expected fields are : " + arLedgerFieldsExp);
        for (String exp : arLedgerFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    // Scenario: Verify Search box should display for all the columns on the grid
    public void verifySearchCriteriaForAllColumns() {
        List<WebElement> actSearchFields = findElementsByXpath(txtSearchBoxARLedger);
        for (WebElement column : actSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    // Scenario: Verify when user enters the data in search criteria to display the appropriate results
    public void userEntersVendorIdInSearchCriteria() throws InterruptedException {
        expVendorID = prop.getProperty("arLedgerVendorID");
        findElementAndSendKeys(findElementByXpath(txtVendorId), expVendorID);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtVendorId);
        threadSleep(5000);
    }

    public void verifyAppropriateResults() {
        List<WebElement> arLedgerValues = findElementsByXpath(lstARLedgerValues);
        System.out.println("Size:" + arLedgerValues.size());
        for (WebElement value : arLedgerValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    public void userEntersVendorNameInSearchCriteria() throws InterruptedException {
        expVendorName = prop.getProperty("arLedgerVendorName");
        findElementAndSendKeys(findElementByXpath(txtVendorName), expVendorName);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtVendorName);
        threadSleep(5000);
    }

    public void userEntersTaxIdInSearchCriteria() throws InterruptedException {
        expTaxID = prop.getProperty("arLedgerTaxID");
        findElementAndSendKeys(findElementByXpath(txtTaxID), expTaxID);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtTaxID);
        threadSleep(5000);
    }

    public void userEntersAmountInSearchCriteria() throws InterruptedException {
        expAmount = prop.getProperty("arLedgerAmount");
        findElementAndSendKeys(findElementByXpath(txtAmount), expAmount);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtAmount);
        threadSleep(5000);
    }

    public void userEntersCreatedOnInSearchCriteria() throws InterruptedException {
        expCreatedOn = prop.getProperty("arLedgerCreatedOn");
        findElementAndSendKeys(findElementByXpath(txtCreatedOn), expCreatedOn);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtCreatedOn);
        threadSleep(5000);
    }

    //  Scenario: Verify user navigates to the A/R Transaction claim details on clicking Vendor ID and validates all the fields
    public void userClicksOnVendorID() throws InterruptedException {
        expVendorID = prop.getProperty("vendorId");
        findElementAndSendKeys(findElementByXpath(txtVendorId), expVendorID);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtVendorId);
        threadSleep(5000);
        explicitElementClickableWaitByXpath((lnkVendorId), 30);
        clickElement(lnkVendorId);
        threadSleep(2000);
    }

    public void userClicksVendorID() throws InterruptedException {
        expVendorID = prop.getProperty("transactionVendorId");
        findElementAndSendKeys(findElementByXpath(txtVendorId), expVendorID);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtVendorId);
        threadSleep(5000);
        explicitElementClickableWaitByXpath((lnkVendorId), 30);
        clickElement(lnkVendorId);
        threadSleep(2000);
    }

    public void userEntersTransactionTypeInSearchCriteria() throws InterruptedException {
        expTransactionType = prop.getProperty("transactionType");
        findElementAndSendKeys(findElementByXpath(txtTransactionType), expTransactionType);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtTransactionType);
        threadSleep(5000);
    }

    public void verifyAppropriateResultsInARTransaction() {
        List<WebElement> arTransactionValues = findElementsByXpath(lstARTransactionValues);
        System.out.println("Size:" + arTransactionValues.size());
        for (WebElement value : arTransactionValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    public void userEntersTransactionDateInSearchCriteria() throws InterruptedException {
        expTransactionDate = prop.getProperty("transactionDate");
        findElementAndSendKeys(findElementByXpath(txtTransactionDate), expTransactionDate);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtTransactionDate);
        threadSleep(5000);
    }

    public void userEntersTransactionAmountInSearchCriteria() throws InterruptedException {
        expTransactionAmount = prop.getProperty("transactionAmount");
        findElementAndSendKeys(findElementByXpath(txtTransactionAmount), expTransactionAmount);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtTransactionAmount);
        threadSleep(5000);
    }

    public void userEntersRunningBalanceInSearchCriteria() throws InterruptedException {
        expRunningBalance = prop.getProperty("runningBalance");
        findElementAndSendKeys(findElementByXpath(txtRunningBalance), expRunningBalance);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtRunningBalance);
        threadSleep(5000);
    }

    public void userEntersTransactedByInSearchCriteria() throws InterruptedException {
        expTransactedBy = prop.getProperty("transactedBy");
        findElementAndSendKeys(findElementByXpath(txtTransactedBy), expTransactedBy);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtTransactedBy);
        threadSleep(5000);
    }

    public void userEntersClaimNumberInSearchCriteria() throws InterruptedException {
        expClaimNumber = prop.getProperty("claimNumberARTransaction");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
        threadSleep(5000);
    }

    public void userEntersRemarksInSearchCriteria() throws InterruptedException {
        expRemarks = prop.getProperty("remarks");
        findElementAndSendKeys(findElementByXpath(txtRemarks), expRemarks);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtRemarks);
        threadSleep(5000);
    }
}