package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClaimDetailsPage extends SeleniumUtils {

    String titleFFSProfessionalPage = "FFS Professional";
    String claimNumber = "//*[@id='pendGrid']//div[3]/div[1]/div[1]/div[2]";
    String actualClaimSummaryTitle = "Claim Summary";


    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void accessFFSProfessionalPage() {
        explicitVisibilityOfWait(driver.findElement(By.xpath(titleFFSProfessionalPage)), 1000);
        clickElement(titleFFSProfessionalPage);
        log.info("User is on FFS Professional page");

        boolean ffsProfessionalPageTitle = getTitle().equals(titleFFSProfessionalPage);
        Assert.assertTrue(ffsProfessionalPageTitle);
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void userClicksOnClaimNumber() {
        clickElement(claimNumber);
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void userNavigatesToClaimSummaryPage() {
        boolean claimSummaryTitle = getTitle().equals(actualClaimSummaryTitle);
        Assert.assertTrue(claimSummaryTitle);
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void userViewsHideOptionBesideClaimSummary(){
        Assert.assertEquals("Hide option is displayed", driver.findElement(By.linkText("Hide")), "Hide");
    }
}
