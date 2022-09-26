package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class ClaimDetailsPage extends SeleniumUtils {

    String lnkFFSProfessional = "(//*[contains(text(), 'FFS Professional')])[1]";
    String lnkClaimNumber = "(//div[@class='ag-cell-wrapper']//a)[1]";
    String titleClaimSummary = "//*[contains(text(), 'Claim Summary')]";
    String lnkHideOption = "//*[contains(text(), '(Hide)')]";
    String btnViewClaim = "//*[contains(text(), 'View Claim in CMS 1500')]";
    String btnSelfAssign = "//*[contains(text(), 'Self-Assign')]";
    String columnFields = "//table[@class='table table-borderless']//thead//tr//th";
    String lstClaimSummaryTab = "//button[@id='nav-claim-details-tab']/..//button";
    String btnFooterFields = "//*[@class = 'footer footer-flex']//button";
    String eleClaimDetailsTab = "//button[@class='nav-link active']";
    String eleClaimDetailsSection = "(//*[@id='nav-claim-details'])[1]//h6";
    String claimInformationFields = "(//div[@id='nav-claim-details']//div)[1]//div[text()]";
    String paymentInformationFields = "//*[@id='nav-claim-details']/div[2]/div[1]/div | //*[@id='nav-claim-details']/div[3]/div[1]/div | " +
            "//*[@id='nav-claim-details']/div[4]/div[1]/div";
    String memberInformationFields = "//*[@id='nav-claim-details']/div[5]/div[1]/div | //*[@id='nav-claim-details']/div[6]/div[1]/div | " +
            "//*[@id='nav-claim-details']/div[7]/div[1]/div | //*[@id='nav-claim-details']/div[8]/div[1]/div";
    String renderingProviderInformationFields = "//*[@id='nav-claim-details']/div[9]/div[1]/div";
    String eleCleanStatus = "(//*[@ng-reflect-model = 'true'])[1]";
    String eleUncleanStatus = "(//*[@ng-reflect-model = 'false'])[1]";
    String billingProviderInformationFields = "//*[@id='nav-claim-details']/div[10]/div[1]/div | //*[@id='nav-claim-details']/div[11]" +
            "/div[1]/div | //*[@id='nav-claim-details']/div[12]/div[1]/div";
    String payerFields = "//*[@id='nav-claim-details']/div[13]/div[1]/div | //*[@id='nav-claim-details']/div[14]/div[1]/div";
    String dateOfServiceFields = "//*[@id='nav-claim-details']/div[15]/div[1]/div[1]/div";
    String isPatientConditionRelatedToField = "//*[@id='nav-claim-details']/div[15]/div[2]//div/b";
    String lnkShowOption = "//*[contains(text(), '(Show)')]";
    String eleClaimNumber = "(//*[contains(text(), 'Claim Number')])[1]";
    String checkboxFields = "//*[@id='nav-claim-details']/div[15]/div[2]//input";
    String txtUniversalSearchBar = "//input[@type='text' and @formcontrolname='searchName']";
    String lstClaimSummaryValues = "//table[@class='table table-borderless']//tbody//tr//td";
    String lstClaimInformationValues = "//*[@id='nav-claim-details']/div[1]//div/b";
    String lstPaymentInformationValues = "//*[@id='nav-claim-details']/div[2]/div[2]/div/b | //*[@id='nav-claim-details']/div[3]/div[2]/div/b | " +
            "//*[@id='nav-claim-details']/div[4]/div[2]/div/b";
    String lstMemberInformationValues = "//*[@id='nav-claim-details']/div[5]/div[2]/div/b | //*[@id='nav-claim-details']/div[6]/div[2]/div/b | " +
            "//*[@id='nav-claim-details']/div[7]/div[2]/div/b | //*[@id='nav-claim-details']/div[8]/div[2]/div/b";
    String lstRenderingProviderInfoValues = "//*[@id='nav-claim-details']/div[9]/div[2]/div/b";
    String lstBillingProviderInfoValues = "//*[@id='nav-claim-details']/div[10]/div[2]/div/b | //*[@id='nav-claim-details']/div[11]/div[2]/div/b |" +
            " //*[@id='nav-claim-details']/div[12]/div[2]/div/b";
    String lstPayerValues = "//*[@id='nav-claim-details']/div[13]/div[2]/div/b | //*[@id='nav-claim-details']/div[14]/div[2]/div/b";
    String lstDateOfServiceSectionValues = "//*[@id='nav-claim-details']/div[15]//div[2]/div/b";

    private static String expClaimNumber = "";


    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void accessFFSProfessionalPage() {
        explicitVisibilityOfWait(findElementByXpath(lnkFFSProfessional), 20);
        clickElement(lnkFFSProfessional);
    }

    public void userClicksOnClaimNumber() throws InterruptedException {
        explicitElementClickableWaitByXpath(lnkClaimNumber, 50);
        clickElement(lnkClaimNumber);
    }

    public void userNavigatesToClaimSummaryPage(String expPageTitle) {
        explicitVisibilityOfWait(findElementByXpath(titleClaimSummary), 20);
        Assert.assertEquals(expPageTitle, findElementByXpath(titleClaimSummary).getText());
    }

    public void userViewsHideOptionBesideClaimSummary(String expOption) {
        explicitVisibilityOfWait(findElementByXpath(lnkHideOption), 20);
        Assert.assertEquals(expOption, findElementByXpath(lnkHideOption).getText());
    }

    //  Scenario: Verify View Claim in CMS 1500 and Self Assign buttons in Claim Summary details page
    public void userViewsCMSButton(String expViewClaimValue) {
        explicitVisibilityOfWait(findElementByXpath(btnViewClaim), 30);
        Assert.assertEquals(expViewClaimValue, findElementByXpath(btnViewClaim).getText());
    }

    public void userViewsSelfAssignButton(String expSelfAssignValue) {
        explicitVisibilityOfWait(findElementByXpath(btnSelfAssign), 30);
        Assert.assertEquals(expSelfAssignValue, findElementByXpath(btnSelfAssign).getText());
    }

    //  Scenario: Verify column fields in Claim Summary details page

    public void enterClaimNumberInSearchField() throws InterruptedException {
        threadSleep(1000);
        expClaimNumber = prop.getProperty("claimNumber");
        findElementAndSendKeys(findElementByXpath(txtUniversalSearchBar), expClaimNumber);
        threadSleep(1000);
        sendKeysUsingKeyboardInput(txtUniversalSearchBar);
        threadSleep(2000);
    }

    public void userViewsAllColumnFieldsInClaimSummaryDetails(DataTable columnList) {
        List<String> columnListExp = columnList.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(columnFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Column Fields in Claim Summary page  : " + columnFieldsForCompare);
        System.out.println("Expected fields are : " + columnListExp);
        for (String exp : columnListExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldValuesInClaimSummaryDetailsPage() throws InterruptedException {
        threadSleep(2000);
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Claim Number", "P00MR22051701S");
        testValues.put("Patient", "BKVVSW NOBNVSW");
        testValues.put("Patient ID/MBR ID", "2193336VF");
        testValues.put("PCP", "mxs zeybq vkmsnow cvkdszcyr idscbofsxe");
        testValues.put("Billing Provider", "mxs zeybq vkmsnow cvkdszcyr idscbofsxe");
        testValues.put("DOS From", "03/05/2022");
        testValues.put("DOS To", "03/05/2022");
        testValues.put("Billed Amount", "$110.00");
        testValues.put("POS", "22");
        testValues.put("PBP", "Valor Health Plan");
        testValues.put("Age", "21");
        testValues.put("Received Date", "05/17/2022");
        testValues.put("Ref ID", "-");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Claim Number", "P00MR22031005Z");
        uatValues.put("Patient", "fndmr mgrggrnt");
        uatValues.put("Patient ID/MBR ID", "VL3000941");
        uatValues.put("PCP", "PINNACLE CARE PROVIDERS LLC");
        uatValues.put("Billing Provider", "PINNACLE CARE PROVIDERS LLC");
        uatValues.put("DOS From", "12/02/2021");
        uatValues.put("DOS To", "12/02/2021");
        uatValues.put("Billed Amount", "$96");
        uatValues.put("POS", "32");
        uatValues.put("PBP", "-");
        uatValues.put("Age", "106");
        uatValues.put("Received Date", "03/10/2022");
        uatValues.put("Ref ID", "-");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstClaimSummaryValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue1 = 2;
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "03/05/2022"));
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "mxs zeybq vkmsnow cvkdszcyr idscbofsxe"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstClaimSummaryValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue1 = 2;
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "12/02/2021"));
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "PINNACLE CARE PROVIDERS LLC"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    //  Scenario: Verify Claim Information section
    public void userViewsClaimSummaryTabList(DataTable fieldList) throws InterruptedException {
        List<String> tabsListExp = fieldList.asList();
        List<WebElement> ActTabsList = findElementsByXpath(lstClaimSummaryTab);
        List<String> tabsListForCompare = new ArrayList<>();
        System.out.println("Size " + ActTabsList.size());
        for (WebElement column : ActTabsList) {
            threadSleep(30);
            scrollIntoView(column, driver);
            String text = column.getText();
            tabsListForCompare.add(text);
        }
        System.out.println("Tabs list in Claim Summary page  : " + tabsListForCompare);
        System.out.println("Expected fields are : " + tabsListExp);
        for (String exp : tabsListExp) {
            if (tabsListForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify footer section in Claim Summary details page
    public void userViewsFooterSectionInClaimSummaryDetails(DataTable footerFields) {
        List<String> footerFieldsExp = footerFields.asList();
        List<WebElement> ActFooterFields = findElementsByXpath(btnFooterFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFooterFields.size());
        for (WebElement column : ActFooterFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Footer fields in Claim Summary page :" + fieldsForCompare);
        System.out.println("Expected fields are : " + footerFieldsExp);
        for (String exp : footerFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify Claim Details sections
    public void userViewClaimDetailsByDefault(String expTabState) {
        explicitElementClickableWaitByXpath(eleClaimDetailsTab, 30);
        String actualValue = findElementByXpath(eleClaimDetailsTab).getAttribute("class");
        if (actualValue.contains(expTabState)) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void userViewsClaimDetailsSections(DataTable claimDetailsSections) throws InterruptedException {
        List<String> claimDetailsSectionsExp = claimDetailsSections.asList();
        List<WebElement> ActSections = findElementsByXpath(eleClaimDetailsSection);
        List<String> sectionsForCompare = new ArrayList<>();
        System.out.println("Size" + ActSections.size());
        threadSleep(20);
        for (WebElement column : ActSections) {
            scrollIntoView(column, driver);
            String text = column.getText();
            sectionsForCompare.add(text);
        }
        System.out.println("Fields in Claim Details section page :" + sectionsForCompare);
        System.out.println("Expected fields are : " + claimDetailsSectionsExp);
        for (String exp : claimDetailsSectionsExp) {
            if (sectionsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Validate Claim Information section
    public void userViewsClaimInformationFields(DataTable claimInfoFields) {
        List<String> claimInfoFieldsExp = claimInfoFields.asList();
        List<WebElement> ActFields = findElementsByXpath(claimInformationFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Claim Information section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + claimInfoFieldsExp);
        for (String exp : claimInfoFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldValuesUnderClaimInfoSection() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Claim Number", "P00MR22051701S");
        testValues.put("Reference Number", "-");
        testValues.put("State", "PAID");
        testValues.put("Claim Status", "PAID");
        testValues.put("Claim Type", "FFS");
        testValues.put("Form Type", "CMS-1500");
        testValues.put("Claim Submission", "1 - NEW");
        testValues.put("Clean Status", "Clean");
        testValues.put("Unclean Status", "Un - Clean");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Claim Number", "P00MR22031005Z");
        uatValues.put("Reference Number", "-");
        uatValues.put("State", "PAID");
        uatValues.put("Claim Status", "PAID");
        uatValues.put("Claim Type", "FFS");
        uatValues.put("Form Type", "CMS-1500");
        uatValues.put("Claim Submission", "1 - NEW");
        uatValues.put("Clean Status", "Clean");
        uatValues.put("Unclean Status", "Un - Clean");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstClaimInformationValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "PAID"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstClaimInformationValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "PAID"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    //  Scenario: Validate Payment Information section
    public void userViewsPaymentInformationFields(DataTable paymentInfoFields) {
        List<String> paymentInfoFieldsExp = paymentInfoFields.asList();
        List<WebElement> ActFields = findElementsByXpath(paymentInformationFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Payment Information section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + paymentInfoFieldsExp);
        for (String exp : paymentInfoFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldValuesUnderPaymentInfoSection() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("OK Pay Date", "06/07/2022");
        testValues.put("Paid Date", "06/07/2022");
        testValues.put("Check Number", "-");
        testValues.put("Reference Check", "1000010413");
        testValues.put("Plan CRN", "221370743255788");
        testValues.put("Adjustment", "$77.18");
        testValues.put("Deductible", "$0");
        testValues.put("Coinsurance", "$0");
        testValues.put("Copay", "$0");
        testValues.put("Recovery Amount", "$32.82");
        testValues.put("Payment Amount", "$0");
        testValues.put("Mailing date", "-");
        testValues.put("Payment Type", "-");
        testValues.put("Payment ID", "-");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("OK Pay Date", "06/24/2022");
        uatValues.put("Paid Date", "06/24/2022");
        uatValues.put("Check Number", "-");
        uatValues.put("Reference Check", "1000008182");
        uatValues.put("Plan CRN", "220691203581736");
        uatValues.put("Adjustment", "$29.9");
        uatValues.put("Deductible", "$0");
        uatValues.put("Coinsurance", "$13.43");
        uatValues.put("Copay", "$0");
        uatValues.put("Recovery Amount", "$0");
        uatValues.put("Payment Amount", "$52.67");
        uatValues.put("Mailing date", "-");
        uatValues.put("Payment Type", "-");
        uatValues.put("Payment ID", "-");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstPaymentInformationValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue1 = 2;
            int expValue2 = 4;
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "06/07/2022"));
            Assert.assertEquals(expValue2, Collections.frequency(ActValues, "-"));
            Assert.assertEquals(expValue2, Collections.frequency(ActValues, "$0"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstPaymentInformationValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue1 = 2;
            int expValue2 = 4;
            int expValue3 = 3;
            Assert.assertEquals(expValue1, Collections.frequency(ActValues, "06/24/2022"));
            Assert.assertEquals(expValue2, Collections.frequency(ActValues, "-"));
            Assert.assertEquals(expValue3, Collections.frequency(ActValues, "$0"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    //  Scenario: Validate Clean status
    public void verifyClaimStatusAsClean() {
        boolean cleanStatus = findElementByXpath(eleCleanStatus).isSelected();
        Assert.assertTrue(cleanStatus);
    }

    //  Scenario: Validate Unclean status
    public void verifyClaimStatusForUncleanIsUnchecked() {
        boolean uncleanStatus = findElementByXpath(eleUncleanStatus).isSelected();
        Assert.assertFalse(uncleanStatus);
    }

    //  Scenario: Validate Member Information section
    public void verifyFieldsUnderMemberInformationSection(DataTable memberInfoSection) {
        List<String> memberInfoFieldsExp = memberInfoSection.asList();
        List<WebElement> ActFields = findElementsByXpath(memberInformationFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Member Information section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + memberInfoFieldsExp);
        for (String exp : memberInfoFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldValuesUnderMemberInfoSection() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Patient Name", "BKVVSW NOBNVSW");
        testValues.put("Address Line 1", "DC UBKZ 048");
        testValues.put("Address Line 2", "-");
        testValues.put("City", "OBBKFKX");
        testValues.put("State", "OH");
        testValues.put("Country", "-");
        testValues.put("Zip Code", "59977");
        testValues.put("Gender", "F");
        testValues.put("Date of Birth", "05/12/1931");
        testValues.put("Insured Name", "BKVVSW");
        testValues.put("Patient's Relationship to Insured", "SELF");
        testValues.put("Insured's Unique Identifier", "2193336VF");
        testValues.put("Insured's Group Name", "VALOR HEALTH PLAN");
        testValues.put("Insured's Group Number", "-");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Patient Name", "fndmr mgrggrnt");
        uatValues.put("Address Line 1", "905 PITTSBURG AVE NW");
        uatValues.put("Address Line 2", "-");
        uatValues.put("City", "NORTH CANTON");
        uatValues.put("State", "OH");
        uatValues.put("Country", "-");
        uatValues.put("Zip Code", "447201814");
        uatValues.put("Gender", "F");
        uatValues.put("Date of Birth", "11/05/1948");
        uatValues.put("Insured Name", "fndmr");
        uatValues.put("Patient's Relationship to Insured", "SELF");
        uatValues.put("Insured's Unique Identifier", "-");
        uatValues.put("Insured's Group Name", "VL3000941");
        uatValues.put("Insured's Group Number", "-");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstMemberInformationValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 3;
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
            List<String> ActValues = findElementsByXpath(lstMemberInformationValues)
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
        }
    }

    //  Scenario: Validate Rendering Provider Information section
    public void verifyFieldsUnderRenderingProviderInformationSection(DataTable renderingProviderInfoSection) {
        List<String> renderingProviderInfoFieldsExp = renderingProviderInfoSection.asList();
        List<WebElement> ActFields = findElementsByXpath(renderingProviderInformationFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Rendering Provider Information section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + renderingProviderInfoFieldsExp);
        for (String exp : renderingProviderInfoFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldValuesUnderRenderingProviderInfoSection() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Rendering Provider Name", "mxs zeybq vkmsnow cvkdszcyr idscbofsxe");
        testValues.put("Rendering Provider NPI", "870551784");
        testValues.put("Taxonomy", "-");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Rendering Provider Name", "PINNACLE CARE PROVIDERS LLC");
        uatValues.put("Rendering Provider NPI", "1245601103");
        uatValues.put("Taxonomy", "-");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstRenderingProviderInfoValues)
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
            List<String> ActValues = findElementsByXpath(lstRenderingProviderInfoValues)
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

    //   Scenario: Validate Billing Provider Information section
    public void verifyFieldsUnderBillingProviderInformationSection(DataTable billingProviderInfoSection) {
        List<String> billingProviderInfoFieldsExp = billingProviderInfoSection.asList();
        List<WebElement> ActFields = findElementsByXpath(billingProviderInformationFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Billing Provider Information section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + billingProviderInfoFieldsExp);
        for (String exp : billingProviderInfoFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldValuesUnderBillingProviderInfoSection() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Billing Provider Name", "mxs zeybq vkmsnow cvkdszcyr idscbofsxe");
        testValues.put("Tax ID", "249411735");
        testValues.put("Address Line 1", "ofK nsvmeO 33444");
        testValues.put("Address Line 2", "-");
        testValues.put("City", "nxkvofovM");
        testValues.put("State", "RY");
        testValues.put("Zip", "940493477");
        testValues.put("Taxonomy", "-");
        testValues.put("SSN", "-");
        testValues.put("Telephone", "-");
        testValues.put("Network Affiliation", "OUT OF NETWORK PROVIDER");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Billing Provider Name", "PINNACLE CARE PROVIDERS LLC");
        uatValues.put("Tax ID", "270204369");
        uatValues.put("Address Line 1", "4580 Stephens Cir NW Ste 202");
        uatValues.put("Address Line 2", "-");
        uatValues.put("City", "Canton");
        uatValues.put("State", "OH");
        uatValues.put("Zip", "447183645");
        uatValues.put("Taxonomy", "-");
        uatValues.put("SSN", "-");
        uatValues.put("Telephone", "-");
        uatValues.put("Network Affiliation", "IN NETWORK PROVIDER");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstBillingProviderInfoValues)
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
            List<String> ActValues = findElementsByXpath(lstBillingProviderInfoValues)
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
        }
    }

    //   Scenario: Validate Payer section
    public void verifyFieldsUnderPayerSection(DataTable payerSection) {
        List<String> payerFieldsExp = payerSection.asList();
        List<WebElement> ActFields = findElementsByXpath(payerFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Payer section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + payerFieldsExp);
        for (String exp : payerFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldValuesUnderPayerSection() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("Payer name", "VALOR HEALTH PLAN");
        testValues.put("Payer ID", "43259");
        testValues.put("Address Line 1", "VALOR HEALTH PLAN");
        testValues.put("Address Line 2", "-");
        testValues.put("City", "NORTH CANTON");
        testValues.put("State", "OH");
        testValues.put("Zip Code", "44720");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("Payer Name", "VALOR HEALTH PLAN");
        uatValues.put("Payer ID", "43259");
        uatValues.put("Address Line 1", "-");
        uatValues.put("Address Line 2", "-");
        uatValues.put("City", "-");
        uatValues.put("State", "-");
        uatValues.put("Zip Code", "-");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstPayerValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "VALOR HEALTH PLAN"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstPayerValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 5;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "-"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    //  Scenario: Validate Date of Service section
    public void verifyFieldsUnderDateOfServiceSection(DataTable dateOfServiceSection) {
        List<String> dateOfServiceFieldsExp = dateOfServiceSection.asList();
        List<WebElement> ActFields = findElementsByXpath(dateOfServiceFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Date of Service section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + dateOfServiceFieldsExp);
        for (String exp : dateOfServiceFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldValuesUnderDateOfServiceSection() {
        HashMap<String, String> testValues = new HashMap<String, String>();
        testValues.put("From Date", "03/05/2022");
        testValues.put("To Date", "03/05/2022");
        testValues.put("Prior Auth", "-");
        testValues.put("Patient Control Number", "");

        HashMap<String, String> uatValues = new HashMap<>();
        uatValues.put("From Date", "12/02/2021");
        uatValues.put("To Date", "12/02/2021");
        uatValues.put("Prior Auth", "-");
        uatValues.put("Patient Control Number", "TXN11893136");

        if (environment.contains("test")) {
            List<String> fieldsExp = testValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstDateOfServiceSectionValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "03/05/2022"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        } else {
            List<String> fieldsExp = uatValues.values().stream().collect(Collectors.toList());
            List<String> ActValues = findElementsByXpath(lstDateOfServiceSectionValues)
                    .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
            System.out.println("Size:" + ActValues.size());
            int expValue = 2;
            Assert.assertEquals(expValue, Collections.frequency(ActValues, "12/02/2021"));
            for (String exp : fieldsExp) {
                if (ActValues.contains(exp)) {
                    Assert.assertTrue(true);
                } else {
                    Assert.fail(exp + " is not listed in actual list");
                }
            }
        }
    }

    //  Scenario: Validate Is Patient Condition Related To section
    public void verifyFieldsUnderIsPatientConditionRelatedToSection(DataTable isPatientConditionRelatedToSection) {
        List<String> isPatientConditionRelatedToFieldsExp = isPatientConditionRelatedToSection.asList();
        List<WebElement> ActFields = findElementsByXpath(isPatientConditionRelatedToField);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Is Patient Condition Related To section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + isPatientConditionRelatedToFieldsExp);
        for (String exp : isPatientConditionRelatedToFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyCheckBoxesForFields() {
        List<WebElement> ActFields = findElementsByXpath(checkboxFields);
        for (WebElement checkbox : ActFields) {
            if (checkbox.isDisplayed()) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(checkbox + "checkbox is not displayed");
            }
        }
    }

    //  Scenario: Validate Hide action for claim summary section
    public void userClicksOnHideLink() {
        explicitElementClickableWaitByXpath(lnkHideOption, 30);
        clickElement(lnkHideOption);
    }

    public void verifyClaimSummarySectionShouldHide() {
        boolean showLink = findElementByXpath(lnkShowOption).isDisplayed();
        Assert.assertTrue(showLink);
    }

    //  Scenario: Validate Show action for claim summary section
    public void verifyShowLinkIsDisplayed() {
        boolean showLink = findElementByXpath(lnkShowOption).isDisplayed();
        Assert.assertTrue(showLink);
    }

    public void userClicksOnShowLink() {
        clickElement(lnkShowOption);
    }

    public void verifyUserViewsClaimSummarySection() {
        boolean claimSummarySection = findElementByXpath(eleClaimNumber).isDisplayed();
        Assert.assertTrue(claimSummarySection);
    }
}