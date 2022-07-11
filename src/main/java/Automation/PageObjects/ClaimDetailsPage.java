package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class ClaimDetailsPage extends SeleniumUtils {

    String FFSProfessional = "//*[contains(text(), 'FFS Professional')]";
    String claimNumber = "(//*[@id='pendGrid']//app-view-claim-render/a)[1]";
    String claimSummaryTitle = "//*[contains(text(), 'Claim Summary')]";
    String hideOption = "//*[contains(text(), '(Hide)')]";
    String viewClaimButton = "//*[contains(text(), 'View Claim in CMS 1500')]";
    String selfAssignButton = "//*[contains(text(), 'Self-Assign')]";
    String columnFields = "//*[@id='mat-tab-content-0-2']//app-claimdetails//div[2]//div/table/thead/tr";
    String claimSummaryTabList = "//*[@id='nav-tab']";
    String footerFieldsButton = "//*[@id='mat-tab-content-0-2']//app-claimdetails/div/div[3]/div[2]";
    String claimDetailsTab = "//*[contains(text(), 'Claim Details (EDI)')]";
    String claimDetailsSection = "//*[@id='nav-claim-details']//h6";
    String claimInformationFields = "//*[@id='nav-claim-details']/div[1]//div";
    String paymentInformationFields = "//*[@id='nav-claim-details']/div[2]/div[1]/div | //*[@id='nav-claim-details']/div[3]/div[1]/div | " +
            "//*[@id='nav-claim-details']/div[4]/div[1]/div";
    String memberInformationFields = "//*[@id='nav-claim-details']/div[5]/div[1]/div | //*[@id='nav-claim-details']/div[6]/div[1]/div | " +
            "//*[@id='nav-claim-details']/div[7]/div[1]/div | //*[@id='nav-claim-details']/div[8]/div[1]/div";
    String renderingProviderInformationFields = "//*[@id='nav-claim-details']/div[9]/div[1]/div";


    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void accessFFSProfessionalPage() {
        explicitVisibilityOfWait(driver.findElement(By.xpath(FFSProfessional)), 1000);
        clickElement(FFSProfessional);
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void userClicksOnClaimNumber() {
        explicitVisibilityOfWait(driver.findElement(By.xpath(claimNumber)), 2000);
        clickElement(claimNumber);
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void userNavigatesToClaimSummaryPage() {
        explicitVisibilityOfWait(driver.findElement(By.xpath(claimSummaryTitle)), 1000);
        Assert.assertEquals("Claim Summary page is displayed", driver.findElement(
                By.xpath(claimSummaryTitle)).getText(), "Claim Summary");
    }

    //  Scenario: Verify user able to navigate to claim summary screen on clicking claim number
    public void userViewsHideOptionBesideClaimSummary() {
        explicitVisibilityOfWait(driver.findElement(By.xpath(hideOption)), 1000);
        Assert.assertEquals("Hide option is displayed", driver.findElement(By.xpath(hideOption)).getText(), "(Hide)");
    }

    //  Scenario: Verify View Claim in CMS 1500 and Self Assign buttons in Claim Summary details page
    public void userViewsSelfAssignAndCMSButtons() {
        explicitVisibilityOfWait(driver.findElement(By.xpath(viewClaimButton)), 1000);
        Assert.assertEquals("View Claim in CMS 1500 button should display", driver.findElement(
                By.xpath(viewClaimButton)).getText(), "View Claim in CMS 1500");
        Assert.assertEquals("Self-Assign button should display", driver.findElement(
                By.xpath(selfAssignButton)).getText(), "Self-Assign");
    }

    //  Scenario: Verify column fields in Claim Summary details page
    public void userViewsAllColumnFieldsInClaimSummaryDetails(DataTable columnList) {
        List<String> columnListExp = columnList.asList();
        List<WebElement> ActColumnFields = findElementsByXpath(columnFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + ActColumnFields.size());
        for (WebElement column : ActColumnFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Column Fields in Claim Summary page  : " + text);
            columnFieldsForCompare.add(text);
        }
        if (columnFieldsForCompare.equals(columnListExp)) {
            Assert.assertEquals(columnListExp, columnFieldsForCompare);
        }
    }

    //  Scenario: Verify Claim Information section
    public void userViewsClaimSummaryTabList(DataTable tabsList) {
        List<String> tabsListExp = tabsList.asList();
        List<WebElement> ActTabsList = findElementsByXpath(claimSummaryTabList);
        List<String> tabsListForCompare = new ArrayList<>();
        System.out.println("Size " + ActTabsList.size());
        for (WebElement column : ActTabsList) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Column Fields in Claim Summary page  : " + text);
            tabsListForCompare.add(text);
        }
        if (tabsListForCompare.equals(tabsListExp)) {
            Assert.assertEquals(tabsListExp, tabsListForCompare);
        }
    }

    //  Scenario: Verify footer section in Claim Summary details page
    public void userViewsFooterSectionInClaimSummaryDetails(DataTable footerFields) {
        List<String> footerFieldsExp = footerFields.asList();
        List<WebElement> ActFooterFields = findElementsByXpath(footerFieldsButton);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFooterFields.size());
        for (WebElement column : ActFooterFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Footer fields in Claim Summary page :" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(footerFieldsExp)) {
            Assert.assertEquals(footerFieldsExp, fieldsForCompare);
        }
    }

    //  Scenario: Verify Claim Details sections
    public void userViewClaimDetailsByDefault() {
        explicitVisibilityOfWait(driver.findElement(By.xpath(claimDetailsTab)), 1000);
        Assert.assertEquals("By default Claim Details tab is displayed",
                driver.findElement(By.xpath(claimDetailsTab)).getText(), "Claim Details (EDI)");
    }

    //  Scenario: Verify Claim Details sections
    public void userViewsClaimDetailsSections(DataTable claimDetailsSections) {
        List<String> claimDetailsSectionsExp = claimDetailsSections.asList();
        List<WebElement> ActSections = findElementsByXpath(claimDetailsSection);
        List<String> sectionsForCompare = new ArrayList<>();
        System.out.println("Size" + ActSections.size());
        for (WebElement column : ActSections) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Footer fields in Claim Summary page :" + text);
            sectionsForCompare.add(text);
        }
        if (sectionsForCompare.equals(claimDetailsSectionsExp)) {
            Assert.assertEquals(claimDetailsSectionsExp, sectionsForCompare);
        }
    }

    //  Scenario: Validate Claim Information section
    public void userViewsClaimInformationFields(DataTable claimInfoFields) {
        List<String> claimInfoFieldsExp = claimInfoFields.asList();
        List<WebElement> ActFields = findElementsByXpath(claimInformationFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Footer fields in Claim Summary page :" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(claimInfoFieldsExp)) {
            Assert.assertEquals(claimInfoFieldsExp, fieldsForCompare);
        }
    }

    //  Scenario: Validate Payment Information section
    public void userViewsPaymentInformationFields(DataTable paymentInfoFields) {
        List<String> paymentInfoFieldsExp = paymentInfoFields.asList();
        List<WebElement> ActFields = findElementsByXpath(paymentInformationFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Footer fields in Claim Summary page :" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(paymentInfoFieldsExp)) {
            Assert.assertEquals(paymentInfoFieldsExp, fieldsForCompare);
        }
    }

    //  Validate Clean status
    public void verifyClaimStatusAsClean() {
        boolean cleanStatus = driver.findElement(By.xpath("//*[@ng-reflect-model = 'true']")).isSelected();
        Assert.assertTrue(cleanStatus);
    }

    //  Validate Unclean status
    public void verifyClaimStatusforUncleanIsUnchecked() {
        boolean uncleanStatus = driver.findElement(By.xpath("( //*[@ng-reflect-model = 'false'])[1]")).isSelected();
        Assert.assertFalse(uncleanStatus);
    }

    //  Validate Member Information section
    public void verifyFieldsUnderMemberInformationSection(DataTable memberInfoSection) {
        List<String> memberInfoFieldsExp = memberInfoSection.asList();
        List<WebElement> ActFields = findElementsByXpath(memberInformationFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Footer fields in Claim Summary page :" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(memberInfoFieldsExp)) {
            Assert.assertEquals(memberInfoFieldsExp, fieldsForCompare);
        }
    }

    //  Validate Rendering Provider Information section
    public void verifyFieldsUnderRenderingProviderInformationSection(DataTable renderingProviderInfoSection) {
        List<String> renderingProviderInfoFieldsExp = renderingProviderInfoSection.asList();
        List<WebElement> ActFields = findElementsByXpath(renderingProviderInformationFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, getWebDriver());
            String text = column.getText();
            System.out.println("Footer fields in Claim Summary page :" + text);
            fieldsForCompare.add(text);
        }
        if (fieldsForCompare.equals(renderingProviderInfoFieldsExp)) {
            Assert.assertEquals(renderingProviderInfoFieldsExp, fieldsForCompare);
        }
    }
}