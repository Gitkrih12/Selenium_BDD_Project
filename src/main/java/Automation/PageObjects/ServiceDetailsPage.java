package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.stream.Collectors;

public class ServiceDetailsPage extends SeleniumUtils {

    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String tabServiceDetails = "//*[contains(text(), 'Service Details')]";
    String lstServiceDetailsColumnFields = "//*[@id='nav-service-details']//div[contains(@class, 'columnFont')]//div";
    String tblServiceLineFields = "//table[@class='table table-striped ng-star-inserted']//tr//th[(node())]";
    String btnFooterFields = "//*[@class='footer footer-flex']/button";
    String lnkLineNumber = "(//*[@class='gridData ng-star-inserted']//a)[1]";
    String tabPricing = "//*[contains(text(),'Pricing')]";
    String lstServiceDetailsValues = "//*[@id='nav-service-details']//div[contains(@class, 'row mt-1')]//div";
    String lstServiceLineFieldValues = "//table[@class='table table-striped ng-star-inserted']/tbody//div";

    private static String expClaimNumber = "";
    private static String expPricingTab = "";


    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void enterClaimNumberInSearchField() throws InterruptedException {
        threadSleep(1000);
        expClaimNumber = prop.getProperty("claimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void clickOnClaimNumber() throws InterruptedException {
        threadSleep(2000);
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 5);
        clickElement(eleClaimNumber);
    }

    public void clickOnServiceDetails() throws InterruptedException {
        threadSleep(2000);
        clickElement(tabServiceDetails);
        threadSleep(1000);
    }

    public void userViewsAllColumnFieldsInServiceDetails(DataTable columnList) {
        List<String> columnListExp = columnList.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstServiceDetailsColumnFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in Service Details section :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + columnListExp);
        for (String exp : columnListExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyUserViewsFieldValuesInServiceDetails() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Adjustment", "$77.18");
        testValues.put("Deductible", "$0.00");
        testValues.put("Coinsurance", "$0.00");
        testValues.put("Copay", "$0.00");
        testValues.put("Total Payment Amount", "$32.82");
        testValues.put("Net Payment Amount", "$0.00");
        testValues.put("Recovery Amount", "$32.82");
        testValues.put("Interest Paid", "$0.00");
        testValues.put("Is A/R Amount Eligible", "");
        testValues.put("A/R Balance", "$164.76");
        testValues.put("Payable Amount", "$0.00");
        testValues.put("ICD Indicator", "ICD - 10");
        testValues.put("ICD Codes", "G912");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Adjustment", "$29.90");
        uatValues.put("Deductible", "$0.00");
        uatValues.put("Coinsurance", "$13.43");
        uatValues.put("Copay", "$0.00");
        uatValues.put("Total Payment Amount", "$52.67");
        uatValues.put("Net Payment Amount", "$52.67");
        uatValues.put("Recovery Amount", "$0.00");
        uatValues.put("Interest Paid", "$0.00");
        uatValues.put("Is A/R Amount Eligible", "");
        uatValues.put("A/R Balance", "$0.00");
        uatValues.put("Payable Amount", "$0.00");
        uatValues.put("ICD Indicator", "ICD - 10");
        uatValues.put("ICD Codes", "G301 F250 F411");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstServiceDetailsValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 6;
            int expValue2 = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "$0.00"));
            Assert.assertEquals(expValue2, Collections.frequency(ActValues, "$32.82"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<WebElement> ActColumnFields = findElementsByXpath(lstServiceDetailsColumnFields);
            List<String> columnFieldsForCompare = new ArrayList<>();
            System.out.println("Size " + ActColumnFields.size());
            for (WebElement column : ActColumnFields) {
                scrollIntoView(column, driver);
                String text = column.getText();
                columnFieldsForCompare.add(text);
            }
            int expValue = 6;
            int expValue2 = 2;
            Assert.assertEquals(expValue, Collections.frequency(columnFieldsForCompare, "$0.00"));
            Assert.assertEquals(expValue2, Collections.frequency(columnFieldsForCompare, "$52.67"));
            for (String exp : fieldsExp) {
                if (columnFieldsForCompare.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    //  Scenario: Verify Service Lines fields
    public void userViewsServiceLineFields(DataTable serviceLineFields) {
        List<String> serviceLineFieldsExp = serviceLineFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(tblServiceLineFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        int expValue = 2;
        Assert.assertEquals(expValue, Collections.frequency(columnFieldsForCompare, "A"));
        Assert.assertEquals(expValue, Collections.frequency(columnFieldsForCompare, "B"));
        Assert.assertEquals(expValue, Collections.frequency(columnFieldsForCompare, "C"));
        Assert.assertEquals(expValue, Collections.frequency(columnFieldsForCompare, "D"));
        System.out.println("Fields in Service Line Fields section :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + serviceLineFieldsExp);
        for (String exp : serviceLineFieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void userViewsServiceLineFieldValues() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Line#", "196551");
        testValues.put("Code", "94775");
        testValues.put("From", "03/05/2022");
        testValues.put("To", "03/05/2022");
        testValues.put("POS", "22");
        testValues.put("A", "-");
        testValues.put("B", "-");
        testValues.put("C", "-");
        testValues.put("D", "-");
        testValues.put("A1", "1");
        testValues.put("B1", "-");
        testValues.put("C1", "-");
        testValues.put("D1", "-");
        testValues.put("Unit", "UN");
        testValues.put("Unit Count", "1");
        testValues.put("Total Charges($)", "110.00");
        testValues.put("Adjudication Status", "Manually Adjudicated");
        testValues.put("Status", "APPROVED");
        testValues.put("PBP", "-");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Line#", "91967");
        uatValues.put("Code", "99308");
        uatValues.put("From", "12/02/2021");
        uatValues.put("To", "12/02/2021");
        uatValues.put("POS", "32");
        uatValues.put("A", "-");
        uatValues.put("B", "-");
        uatValues.put("C", "-");
        uatValues.put("D", "-");
        uatValues.put("A1", "1");
        uatValues.put("B1", "2");
        uatValues.put("C1", "3");
        uatValues.put("D1", "-");
        uatValues.put("Unit", "UN");
        uatValues.put("Unit Count", "1");
        uatValues.put("Total Charges($)", "96.00");
        uatValues.put("Adjudication Status", "Manually Adjudicated");
        uatValues.put("Status", "APPROVED");
        uatValues.put("PBP", "-");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstServiceLineFieldValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue1 = 8;
            int expValue2 = 2;
            int expValue3 = 2;
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "-"));
            Assert.assertEquals(expValue2, Collections.frequency(ActValues, "03/05/2022"));
            Assert.assertEquals(expValue3, Collections.frequency(ActValues, "1"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstServiceLineFieldValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue1 = 6;
            int expValue2 = 2;
            int expValue3 = 2;
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "-"));
            Assert.assertEquals(expValue2, Collections.frequency(ActValues, "12/02/2021"));
            Assert.assertEquals(expValue3, Collections.frequency(ActValues, "1"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    //  Scenario: Verify footer section available in Service details tab
    public void userViewsFooterSectionInServiceDetails(DataTable footerFields) {
        List<String> footerFieldsExp = footerFields.asList();
        List<WebElement> ActFooterFields = findElementsByXpath(btnFooterFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFooterFields.size());
        for (WebElement column : ActFooterFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Footer fields in Service Details page :" + fieldsForCompare);
        System.out.println("Expected fields are : " + footerFieldsExp);
        for (String exp : footerFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify user able to navigate to Pricing page upon clicking Line number
    public void clickOnLineNumber() {
        clickElement(lnkLineNumber);
    }

    public void userNavigatesToPricingPage() {
        String actualValue[] = findElementByXpath(tabPricing).getText().split(" ");
        expPricingTab = prop.getProperty("expPricingScreen");
        Assert.assertEquals(expPricingTab, actualValue[0] + actualValue[1] + actualValue[2]);
    }
}