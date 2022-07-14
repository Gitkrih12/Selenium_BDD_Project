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
    String footerSectionBtn = "//*[@class='button-padding-left footer']//button";

    public void clickOnProviderDetails(){
        clickElement(providerDetailsTab);
    }

    public void userNavigatedToProvideDetails(){
        Assert.assertEquals("Provider Details", driver.findElement(By.xpath(providerDetailsTab)).getText());
    }

    public void userShouldViewProviderDetailsSection(DataTable providerDetailsSection){
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

    public void userViewsFieldsUnderPayToProviderDetailsSection(DataTable fieldsUnderPayToProviderDetails){
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

    public void userViewsFieldsUnderGroupRenderingProviderDetailsSection(DataTable fieldsUnderGroupRendering){
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

    public void userViewsFooterSectionInServiceDetails(DataTable footerSection){
        List<String> footerSectionExp = footerSection.asList();
        List<WebElement> ActFooterSection = findElementsByXpath(footerSectionBtn);
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
}