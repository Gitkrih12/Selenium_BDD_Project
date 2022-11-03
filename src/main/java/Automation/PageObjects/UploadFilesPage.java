package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.awt.*;
import java.util.List;

public class UploadFilesPage extends SeleniumUtils {

    String mnuFileManagement = "//div[contains(text(),'File Management')]";
    String mnuUploadFiles = "(//div[contains(text(), 'Upload Files')])[1]";
    String tabUploadFiles = "(//div[contains(text(), 'Upload Files')])[2]";
    String lblDragFiles = "//div[@class='drag']";
    String lblChooseFiles = "//a[@class='drag']";
    String txtFileUpload = "//input[@type='file']";
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

    private static String futurePlanReceivedDateAct;

    //    Scenario: Verify user navigates to Upload files section on clicking Upload Files in Left Navigation Menu
    public void clickOnUploadFiles() {
        clickElement(mnuFileManagement);
        moveToElement(mnuUploadFiles).perform();
        clickElement(mnuUploadFiles);
    }
    public void verifyUserIsOnUploadFilesTab(String uploadFilesTitleExp) {
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabUploadFiles), 10, uploadFilesTitleExp);
        String[] uploadFilesTitleText = getText(tabUploadFiles).split(" ");
        String uploadFilesTitleAct = uploadFilesTitleText[0] + " " + uploadFilesTitleText[1];
        System.out.println(ANSI_GREEN + "Upload files actual title is: " + uploadFilesTitleAct + ANSI_RESET);
        Assert.assertEquals(uploadFilesTitleExp, uploadFilesTitleAct);
    }

    public void verifyUserNavigatedToUploadFilesScreen(String uploadFilesExp) throws InterruptedException {
        String dragFilesText = explicitVisibilityOfElementLocatedWaitByXpath(lblDragFiles, 5).getText();
        String chooseFilesText = explicitVisibilityOfElementLocatedWaitByXpath(lblChooseFiles, 5).getText();
        String uploadFilesAct = dragFilesText + " " + chooseFilesText;
        System.out.println(ANSI_GREEN + "Actual message is: " + uploadFilesAct + ANSI_RESET);
        System.out.println(ANSI_GREEN + "Expected message is: " + uploadFilesExp + ANSI_RESET);
        Assert.assertEquals(uploadFilesExp, uploadFilesAct);
    }

    //    Scenario: Verify user should see Drag Files Here (or) Choose File option and able to upload file
    public void verifyUserAbleToChoose837FilesFromSystem() throws InterruptedException, AWTException {
        String filePath = basePath + prop.getProperty("uploadFilePath1");
        uploadFileWithJavaScriptAndSendKeys(txtFileUpload, filePath);
        boolean uploadFileStatus = explicitVisibilityOfElementLocatedWaitByXpath(btnUploadFile, 10).isDisplayed();
        Assert.assertTrue(uploadFileStatus);
    }

    //    Scenario: Verify Total File Selected section
    public void verifyUserAbleToChooseMultiple837FilesFromSystem() throws InterruptedException, AWTException {
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
        System.out.println(ANSI_GREEN + "Actual File records size: " + fileRecords.size() + ANSI_RESET);
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
        System.out.println(ANSI_GREEN + "UI plan received date is: " + text + ANSI_RESET);
    }
    public void clickOnUploadFileButton() {
        explicitVisibilityOfElementLocatedWaitByXpath(btnUploadFile, 5).click();
        String fileUploadToasterMessageAct = explicitVisibilityOfElementLocatedWaitByXpath(msgFileUploadToaster, 30).getText();
        System.out.println(ANSI_GREEN + "File upload actual message is: " + fileUploadToasterMessageAct + ANSI_RESET);
        Assert.assertEquals(fileUploadSuccessfulMessageExp, fileUploadToasterMessageAct);
    }

    //    Scenario: Verify Invalid Payer ID File message Identified by system in red color
    public void verifyUserAbleToChooseInvalid837FilesFromSystem() throws InterruptedException, AWTException {
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
        System.out.println(ANSI_GREEN + "Invalid payer id file upload actual message is: " + fileUploadInvalidMessageAct + ANSI_RESET);
        Assert.assertEquals(fileUploadInvalidMessageExp, fileUploadInvalidMessageAct);
    }

    //    Scenario: Verify user able to see Total File, File Name and Plan Received Date fields on upload files page
    public void verifyUserAbleToSeeColumnFieldsOnFileUploadPage(DataTable fileUploadColumnFields) {
        List<String> fileUploadColumnFieldsExp = fileUploadColumnFields.asList();
        List<String> fileUploadColumnFieldsAct = findElementsByXpath(lstFileUploadColumnFields)
                .stream().map(element -> element.getText().trim()).toList();
        System.out.println(ANSI_GREEN + "File Upload column fields actual size: " + fileUploadColumnFieldsAct.size() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "File Upload column fields expected size: " + fileUploadColumnFieldsExp.size() + ANSI_RESET);
        System.out.println(ANSI_GREEN + "File Upload actual column fields are: " + fileUploadColumnFieldsAct + ANSI_RESET);
        System.out.println(ANSI_GREEN + "File Upload expected column fields are: " + fileUploadColumnFieldsExp + ANSI_RESET);
        Assert.assertEquals(fileUploadColumnFieldsExp, fileUploadColumnFieldsAct);
    }

    //    Scenario: Verify Plan Received Date field in total File Selected section
    public void verifyUserAbleToEnterCurrentPlanReceivedDate() throws Exception {
        String currentDate = explicitVisibilityOfElementLocatedWaitByXpath(txtPlanReceivedDate, 10).getAttribute("max");
        String currentDateAct = convertDateFromOneFormatToAnother("yyyy-MM-dd", "MM/dd/yyyy", currentDate);
        String currentDateExp = getCurrentDate("MM/dd/yyyy");
        System.out.println(ANSI_GREEN + "UI actual current date is: " + currentDateAct + ANSI_RESET);
        System.out.println(ANSI_GREEN + "UI expected current date is: " + currentDateExp + ANSI_RESET);
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
        System.out.println(ANSI_GREEN + "UI actual past date is: " + pastDateAct + ANSI_RESET);
        System.out.println(ANSI_GREEN + "UI expected past date is: " + pastDateExp + ANSI_RESET);
        Assert.assertEquals(pastDateExp, pastDateAct);
    }

    //    Scenario: verify user able to delete the selected file on file upload page
    public void verifyUserAbleToDeleteSelectedFileOnUploadFilesPage()
    {
        clickElement(btnDelete);
        boolean deleteStatus = isDisplayed(btnDelete);
        System.out.println(ANSI_GREEN + "Delete button status is: " + deleteStatus + ANSI_RESET);
        Assert.assertFalse(deleteStatus);
    }

    //    Scenario: verify user able to cancel the selected files on file upload page
    public void verifyUserAbleToCancelSelectedFilesOnUploadFilesPage()
    {
        clickElement(btnCancel);
        boolean cancelStatus = isDisplayed(btnCancel);
        System.out.println(ANSI_GREEN + "Cancel button status is: " + cancelStatus + ANSI_RESET);
        Assert.assertFalse(cancelStatus);
    }

    //    Scenario: verify user should NOT be able to upload any file with future date
    public void enterFuturePlanReceivedDateOnFileUploadPage() throws Exception {
        String futureDate = addDaysToCurrentDateAndGetFutureDate("MM/dd/yyyy", 10);
        clearUsingKeyClass(txtPlanReceivedDate);
        findElementByXpath(txtPlanReceivedDate).sendKeys(futureDate);
        clickElement(btnUploadFile);
        futurePlanReceivedDateAct = explicitVisibilityOfElementLocatedWaitByXpath(msgFileUploadToaster, 30).getText();
        printStatementInGreenColor("Future plan received date error message actual", futurePlanReceivedDateAct);
    }
    public void verifyUserShouldNotBeAbleToUploadFilesWithFuturePlanReceivedDate(String futurePlanReceivedDateExp)
    {
        printStatementInGreenColor("Future plan received date error message expected", futurePlanReceivedDateExp);
        Assert.assertEquals(futurePlanReceivedDateExp, futurePlanReceivedDateAct);
    }

}
