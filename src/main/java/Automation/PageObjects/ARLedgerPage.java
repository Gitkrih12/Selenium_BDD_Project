package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ARLedgerPage extends SeleniumUtils {

    String lnkAccountManagement = "//*[contains(text(), ' Account Management ')]";
    String lnkARLedger = "//*[contains(text(), ' A/R Ledger ')]";
    String tabARLedger = "//h6";
    String btnAddARTransaction = "//button[contains(text(), 'Add A/R Transaction')]";
    String lstArLedgerColumns = "//*[@id='arLedgersGrid']//div[@class = 'ag-header-cell-label']//span[@ref = 'eText']";
    String txtSearchBoxARLedger = "//input[@ref='eInput' and @type = 'text']";
    String txtVendorId = "//input[@aria-label = 'Vendor ID Filter Input']";
    String lstARLedgerValues = "//*[@class = 'ag-cell-value']";
    String txtVendorName = "//input[@aria-label='Vendor Name Filter Input']";
    String txtTaxID = "//input[@aria-label='Tax ID / SSN Filter Input']";
    String txtAmount = "//input[@aria-label='Amount($) Filter Input']";
    String txtCreatedOn = "//input[@aria-label='Created On Filter Input']";

    private static String expVendorID = "";
    private static String expVendorName = "";
    private static String expTaxID = "";
    private static String expAmount = "";
    private static String expCreatedOn = "";

    // Scenario: Verify user able to navigate to A/R Ledger page from the Account Management grid in Left navigation panel
    public void userClicksARLedger() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(lnkAccountManagement), 20);
        clickElement(lnkAccountManagement);
        threadSleep(1000);
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
        List<WebElement> ActFields = findElementsByXpath(lstArLedgerColumns);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
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
        List<WebElement> ActSearchFields = findElementsByXpath(txtSearchBoxARLedger);
        for (WebElement column : ActSearchFields) {
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
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Vendor ID", "V0000000143");
        testValues.put("Vendor Name", "Maxwell Teresa");
        testValues.put("Tax ID/SSN", "929588446");
        testValues.put("Amount($)", "34400");
        testValues.put("Created On", "07/06/2022");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Vendor ID", "V0000000005");
        uatValues.put("Vendor Name", "SAFAR AIDA");
        uatValues.put("Tax ID/SSN", "020737147");
        uatValues.put("Amount($)", "400");
        uatValues.put("Created On", "07/27/2022");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstARLedgerValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstARLedgerValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
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
}