package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        explicitElementClickableWaitByXpath(inputClaimNumber, 10);
        expClaimNumber = prop.getProperty("claimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void clickOnClaimNumber() throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleClaimNumber), 20, expClaimNumber);
        clickElement(eleClaimNumber);
        threadSleep(1000);
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
        List<WebElement> serviceDetailsValues = findElementsByXpath(lstServiceDetailsValues);
        System.out.println("Size:" + serviceDetailsValues.size());
        for (WebElement value : serviceDetailsValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
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
        List<WebElement> serviceLineFieldValues = findElementsByXpath(lstServiceLineFieldValues);
        System.out.println("Size:" + serviceLineFieldValues.size());
        for (WebElement value : serviceLineFieldValues) {
            isDisplayed(value);
            System.out.println("Value is displayed: " + isDisplayed(value));
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