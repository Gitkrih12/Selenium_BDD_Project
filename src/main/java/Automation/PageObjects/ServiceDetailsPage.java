package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.*;

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

    public void clickOnClaimNumber() {
        clickElement(eleClaimNumber);
    }

    public void clickOnServiceDetails() throws InterruptedException {
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
        Assert.assertEquals(expValue, Collections.frequency(columnFieldsForCompare,"C"));
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

    //  Scenario: Verify footer section available in Service details tab
    public void enterPendClaimNumberInSearchField() throws InterruptedException {
        threadSleep(1000);
        expClaimNumber = prop.getProperty("pendClaimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

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