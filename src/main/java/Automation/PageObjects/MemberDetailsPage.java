package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.bs.A;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.sql.ClientInfoStatus;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
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
    String tabMOOP = "//*[@id = 'nav-moop-details-tab']";
    String lstMoopFields = "(//*[contains(@class, 'ag-theme-alpine')])[7]//span[@ref = 'eText']";
    String tabInstructions = "//*[@id = 'nav-adjudicatorInstructions-details-tab']";
    String lstInstructionFields = "//*[@id = 'nav-adjudicatorInstructions-details']//span[@ref = 'eText']";
    String tabHospice = "//*[@id = 'nav-hospice-details-tab']";
    String lstHospiceFields = "//*[@id = 'nav-hospice-details']//span[@ref = 'eText']";
    String lstMemberInfoFieldValues = "//app-memberdetails//td";
    String lstProviderDetailValues = "//*[@id='nav-providerDetails-details']//span[@class = 'ag-cell-value']";
    String lstAddressValues = "(//*[@id='nav-address-details']//div[contains(@class, 'ag-row-first')])[2]//span";
    String lnkGlobalSearch = "(//div[contains(text(),'Global Search')])[1]";
    String inputClaimNumber = "//input[@aria-label='Claim Number Filter Input']";
    String eleClaimNumber = "(//div[@class='ag-pinned-left-cols-container']//a)[1]";
    String lstMemberShipInfoValues = "(//*[@class='grid-membership']//div[@ref='eBodyViewport'])[1]//div[@role = 'gridcell']";
    String lstMemberShipHistoryValues = "(//*[@class='grid-membership']//div[@ref='eBodyViewport'])[2]//div[@role = 'gridcell']";

    private static String expMemberInfoTab = "";
    private static String expClaimNumber = "";


    //  Scenario: Verify user should navigates to Member Details screen on clicking Patient ID/MBR ID
    public void userClicksOnPatientID() throws InterruptedException {
        clickElement(lnkPatientID);
        threadSleep(2000);
    }

    public void verifyMemberInfoPage() {
        String actValue[] = findElementByXpath(tabMemberInfoPage).getText().split(" ");
        expMemberInfoTab = prop.getProperty("expMemberInfoScreen");
        Assert.assertEquals(expMemberInfoTab, actValue[0] + actValue[1]);
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

    public void verifyFieldValuesUnderMemberDetails(){
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Member ID", "2193336VF");
        testValues.put("Member Name", "BKVVSW NOBNVSW");
        testValues.put("Date of Birth", "05/12/1931");
        testValues.put("MBR Phone", "(348) 314-7366");
        testValues.put("Gender", "Female");
        testValues.put("Age", "91");
        testValues.put("Plan-Subgroup", "Valor Health Plan-H1119-001 Valor Health Plan 001");
        testValues.put("County", "UBKDC");
        testValues.put("Eff.Date", "10/01/2020");
        testValues.put("ELIG", "12/31/2020");
        testValues.put("Provider ID", "1467896100");
        testValues.put("PCP", "-");
        testValues.put("PCP Phone", "-");
        testValues.put("Address", "GC NB XEB XYOQSZ 7076");
        testValues.put("City", "XYVVSCCKW");
        testValues.put("State", "OH");
        testValues.put("Phone", "-");
        testValues.put("Cell", "-");
        testValues.put("Email", "-");
        testValues.put("ZIP", "07977");
        testValues.put("Group/Plan", "Valor Health Plan");
        testValues.put("Eff.Date1", "10/01/2020");
        testValues.put("MBI", "15WB2EA43M9");
        testValues.put("Status", "InActive");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Member ID", "");
        uatValues.put("Member Name", "");
        uatValues.put("Date of Birth", "");
        uatValues.put("MBR Phone", "");
        uatValues.put("Gender", "");
        uatValues.put("Age", "");
        uatValues.put("Plan-Subgroup", "");
        uatValues.put("County", "-");
        uatValues.put("Eff.Date", "-");
        uatValues.put("ELIG", "");
        uatValues.put("Provider ID", "");
        uatValues.put("PCP", "");
        uatValues.put("PCP Phone", "");
        uatValues.put("Address", "");
        uatValues.put("City", "");
        uatValues.put("State", "");
        uatValues.put("Phone", "");
        uatValues.put("Cell", "");
        uatValues.put("Email", "-");
        uatValues.put("ZIP", "");
        uatValues.put("Group/Plan", "");
        uatValues.put("Eff.Date1", "");
        uatValues.put("MBI", "");
        uatValues.put("Status", "-");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstMemberInfoFieldValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue1 = 5;
            int expValue2 = 2;
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "-"));
            Assert.assertEquals(expValue2, Collections.frequency(ActValues, "10/01/2020"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstMemberInfoFieldValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
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

    public void verifyFieldValuesUnderProviderDetails(){
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Physician Name", "-");
        testValues.put("NPI", "-");
        testValues.put("Address", "-");
        testValues.put("Provider ID", "1467896100");
        testValues.put("PCP", "YES");
        testValues.put("Eff From", "10/01/2020");
        testValues.put("Eff To", "12/31/9999");
        testValues.put("Phone", "-");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Physician Name", "");
        uatValues.put("NPI", "");
        uatValues.put("Address", "");
        uatValues.put("Provider ID", "");
        uatValues.put("PCP", "");
        uatValues.put("Eff From", "");
        uatValues.put("Eff To", "");
        uatValues.put("Phone", "");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstProviderDetailValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 4;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "-"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<WebElement> ActColumnFields = findElementsByXpath(lstProviderDetailValues);
            List<String> columnFieldsForCompare = new ArrayList<>();
            System.out.println("Size " + ActColumnFields.size());
            for (WebElement column : ActColumnFields) {
                scrollIntoView(column, driver);
                String text = column.getText();
                columnFieldsForCompare.add(text);
            }
            for (String exp : fieldsExp) {
                if (columnFieldsForCompare.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
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

    public void verifyFieldValuesUnderAddress(){
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Address Type", "Residential");
        testValues.put("Address1", "DC UBKZ 048");
        testValues.put("Address2", "-");
        testValues.put("City", "OBBKFKX");
        testValues.put("State", "OH");
        testValues.put("ZIP Code", "59977");
        testValues.put("Phone", "(348) 314-7366");
        testValues.put("Fax", "");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Address Type", "");
        uatValues.put("Address1", "");
        uatValues.put("Address2", "");
        uatValues.put("City", "");
        uatValues.put("State", "");
        uatValues.put("ZIP Code", "");
        uatValues.put("Phone", "");
        uatValues.put("Fax", "");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstAddressValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<WebElement> ActColumnFields = findElementsByXpath(lstAddressValues);
            List<String> columnFieldsForCompare = new ArrayList<>();
            System.out.println("Size " + ActColumnFields.size());
            for (WebElement column : ActColumnFields) {
                scrollIntoView(column, driver);
                String text = column.getText();
                columnFieldsForCompare.add(text);
            }
            for (String exp : fieldsExp) {
                if (columnFieldsForCompare.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    //  Scenario: Verify user should navigate to Membership Information tab in Member Details page
    public void clickOnGlobalSearch() {
        explicitVisibilityOfWait(findElementByXpath(lnkGlobalSearch), 5);
        clickElement(lnkGlobalSearch);
    }

    public void enterClaimNumberInSearchField() throws InterruptedException {
        threadSleep(1000);
        expClaimNumber = prop.getProperty("membershipClaimNumber");
        findElementAndSendKeys(findElementByXpath(inputClaimNumber), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(inputClaimNumber);
    }

    public void clickOnClaimNumber() throws InterruptedException{
        explicitVisibilityOfWait(findElementByXpath(eleClaimNumber), 5);
        clickElement(eleClaimNumber);
        threadSleep(1000);
    }

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

    public void verifyFieldValuesUnderMembershipInformation(){
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Member ID", "5453336VF");
        testValues.put("Last Name", "OVYM");
        testValues.put("First Name", "KXXYN");
        testValues.put("Middle Name", "T");
        testValues.put("Relationship", "Self");
        testValues.put("Policy Number", "370RW53O9XD8");
        testValues.put("Payer Name", "Valor Health Plan");
        testValues.put("Plan Name", "Valor Health Plan");
        testValues.put("Plan Eff.Date", "03/01/2019");
        testValues.put("PCP Name", "");
        testValues.put("Plan Term Date", "12/31/9999");
        testValues.put("Address", "DOOBDC CELWEVYM RDEYC 447, DOCBOWYC, OH 61067");
        testValues.put("Phone", "(752) 567-0370");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Member ID", "");
        uatValues.put("Last Name", "");
        uatValues.put("First Name", "");
        uatValues.put("Middle Name", "");
        uatValues.put("Relationship", "");
        uatValues.put("Policy Number", "");
        uatValues.put("Payer Name", "");
        uatValues.put("Plan Name", "");
        uatValues.put("Plan Eff.Date", "");
        uatValues.put("PCP Name", "");
        uatValues.put("Plan Term Date", "");
        uatValues.put("Address", "");
        uatValues.put("Phone", "");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstMemberShipInfoValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "Valor Health Plan"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<WebElement> ActColumnFields = findElementsByXpath(lstMemberShipInfoValues);
            List<String> columnFieldsForCompare = new ArrayList<>();
            System.out.println("Size " + ActColumnFields.size());
            for (WebElement column : ActColumnFields) {
                scrollIntoView(column, driver);
                String text = column.getText();
                columnFieldsForCompare.add(text);
            }
            for (String exp : fieldsExp) {
                if (columnFieldsForCompare.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
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

    public void verifyFieldValuesUnderMembershipHistory(){
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Member ID", "2193336VF");
        testValues.put("Last Name", "BKVVSW");
        testValues.put("First Name", "NOBNVSW");
        testValues.put("Middle Name", "S");
        testValues.put("Relationship", "Self");
        testValues.put("Policy Number", "315WB2EA43M9");
        testValues.put("Payer Name", "Valor Health Plan");
        testValues.put("Plan Name", "Valor Health Plan");
        testValues.put("Plan Eff.Date", "10/01/2020");
        testValues.put("PCP Name", "");
        testValues.put("Plan Term Date", "12/31/2020");
        testValues.put("Address", "DC UBKZ 048, OBBKFKX, OH 59977");
        testValues.put("Phone", "(348) 314-7366");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Member ID", "");
        uatValues.put("Last Name", "");
        uatValues.put("First Name", "");
        uatValues.put("Middle Name", "");
        uatValues.put("Relationship", "");
        uatValues.put("Policy Number", "");
        uatValues.put("Payer Name", "");
        uatValues.put("Plan Name", "");
        uatValues.put("Plan Eff.Date", "");
        uatValues.put("PCP Name", "");
        uatValues.put("Plan Term Date", "");
        uatValues.put("Address", "");
        uatValues.put("Phone", "");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstMemberShipHistoryValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "Valor Health Plan"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<WebElement> ActColumnFields = findElementsByXpath(lstMemberShipHistoryValues);
            List<String> columnFieldsForCompare = new ArrayList<>();
            System.out.println("Size " + ActColumnFields.size());
            for (WebElement column : ActColumnFields) {
                scrollIntoView(column, driver);
                String text = column.getText();
                columnFieldsForCompare.add(text);
            }
            for (String exp : fieldsExp) {
                if (columnFieldsForCompare.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
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

    public void userClicksOnMOOPSubtab() throws InterruptedException {
        clickElement(tabMOOP);
        threadSleep(1000);
    }

    public void userNavigatesToMOOPSubtab(String expSubtab){
        Assert.assertEquals(expSubtab, findElementByXpath(tabMOOP).getText());
    }

    public void verifyFieldsUnderMOOPSubtab(DataTable expFields){
        List<String> fieldsExp = expFields.asList();
        List<String> ActFields = findElementsByXpath(lstMoopFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size :" + ActFields.size());
        System.out.println("Moop Fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    public void userClicksOnInstructionsSubtab() throws InterruptedException {
        clickElement(tabInstructions);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToInstructions(String expSubtab){
        Assert.assertEquals(expSubtab, findElementByXpath(tabInstructions).getText());
    }

    public void verifyColumnsUnderInstructions(DataTable expColumns) {
        List<String> fieldsExp = expColumns.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstInstructionFields);
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

    public void userClicksOnHospiceSubtab() throws InterruptedException {
        clickElement(tabHospice);
        threadSleep(1000);
    }

    public void userNavigatesToHospiceSubtab(String expSubtab){
        Assert.assertEquals(expSubtab, findElementByXpath(tabHospice).getText());
    }

    public void verifyFieldsUnderHospice(DataTable expFields){
        List<String> fieldsExp = expFields.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(lstHospiceFields);
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