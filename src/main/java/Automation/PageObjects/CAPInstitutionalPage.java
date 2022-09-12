package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CAPInstitutionalPage extends SeleniumUtils {
    String lnkCAPInstitutional = "//div[contains(text(),'CAP Institutional')]";
    String tabCAPInstitutional = "(//div[contains(text(),'CAP Institutional')])[2]";
    String elePendQueuePage = "(//span[@class='ag-cell-value']//app-view-claim-render)[1]";
    String eleClaimList = "//div//*[text()='Claim List']";
    String tabPendState = "(//button[@class='nav-link active'])[1]";
    String lstColumnFields = "//ag-grid-angular[@id='pendGrid']//div[@class='ag-header-cell-label']//span[text()]";
    String lstQueues = "//div[@id='nav-tab']//button";
    String txtSearchFields = "//ag-grid-angular[@id='pendGrid']//div[@class='ag-header-cell-label']//span[text()]//following::div[1]//input[@type='text']";
    String txtMemberId = "//*[@id='pendGrid']//input[@aria-label='Member ID Filter Input']";
    String eleMemberId = "(//*[@id='pendGrid']//div[@col-id='subscriberId']//span[@class='ag-cell-value'])[1]";
    String eleTotalMemberIdRecords = "//*[@id='pendGrid']//div[@col-id='subscriberId']//span[@class='ag-cell-value']";
    String eleTotalResults = "//*[@id='pendGrid']//span[@class='ag-paging-row-summary-panel']";
    String elePaginationDescription = "//*[@id='pendGrid']//span[@class='ag-paging-description']";
    String tabOnHold = "//button[@id='nav-onhold-details-tab']";
    String eleOnHoldPaginationDescription = "//*[@id='onHoldGrid']//span[@class='ag-paging-description']";
    String btnNextPage = "//*[@id='onHoldGrid']//span[@class='ag-icon ag-icon-next']";
    String btnPreviousPage = "//*[@id='onHoldGrid']//span[@class='ag-icon ag-icon-previous']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";

    private static String expClaimNumber = "";
    private static String expMemberId = "";
    private static int totalRecords = 0;
    private static int pageNumber = 0;
    private static int pageNumberNextNavigation = 0;


    //Scenario: Verify when user clicks on CAP Institutional page on the left navigation pane
    public void clickOnCAPInstitutional(){
        explicitVisibilityOfWait(findElementByXpath(lnkCAPInstitutional), 5);
        clickElement(lnkCAPInstitutional);
    }
    public void verifyCAPInstitutionalPage() throws InterruptedException {
        boolean value = isDisplayed(tabCAPInstitutional);
        Assert.assertTrue(value);
        threadSleep(20000);
    }

    //Scenario: Verify by default user should be in the Pend state field results page
    public void verifyUserByDefaultInPendStateResultsPage() throws InterruptedException {
        boolean value=isDisplayed(elePendQueuePage);
        Assert.assertTrue(value);
    }

    //Scenario: Verify user should able to see Clam List Label in CAP Institutional screen
    public void verifyClaimListLabel(){
        Assert.assertTrue(isDisplayed(eleClaimList));
    }

    //Scenario: Validate user able to view all the column fields in CAP Institutional screen
    public void verifyPendStateByDefault(String expState) throws InterruptedException{
        String actState=findElementByXpath(tabPendState).getAttribute("class");
        if(actState.contains(expState)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }
    public void verifyFFSInstitutionalPendColumnFields(DataTable columnList) throws InterruptedException {
        List<String> expColumnList = columnList.asList();
        List<WebElement> actColumnFields = findElementsByXpath(lstColumnFields);
        List<String> actualColumnFieldsForCompare = new ArrayList<>();
        for (WebElement column : actColumnFields) {
            threadSleep(1000);
            scrollIntoView(column, driver);
            String text = column.getText();
            actualColumnFieldsForCompare.add(text);
        }
        System.out.println("actual column fields " + actualColumnFieldsForCompare);
        System.out.println("expected column fields " + expColumnList);
        for (String expColumn : expColumnList) {
            if (actualColumnFieldsForCompare.contains(expColumn)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(expColumn + " column is not as expected");
            }
        }
    }

    //Scenario: Verify all the queue field details in the CAP Institutional page
    public void verifyQueuesInFFSInstitutional(DataTable queueList) throws InterruptedException {
        List<String> expQueueList = queueList.asList();
        List<WebElement> actQueueFields = findElementsByXpath(lstQueues);
        List<String> actualQueueFieldsForCompare = new ArrayList<>();
        for (WebElement column : actQueueFields) {
            threadSleep(1000);
            scrollIntoView(column, driver);
            String text = column.getText();
            String[] queueData=text.split(" ");
            if(queueData.length==2) {
                actualQueueFieldsForCompare.add(queueData[0]);
            }else if(queueData.length==3){
                actualQueueFieldsForCompare.add(queueData[0]+" "+queueData[1]);
            }else if(queueData.length==4){
                actualQueueFieldsForCompare.add(queueData[0]+" "+queueData[1]+" "+queueData[2]);
            }
        }
        System.out.println("actual queue fields " + actualQueueFieldsForCompare);
        System.out.println("expected queue fields " + expQueueList);
        for (String expQueue : expQueueList) {
            if (actualQueueFieldsForCompare.contains(expQueue)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(expQueue + " queue is not as expected");
            }
        }
    }

    //Scenario: Verify user able to view the search fields under each columns in the CAP Institutional screen
    public void verifySearchFieldsUnderEachColumnInCAPInstitutional() {
        List<WebElement> actSearchFields = findElementsByXpath(txtSearchFields);
        for (WebElement column : actSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    //Scenario: Validate the pagination field in CAP Institutional page
    public void enterMemberIdInSearchFieldForPaginationInCAPInstitutional() throws InterruptedException {
        expMemberId = prop.getProperty("capInstitutionalPaginationMemberId");
        findElementAndSendKeys(findElementByXpath(txtMemberId), expMemberId);
        threadSleep(3000);
    }
    public void validateMemberIDResultInCAPInstitutional() {
        explicitVisibilityOfWait(findElementByXpath(eleMemberId), 5);
        String actMemberId = getText(eleMemberId);
        System.out.println("actual member id :" + actMemberId);
        Assert.assertEquals(expMemberId, actMemberId);
    }
    public void getAllMemberIdResults() {
        List<WebElement> memberIDResults = findElementsByXpath(eleTotalMemberIdRecords);
        totalRecords = memberIDResults.size();
        System.out.println("Total records " + memberIDResults.size());
    }

    public void verifyTotalResultsForGivenSearch() {
        String paginationText = findElementByXpath(eleTotalResults).getText();
        System.out.println("Pagination text " + paginationText);
        String[] totalResultsCount = paginationText.split(" ");
        System.out.println(totalResultsCount[4]);
        if (totalRecords == Integer.parseInt(totalResultsCount[4])) {
            Assert.assertTrue(true);
            System.out.println("Pagination text is having the total no of records in the grid");
        } else {
            Assert.assertTrue(false);
        }
    }

    //Scenario: Verify user see the page numbers as per the no of data divided by pages size
    public void clickOnOnHold(){
        clickElement(tabOnHold);
    }
    public void verifyPageNumbersAtBottomOfPage() throws InterruptedException {
        threadSleep(10000);
        String pagination = findElementByXpath(eleOnHoldPaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        System.out.println("Page count " + Integer.parseInt(paginationCount[3]));
        pageNumber = Integer.parseInt(paginationCount[1]);
        if (Integer.parseInt(paginationCount[3]) >= 1) {
            Assert.assertTrue(true);
        }else{
            Assert.fail("Unable to navigate to next page");
        }
    }

    public void clickOnNextButton() {
        clickElement(btnNextPage);
    }

    public void verifyUserNavigatesToNextPage() {
        String pagination = findElementByXpath(eleOnHoldPaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        pageNumberNextNavigation = Integer.parseInt(paginationCount[1]);
        System.out.println("Page number " + pageNumberNextNavigation);
        if (pageNumberNextNavigation > pageNumber) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }

    }

    public void clickOnPreviousButton() {
        clickElement(btnPreviousPage);
    }

    public void verifyUserNavigatesToPreviousPage() {
        String pagination = findElementByXpath(eleOnHoldPaginationDescription).getText();
        String[] paginationCount = pagination.split(" ");
        int pageNumberPreviousNavigation = Integer.parseInt(paginationCount[1]);
        System.out.println("Page number " + pageNumberPreviousNavigation);
        if (pageNumberNextNavigation > pageNumberPreviousNavigation) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }




}
