package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ValidationHistoryPage extends SeleniumUtils {

    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String tabValidationHistory = "//*[@id = 'nav-validationhistory-tab']";
    String lstValidationHistory = "//*[@ref='eText']";
    String txtDateAndTime = "//*[@aria-label = 'Date & Time Filter Input']";
    String eleDateAndTime = "//*[@col-id = 'logTime']//span[@class = 'ag-cell-value']";
    String txtServiceLineNo = "//*[@aria-label = 'Service Line No. Filter Input']";
    String eleServiceLineNo = "//*[@col-id = 'serviceLineNumber']//span[@class = 'ag-cell-value']";
    String txtActivity = "//*[@aria-label = 'Activity Filter Input']";
    String eleActivity = "(//*[@col-id = 'category']//span[@class = 'ag-cell-value'])[1]";
    String txtDescription = "//*[@aria-label = 'Description Filter Input']";
    String eleDescription = "//*[@col-id = 'subCategory']//span[@class = 'ag-cell-value']";
    String txtPerformedBy = "//*[@aria-label = 'Performed By Filter Input']";
    String elePerformedBy = "(//*[@col-id = 'userId']//span[@class = 'ag-cell-value'])[1]";
    String btnFooterFields = "//*[@class='footer footer-flex']/button";

    private static String expClaimNumber = "";
    private static String expDateAndTime = "";
    private static String expServiceLineNo = "";
    private static String expActivity = "";
    private static String expDescription = "";
    private static String expPerformedBy = "";


    //  Scenario: Verify user able to navigate to the Validation History tab
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void enterClaimNumberInSearchField() throws InterruptedException {
        explicitElementClickableWaitByXpath(inputClaimNumber, 10);
        expClaimNumber = prop.getProperty("validationHistoryClaimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void clickOnClaimNumber() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleClaimNumber), 20, expClaimNumber);
        clickElement(eleClaimNumber);
        explicitElementClickableWaitByXpath(tabValidationHistory, 20);
    }

    public void clickOnValidationHistory() {
        clickElement(tabValidationHistory);
    }

    public void verifyValidationHistoryTab(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabValidationHistory).getText());
    }

    //  Scenario: Verify user able to view all the column fields under Validation History subtab
    public void verifyFieldsUnderValidationHistory(DataTable expFields) {
        scrollToElementsAndCompare2Lists(expFields, lstValidationHistory);
    }

    //  Scenario: Verify user able to view the search criteria for Date and Time
    public void userEntersDateAndTime() {
        expDateAndTime = prop.getProperty("dateAndTime");
        explicitElementClickableWaitByXpath(txtDateAndTime, 20);
        findElementAndSendKeys(findElementByXpath(txtDateAndTime), expDateAndTime);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleDateAndTime), 10, expDateAndTime);
    }

    public void verifyDateAndTimeFieldValue() {
        explicitElementClickableWaitByXpath(eleDateAndTime, 20);
        Assert.assertEquals(expDateAndTime, findElementByXpath(eleDateAndTime).getText());
    }

    //  Scenario: Verify user able to view the search criteria for Service Line No.
    public void userEntersServiceLineNo() {
        expServiceLineNo = prop.getProperty("serviceLineNo");
        explicitElementClickableWaitByXpath(txtServiceLineNo, 20);
        findElementAndSendKeys(findElementByXpath(txtServiceLineNo), expServiceLineNo);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleServiceLineNo), 10, expServiceLineNo);
    }

    public void verifyServiceLineNoFieldValue() {
        explicitElementClickableWaitByXpath(eleServiceLineNo, 20);
        Assert.assertEquals(expServiceLineNo, findElementByXpath(eleServiceLineNo).getText());
    }

    //  Scenario: Verify user able to view the search criteria for Activity
    public void userEntersActivity() {
        expActivity = prop.getProperty("activity");
        explicitElementClickableWaitByXpath(txtActivity, 20);
        findElementAndSendKeys(findElementByXpath(txtActivity), expActivity);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleActivity), 10, expActivity);
    }

    public void verifyActivityFieldValue() {
        explicitElementClickableWaitByXpath(eleActivity, 20);
        Assert.assertEquals(expActivity, findElementByXpath(eleActivity).getText());
    }

    //  Scenario: Verify user able to view the search criteria for Description
    public void userEntersDescription() {
        expDescription = prop.getProperty("description");
        explicitElementClickableWaitByXpath(txtDescription, 20);
        findElementAndSendKeys(findElementByXpath(txtDescription), expDescription);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleDescription), 10, expDescription);
    }

    public void verifyDescriptionFieldValue() {
        explicitElementClickableWaitByXpath(eleDescription, 20);
        Assert.assertEquals(expDescription, findElementByXpath(eleDescription).getText());
    }

    //  Scenario: Verify user able to view the search criteria for Performed By
    public void userEntersPerformedBy() {
        expPerformedBy = prop.getProperty("performedBy");
        explicitElementClickableWaitByXpath(txtPerformedBy, 20);
        findElementAndSendKeys(findElementByXpath(txtPerformedBy), expPerformedBy);
        explicitTextToBePresentInElementLocatedWait(By.xpath(elePerformedBy), 10, expPerformedBy);
    }

    public void verifyPerformedByFieldValue() {
        explicitElementClickableWaitByXpath(elePerformedBy, 20);
        Assert.assertEquals(expPerformedBy, findElementByXpath(elePerformedBy).getText());
    }

    //  Scenario: Verify footer section available in Validation History tab
    public void verifyFooterFieldsInValidationHistory(DataTable expFields) {
        compare2Lists(expFields, btnFooterFields);
    }
}
