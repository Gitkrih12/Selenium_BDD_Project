package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import cucumber.deps.com.thoughtworks.xstream.core.util.Fields;
import io.cucumber.core.gherkin.messages.internal.gherkin.AstNode;
import io.cucumber.datatable.DataTable;
import lombok.experimental.FieldDefaults;
import org.apache.velocity.util.ArrayListWrapper;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

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
        List<String> ActFields = findElementsByXpath(lstProviderDetails)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Pay to Provider fields and Group/Rendering Provider details are displayed:" + ActFields);
        System.out.println("Expected fields are: " + sectionsExp);
        Assert.assertEquals(ActFields, sectionsExp);
    }

    //  Scenario: Verify user able to view all the fields under Pay to Provider Details section
    public void userViewsFieldsUnderPayToProviderDetailsSection(DataTable fieldsUnderPayToProviderDetails) {
        List<Map<String, String>> rows = fieldsUnderPayToProviderDetails.asMaps(String.class, String.class);
        List<String> ActFields = findElementsByXpath(lstPayToProviderDetails)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Pay to Provider fields are displayed:" + ActFields);
        System.out.println("Expected fields are: " + rows);
        Assert.assertEquals(ActFields, rows);
    }

    //  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    public void userViewsFieldsUnderGroupRenderingProviderDetailsSection(DataTable fieldsUnderGroupRendering) {
        List<String> fieldsExp = fieldsUnderGroupRendering.asList();
        List<String> ActFields = findElementsByXpath(lstGroupRenderingProviderDetails)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Group/Rendering Provider Details Fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Validate all the buttons available at the footer section under Provider Details tab
    public void userViewsFooterSectionInServiceDetails(DataTable footerSection) {
        List<String> fieldsExp = footerSection.asList();
        List<String> ActFields = findElementsByXpath(btnFooterSection)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
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
        List<String> ActFields = findElementsByXpath(lstArTransactionFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("AR Transaction should display:" + ActFields);
        System.out.println("Expected fields are: " + arTransactionFieldsExp);
        Assert.assertEquals(ActFields, arTransactionFieldsExp);
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