package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class EditsPage extends SeleniumUtils {

    String eleEditsTab = "//*[@id = 'nav-edits-tab']";
    String eleServiceLevelSubTab = "//*[@id = 'nav-edit-details-tab']";
    String eleClaimLevelSubTab = "//*[@id = 'nav-edit-service-details-tab']";
    String btnFooterSection = "//*[@class='button-padding-left footer']//button";


    //  Scenario: Verify user able to navigate to Edits tab from Global Search and validate the fields
    public void clickOnEditsTab() throws InterruptedException{
        clickElement(eleEditsTab);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToEditsTab(String expTab){
        Assert.assertEquals(expTab, findElementByXpath(eleEditsTab).getText());
    }

    public void verifyUserViewsServiceLevelSubTab(String expSubTab1){
        String actualValue1 = findElementByXpath(eleServiceLevelSubTab).getText().replace("("," ").replace(")","");
        String actualTab1[] = actualValue1.split(" ");
        Assert.assertEquals(expSubTab1, actualTab1[0]+actualTab1[1]+actualTab1[2]);
    }

    public void verifyUserViewsClaimLevelSubTab(String expSubTab2){
        String actualValue2 = findElementByXpath(eleClaimLevelSubTab).getText().replace("("," ").replace(")","");
        String actualTab2[] = actualValue2.split(" ");
        Assert.assertEquals(expSubTab2, actualTab2[0]+actualTab2[1]+actualTab2[2]);
    }

    public void userViewsFooterSectionInEditsPage(DataTable footerSection){
        List<String> footerSectionExp = footerSection.asList();
        List<WebElement> ActFooterSection = findElementsByXpath(btnFooterSection);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFooterSection.size());
        for (WebElement column : ActFooterSection) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Footer section should display:" + fieldsForCompare);
        System.out.println("Expected fields are : " + footerSectionExp);
        for (String exp : footerSectionExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }
}
