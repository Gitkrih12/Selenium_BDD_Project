package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.junit.Assert;
import org.openqa.selenium.By;

public class FeeSchedulePage extends SeleniumUtils {
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String lnkServiceLine="(//div[@class='gridData ng-star-inserted']//a)[1]";
    String elePricingScreen="//div[contains(text(),'Pricing')]";
    String lnkSeeFeeSchedule="//button[text()='See Fee Schedule']";
    String eleFeeSchedules="//div[@class='offcanvas-header']//h5";


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


}
