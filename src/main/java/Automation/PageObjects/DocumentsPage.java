package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DocumentsPage extends SeleniumUtils {

    String tabDocument = "//*[@id='nav-documents-tab']";
    String subtabsDocument = "(//*[@role='tablist'])[4]/button[@role='tab']";


    public void userClicksOnDocumentsTab() {
        clickElement(tabDocument);
    }

    public void verifySubTabsUnderDocumentsTab(DataTable subTabView) {
        List<String> subTabsExp = subTabView.asList();
        List<WebElement> ActFields = findElementsByXpath(subtabsDocument);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
            System.out.println(fieldsForCompare);
        }
        System.out.println("Sub-tabs of Documents are :" + fieldsForCompare);
        System.out.println("Expected fields are : " + subTabsExp);
        for (String exp : subTabsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }
}