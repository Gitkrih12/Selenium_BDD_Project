package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MemberDetailsPage extends SeleniumUtils {


    String lnkPatientID = "//*[@class='subscribeid']/a";
    String tabMemberInfoPage = "//*[contains(@class,'active-tab')]";
    String lstMemberInfoFields = "//app-memberdetails//th";
    String tabsList = "//*[@class = 'nav nav-tabs']/button";
    String tabProviderDetails = "//*[@class= 'nav-link active']";
    String lstProviderDetails = "//*[@id='nav-providerDetails-details']//span[@ref = 'eText']";
    String tabAddress = "//*[@id='nav-address-details-tab']";
    String lstAddressColumns = "//*[@id='nav-address-details']//span[@ref = 'eText']";
    String tabMemberShipInformation = "//*[@id='nav-membershipInformation-details-tab']";
    String lstMemberShipInfoFields = "(//*[@class='grid-membership']//div[@class = 'ag-header-container'])[1]//span[@ref = 'eText']";
    String lstMemberShipHistory = "(//*[@class='grid-membership']//div[@class = 'ag-header-container'])[2]//span[@ref = 'eText']";
    String tabClaims = "//*[@id = 'nav-claims-details-tab']";
    String lstClaimsFields = "//*[@id = 'resultsGrid']//span[@ref = 'eText']";
    String txtSearchFields = "//*[@id = 'resultsGrid']//input[@type = 'text']";
    String tabCOB = "//*[@id = 'nav-cob-details-tab']";
    String lstCOBFields = "//*[@id = 'nav-cob-details']//span[@ref = 'eText']";


    //  Scenario: Verify user should navigates to Member Details screen on clicking Patient ID/MBR ID
    public void userClicksOnPatientID() throws InterruptedException {
        clickElement(lnkPatientID);
        threadSleep(1000);
    }

    public void verifyMemberInfoPage() {
        String actValue[] = findElementByXpath(tabMemberInfoPage).getText().split(" ");
        Assert.assertEquals("Member-#2973336VF", actValue[0] + actValue[1]);
    }

    //  Scenario: Verify fields in the Member Details page
    public void userViewsFields(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<String> ActFields = findElementsByXpath(lstMemberInfoFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Member Info Fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify Member Details tabs
    public void userViewsTheTabs(DataTable expTabs) {
        List<String> fieldsExp = expTabs.asList();
        List<String> ActFields = findElementsByXpath(tabsList)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("All the tabs should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    //  Scenario: Verify user should navigate to Provider Details on Clicking Patient ID/MBR ID in View claim Details page
    public void userNavigatesDefaultToProviderDetails(String expValue) {
        String actualValue = findElementByXpath(tabProviderDetails).getAttribute("class");
        if (actualValue.contains(expValue)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    //  Scenario: Verify column fields in Provider Details tab
    public void userViewsFieldsUnderProviderDetails(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstProviderDetails);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("All the tabs should display:" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify user navigates to Address subtab in Member Details page
    public void userClicksOnAddressSubTab() throws InterruptedException {
        clickElement(tabAddress);
        threadSleep(1000);
    }

    public void userNavigatesToAddressSubTab(String expSubTab) {
        Assert.assertEquals(expSubTab, findElementByXpath(tabAddress).getText());
    }

    //  Scenario: Verify column fields in Address sub tab in Member Details page
    public void userViewAddressSubTabColumns(DataTable expColumns) {
        List<String> fieldsExp = expColumns.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstAddressColumns);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("All the columns should display:" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify user should navigate to Membership Information tab in Member Details page
    public void userClicksOnMemberShipInfoSubTab() throws InterruptedException {
        clickElement(tabMemberShipInformation);
        threadSleep(1000);
    }

    public void userNavigatesToMemberShipInformation(String expSubTab) {
        Assert.assertEquals(expSubTab, findElementByXpath(tabMemberShipInformation).getText());
    }

    //  Scenario: Verify column fields in Membership Information tab
    public void userViewMemberShipInfoColumns(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstMemberShipInfoFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("All the columns should display:" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify user should able to see Membership History column fields
    public void userViewMemberShipHistoryColumns(DataTable expMemberShipHistoryColumns) {
        List<String> fieldsExp = expMemberShipHistoryColumns.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstMemberShipHistory);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("All the columns should display:" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify column fields in Claims subtab
    public void userClicksOnClaimsSubTab() {
        clickElement(tabClaims);
    }

    public void userNavigatesToClaimsSubTab(String expClaimsSubTab) {
        Assert.assertEquals(expClaimsSubTab, findElementByXpath(tabClaims).getText());
    }

    public void userViewsAllFieldsUnderClaimsSubTab(DataTable expColumns) {
        List<String> fieldsExp = expColumns.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstClaimsFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("All the columns should display:" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify Search functionality in claims subtab
    public void verifySearchBoxForAllFields() {
        List<WebElement> ActSearchFields = findElementsByXpath(txtSearchFields);
        for (WebElement column : ActSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    public void userClicksOnCOB() throws InterruptedException {
        clickElement(tabCOB);
        threadSleep(1000);
    }

    public void userNavigatesToCOBSubTab(String expSubTab){
        Assert.assertEquals(expSubTab, findElementByXpath(tabCOB).getText());
    }

    public void verifyCOBFields(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstCOBFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("All the columns should display:" + columnFieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }
}