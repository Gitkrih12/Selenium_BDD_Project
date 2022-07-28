package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DocumentsPage extends SeleniumUtils {

    String tabDocument = "//*[@id='nav-documents-tab']";
    String tabEdiFile = "//*[@id = 'nav-edifiles-details-tab']";
    String tabAttachments = "//*[@id = 'nav-attachments-details-tab']";
    String btnFooterSection = "//*[@class='button-padding-left footer']//button";
    String lstEdiFiles = "(//*[@id='resultsGrid']/div/div[1]/div[2]/div[1]/div[2]/div)[2]//div[1]//span[@class='ag-header-cell-text']";
    String lstAttachments = "(//*[@id='resultsGrid1']/div/div[1]/div[2]/div[1]/div[2]/div/div)[4]//div[1]//span[@class='ag-header-cell-text']";



    public void userClicksOnDocumentsTab() throws InterruptedException {
        clickElement(tabDocument);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToDocumentsTab(String expTab){
        Assert.assertEquals(expTab, findElementByXpath(tabDocument).getText());
    }

    public void verifyUserViewsEDIFilesSubTab(String expSubTab1){
        String actualValue = findElementByXpath(tabEdiFile).getText().replace("(", " ").replace(")", "");
        String actualTab1[] = actualValue.split(" ");
        Assert.assertEquals(expSubTab1, actualTab1[0]+actualTab1[1]);
    }

    public void verifyUserViewsAttachmentsSubTab(String expSubTab2){
        String actualSubTabValue = findElementByXpath(tabAttachments).getText().replace("(", " ").replace(")", "");
        String actualTab2[] = actualSubTabValue.split(" ");
        Assert.assertEquals(expSubTab2, actualTab2[0]);
    }

    public void verifyFooterSectionInDocumentsPage(DataTable footerSection){
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

    public void verifyUserViewsColumnsUnderAttachmentsSection(DataTable columnsUnderAttachments){
        List<String> columnFieldsExp = columnsUnderAttachments.asList();
        List<WebElement> ActColumns = findElementsByXpath(lstAttachments);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActColumns.size());
        for (WebElement column : ActColumns) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Attachments Columns should display:" + fieldsForCompare);
        System.out.println("Expected fields are : " + columnFieldsExp);
        for (String exp : columnFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyUserViewsColumnsUnderEdiFilesSection(DataTable columnFields){
        List<String> columnFieldsExp = columnFields.asList();
        List<WebElement> ActColumns = findElementsByXpath(lstEdiFiles);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActColumns.size());
        for (WebElement column : ActColumns) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("EDI Files Columns should display:" + fieldsForCompare);
        System.out.println("Expected fields are : " + columnFieldsExp);
        for (String exp : columnFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }
}