package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class MoopPage extends SeleniumUtils {

    String tabMoop = "//*[@id ='nav-moop-tab']";
    String lstMoopColumns = "//app-moop//*[contains(@class, 'ag-theme-alpine')]//span[@ref='eText']";
    String btnFooterFields = "//*[@class='footer footer-flex']/button";
    String eleDeny = "//button[contains(text(),'Deny')]";
    String lstMoopValues = "(//app-moop//div[@class = 'ag-center-cols-container']//div)[1]//span";


    //  Scenario: Verify user should be able to navigate to the MOOP page through view claims from Global Search page
    public void userClicksOnMoopTab() throws InterruptedException {
        threadSleep(1000);
        clickElement(tabMoop);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToMoop(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabMoop).getText());
    }

    //  Scenario: Verify user should be able to view the appropriate table with all the fields in MOOP page
    public void userViewsAllColumnFieldsInMoop(DataTable columnFields) {
        List<String> fieldsExp = columnFields.asList();
        List<String> ActFields = findElementsByXpath(lstMoopColumns)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Fields in Moop should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, ActFields);
    }

    public void verifyFieldValuesUnderMoopTab() throws InterruptedException {
        threadSleep(2000);
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Year", "2022");
        testValues.put("Co-pay($)", "0.00");
        testValues.put("Co-Insurance($)", "151.85");
        testValues.put("Deductible($)", "233.00");
        testValues.put("Total($)", "384.85");
        testValues.put("Max Limit($)", "0.00");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Year", "2021");
        uatValues.put("Co-pay($)", "0.00");
        uatValues.put("Co-Insurance($)", "155.98");
        uatValues.put("Deductible($)", "203.00");
        uatValues.put("Total($)", "358.98");
        uatValues.put("Max Limit($)", "0.00");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstMoopValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "0.00"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstMoopValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "0.00"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    //  Scenario: Verify the footer section should display in MOOP page
    public void userViewsFooterSectionInMoopPage(DataTable footerFields) {
        List<String> fieldsExp = footerFields.asList();
        List<String> ActFields = findElementsByXpath(btnFooterFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify Deny button should highlight in Red color in footer section
    public void denyButtonHighlightsInRedColor(String expColor) {
        String actColor = getColorCodeForBackground(eleDeny);
        System.out.println("actual color code :" + actColor);
        Assert.assertEquals(expColor, actColor);
    }
}