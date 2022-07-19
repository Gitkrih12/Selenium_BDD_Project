package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
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
    String lstClaimSummaryTab = "(//nav//div[@role='tablist'])[1]//button";
    String btnFooterFields = "//div[@class='button-padding-left footer']//button";
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
    String isPatientConditionRelatedToField = "//*[@id='nav-claim-details']/div[15]/div[2]/div/div";
    String showOption = "//*[contains(text(), '(Show)')]";


    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void accessFFSProfessionalPage() {
        explicitVisibilityOfWait(findElementByXpath(lnkFFSProfessional), 20);
        clickElement(lnkFFSProfessional);
    }

    public void userClicksOnClaimNumber() {
        explicitElementClickableWaitByXpath(lnkClaimNumber, 30);
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

    public void userViewsSelfAssignButton(String expSelfAssignValue) {
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
}