package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class PriorAuthPage extends SeleniumUtils {

    String tabPriorAuth = "//*[@id = 'nav-prior-authorization-tab']";
    String lstPriorAuth = "//app-prior-authorization//span[@ref = 'eText']";
    String txtPriorAuthSearchFields = "//app-prior-authorization//*[@class = 'ag-floating-filter-input']";
    String btnFooterFields = "//*[@class='footer footer-flex']//button";


    //  Scenario: Verify user navigate to Prior Authorization tab from Global Search
    public void userClicksPriorAuthorizationTab() throws InterruptedException {
        clickElement(tabPriorAuth);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToPriorAuthTab(String expPriorAuthTab) {
        Assert.assertEquals(expPriorAuthTab, findElementByXpath(tabPriorAuth).getText());
    }

    //  Scenario: Verify Prior Authorization column fields
    public void verifyUserViewsColumnFieldsUnderPriorAuth(DataTable columnFields) {
        List<String> fieldsExp = columnFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstPriorAuth);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in Prior Authorization tab :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify Search box under each column and able to enter search criteria
    public void verifySearchFieldsUnderEachColumn() {
        List<WebElement> ActSearchFields = findElementsByXpath(txtPriorAuthSearchFields);
        for (WebElement column : ActSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    //  Scenario: Validate footer section in Prior Authorization tab
    public void userViewsFooterSectionInPriorAuth(DataTable footerFields) {
        List<String> fieldsExp = footerFields.asList();
        List<String> ActFields = findElementsByXpath(btnFooterFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }
}