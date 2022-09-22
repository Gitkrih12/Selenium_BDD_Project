package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class UploadFilesPage extends SeleniumUtils {

    String mnuFileManagement = "//div[contains(text(),'File Management')]";
    String mnuUploadFiles = "(//div[contains(text(), 'Upload Files')])[1]";
    String tabUploadFiles = "(//div[contains(text(), 'Upload Files')])[2]";
    String lblUploadFiles = "//div[@class='drag']";
    String txtFileUpload = "//input[@type='file']";
    String uploadFilesExp = "Drag Files Here or";
    String lbl837UploadFileName = "//tbody//tr[1]//td[1]";
    String btnUploadFile = "//button[contains(text(),'Upload File')]";
    String txtPlanReceivedDate = "(//tbody//tr[1]/td[2]//input[1])[1]";
    String msgFileUploadToaster = "//div[@aria-live='polite']";
    String fileUploadSuccessfulMessageExp = "File(s) Uploaded successfully";
    String fileUploadInvalidMessageExp = "Invalid Payer ID File Identified by system. Please upload a file with current payer ID details.";
    String btnDelete = "//button[contains(text(),'Delete')]";
    String tblFileList = "//table//tbody//tr";
    String lstFileUploadColumnFields = "//div[contains(text(),'Total File')]|//tr/th[node()]";
    String btnCancel = "//button[contains(text(),'Cancel')]";

    //    Scenario: Verify user navigates to Upload files section on clicking Upload Files in Left Navigation Menu
    public void clickOnUploadFiles() {
        clickElement(mnuFileManagement);
        moveToElement(mnuUploadFiles).perform();
        clickElement(mnuUploadFiles);
    }
    public void verifyUserIsOnUploadFilesTab(String uploadFilesTitleExp) {
        explicitVisibilityOfElementLocatedWaitByXpath(tabUploadFiles, 10).click();
        String[] uploadFilesTitleText = getText(tabUploadFiles).split(" ");
        String uploadFilesTitleAct = uploadFilesTitleText[0] + " " + uploadFilesTitleText[1];
        System.out.println("Upload files actual title is: " + uploadFilesTitleAct);
        Assert.assertEquals(uploadFilesTitleExp, uploadFilesTitleAct);
    }

    public void verifyUserNavigatedToUploadFilesScreen() {
        String uploadFilesAct = explicitVisibilityOfElementLocatedWaitByXpath(lblUploadFiles, 5).getText();
        System.out.println("Actual message is: " + uploadFilesAct);
        Assert.assertEquals(uploadFilesExp, uploadFilesAct);
    }

    //    Scenario: Verify user should see Drag Files Here (or) Choose File option and able to upload file
    public void verifyUserAbleToChoose837FilesFromSystem() throws InterruptedException, AWTException {
        String basePath = System.getProperty("user.dir");
        String filePath = basePath + prop.getProperty("uploadFilePath1");
        uploadFileWithJavaScriptAndSendKeys(txtFileUpload, filePath);
        boolean uploadFileStatus = explicitVisibilityOfElementLocatedWaitByXpath(btnUploadFile, 10).isDisplayed();
        Assert.assertTrue(uploadFileStatus);
    }

    //    Scenario: Verify Total File Selected section
    public void verifyUserAbleToChooseMultiple837FilesFromSystem() throws InterruptedException, AWTException {
        String basePath = System.getProperty("user.dir");

        String filePath1 = basePath + prop.getProperty("uploadFilePath1");
        uploadFileWithJavaScriptAndSendKeys(txtFileUpload, filePath1);
        explicitVisibilityOfElementLocatedWaitByXpath(btnUploadFile, 10);

        String filePath2 = basePath + prop.getProperty("uploadFilePath2");
        uploadFileWithJavaScriptAndSendKeys(txtFileUpload, filePath2);

        boolean uploadFileStatus = explicitVisibilityOfElementLocatedWaitByXpath(btnUploadFile, 10).isDisplayed();
        Assert.assertTrue(uploadFileStatus);
    }

    public void validateSelectedFileCountOnFileUploadPage() {
        List<WebElement> fileRecords = findElementsByXpath(tblFileList);
        int fileRecordsSizeAct = fileRecords.size();
        int fileRecordsSizeExp = 2;
        System.out.println("Actual File records size: " + fileRecords.size());
        Assert.assertEquals(fileRecordsSizeExp, fileRecordsSizeAct);
    }

    //    Scenario: Verify user should see chosen files/dragged files in the 'Total File Selected' Grid
    public void verifyUserAbleToViewSelectedFilesUnderTotalFileSection() throws InterruptedException, AWTException {
        String UploadFileName837Exp = prop.getProperty("837UploadFileName1");
        String UploadFileName837Act = getText(lbl837UploadFileName);
        Assert.assertEquals(UploadFileName837Exp, UploadFileName837Act);
    }
    public void verifyUserAbleToEnterPlanReceivedDate() throws Exception {
        clearUsingKeyClass(txtPlanReceivedDate);
        String date = subtractDaysFromCurrentDateAndGetPastDate("MM/dd/yyyy", 10);
        findElementAndSendKeys(findElementByXpath(txtPlanReceivedDate), date);
        String text = getAttribute(txtPlanReceivedDate, "ng-reflect-model");
        System.out.println("UI plan received date is: " + text);
    }
    public void clickOnUploadFileButton() {
        explicitVisibilityOfElementLocatedWaitByXpath(btnUploadFile, 5).click();
        String fileUploadToasterMessageAct = explicitVisibilityOfElementLocatedWaitByXpath(msgFileUploadToaster, 10).getText();
        System.out.println("File upload actual message is: " + fileUploadToasterMessageAct);
        Assert.assertEquals(fileUploadSuccessfulMessageExp, fileUploadToasterMessageAct);
    }

    //    Scenario: Verify Invalid Payer ID File message Identified by system in red color
    public void verifyUserAbleToChooseInvalid837FilesFromSystem() throws InterruptedException, AWTException {
        String basePath = System.getProperty("user.dir");
        String filePath = basePath + prop.getProperty("invalidPayerIdFilePath");
        uploadFileWithJavaScriptAndSendKeys(txtFileUpload, filePath);
        boolean uploadFileStatus = explicitVisibilityOfElementLocatedWaitByXpath(btnUploadFile, 10).isDisplayed();
        Assert.assertTrue(uploadFileStatus);
    }
    public void clickOnUploadFileButtonToUploadInvalidFiles() {
        explicitVisibilityOfElementLocatedWaitByXpath(btnUploadFile, 5).click();
    }
    public void validateInvalidPayerIdMessage() {
        String fileUploadInvalidMessageAct = explicitVisibilityOfElementLocatedWaitByXpath(msgFileUploadToaster, 10).getText();
        System.out.println("Invalid payer id file upload actual message is: " + fileUploadInvalidMessageAct);
        Assert.assertEquals(fileUploadInvalidMessageExp, fileUploadInvalidMessageAct);
    }

    //    Scenario: Verify user able to see Total File, File Name and Plan Received Date fields on upload files page
    public void verifyUserAbleToSeeColumnFieldsOnFileUploadPage(DataTable fileUploadColumnFields) {
        List<String> fileUploadColumnFieldsExp = fileUploadColumnFields.asList();
        List<String> fileUploadColumnFieldsAct = findElementsByXpath(lstFileUploadColumnFields)
                .stream().map(element -> element.getText().trim()).toList();
        System.out.println("File Upload column fields actual size: " + fileUploadColumnFieldsAct.size());
        System.out.println("File Upload column fields expected size: " + fileUploadColumnFieldsExp.size());
        System.out.println("File Upload actual column fields are: " + fileUploadColumnFieldsAct);
        System.out.println("File Upload expected column fields are: " + fileUploadColumnFieldsExp);
        Assert.assertEquals(fileUploadColumnFieldsExp, fileUploadColumnFieldsAct);
    }

    //    Scenario: Verify Plan Received Date field in total File Selected section
    public void verifyUserAbleToEnterCurrentPlanReceivedDate() throws Exception {
        String currentDate = explicitVisibilityOfElementLocatedWaitByXpath(txtPlanReceivedDate, 10).getAttribute("max");
        String currentDateAct = convertDateFromOneFormatToAnother("yyyy-MM-dd", "MM/dd/yyyy", currentDate);
        String currentDateExp = getCurrentDate("MM/dd/yyyy");
        System.out.println("UI actual current date is: " + currentDateAct);
        System.out.println("UI expected current date is: " + currentDateExp);
        Assert.assertEquals(currentDateExp, currentDateAct);
    }

    public void verifyUserAbleToEnterPastPlanReceivedDate() throws Exception
    {
        explicitVisibilityOfElementLocatedWaitByXpath(txtPlanReceivedDate, 10);
        clearUsingKeyClass(txtPlanReceivedDate);
        String pastDateExp = subtractDaysFromCurrentDateAndGetPastDate("MM/dd/yyyy", 10);
        findElementAndSendKeys(findElementByXpath(txtPlanReceivedDate), pastDateExp);
        String pastDate = findElementByXpath(txtPlanReceivedDate).getAttribute("ng-reflect-model");
        String pastDate1 = pastDate.substring(4, 15);
        String pastDateAct = convertDateFromOneFormatToAnother("MMM dd yyyy", "MM/dd/yyyy", pastDate1);
        System.out.println("UI actual past date is: " + pastDateAct);
        System.out.println("UI expected past date is: " + pastDateExp);
        Assert.assertEquals(pastDateExp, pastDateAct);
    }

    //    Scenario: verify user able to delete the selected file on file upload page
    public void verifyUserAbleToDeleteSelectedFileOnUploadFilesPage()
    {
        clickElement(btnDelete);
        boolean deleteStatus = isDisplayed(btnDelete);
        System.out.println("Delete button status is: " + deleteStatus);
        Assert.assertFalse(deleteStatus);
    }

    //    Scenario: verify user able to cancel the selected files on file upload page
    public void verifyUserAbleToCancelSelectedFilesOnUploadFilesPage()
    {
        clickElement(btnCancel);
        boolean cancelStatus = isDisplayed(btnCancel);
        System.out.println("Cancel button status is: " + cancelStatus);
        Assert.assertFalse(cancelStatus);
    }

}
