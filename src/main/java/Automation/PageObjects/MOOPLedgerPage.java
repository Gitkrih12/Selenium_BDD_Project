package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.checkerframework.checker.units.qual.C;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MOOPLedgerPage extends SeleniumUtils {

    String lnkMemberManagement = "//*[contains(text(), ' Member Management ')]";
    String lnkMOOPLedger = "(//*[contains(text(), 'MOOP Ledger')])[1]";
    String tabMOOPLedger = "//app-moop-ledger//h6";
    String lstMOOPLedger = "//*[@ref = 'eText']";
    String txtMOOPSearchBox = "//input[@ref='eInput' and @type = 'text']";
    String inputMemberID = "//*[@aria-label = 'Member ID Filter Input']";
    String lnkMemberID = "(//app-view-claim-render//a)[1]";
    String titleMoopTransaction = "(//app-moop-transaction//h6)[1]";
    String lstMoopTransactionFields = "//app-moop-transaction//span[@ref = 'eText']";
    String titleMoopAccumulatorSummary = "(//app-moop-transaction//h6)[2]";
    String lstMoopTransactionFieldValues = "//*[@class = 'ag-cell-value']";
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
        threadSleep(1000);
    }

    public void userNavigatesToMoopLedgerPage(String expTab){
        Assert.assertEquals(expTab, findElementByXpath(tabMOOPLedger).getText());
    }

    public void verifyFieldsUnderMoopLedger(DataTable expFields) {
        List<String> arTransactionFieldsExp = expFields.asList();
        List<WebElement> ActFooterFields = findElementsByXpath(lstMOOPLedger);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFooterFields.size());
        for (WebElement column : ActFooterFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Moop Ledger fields  should display :" + fieldsForCompare);
        System.out.println("Expected fields are : " + arTransactionFieldsExp);
        for (String exp : arTransactionFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifySearchCriteriaInMoopLedgerPage(){
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
        findElementAndSendKeys(findElementByXpath(inputMemberID), expMemberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputMemberID);
        explicitVisibilityOfWait(findElementByXpath(lnkMemberID),10);
        clickElement(lnkMemberID);
        threadSleep(1000);
    }

    public void userNavigatesToMoopTransactionScreen(){
        expMoopTransactionTab = prop.getProperty("moopTransactionTab");
        Assert.assertEquals(expMoopTransactionTab, findElementByXpath(titleMoopTransaction).getText());
    }

    public void userNavigatesToMoopAccumulatorSummary(){
        expMoopAccumulatorSummaryTab = prop.getProperty("moopAccumulatorSummaryTab");
        Assert.assertEquals(expMoopAccumulatorSummaryTab, findElementByXpath(titleMoopAccumulatorSummary).getText());
    }

    public void verifyFieldsUnderMoopTransaction(DataTable expFields){
        List<String> columnListExp = expFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstMoopTransactionFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in Moop Transaction and Accumulator summary section :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + columnListExp);
        for (String exp : columnListExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldValuesUnderMoopTransaction(){
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Claim Number", "I00MR220303002");
        testValues.put("Type Of Coverage", "Part B");
        testValues.put("Network Affiliation", "INN");
        testValues.put("Member Responsibility", "CO-INSURANCE");
        testValues.put("Moop Amount($)", "0");
        testValues.put("Transaction Date ", "04/04/2022");
        testValues.put("Transaction By", "ClaimsUser@ahcpllc.com");
        testValues.put("Remarks", "I00MR220303002 REPROCESSED");
        testValues.put("Type Of Coverage1", "Part B");
        testValues.put("Network Affiliation1", "INN");
        testValues.put("Deductible", "0");
        testValues.put("Copay ($)", "0");
        testValues.put("Coinsurance ($)", "0");
        testValues.put("Total Amount ($)", "0");
        testValues.put("Moop Year", "2022");
        testValues.put("Max Moop Year", "-");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Claim Number", "I02MR22031003O");
        uatValues.put("Type Of Coverage", "Part A");
        uatValues.put("Network Affiliation", "INN");
        uatValues.put("Member Responsibility", "CO-INSURANCE");
        uatValues.put("Moop Amount($)", "3000");
        uatValues.put("Transaction Date ", "05/20/2022");
        uatValues.put("Transaction By ", "ClaimsUser@ahcpllc.com");
        uatValues.put("Remarks", "User Updated");
        uatValues.put("Type Of Coverage1", "Part A");
        uatValues.put("Network Affiliation1", "INN");
        uatValues.put("Deductible", "0");
        uatValues.put("Copay ($)", "0");
        uatValues.put("Coinsurance ($)", "3000");
        uatValues.put("Total Amount ($)", "3000");
        uatValues.put("Moop Year", "2022");
        uatValues.put("Max Moop Year", "-");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstMoopTransactionFieldValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue1 = 2;
            int expValue2 = 5;
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "INN"));
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "Part B"));
            Assert.assertEquals(expValue2, Collections.frequency(ActValues, "0"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstMoopTransactionFieldValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue1 = 2;
            int expValue2 = 3;
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "INN"));
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "Part A"));
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "0"));
            Assert.assertEquals(expValue2, Collections.frequency(ActValues, "3000"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    public void verifySearchCriteriaInMoopTransaction(){
        List<WebElement> ActSearchFields = findElementsByXpath(txtSearchFieldsForMoopTransaction);
        for (WebElement column : ActSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }
}