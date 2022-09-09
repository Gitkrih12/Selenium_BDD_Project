package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.junit.Assert;

public class CAPInstitutionalPage extends SeleniumUtils {
    String lnkCAPInstitutional = "//div[contains(text(),'CAP Institutional')]";
    String tabCAPInstitutional = "(//div[contains(text(),'CAP Institutional')])[2]";


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
}
