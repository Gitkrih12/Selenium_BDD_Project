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
    String btnFooterFields = "//*[@class='button-padding-left footer']/button";


    public void userClicksPriorAuthorizationTab() throws InterruptedException {
        clickElement(tabPriorAuth);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToPriorAuthTab(String expPriorAuthTab){
        Assert.assertEquals(expPriorAuthTab, findElementByXpath(tabPriorAuth).getText());
    }

    public void verifyUserViewsColumnFieldsUnderPriorAuth(DataTable columnFields){
        List<String> fieldsExp = columnFields.asList();
        List<String> ActFields = findElementsByXpath(lstPriorAuth)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Fields in Prior Authorization tab :" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
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
        List<String> fieldsExp = footerFields.asList();
        List<String> ActFields = findElementsByXpath(btnFooterFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }
}