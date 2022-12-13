package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

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
            "//*[@id='nav-claim-details']/div[7]/div[1]/div";
    String renderingProviderInformationFields = "//*[@id='nav-claim-details']/div[8]/div[1]/div";
    String eleCleanStatus = "(//*[@ng-reflect-model = 'true'])[1]";
    String eleUncleanStatus = "(//*[@ng-reflect-model = 'false'])[1]";
    String billingProviderInformationFields = "//*[@id='nav-claim-details']/div[9]/div[1]/div | //*[@id='nav-claim-details']/div[10]" +
            "/div[1]/div | //*[@id='nav-claim-details']/div[11]/div[1]/div";
    String payerFields = "//*[@id='nav-claim-details']/div[12]/div[1]/div | //*[@id='nav-claim-details']/div[13]/div[1]/div";
    String dateOfServiceFields = "//*[@id='nav-claim-details']/div[14]/div[1]/div[1]/div";
    String isPatientConditionRelatedToField = "//*[@id='nav-claim-details']/div[14]/div[2]//div/b";
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
    String lblClaimSubmissionNew = "//*[contains(text(), '1 - NEW')]";
    String lblClaimSubmissionCorrected = "//*[contains(text(), '7 - CORRECTED')]";
    String eleClaimSubmission = "//*[@id='nav-claim-details']//div[4]/div[2]/b";
    String tabPend = "//button[@id='nav-pend-details-tab']";
    String eleSuccessMessage = "//div[contains(@class,'toastr toast-success')]";
    String eleAssignedUser = "(//table[@class='table table-borderless']//tr)[2]//td[14]";



    private static String expClaimNumber = "";
    private static String expClaimSubmission = "";


    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void accessFFSProfessionalPage() {
        explicitVisibilityOfWait(findElementByXpath(lnkFFSProfessional), 20);
        clickElement(lnkFFSProfessional);
    }

    public void userClicksOnClaimNumber() {
        explicitElementClickableWaitByXpath(lnkClaimNumber, 60);
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
        explicitVisibilityOfWait(findElementByXpath(btnViewClaim), 40);
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
        List<WebElement> claimSummaryValues = findElementsByXpath(lstClaimSummaryValues);
        System.out.println("Size:" + claimSummaryValues.size());
        for (WebElement value : claimSummaryValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
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
        explicitElementClickableWaitByXpath(btnFooterFields, 40);
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
        List<WebElement> claimInfoValues = findElementsByXpath(lstClaimInformationValues);
        System.out.println("Size:" + claimInfoValues.size());
        for (WebElement value : claimInfoValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
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
        List<WebElement> paymentInfoValues = findElementsByXpath(lstPaymentInformationValues);
        System.out.println("Size:" + paymentInfoValues.size());
        for (WebElement value : paymentInfoValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
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
        List<WebElement> memberInformationValues = findElementsByXpath(lstMemberInformationValues);
        System.out.println("Size:" + memberInformationValues.size());
        for (WebElement value : memberInformationValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
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
        List<WebElement> renderingProviderValues = findElementsByXpath(lstRenderingProviderInfoValues);
        System.out.println("Size:" + renderingProviderValues.size());
        for (WebElement value : renderingProviderValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
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
        List<WebElement> billingProviderValues = findElementsByXpath(lstBillingProviderInfoValues);
        System.out.println("Size:" + billingProviderValues.size());
        for (WebElement value : billingProviderValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
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
        List<WebElement> payerSectionValues = findElementsByXpath(lstPayerValues);
        System.out.println("Size:" + payerSectionValues.size());
        for (WebElement value : payerSectionValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
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
        List<WebElement> dateOfServiceSectionValues = findElementsByXpath(lstDateOfServiceSectionValues);
        System.out.println("Size:" + dateOfServiceSectionValues.size());
        for (WebElement value : dateOfServiceSectionValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
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
        clickElement(lnkHideOption);
    }

    public void verifyClaimSummarySectionShouldHide() {
        boolean claimSummarySection = explicitElementClickableWaitByXpath(eleClaimNumber, 30).isDisplayed();
        Assert.assertTrue(claimSummarySection);
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
        Assert.assertFalse(claimSummarySection);
    }

    //  Scenario: Verify user able to view 1-New Claim Submission type in Claim details page
    public void verifyClaimSubmissionTypeAsNew() {
        expClaimSubmission = prop.getProperty("claimSubmissionNew");
        explicitTextToBePresentInElementLocatedWait(By.xpath(lblClaimSubmissionNew), 20, expClaimSubmission);
        Assert.assertEquals(expClaimSubmission, findElementByXpath(lblClaimSubmissionNew).getText());
    }

    //  Scenario: Verify user able to view 7-Corrected claim submission type in Claim Details page
    public void verifyClaimSubmissionTypeAsCorrected() {
        expClaimSubmission = prop.getProperty("claimSubmissionCorrected");
        explicitTextToBePresentInElementLocatedWait(By.xpath(lblClaimSubmissionCorrected), 20, expClaimSubmission);
        Assert.assertEquals(expClaimSubmission, findElementByXpath(lblClaimSubmissionCorrected).getText());
    }

    //  Scenario: Verify user able to view different types of claim submission from FFS/CAP Institutional page
    public void userEntersAndClicksOnClaimNumber(String claimNumber) {
        findElementAndSendKeys(findElementByXpath(txtUniversalSearchBar), claimNumber);
        sendKeysUsingKeyboardInput(txtUniversalSearchBar);
    }

    public void verifyClaimSubmissionType(String type){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleClaimSubmission), 30, type);
        Assert.assertEquals(type, findElementByXpath(eleClaimSubmission).getText());
    }

    //Scenario: Verify self assign claim functionality
    public void clickSelfAssignButton(){
        explicitElementClickableWaitByXpath(btnSelfAssign, 20);
        clickElement(btnSelfAssign);
    }

    public void verifySuccessValidation(String validationMsg1,String validationMsg2) {
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleSuccessMessage), 15, validationMsg1);
        String actMsg = getText(eleSuccessMessage);
        System.out.println(" actual msg "+actMsg);
        if(actMsg.contains(validationMsg1)&&actMsg.contains(validationMsg2)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }
    public void verifyAssignedUser(){
        String actUser = getText(eleAssignedUser);
        String expUserName = LoginPage.username;
        System.out.println("exp user :" +expUserName);
        if(actUser.contains(expUserName)){
            Assert.assertTrue(true);
        }else{
            Assert.assertTrue(false);
        }

    }
}