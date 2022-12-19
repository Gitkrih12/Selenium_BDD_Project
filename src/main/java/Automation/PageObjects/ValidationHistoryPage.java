package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ValidationHistoryPage extends SeleniumUtils {

    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String tabValidationHistory = "//*[@id = 'nav-validationhistory-tab']";
    String lstValidationHistory = "//*[@ref='eText']";

    private static String expClaimNumber = "";

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

    public void clickOnClaimNumber() throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleClaimNumber), 20, expClaimNumber);
        clickElement(eleClaimNumber);
        threadSleep(1000);
    }

    public void clickOnValidationHistory(){
        clickElement(tabValidationHistory);
    }

    public void verifyValidationHistoryTab(String expTab){
        Assert.assertEquals(expTab, findElementByXpath(tabValidationHistory).getText());
    }

    public void verifyFieldsUnderValidationHistory(DataTable expFields){
        scrollToElementsAndCompare2Lists(expFields, lstValidationHistory);
    }
}
