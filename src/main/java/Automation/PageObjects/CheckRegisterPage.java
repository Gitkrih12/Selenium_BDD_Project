package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class CheckRegisterPage extends SeleniumUtils {

    String lnkCheckManagement = "//*[contains(text(), 'Check Management')]";
    String lnkCheckRegister = "//*[contains(text(), ' Check Register ')]";
    String titleCheckRegister = "//h5";
    String lstCheckRegister = "//app-check-register//div//span";
    String lstBillingProvider = "(//*[@name = 'ddlplaceofservice'])[1]//option";
    String btnSearch = "//button[contains(text(), 'Search')]";

    private static String expCheckRegisterTab = "";
    private static Random rand = new Random();

    public void userClicksOnCheckRegister() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(lnkCheckManagement), 20);
        clickElement(lnkCheckManagement);
        explicitVisibilityOfWait(findElementByXpath(lnkCheckRegister), 20);
        clickElement(lnkCheckRegister);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToCheckRegister(){
        expCheckRegisterTab = prop.getProperty("checkRegisterTab");
        Assert.assertEquals(expCheckRegisterTab, findElementByXpath(titleCheckRegister).getText());
    }

    public void verifyFieldsUnderCheckRegister(DataTable expFields){
        List<String> checkRegisterFieldsExp = expFields.asList();
        List<WebElement> actFields = findElementsByXpath(lstCheckRegister);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + actFields.size());
        for (WebElement column : actFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Check Register Fields should display :" + fieldsForCompare);
        System.out.println("Expected fields are : " + checkRegisterFieldsExp);
        for (String exp : checkRegisterFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void userSelectsValuesFromBillingProviderDropDown() throws InterruptedException {
        List <String> getAllOptionsFromDropdown = findElementsByXpath(lstBillingProvider)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println(getAllOptionsFromDropdown.get(rand.nextInt(getAllOptionsFromDropdown.size())));
        explicitVisibilityOfWait(findElementByXpath(btnSearch), 20);
        clickElement(btnSearch);
        threadSleep(2000);
    }

    public void verifyTheResultForTheSearchCriteria(){

    }
}