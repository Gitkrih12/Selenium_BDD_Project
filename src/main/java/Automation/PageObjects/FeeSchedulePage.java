package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class FeeSchedulePage extends SeleniumUtils {
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String lnkServiceLine="(//div[@class='gridData ng-star-inserted']//a)[1]";
    String elePricingScreen="//div[contains(text(),'Pricing')]";
    String lnkSeeFeeSchedule="//button[text()='See Fee Schedule']";
    String eleFeeSchedules="//div[@class='offcanvas-header']//h5";
    String lstTabsInFeeSchedules= "//h5[@id='offcanvasRightLabel']//following::div[@id='nav-tab']//button";
    String lstFeeSchedulesColumnFields="(//div[@class='ag-header-row ag-header-row-column'])[2]//div[@role='columnheader']";
    String tabPaymentPolicyIndicators="//button[text()='Payment Policy Indicators']";
    String lstPaymentPolicyIndicatorsColumnFields="(//div[@class='ag-header-row ag-header-row-column'])[5]//div[@role='columnheader']";
    String tabRVU="//button[contains(text(),'RVU')]";
    String lstRVUColumnFields="(//div[@class='ag-header-row ag-header-row-column'])[8]//div[@role='columnheader']";
    String tabGeographicPracticeCost="//button[contains(text(),'Geographic Practice Cost')]";
    String lstGeographicPracticeCostColumnFields="(//div[@class='ag-header-row ag-header-row-column'])[11]//div[@role='columnheader']";
    String lstFeeSchedulesFieldValues="(//div[contains(@class,'ag-row-even ag-row-no-focus ag-row ag-row-level-0')])[2]//div[text()]";
    String lstPaymentPolicyIndicatorsFieldValues="((//div[@id='nav-profile']//div[@ref='eContainer'])[2]//div[@role='row'])[1]//div[text()]";
    String lstRVUFieldValues="((//div[@id='nav-contact']//div[@ref='eContainer'])[2]//div[@role='row'])[1]//div[text()]";
    String lstGeographicPracticeCostFieldValues="((//div[@id='nav-expiry']//div[@ref='eContainer'])[2]//div[@role='row'])[1]//div[text()]";
    String elePaymentPolicyIndicatorCPTCode="(((//div[@id='nav-profile']//div[@ref='eContainer'])[2]//div[@role='row'])[1]//div[text()])[1]";
    String eleGeographicPracticeCostMACLocality="(((//div[@id='nav-expiry']//div[@ref='eContainer'])[2]//div[@role='row'])[1]//div[text()])[1]";



    private static String expClaimNumber = "";

    //Scenario: Verify user able to view the Fee schedules side drawer when clicking on See Fee Schedule in Pricing screen
    public void enterClaimNumberInSearchField() throws InterruptedException {
        expClaimNumber = prop.getProperty("claimNumberForFeeSchedule");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void clickOnClaimNumber() throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleClaimNumber), 20, expClaimNumber);
        clickElement(eleClaimNumber);
    }

    public void clickOnServiceLine(){
        scrollPageDown(driver);
        explicitElementClickableWaitByXpath(lnkServiceLine, 20);
        clickElement(lnkServiceLine);
    }

    public void clickOnSeeFeeSchedule(){
        scrollPageUp(driver);
        explicitTextToBePresentInElementLocatedWait(By.xpath(lnkSeeFeeSchedule), 20, "See Fee Schedule");
        clickElement(lnkSeeFeeSchedule);
    }

    public void verifyUserNavigatesPricingAndFeeScheduleScreens(String expText){
        if(expText.contains("Pricing")){
            explicitTextToBePresentInElementLocatedWait(By.xpath(elePricingScreen), 20, "Pricing");
            String pricingText = findElementByXpath(elePricingScreen).getText();
            String[] actPricingText = pricingText.split(" ");
            Assert.assertEquals(expText, actPricingText[0]);
        }else if(expText.contains("Fee Schedules")){
            explicitTextToBePresentInElementLocatedWait(By.xpath(eleFeeSchedules), 20, "Fee Schedules");
            String actFeeScheduleText = findElementByXpath(eleFeeSchedules).getText();
            Assert.assertEquals(expText, actFeeScheduleText);
        }
    }

    //Scenario: Verify user able to view the respective tabs under Fee Schedules side drawer
    public void verifyTabsInFeeSchedules(DataTable tabList) throws InterruptedException{
        compare2Lists(tabList, lstTabsInFeeSchedules);
    }

    public void verifyFeeSchedulesColumnFields(DataTable columnList) throws InterruptedException {
        //compare2Lists(columnList, lstFeeSchedulesColumnFields);
        scrollToElementsAndCompare2Lists(columnList,lstFeeSchedulesColumnFields);
    }

    public void verifyFieldValuesInFeeSchedules(){
       scrollToElementsAndValidateDisplayStatus(lstFeeSchedulesFieldValues);
    }

    //Scenario: Verify column fields in Payment Policy Indicators tab
    public void clickPaymentPolicyIndicators(){
        explicitElementClickableWaitByXpath(tabPaymentPolicyIndicators, 15);
        clickElement(tabPaymentPolicyIndicators);
    }
    public void verifyPaymentPolicyIndicatorsColumnFields(DataTable columnList) throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(lstPaymentPolicyIndicatorsColumnFields), 10);
        scrollToElementsAndCompare2Lists(columnList,lstPaymentPolicyIndicatorsColumnFields);
    }
    public void verifyFieldValuesInPaymentPolicyIndicator(){
        explicitElementClickableWaitByXpath(elePaymentPolicyIndicatorCPTCode,20);
        scrollToElementsAndValidateDisplayStatus(lstPaymentPolicyIndicatorsFieldValues);
    }

    //Scenario: Verify user navigates to Payment Policy Indicators tab
    public void verifyUserNavigatesToPaymentPolicyIndicatorsRVUAndGeographicScreens(String expText){
        if(expText.contains("Payment")){
            explicitTextToBePresentInElementLocatedWait(By.xpath(tabPaymentPolicyIndicators), 10, "Payment Policy Indicators");
            String actPaymentPolicyIndicators = findElementByXpath(tabPaymentPolicyIndicators).getText();
            Assert.assertEquals(expText, actPaymentPolicyIndicators);
        }else if(expText.contains("RVU")){
            explicitTextToBePresentInElementLocatedWait(By.xpath(tabRVU), 10, "RVU");
            String actRVU = findElementByXpath(tabRVU).getText();
            Assert.assertEquals(expText, actRVU);
        } else if(expText.contains("Geographic")){
            explicitTextToBePresentInElementLocatedWait(By.xpath(tabGeographicPracticeCost), 10, "Geographic");
            String actRVU = findElementByXpath(tabGeographicPracticeCost).getText();
            Assert.assertEquals(expText, actRVU);
        }

    }

    //Scenario: Verify user navigates to RVU tab
    public void clickOnRVU(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabRVU), 10, "RVU");
        explicitElementClickableWaitByXpath(tabRVU, 20);
        clickElement(tabRVU);
    }

    //Scenario: Verify column fields in RVU tab
    public void verifyRVUColumnFields(DataTable columnList) throws InterruptedException {
        scrollToElementsAndCompare2Lists(columnList,lstRVUColumnFields);
    }
    public void verifyFieldValuesInRVU(){
        scrollToElementsAndValidateDisplayStatus(lstRVUFieldValues);
    }

    //Scenario: Verify user navigates to Geographic Practice Cost tab
    public void clickOnGeographicPracticeCost(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabGeographicPracticeCost), 10, "Geographic");
        clickElement(tabGeographicPracticeCost);
    }

    //Scenario: Verify column fields in Geographic Practice Cost tab
    public void verifyGeographicPracticeCostColumnFields(DataTable columnList) throws InterruptedException {
        scrollToElementsAndCompare2Lists(columnList,lstGeographicPracticeCostColumnFields);
    }

    public void verifyFieldValuesInGeographicPracticeCost(){
        explicitElementClickableWaitByXpath(eleGeographicPracticeCostMACLocality,20);
        scrollToElementsAndValidateDisplayStatus(lstGeographicPracticeCostFieldValues);
    }

}
