package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class MemberDetailsPage extends SeleniumUtils {


    String lnkPatientID = "//*[@class='subscribeid']/a";
    String tabMemberInfoPage = "//*[contains(@class,'active-tab')]";
    String lstMemberInfoFields = "//app-memberdetails//th";
    String tabsList = "//*[@class = 'nav nav-tabs']/button";
    String tabProviderDetails = "//*[@class= 'nav-link active']";
    String lstProviderDetails = "//*[@id='nav-providerDetails-details']//span[@ref = 'eText']";


    //  Scenario: Verify user should navigates to Member Information screen on clicking Patient ID/MBR ID
    public void userClicksOnPatientID() throws InterruptedException {
        clickElement(lnkPatientID);
        threadSleep(1000);
    }

    public void verifyMemberInfoPage(){
        String actValue[] = findElementByXpath(tabMemberInfoPage).getText().split(" ");
        Assert.assertEquals("Member-#2973336VF", actValue[0] + actValue[1]);
    }

    //  Scenario: Verify fields in the Member Information page
    public void userViewsFields(DataTable expFields){
        List<String> fieldsExp = expFields.asList();
        List<String> ActFields = findElementsByXpath(lstMemberInfoFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Member Info Fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify Member Information tabs
    public void userViewsTheTabs(DataTable expTabs){
        List<String> fieldsExp = expTabs.asList();
        List<String> ActFields = findElementsByXpath(tabsList)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("All the tabs should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    public void userNavigatesDefaultToProviderDetails(String expValue){
        String actualValue = findElementByXpath(tabProviderDetails).getAttribute("class");
        if (actualValue.contains(expValue)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void userViewsFieldsUnderProviderDetails(DataTable expFields){
        List<String> fieldsExp = expFields.asList();
        List<String> ActFields = findElementsByXpath(lstProviderDetails)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("All the tabs should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }
}