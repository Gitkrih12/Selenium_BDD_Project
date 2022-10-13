package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class NotesPage extends SeleniumUtils {

    String tabNotes = "//*[@id = 'nav-notes-tab']";
    String lstNotesColumns = "//app-notes//*[contains(@class, 'ag-theme-alpine')]//span[@ref = 'eText']";
    String btnFooterFields = "//*[@class='footer footer-flex']/button";
    String lstNotesValues = "//app-notes//div[@class = 'ag-center-cols-container']//span";
    String lstNotesValuesUat = "(//app-notes//div[@class = 'ag-center-cols-container']//div)[1]//span";


    //  Scenario: Verify user should navigate to Notes page on clicking claim number from Global Search page
    public void userClicksOnNotesTab() throws InterruptedException {
        threadSleep(1000);
        clickElement(tabNotes);
        threadSleep(1000);
    }

    public void verifyUserNavigatedToNotesTab(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabNotes).getText());
    }

    //  Scenario: Verify column fields in Notes tab
    public void verifyColumnsUnderNotesTab(DataTable columnFields) {
        List<String> columnListExp = columnFields.asList();
        List<String> ActFields = findElementsByXpath(lstNotesColumns)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Notes Fields should display:" + ActFields);
        System.out.println("Expected fields are: " + columnListExp);
        Assert.assertEquals(columnListExp, ActFields);
    }

    public void verifyFieldValuesUnderNotesTab() {
        List<WebElement> notesValues = findElementsByXpath(lstNotesValues);
        System.out.println("Size:" + notesValues.size());
        for (WebElement value : notesValues) {
            isDisplayed(value);
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    //  Scenario: Validate footer buttons in Notes Tab
    public void userViewsFooterSectionInNotesTab(DataTable footerFields) {
        List<String> fieldsExp = footerFields.asList();
        List<String> ActFields = findElementsByXpath(btnFooterFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, ActFields);
    }
}