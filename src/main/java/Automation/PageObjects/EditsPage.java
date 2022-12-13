package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditsPage extends SeleniumUtils {

    String tabEdits = "//*[@id = 'nav-edits-tab']";
    String tabServiceLevel = "//button[contains(text(), 'Service Level Edits')]";
    String tabClaimLevel = "//button[contains(text(), 'Claim Level Edits')]";
    String btnFooterSection = "//*[@class='footer footer-flex']/button";
    String lstServiceLevelEdits = "(//div[@id='nav-serviceleveledits-details']//div[@class='ag-header-cell-label']//span[text()])[not(position()=7)]";
    String lstClaimLevelEdits = "(//div[@id = 'nav-claimleveledits-details']//div[@class='ag-header-cell-label']//span[text()])[not(position()=7)]";
    String btnDeleteServiceLevel = "//*[@id='nav-serviceleveledits-details']//button[@title = 'Delete']/img";
    String btnDeleteClaimLevel = "//*[@id = 'nav-claimleveledits-details']//button[@title = 'Delete']/img";
    String btnEditServiceLevel = "//*[@id='nav-serviceleveledits-details']//button[@title = 'Edit']/img";
    String btnEditClaimLevel = "//*[@id = 'nav-claimleveledits-details']//button[@title = 'Edit']/img";
    String lstClaimLevelEditsFieldValues = "//*[@id = 'nav-claimleveledits-details']//span[@class = 'ag-cell-value' and text()]";
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String lstServiceLevelEditsFieldValues = "(//*[@id = 'nav-serviceleveledits-details']//span[@class = 'ag-cell-value']//span)[1] | (//*[@id = 'nav-serviceleveledits-details']//span[@class = 'ag-cell-value' and text()])";
    String txtServiceLevelEdits = "//*[@id='nav-serviceleveledits-details']//input[@type = 'text']";
    String txtClaimLevelEdits = "//*[@id='nav-claimleveledits-details']//input[@type = 'text']";


    private static String expClaimNumber = "";

    //  Scenario: Verify user able to navigate to Edits tab from Global Search and validate the fields
    public void clickOnEditsTab() {
        explicitElementClickableWaitByXpath(tabEdits, 20);
        clickElement(tabEdits);
//        explicitElementClickableWaitByXpath(tabEdits, 30);
    }

    public void verifyUserNavigatesToEditsTab(String expTab) {
        Assert.assertEquals(expTab, findElementByXpath(tabEdits).getText());
    }

    public void verifyUserViewsServiceLevelSubTab(String expSubTab1) {
        explicitVisibilityOfElementLocatedWaitByXpath(tabServiceLevel, 20);
        String actualValue1 = findElementByXpath(tabServiceLevel).getText().replace("(", " ").replace(")", "");
        String actualTab1[] = actualValue1.split(" ");
        Assert.assertEquals(expSubTab1, actualTab1[0] + " " + actualTab1[1] + " " + actualTab1[2]);
    }

    public void verifyUserViewsClaimLevelSubTab(String expSubTab2) {
        explicitVisibilityOfElementLocatedWaitByXpath(tabClaimLevel, 20);
        String actualValue2 = findElementByXpath(tabClaimLevel).getText().replace("(", " ").replace(")", "");
        String actualTab2[] = actualValue2.split(" ");
        Assert.assertEquals(expSubTab2, actualTab2[0] + " " + actualTab2[1] + " " + actualTab2[2]);
    }

    //  Scenario: Validate buttons functionality of Edits tab
    public void userViewsFooterSectionInEditsPage(DataTable footerSection) {
        explicitElementClickableWaitByXpath(btnFooterSection, 20);
        compare2Lists(footerSection, btnFooterSection);
    }

    //  Scenario: Verify Service Level Edits Sub tab functionality
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void enterClaimNumberInSearchField() throws InterruptedException {
        explicitElementClickableWaitByXpath(inputClaimNumber, 10);
        expClaimNumber = prop.getProperty("editsClaimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void clickOnClaimNumber() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleClaimNumber), 20, expClaimNumber);
        clickElement(eleClaimNumber);
    }

    public void userViewsServiceLevelEditsFields(DataTable columnFields) {
        explicitVisibilityOfElementLocatedWaitByXpath(lstServiceLevelEdits, 40);
        scrollToElementsAndCompare2Lists(columnFields, lstServiceLevelEdits);
    }

    public void verifyFieldValuesUnderServiceLevelEditsTab() {
        scrollToElementsAndValidateDisplayStatus(lstServiceLevelEditsFieldValues);
    }

    public void verifySearchBoxInServiceLevelEdits(){
        scrollToElementsAndValidateDisplayStatus(txtServiceLevelEdits);
    }

    //  Scenario: Verify Edit & Delete functionality in Service Level Edits Sub tab

    public void userViewsDeleteButtonUnderServiceLevelTab(){
        scrollToElement(btnDeleteServiceLevel);
        userViewsDeleteButton(btnDeleteServiceLevel);
    }

    //Generic method to validate delete button
    public void userViewsDeleteButton(String deleteXpath) {
        explicitElementClickableWaitByXpath(deleteXpath, 20);
        WebElement deleteExp = findElementByXpath(deleteXpath);
        if (deleteExp.isDisplayed()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail("delete button is not displayed");
        }
    }

    public void userViewsEditButtonUnderServiceLevelTab(){
        userViewsEditButton(btnEditServiceLevel);
    }

    //Generic method to validate edit button
    public void userViewsEditButton(String editXpath) {
        explicitElementClickableWaitByXpath(editXpath, 20);
        WebElement editExp = findElementByXpath(editXpath);
        if (editExp.isDisplayed()) {
            Assert.assertTrue(true);
        } else {
            Assert.fail(editExp + "edit buttons are not displayed");
        }
    }

    // Scenario: Verify Claim Level Edits Sub-tab
    public void userClicksOnClaimLevelEditsTab() {
        explicitElementClickableWaitByXpath(tabClaimLevel, 20);
        clickElement(tabClaimLevel);
    }

    public void userViewsClaimLevelEditsFields(DataTable editLevelColumnFields) {
        explicitVisibilityOfElementLocatedWaitByXpath(lstClaimLevelEdits, 40);
        scrollToElementsAndCompare2Lists(editLevelColumnFields, lstClaimLevelEdits);
    }

    public void verifyFieldValuesUnderClaimLevelEditsTab() {
        scrollToElementsAndValidateDisplayStatus(lstClaimLevelEditsFieldValues);
    }

    public void verifySearchBoxInClaimLevelEdits(){
        scrollToElementsAndValidateDisplayStatus(txtClaimLevelEdits);
    }

    public void userViewsDeleteButtonUnderClaimLevelTab(){
        userViewsDeleteButton(btnDeleteClaimLevel);
    }

    public void userViewsEditButtonUnderClaimLevelTab(){
        userViewsEditButton(btnEditClaimLevel);
    }
}