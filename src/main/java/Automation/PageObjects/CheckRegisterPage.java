package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
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
    String dropdownBillingProvider = "(//*[@name = 'ddlplaceofservice'])[1]";
    String selectOption = "(//select//option[contains(text(), '$option$')])[1]";
    String txtLoading = "//*[contains(text(), 'Loading...')]";
    String txtBillProv = "(//*[@col-id='billProv']//span[@class = 'ag-cell-value'])[1]";
    String dropdownFacility = "(//*[@name = 'ddlplaceofservice'])[3]";
    String lstFacility = "(//*[@name = 'ddlplaceofservice'])[3]//option";
    String txtCreatedFromDate = "//*[@id = 'fromDate']";
    String txtCreatedToDate = "//*[@id = 'toDate']";
    String txtPayToId = "(//*[@col-id='patID']//span[@class = 'ag-cell-value'])[1]";
    String txtDateOfServiceFromField = "//*[@id = 'fromDOS']";
    String txtDateOfServiceToField = "//*[@id = 'toDOS']";
    String dropdownState = "(//*[@name = 'ddlplaceofservice'])[4]";
    String lstState = "(//*[@name = 'ddlplaceofservice'])[4]//option";
    String dropdownPlaceOfService = "(//*[@name = 'ddlplaceofservice'])[2]";
    String lstPlaceOfService = "(//*[@name = 'ddlplaceofservice'])[2]//option";


    private static String expCheckRegisterTab = "";
    private static Random rand = new Random();
    private static String expFromDate = "";
    private static String expToDate = "";
    private static String expDateOfServiceFromField = "";
    private static String expDateOfServiceToField = "";

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
        explicitVisibilityOfWait(findElementByXpath(dropdownBillingProvider), 10);
        clickElement(dropdownBillingProvider);
        List <String> getAllOptionsFromDropdown = findElementsByXpath(lstBillingProvider)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        String getRandomOption = getAllOptionsFromDropdown.get(rand.nextInt(getAllOptionsFromDropdown.size()));
        System.out.println(getRandomOption);
        clickElement(findElementByXpath(selectOption.replace("$option$", getRandomOption)));
        explicitVisibilityOfWait(findElementByXpath(btnSearch), 20);
        clickElement(btnSearch);
        threadSleep(2000);
    }

    public void verifyTheResultForTheSearchCriteria(){
        String selectedOption = findElementByXpath(dropdownBillingProvider).getText();
        if(selectedOption.equals("Select Billing Provider")){
            findElementByXpath(txtLoading).isDisplayed();
        }
        else {
            Assert.assertTrue(findElementByXpath(txtPayToId).isDisplayed());
        }
    }

    public void userSelectsValuesFromFacilityDropDown() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(dropdownFacility), 10);
        clickElement(dropdownFacility);
        List <String> getAllOptionsFromDropdown = findElementsByXpath(lstFacility)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        String getRandomOption = getAllOptionsFromDropdown.get(rand.nextInt(getAllOptionsFromDropdown.size()));
        System.out.println(getRandomOption);
        clickElement(findElementByXpath(selectOption.replace("$option$", getRandomOption)));
        explicitVisibilityOfWait(findElementByXpath(btnSearch), 20);
        clickElement(btnSearch);
        threadSleep(2000);
    }

    public void verifyTheResultForTheFacilitySearchCriteria(){
        String selectedOption = findElementByXpath(dropdownFacility).getText();
        if(selectedOption.equals("Select Facility")){
            findElementByXpath(txtLoading).isDisplayed();
        }
        else {
            Assert.assertTrue(findElementByXpath(txtPayToId).isDisplayed());
        }
    }

    public void userSelectsValuesFromCreatedDateFromField() throws InterruptedException {
        expFromDate = prop.getProperty("createdFromDate");
        findElementAndSendKeys(findElementByXpath(txtCreatedFromDate), expFromDate);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtCreatedFromDate);
    }

    public void userSelectsValuesFromCreatedDateToField() throws InterruptedException {
        expToDate = prop.getProperty("createdToDate");
        findElementAndSendKeys(findElementByXpath(txtCreatedToDate), expToDate);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtCreatedToDate);
        clickElement(btnSearch);
        threadSleep(2000);
    }

    public void verifyTheResultForTheCreatedDateSearchCriteria() {
        Assert.assertTrue(findElementByXpath(txtPayToId).isDisplayed());
    }

    public void userSelectsValuesFromDateOfServiceFromField() throws InterruptedException {
        expDateOfServiceFromField = prop.getProperty("dateOfServiceFromField");
        findElementAndSendKeys(findElementByXpath(txtDateOfServiceFromField), expDateOfServiceFromField);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtDateOfServiceFromField);
    }

    public void userSelectsValuesFromDateOfServiceToField() throws InterruptedException {
        expDateOfServiceToField = prop.getProperty("dateOfServiceToField");
        findElementAndSendKeys(findElementByXpath(txtDateOfServiceToField), expDateOfServiceToField);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtDateOfServiceToField);
        clickElement(btnSearch);
        threadSleep(5000);
    }

    public void verifyTheResultForTheDateOfServiceSearchCriteria(){
        Assert.assertTrue(findElementByXpath(txtPayToId).isDisplayed());
    }

    public void userSelectsValuesFromStateField() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(dropdownState), 10);
        clickElement(dropdownState);
        List <String> getAllOptionsFromDropdown = findElementsByXpath(lstState)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        String getRandomOption = getAllOptionsFromDropdown.get(rand.nextInt(getAllOptionsFromDropdown.size()));
        System.out.println(getRandomOption);
        clickElement(findElementByXpath(selectOption.replace("$option$", getRandomOption)));
        explicitVisibilityOfWait(findElementByXpath(btnSearch), 20);
        clickElement(btnSearch);
        threadSleep(2000);
    }

    public void verifyTheResultForTheStateSearchCriteria(){
        String selectedOption = findElementByXpath(dropdownState).getText();
        if(selectedOption.equals("Select State")){
            findElementByXpath(txtLoading).isDisplayed();
        }
        else {
            Assert.assertTrue(findElementByXpath(txtPayToId).isDisplayed());
        }
    }

    public void userSelectsValuesFromPlaceOfServiceDropdownField() throws InterruptedException {
        explicitVisibilityOfWait(findElementByXpath(dropdownPlaceOfService), 10);
        clickElement(dropdownPlaceOfService);
        List <String> getAllOptionsFromDropdown = findElementsByXpath(lstPlaceOfService)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        String getRandomOption = getAllOptionsFromDropdown.get(rand.nextInt(getAllOptionsFromDropdown.size()));
        System.out.println(getRandomOption);
        clickElement(findElementByXpath(selectOption.replace("$option$", getRandomOption)));
        explicitVisibilityOfWait(findElementByXpath(btnSearch), 20);
        clickElement(btnSearch);
        threadSleep(4000);
    }

    public void verifyTheResultForThePlaceOfServiceSearchCriteria(){
        String selectedOption = findElementByXpath(dropdownPlaceOfService).getText();
        if(selectedOption.equals("Select Place of Service")){
            findElementByXpath(txtLoading).isDisplayed();
        }
        else {
            Assert.assertTrue(findElementByXpath(txtPayToId).isDisplayed());
        }
    }
}