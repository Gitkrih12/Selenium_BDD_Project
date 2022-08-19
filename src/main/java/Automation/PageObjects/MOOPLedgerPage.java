package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MOOPLedgerPage extends SeleniumUtils {

    String lnkMemberManagement = "//*[contains(text(), ' Member Management ')]";
    String lnkMOOPLedger = "(//*[contains(text(), 'MOOP Ledger')])[1]";
    String tabMOOPLedger = "//app-moop-ledger//h6";
    String lstMOOPLedger = "//*[@ref = 'eText']";
    String txtMOOPSearchBox = "//input[@ref='eInput' and @type = 'text']";
    String lnkMemberID = "";


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

    public void userClicksOnMemberId(){
        explicitVisibilityOfWait(findElementByXpath());
        clickElement();
    }

    public void userNavigatesToMemberTransactionScreen(String expTab){

    }
}