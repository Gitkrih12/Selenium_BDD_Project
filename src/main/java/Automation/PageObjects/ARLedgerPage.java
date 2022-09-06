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
    String txtSearchVendor = "//input[@placeholder='Enter Claim Number To Search Vendor']";
    String lstArLedgerColumns = "//*[@id='arLedgersGrid']//div[@class = 'ag-header-cell-label']//span[@ref = 'eText']";
    String txtSearchBoxARLedger = "//input[@ref='eInput' and @type = 'text']";

    private static String expVendorID = "";

    // Scenario: Verify user able to navigate to A/R Ledger page from the Account Management grid in Left navigation panel
    public void userClicksARLedger() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(lnkAccountManagement), 20);
        clickElement(lnkAccountManagement);
        threadSleep(1000);
        explicitVisibilityOfWait(findElementByXpath(lnkARLedger), 20);
        clickElement(lnkARLedger);
        threadSleep(1000);
    }

    public void userNavigatesToARLedgerPage(String expTab){
        Assert.assertEquals(expTab, findElementByXpath(tabARLedger).getText());
    }

    // Scenario: Verify user able to view all the column details in the A/R Ledger page
    public void verifyAddARTransactionButton(String expButton){
        Assert.assertEquals(expButton, findElementByXpath(btnAddARTransaction).getText());
    }

    public void verifySearchVendor(String expSearchVendor){
        Assert.assertEquals(expSearchVendor, findElementByXpath(txtSearchVendor).getAttribute("placeholder"));
    }

    public void verifyColumnsUnderARLedger(DataTable expColumns){
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
    public void verifySearchCriteriaForAllColumns(){
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
        findElementAndSendKeys(findElementByXpath(txtMemberId), expVendorID);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtMemberId);
        threadSleep(5000);
    }
}