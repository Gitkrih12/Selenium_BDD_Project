package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ActivityLoggerPage extends SeleniumUtils {

    String tabActivityLogger = "//button[@id ='nav-activity-logger-tab']";
    String lstActivityLogger = "//app-activity-logger//*[@id = 'resultsGrid']//span[@ref = 'eText']";
    String btnFooterSection = "//*[@class='footer footer-flex']/button";
    String lstActivityLoggerValues = "//app-activity-logger//div//span[@class = 'ag-cell-value']";
    String txtChangeset = "//input[@aria-label = 'Changeset Filter Input']";

    private static String expChangeset = "";

    //  Scenario: Verify user able to navigate to Activity Logger tab
    public void userClicksOnActivityLogger() throws InterruptedException {
        threadSleep(1000);
        clickElement(tabActivityLogger);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToActivityLogger(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabActivityLogger).getText());
    }

    public void userViewsActivityLoggerFields(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstActivityLogger);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Activity Logger Fields should display:" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void enterChangesetInSearchField() throws InterruptedException {
        expChangeset = prop.getProperty("changeset");
        scrollIntoView(findElementByXpath(txtChangeset), driver);
        findElementAndSendKeys(findElementByXpath(txtChangeset), expChangeset);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtChangeset);
        threadSleep(3000);
    }

    public void verifyFieldValuesUnderActivityLogger() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Changeset", "P100672157");
        testValues.put("Performed Date", "06/07/2022");
        testValues.put("Status of Claims", "PAID");
        testValues.put("Activity", "Check Refund updated");
        testValues.put("Description", "Check Refund applied with Check number -123456");
        testValues.put("Performed By", "ClaimsUser@ahcpllc.com");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Changeset", "P100456894");
        uatValues.put("Performed Date", "06/24/2022");
        uatValues.put("Status of Claims", "PAID");
        uatValues.put("Activity", "EFT PAYMENT DONE");
        uatValues.put("Description", "CLAIM PAYMENT HAS BEEN DONE THROUGH EFT PAYMENT");
        uatValues.put("Performed By", "ClaimsUser@ahcpllc.com");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstActivityLoggerValues)
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
            List<String> ActValues = findElementsByXpath(lstActivityLoggerValues)
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

    //  Scenario: Verify user able to navigate to Activity Logger tab and validated the buttons
    public void userViewsFooterSectionInActivityLogger(DataTable expFooterSection) {
        List<String> fieldsExp = expFooterSection.asList();
        List<String> ActFields = findElementsByXpath(btnFooterSection)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size" + ActFields.size());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, ActFields);
    }
}