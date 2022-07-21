package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ProviderDetailsPage extends SeleniumUtils {

    String providerDetailsTab = "//*[contains(text(), 'Provider Details') and @type = 'button']";
    String providerDetailsSections = "//*[contains(text(), 'Group/Rendering Provider Details') or contains(text(),'Pay to Provider details')]";
    String payToProviderDetailsFields = "//*[contains(text(), 'Pay to Provider details')]//following::div[@class = 'row']//div";
    String groupRenderingProviderDetailsFields = "//*[@class='table table-striped']//tr//th";
    String btnFooterSection = "//*[@class='button-padding-left footer']//button";


    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    public void clickOnProviderDetails() throws InterruptedException{
        clickElement(providerDetailsTab);
        threadSleep(1000);
    }

    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    public void userNavigatedToProvideDetails(){
        Assert.assertEquals("Provider Details", driver.findElement(By.xpath(providerDetailsTab)).getText());
    }

    //  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    public void userShouldViewProviderDetailsSection(DataTable providerDetailsSection){
        List<String> sectionsExp = providerDetailsSection.asList();
        List<WebElement> ActSections = findElementsByXpath(providerDetailsSections);
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
    public void userViewsFieldsUnderPayToProviderDetailsSection(DataTable fieldsUnderPayToProviderDetails){
        List<String> fieldsExp = fieldsUnderPayToProviderDetails.asList();
        List<WebElement> ActFields = findElementsByXpath(payToProviderDetailsFields);
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
    public void userViewsFieldsUnderGroupRenderingProviderDetailsSection(DataTable fieldsUnderGroupRendering){
        List<String> fieldsExp = fieldsUnderGroupRendering.asList();
        List<WebElement> ActFields = findElementsByXpath(groupRenderingProviderDetailsFields);
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
    public void userViewsFooterSectionInServiceDetails(DataTable footerSection){
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
}