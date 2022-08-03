package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentsPage extends SeleniumUtils {

    String tabDocument = "//*[@id='nav-documents-tab']";
    String tabEdiFile = "//*[@id = 'nav-edifiles-details-tab']";
    String tabAttachments = "//*[@id = 'nav-attachments-details-tab']";
    String btnFooterSection = "//*[@class='footer footer-flex']/button";
    String lstEdiFiles = "//app-documents//*[@id = 'resultsGrid']//span[@ref = 'eText']";
    String lstAttachments = "//app-documents//*[@id = 'resultsGrid1']//span[@ref = 'eText']";


    //  Scenario: Verify user should be able to see attached files and EDI files in Documents tab
    public void userClicksOnDocumentsTab() throws InterruptedException {
        clickElement(tabDocument);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToDocumentsTab(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabDocument).getText());
    }

    public void verifyUserViewsEDIFilesSubTab(String expSubTab1) {
        String actualValue = findElementByXpath(tabEdiFile).getText().replace("(", " ").replace(")", "");
        String actualTab1[] = actualValue.split(" ");
        Assert.assertEquals(expSubTab1, actualTab1[0] + actualTab1[1]);
    }

    public void verifyUserViewsAttachmentsSubTab(String expSubTab2) {
        String actualSubTabValue = findElementByXpath(tabAttachments).getText().replace("(", " ").replace(")", "");
        String actualTab2[] = actualSubTabValue.split(" ");
        Assert.assertEquals(expSubTab2, actualTab2[0]);
    }

    //  Scenario: Verify user should be able to see footer section buttons
    public void verifyFooterSectionInDocumentsPage(DataTable footerSection) {
        List<String> fieldsExp = footerSection.asList();
        List<String> ActFields = findElementsByXpath(btnFooterSection)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify column fields in Attachments sub tab
    public void verifyUserViewsColumnsUnderAttachmentsSection(DataTable columnsUnderAttachments) {
        List<String> fieldsExp = columnsUnderAttachments.asList();
        List<String> ActFields = findElementsByXpath(lstAttachments)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Attachments Columns should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify column fields in EDI files sub tab
    public void verifyUserViewsColumnsUnderEdiFilesSection(DataTable columnFields) {
        List<String> fieldsExp = columnFields.asList();
        List<String> ActFields = findElementsByXpath(lstEdiFiles)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("EDI Files Columns should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }
}