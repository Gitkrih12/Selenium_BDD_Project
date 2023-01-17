package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.stream.Collectors;

public class DocumentsPage extends SeleniumUtils {

    String tabDocument = "//*[@id='nav-documents-tab']";
    String tabEdiFile = "//*[@id = 'nav-edifiles-details-tab']";
    String tabAttachments = "//*[@id = 'nav-attachments-details-tab']";
    String btnFooterSection = "//*[@class='footer footer-flex']/button";
    String lstEdiFiles = "//app-documents//*[@id = 'resultsGrid']//span[@ref = 'eText']";
    String lstAttachments = "//app-documents//*[@id = 'resultsGrid1']//span[@ref = 'eText']";
    String lstEdiFilesValues = "(//app-documents//div[@aria-label = 'Press SPACE to select this row.'])[4]//span[@class = 'ag-cell-value']";
    String lstEdiFilesValuesUat = "(//*[@id='nav-edifiles-details']//div[@aria-label = 'Press SPACE to select this row.'])[5]//span[@class = 'ag-cell-value']";
    String lstAttachmentValues = "//*[@id = 'nav-attachments-details']//span[@ref='eText']";
    String lstEdiFilesHeaderName = "//*[@id = 'resultsGrid']//span[contains(text(), '$HeaderName^')]";
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String btnUploadDocument = "//button[contains(text(), 'Upload Document')]";
    String titleUploadDocument = "//h2[contains(text(), 'Upload Document')]";
    String lstUploadDocumentFields = "//*[contains(@class, 'row columnFont')]//span";
    String btnCancelAndUpload = "//mat-dialog-actions//button";
    String btnUpload = "//button[text() = 'Upload']";

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
        Assert.assertEquals(expSubTab1, actualTab1[0] + " " + actualTab1[1]);
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
        explicitElementClickableWaitByXpath(lstAttachments, 20);
        scrollToElementsAndCompare2Lists(columnsUnderAttachments, lstAttachments);
    }

    public void verifyFieldValuesUnderAttachments() {
        elementsDisplayValidation(lstAttachmentValues);
    }

    //  Scenario: Verify column fields in EDI files sub tab
    public void verifyUserViewsColumnsUnderEdiFilesSection(DataTable columnFields) {
        explicitElementClickableWaitByXpath(lstEdiFiles, 20);
        scrollToElementsAndCompare2Lists(columnFields, lstEdiFiles);
    }

    public void verifyFieldValuesUnderEdiFiles() {
        elementsDisplayValidation(lstEdiFiles);
    }

    public void userClicksOnUploadDocumentButton(){
        explicitVisibilityOfElementLocatedWaitByXpath(btnUploadDocument, 20);
        clickElement(btnUploadDocument);
    }

    public void verifyUserNavigatesToUploadDocumentWindow(String expWindow){
        Assert.assertEquals(expWindow, findElementByXpath(titleUploadDocument).getText());
    }

    public void verifyUploadDocumentFields(DataTable expFields){
        scrollToElementsAndCompare2Lists(expFields, lstUploadDocumentFields);
    }

    public void verifyButtonsUnderUploadDocument(DataTable expButtons){
        compare2Lists(expButtons, btnCancelAndUpload);
    }

    public void userEntersAllRequiredFields(){

    }

    public void clickOnUploadButton(){
        explicitVisibilityOfElementLocatedWaitByXpath(btnUpload, 30);
        clickElement(btnUpload);
    }
}