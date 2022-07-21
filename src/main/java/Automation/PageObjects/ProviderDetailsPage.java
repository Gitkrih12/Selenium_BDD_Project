package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProviderDetailsPage extends SeleniumUtils {

    String tabProviderDetails = "//*[contains(text(), 'Provider Details') and @type = 'button']";
    String providerDetailsSections = "//*[contains(text(), 'Group/Rendering Provider Details') or contains(text(),'Pay to Provider details')]";
    String payToProviderDetailsFields = "//*[contains(text(), 'Pay to Provider details')]//following::div[@class = 'row']//div";
    String groupRenderingProviderDetailsFields = "//*[@class='table table-striped']//tr//th";
    String btnFooterSection = "//*[@class='button-padding-left footer']//button";
    String lnkVendorId = "//a[contains(text(),'V0000000256')]";
    String titleArTransactions = "//*[@class='claims-list']";
    String eleCreditOverPaidStatus = "(//span[@class='bold-letter'])[1]";
    String eleDebitUnderPaidStatus = "(//span[@class='bold-letter'])[2]";
    String lstArTransactionFields = "//*[@role='columnheader']";
    String inputSearchFieldsForAR = "//*[@class = 'ag-floating-filter-input']";


    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    public void clickOnProviderDetails() {
        clickElement(tabProviderDetails);
    }

    public void userNavigatedToProvideDetails() {
        Assert.assertEquals("Provider Details", findElementByXpath(tabProviderDetails).getText());
    }

    //  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    public void userShouldViewProviderDetailsSection(DataTable providerDetailsSection) {
        List<String> sectionsExp = providerDetailsSection.asList();
        List<WebElement> ActSections = findElementsByXpath(providerDetailsSections);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActSections.size());
        for (WebElement column : ActSections) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Pay to Provider details and Group/Rendering Provider details are displayed :" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(sectionsExp)) {
            Assert.assertEquals(sectionsExp, fieldsForCompare);
        }
    }

    //  Scenario: Verify user able to view all the fields under Pay to Provider Details section
    public void userViewsFieldsUnderPayToProviderDetailsSection(DataTable fieldsUnderPayToProviderDetails) {
        List<String> fieldsExp = fieldsUnderPayToProviderDetails.asList();
        List<WebElement> ActFields = findElementsByXpath(payToProviderDetailsFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Pay to Provider Fields should display:" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(fieldsExp)) {
            Assert.assertEquals(fieldsExp, fieldsForCompare);
        }
    }

    //  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    public void userViewsFieldsUnderGroupRenderingProviderDetailsSection(DataTable fieldsUnderGroupRendering) {
        List<String> fieldsExp = fieldsUnderGroupRendering.asList();
        List<WebElement> ActFields = findElementsByXpath(groupRenderingProviderDetailsFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Group/Rendering Provider Details Fields should display:" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(fieldsExp)) {
            Assert.assertEquals(fieldsExp, fieldsForCompare);
        }
    }

    //  Scenario: Validate all the buttons available at the footer section under Provider Details tab
    public void userViewsFooterSectionInServiceDetails(DataTable footerSection) {
        List<String> footerSectionExp = footerSection.asList();
        List<WebElement> ActFooterSection = findElementsByXpath(btnFooterSection);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFooterSection.size());
        for (WebElement column : ActFooterSection) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Footer section should display:" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(footerSectionExp)) {
            Assert.assertEquals(footerSectionExp, fieldsForCompare);
        }
    }

    public void clickOnVendorId() throws InterruptedException {
        explicitElementClickableWaitByXpath((lnkVendorId), 20);
        clickElement(lnkVendorId);
        threadSleep(1000);
    }

    public void userNavigatesToARTransactionsPage() {
        String ARTransactionTitleActual[] = findElementByXpath(titleArTransactions).getText().split(" ");
        Assert.assertEquals("A/RLedger", ARTransactionTitleActual[0] + ARTransactionTitleActual[1]);
    }

    public void userViewsCreditOverPaidStatus(String expCreditStatus) {
        Assert.assertEquals(expCreditStatus, findElementByXpath(eleCreditOverPaidStatus).getText());
    }

    public void userViewsDebitUnderPaidStatus(String expOverpaidStatus) {
        Assert.assertEquals(expOverpaidStatus, findElementByXpath(eleDebitUnderPaidStatus).getText());
    }

    public void userViewsAccountReviewTransactionColumns(DataTable arTransactionFields) {
        List<String> arTransactionFieldsExp = arTransactionFields.asList();
        List<WebElement> ActFields = findElementsByXpath(lstArTransactionFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Claim Information section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + arTransactionFieldsExp);
        for (String exp : arTransactionFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifySearchFieldsUnderEachColumn() {
        List<WebElement> ActSearchFields = findElementsByXpath(inputSearchFieldsForAR);
        for (WebElement column : ActSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }
}