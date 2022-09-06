package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class NotesPage extends SeleniumUtils {

    String tabNotes = "//*[@id = 'nav-notes-tab']";
    String lstNotesColumns = "//app-notes//*[contains(@class, 'ag-theme-alpine')]//span[@ref = 'eText']";
    String btnFooterFields = "//*[@class='footer footer-flex']/button";
    String lstNotesValues = "//app-notes//div[@class = 'ag-center-cols-container']//span";
    String lstNotesValuesUat = "(//app-notes//div[@class = 'ag-center-cols-container']//div)[1]//span";


    //  Scenario: Verify user should navigate to Notes page on clicking claim number from Global Search page
    public void userClicksOnNotesTab() throws InterruptedException {
        threadSleep(1000);
        clickElement(tabNotes);
        threadSleep(1000);
    }

    public void verifyUserNavigatedToNotesTab(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabNotes).getText());
    }

    //  Scenario: Verify column fields in Notes tab
    public void verifyColumnsUnderNotesTab(DataTable columnFields) {
        List<String> columnListExp = columnFields.asList();
        List<String> ActFields = findElementsByXpath(lstNotesColumns)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Notes Fields should display:" + ActFields);
        System.out.println("Expected fields are: " + columnListExp);
        Assert.assertEquals(columnListExp, ActFields);
    }

    public void verifyFieldValuesUnderNotesTab() throws InterruptedException {
        threadSleep(2000);
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Title", "Claim Reprocessed");
        testValues.put("Category", "Plan - Claims/Appeals");
        testValues.put("Description", "Testing Reprocess P01MR22051701O");
        testValues.put("Created By", "ClaimsUser@ahcpllc.com");
        testValues.put("Created Date", "06/07/2022");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Title", "Moved to PEND status.");
        uatValues.put("Category", "Ambulance");
        uatValues.put("Description", "test");
        uatValues.put("Created By", "ClaimsUser@ahcpllc.com");
        uatValues.put("Created Date", "06/24/2022");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstNotesValues)
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
            List<String> ActValues = findElementsByXpath(lstNotesValuesUat)
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

    //  Scenario: Validate footer buttons in Notes Tab
    public void userViewsFooterSectionInNotesTab(DataTable footerFields) {
        List<String> fieldsExp = footerFields.asList();
        List<String> ActFields = findElementsByXpath(btnFooterFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, ActFields);
    }
}