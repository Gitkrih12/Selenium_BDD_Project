package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.junit.Assert;
import org.openqa.selenium.support.Color;

import java.util.Locale;

public class FFSProfessionalPage extends SeleniumUtils {
    String lnkFFSProfessional = "//div[contains(text(),'FFS Professional')]";
    String tabFFSProfessional = "(//div[contains(text(),'FFS Professional')])[2]";
    String txtClaimNumber = "(//input[@aria-label='Claim Number Filter Input'])[1]";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String eleVerticalColorForCorrected = "(//div[@col-id='isCorrected']//span)[6]";
    String eleCorrectedInfoTopGrid = "//div//span[@class='ColorBall']//following::span[contains(text(),'Corrected')]";
    //String elePatientNameColorCode = "((//div[contains(@class,'ag-cell-focus') and @col-id='memberFullName'])[1]//span)[3]";
    String elePatientNameColorCode = "((//div[contains(@class,'ag-cell ag-cell-not-inline-editing ag-cell-normal-height') and @col-id='memberFullName'])[1]//span)[3]";
    String eleCOBInMemberHouseInfoTopGrid = "//span[@class='ColorBall_COBInMemberHouse']//following::span[contains(text(),'COB (In Member House)')]";
    String eleCOBNotInMemberHouseInfoTopGrid = "//span[@class='ColorBall_COB_NoninMemberHouse']//following::span[contains(text(),'COB (Not in Member House)')]";

    private static String expClaimNumber = "";



    //Verify color code for corrected claims in FFS Professional page
    public void clickOnFFSProfessional(){
        explicitVisibilityOfWait(findElementByXpath(lnkFFSProfessional), 5);
        clickElement(lnkFFSProfessional);
    }
    public void verifyFFSProfessionalPage(){
        boolean value = isDisplayed(tabFFSProfessional);
        Assert.assertTrue(value);

    }
    public void enterCorrectedClaimNumberInFFSProfessionalSearchField() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("ffsProfessionalCorrectedClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void validateClaimNumberResult() {
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 5);
        String actClaimNumber = getText(eleClaimNumber);
        System.out.println("actual claimNumber :" + actClaimNumber);
        Assert.assertEquals(expClaimNumber, actClaimNumber);
    }

    public void verifyVerticalColorIndicationForCorrectedClaim(String expColorIndication) {
        String actColorCode = getColorCodeForBackground(eleVerticalColorForCorrected);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorIndication, actColorCode);
    }

    public void verifyCorrectedInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleCorrectedInfoTopGrid);
        Assert.assertTrue(value);
    }

    //Verify color code for COB Not In Member House in FFS Professional page
    public void enterCOBInMemberHouseClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("cobInMemberHouse");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void verifyPatientNameColorCode(String expColorCode){
        String actColorCode = getColorCodeForText(elePatientNameColorCode);
        System.out.println("actual color code :" + actColorCode);
        Assert.assertEquals(expColorCode, actColorCode);
    }
    public void verifyCOBInMemberHouseInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleCOBInMemberHouseInfoTopGrid);
        Assert.assertTrue(value);
    }

    //Scenario: Verify color code for COB(Not In Member House) in FFS Professional page
    public void enterCOBNotInMemberHouseClaimNumber() throws InterruptedException {
        threadSleep(30000);
        expClaimNumber = prop.getProperty("cobNotInMemberHouse");
        findElementAndSendKeys(findElementByXpath(txtClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtClaimNumber);
    }
    public void verifyCOBNotInMemberHouseInformationOnTopOfGrid() {
        boolean value = isDisplayed(eleCOBNotInMemberHouseInfoTopGrid);
        Assert.assertTrue(value);
    }



}
