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
    String lstPaymentPolicyIndicatorsFieldValues="(//div[contains(@class,'ag-row-even ag-row-no-focus ag-row ag-row-level-0')])[5]//div[text()]";
    String lstRVUFieldValues="(//div[contains(@class,'ag-row-even ag-row-no-focus ag-row ag-row-level-0')])[8]//div[text()]";
    String lstGeographicPracticeCostFieldValues="(//div[contains(@class,'ag-row-even ag-row-no-focus ag-row ag-row-level-0')])[11]//div";


    private static String expClaimNumber = "";

    //Scenario: Verify user able to view the Fee schedules side drawer when clicking on See Fee Schedule in Pricing screen
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void enterClaimNumberInSearchField() throws InterruptedException {
        threadSleep(1000);
        expClaimNumber = prop.getProperty("claimNumberForFeeSchedule");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void clickOnClaimNumber() throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleClaimNumber), 20, expClaimNumber);
        clickElement(eleClaimNumber);
        threadSleep(1000);
    }

    public void clickOnServiceLine(){
        clickElement(lnkServiceLine);
    }

    public void verifyPricingScreen(String expPricingText){
        explicitTextToBePresentInElementLocatedWait(By.xpath(elePricingScreen), 20, "Pricing");
        String pricingText = findElementByXpath(elePricingScreen).getText();
        String[] actPricingText = pricingText.split(" ");
        Assert.assertEquals(expPricingText, actPricingText[0]);
    }

    public void clickOnSeeFeeSchedule(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(lnkSeeFeeSchedule), 20, "See Fee Schedule");
        clickElement(lnkSeeFeeSchedule);
    }

    public void verifyFeeSchedules(String expFeeScheduleText){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleFeeSchedules), 20, "Fee Schedules");
        String actFeeScheduleText = findElementByXpath(eleFeeSchedules).getText();
        Assert.assertEquals(expFeeScheduleText, actFeeScheduleText);
    }

    //Scenario: Verify user able to view the respective tabs under Fee Schedules side drawer
    public void verifyTabsInFeeSchedules(DataTable tabList) throws InterruptedException{
        List<String> exTabList = tabList.asList();
        List<WebElement> actTabFields = findElementsByXpath(lstTabsInFeeSchedules);
        List<String> actualTabFieldsForCompare = new ArrayList<>();
        for (WebElement column : actTabFields) {
            threadSleep(1000);
            scrollIntoView(column, driver);
            String text = column.getText();
            actualTabFieldsForCompare.add(text);
        }
        System.out.println("actual tab fields " + actualTabFieldsForCompare);
        System.out.println("expected tab fields " + exTabList);
        for (String expColumn : exTabList) {
            if (actualTabFieldsForCompare.contains(expColumn)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(expColumn + " tab is not as expected");
            }
        }

    }

    public void verifyFeeSchedulesColumnFields(DataTable columnList) throws InterruptedException {
        compare2Lists(columnList, lstFeeSchedulesColumnFields);
    }

    public void verifyFieldValuesInFeeSchedules(){
       scrollToElementsAndValidateDisplayStatus(lstFeeSchedulesFieldValues);
    }

    //Scenario: Verify column fields in Payment Policy Indicators tab
    public void clickPaymentPolicyIndicators(){
        explicitElementClickableWaitByXpath(tabPaymentPolicyIndicators, 10);
        clickElement(tabPaymentPolicyIndicators);
    }
    public void verifyPaymentPolicyIndicatorsColumnFields(DataTable columnList) throws InterruptedException {
        List<String> expColumnList = columnList.asList();
        List<WebElement> actColumnFields = findElementsByXpath(lstPaymentPolicyIndicatorsColumnFields);
        List<String> actualColumnFieldsForCompare = new ArrayList<>();
        for (WebElement column : actColumnFields) {
            threadSleep(5000);
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
    public void verifyFieldValuesInPaymentPolicyIndicator(){
        explicitElementClickableWaitByXpath(lstPaymentPolicyIndicatorsFieldValues, 10);
        scrollToElementsAndValidateDisplayStatus(lstPaymentPolicyIndicatorsFieldValues);
    }

    //Scenario: Verify user navigates to Payment Policy Indicators tab
    public void verifyPaymentPolicyIndicators(String expPaymentPolicyIndicatorsText){
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabPaymentPolicyIndicators), 10, "Payment Policy Indicators");
        String actPaymentPolicyIndicators = findElementByXpath(tabPaymentPolicyIndicators).getText();
        Assert.assertEquals(expPaymentPolicyIndicatorsText, actPaymentPolicyIndicators);
    }

    //Scenario: Verify user navigates to RVU tab
    public void clickOnRVU(){
        explicitElementClickableWaitByXpath(tabRVU, 20);
        clickElement(tabRVU);
    }

    public void verifyRVU(String expRVUText){
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabRVU), 10, "RVU");
        String actRVU = findElementByXpath(tabRVU).getText();
        Assert.assertEquals(expRVUText, actRVU);
    }

    //Scenario: Verify column fields in RVU tab
    public void verifyRVUColumnFields(DataTable columnList) throws InterruptedException {
        List<String> expColumnList = columnList.asList();
        List<WebElement> actColumnFields = findElementsByXpath(lstRVUColumnFields);
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
       //compare2Lists(columnList, lstRVUColumnFields);
    }
    public void verifyFieldValuesInRVU(){
        explicitElementClickableWaitByXpath(lstRVUFieldValues, 10);
        scrollToElementsAndValidateDisplayStatus(lstRVUFieldValues);
    }

    //Scenario: Verify user navigates to Geographic Practice Cost tab
    public void clickOnGeographicPracticeCost(){
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabGeographicPracticeCost), 10, "Geographic");
        clickElement(tabGeographicPracticeCost);
    }

    public void verifyGeographicPracticeCost(String expRVUText){
        explicitTextToBePresentInElementLocatedWait(By.xpath(tabGeographicPracticeCost), 10, "Geographic");
        String actRVU = findElementByXpath(tabGeographicPracticeCost).getText();
        Assert.assertEquals(expRVUText, actRVU);
    }

    //Scenario: Verify column fields in Geographic Practice Cost tab
    public void verifyGeographicPracticeCostColumnFields(DataTable columnList) throws InterruptedException {
        List<String> expColumnList = columnList.asList();
        List<WebElement> actColumnFields = findElementsByXpath(lstGeographicPracticeCostColumnFields);
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
    public void verifyFieldValuesInGeographicPracticeCost(){
        explicitElementClickableWaitByXpath(lstGeographicPracticeCostFieldValues, 10);
        scrollToElementsAndValidateDisplayStatus(lstGeographicPracticeCostFieldValues);
    }

}
