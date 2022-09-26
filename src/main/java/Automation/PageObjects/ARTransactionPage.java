package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ARTransactionPage extends SeleniumUtils {

    String tabArTransaction = "//*[@id = 'nav-artranscation-tab']";
    String lstArTransaction = "//app-ar-transactionview//*[@id = 'resultsGrid']//span[@ref='eText']";
    String btnFooterSection = "//*[@class='footer footer-flex']//button";


    //  Scenario: Verify user able to Navigate to the A/R Transaction tab from Global Search
    public void userClicksOnARTransaction() throws InterruptedException {
        clickElement(tabArTransaction);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToARTransaction(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabArTransaction).getText());
    }

    public void userViewsArTransactionFields(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstArTransaction);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields in AR Transaction tab :" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify Buttons in A/R Transaction tab
    public void userViewsFooterSectionInARTransaction(DataTable expFooterFields) {
        List<String> fieldsExp = expFooterFields.asList();
        List<String> ActFields = findElementsByXpath(btnFooterSection)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size " + ActFields.size());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, ActFields);
    }
}