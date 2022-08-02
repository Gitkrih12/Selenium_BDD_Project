package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NotesPage extends SeleniumUtils {

    String tabNotes = "//*[@id = 'nav-notes-tab']";
    String lstNotesColumns = "//app-notes//*[contains(@class, 'ag-theme-alpine')]//span[@ref = 'eText']";
    String btnFooterFields = "//*[@class='button-padding-left footer']/button";


    public void userClicksOnNotesTab() throws InterruptedException {
        clickElement(tabNotes);
        threadSleep(1000);
    }

    public void verifyUserNavigatedToNotesTab(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabNotes).getText());
    }

    public void verifyColumnsUnderNotesTab(DataTable columnFields) {
        List<String> columnListExp = columnFields.asList();
        List<String> ActFields = findElementsByXpath(lstNotesColumns)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Notes Fields should display:" + ActFields);
        System.out.println("Expected fields are: " + columnListExp);
        Assert.assertEquals(ActFields, columnListExp);
    }

    public void userViewsFooterSectionInNotesTab(DataTable footerFields) {
        List<String> fieldsExp = footerFields.asList();
        List<String> ActFields = findElementsByXpath(btnFooterFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }
}