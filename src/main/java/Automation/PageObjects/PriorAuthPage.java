package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class PriorAuthPage extends SeleniumUtils {

    String tabPriorAuth = "//*[@id = 'nav-prior-authorization-tab']";
    String lstPriorAuth = "//app-prior-authorization//span[@ref = 'eText']";
    String txtPriorAuthSearchFields = "//app-prior-authorization//*[@class = 'ag-floating-filter-input']";
    String btnFooterFields = "//*[@class='footer footer-flex']//button";
    String lstPriorAuthValues = "(//app-prior-authorization//div[@aria-label = 'Press SPACE to select this row.'])[6]//span";
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";

    private static String expClaimNumber = "";


    //  Scenario: Verify user navigate to Prior Authorization tab from Global Search
    public void userClicksPriorAuthorizationTab() throws InterruptedException {
        threadSleep(1000);
        clickElement(tabPriorAuth);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToPriorAuthTab(String expPriorAuthTab) {
        Assert.assertEquals(expPriorAuthTab, findElementByXpath(tabPriorAuth).getText());
    }

    //  Scenario: Verify Prior Authorization column fields
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void enterClaimNumberInSearchField() throws InterruptedException {
        threadSleep(1000);
        expClaimNumber = prop.getProperty("priorAuthClaimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void clickOnClaimNumber() throws InterruptedException {
        threadSleep(2000);
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 5);
        clickElement(eleClaimNumber);
    }

    public void verifyUserViewsColumnFieldsUnderPriorAuth(DataTable columnFields) {
        List<String> fieldsExp = columnFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstPriorAuth);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in Prior Authorization tab :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyUserViewsFieldValuesUnderPriorAuthTab() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Auth Number", "310909004");
        testValues.put("Provider NPI", "1548435365");
        testValues.put("Tax ID", "200492277");
        testValues.put("Provider Name", "KACIUBAN STACEY");
        testValues.put("CPT-Units", "90999-1");
        testValues.put("ICD Code", "P09");
        testValues.put("Received Date", "09/09/2021");
        testValues.put("From Date", "08/01/2021");
        testValues.put("To Date", "10/30/2021");
        testValues.put("POS", "65");
        testValues.put("Status", "APP-CI");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Auth Number", "1245601103");
        uatValues.put("Provider NPI", "Jacqueline Croston");
        uatValues.put("Tax ID", "-");
        uatValues.put("Provider Name", "09/01/2018");
        uatValues.put("CPT-Units", "12/31/9999");
        uatValues.put("ICD Code", "-");
        uatValues.put("Received Date", "-");
        uatValues.put("From Date", "PRO000001324");
        uatValues.put("To Date", "MCR_100");
        uatValues.put("POS", "PRO000001324");
        uatValues.put("Status", "MCR_100");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstPriorAuthValues)
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
            List<String> ActValues = findElementsByXpath(lstPriorAuthValues)
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

    //  Scenario: Verify Search box under each column and able to enter search criteria
    public void verifySearchFieldsUnderEachColumn() {
        List<WebElement> actSearchFields = findElementsByXpath(txtPriorAuthSearchFields);
        for (WebElement column : actSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    //  Scenario: Validate footer section in Prior Authorization tab
    public void userViewsFooterSectionInPriorAuth(DataTable footerFields) {
        List<String> fieldsExp = footerFields.asList();
        List<String> ActFields = findElementsByXpath(btnFooterFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, ActFields);
    }
}