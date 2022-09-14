package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MembersListPage extends SeleniumUtils {

    String lnkMemberManagement = "//*[contains(text(), ' Member Management ')]";
    String lnkMembersList = "//*[contains(text(), ' Members List ')]";
    String titleMembersList = "//h6";
    String lstMembersListFields = "//*[@class = 'ag-header-cell-label']//span[@ref = 'eText']";

    private static String expMembersListTab = "";


    public void userClicksOnMembersList() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(lnkMemberManagement), 20);
        clickElement(lnkMemberManagement);
        explicitVisibilityOfWait(findElementByXpath(lnkMembersList), 20);
        clickElement(lnkMembersList);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToMembersListPage(){
        expMembersListTab = prop.getProperty("membersListTab");
        Assert.assertEquals(expMembersListTab, findElementByXpath(titleMembersList).getText());
    }

    public void verifyFieldsUnderMembersList(DataTable expFields){
        List<String> columnListExp = expFields.asList();
        List<WebElement> actColumnFields = findElementsByXpath(lstMembersListFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + actColumnFields.size());
        for (WebElement column : actColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in Members List section :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + columnListExp);
        for (String exp : columnListExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }
}
