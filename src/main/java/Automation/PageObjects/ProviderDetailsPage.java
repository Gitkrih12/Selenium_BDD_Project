package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProviderDetailsPage extends SeleniumUtils {

    String tabProviderDetails = "//button[@id='nav-provider-details-tab']";
    String lstProviderDetails = "(//div[@class='ng-star-inserted'])[3]//h6";
    String lstPayToProviderDetails = "//app-providerdetails//div[contains(@class, 'columnFont')]//div";
    String lstGroupRenderingProviderDetails = "//*[@class='table table-striped']//tr//th[position()<last()]";
    String btnFooterSection = "//*[@class='footer footer-flex']//button";
    String lnkVendorId = "//*[@id='nav-claim-details']//div[5]//a";
    String labelVendorId = "//*[@class='claims-list']";
    String labelCreditOverPaidStatus = "(//*[contains(@class, 'claims-list')])[2]";
    String labelDebitUnderPaidStatus = "(//*[contains(@class, 'claims-list')])[3]";
    String lstArTransactionFields = "//*[@role='columnheader']//span[text()]";
    String txtSearchFieldsForAR = "//*[@class = 'ag-floating-filter-input']";
    String lstPayToProviderDetailsValues = "//app-providerdetails//div[contains(@class, 'col-3')]//b";
    String lstGroupRenderingProviderDetailsValues = "//*[@class='table table-striped']//tr//td//div";


    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    public void clickOnProviderDetails() throws InterruptedException {
        explicitElementClickableWaitByXpath(tabProviderDetails, 50);
        clickElement(tabProviderDetails);
        threadSleep(3000);
    }

    public void userNavigatedToProviderDetails() {
        Assert.assertEquals("Provider Details", findElementByXpath(tabProviderDetails).getText());
    }

    //  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    public void userShouldViewProviderDetailsSection(DataTable providerDetailsSection) {
        List<String> sectionsExp = providerDetailsSection.asList();
        List<String> actFields = findElementsByXpath(lstProviderDetails)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actFields.size());
        System.out.println("Pay to Provider fields and Group/Rendering Provider details are displayed:" + actFields);
        System.out.println("Expected fields are: " + sectionsExp);
        Assert.assertEquals(sectionsExp, actFields);
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
        System.out.println("Fields in Payment Information section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void userViewsFieldValuesUnderPayToProviderDetails() {
        List<WebElement> payToProviderValues = findElementsByXpath(lstPayToProviderDetailsValues);
        System.out.println("Size:" + payToProviderValues.size());
        for (WebElement value : payToProviderValues) {
            isDisplayed(value);
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    //  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    public void userViewsFieldsUnderGroupRenderingProviderDetailsSection(DataTable fieldsUnderGroupRendering) {
        List<String> fieldsExp = fieldsUnderGroupRendering.asList();
        List<String> actFields = findElementsByXpath(lstGroupRenderingProviderDetails)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actFields.size());
        System.out.println("Group/Rendering Provider Details Fields should display:" + actFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, actFields);
    }

    public void userViewsFieldValuesUnderGroupRenderingProviderDetails() {
        List<WebElement> payToProviderValues = findElementsByXpath(lstGroupRenderingProviderDetailsValues);
        System.out.println("Size:" + payToProviderValues.size());
        for (WebElement value : payToProviderValues) {
            isDisplayed(value);
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    //  Scenario: Validate all the buttons available at the footer section under Provider Details tab
    public void userViewsFooterSectionInServiceDetails(DataTable footerSection) {
        List<String> fieldsExp = footerSection.asList();
        List<String> actFields = findElementsByXpath(btnFooterSection)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actFields.size());
        System.out.println("Footer fields should display:" + actFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, actFields);
    }

    public void clickOnVendorId() throws InterruptedException {
        explicitElementClickableWaitByXpath((lnkVendorId), 30);
        clickElement(lnkVendorId);
        threadSleep(3000);
    }

    public void userNavigatesToARTransactionsPage() {
        String expVendorID = prop.getProperty("vendorID");
        Assert.assertEquals(expVendorID, findElementByXpath(labelVendorId).getText());
    }

    //  Scenario: Verify user able to view the Credit/Overpaid and Debit/Underpaid status at the middle of the A/R Ledger
    public void userViewsCreditOverPaidStatus(String expCreditStatus) {
        Assert.assertEquals(expCreditStatus, findElementByXpath(labelCreditOverPaidStatus).getText());
    }

    public void userViewsDebitUnderPaidStatus(String expDebitStatus) {
        Assert.assertEquals(expDebitStatus, findElementByXpath(labelDebitUnderPaidStatus).getText());
    }

    //  Scenario: Verify user able to view the available Account Review Transactions and all the columns in the A/R transaction details page
    public void userViewsAccountReviewTransactionColumns(DataTable arTransactionFields) {
        List<String> arTransactionFieldsExp = arTransactionFields.asList();
        List<WebElement> actFields = findElementsByXpath(lstArTransactionFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + actFields.size());
        for (WebElement column : actFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("AR Transaction should display :" + fieldsForCompare);
        System.out.println("Expected fields are : " + arTransactionFieldsExp);
        for (String exp : arTransactionFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify Search box should display for all the columns on the A/R Transactions grid
    public void verifySearchFieldsUnderEachColumn() {
        List<WebElement> actSearchFields = findElementsByXpath(txtSearchFieldsForAR);
        for (WebElement column : actSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }
}