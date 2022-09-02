package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentsPage extends SeleniumUtils {

    String tabDocument = "//*[@id='nav-documents-tab']";
    String tabEdiFile = "//*[@id = 'nav-edifiles-details-tab']";
    String tabAttachments = "//*[@id = 'nav-attachments-details-tab']";
    String btnFooterSection = "//*[@class='footer footer-flex']/button";
    String lstEdiFiles = "//app-documents//*[@id = 'resultsGrid']//span[@ref = 'eText']";
    String lstAttachments = "//app-documents//*[@id = 'resultsGrid1']//span[@ref = 'eText']";
    String lstEdiFilesValues = "(//*[@id= 'resultsGrid'])[3]//span[@class = 'ag-cell-value']";
    String lstAttachmentValues = "(//*[@aria-label = 'Press SPACE to select this row.'])[6]//span[@class = 'ag-cell-value']";
    String lstEdiFilesHeaderName = "//*[@id = 'resultsGrid']//span[contains(text(), '$HeaderName^')]";


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
        Assert.assertEquals(fieldsExp, ActFields);
    }

    //  Scenario: Verify column fields in Attachments sub tab
    public void userClicksOnAttachmentsSubTab() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(tabAttachments), 10);
        clickElement(tabAttachments);
        threadSleep(1000);
    }

    public void verifyUserViewsColumnsUnderAttachmentsSection(DataTable columnsUnderAttachments) {
        List<String> fieldsExp = columnsUnderAttachments.asList();
        List<String> ActFields = findElementsByXpath(lstAttachments)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Attachments Columns should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, ActFields);
    }

    public void verifyFieldValuesUnderAttachments() throws InterruptedException {
        threadSleep(1000);
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("File Name", "mxs codksmycck kscordcoxk ubkz vol__EOPRemittance.pdf");
        testValues.put("Title", "EOPRemittance");
        testValues.put("Uploaded By", "LiveValorAdjudication@mirra.com");
        testValues.put("Uploaded On", "07/21/2022");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("File Name", "");
        uatValues.put("Title", "");
        uatValues.put("Uploaded By", "");
        uatValues.put("Uploaded On", "");

        if (environment.contains("test")) {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<WebElement> ActColumnFields = findElementsByXpath(lstAttachmentValues);
            List<String> columnFieldsForCompare = new ArrayList<>();
            System.out.println("Size " + ActColumnFields.size());
            for (WebElement column : ActColumnFields) {
                scrollIntoView(column, driver);
                String text = column.getText();
                columnFieldsForCompare.add(text);
            }
            for (String exp : fieldsExp) {
                if (columnFieldsForCompare.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<WebElement> ActColumnFields = findElementsByXpath(lstAttachmentValues);
            List<String> columnFieldsForCompare = new ArrayList<>();
            System.out.println("Size " + ActColumnFields.size());
            for (WebElement column : ActColumnFields) {
                scrollIntoView(column, driver);
                String text = column.getText();
                columnFieldsForCompare.add(text);
            }
            for (String exp : fieldsExp) {
                if (columnFieldsForCompare.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
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

    public void verifyFieldValuesUnderEdiFiles(){
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("File Name", "H1119.AH.PROD.MAO.ENC0132.AH.P.CARE.20220607195510.edi");
        testValues.put("File Type", "Encounter");
        testValues.put("Uploaded By", "claims-User@adjudication.com");
        testValues.put("Uploaded On", "06/07/2022");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("File Name", "H1119.AH.PROD.MAO.ENC0132.AH.P.CARE.20220624073021.edi");
        uatValues.put("File Type", "Encounter");
        uatValues.put("Uploaded By", "claims-User@adjudication.com");
        uatValues.put("Uploaded On", "06/24/2022");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstEdiFilesValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<WebElement> ActColumnFields = findElementsByXpath(lstEdiFilesValues);
            List<String> columnFieldsForCompare = new ArrayList<>();
            System.out.println("Size " + ActColumnFields.size());
            for (WebElement column : ActColumnFields) {
                scrollIntoView(column, driver);
                String text = column.getText();
                columnFieldsForCompare.add(text);
            }
            for (String exp : fieldsExp) {
                if (columnFieldsForCompare.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }
}