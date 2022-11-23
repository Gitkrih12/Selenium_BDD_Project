package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProviderDetailsPage extends SeleniumUtils {

    String tabProviderDetails = "//button[@id='nav-provider-details-tab']";
    String lstProviderDetails = "(//div[@class='ng-star-inserted'])[3]//h6";
    String lstPayToProviderDetails = "//app-providerdetails//div[contains(@class, 'columnFont')]//div";
    String lstGroupRenderingProviderDetails = "//*[@class='table table-striped']//tr//th[position()<last()]";
    String btnFooterSection = "//*[@class='footer footer-flex']//button";
    String lnkVendorId = "//*[@id='nav-claim-details']//div[5]//a";
    String labelVendorId = "//*[@class='claims-list']";
    String labelCreditOverPaidStatus = "(//*[contains(@class, 'claims-list')])[2]";
    String labelDebitUnderPaidStatus = "(//*[contains(@class, 'claims-list')])[3]";
    String lstArTransactionFields = "//*[@role='columnheader']//span[text()]";
    String txtSearchFieldsForAR = "//*[@class = 'ag-floating-filter-input']";
    String lstPayToProviderDetailsValues = "//app-providerdetails//div[contains(@class, 'col-3')]//b";
    String lstGroupRenderingProviderDetailsValues = "//*[@class='table table-striped']//tr//td//div";
    String eleOnHoldClaimNumber = "(//*[@id = 'onHoldGrid']//div[@class = 'ag-pinned-left-cols-container']//a)[1]";
    String btnMapPayToProvider = "//*[contains(text(), 'Map Pay To Provider')]";
    String titleMapPayToProvider = "//*[@class = 'map-rendering']//h2";
    String lstHeadersMapPayToProvider = "//mat-dialog-container//*[contains(@class, 'label-heading')]";
    String lstFieldsMapPayToProvider = "//*[@id='resultsGridPaytoprovider']//span[@ref = 'eText' and text()]";
    String eleLastRowOnPage = "//*[@id='resultsGridPaytoprovider']//span[@ref = 'lbLastRowOnPage']";
    String btnSelect = "(//*[@id='resultsGridPaytoprovider']//button[contains(text(), 'Select')])";
    String eleDefaultVendor = "//*[@col-id='uniquePayToId']//button";
    String eleGreenBar = "//*[@id='resultsGridPaytoprovider']//div[@col-id = 'isDefault']//span//span//span";
    String txtOnHoldClaimNumber = "//*[@id = 'onHoldGrid']//input[@aria-label='Claim Number Filter Input']";
    String eleSelect = "(//*[@id='resultsGridPaytoprovider']//button[contains(text(), 'Select')])[last()]";
    String btnCancel = "//mat-dialog-container//button[contains(text(),'Cancel')]";
    String btnClose = "//mat-dialog-container//button[@aria-label = 'Close']";
    String btnFirstPage = "//mat-dialog-container//div[@aria-label = 'First Page']";
    String btnPreviousPage = "//mat-dialog-container//div[@aria-label = 'Previous Page']";
    String btnNextPage = "//mat-dialog-container//div[@aria-label = 'Next Page']";
    String btnLastPage = "//mat-dialog-container//div[@aria-label = 'Last Page']";
    String lnkProviderId = "(//*[@class = 'table table-striped']//a)[1]";
    String titleProviderWindow = "//*[@class = 'mat-tab-label-content']//div[@ng-reflect-ng-class ='active-tab']";
    String lstSubtabs = "//*[@id = 'nav-tab']//button";
    String titleBasicInfoSubtab = "//button[@class = 'nav-link active']";
    String lstProviderBasicInfoFields = "//*[@id = 'nav-basic-details']//div[contains(@class, 'columnFont')]//div";
    String lstFacilityName = "//*[@id = 'nav-basic-details']//div[@class = 'facility-bd']//div//h5[@class = 'columnFont' and text()]";
    String lstAdverseActions = "(//*[@class = 'table table-striped'])[1]//tr//th";
    String lstCommentSection = "(//*[@class = 'table table-striped'])[2]//tr//th";
    String lnkContractName = "//*[@aria-controls = 'offcanvasRight']";
    String titlePayClass = "//*[@class = 'offcanvas-header']//span";
    String titleException = "//*[@class = 'offcanvas-body']//h4";
    String lstPayClassFields = "//*[@class = 'offcanvas-body']//div[@class = 'row']//span[@class = 'label-heading']";
    String lstCPTFields = "(//*[@id = 'resultsGrid']//div[@ref='gridHeader'])[1]//span[@ref = 'eText']";
    String btnRevenueCode = "//button[contains(text(), 'Revenue Code')]";
    String lstRevenueCodeFields = "(//*[@id = 'resultsGrid1']//div[@ref='gridHeader'])[1]//span[@ref = 'eText']";
    String eleVendorId = "(//div[@col-id='uniquePayToId_1']//span[@class='ag-cell-value'])[last()]";
    String tabLocationInfo = "//*[@id = 'nav-location-details-tab']";
    String lstPracticeLocation = "//*[@id = 'nav-location-info']//tr//th";
    String tabContractInfo = "//*[@id = 'nav-contract-details-tab']";
    String lstContract = "//*[@id = 'nav-contract-info']//tr//th";
    String tabAliasInfo = "//*[@id = 'nav-alias-info-tab']";
    String lstAliasInfo = "//*[@id = 'nav-alias-info']//tr//th";
    String btnMapProvider = "//*[contains(text(), 'Map Provider')]";
    String titleMapRenderingProvider = "//*[contains(text(), 'Map Rendering Provider')]";
    String eleTaxID = "//mat-dialog-container//*[contains(text(), 'Tax ID')]";
    String eleRenderingProvider = "(//mat-dialog-container//*[contains(text(), 'Rendering Provider')])[2]";
    String lstRenderingProvider = "//*[@id = 'resultsGridRenderingprovider']//span[@ref = 'eText' and text()]";
    String eleFacilityName = "//*[@id = 'nav-basic-details']//h6[contains(@class, 'columnFont')]";
    String eleSpeciality = "//*[contains(text(), 'Speciality')]";
    String eleValidated = "(//*[contains(text(),'Validated')])[2]";
    String lstSelectButton = "//div[@col-id='uniquePayToId']//button";
    String elePayToProvider = "//span[contains(text(),'Pay to Provider')]";



    private static String expFirstPage = "";
    private static String expNextPage = "";
    private static String expPreviousPage = "";
    private static String expLastPage = "";
    private static String expColor = "";
    private static String expMultipleVendorClaimNumber = "";
    private static String expWindow = "";
    private static String expSubtab = "";
    private static String expPayClass = "";
    private static String expException = "";
    private static String expMapPayProviderSideDrawer = "";
    private static String expOnHoldVendorClaimNumber = "";


    // Scenario: Verify user able to navigate to the Provider details tab in the View Claims Form page
    public void clickOnProviderDetails() throws InterruptedException {
        explicitElementClickableWaitByXpath(tabProviderDetails, 30);
        clickElement(tabProviderDetails);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleValidated), 60, "Validated");
    }

    public void userNavigatedToProviderDetails() {
        Assert.assertEquals("Provider Details", findElementByXpath(tabProviderDetails).getText());
    }

    //  Scenario: Verify user able to view the Pay to Provider Details and Group/Rendering Provider Details section under Provider Details tab
    public void userShouldViewProviderDetailsSection(DataTable providerDetailsSection) {
        List<String> sectionsExp = providerDetailsSection.asList();
        List<String> actFields = findElementsByXpath(lstProviderDetails)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actFields.size());
        System.out.println("Pay to Provider fields and Group/Rendering Provider details are displayed:" + actFields);
        System.out.println("Expected fields are: " + sectionsExp);
        Assert.assertEquals(sectionsExp, actFields);
    }

    //  Scenario: Verify user able to view all the fields under Pay to Provider Details section
    public void userViewsFieldsUnderPayToProviderDetailsSection(DataTable fieldsUnderPayToProviderDetails) {
        List<String> fieldsExp = fieldsUnderPayToProviderDetails.asList();
        List<WebElement> ActFields = findElementsByXpath(lstPayToProviderDetails);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + ActFields.size());
        for (WebElement column : ActFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("Fields in Payment Information section :" + fieldsForCompare);
        System.out.println("Expected fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void userViewsFieldValuesUnderPayToProviderDetails() {
        List<WebElement> payToProviderValues = findElementsByXpath(lstPayToProviderDetailsValues);
        System.out.println("Size:" + payToProviderValues.size());
        for (WebElement value : payToProviderValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    //  Scenario: Verify user able to view all the fields under Group/Rendering Provider Details section
    public void userViewsFieldsUnderGroupRenderingProviderDetailsSection(DataTable fieldsUnderGroupRendering) {
        List<String> fieldsExp = fieldsUnderGroupRendering.asList();
        List<String> actFields = findElementsByXpath(lstGroupRenderingProviderDetails)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actFields.size());
        System.out.println("Group/Rendering Provider Details Fields should display:" + actFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, actFields);
    }

    public void userViewsFieldValuesUnderGroupRenderingProviderDetails() {
        List<WebElement> payToProviderValues = findElementsByXpath(lstGroupRenderingProviderDetailsValues);
        System.out.println("Size:" + payToProviderValues.size());
        for (WebElement value : payToProviderValues) {
            Assert.assertTrue(isDisplayed(value));
            System.out.println("Value is displayed: " + isDisplayed(value));
        }
    }

    //  Scenario: Validate all the buttons available at the footer section under Provider Details tab
    public void userViewsFooterSectionInServiceDetails(DataTable footerSection) {
        List<String> fieldsExp = footerSection.asList();
        List<String> actFields = findElementsByXpath(btnFooterSection)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actFields.size());
        System.out.println("Footer fields should display:" + actFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, actFields);
    }

    public void clickOnVendorId() throws InterruptedException {
        explicitElementClickableWaitByXpath((lnkVendorId), 30);
        clickElement(lnkVendorId);
        threadSleep(3000);
    }

    public void userNavigatesToARTransactionsPage() {
        String expVendorID = prop.getProperty("vendorID");
        Assert.assertEquals(expVendorID, findElementByXpath(labelVendorId).getText());
    }

    //  Scenario: Verify user able to view the Credit/Overpaid and Debit/Underpaid status at the middle of the A/R Ledger
    public void userViewsCreditOverPaidStatus(String expCreditStatus) {
        Assert.assertEquals(expCreditStatus, findElementByXpath(labelCreditOverPaidStatus).getText());
    }

    public void userViewsDebitUnderPaidStatus(String expDebitStatus) {
        Assert.assertEquals(expDebitStatus, findElementByXpath(labelDebitUnderPaidStatus).getText());
    }

    //  Scenario: Verify user able to view the available Account Review Transactions and all the columns in the A/R transaction details page
    public void userViewsAccountReviewTransactionColumns(DataTable arTransactionFields) {
        List<String> arTransactionFieldsExp = arTransactionFields.asList();
        List<WebElement> actFields = findElementsByXpath(lstArTransactionFields);
        List<String> fieldsForCompare = new ArrayList<>();
        System.out.println("Size" + actFields.size());
        for (WebElement column : actFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            fieldsForCompare.add(text);
        }
        System.out.println("AR Transaction should display :" + fieldsForCompare);
        System.out.println("Expected fields are : " + arTransactionFieldsExp);
        for (String exp : arTransactionFieldsExp) {
            if (fieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify Search box should display for all the columns on the A/R Transactions grid
    public void verifySearchFieldsUnderEachColumn() {
        List<WebElement> actSearchFields = findElementsByXpath(txtSearchFieldsForAR);
        for (WebElement column : actSearchFields) {
            scrollIntoView(column, driver);
            boolean value = column.isDisplayed();
            Assert.assertTrue(value);
        }
    }

    // Scenario: Verify user able to view Map Pay To Provider button for ONHOLD Claims only
    public void userClicksOnHoldClaimNumber() {
        explicitElementClickableWait(findElementByXpath(txtOnHoldClaimNumber), 60);
        expOnHoldVendorClaimNumber = prop.getProperty("onHoldVendorClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtOnHoldClaimNumber), expOnHoldVendorClaimNumber);
        sendKeysUsingKeyboardInput(txtOnHoldClaimNumber);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleOnHoldClaimNumber), 10, expOnHoldVendorClaimNumber);
        clickElement(eleOnHoldClaimNumber);
    }

    public void verifyMapPayToProviderButton(String expMapPayToProviderButton) {
        Assert.assertEquals(expMapPayToProviderButton, findElementByXpath(btnMapPayToProvider).getText());
    }

    //  Scenario: Verify user able to view the Map Pay to Provider side drawer on clicking the Map Pay To Provider button
    public void userClicksOnMapPayToProviderButton() {
        explicitElementClickableWaitByXpath(btnMapPayToProvider, 40);
        clickElement(btnMapPayToProvider);
        explicitTextToBePresentInElementLocatedWait(By.xpath(titleMapPayToProvider), 30, expMapPayProviderSideDrawer);
    }

    public void verifyUserNavigatesToMapPayToProvider() {
        expMapPayProviderSideDrawer = prop.getProperty("expMapPayToProviderSideDrawer");
        Assert.assertEquals(expMapPayProviderSideDrawer, findElementByXpath(titleMapPayToProvider).getText());
    }

    //  Scenario: Verify user able to view all the fields in Map Pay To Provider Side drawer
    public void verifyHeadersUnderMapPayToProvider(DataTable expHeaders) {
        List<String> headersExp = expHeaders.asList();
        List<WebElement> actColumnHeaders = findElementsByXpath(lstHeadersMapPayToProvider);
        List<String> columnHeadersForCompare = new ArrayList<>();
        System.out.println("Size " + actColumnHeaders.size());
        for (WebElement column : actColumnHeaders) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnHeadersForCompare.add(text);
        }
        System.out.println("Headers under Map Pay To Provider section :" + columnHeadersForCompare);
        System.out.println("Expected fields are : " + headersExp);
        for (String exp : headersExp) {
            if (columnHeadersForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    public void verifyFieldsUnderMapPayToProvider(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<WebElement> actColumnFields = findElementsByXpath(lstFieldsMapPayToProvider);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + actColumnFields.size());
        for (WebElement column : actColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields under Map Pay To Provider section :" + columnFieldsForCompare);
        System.out.println("Expected Fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify user should not be able to view the select option and Green bar should display for the default Vendor ID
    public void userClicksOnHoldMultipleVendorClaim() {
        explicitElementClickableWait(findElementByXpath(txtOnHoldClaimNumber), 60);
        expMultipleVendorClaimNumber = prop.getProperty("onHoldMultipleVendorClaimNumber");
        findElementAndSendKeys(findElementByXpath(txtOnHoldClaimNumber), expMultipleVendorClaimNumber);
        sendKeysUsingKeyboardInput(txtOnHoldClaimNumber);
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleOnHoldClaimNumber), 20, expMultipleVendorClaimNumber);
        clickElement(eleOnHoldClaimNumber);
    }

    public void userHasMultipleVendors() {
        explicitElementClickableWaitByXpath(eleVendorId, 60);
        int expVendor = Integer.parseInt(findElementByXpath(eleLastRowOnPage).getText());
        System.out.println(expVendor);
        if (expVendor > 1) {
            Assert.assertTrue(true);
        } else {
            Assert.fail(expVendor + " doesn't have multiple vendors");
        }
    }

    public void userViewsSelectButton(String expButton) {
        List<WebElement> selectButtons = findElementsByXpath(lstSelectButton);
        int count = 0;
        for (WebElement button : selectButtons) {
            String expDefaultVendor = button.getAttribute("style");
            if (!expDefaultVendor.contains("display: none")) {
                count++;
                System.out.println("Select button text" + button.getText());
                Assert.assertEquals(expButton, button.getText());
            }
        }
        if (count == 0) {
            Assert.fail("Default vendor is not selected");
        }
    }

    public void verifyGreenBar() {
        String actColor = getColorCodeForBackground(eleGreenBar);
        expColor = prop.getProperty("greenBar");
        System.out.println("actual color code :" + actColor);
        Assert.assertEquals(expColor, actColor);
    }

    //  Scenario: Verify user able to select the default Vendor ID on clicking the Select button
    public void userClicksOnSelectButtonForOtherVendorID() {
        explicitElementClickableWaitByXpath(eleVendorId, 60);

        List<WebElement> selectButtons = findElementsByXpath(lstSelectButton);
        for (WebElement button : selectButtons) {
            String expDefaultVendor = button.getAttribute("style");
            if (!expDefaultVendor.contains("display: none")) {
                clickElement(button);
            }
        }
    }

    public void verifyVendorShouldBeDefaultAfterSelected() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(elePayToProvider), 20, "Provider");
        int count = 0;
        List<WebElement> selectButtons = findElementsByXpath(eleSelect);
        for (WebElement button : selectButtons) {
            String expDefaultVendor = button.getAttribute("style");
            if (expDefaultVendor.contains("display: none")) {
                count++;
                System.out.println("Attribute value is " + button.getAttribute("style"));
                Assert.assertTrue(true);
            }
        }
        if (count == 0) {
            Assert.fail("Default vendor is not selected");
        }
    }

    //  Scenario: Verify user able to view the pagination, cancel and close buttons for Map Pay To Provider Side Drawer
    public void verifyCancelCloseButtons(String expCancelButton, String expCloseButton) {
        explicitElementClickableWaitByXpath(eleVendorId, 60);
        scrollToElement(btnCancel);
        explicitTextToBePresentInElementLocatedWait(By.xpath(btnCancel), 30, "Cancel");
        Assert.assertEquals(expCancelButton, findElementByXpath(btnCancel).getText());
        Assert.assertEquals(expCloseButton, findElementByXpath(btnClose).getAttribute("aria-label"));
    }

    public void verifyPaginationButtons() {
        expFirstPage = prop.getProperty("expFirst");
        Assert.assertEquals(expFirstPage, findElementByXpath(btnFirstPage).getAttribute("aria-label"));
        expPreviousPage = prop.getProperty("expPrevious");
        Assert.assertEquals(expPreviousPage, findElementByXpath(btnPreviousPage).getAttribute("aria-label"));
        expNextPage = prop.getProperty("expNext");
        Assert.assertEquals(expNextPage, findElementByXpath(btnNextPage).getAttribute("aria-label"));
        expLastPage = prop.getProperty("expLast");
        Assert.assertEquals(expLastPage, findElementByXpath(btnLastPage).getAttribute("aria-label"));
    }

    //  Scenario: Verify user able to perform click functionality on cancel and close buttons
    public void userClicksOnCloseButton() {
        explicitElementClickableWait(findElementByXpath(btnClose), 30);
        clickElement(btnClose);
    }

    public void userClicksOnCancelButton() {
        explicitElementClickableWait(findElementByXpath(btnCancel), 30);
        clickElement(btnCancel);
    }

    //  Scenario: Verify user should navigate to Provider window on clicking Provider ID under Group/Rendering Provider Details table
    public void userClicksOnProviderIDUnderGroupRenderingProvider() {
        explicitElementClickableWait(findElementByXpath(lnkProviderId), 20);
        clickElement(lnkProviderId);
        explicitTextToBePresentInElementLocatedWait(By.xpath(titleBasicInfoSubtab), 20, "Basic Information");
    }

    public void verifyUserNavigatesToProviderWindow() {
        expWindow = prop.getProperty("expProviderWindow");
        Assert.assertEquals(expWindow, findElementByXpath(titleProviderWindow).getAttribute("ng-reflect-ng-class"));
    }

    //  Scenario: Verify user should able to see sub-tabs in provider window
    public void verifyTheSubtabs(DataTable expSubtabs) {
        List<String> subtabsExp = expSubtabs.asList();
        List<String> actSubtabs = findElementsByXpath(lstSubtabs)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actSubtabs.size());
        System.out.println("Subtabs should display:" + actSubtabs);
        System.out.println("Expected subtabs are: " + subtabsExp);
        Assert.assertEquals(subtabsExp, actSubtabs);
    }

    public void userNavigatesToBasicInformationSubtabByDefault() {
        expSubtab = prop.getProperty("expBasicInfo");
        Assert.assertEquals(expSubtab, findElementByXpath(titleBasicInfoSubtab).getText());
    }

    //  Scenario: Verify Basic Information tab in Provider details screen
    public void verifyFieldsUnderProviderBasicInfoSubtab(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<String> actFields = findElementsByXpath(lstProviderBasicInfoFields)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actFields.size());
        System.out.println("Fields should display:" + actFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, actFields);
    }

    // Scenario: Verify Facility Name section in Basic Information tab
    public void verifySpecialityAndFacilityNameFields(String expFacilityName) {
        Assert.assertEquals(expFacilityName, findElementByXpath(eleFacilityName).getText());
        String actValue = findElementByXpath(eleSpeciality).getText();
        Assert.assertTrue(actValue.contains("Speciality"));
    }

    public void verifyFieldsUnderFacilityName(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<String> actFields = findElementsByXpath(lstFacilityName)
                .stream().map((e) -> e.getText().trim()).toList();
        System.out.println("Size: " + actFields.size());
        System.out.println("Fields should display:" + actFields);
        System.out.println("Expected fields are: " + fieldsExp);
        for (String field : fieldsExp) {
            if (actFields.contains(field)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(field + " is not displayed");
            }
        }
    }

    // Scenario: Verify Adverse Actions section in Basic Information tab
    public void verifyFieldsUnderAdverseActionsSection(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<String> actFields = findElementsByXpath(lstAdverseActions)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actFields.size());
        System.out.println("Fields should display:" + actFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, actFields);
    }

    //  Scenario: Verify Comments section in Basic Information tab
    public void verifyFieldsUnderCommentsSection(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        List<String> actFields = findElementsByXpath(lstCommentSection)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size: " + actFields.size());
        System.out.println("Fields should display:" + actFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(fieldsExp, actFields);
    }

    //  Scenario: Verify user should navigate to Contract Name window on clicking contract name hyperlink in Provider Details tab
    public void userClicksOnContractName() {
        explicitElementClickableWait(findElementByXpath(lnkContractName), 20);
        clickElement(lnkContractName);
    }

    public void verifyPayClassUnderContractNameWindow() {
        explicitTextToBePresentInElementLocatedWait(By.xpath(titlePayClass), 20, expPayClass);
        expPayClass = prop.getProperty("expPayClass");
        Assert.assertEquals(expPayClass, findElementByXpath(titlePayClass).getText());
    }

    //  Scenario: Verify Pay Class and Exceptions sections in contract window
    public void verifyExceptionSection() {
        expException = prop.getProperty("expExceptionSection");
        Assert.assertEquals(expException, findElementByXpath(titleException).getText());
    }

    //  Scenario: Verify Pay class section fields in contract window
    public void verifyFieldsInPayClass(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        explicitElementClickableWait(findElementByXpath(lstPayClassFields), 20);
        List<WebElement> actColumnFields = findElementsByXpath(lstPayClassFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + actColumnFields.size());
        for (WebElement column : actColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields should display:" + columnFieldsForCompare);
        System.out.println("Expected Fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //   Scenario: Verify Exceptions CPT fields in contract window
    public void verifyFieldsInCPTSection(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        explicitElementClickableWait(findElementByXpath(lstCPTFields), 20);
        List<WebElement> actColumnFields = findElementsByXpath(lstCPTFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + actColumnFields.size());
        for (WebElement column : actColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields should display:" + columnFieldsForCompare);
        System.out.println("Expected Fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify Exceptions Revenue Code fields in contract window
    public void userClicksOnRevenueCodeSection() {
        explicitElementClickableWait(findElementByXpath(btnRevenueCode), 20);
        clickElement(btnRevenueCode);
    }

    public void verifyFieldsInRevenueCode(DataTable expFields) {
        List<String> fieldsExp = expFields.asList();
        explicitElementClickableWait(findElementByXpath(lstRevenueCodeFields), 30);
        List<WebElement> actColumnFields = findElementsByXpath(lstRevenueCodeFields);
        List<String> columnFieldsForCompare = new ArrayList<>();
        System.out.println("Size " + actColumnFields.size());
        for (WebElement column : actColumnFields) {
            scrollIntoView(column, driver);
            String text = column.getText();
            columnFieldsForCompare.add(text);
        }
        System.out.println("Fields should display:" + columnFieldsForCompare);
        System.out.println("Expected Fields are : " + fieldsExp);
        for (String exp : fieldsExp) {
            if (columnFieldsForCompare.contains(exp)) {
                Assert.assertTrue(true);
            } else {
                Assert.fail(exp + " is not listed in actual list");
            }
        }
    }

    //  Scenario: Verify Location Information tab in Provider Details screen
    public void userClicksOnLocationInfo(){
        explicitElementClickableWaitByXpath(tabLocationInfo, 30);
        clickElement(tabLocationInfo);
    }

    public void userNavigatesToLocationInfoSubtab(String expSubtab){
        Assert.assertEquals(expSubtab, findElementByXpath(tabLocationInfo).getText());
    }

    public void verifyPracticeLocationList(DataTable expFields){
        explicitElementClickableWaitByXpath(lstPracticeLocation, 30);
        compare2Lists(expFields, lstPracticeLocation);
    }

    //  Scenario: Verify Contract Information tab in Provider Details screen
    public void userClicksOnContractInfo(){
        explicitElementClickableWaitByXpath(tabContractInfo, 20);
        clickElement(tabContractInfo);
    }

    public void userNavigatesToContractInfoSubtab(String expSubtab){
        Assert.assertEquals(expSubtab, findElementByXpath(tabContractInfo).getText());
    }

    public void verifyFieldsUnderContractList(DataTable expFields){
        explicitElementClickableWaitByXpath(lstContract, 30);
        compare2Lists(expFields, lstContract);
    }

    //  Scenario: Verify Alias Information tab in Provider Details screen
    public void userClicksOnAliasInfo(){
        explicitElementClickableWaitByXpath(tabAliasInfo, 20);
        clickElement(tabAliasInfo);
    }

    public void verifyUserNavigatesToAliasInfo(String expSubtab){
        Assert.assertEquals(expSubtab, findElementByXpath(tabAliasInfo).getText());
    }

    public void verifyProviderAliasList(DataTable expFields){
        explicitElementClickableWaitByXpath(lstAliasInfo, 30);
        compare2Lists(expFields, lstAliasInfo);
    }

    //  Scenario: Verify user should be able to navigate Map Provider window on clicking Map Provider button in Provider Details tab
    public void userClicksOnMapProviderButton(){
        explicitElementClickableWaitByXpath(btnMapProvider, 20);
        clickElement(btnMapProvider);
    }

    public void verifyUserNavigatesToMapPayProvider(String expWindow){
        Assert.assertEquals(expWindow, findElementByXpath(titleMapRenderingProvider).getText());
    }

    //  Scenario: Verify user should able to validate Tax ID/SSN in Map Provider window
    public void verifyFields(String expField1, String expField2){
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleTaxID), 20, expField1);
        Assert.assertEquals(expField1, findElementByXpath(eleTaxID).getText());
        explicitTextToBePresentInElementLocatedWait(By.xpath(eleRenderingProvider), 20, expField2);
        Assert.assertEquals(expField2, findElementByXpath(eleRenderingProvider).getText());
    }

    public void verifyRenderingProvider(DataTable expFields) {
        explicitElementClickableWaitByXpath(lstRenderingProvider, 30);
        compare2Lists(expFields, lstRenderingProvider);
    }
}