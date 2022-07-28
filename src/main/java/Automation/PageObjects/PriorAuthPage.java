package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class PriorAuthPage extends SeleniumUtils {

    String tabPriorAuth = "//*[@id = 'nav-prior-authorization-tab']";
    String lstPriorAuth = "//app-prior-authorization//span[@ref = 'eText']";
    String txtPriorAuthSearchFields = "//app-prior-authorization//*[@class = 'ag-floating-filter-input']";
    String btnFooterFields = "//*[@class='button-padding-left footer']/button";


    public void userClicksPriorAuthorizationTab() throws InterruptedException {
        clickElement(tabPriorAuth);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToPriorAuthTab(String expPriorAuthTab){
        Assert.assertEquals(expPriorAuthTab, findElementByXpath(tabPriorAuth).getText());
    }

    public void verifyUserViewsColumnFieldsUnderPriorAuth(DataTable columnFields){
        List<String> priorAuthFieldsExp = columnFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstPriorAuth);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in Prior Authorization tab :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + priorAuthFieldsExp);
        for (String exp : priorAuthFieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifySearchFieldsUnderEachColumn(){
        List<WebElement> ActSearchFields = findElementsByXpath(txtPriorAuthSearchFields);
        for (WebElement column : ActSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    public void userViewsFooterSectionInPriorAuth(DataTable footerFields) {
        List<String> footerFieldsExp = footerFields.asList();
        List<WebElement> ActFooterFields = findElementsByXpath(btnFooterFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFooterFields.size());
        for (WebElement column : ActFooterFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Footer fields in Prior Auth page :" + fieldsForCompare);
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