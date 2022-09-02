package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
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
    String lstEdiFilesValuesUat = "(//*[@id='nav-edifiles-details']//div[@aria-label = 'Press SPACE to select this row.'])[5]//span[@class = 'ag-cell-value']";
    String lstAttachmentValues = "(//*[@id = 'nav-attachments-details']//div[@aria-label = 'Press SPACE to select this row.'])[4]//span[@class = 'ag-cell-value']";
    String lstEdiFilesHeaderName = "//*[@id = 'resultsGrid']//span[contains(text(), '$HeaderName^')]";
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";

    private static String expClaimNumber = "";


    //  Scenario: Verify user should be able to see attached files and EDI files in Documents tab
    public void userClicksOnDocumentsTab() throws InterruptedException {
        threadSleep(1000);
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
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void enterClaimNumberInSearchField() throws InterruptedException {
        threadSleep(1000);
        expClaimNumber = prop.getProperty("attachmentClaimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void clickOnClaimNumber() throws InterruptedException {
        threadSleep(2000);
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 5);
        clickElement(eleClaimNumber);
        threadSleep(1000);
    }

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
        testValues.put("File Name", "THORN TWP_EOPRemittance.pdf");
        testValues.put("Title", "EOPRemittance");
        testValues.put("Uploaded By", "LiveValorAdjudication@mirra.com");
        testValues.put("Uploaded On", "02/27/2020");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("File Name", "mxs codksmycck kscordcoxk ubkz vol__EOPRemittance.pdf");
        uatValues.put("Title", "EOPRemittance");
        uatValues.put("Uploaded By", "LiveValorAdjudication@mirra.com");
        uatValues.put("Uploaded On", "09/02/2022");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
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

    public void verifyFieldValuesUnderEdiFiles() {
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
            List<WebElement> ActColumnFields = findElementsByXpath(lstEdiFilesValuesUat);
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