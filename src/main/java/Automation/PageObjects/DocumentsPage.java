package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;

public class DocumentsPage extends SeleniumUtils {

    String tabDocument = "//*[@id='nav-documents-tab']";
    String tabEdiFile = "//*[@id = 'nav-edifiles-details-tab']";
    String tabAttachments = "//*[@id = 'nav-attachments-details-tab']";
    String btnFooterSection = "//*[@class='footer footer-flex']/button";
    String lstEdiFiles = "//app-documents//*[@id = 'resultsGrid']//span[@ref = 'eText']";
    String lstAttachments = "//app-documents//*[@id = 'resultsGrid1']//span[@ref = 'eText']";
    String lstAttachmentValues = "//*[@id = 'nav-attachments-details']//span[@ref='eText']";
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String btnUploadDocument = "//button[contains(text(), 'Upload Document')]";
    String titleUploadDocument = "//h2[contains(text(), 'Upload Document')]";
    String lstUploadDocumentFields = "//*[contains(@class, 'row columnFont')]//span";
    String btnCancelAndUpload = "//mat-dialog-actions//button";
    String btnUpload = "//button[text() = 'Upload']";
    String inputTitle = "//input[@name = 'Title']";
    String dropdownCategory = "//*[contains(@class,'mat-select-arrow-wrapper')]";
    String dropdownSelectCategory = "(//*[contains(@class,'mat-option-text')])[3]";
    String txtDescription = "//textarea[@id='description']";
    String txtFileUpload = "//input[@type='file']";
    String txtToasterMessage = "(//*[@id='toast-container']//div)[2]";
    String txtSuccessMessage = "//*[@role = 'alertdialog']";
    String eleDocument = "(//div[@col-id='title'])[2]/..";
    String tabNotes = "//*[@id = 'nav-notes-tab']";

    private static String expClaimNumber = "";
    private static String expTitle = "";
    private static String expDescription = "";
    private static String expFileName = "";


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
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 10);
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

    //  Scenario: Verify user should navigate to the Upload Document window on clicking Upload Document button
    public void userClicksOnUploadDocumentButton() {
        explicitVisibilityOfElementLocatedWaitByXpath(btnUploadDocument, 20);
        clickElement(btnUploadDocument);
    }

    public void verifyUserNavigatesToUploadDocumentWindow(String expWindow) {
        Assert.assertEquals(expWindow, findElementByXpath(titleUploadDocument).getText());
    }

    //  Scenario: Verify user should be able to view all the fields in upload document window
    public void verifyUploadDocumentFields(DataTable expFields) {
        scrollToElementsAndCompare2Lists(expFields, lstUploadDocumentFields);
    }

    public void verifyButtonsUnderUploadDocument(DataTable expButtons) {
        compare2Lists(expButtons, btnCancelAndUpload);
    }

    //  Scenario: Verify user able to upload the document successfully by entering all the required fields
    public void userEntersAllRequiredFields() {
        userEntersTitle();
        userSelectsCategory();
        userEntersDescription();
        uploadAFile(1);
    }


    public void uploadAFile(int sizeInMb) {
        String randomText = getRandomString(4);
        expFileName = randomText + sizeInMb + "mb_File.txt";
        createDummyFile(expFileName, 1000 * 1024 * sizeInMb);
        String filePath = "target/" + expFileName;
        File file = new File(filePath);
        uploadFileWithJavaScriptAndSendKeys(txtFileUpload, file.getAbsolutePath());
    }

    //  Scenario: Verify user throws an error message when Title is not entered
    public void clickOnUploadButton() {
        explicitVisibilityOfElementLocatedWaitByXpath(btnUpload, 30);
        clickElement(btnUpload);
    }

    public void verifySuccessToasterMessage(String expToasterMsg) {
        explicitVisibilityOfElementLocatedWaitByXpath(txtToasterMessage, 20);
        String actToasterMsg = findElementByXpath(txtToasterMessage).getText();
        String actSuccessMsg[] = findElementByXpath(txtSuccessMessage).getText().split(" ");
        Assert.assertEquals(expToasterMsg, actToasterMsg + " " + actSuccessMsg[0] + " " + actSuccessMsg[1] + " " + actSuccessMsg[2]);
    }

    public void verifyToasterMessage(String expToasterMsg) {
        explicitVisibilityOfElementLocatedWaitByXpath(txtToasterMessage, 20);
        String actToasterMsg[] = findElementByXpath(txtToasterMessage).getText().split(" ");
        Assert.assertEquals(expToasterMsg, actToasterMsg[0] + " " + actToasterMsg[1] + " " + actToasterMsg[2]);
    }

    public void clickOnNotesTab() {
        explicitVisibilityOfElementLocatedWaitByXpath(tabNotes, 30);
        clickElement(tabNotes);
    }

    public void verifyAddedDocumentInAttachmentsSection() throws InterruptedException {
        clickOnNotesTab();
        userClicksOnDocumentsTab();
        userClicksOnAttachmentsSubTab();
        explicitElementClickableWaitByXpath(eleDocument, 40);
        String actDocumentText = findElementByXpath(eleDocument).getText();
        System.out.println("Actual Document :" + actDocumentText);
        String[] actDocument = actDocumentText.split("\n");
        String actDocumentValue = actDocument[0] + " " + actDocument[1] + " " + actDocument[2] + " " + actDocument[3];
        System.out.println("actual document value :" + actDocumentValue);
        if (actDocumentValue.contains(expFileName) && actDocumentValue.contains(expTitle) && actDocumentValue.contains(expDescription)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void verifyErrorMessage(String expErrMsg) {
        explicitVisibilityOfElementLocatedWaitByXpath(txtToasterMessage, 20);
        Assert.assertEquals(expErrMsg, findElementByXpath(txtToasterMessage).getText());
    }

    //  Scenario: Verify user throws an error message when Category is not selected
    public void userEntersTitle() {
        expTitle = getRandomString(6);
        findElementAndSendKeys(findElementByXpath(inputTitle), expTitle);
    }

    //  Scenario: Verify user throws an error message when Description is not entered in field
    public void userSelectsCategory() {
        explicitElementClickableWaitByXpath(dropdownCategory, 20);
        clickElement(dropdownCategory);
        clickElement(dropdownSelectCategory);
    }

    public void userEntersDescription() {
        expDescription = getRandomString(4);
        findElementAndSendKeys(findElementByXpath(txtDescription), expDescription);
    }
}