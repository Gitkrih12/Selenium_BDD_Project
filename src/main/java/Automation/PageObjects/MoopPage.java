package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import java.util.List;
import java.util.stream.Collectors;

public class MoopPage extends SeleniumUtils {

    String tabMoop = "//*[@id ='nav-moop-tab']";
    String lstMoopColumns = "//app-moop//*[contains(@class, 'ag-theme-alpine')]//span[@ref='eText']";
    String btnFooterFields = "//*[@class='footer footer-flex']/button";
    String eleDeny = "//button[contains(text(),'Deny')]";


    //  Scenario: Verify user should be able to navigate to the MOOP page through view claims from Global Search page
    public void userClicksOnMoopTab() throws InterruptedException {
        clickElement(tabMoop);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToMoop(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabMoop).getText());
    }

    //  Scenario: Verify user should be able to view the appropriate table with all the fields in MOOP page
    public void userViewsAllColumnFieldsInMoop(DataTable columnFields) {
        List<String> fieldsExp = columnFields.asList();
        List<String> ActFields = findElementsByXpath(lstMoopColumns)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Fields in Moop should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify the footer section should display in MOOP page
    public void userViewsFooterSectionInMoopPage(DataTable footerFields) {
        List<String> fieldsExp = footerFields.asList();
        List<String> ActFields = findElementsByXpath(btnFooterFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify Deny button should highlight in Red color in footer section
    public void denyButtonHighlightsInRedColor(String expColor) {
        String actColor = getColorCodeForBackground(eleDeny);
        System.out.println("actual color code :" + actColor);
        Assert.assertEquals(expColor, actColor);
    }
}