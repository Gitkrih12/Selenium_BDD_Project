package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class EditsPage extends SeleniumUtils {

    String tabEdits = "//*[@id = 'nav-edits-tab']";
    String tabServiceLevel = "//*[@id = 'nav-edit-details-tab']";
    String tabClaimLevel = "//button[contains(text(), 'Claim Level Edits')]";
    String btnFooterSection = "//*[@class='button-padding-left footer']//button";
    String lstServiceLevelEdits = "//app-edits//*[@id = 'resultsGrid']//div//span[@ref='eText']";
    String lstClaimLevelEdits = "//app-edits//*[@id = 'resultsGrid']//div//span[@ref='eText']";
    String btnDelete = "//button[@title = 'Delete']/img";
    String btnEdit = "//button[@title = 'Edit']/img";
    String lnkInvertedExclamatory = "(//i[@class='bi bi-info-circle'])[1]";


    //  Scenario: Verify user able to navigate to Edits tab from Global Search and validate the fields
    public void clickOnEditsTab() throws InterruptedException{
        clickElement(tabEdits);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToEditsTab(String expTab){
        Assert.assertEquals(expTab, findElementByXpath(tabEdits).getText());
    }

    public void verifyUserViewsServiceLevelSubTab(String expSubTab1){
        String actualValue1 = findElementByXpath(tabServiceLevel).getText().replace("("," ").replace(")","");
        String actualTab1[] = actualValue1.split(" ");
        Assert.assertEquals(expSubTab1, actualTab1[0]+actualTab1[1]+actualTab1[2]);
    }

    public void verifyUserViewsClaimLevelSubTab(String expSubTab2){
        String actualValue2 = findElementByXpath(tabClaimLevel).getText().replace("("," ").replace(")","");
        String actualTab2[] = actualValue2.split(" ");
        Assert.assertEquals(expSubTab2, actualTab2[0]+actualTab2[1]+actualTab2[2]);
    }

    //  Scenario: Validate buttons functionality of Edits tab
    public void userViewsFooterSectionInEditsPage(DataTable footerSection){
        List<String> fieldsExp = footerSection.asList();
        List<String> ActFields = findElementsByXpath(btnFooterSection)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify Service Level Edits Sub tab functionality
    public void userViewsServiceLevelEditsTab(DataTable columnFields){
        List<String> fieldsExp = columnFields.asList();
        List<String> ActFields = findElementsByXpath(lstServiceLevelEdits)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Service Level Edit fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify Edit & Delete functionality in Service Level Edits Sub tab
    public void userViewsDeleteButton(){
        List<WebElement> deleteExp = findElementsByXpath(btnDelete);
        for(WebElement button : deleteExp){
            if(button.isEnabled()){
                Assert.assertTrue(true);
            }
            else {
                Assert.fail(button + "delete buttons are not displayed");
            }
        }
    }

    public void userViewsEditButton(){
        List<WebElement> editExp = findElementsByXpath(btnEdit);
        for(WebElement button : editExp){
            if(button.isEnabled()){
                Assert.assertTrue(true);
            }
            else {
                Assert.fail(button + "edit buttons are not displayed");
            }
        }
    }

    // Scenario: Verify Claim Level Edits Sub-tab
    public void userClicksOnClaimLevelEditsTab() throws InterruptedException{
        clickElement(tabClaimLevel);
        threadSleep(1000);
    }

    public void userViewsClaimLevelEditsTab(DataTable editLevelColumnFields){
        List<String> fieldsExp = editLevelColumnFields.asList();
        List<String> ActFields = findElementsByXpath(lstClaimLevelEdits)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Claim Level Edit fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }
}