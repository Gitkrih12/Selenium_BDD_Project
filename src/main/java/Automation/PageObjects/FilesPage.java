package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class FilesPage extends SeleniumUtils {

    //    Files tab locators
    String mnuFileManagement = "//div[contains(text(),'File Management')]";
    String mnuFiles = "(//div[normalize-space(text())='Files'])[1]";
    String tabFiles = "//div[contains(@class,'active-tab')]";

    //    837P Files tab locators
    String tab837PFiles = "//button[@aria-controls='nav-837p-details']";
    String lst837PColumnFieldNames = "//div[@id='nav-837p-details']//div[@ref='eLabel']//span[text()]";
    String lst837PColumnSearchFields = "//div[@id='nav-837p-details']//span[@class='ag-header-cell-text']//following::div[1]//input[@type='text']";
    String lst837PPageBar = "//div[@id='nav-837p-details']//span[@class='ag-paging-description']";
    String lst837PRecordsBar = "//div[@id='nav-837p-details']//span[@class='ag-paging-row-summary-panel']";
    String btn837PNext = "//div[@id='nav-837p-details']//span[@class='ag-icon ag-icon-next']";
    String btn837PPrevious = "//div[@id='nav-837p-details']//span[@class='ag-icon ag-icon-previous']";
    String lbl837PFileName = "//div[@id='nav-837p-details']//span[contains(text(),'File Name')]";
    String lst837PFileNameRecords = "//div[@id='nav-837p-details']//div[@col-id='fileName']//span[@class='ag-cell-value']";
    String lst837PSenderRecords = "//div[@id='nav-837p-details']//div[@col-id='sender']//span[@class='ag-cell-value']";
    String txt837PStatus = "//div[@id='nav-837p-details']//input[@aria-label='Status Filter Input']";
    String lbl837PStatusColor = "(//div[@id='nav-837p-details']//div[@col-id='status']//span[contains(@style,'color')])[1]";
    String lbl837PStatusType = "(//div[@id='nav-837p-details']//div[@col-id='status']//span[contains(@style,'Roboto')])[1]";
    String lbl837PSender = "//div[@id='nav-837p-details']//span[contains(text(),'Sender')]";
    String lst837PReceiverRecords = "//div[@id='nav-837p-details']//div[@col-id='receiver']//span[@class='ag-cell-value']";
    String lbl837PReceiver = "//div[@id='nav-837p-details']//span[contains(text(),'Receiver')]";
    String lst837PDateReceivedRecords = "//div[@id='nav-837p-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value']";
    String lst837PAgeDaysRecords = "//div[@id='nav-837p-details']//div[@col-id='ageInDays']//span[@class='ag-cell-value']";
    String lbl837PStatus = "//div[@id='nav-837p-details']//span[contains(text(),'Status')]";
    String lst837PStatusRecords = "//div[@id='nav-837p-details']//div[@col-id='status']//span[@class='ag-cell-value']//span[2]";
    String lbl837PFileType = "//div[@id='nav-837p-details']//span[contains(text(),'File Type')]";
    String lst837PFileTypeRecords = "//div[@id='nav-837p-details']//div[@col-id='fileType']//span[@class='ag-cell-value']";
    String txt837PDateReceived = "(//div[@col-id='dateReceived']//following::input[@aria-label='Date Received Filter Input'])[1]";
    String ele837PDateReceived = "(//div[@id='nav-837p-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value'])[1]";
    String lst837PControlNumberRecords = "//div[@id='nav-837p-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value']";
    String lbl837PControlNumber = "//div[@id='nav-837p-details']//span[contains(text(),'Control Number')]";
    String txt837PControlNumber = "(//div[@col-id='controlNumber']//following::input[@aria-label='Control Number Filter Input'])[1]";
    String ele837PControlNumber = "(//div[@class='ag-pinned-left-cols-container']//span[@class='ag-cell-value'])[1]";

    //    837I Files tab locators
    String tab837I = "//button[@aria-controls='nav-837i-details']";
    String lst837IColumnFieldNames = "//div[@id='nav-837i-details']//div[@ref='eLabel']//span[text()]";
    String lst837IColumnSearchFields = "//div[@id='nav-837i-details']//span[@class='ag-header-cell-text']//following::div[1]//input[@type='text']";
    String lst837IPageBar = "//div[@id='nav-837i-details']//span[@class='ag-paging-description']";
    String lst837IRecordsBar = "//div[@id='nav-837i-details']//span[@class='ag-paging-row-summary-panel']";
    String txt837IControlNumber = "(//div[@col-id='controlNumber']//following::input[@aria-label='Control Number Filter Input'])[2]";
    String ele837IControlNumber = "(//div[@id='nav-837i-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value'])[1]";
    String btn837INext = "//div[@id='nav-837i-details']//span[@class='ag-icon ag-icon-next']";
    String btn837IPrevious = "//div[@id='nav-837i-details']//span[@class='ag-icon ag-icon-previous']";
    String lbl837IStatusColor = "(//div[@id='nav-837i-details']//div[@col-id='status']//span[contains(@style,'color')])[1]";
    String lbl837IStatusType = "(//div[@id='nav-837i-details']//div[@col-id='status']//span[contains(@style,'Roboto')])[1]";
    String txt837IStatus = "//div[@id='nav-837i-details']//input[@aria-label='Status Filter Input']";
    String lbl837IFileName = "//div[@id='nav-837i-details']//span[contains(text(),'File Name')]";
    String lst837IFileNameRecords = "//div[@id='nav-837i-details']//div[@col-id='fileName']//span[@class='ag-cell-value']";
    String lbl837ISender = "//div[@id='nav-837i-details']//span[contains(text(),'Sender')]";
    String lst837ISenderRecords = "//div[@id='nav-837i-details']//div[@col-id='sender']//span[@class='ag-cell-value']";
    String lbl837IReceiver = "//div[@id='nav-837i-details']//span[contains(text(),'Receiver')]";
    String lst837IReceiverRecords = "//div[@id='nav-837i-details']//div[@col-id='receiver']//span[@class='ag-cell-value']";
    String lst837IDateReceivedRecords = "//div[@id='nav-837i-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value']";
    String txt837IDateReceived = "(//div[@col-id='dateReceived']//following::input[@aria-label='Date Received Filter Input'])[2]";
    String ele837IDateReceived = "(//div[@id='nav-837i-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value'])[1]";
    String lst837IAgeDaysRecords = "//div[@id='nav-837i-details']//div[@col-id='ageInDays']//span[@class='ag-cell-value']";
    String lbl837IStatus = "//div[@id='nav-837i-details']//span[contains(text(),'Status')]";
    String lst837IStatusRecords = "//div[@id='nav-837i-details']//div[@col-id='status']//span[@class='ag-cell-value']//span[2]";
    String lbl837IFileType = "//div[@id='nav-837i-details']//span[contains(text(),'File Type')]";
    String lst837IFileTypeRecords = "//div[@id='nav-837i-details']//div[@col-id='fileType']//span[@class='ag-cell-value']";
    String lst837IControlNumberRecords = "//div[@id='nav-837i-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value']";
    String lbl837IControlNumber = "//div[@id='nav-837i-details']//span[contains(text(),'Control Number')]";

    //    837D Files tab locators
    String tab837D = "//button[@aria-controls='nav-837d-details']";
    String lst837DColumnFieldNames = "//div[@id='nav-837d-details']//div[@ref='eLabel']//span[text()]";
    String lst837DColumnSearchFields = "//div[@id='nav-837d-details']//span[@class='ag-header-cell-text']//following::div[1]//input[@type='text']";
    String lst837DPageBar = "//div[@id='nav-837d-details']//span[@class='ag-paging-description']";
    String lst837DRecordsBar = "//div[@id='nav-837d-details']//span[@class='ag-paging-row-summary-panel']";
    String txt837DControlNumber = "(//div[@col-id='controlNumber']//following::input[@aria-label='Control Number Filter Input'])[3]";
    String ele837DControlNumber = "(//div[@id='nav-837d-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value'])[1]";
    String btn837DNext = "//div[@id='nav-837d-details']//span[@class='ag-icon ag-icon-next']";
    String btn837DPrevious = "//div[@id='nav-837d-details']//span[@class='ag-icon ag-icon-previous']";
    String lbl837DStatusColor = "(//div[@id='nav-837d-details']//div[@col-id='status']//span[contains(@style,'color')])[1]";
    String txt837DStatus = "//div[@id='nav-837d-details']//input[@aria-label='Status Filter Input']";
    String lbl837DFileName = "//div[@id='nav-837d-details']//span[contains(text(),'File Name')]";
    String lst837DFileNameRecords = "//div[@id='nav-837d-details']//div[@col-id='fileName']//span[@class='ag-cell-value']";
    String lbl837DSender = "//div[@id='nav-837d-details']//span[contains(text(),'Sender')]";
    String lst837DSenderRecords = "//div[@id='nav-837d-details']//div[@col-id='sender']//span[@class='ag-cell-value']";
    String lbl837DReceiver = "//div[@id='nav-837d-details']//span[contains(text(),'Receiver')]";
    String lst837DReceiverRecords = "//div[@id='nav-837d-details']//div[@col-id='receiver']//span[@class='ag-cell-value']";
    String lst837DDateReceivedRecords = "//div[@id='nav-837d-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value']";
    String txt837DDateReceived = "(//div[@col-id='dateReceived']//following::input[@aria-label='Date Received Filter Input'])[3]";
    String ele837DDateReceived = "(//div[@id='nav-837d-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value'])[1]";
    String lst837DAgeDaysRecords = "//div[@id='nav-837d-details']//div[@col-id='ageInDays']//span[@class='ag-cell-value']";
    String lbl837DStatus = "//div[@id='nav-837d-details']//span[contains(text(),'Status')]";
    String lst837DStatusRecords = "//div[@id='nav-837d-details']//div[@col-id='status']//span[@class='ag-cell-value']//span[2]";
    String lbl837DFileType = "//div[@id='nav-837d-details']//span[contains(text(),'File Type')]";
    String lst837DFileTypeRecords = "//div[@id='nav-837d-details']//div[@col-id='fileType']//span[@class='ag-cell-value']";
    String lst837DControlNumberRecords = "//div[@id='nav-837d-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value']";
    String lbl837DControlNumber = "//div[@id='nav-837d-details']//span[contains(text(),'Control Number')]";

    // 999 Files tab locators
    String tab999 = "//button[@aria-controls='nav-999-details']";
    String lst999ColumnFieldNames = "//div[@id='nav-999-details']//div[@ref='eLabel']//span[@ref='eText']";
    String lst999ColumnSearchFields = "//div[@id='nav-999-details']//span[@class='ag-header-cell-text']//following::div[1]//input[@type='text']";
    String lst999PageBar = "//div[@id='nav-999-details']//span[@class='ag-paging-description']";
    String lst999RecordsBar = "//div[@id='nav-999-details']//span[@class='ag-paging-row-summary-panel']";
    String txt999ControlNumber = "(//div[@col-id='controlNumber']//following::input[@aria-label='Control Number Filter Input'])[4]";
    String ele999ControlNumber = "(//div[@id='nav-999-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value'])[1]";
    String btn999Next = "//div[@id='nav-999-details']//span[@class='ag-icon ag-icon-next']";
    String btn999Previous = "//div[@id='nav-999-details']//span[@class='ag-icon ag-icon-previous']";
    String lbl999StatusColor = "(//div[@id='nav-999-details']//div[@col-id='status']//span[contains(@style,'color')])[1]";
    String lbl999StatusType = "(//div[@id='nav-999-details']//div[@col-id='status']//span[contains(@style,'Roboto')])[1]";
    String txt999Status = "//div[@id='nav-999-details']//input[@aria-label='Status Filter Input']";
    String lbl999FileName = "//div[@id='nav-999-details']//span[contains(text(),'File Name')]";
    String lst999FileNameRecords = "//div[@id='nav-999-details']//div[@col-id='fileName']//span[@class='ag-cell-value']";
    String lbl999Sender = "//div[@id='nav-999-details']//span[contains(text(),'Sender')]";
    String lst999SenderRecords = "//div[@id='nav-999-details']//div[@col-id='sender']//span[@class='ag-cell-value']";
    String lbl999Receiver = "//div[@id='nav-999-details']//span[contains(text(),'Receiver')]";
    String lst999ReceiverRecords = "//div[@id='nav-999-details']//div[@col-id='receiver']//span[@class='ag-cell-value']";
    String lst999DateOfCreationRecords = "//div[@id='nav-999-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value']";
    String txt999DateOfCreation = "(//div[@col-id='dateReceived']//following::input[@aria-label='Date of Creation Filter Input'])[1]";
    String ele999DateOfCreation = "(//div[@id='nav-999-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value'])[1]";
    String lst999AgeDaysRecords = "//div[@id='nav-999-details']//div[@col-id='ageInDays']//span[@class='ag-cell-value']";
    String lbl999Status = "//div[@id='nav-999-details']//span[contains(text(),'Status')]";
    String lst999StatusRecords = "//div[@id='nav-999-details']//div[@col-id='status']//span[@class='ag-cell-value']//span[2]";
    String lbl999ClaimType = "//div[@id='nav-999-details']//span[contains(text(),'Claim Type')]";
    String lst999ClaimTypeRecords = "//div[@id='nav-999-details']//div[@col-id='claimType']//span[@class='ag-cell-value']";
    String lst999ControlNumberRecords = "//div[@id='nav-999-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value']";
    String lbl999ControlNumber = "//div[@id='nav-999-details']//span[contains(text(),'Control Number')]";

    // 277CA Files tab locators
    String tab277CA = "//button[@aria-controls='nav-277ca-details']";
    String lst277CAColumnFieldNames = "//div[@id='nav-277ca-details']//div[@ref='eLabel']//span[@ref='eText']";
    String lst277CAColumnSearchFields = "//div[@id='nav-277ca-details']//span[@class='ag-header-cell-text']//following::div[1]//input[@type='text']";
    String lst277CAPageBar = "//div[@id='nav-277ca-details']//span[@class='ag-paging-description']";
    String lst277CARecordsBar = "//div[@id='nav-277ca-details']//span[@class='ag-paging-row-summary-panel']";
    String txt277CAControlNumber = "(//div[@col-id='controlNumber']//following::input[@aria-label='Control Number Filter Input'])[5]";
    String ele277CAControlNumber = "(//div[@id='nav-277ca-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value'])[1]";
    String btn277CANext = "//div[@id='nav-277ca-details']//span[@class='ag-icon ag-icon-next']";
    String btn277CAPrevious = "//div[@id='nav-277ca-details']//span[@class='ag-icon ag-icon-previous']";
    String lbl277CAStatusColor = "(//div[@id='nav-277ca-details']//div[@col-id='status']//span[contains(@style,'color')])[1]";
    String lbl277CAStatusType = "(//div[@id='nav-277ca-details']//div[@col-id='status']//span[contains(@style,'Roboto')])[1]";
    String txt277CAStatus = "//div[@id='nav-277ca-details']//input[@aria-label='Status Filter Input']";
    String lbl277CAFileName = "//div[@id='nav-277ca-details']//span[contains(text(),'File Name')]";
    String lst277CAFileNameRecords = "//div[@id='nav-277ca-details']//div[@col-id='fileName']//span[@class='ag-cell-value']";
    String lbl277CASender = "//div[@id='nav-277ca-details']//span[contains(text(),'Sender')]";
    String lst277CASenderRecords = "//div[@id='nav-277ca-details']//div[@col-id='sender']//span[@class='ag-cell-value']";
    String lbl277CAReceiver = "//div[@id='nav-277ca-details']//span[contains(text(),'Receiver')]";
    String lst277CAReceiverRecords = "//div[@id='nav-277ca-details']//div[@col-id='receiver']//span[@class='ag-cell-value']";
    String lst277CADateOfCreationRecords = "//div[@id='nav-277ca-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value']";
    String txt277CADateOfCreation = "(//div[@col-id='dateReceived']//following::input[@aria-label='Date Of Creation Filter Input'])[1]";
    String ele277CADateOfCreation = "(//div[@id='nav-277ca-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value'])[1]";
    String lst277CAAgeDaysRecords = "//div[@id='nav-277ca-details']//div[@col-id='ageInDays']//span[@class='ag-cell-value']";
    String lbl277CAStatus = "//div[@id='nav-277ca-details']//span[contains(text(),'Status')]";
    String lst277CAStatusRecords = "//div[@id='nav-277ca-details']//div[@col-id='status']//span[@class='ag-cell-value']//span[2]";
    String lbl277CAClaimType = "//div[@id='nav-277ca-details']//span[contains(text(),'Claim Type')]";
    String lst277CAClaimTypeRecords = "//div[@id='nav-277ca-details']//div[@col-id='claimType']//span[@class='ag-cell-value']";
    String lst277CAControlNumberRecords = "//div[@id='nav-277ca-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value']";
    String lbl277CAControlNumber = "//div[@id='nav-277ca-details']//span[contains(text(),'Control Number')]";

    // 277CA Files tab locators
    String tab835 = "//button[@aria-controls='nav-835-details']";
    String lst835ColumnFieldNames = "//div[@id='nav-835-details']//div[@ref='eLabel']//span[@ref='eText']";
    String lst835ColumnSearchFields = "//div[@id='nav-835-details']//span[@class='ag-header-cell-text']//following::div[1]//input[@type='text']";
    String lst835PageBar = "//div[@id='nav-835-details']//span[@class='ag-paging-description']";
    String lst835RecordsBar = "//div[@id='nav-835-details']//span[@class='ag-paging-row-summary-panel']";
    String txt835ControlNumber = "(//div[@col-id='controlNumber']//following::input[@aria-label='Control Number Filter Input'])[6]";
    String ele835ControlNumber = "(//div[@id='nav-835-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value'])[1]";
    String lbl835ChequeDate = "//div[@id='nav-835-details']//span[contains(text(),'Cheque Date')]";
    String lst835ChequeDateRecords = "//div[@id='nav-835-details']//div[@col-id='chequeIssueDate']//span[@class='ag-cell-value']";
    String btn835Next = "//div[@id='nav-835-details']//span[@class='ag-icon ag-icon-next']";
    String btn835Previous = "//div[@id='nav-835-details']//span[@class='ag-icon ag-icon-previous']";
    String lbl835StatusColor = "(//div[@id='nav-835-details']//div[@col-id='status']//span[contains(@style,'color')])[1]";
    String lbl835StatusType = "(//div[@id='nav-835-details']//div[@col-id='status']//span[contains(@style,'Roboto')])[1]";
    String txt835Status = "//div[@id='nav-835-details']//input[@aria-label='Status Filter Input']";
    String lbl835FileName = "//div[@id='nav-835-details']//span[contains(text(),'File Name')]";
    String lst835FileNameRecords = "//div[@id='nav-835-details']//div[@col-id='fileName']//span[@class='ag-cell-value']";
    String lbl835Sender = "//div[@id='nav-835-details']//span[contains(text(),'Sender')]";
    String lst835SenderRecords = "//div[@id='nav-835-details']//div[@col-id='sender']//span[@class='ag-cell-value']";
    String lbl835Receiver = "//div[@id='nav-835-details']//span[contains(text(),'Receiver')]";
    String lst835ReceiverRecords = "//div[@id='nav-835-details']//div[@col-id='receiver']//span[@class='ag-cell-value']";
    String lst835DateOfCreationRecords = "//div[@id='nav-835-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value']";
    String txt835DateOfCreation = "(//div[@col-id='dateReceived']//following::input[@aria-label='Date of Creation Filter Input'])[2]";
    String ele835DateOfCreation = "(//div[@id='nav-835-details']//div[@col-id='dateReceived']//span[@class='ag-cell-value'])[1]";
    String lst835AgeDaysRecords = "//div[@id='nav-835-details']//div[@col-id='ageInDays']//span[@class='ag-cell-value']";
    String lbl835Status = "//div[@id='nav-835-details']//span[contains(text(),'Status')]";
    String lst835StatusRecords = "//div[@id='nav-835-details']//div[@col-id='status']//span[@class='ag-cell-value']//span[2]";
    String lbl835Transaction = "//div[@id='nav-835-details']//span[contains(text(),'Transaction')]";
    String lst835TransactionRecords = "//div[@id='nav-835-details']//div[@col-id='transaction']//span[@class='ag-cell-value']";
    String lst835ControlNumberRecords = "//div[@id='nav-835-details']//div[@col-id='controlNumber']//span[@class='ag-cell-value']";
    String lbl835ControlNumber = "//div[@id='nav-835-details']//span[contains(text(),'Control Number')]";

    private static String controlNumber837PSortExp;
    private static ArrayList<String> fileNameRecords837P;
    private static ArrayList<String> senderRecords837P;
    private static ArrayList<String> receiverRecords837P;
    private static ArrayList<String> dateReceivedRecords837PBeforeSort;
    private static ArrayList<String> dateReceivedRecords837PAfterSort;
    private static ArrayList<String> ageDaysRecords837P;
    private static ArrayList<String> ageDaysRecords837PAfterSort;
    private static ArrayList<String> statusRecords837P;
    private static ArrayList<String> fileTypeRecords837P;
    private static String receivedDate837PSortExp;
    private static ArrayList<String> controlNumberRecords837P;


    //    Scenario: Verify column fields in '837P Files' tab
    public void verifyUserIsOnFilesTab(String filesTabTextExp) throws InterruptedException {
        clickElement(mnuFileManagement);
        explicitElementClickableWaitByXpath(mnuFiles, 10).click();
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabFiles), 10, "Files");
        String[] filesTabText = getText(tabFiles).split(" ");
        String filesTabTextAct = filesTabText[0];
        System.out.println("Actual files tab text is: " + filesTabTextAct);
        System.out.println("Expected files tab text is: " + filesTabTextExp);
        Assert.assertEquals(filesTabTextExp, filesTabTextAct);
    }

    public void clickOn837PFilesTab() throws InterruptedException {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tab837PFiles), 40, "837P Files() ");
        explicitElementClickableWaitByXpath(tab837PFiles, 10);
        moveToElement(tab837PFiles).click().perform();
    }

    public void verifyUserAbleToSee837PColumnFields(DataTable fieldsList837P) throws InterruptedException {
        explicitElementClickableWaitByXpath(lst837PColumnFieldNames, 10);
        scrollToElementsAndCompare2Lists(fieldsList837P, lst837PColumnFieldNames);
    }

    public void verifyUserAbleToView837PColumnFieldsSearchBoxes() {
        scrollToElementsAndValidateDisplayStatus(lst837PColumnSearchFields);
    }

    //    Scenario: Verify user should be able to see the results of rows count next to the "837P Files" tab
    public void validateRowCountNextTo837PFilesTab() throws InterruptedException {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tab837PFiles), 60, "837P Files() ");
        validateRowCountNextToFilesTab(tab837PFiles, lst837PRecordsBar);
    }

    //    Scenario: Validate pagination functionality in '837P Files' tab
    public void applyFilterToControlNumberFieldOn837PFilesTab() throws InterruptedException {
        if (Objects.equals(environment, "test")) {
            String paginationControlNumber837PExp = prop.getProperty("837PPaginationControlNumber");
            explicitElementClickableWaitByXpath(txt837PControlNumber, 5).sendKeys(paginationControlNumber837PExp);
            explicitTextToBePresentInElementLocatedWait(By.xpath(ele837PControlNumber), 20, paginationControlNumber837PExp);
            String paginationControlNumber837PAct = explicitElementClickableWaitByXpath(ele837PControlNumber, 5).getText();
            System.out.println("837P control line is: " + paginationControlNumber837PAct);
            Assert.assertEquals(paginationControlNumber837PExp, paginationControlNumber837PAct);
        }
    }

    public void validateTheDataExceedsTheDefinedPageSizeUnder837PFilesTab() {
        validateTheDataExceedsTheDefinedPageSize(lst837PRecordsBar);
    }

    public void verify837PForwardNavigationThroughPages() {
        verifyForwardNavigationThroughPages(btn837PNext, lst837PPageBar);
    }

    public void verify837PBackwardNavigationThroughPages() {
        verifyBackwardNavigationThroughPages(btn837PPrevious, lst837PPageBar);
    }

    public void verify837PForwardNavigationPageSizeAtTheBottomOfTheGrid() {
        verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(btn837PNext, lst837PRecordsBar);
    }

    public void verify837PBackwardNavigationPageSizeAtTheBottomOfTheGrid() {
        verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(btn837PPrevious, lst837PRecordsBar);
    }

    public void verify837PTotalNumberOfPagesBasedOnThePerPageRecordCount() {
        verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(lst837PRecordsBar, lst837PPageBar);
    }

    //Generic method to validate the data exceeds the defined page size 50
    public String[] validateTheDataExceedsTheDefinedPageSize(String recordsBarXpath) {
        int totalRowsExp= 0;
        String[] paginationRecordsExp = explicitElementClickableWaitByXpath(recordsBarXpath, 5).getText().split(" ");
        if(paginationRecordsExp[4].contains(","))
        {
            String totalRowsString = paginationRecordsExp[4].replace(",", "");
            totalRowsExp = Integer.parseInt(totalRowsString);
        }
        else
        {
            totalRowsExp = Integer.parseInt(paginationRecordsExp[4]);
        }
        System.out.println("total row count is: " + totalRowsExp);
        if (totalRowsExp > 50) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Data has not exceeded the defined page size");
        }
        return paginationRecordsExp;
    }

    //Generic method to verify forward navigation through pages
    public String[] verifyForwardNavigationThroughPages(String nextButtonXpath, String pageBarXpath) {
        String[] paginationPagesExp = new String[0];
        try {
            scrollToElement(nextButtonXpath);
            clickElement(nextButtonXpath);
            paginationPagesExp = explicitElementClickableWaitByXpath(pageBarXpath, 5).getText().split(" ");
            System.out.println("Forward navigation page : " + paginationPagesExp[1]);
            if (Integer.parseInt(paginationPagesExp[1]) > 1) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("User not able to navigate through pages");
            }
        } catch (Exception e) {
            Assert.fail("User not able to navigate through pages");
        }
        return paginationPagesExp;
    }

    //Generic method to verify forward navigation through pages
    public String[] verifyBackwardNavigationThroughPages(String previousButtonXpath, String pageBarXpath) {
        String[] paginationPagesExp = new String[0];
        try {
            scrollToElement(previousButtonXpath);
            clickElement(previousButtonXpath);
            paginationPagesExp = explicitElementClickableWaitByXpath(pageBarXpath, 10).getText().split(" ");
            System.out.println("Backward navigation page: " + paginationPagesExp[1]);
            Assert.assertEquals(1, Integer.parseInt(paginationPagesExp[1]));
        } catch (Exception e) {
            Assert.fail("User not able to navigate through pages");
        }
        return paginationPagesExp;
    }

    //Generic method to verify forward navigation through pages
    public String[] verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(String nextButtonXpath, String recordsBarXpath) {
        String[] paginationRecordsExp = new String[0];
        try {
            scrollToElement(nextButtonXpath);
            clickElement(nextButtonXpath);
            paginationRecordsExp = explicitElementClickableWaitByXpath(recordsBarXpath, 10).getText().split(" ");
            System.out.println("Forward navigation page size: " + paginationRecordsExp[0]);
            if (Integer.parseInt(paginationRecordsExp[0]) > 50) {
                Assert.assertTrue(true);
            } else {
                Assert.fail("Page size is not correct through forward navigation");
            }
        } catch (Exception e) {
            Assert.fail("Page size is not correct through forward navigation");
        }
        return paginationRecordsExp;
    }

    //Generic method to verify backward navigation through pages
    public String[] verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(String previousButtonXpath, String recordsBarXpath) {
        String[] paginationRecordsExp = new String[0];
        try {
            scrollToElement(previousButtonXpath);
            clickElement(previousButtonXpath);
            paginationRecordsExp = explicitElementClickableWaitByXpath(recordsBarXpath, 10).getText().split(" ");
            System.out.println("Backward navigation page size: " + paginationRecordsExp[0]);
            Assert.assertEquals(1, Integer.parseInt(paginationRecordsExp[0]));
        } catch (Exception e) {
            Assert.fail("Page size is not correct through backward navigation");
        }
        return paginationRecordsExp;
    }

    //Generic method to verify total number of pages based on the record count per page
    public void verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(String recordsBarXpath, String pageBarXpath) {
        String[] paginationRecordsExp = explicitElementClickableWaitByXpath(recordsBarXpath, 10).getText().split(" ");
        String[] paginationPagesExp = explicitElementClickableWaitByXpath(pageBarXpath, 10).getText().split(" ");

        String totalRowsExp=null;
        if(paginationRecordsExp[4].contains(","))
        {
            totalRowsExp = paginationRecordsExp[4].replace(",", "");
        }
        else
        {
            totalRowsExp = paginationRecordsExp[4];
        }
        double pageCount = Math.ceil(Double.parseDouble(totalRowsExp) / 50);
        int pageCountAct = (int) pageCount;
        System.out.println("Actual page count: " + pageCountAct);
        System.out.println("Expected page count: " + paginationPagesExp[3]);
        Assert.assertEquals(Integer.parseInt(paginationPagesExp[3]), pageCountAct);
    }

    //Generic method to verify row count next to 837P, 837I, 837D, 999, 277CA and 835
    public void validateRowCountNextToFilesTab(String fileTabXpath, String recordsBarXpath) throws InterruptedException {
        String recordsBarText = explicitElementClickableWaitByXpath(fileTabXpath, 5).getText();
        String rowCountAct = recordsBarText.substring(recordsBarText.indexOf("(") + 1, recordsBarText.indexOf(")"));
        printStatementInGreenColor("Actual row count is" , rowCountAct);
        scrollToElement(recordsBarXpath);
        String[] records = explicitElementClickableWaitByXpath(recordsBarXpath, 5).getText().split(" ");
        String rowCountExp;
        if(records[4].contains(","))
        {
            rowCountExp = records[4].replace(",", "");
        }
        else
        {
            rowCountExp = records[4];
        }
        printStatementInGreenColor("Expected row count is" , rowCountExp);
        Assert.assertEquals(rowCountExp, rowCountAct);
    }


    //    Scenario: Verify color code for Status View under '837P Files' tab
    public void verify837PStatusViewColorCoding(String status, String colorCode837PExp) throws InterruptedException {
        explicitElementClickableWaitByXpath(txt837PStatus, 5).sendKeys(status);
        explicitTextToBePresentInElementLocatedWait(By.xpath(lbl837PStatusType), 10, status);
        String colorCode837PAct = getColorCodeForBackground(lbl837PStatusColor);
        System.out.println("837P color code status is: " + colorCode837PAct);
        Assert.assertEquals(colorCode837PExp, colorCode837PAct);
    }

    //    Scenario: Verify Sorting functionality for "File Name" column under "837P Files" tab
    public void enter837PControlNumberUnderSearchField() throws InterruptedException {
        controlNumber837PSortExp = prop.getProperty("837PSortControlNumber");
        explicitElementClickableWaitByXpath(txt837PControlNumber, 10).sendKeys(controlNumber837PSortExp);
    }

    public void verify837PControlNumbersForGivenRecord() throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(ele837PControlNumber), 10, controlNumber837PSortExp);
        String controlNumber837PSortAct = explicitElementClickableWaitByXpath(ele837PControlNumber, 5).getText();
        System.out.println("837P control number is: " + controlNumber837PSortAct);
        Assert.assertEquals(controlNumber837PSortExp, controlNumber837PSortAct);
    }

    public void get837PFileNameRecordsBeforeSort() {
        fileNameRecords837P = getAllElementsToArrayList(lst837PFileNameRecords);
        System.out.println("837P file name records before sort: " + fileNameRecords837P);
        Collections.sort(fileNameRecords837P);
        System.out.println("837P file name records after sort: " + fileNameRecords837P);
    }

    public void clickOn837PFileNameColumn() throws InterruptedException {
        clickElement(lbl837PFileName);
    }

    public void verify837PFileNameColumnRecordsInAscendingOrder() {
        ArrayList<String> fileNameRecords837PAfterSort = getAllElementsToArrayList(lst837PFileNameRecords);
        System.out.println("837P file name records before sort: " + fileNameRecords837PAfterSort);
        Collections.sort(fileNameRecords837PAfterSort);
        System.out.println("837P file name records after sort: " + fileNameRecords837PAfterSort);
        if (fileNameRecords837P.equals(fileNameRecords837PAfterSort)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("837P file name records are not in sorted order");
        }
    }

    //  Scenario: Verify Sorting functionality for "Sender" column under "837P Files" tab
    public void get837PSenderRecordsBeforeSort() {
        senderRecords837P = getAllElementsToArrayList(lst837PSenderRecords);
        System.out.println("837P sender records before sort: " + senderRecords837P);
        Collections.sort(senderRecords837P);
        System.out.println("837P sender records after sort: " + senderRecords837P);
    }

    public void clickOn837PSenderColumn() throws InterruptedException {
        clickElement(lbl837PSender);
    }

    public void verify837PSenderColumnRecordsInAscendingOrder() {
        ArrayList<String> senderRecords837PAfterSort = getAllElementsToArrayList(lst837PSenderRecords);
        System.out.println("837P sender records before sort: " + senderRecords837PAfterSort);
        Collections.sort(senderRecords837PAfterSort);
        System.out.println("837P sender records after sort: " + senderRecords837PAfterSort);
        if (senderRecords837P.equals(senderRecords837PAfterSort)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("837P sender records are not in sorted order");
        }
    }

    //  Scenario: Verify Sorting functionality for "Receiver" column under "837P Files" tab
    public void get837PReceiverRecordsBeforeSort() {
        receiverRecords837P = getAllElementsToArrayList(lst837PReceiverRecords);
        System.out.println("837P receiver records before sort: " + receiverRecords837P);
        Collections.sort(receiverRecords837P);
        System.out.println("837P receiver records after sort: " + receiverRecords837P);
    }

    public void clickOn837PReceiverColumn() {
        clickElement(lbl837PReceiver);
    }

    public void verify837PReceiverColumnRecordsInAscendingOrder() {
        ArrayList<String> receiverRecords837PAfterSort = getAllElementsToArrayList(lst837PReceiverRecords);
        System.out.println("837P receiver records before sort: " + receiverRecords837PAfterSort);
        Collections.sort(receiverRecords837PAfterSort);
        System.out.println("837P receiver records after sort: " + receiverRecords837PAfterSort);
        if (receiverRecords837P.equals(receiverRecords837PAfterSort)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("837P receiver records are not in sorted order");
        }
    }

    //  Scenario: Verify Sorting functionality for "Date received" column under "837P Files" tab
    public void get837PDateReceivedRecordsBeforeSort() {
        dateReceivedRecords837PBeforeSort = getAllElementsToArrayList(lst837PDateReceivedRecords);
        dateReceivedRecords837PAfterSort = getAllElementsToArrayList(lst837PDateReceivedRecords);
        System.out.println("837P date received records before sort: " + dateReceivedRecords837PBeforeSort);
    }

    public void verify837PDateReceivedColumnRecordsInDescendingOrder() {
        Collections.sort(dateReceivedRecords837PAfterSort, Collections.reverseOrder());
        System.out.println("837P date received records after sort: " + dateReceivedRecords837PAfterSort);
        if (dateReceivedRecords837PBeforeSort.equals(dateReceivedRecords837PAfterSort)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("837P date received records are not in sorted order");
        }
    }

    //  Scenario: Verify Sorting functionality for "Age(Days)" column under "837P Files" tab
    public void get837PAgeDaysRecordsBeforeSort() {
        ageDaysRecords837P = getAllElementsToArrayList(lst837PAgeDaysRecords);
        ageDaysRecords837PAfterSort = getAllElementsToArrayList(lst837PAgeDaysRecords);
        System.out.println("837P age(Days) records before sort: " + ageDaysRecords837P);
    }

    public void verify837PAgeDaysColumnRecordsInAscendingOrder() {
        Collections.sort(ageDaysRecords837PAfterSort);
        System.out.println("837P age(Days) records after sort: " + ageDaysRecords837PAfterSort);
        if (ageDaysRecords837P.equals(ageDaysRecords837PAfterSort)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("837P age(Days) records are not in sorted order");
        }
    }

    //  Scenario: Verify Sorting functionality for "Status" column under "837P Files" tab
    public void get837PStatusRecordsBeforeSort() {
        statusRecords837P = getAllElementsToArrayList(lst837PStatusRecords);
        System.out.println("837P status records before sort: " + statusRecords837P);
        Collections.sort(statusRecords837P);
        System.out.println("837P status records after sort: " + statusRecords837P);
    }

    public void clickOn837PStatusColumn() {
        clickElement(lbl837PStatus);
    }

    public void verify837PStatusColumnRecordsInAscendingOrder() {
        ArrayList<String> statusRecords837PAfterSort = getAllElementsToArrayList(lst837PStatusRecords);
        System.out.println("837P status records before sort: " + statusRecords837PAfterSort);
        Collections.sort(statusRecords837PAfterSort);
        System.out.println("837P status records after sort: " + statusRecords837PAfterSort);
        if (statusRecords837P.equals(statusRecords837PAfterSort)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("837P status records are not in sorted order");
        }
    }

    //  Scenario: Verify Sorting functionality for "File Type" column under "837P Files" tab
    public void get837PFileTypeRecordsBeforeSort() {
        fileTypeRecords837P = scrollAndGetAllElementsToArrayList(lst837PFileTypeRecords);
        System.out.println("837P file type records before sort: " + fileTypeRecords837P);
        Collections.sort(fileTypeRecords837P);
        System.out.println("837P file type records after sort: " + fileTypeRecords837P);
    }

    public void clickOn837PFileTypeColumn() {
        scrollToElement(lbl837PFileType);
        clickElement(lbl837PFileType);
    }

    public void verify837PFileTypeColumnRecordsInAscendingOrder() {
        ArrayList<String> fileTypeRecords837PAfterSort = scrollAndGetAllElementsToArrayList(lst837PFileTypeRecords);
        System.out.println("837P file type records before sort: " + fileTypeRecords837PAfterSort);
        Collections.sort(fileTypeRecords837PAfterSort);
        System.out.println("837P file type records after sort: " + fileTypeRecords837PAfterSort);
        if (fileTypeRecords837P.equals(fileTypeRecords837PAfterSort)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("837P file type records are not in sorted order");
        }
    }

    //    Scenario: Verify Sorting functionality for "Control Number" column under "837P Files" tab
    public void enter837PReceivedDateUnderSearchField() throws InterruptedException {
        receivedDate837PSortExp = prop.getProperty("837PSortDate");
        explicitElementClickableWaitByXpath(txt837PDateReceived, 10);
        findElementWithXpathAndsendKeys(txt837PDateReceived, receivedDate837PSortExp);
    }

    public void verifyUserAbleToView837PReceivedDates() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(ele837PDateReceived), 10, receivedDate837PSortExp);
        String receivedDate837PSortAct = explicitElementClickableWaitByXpath(ele837PDateReceived, 10).getText();
        System.out.println("837P received date is: " + receivedDate837PSortAct);
        Assert.assertEquals(receivedDate837PSortExp, receivedDate837PSortAct);
    }

    public void get837PControlNumberRecordsBeforeSort() {
        controlNumberRecords837P = getAllElementsToArrayList(lst837PControlNumberRecords);
        System.out.println("837P control number records before sort: " + controlNumberRecords837P);
        Collections.sort(controlNumberRecords837P);
        System.out.println("837P control number records after sort: " + controlNumberRecords837P);
    }

    public void clickOn837PControlNumberColumn() throws InterruptedException {
        clickElement(lbl837PControlNumber);
    }

    public void verify837PControlNumberColumnRecordsInAscendingOrder() {
        ArrayList<String> controlNumberRecords837PAfterSort = getAllElementsToArrayList(lst837PControlNumberRecords);
        System.out.println("837P control number records before sort: " + controlNumberRecords837PAfterSort);
        Collections.sort(controlNumberRecords837PAfterSort);
        System.out.println("837P control number records after sort: " + controlNumberRecords837PAfterSort);
        if (controlNumberRecords837P.equals(controlNumberRecords837PAfterSort)) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("837P control number records are not in sorted order");
        }
    }

    //    Scenario: Verify column fields in '837I Files' tab
    public void clickOn837IFilesTab() throws InterruptedException {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tab837I), 60, "837I() ");
        explicitElementClickableWaitByXpath(tab837I, 5);
        moveToElement(tab837I).click().perform();
    }

    public void verifyUserAbleToSee837IColumnFields(DataTable fieldsList837I) throws InterruptedException {
        explicitElementClickableWaitByXpath(lst837IColumnFieldNames, 10);
        scrollToElementsAndCompare2Lists(fieldsList837I, lst837IColumnFieldNames);
    }

    public void verifyUserAbleToView837IColumnFieldsSearchBoxes() {
        scrollToElementsAndValidateDisplayStatus(lst837IColumnSearchFields);
    }

    //    Scenario: Validate pagination functionality in '837I Files' tab
    public void applyFilterToControlNumberFieldOn837IFilesTab() throws InterruptedException {
        if (Objects.equals(environment, "test")) {
            String paginationControlNumber837IExp = prop.getProperty("837IPaginationControlNumber");
            explicitElementClickableWaitByXpath(txt837IControlNumber, 5).sendKeys(paginationControlNumber837IExp);
            explicitTextToBePresentInElementLocatedWait(By.xpath(ele837IControlNumber), 10, paginationControlNumber837IExp);
            String paginationControlNumber837IAct = explicitElementClickableWaitByXpath(ele837IControlNumber, 5).getText();
            System.out.println("837I control line is: " + paginationControlNumber837IAct);
            Assert.assertEquals(paginationControlNumber837IExp, paginationControlNumber837IAct);
        }
    }

    public void validateTheDataExceedsTheDefinedPageSizeUnder837IFilesTab() {
        validateTheDataExceedsTheDefinedPageSize(lst837IRecordsBar);
    }

    public void verify837IForwardNavigationThroughPages() {
        verifyForwardNavigationThroughPages(btn837INext, lst837IPageBar);
    }

    public void verify837IBackwardNavigationThroughPages() {
        verifyBackwardNavigationThroughPages(btn837IPrevious, lst837IPageBar);
    }

    public void verify837IForwardNavigationPageSizeAtTheBottomOfTheGrid() {
        verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(btn837INext, lst837IRecordsBar);
    }

    public void verify837IBackwardNavigationPageSizeAtTheBottomOfTheGrid() {
        verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(btn837IPrevious, lst837IRecordsBar);
    }

    public void verify837ITotalNumberOfPagesBasedOnThePerPageRecordCount() {
        verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(lst837IRecordsBar, lst837IPageBar);
    }

    //    Scenario: Verify color code for Status View
    public void verify837IStatusViewColorCoding(String status, String colorCode837IExp) throws InterruptedException {
        explicitElementClickableWaitByXpath(txt837IStatus, 5).sendKeys(status);
        explicitTextToBePresentInElementLocatedWait(By.xpath(lbl837IStatusType), 10, status);
        String colorCode837IAct = getColorCodeForBackground(lbl837IStatusColor);
        System.out.println("837I color code status is: " + colorCode837IAct);
        Assert.assertEquals(colorCode837IExp, colorCode837IAct);
    }

    //    Scenario: Verify column fields in '837D Files' tab
    public void clickOn837DFilesTab() throws InterruptedException {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tab837D), 60, "837D()");
        explicitElementClickableWaitByXpath(tab837D, 5);
        moveToElement(tab837D).click().perform();
    }

    public void verifyUserAbleToSee837DColumnFields(DataTable fieldsList837D) throws InterruptedException {
        explicitElementClickableWaitByXpath(lst837DColumnFieldNames, 10);
        scrollToElementsAndCompare2Lists(fieldsList837D, lst837DColumnFieldNames);
    }
    public void verifyUserAbleToView837DColumnFieldsSearchBoxes() {
        scrollToElementsAndValidateDisplayStatus(lst837DColumnSearchFields);
    }

    //    Scenario: Verify column fields in '999' tab
    public void clickOn999FilesTab() throws InterruptedException {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tab999), 60, "999()");
        explicitElementClickableWaitByXpath(tab999, 5);
        moveToElement(tab999).click().perform();
    }

    public void verifyUserAbleToSee999ColumnFields(DataTable fieldsList999) throws InterruptedException {
        explicitElementClickableWaitByXpath(lst999ColumnFieldNames, 10);
        scrollToElementsAndCompare2Lists(fieldsList999, lst999ColumnFieldNames);
    }

    public void verifyUserAbleToView999ColumnFieldsSearchBoxes() {
        scrollToElementsAndValidateDisplayStatus(lst999ColumnSearchFields);
    }

    //    Scenario: Validate pagination functionality in '999 Files' tab
    public void validateTheDataExceedsTheDefinedPageSizeUnder999FilesTab() {
        validateTheDataExceedsTheDefinedPageSize(lst999RecordsBar);
    }

    public void verify999ForwardNavigationThroughPages() {
        verifyForwardNavigationThroughPages(btn999Next, lst999PageBar);
    }

    public void verify999BackwardNavigationThroughPages() {
        verifyBackwardNavigationThroughPages(btn999Previous, lst999PageBar);
    }

    public void verify999ForwardNavigationPageSizeAtTheBottomOfTheGrid() {
        verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(btn999Next, lst999RecordsBar);
    }

    public void verify999BackwardNavigationPageSizeAtTheBottomOfTheGrid() {
        verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(btn999Previous, lst999RecordsBar);
    }

    public void verify999TotalNumberOfPagesBasedOnThePerPageRecordCount() {
        verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(lst999RecordsBar, lst999PageBar);
    }

    //    Scenario Outline: Verify color code for Status View under 999 files tab
    public void verify999StatusViewColorCoding(String status, String colorCode999Exp) throws InterruptedException {
        explicitElementClickableWaitByXpath(txt999Status, 5).sendKeys(status);
        explicitTextToBePresentInElementLocatedWait(By.xpath(lbl999StatusType), 10, status);
        String colorCode999Act = getColorCodeForBackground(lbl999StatusColor);
        System.out.println("999 color code status is: " + colorCode999Act);
        Assert.assertEquals(colorCode999Exp, colorCode999Act);
    }

    //    Scenario: Verify column fields in '277CA' tab
    public void clickOn277CAFilesTab() throws InterruptedException {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tab277CA), 60, "277CA () ");
        explicitElementClickableWaitByXpath(tab277CA, 5).click();
    }

    public void verifyUserAbleToSee277CAColumnFields(DataTable fieldsList277CA) throws InterruptedException {
        explicitElementClickableWaitByXpath(lst277CAColumnFieldNames, 10);
        scrollToElementsAndCompare2Lists(fieldsList277CA, lst277CAColumnFieldNames);
    }

    public void verifyUserAbleToView277CAColumnFieldsSearchBoxes() {
        scrollToElementsAndValidateDisplayStatus(lst277CAColumnSearchFields);
    }

    //    Scenario: Validate pagination functionality in '277CA Files' tab
    public void validateTheDataExceedsTheDefinedPageSizeUnder277CAFilesTab() {
        validateTheDataExceedsTheDefinedPageSize(lst277CARecordsBar);
    }

    public void verify277CAForwardNavigationThroughPages() {
        verifyForwardNavigationThroughPages(btn277CANext, lst277CAPageBar);
    }

    public void verify277CABackwardNavigationThroughPages() {
        verifyBackwardNavigationThroughPages(btn277CAPrevious, lst277CAPageBar);
    }

    public void verify277CAForwardNavigationPageSizeAtTheBottomOfTheGrid() {
        verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(btn277CANext, lst277CARecordsBar);
    }

    public void verify277CABackwardNavigationPageSizeAtTheBottomOfTheGrid() {
        verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(btn277CAPrevious, lst277CARecordsBar);
    }

    public void verify277CATotalNumberOfPagesBasedOnThePerPageRecordCount() {
        verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(lst277CARecordsBar, lst277CAPageBar);
    }

    //    Scenario Outline: Verify color code for Status View under 277CA files tab
    public void verify277CAStatusViewColorCoding(String status, String colorCode277CAExp) throws InterruptedException {
        explicitElementClickableWaitByXpath(txt277CAStatus, 5).sendKeys(status);
        explicitTextToBePresentInElementLocatedWait(By.xpath(lbl277CAStatusType), 10, status);
        String colorCode277CAAct = getColorCodeForBackground(lbl277CAStatusColor);
        System.out.println("277CA color code status is: " + colorCode277CAAct);
        Assert.assertEquals(colorCode277CAExp, colorCode277CAAct);
    }

    //    Scenario: Validate pagination functionality in '835' tab
    public void clickOn835FilesTab() throws InterruptedException {
        explicitInvisibilityOfElementWithTextWait(By.xpath(tab837PFiles), 40, "835 () ");
        explicitElementClickableWaitByXpath(tab835, 5);
        moveToElement(tab835).click().perform();
    }
    public void validateTheDataExceedsTheDefinedPageSizeUnder835FilesTab()
    {
        validateTheDataExceedsTheDefinedPageSize(lst835RecordsBar);
    }
    public void verify835ForwardNavigationThroughPages()
    {
        verifyForwardNavigationThroughPages(btn835Next, lst835PageBar);
    }
    public void verify835BackwardNavigationThroughPages()
    {
        verifyBackwardNavigationThroughPages(btn835Previous, lst835PageBar);
    }
    public void verify835ForwardNavigationPageSizeAtTheBottomOfTheGrid()
    {
        verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(btn835Next, lst835RecordsBar);
    }
    public void verify835BackwardNavigationPageSizeAtTheBottomOfTheGrid()
    {
        verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(btn835Previous, lst835RecordsBar);
    }
    public void verify835TotalNumberOfPagesBasedOnThePerPageRecordCount()
    {
        verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(lst835RecordsBar, lst835PageBar);
    }

    //    Scenario Outline: Verify color code for Status View under 835 files tab
    public void verify835StatusViewColorCoding(String status, String colorCode835Exp) throws InterruptedException {
        scrollToElement(txt835Status);
        explicitElementClickableWaitByXpath(txt835Status, 5).sendKeys(status);
        explicitTextToBePresentInElementLocatedWait(By.xpath(lbl835StatusType), 10, status);
        String colorCode835Act = getColorCodeForBackground(lbl835StatusColor);
        System.out.println("835 color code status is: " + colorCode835Act);
        Assert.assertEquals(colorCode835Exp, colorCode835Act);
    }

    //    Scenario: Verify column fields in '835' tab
    public void verifyUserAbleToSee835ColumnFields(DataTable fieldsList835) throws InterruptedException {
        explicitElementClickableWaitByXpath(lst835ColumnFieldNames, 10);
        scrollToElementsAndCompare2Lists(fieldsList835, lst835ColumnFieldNames);
    }
    public void verifyUserAbleToView835ColumnFieldsSearchBoxes()
    {
        scrollToElementsAndValidateDisplayStatus(lst835ColumnSearchFields);
    }


}
