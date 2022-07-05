package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class ClaimDetailsPage extends SeleniumUtils {

    String FFSProfessional = "//*[contains(text(), 'FFS Professional')]";
    String claimNumber = "//*[@id='pendGrid']//div[3]/div[1]/div[1]/div[2]";
    String claimSummaryTitle = "//*[contains(text(), 'Claim Summary')]";
    String hideOption = "//*[contains(text(), '(Hide)')]";
    String viewClaimButton = "//*[contains(text(), 'View Claim in CMS 1500')]";
    String selfAssignButton = "//*[contains(text(), 'Self-Assign')]";


    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void accessFFSProfessionalPage() {
        explicitVisibilityOfWait(driver.findElement(By.xpath(FFSProfessional)), 1000);
        clickElement(FFSProfessional);
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void userClicksOnClaimNumber() {
        clickElement(claimNumber);
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void userNavigatesToClaimSummaryPage() {
        explicitVisibilityOfWait(driver.findElement(By.xpath(claimSummaryTitle)), 1000);
        Assert.assertEquals("Claim Summary page is displayed", driver.findElement(
                By.xpath(claimSummaryTitle)).getText(), "Claim Summary");
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void userViewsHideOptionBesideClaimSummary(){
        explicitVisibilityOfWait(driver.findElement(By.xpath(hideOption)), 1000);
        Assert.assertEquals("Hide option is displayed", driver.findElement(By.xpath(hideOption)).getText(), "(Hide)");
    }

    //  Scenario: Verify View Claim in CMS 1500 and Self Assign buttons in Claim Summary details page
    public void userViewsSelfAssignAndCMSButtons(){
        explicitVisibilityOfWait(driver.findElement(By.xpath(viewClaimButton)),1000);
        Assert.assertEquals("View Claim in CMS 1500 button should display", driver.findElement(
                By.xpath(viewClaimButton)).getText(), "View Claim in CMS 1500");
        Assert.assertEquals("Self-Assign button should display", driver.findElement(
                By.xpath(selfAssignButton)).getText(), "Self-Assign");
    }

    public void userViewsAllColumnFieldsInClaimSummaryDetails(){

    }
}