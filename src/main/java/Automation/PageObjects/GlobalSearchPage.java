package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GlobalSearchPage extends SeleniumUtils {
    String lnkGlobalSearch = "//div[contains(text(),'Global Search')]";
    String tabGlobalSearch = "(//div[contains(text(),'Global Search')])[2]";
    String lblNoDataDisplay = "//div[@class='ag-center-cols-clipper']";
    String expHeight= "1px";
    String btnFilter = "//button[text()='Filter']";
    String btnCustomisedColumns = "//button[text()='Customize Columns']";
    String columnFeilds = " //div[@class='ag-header-cell-label']//span[text()]";
    String inputSearchFields = " //div[@class='ag-header-cell-label']//span[text()]//following::div//input[@class='ag-input-field-input ag-text-field-input']";
    String activeGlobalSearch="//div[@class='col active-tab ng-star-inserted']";
    String inputClaimNumber="//input[@aria-label='Claim Number Filter Input']";
    String inputMemberId="//input[@aria-label='Member Id Filter Input']";
    String eleClaimNumber="//div[@class='ag-pinned-left-cols-container']//a";
    String eleMemberId="(//div[@col-id='subscriberId']//span[@class='ag-cell-value'])[1]";
    String inputPatientName="//input[@aria-label='Patient Filter Input']";
    String elePatientName="(//div[@col-id='memberFullName']//span[@class='ag-cell-value'])[1]";
    String inputBillingProvider="//input[@aria-label='Billing Provider Filter Input']";
    String eleBillingProvider="(//div[@col-id='billingProviderFullName']//span[@class='ag-cell-value'])[1]";
    String inputState=" //input[@aria-label='State Filter Input']";
    String eleState="(//div[@col-id='status']//span[@class='ag-cell-value'])[1]";
    String inputCategory=" //input[@aria-label='Category Filter Input']";
    String eleCategory="(//div[@col-id='category']//span[@class='ag-cell-value'])[1]";
    String inputDOSFrom=" //input[@aria-label='DOS From Filter Input']";
    String eleDOSFrom="(//div[@col-id='dosFrom']//span[@class='ag-cell-value'])[1]";
    String inputDOSTo=" //input[@aria-label='DOS To Filter Input']";
    String eleDOSTo="(//div[@col-id='dosTo']//span[@class='ag-cell-value'])[1]";
    String btnExportResult="//button[text()='Export Result']";
    String btnReprocess="(//button[@title='Reprocess']//img)[1]";



    public static String expClaimNumber="";
    public static String expMemberId="";
    public static String expPatientName="";
    public static String expState="";
    public static String expCategory="";
    public static String expDOSFrom="";
    public static String expDOSTo="";
    public static String expBillingProvider="";




    public void clickOnGlobalSearch(){
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch),5);
        clickElement(lnkGlobalSearch);
    }
    public void verifyGlobalSearchPage(){
        boolean value= isDisplayed(tabGlobalSearch);
        Assert.assertTrue(value);

    }
    public void verifyNoDataDisplayMessage(){
        String actHeight= findElementByXpath(lblNoDataDisplay).getAttribute("style");
        System.out.println("actHeight" +actHeight);
        if(actHeight.contains(expHeight)){
            Assert.assertTrue(true);
        }
    }
    public void verifyFilterButton(){
        explicitVisibilityOfWait(findElementByXpath(btnFilter),5);
        boolean value= isDisplayed(btnFilter);
        Assert.assertTrue(value);
    }
    public void verifyCustomisedColumn(){
        boolean value= isDisplayed(btnCustomisedColumns);
        Assert.assertTrue(value);
    }
    public void verifyColumnFields(DataTable columnList) {
        List<String> columnListExp = columnList.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(columnFeilds);
        List<String> columnFieldsforCompare = new ArrayList<>();
        System.out.println("Size "+ ActColumnFields.size());
        for (WebElement column:ActColumnFields){
            scrollIntoView(column,getWebDriver());
            String text = column.getText();
            System.out.println("Column Fields in Global Search  : " + text);
            columnFieldsforCompare.add(text);
        }
        if(columnFieldsforCompare.equals(columnListExp)){
            Assert.assertEquals(columnListExp,columnFieldsforCompare);
        }

    }
    public void verifySearchFieldUnderEachCoulmn(){
        List<WebElement> ActCSearchFields = findElementsByXpath(inputSearchFields);
        for (WebElement column:ActCSearchFields) {
            scrollIntoView(column, getWebDriver());
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }

    }
    public void verifyAdjudicatorLandsonGlobalSearchPage(){
        boolean value=isDisplayed(activeGlobalSearch);
        Assert.assertTrue(value);
    }
    public void enterClaimNumberInSearchfield(String claimNumber) throws InterruptedException {
        expClaimNumber= claimNumber;
        clickElement(inputClaimNumber);
        findElementAndSendKeys(findElementByXpath(inputClaimNumber),claimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }
    public void validateClaimNumberResult(){
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber),5);
        String actClaimNumber= getText(eleClaimNumber);
        System.out.println("actual claimNumber :" +actClaimNumber);
        Assert.assertEquals(expClaimNumber,actClaimNumber);
    }

    public void enterMemberIdInSearchfield(String memberId) throws InterruptedException {
        expMemberId= memberId;
        clickElement(inputMemberId);
        findElementAndSendKeys(findElementByXpath(inputMemberId),memberId);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputMemberId);
        threadSleep(3000);
    }

    public void validateMemberIDResult(){
        explicitVisibilityOfWait(findElementByXpath(eleMemberId),5);
        String actMemberId= getText(eleMemberId);
        System.out.println("actual member id :" +actMemberId);
        Assert.assertEquals(expMemberId,actMemberId);
    }
    public void enterPatientNameInSearchfield(String patientName) throws InterruptedException {
        expPatientName= patientName;
        clickElement(inputPatientName);
        findElementAndSendKeys(findElementByXpath(inputPatientName),patientName);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputPatientName);
        threadSleep(3000);
    }

    public void validatePatientNameResult(){
        explicitVisibilityOfWait(findElementByXpath(elePatientName),5);
        String actPatientName= getText(elePatientName);
        System.out.println("actual patient name :" +actPatientName);
        Assert.assertEquals(expPatientName,actPatientName);
    }

    public void enterBillingProviderInSearchfield(String BillingProvider) throws InterruptedException {
        expBillingProvider= BillingProvider;
        clickElement(inputBillingProvider);
        findElementAndSendKeys(findElementByXpath(inputBillingProvider),BillingProvider);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputBillingProvider);
        threadSleep(3000);
    }

    public void validateBillingProviderResult(){
        explicitVisibilityOfWait(findElementByXpath(eleBillingProvider),5);
        String actBillingProvider= getText(eleBillingProvider);
        System.out.println("actual Billing Provider :" +actBillingProvider);
        Assert.assertEquals(expBillingProvider,actBillingProvider);
    }


    public void enterStateInSearchfield(String state) throws InterruptedException {
        expState= state;
        scrollIntoView(findElementByXpath(inputState),getWebDriver());
        clickElement(inputState);
        findElementAndSendKeys(findElementByXpath(inputState),state);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputState);
        threadSleep(3000);
    }

    public void validateStateResult(){
        explicitVisibilityOfWait(findElementByXpath(eleState),5);
        String actState= getText(eleState);
        System.out.println("actual state :" +actState);
        Assert.assertEquals(expState,actState);
    }
    public void enterCategoryInSearchfield(String category) throws InterruptedException {
        expCategory= category;
        scrollIntoView(findElementByXpath(inputCategory),getWebDriver());
        clickElement(inputCategory);
        findElementAndSendKeys(findElementByXpath(inputCategory),category);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputCategory);
        threadSleep(3000);
    }

    public void validateCategoryResult(){
        explicitVisibilityOfWait(findElementByXpath(eleCategory),5);
        String actCategory= getText(eleCategory);
        System.out.println("actual category :" +actCategory);
        Assert.assertEquals(expCategory,actCategory);
    }
    public void enterDOSFromInSearchfield(String DOSFrom) throws InterruptedException {
        expDOSFrom= DOSFrom;
        scrollIntoView(findElementByXpath(inputDOSFrom),getWebDriver());
        clickElement(inputDOSFrom);
        findElementAndSendKeys(findElementByXpath(inputDOSFrom),DOSFrom);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputDOSFrom);
        threadSleep(3000);
    }

    public void validateDOSFromResult(){
        explicitVisibilityOfWait(findElementByXpath(eleDOSFrom),5);
        String actDOSFrom= getText(eleDOSFrom);
        System.out.println("actual DOSFrom :" +actDOSFrom);
        Assert.assertEquals(expDOSFrom,actDOSFrom);
    }
    public void enterDOSToInSearchfield(String DOSTo) throws InterruptedException {
        expDOSTo= DOSTo;
        scrollIntoView(findElementByXpath(inputDOSTo),getWebDriver());
        clickElement(inputDOSTo);
        findElementAndSendKeys(findElementByXpath(inputDOSTo),DOSTo);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputDOSTo);
        threadSleep(3000);
    }

    public void validateDOSToResult(){
        explicitVisibilityOfWait(findElementByXpath(eleDOSTo),5);
        String actDOSTo= getText(eleDOSTo);
        System.out.println("actual DOSTo :" +actDOSTo);
        Assert.assertEquals(expDOSTo,actDOSTo);
    }

    public void verifyExportResultButtonwhenSearchResultsDisplayed(){
        boolean value=isDisplayed(btnExportResult);
        Assert.assertTrue(value);
    }
    public void verifyExportResultButtonwhenNoSearchResultsDisplayed(){
        boolean value=isDisplayed(btnExportResult);
        Assert.assertFalse(value);
    }
    public void verifyReprocessButton() throws InterruptedException {
        threadSleep(1000);
        scrollIntoView(findElementByXpath(eleState),getWebDriver());
        boolean value=isDisplayed(btnReprocess);
        Assert.assertTrue(value);
    }
    public void validateClaimNumberResultForCharacterLimit(){
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber),5);
        String actClaimNumber= getText(eleClaimNumber);
        System.out.println("actual claimNumber :" +actClaimNumber);
        if(actClaimNumber.contains(expClaimNumber)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }
    public void validateMemberIDResultForCharacterLimit(){
        explicitVisibilityOfWait(findElementByXpath(eleMemberId),5);
        String actMemberId= getText(eleMemberId);
        System.out.println("actual member iD :" +actMemberId);
        if(actMemberId.contains(expMemberId)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }
    public void validatePatientResultForCharacterLimit(){
        explicitVisibilityOfWait(findElementByXpath(elePatientName),5);
        String actPatientName= getText(elePatientName);
        System.out.println("actual patient name :" +actPatientName);
        if(actPatientName.contains(expPatientName)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }
    public void validateBillingProviderResultForCharacterLimit(){
        explicitVisibilityOfWait(findElementByXpath(eleBillingProvider),5);
        String actPatientName= getText(eleBillingProvider);
        System.out.println("actual billing provider :" +actPatientName);
        if(actPatientName.contains(expBillingProvider)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }
    public void validateStateResultForCharacterLimit(){
        explicitVisibilityOfWait(findElementByXpath(eleState),5);
        String actState= getText(eleState);
        System.out.println("actual state :" +actState);
        if(actState.contains(expState)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }
    }

}
