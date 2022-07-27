package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class MoopPage extends SeleniumUtils {

    String tabMoop = "//*[@id ='nav-moop-tab']";
    String lstMoopColumns = "(//*[@id='nav-moop']//ag-grid-angular//div)[11]//span[@ref='eText']";
    String btnFooterFields = "//*[@class='button-padding-left footer']/button";
    String eleDeny = "//button[contains(text(),'Deny')]";


    //  Scenario: Verify user should be able to navigate to the MOOP page through view claims from Global Search page
    public void userClicksOnMoopTab() {
        clickElement(tabMoop);
    }

    public void verifyUserNavigatesToMoop(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabMoop).getText());
    }

    //  Scenario: Verify user should be able to view the appropriate table with all the fields in MOOP page
    public void userViewsAllColumnFieldsInMoop(DataTable columnFields) {
        List<String> columnListExp = columnFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstMoopColumns);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in Moop Table :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + columnListExp);
        for (String exp : columnListExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify the footer section should display in MOOP page
    public void userViewsFooterSectionInMoopPage(DataTable footerFields) {
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

    //  Scenario: Verify Deny button should highlight in Red color in footer section
    public void denyButtonHighlightsInRedColor(String expColor) {
        String actColor = getColorCodeForBackground(eleDeny);
        System.out.println("actual color code :" + actColor);
        Assert.assertEquals(expColor, actColor);
    }
}