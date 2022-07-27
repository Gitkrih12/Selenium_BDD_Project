package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class NotesPage extends SeleniumUtils {

    String tabNotes = "//*[@id = 'nav-notes-tab']";
    String lstNotesColumns = "(//*[@class='ag-header-viewport'])[7]//div[@class='ag-header-cell-label']/span[1]";
    String btnFooterFields = "//*[@class='button-padding-left footer']/button";


    public void userClicksOnNotesTab() {
        clickElement(tabNotes);
    }

    public void verifyUserNavigatedToNotesTab(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabNotes).getText());
    }

    public void verifyColumnsUnderNotesTab(DataTable columnfields) {
        List<String> columnListExp = columnfields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstNotesColumns);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in Notes tab :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + columnListExp);
        for (String exp : columnListExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void userViewsFooterSectionInNotesTab(DataTable footerFields) {
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
}