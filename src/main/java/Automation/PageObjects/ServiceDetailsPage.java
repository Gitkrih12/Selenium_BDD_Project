package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ServiceDetailsPage extends SeleniumUtils {

    String lnkGlobalSearch = "//div[contains(text(),'Global Search')]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "//div[@class='ag-pinned-left-cols-container']//a";
    String lnkServiceDetails = "//*[contains(text(), 'Service Details')]";
    String serviceDetailsColumnFields = "//*[@class='tab-pane fade show active']/div[1]/div | " +
            "//*[@id='nav-claim-details']/div[3]/div | //*[@id='nav-claim-details']/div[5]/div";
    String serviceLineFieldsTable = "//*[@id='nav-service-details']/div/app-servicedetails/table/thead/tr[1]/th | " +
            "//*[@id='nav-service-details']/div/app-servicedetails/table/thead/tr[2]/th";
    String footerFieldsButton = "//*[@class='button-padding-left footer']/button";
    String lnklineNumber = "(//*[@class='gridData ng-star-inserted']//a)[1]";
    String pricingTab = "//*[contains(text(),'Pricing')]";


    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void enterClaimNumberInSearchfield(String claimNumber) throws InterruptedException {
        clickElement(inputClaimNumber);
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), claimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void clickOnClaimNumber() {
        clickElement(eleClaimNumber);
    }

    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void clickOnServiceDetails() {
        clickElement(lnkServiceDetails);
    }

    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void userViewsAllColumnFieldsInServiceDetails(DataTable columnList) {
        List<String> columnListExp = columnList.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(serviceDetailsColumnFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Column Fields in Service Details page  : " + text);
            columnFieldsForCompare.add(text);
        }
        if (columnFieldsForCompare.equals(columnListExp)) {
            Assert.assertEquals(columnListExp, columnFieldsForCompare);
        }
    }

    //  Scenario: Verify Service Lines fields
    public void userViewsServiceLineFields(DataTable serviceLineFields) {
        List<String> serviceLineFieldsExp = serviceLineFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(serviceLineFieldsTable);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Service Line Fields should display  : " + text);
            columnFieldsForCompare.add(text);
        }
        if (columnFieldsForCompare.equals(serviceLineFieldsExp)) {
            Assert.assertEquals(serviceLineFieldsExp, columnFieldsForCompare);
        }
    }

    //  Scenario: Verify footer section available in Service details tab
    public void userViewsFooterSectionInServiceDetails(DataTable footerFields) {
        List<String> footerFieldsExp = footerFields.asList();
        List<WebElement> ActFooterFields = findElementsByXpath(footerFieldsButton);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFooterFields.size());
        for (WebElement column : ActFooterFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Footer fields in Service Details page :" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(footerFieldsExp)) {
            Assert.assertEquals(footerFieldsExp, fieldsForCompare);
        }
    }

    //  Scenario: Verify user able to navigate to Pricing page upon clicking Line number
    public void clickOnLineNumber() {
        clickElement(lnklineNumber);
    }

    //  Scenario: Verify user able to navigate to Pricing page upon clicking Line number
    public void userNavigatesToPricingPage() {
        String actualValue[] = findElementByXpath(pricingTab).getText().split(" ");
        Assert.assertEquals("Pricing-#P0020021100018", actualValue[0] + actualValue[1] + actualValue[2]);
    }
}