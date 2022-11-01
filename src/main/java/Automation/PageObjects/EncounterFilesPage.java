package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;

public class EncounterFilesPage extends SeleniumUtils {

    String mnuFileManagement = "//div[contains(text(),'File Management')]";
    String mnuEncounterFiles = "(//div[contains(text(),'Encounter Files')])[1]";
    String tabEncounterFiles = "(//div[contains(text(),'Encounter Files')])[2]";
    String lstEncounterFilesColumnFields = "//div[@id='encounterFilesGrid']//span[@class='ag-header-cell-text']";
    String lstEncounterFilesColumnSearchFields = "//div[@id='encounterFilesGrid']//span[@class='ag-header-cell-text']//following::input[@type='text']";
    String lblEncounterFiles = "//h6[contains(text(),'Encounter Files')]";
    String btnGenerateEncounterFile = "//button[contains(text(),'Generate Encounter File')]";
    String txtEncounterFileName = "//div[@id='encounterFilesGrid']//input[@aria-label='File Name Filter Input']";
    String txtEncounterSender = "//div[@id='encounterFilesGrid']//input[@aria-label='Sender Filter Input']";
    String txtEncounterReceiver = "//div[@id='encounterFilesGrid']//input[@aria-label='Receiver Filter Input']";
    String txtEncounterDateReceived = "//div[@id='encounterFilesGrid']//input[@aria-label='Date Recieved Filter Input']";
    String txtEncounterAgeDays = "//div[@id='encounterFilesGrid']//input[@aria-label='Age(Days) Filter Input']";
    String txtEncounterClaimType = "//div[@id='encounterFilesGrid']//input[@aria-label='Claim Type Filter Input']";
    String eleEncounterFileName = "(//div[@id='encounterFilesGrid']//div[@col-id='fileName']//span[@class='ag-cell-value'])[1]";
    String eleEncounterSender = "(//div[@id='encounterFilesGrid']//div[@col-id='sender']//span[@class='ag-cell-value'])[1]";
    String eleEncounterReceiver = "(//div[@id='encounterFilesGrid']//div[@col-id='receiver']//span[@class='ag-cell-value'])[1]";
    String eleEncounterDateReceived = "(//div[@id='encounterFilesGrid']//div[@col-id='dateReceived']//span[@class='ag-cell-value'])[1]";
    String eleEncounterAgeDays = "(//div[@id='encounterFilesGrid']//div[@col-id='ageInDays']//span[@class='ag-cell-value'])[1]";
    String eleEncounterClaimType = "(//div[@id='encounterFilesGrid']//div[@col-id='claimType']//span[@class='ag-cell-value'])[1]";

    private static String encounterFileNameRecordExp;
    private static String encounterSenderRecordExp;
    private static String encounterReceiverRecordExp;
    private static String encounterDateReceivedRecordExp;
    private static String encounterAgeDaysRecordExp;
    private static String encounterClaimTypeRecordExp;


    //    Scenario:Verify user should navigate to Encounter Files
    public void clickOnEncounterFilesMenu()
    {
        clickElement(mnuFileManagement);
        moveToElement(mnuEncounterFiles).perform();
        clickElement(mnuEncounterFiles);
    }
    public void verifyUserNavigatedToEncounterFilesPage(String encounterFilesExp)
    {
        explicitVisibilityOfElementLocatedWaitByXpath(tabEncounterFiles, 10).click();
        String encounterFilesAct = getText(lblEncounterFiles);
        System.out.println("Encounter files actual text is: " + encounterFilesAct);
        Assert.assertEquals(encounterFilesExp, encounterFilesAct);
    }

    //    Scenario: Verify column fields in Encounter files page
    public void verifyColumnFieldsUnderEncounterFilesTab(DataTable encounterFilesColumnFields)
    {
        compare2Lists(encounterFilesColumnFields, lstEncounterFilesColumnFields);
    }

    //    Scenario: Verify Search Box should display below on each column in Encounter files
    public void validateEncounterFilesColumnFieldsSearchBoxes()
    {
        elementsDisplayValidation(lstEncounterFilesColumnSearchFields);
    }

    //    Scenario: Verify user should be able to see 'Generated Encounter File' button in Encounter Files Page
    public void verifyUserShouldBeAbleToViewGenerateEncounterFileButton()
    {
        boolean status = isDisplayed(btnGenerateEncounterFile);
        System.out.println(ANSI_GREEN + "Generate Encounter File button status is: " + status + ANSI_RESET);
        Assert.assertTrue(status);
    }

    //    Scenario: Verify user should be able to get results for applying filter on "File Name" column under Encounter files tab
    public void enterFileNameRecordUnderEncounterFileNameSearchBox()
    {
        encounterFileNameRecordExp = prop.getProperty("encounterFileNameSearchRecord");
        explicitElementClickableWaitByXpath(txtEncounterFileName, 10).sendKeys(encounterFileNameRecordExp);
    }
    public void verifyUserAbleToViewEncounterFileNameRecordsUnderResultsSection()
    {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleEncounterFileName), 10, encounterFileNameRecordExp);
        String encounteredFileNameRecordAct = getText(eleEncounterFileName);
        printStatementInGreenColor("Encounter file name actual record", encounteredFileNameRecordAct);
        printStatementInGreenColor("Encounter file name expected record", encounterFileNameRecordExp);
        Assert.assertEquals(encounterFileNameRecordExp, encounteredFileNameRecordAct);
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Sender" column under Encounter files tab
    public void enterSenderNameUnderEncounterSenderSearchBox()
    {
        encounterSenderRecordExp = prop.getProperty("encounterSenderName");
        explicitElementClickableWaitByXpath(txtEncounterSender, 10).sendKeys(encounterSenderRecordExp);
    }
    public void verifyUserAbleToViewEncounterSenderNameUnderResultsSection()
    {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleEncounterSender), 10, encounterSenderRecordExp);
        String encounteredFileNameRecordAct = getText(eleEncounterSender);
        printStatementInGreenColor("Encounter sender name actual record", encounteredFileNameRecordAct);
        printStatementInGreenColor("Encounter sender name expected record", encounterSenderRecordExp);

        Assert.assertEquals(encounterSenderRecordExp, encounteredFileNameRecordAct);
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Receiver" column under Encounter files tab
    public void enterReceiverNameUnderEncounterSenderSearchBox()
    {
        encounterReceiverRecordExp = prop.getProperty("encounterReceiverName");
        explicitElementClickableWaitByXpath(txtEncounterReceiver, 10).sendKeys(encounterReceiverRecordExp);
    }
    public void verifyUserAbleToViewEncounterReceiverNameUnderResultsSection()
    {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleEncounterReceiver), 10, encounterReceiverRecordExp);
        String encounteredReceiverRecordAct = getText(eleEncounterReceiver);
        printStatementInGreenColor("Encounter sender name actual record", encounteredReceiverRecordAct);
        printStatementInGreenColor("Encounter sender name expected record", encounterReceiverRecordExp);
        Assert.assertEquals(encounterReceiverRecordExp, encounteredReceiverRecordAct);
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Date Received" column under Encounter files tab
    public void enterReceivedDateUnderEncounterDateReceivedSearchBox()
    {
        encounterDateReceivedRecordExp = prop.getProperty("encounterDateReceived");
        explicitElementClickableWaitByXpath(txtEncounterDateReceived, 10).sendKeys(encounterDateReceivedRecordExp);
    }
    public void verifyUserAbleToViewEncounterReceivedDateUnderResultsSection()
    {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleEncounterDateReceived), 10, encounterDateReceivedRecordExp);
        String encounteredDateReceivedRecordAct = getText(eleEncounterDateReceived);
        printStatementInGreenColor("Encounter received date actual record", encounteredDateReceivedRecordAct);
        printStatementInGreenColor("Encounter received date expected record", encounterDateReceivedRecordExp);
        Assert.assertEquals(encounterDateReceivedRecordExp, encounteredDateReceivedRecordAct);
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Age(Days)" column under Encounter files tab
    public void enterAgeDaysUnderEncounterAgeDaysSearchBox()
    {
        encounterAgeDaysRecordExp = getText(eleEncounterAgeDays);
        explicitElementClickableWaitByXpath(txtEncounterAgeDays, 10).sendKeys(encounterAgeDaysRecordExp);
    }
    public void verifyUserAbleToViewEncounterAgeDaysUnderResultsSection()
    {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleEncounterAgeDays), 10, encounterAgeDaysRecordExp);
        String encounteredAgeDaysRecordAct = getText(eleEncounterAgeDays);
        printStatementInGreenColor("Encounter age days actual record", encounteredAgeDaysRecordAct);
        printStatementInGreenColor("Encounter age days expected record", encounterAgeDaysRecordExp);
        Assert.assertEquals(encounterAgeDaysRecordExp, encounteredAgeDaysRecordAct);
    }

    //    Scenario: Verify user should be able to get results for applying filter on "Claim Type" column under Encounter files tab
    public void enterClaimTypeUnderEncounterClaimTypeSearchBox()
    {
        encounterClaimTypeRecordExp = prop.getProperty("encounterClaimType");
        explicitElementClickableWaitByXpath(txtEncounterClaimType, 10).sendKeys(encounterClaimTypeRecordExp);
    }
    public void verifyUserAbleToViewEncounterClaimTypeUnderResultsSection()
    {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleEncounterClaimType), 10, encounterClaimTypeRecordExp);
        String encounteredClaimTypeRecordAct = getText(eleEncounterClaimType);
        printStatementInGreenColor("Encounter claim type actual record", encounteredClaimTypeRecordAct);
        printStatementInGreenColor("Encounter claim type expected record", encounterClaimTypeRecordExp);
        Assert.assertEquals(encounterClaimTypeRecordExp, encounteredClaimTypeRecordAct);
    }
}
