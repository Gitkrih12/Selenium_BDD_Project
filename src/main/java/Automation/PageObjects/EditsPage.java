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
    String lstServiceLevelEdits = "//*[@id = 'nav-serviceleveledits-details']//span[@ref='eText']";
    String lstClaimLevelEdits = "//*[@id = 'nav-claimleveledits-details']//span[@ref='eText']";
    String btnDelete = "//button[@title = 'Delete']/img";
    String btnEdit = "//button[@title = 'Edit']/img";
    String lstClaimLevelEditsFieldValues = "//*[@id = 'nav-claimleveledits-details']//span[@class = 'ag-cell-value' and text()]";
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String lstServiceLevelEditsFieldValues = "(//*[@id = 'nav-serviceleveledits-details']//span[@class = 'ag-cell-value']//span)[1] | (//*[@id = 'nav-serviceleveledits-details']//span[@class = 'ag-cell-value' and text()])";

    private static String expClaimNumber = "";

    //  Scenario: Verify user able to navigate to Edits tab from Global Search and validate the fields
    public void clickOnEditsTab() {
        explicitElementClickableWaitByXpath(tabEdits, 20);
        clickElement(tabEdits);
        explicitElementClickableWaitByXpath(tabEdits, 30);
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
        scrollToElementsAndCompare2Lists(footerSection, btnFooterSection);
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

    public void clickOnClaimNumber() throws InterruptedException {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleClaimNumber), 20, expClaimNumber);
        clickElement(eleClaimNumber);
        threadSleep(1000);
    }

    public void userViewsServiceLevelEditsFields(DataTable columnFields) {
        explicitVisibilityOfElementLocatedWaitByXpath(lstServiceLevelEdits, 40);
        scrollToElementsAndCompare2Lists(columnFields, lstServiceLevelEdits);
    }

    public void verifyFieldValuesUnderServiceLevelEditsTab(){
        scrollToElementsAndValidateDisplayStatus(lstServiceLevelEditsFieldValues);
    }

    //  Scenario: Verify Edit & Delete functionality in Service Level Edits Sub tab
    public void userViewsDeleteButton() {
        List<WebElement> deleteExp = findElementsByXpath(btnDelete);
        for (WebElement button : deleteExp) {
            if (button.isEnabled()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(button + "delete buttons are not displayed");
            }
        }
    }

    public void userViewsEditButton() {
        List<WebElement> editExp = findElementsByXpath(btnEdit);
        for (WebElement button : editExp) {
            if (button.isEnabled()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(button + "edit buttons are not displayed");
            }
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

    public void verifyFieldValuesUnderClaimLevelEditsTab(){
        scrollToElementsAndValidateDisplayStatus(lstClaimLevelEditsFieldValues);
    }
}