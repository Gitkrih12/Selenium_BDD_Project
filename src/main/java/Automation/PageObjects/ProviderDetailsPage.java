package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProviderDetailsPage extends SeleniumUtils {

    String tabProviderDetails = "//button[@id='nav-provider-details-tab']";
    String lstProviderDetails = "(//div[@class='ng-star-inserted'])[3]//h6";
    String lstPayToProviderDetails = "//app-providerdetails//div[contains(@class, 'columnFont')] | //app-providerdetails//div//b";
    String lstGroupRenderingProviderDetails = "//*[@class='table table-striped']//tr//th[position()<last()]";
    String btnFooterSection = "//*[@class='button-padding-left footer']//button";
    String lnkVendorId = "//div[@id='nav-claim-details']//div[5]//a";
    String labelVendorId = "//*[@class='claims-list']";
    String labelCreditOverPaidStatus = "(//app-ar-transaction[@class='ng-star-inserted']//div)[3]";
    String labelDebitUnderPaidStatus = "(//app-ar-transaction[@class='ng-star-inserted']//div)[4]";
    String lstArTransactionFields = "//*[@role='columnheader' and position()>1]";
    String txtSearchFieldsForAR = "//*[@class = 'ag-floating-filter-input']";


    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    public void clickOnProviderDetails() throws InterruptedException {
        clickElement(tabProviderDetails);
        threadSleep(1000);
    }

    public void userNavigatedToProviderDetails() {
        Assert.assertEquals("Provider Details", findElementByXpath(tabProviderDetails).getText());
    }

    //  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    public void userShouldViewProviderDetailsSection(DataTable providerDetailsSection) {
        List<String> sectionsExp = providerDetailsSection.asList();
        List<WebElement> ActSections = findElementsByXpath(lstProviderDetails);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActSections.size());
        for (WebElement column : ActSections) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Pay to Provider details and Group/Rendering Provider details are displayed :" + fieldsForCompare);
        System.out.println("Expected fields are : " + sectionsExp);
        for (String exp : sectionsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify user able to view all the fields under Pay to Provider Details section
    public void userViewsFieldsUnderPayToProviderDetailsSection(DataTable fieldsUnderPayToProviderDetails) {
        List<String> fieldsExp = fieldsUnderPayToProviderDetails.asList();
        List<WebElement> ActFields = findElementsByXpath(lstPayToProviderDetails);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Pay to Provider Fields should display:" + fieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    public void userViewsFieldsUnderGroupRenderingProviderDetailsSection(DataTable fieldsUnderGroupRendering) {
        List<String> fieldsExp = fieldsUnderGroupRendering.asList();
        List<WebElement> ActFields = findElementsByXpath(lstGroupRenderingProviderDetails);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Group/Rendering Provider Details Fields should display:" + fieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Validate all the buttons available at the footer section under Provider Details tab
    public void userViewsFooterSectionInServiceDetails(DataTable footerSection) {
        List<String> footerSectionExp = footerSection.asList();
        List<WebElement> ActFooterSection = findElementsByXpath(btnFooterSection);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFooterSection.size());
        for (WebElement column : ActFooterSection) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Footer section should display:" + fieldsForCompare);
        System.out.println("Expected fields are : " + footerSectionExp);
        for (String exp : footerSectionExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void clickOnVendorId() throws InterruptedException {
        explicitElementClickableWaitByXpath((lnkVendorId), 20);
        clickElement(lnkVendorId);
        threadSleep(1000);
    }

    public void userNavigatesToARTransactionsPage(String expVendorID) {
        Assert.assertEquals(expVendorID, findElementByXpath(labelVendorId).getText());
    }

    public void userViewsCreditOverPaidStatus(String expCreditStatus) {
        Assert.assertEquals(expCreditStatus, findElementByXpath(labelCreditOverPaidStatus).getText());
    }

    public void userViewsDebitUnderPaidStatus(String expDebitStatus) {
        Assert.assertEquals(expDebitStatus, findElementByXpath(labelDebitUnderPaidStatus).getText());
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
        List<WebElement> ActSearchFields = findElementsByXpath(txtSearchFieldsForAR);
        for (WebElement column : ActSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }
}