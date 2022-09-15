package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
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
        moveToElement(mnuFiles).perform();
        clickElement(mnuFiles);
        threadSleep(1000);
        explicitElementClickableWaitByXpath(tabFiles, 5);
        String[] filesTabText = getText(tabFiles).split(" ");
        String filesTabTextAct = filesTabText[0];
        System.out.println("Actual files tab text is: " + filesTabTextAct);
        System.out.println("Expected files tab text is: " + filesTabTextExp);
        Assert.assertEquals(filesTabTextExp, filesTabTextAct);
    }

    public void clickOn837PFilesTab() throws InterruptedException {
        explicitElementClickableWaitByXpath(tab837PFiles, 10);
        moveToElement(tab837PFiles).click().perform();
        threadSleep(4000);
    }

    public void verifyUserAbleToSee837PColumnFields(DataTable fieldsList837P) throws InterruptedException {
        List<String> fieldsList837PExp = fieldsList837P.asList();
        List<WebElement> fields837P = findElementsByXpath(lst837PColumnFieldNames);
        System.out.println("Elements size is: " + fields837P.size());
        List<String> fieldsList837PAct = new ArrayList<>();
        for (WebElement column : fields837P) {
            threadSleep(2000);
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsList837PAct.add(text);
        }
        System.out.println("837P column names actual size: " + fieldsList837PAct.size());
        System.out.println("837P column names expected size: " + fieldsList837PExp.size());
        System.out.println("837P actual column names: " + fieldsList837PAct);
        System.out.println("837P expected column names: " + fieldsList837PExp);
        for (String exp : fieldsList837PExp) {
            if (fieldsList837PAct.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual");
            }
        }
    }

    public void verifyUserAbleToView837PColumnFieldsSearchBoxes() {
        List<WebElement> SearchBoxes837P = findElementsByXpath(lst837PColumnSearchFields);
        for (WebElement searchBox : SearchBoxes837P) {
            scrollIntoView(searchBox, driver);
            Assert.assertTrue(isDisplayed(searchBox));
        }
    }

    //    Scenario: Verify user should be able to see the results of rows count next to the "837P Files" tab
    public void validateRowCountNextTo837PFilesTab() throws InterruptedException {
        validateRowCountNextToFilesTab(tab837PFiles, lst837PRecordsBar);
    }

    //    Scenario: Validate pagination functionality in '837P Files' tab
    public void applyFilterToControlNumberFieldOn837PFilesTab() throws InterruptedException {
        if (Objects.equals(environment, "test")) {
            String paginationControlNumber837PExp = prop.getProperty("837PPaginationControlNumber");
            explicitElementClickableWaitByXpath(txt837PControlNumber, 5).sendKeys(paginationControlNumber837PExp);
            threadSleep(2000);
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
    public String[] validateTheDataExceedsTheDefinedPageSize(String paginationRecordsBarXpath) {
        String[] paginationRecordsExp = explicitElementClickableWaitByXpath(paginationRecordsBarXpath, 5).getText().split(" ");
        int totalRowsExp = Integer.parseInt(paginationRecordsExp[4]);
        System.out.println("total row count is: " + totalRowsExp);
        if (totalRowsExp > 50) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("Data has not exceeded the defined page size");
        }
        return paginationRecordsExp;
    }

    //Generic method to verify forward navigation through pages
    public String[] verifyForwardNavigationThroughPages(String nextButtonXpath, String paginationPageBarXpath) {
        String[] paginationPagesExp = new String[0];
        try {
            scrollToElement(nextButtonXpath);
            clickElement(nextButtonXpath);
            paginationPagesExp = explicitElementClickableWaitByXpath(paginationPageBarXpath, 5).getText().split(" ");
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
    public String[] verifyBackwardNavigationThroughPages(String previousButtonXpath, String paginationPageBarXpath) {
        String[] paginationPagesExp = new String[0];
        try {
            scrollToElement(previousButtonXpath);
            clickElement(previousButtonXpath);
            paginationPagesExp = explicitElementClickableWaitByXpath(paginationPageBarXpath, 10).getText().split(" ");
            System.out.println("Backward navigation page: " + paginationPagesExp[1]);
            Assert.assertEquals(1, Integer.parseInt(paginationPagesExp[1]));
        } catch (Exception e) {
            Assert.fail("User not able to navigate through pages");
        }
        return paginationPagesExp;
    }

    //Generic method to verify forward navigation through pages
    public String[] verifyForwardNavigationPageSizeAtTheBottomOfTheGrid(String nextButtonXpath, String paginationRecordsBarXpath) {
        String[] paginationRecordsExp = new String[0];
        try {
            scrollToElement(nextButtonXpath);
            clickElement(nextButtonXpath);
            paginationRecordsExp = explicitElementClickableWaitByXpath(paginationRecordsBarXpath, 10).getText().split(" ");
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
    public String[] verifyBackwardNavigationPageSizeAtTheBottomOfTheGrid(String previousButtonXpath, String paginationRecordsBarXpath) {
        String[] paginationRecordsExp = new String[0];
        try {
            scrollToElement(previousButtonXpath);
            clickElement(previousButtonXpath);
            paginationRecordsExp = explicitElementClickableWaitByXpath(paginationRecordsBarXpath, 10).getText().split(" ");
            System.out.println("Backward navigation page size: " + paginationRecordsExp[0]);
            Assert.assertEquals(1, Integer.parseInt(paginationRecordsExp[0]));
        } catch (Exception e) {
            Assert.fail("Page size is not correct through backward navigation");
        }
        return paginationRecordsExp;
    }

    //Generic method to verify total number of pages based on the record count per page
    public void verifyTotalNumberOfPagesBasedOnThePerPageRecordCount(String paginationRecordsBarXpath, String paginationPageBarXpath) {
        String[] paginationRecordsExp = explicitElementClickableWaitByXpath(paginationRecordsBarXpath, 10).getText().split(" ");
        String[] paginationPagesExp = explicitElementClickableWaitByXpath(paginationPageBarXpath, 10).getText().split(" ");
        double pageCount = Math.ceil(Double.parseDouble(paginationRecordsExp[4]) / 50);
        int pageCountAct = (int) pageCount;
        System.out.println("Actual page count: " + pageCountAct);
        System.out.println("Expected page count: " + paginationPagesExp[3]);
        Assert.assertEquals(Integer.parseInt(paginationPagesExp[3]), pageCountAct);
    }

    //Generic method to verify row count next to 837P, 837I, 837D, 999, 277CA and 835
    public void validateRowCountNextToFilesTab(String fileTabXpath, String recordsBarXpath) throws InterruptedException {
        String recordsBarText = explicitElementClickableWaitByXpath(fileTabXpath, 5).getText();
        String rowCountAct = recordsBarText.substring(recordsBarText.indexOf("(") + 1, recordsBarText.indexOf(")"));
        System.out.println("Actual row count is: " + rowCountAct);
        threadSleep(2000);
        scrollToElement(recordsBarXpath);
        String[] RecordsExp = explicitElementClickableWaitByXpath(recordsBarXpath, 5).getText().split(" ");
        System.out.println("Expected row count is: " + RecordsExp[4]);
        Assert.assertEquals(RecordsExp[4], rowCountAct);
    }


    //    Scenario: Verify color code for Status View under '837P Files' tab
    public void verify837PStatusViewColorCoding(String status, String colorCode837PExp) throws InterruptedException {
        explicitElementClickableWaitByXpath(txt837PStatus, 10).sendKeys(status);
        threadSleep(4000);
        String colorCode837PAct = getColorCodeForBackground(lbl837PStatusColor);
        System.out.println("837P color code status is: " + colorCode837PAct);
        Assert.assertEquals(colorCode837PExp, colorCode837PAct);
    }

    //    Scenario: Verify Sorting functionality for "File Name" column under "837P Files" tab
    public void enter837PControlNumberUnderSearchField() throws InterruptedException {
        controlNumber837PSortExp = prop.getProperty("837PSortControlNumber");
        findElementWithXpathAndsendKeys(txt837PControlNumber, controlNumber837PSortExp);
        threadSleep(2000);
    }

    public void verify837PControlNumbersForGivenRecord() throws InterruptedException {
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
        findElementWithXpathAndsendKeys(txt837PDateReceived, receivedDate837PSortExp);
        threadSleep(2000);
    }

    public void verifyUserAbleToView837PReceivedDates() {
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



}
