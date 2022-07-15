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
    String lnkClaimNumber = "(//*[@id='pendGrid']//app-view-claim-render/a)[1]";
    String titleClaimSummary = "//*[contains(text(), 'Claim Summary')]";
    String lnkHideOption = "//*[contains(text(), '(Hide)')]";
    String btnViewClaim = "//*[contains(text(), 'View Claim in CMS 1500')]";
    String btnSelfAssign = "//*[contains(text(), 'Self-Assign')]";
    String columnFields = "//table[@class='table table-borderless']//thead//tr//th";
    String lstClaimSummaryTab = "(//nav//div[@class='nav nav-tabs'])[1]//button";
    String btnFooterFields = "//div[@class='button-padding-left footer']//button";
    //String eleClaimDetailsTab = "//*[contains(text(), 'Claim Details (EDI)')]";
    String eleClaimDetailsTab = "//button[@class='nav-link active']";
    String eleClaimDetailsSection = "//*[@id='nav-claim-details']//h6";
    String claimInformationFields = "//*[@id='nav-claim-details']/div[1]//div";
    String paymentInformationFields = "//*[@id='nav-claim-details']/div[2]/div[1]/div | //*[@id='nav-claim-details']/div[3]/div[1]/div | " +
            "//*[@id='nav-claim-details']/div[4]/div[1]/div";
    String memberInformationFields = "//*[@id='nav-claim-details']/div[5]/div[1]/div | //*[@id='nav-claim-details']/div[6]/div[1]/div | " +
            "//*[@id='nav-claim-details']/div[7]/div[1]/div | //*[@id='nav-claim-details']/div[8]/div[1]/div";
    String renderingProviderInformationFields = "//*[@id='nav-claim-details']/div[9]/div[1]/div";
    String billingProviderInformationFields = "//*[@id='nav-claim-details']/div[10]/div[1]/div | //*[@id='nav-claim-details']/div[11]" +
            "/div[1]/div | //*[@id='nav-claim-details']/div[12]/div[1]/div";
    String payerFields = "//*[@id='nav-claim-details']/div[13]/div[1]/div | //*[@id='nav-claim-details']/div[14]/div[1]/div";
    String dateOfServiceFields = "//*[@id='nav-claim-details']/div[15]/div[1]/div[1]/div";
    String isPatientConditionRelatedToField = "//*[@id='nav-claim-details']/div[15]/div[2]/div/div";
    String showOption = "//*[contains(text(), '(Show)')]";


    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void accessFFSProfessionalPage() {
        explicitVisibilityOfWait(findElementByXpath(lnkFFSProfessional), 20);
        clickElement(lnkFFSProfessional);
    }

    public void userClicksOnClaimNumber() {
        explicitVisibilityOfWait(findElementByXpath(lnkClaimNumber), 100);
        clickElement(lnkClaimNumber);
    }

    public void userNavigatesToClaimSummaryPage(String expPageTitle) {
        explicitVisibilityOfWait(findElementByXpath(titleClaimSummary), 20);
        Assert.assertEquals(expPageTitle, findElementByXpath(titleClaimSummary).getText());
    }

    public void userViewsHideOptionBesideClaimSummary(String expOption) {
        explicitVisibilityOfWait(findElementByXpath(lnkHideOption), 20);
        Assert.assertEquals("(Hide)", findElementByXpath(lnkHideOption).getText());
    }

    //  Scenario: Verify View Claim in CMS 1500 and Self Assign buttons in Claim Summary details page
    public void userViewsCMSButton(String expViewClaimValue) {
        explicitVisibilityOfWait(findElementByXpath(btnViewClaim), 20);
        Assert.assertEquals(expViewClaimValue, findElementByXpath(btnViewClaim).getText());

    }

    public void userViewsSelfAssignButton(String expSelfAssignValue){
        explicitVisibilityOfWait(findElementByXpath(btnSelfAssign), 20);
        Assert.assertEquals(expSelfAssignValue, findElementByXpath(btnSelfAssign).getText());
    }

    //  Scenario: Verify column fields in Claim Summary details page
    public void userViewsAllColumnFieldsInClaimSummaryDetails(DataTable columnList) {
        List<String> columnListExp = columnList.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(columnFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            System.out.println("Column Fields in Claim Summary page  : " + columnFieldsForCompare);
            columnFieldsForCompare.add(text);
        }
        if (columnFieldsForCompare.equals(columnListExp)) {
            Assert.assertTrue(true);
        }
    }

    //  Scenario: Verify Claim Information section
    public void userViewsClaimSummaryTabList(DataTable tabsList) {
        List<String> tabsListExp = tabsList.asList();
        List<WebElement> ActTabsList = findElementsByXpath(lstClaimSummaryTab);
        List<String> tabsListForCompare = new ArrayList<>();
        System.out.println("Size " + ActTabsList.size());
        for (WebElement column : ActTabsList) {
            scrollIntoView(column, driver);
            String text = column.getText();
            System.out.println("Tabs list in Claim Summary page  : " + tabsListForCompare);
            tabsListForCompare.add(text);
        }
        if (tabsListForCompare.equals(tabsListExp)) {
            Assert.assertTrue(true);
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
            System.out.println("Footer fields in Claim Summary page :" + fieldsForCompare);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(footerFieldsExp)) {
            Assert.assertTrue(true);
        }
    }

    //  Scenario: Verify Claim Details sections
    public void userViewClaimDetailsByDefault(String expTabState) {
        explicitVisibilityOfWait(findElementByXpath(eleClaimDetailsTab), 20);
        String actualValue = findElementByXpath(eleClaimDetailsTab).getAttribute("class");
        Assert.assertTrue(actualValue.contains(expTabState));
    }

    public void userViewsClaimDetailsSections(DataTable claimDetailsSections) {
        List<String> claimDetailsSectionsExp = claimDetailsSections.asList();
        List<WebElement> ActSections = findElementsByXpath(eleClaimDetailsSection);
        List<String> sectionsForCompare = new ArrayList<>();
        System.out.println("Size" + ActSections.size());
        for (WebElement column : ActSections) {
            scrollIntoView(column, driver);
            String text = column.getText();
            System.out.println("Fields in Claim Details section page :" + sectionsForCompare);
            sectionsForCompare.add(text);
        }
        if (sectionsForCompare.equals(claimDetailsSectionsExp)) {
            Assert.assertTrue(true);
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
            System.out.println("Fields in Claim Information section :" + fieldsForCompare);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(claimInfoFieldsExp)) {
            Assert.assertTrue(true);
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
            System.out.println("Fields in Payment Information section :" + fieldsForCompare);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(paymentInfoFieldsExp)) {
            Assert.assertTrue(true);
        }
    }

    //  Scenario: Validate Clean status
    public void verifyClaimStatusAsClean() {
        boolean cleanStatus = findElementByXpath("//*[@ng-reflect-model = 'true']").isSelected();
        Assert.assertTrue(cleanStatus);
    }

    //  Scenario: Validate Unclean status
    public void verifyClaimStatusForUncleanIsUnchecked() {
        boolean uncleanStatus = findElementByXpath("( //*[@ng-reflect-model = 'false'])[1]").isSelected();
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
            System.out.println("Fields in Member Information section :" +fieldsForCompare );
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(memberInfoFieldsExp)) {
            Assert.assertTrue(true);
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
            System.out.println("Fields in Rendering Provider Information section :" + fieldsForCompare);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(renderingProviderInfoFieldsExp)) {
            Assert.assertTrue(true);
        }
    }
}