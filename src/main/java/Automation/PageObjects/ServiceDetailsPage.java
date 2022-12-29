package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ServiceDetailsPage extends SeleniumUtils {

    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String tabServiceDetails = "//*[contains(text(), 'Service Details')]";
    String lstServiceDetailsColumnFields = "//*[@id='nav-service-details']//div[contains(@class, 'columnFont')]//div";
    String tblServiceLineFields = "(//table[@class='table table-striped ng-star-inserted']//tr//th[(node())])[not(position()=4)]";
    String btnFooterFields = "//*[@class='footer footer-flex']/button";
    String lnkLineNumber = "(//*[@class='gridData ng-star-inserted']//a)[1]";
    String tabPricing = "//*[contains(text(),'Pricing')]";
    String lstServiceDetailsValues = "//*[@id='nav-service-details']//div[contains(@class, 'row mt-1')]//div";
    String lstServiceLineFieldValues = "//table[@class='table table-striped ng-star-inserted']/tbody//div[contains(@class, 'gridData') and text()]";


    private static String expClaimNumber = "";
    private static String expPricingTab = "";


    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void enterClaimNumberInSearchField() throws InterruptedException {
        explicitElementClickableWaitByXpath(inputClaimNumber, 10);
        expClaimNumber = prop.getProperty("claimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    //  Scenario: Verify Adjudicator able to Navigate Service Details from Global Search and validate the fields
    public void clickOnClaimNumber() throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleClaimNumber), 20, expClaimNumber);
        clickElement(eleClaimNumber);
        threadSleep(1000);
    }

    public void clickOnServiceDetails() throws InterruptedException {
        explicitElementClickableWaitByXpath(tabServiceDetails, 30);
        clickElement(tabServiceDetails);
    }

    public void userViewsAllColumnFieldsInServiceDetails(DataTable columnList) {
        scrollToElementsAndCompare2Lists(columnList, lstServiceDetailsColumnFields);
    }

    public void verifyUserViewsFieldValuesInServiceDetails() {
        scrollToElementsAndValidateDisplayStatus(lstServiceDetailsValues);
    }

    //  Scenario: Verify Service Lines fields
    public void userViewsServiceLineFields(DataTable serviceLineFields) {
        explicitElementClickableWaitByXpath(tblServiceLineFields, 20);
        scrollToElementsAndCompare2Lists(serviceLineFields, tblServiceLineFields);
    }

    public void userViewsServiceLineFieldValues() {
        scrollToElementsAndValidateDisplayStatus(lstServiceLineFieldValues);
    }

    //  Scenario: Verify footer section available in Service details tab
    public void userViewsFooterSectionInServiceDetails(DataTable footerFields) {
        explicitElementClickableWaitByXpath(btnFooterFields, 20);
        compare2Lists(footerFields, btnFooterFields);
    }

    //  Scenario: Verify user able to navigate to Pricing page upon clicking Line number
    public void clickOnLineNumber() {
        explicitElementClickableWaitByXpath(lnkLineNumber, 20);
        clickElement(lnkLineNumber);
    }

    public void userNavigatesToPricingPage() {
        String actualValue[] = findElementByXpath(tabPricing).getText().split(" ");
        expPricingTab = prop.getProperty("expPricingScreen");
        Assert.assertEquals(expPricingTab, actualValue[0] + actualValue[1] + actualValue[2]);
    }
}