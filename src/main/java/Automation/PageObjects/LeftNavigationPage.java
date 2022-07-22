package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LeftNavigationPage extends SeleniumUtils {

    String mnuLeftNavigation = "//mat-nav-list[@class='mat-nav-list mat-list-base']";
    String btnAdjudicationExpansion = "//div[contains(text(),'Adjudication')]//following::span[1]";
    String btnQueueManagementExpansion = "//div[contains(text(),'Queue Management')]//following::span[1]";
    String expandedExpText = "rotate(180deg)";
    String collapsedExpText = "rotate(0deg)";
    String tglClaimsAdj = "//div[@class='menu']//img";
    String attClaimsAdj = "//*[@class='mat-drawer-content']";
    String attClaimsAdjCollapsedExpStatus = "25px";
    String tglClaimsAdjCollapsed = "//span[contains(@class, 'hamburger-icon')]//img";
    String attClaimsAdjExpandedExpStatus = "271px";
    String mnuMainItems = "//div[@class='menuitemsnames']/../..//following::span[1]";
    String mnuAccountManagement = "//div[contains(text(),'Account Management')]";
    String mnuArLedger = "//div[contains(text(),'A/R Ledger')]";
    String mnuAdjudicationList = "(//div[contains(@class,'mat-expansion-panel-body')])[1]//div[@class='menuitemschaild']";
    String mnuCheckManagement = "//div[contains(text(),'Check Management')]";
    String mnuCheckManagementList = "(//div[contains(@class,'mat-expansion-panel-content')])[6]//div[@class='menuitemschaild']";
    String mnuFeeSchedule = "//div[contains(text(),'Fee Schedule')]";
    String mnuMedicare = "//div[contains(text(),'Medicare')]";
    String mnuMedicaid = "//div[contains(text(),'Medicaid')]";
    String mnuFileManagement = "//div[contains(text(),'File Management')]";
    String mnuFileManagementList = "(//div[contains(@class,'mat-expansion-panel-body')])[3]//div[@class='menuitemschaild']";
    String mnuMemberManagement = "//div[normalize-space()='Member Management']";
    String mnuMemberManagementList = "(//div[contains(@class,'mat-expansion-panel-body')])[7]//div[@class='menuitemschaild']";
    String mnuQueueManagementList = "(//div[contains(@class,'mat-expansion-panel-body')])[2]//div[@class='menuitemschaild']";
    String mnuReports = "//div[normalize-space()='Reports']";
    String mnuReportsList = "//div[contains(text(),'SSRS Reports')]";
    String mnuSettings = "//div[normalize-space()='Settings']";
    String mnuPlainLanguage = "//div[contains(text(),'Plain Language')]";
    String mnuInstructions = "//div[contains(text(),'Instructions')]";
    String mnuUserManagement = "//div[contains(text(),'User Management')]";
    String mnuManageUsers = "//div[contains(text(),'Manage Users')]";
    String mnuManageRole = "//div[contains(text(),'Manage Role')]";


    public void leftNavigationValidation() {
        boolean leftNavigationStatus = isDisplayed(mnuLeftNavigation);
        System.out.println("Left navigation section status is : " + leftNavigationStatus);
        Assert.assertTrue(leftNavigationStatus);
    }

    //    Verify Adjudication section should be in expanded mode by default in left navigation mode for Admin role
    public void verifyAdjudicationMenuByDefaultInExpandableMode()
    {
        String expandActText = findElementByXpath(btnAdjudicationExpansion).getAttribute("style");
        System.out.println("Adjudication expanded menu attribute value is... " + expandActText);
        if (expandActText.contains(expandedExpText))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.fail("Adjudication menu is not in expanded mode");
        }
    }

    //    Scenario: Verify Queue Management section should be expanded mode by default in left navigation mode for Admin role
    public void verifyQueueManagementMenuByDefaultInExpandableMode()
    {
        String expandActText = findElementByXpath(btnQueueManagementExpansion).getAttribute("style");
        System.out.println("Queue management expanded menu attribute value is... " + expandActText);
        if (expandActText.contains(expandedExpText))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.fail("Queue management menu is not in expanded mode");
        }
    }


    //    Scenario:  Validate expanding collapsing action for all menu's in left navigation for admin role
    public void validateExpandAndCollapseActionsForAllLeftNavigationMenus() {
        List<WebElement> menuList = findElementsByXpath(mnuMainItems);
        String actualText = null;

        //Expand validation for Adjudication and Queue management menus
        try {
            for (int i = 0; i < 2; i++) {
                actualText = menuList.get(i).getAttribute("style");
                if (actualText.contains(expandedExpText))
                {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }
            System.out.println("Expanded status for Adjudication & Queue management is : " + actualText.contains(expandedExpText));
        } catch (Exception e) {
            System.out.println("Exception in validating Adjudication & Queue management expanded menus " + e);
        }

        //Collapse validation for Adjudication and Queue management menus
        try
        {
            for (int i = 0; i<2; i++)
            {
                menuList.get(i).click();
                threadSleep(500);

                actualText = menuList.get(i).getAttribute("style");
                if (actualText.contains(collapsedExpText)) {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }
            System.out.println("Collapsed status for Adjudication & Queue management is: " + actualText.contains(collapsedExpText));
        }catch (Exception e)
        {
            System.out.println("Exception in validating Adjudication & Queue management collapsed menus " + e);
        }

        //Collapse validation for other menus except Adjudication and Queue management menus
        try
        {
            for (int i = 2; i<menuList.size(); i++)
            {
                actualText = menuList.get(i).getAttribute("style");
                if (actualText.contains(collapsedExpText)) {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }
            System.out.println("Collapsed status for other menus is : " + actualText.contains(collapsedExpText));
        }catch (Exception e)
        {
            Assert.fail("Exception in validating collapsed menus " + e);
        }

        //Expand validation for other menus Adjudication and Queue management menus
        try
        {
            for (int i = 2; i<menuList.size(); i++)
            {
                menuList.get(i).click();
                threadSleep(500);
                actualText = menuList.get(i).getAttribute("style");
                if (actualText.contains(expandedExpText))
                {
                    Assert.assertTrue(true);
                }
                else
                {
                    Assert.assertTrue(false);
                }
            }
            System.out.println("Expanded status for other menus is : " + actualText.contains(expandedExpText));
        }catch (Exception e)
        {
            Assert.fail("Exception in expanding menus " + e);
        }
    }

    //    Scenario: Validate Account Management Menu for admin role
    public void validateARLedgerMenu()
    {
        clickElement(mnuAccountManagement);
        moveToElement(mnuArLedger).perform();
        Assert.assertTrue(isDisplayed(mnuArLedger));
        System.out.println("AR Ledger menu status is : " + isDisplayed(mnuArLedger));
    }

    //    Scenario: Validate Adjudication Menu for admin role
    public void validateAdjudicationSubMenusForAdmin(DataTable adjList)
    {
        List<String> adjListExp = adjList.asList();
        List<WebElement> adjSubMenusList = findElementsByXpath(mnuAdjudicationList);
        List<String> adjListAct = new ArrayList<>();

        for (WebElement list:adjSubMenusList)
        {
            String text = list.getText();
            adjListAct.add(text);
        }
        System.out.println("Actual adjudication list : " + adjListAct);
        System.out.println("Expected adjudication list : " + adjListExp);

        for (String exp: adjListExp)
        {
            if (adjListAct.contains(exp))
            {
                Assert.assertTrue(true);
            }
            else
            {
                Assert.fail(exp + " is not listed in actual list");
            }

        }

    }

    //    Scenario: Validate Check Management Menu for admin role
    public void validateCheckManagementSubMenus(DataTable checkManagementList) throws InterruptedException {

        List<String> checkManagementListExp = checkManagementList.asList();
        clickElement(mnuCheckManagement);
        List<WebElement> checkMngmtSubMenusList = findElementsByXpath(mnuCheckManagementList);
        List<String> checkManagementListAct = new ArrayList<>();

        for (WebElement checkList: checkMngmtSubMenusList)
        {
            moveToElement(checkList).perform();
            String text = checkList.getText();
            checkManagementListAct.add(text);
        }
        System.out.println("Actual check management list is : " + checkManagementListAct);
        System.out.println("Expected check management list is : " + checkManagementListExp);

        for (String exp: checkManagementListExp)
        {
            if (checkManagementListAct.contains(exp))
            {
                Assert.assertTrue(true);
            }
            else
            {
                Assert.fail(exp + " value is not listed in actual list");
            }
        }
    }

    //    Scenario: Validate expanding collapsing left navigation menu on clicking Menu Toggle for admin role
    public void clickOnClaimsAdjudicationToggleMenu()
    {
        clickElement(tglClaimsAdj);
    }
    public void verifyCollapsedStatusForClaimsAdjudicationToggleMenu()
    {
        String claimsAdjCollapsedAttAct = getAttribute(attClaimsAdj, "style");
        System.out.println("Claims Adjudication toggle attribute value in collapsed mode: " + claimsAdjCollapsedAttAct);
        if (claimsAdjCollapsedAttAct.contains(attClaimsAdjCollapsedExpStatus))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.fail("Claims Adjudication toggle menu is not in collapsed mode");
        }

    }
    public void clickOnClaimsAdjudicationToggleMenuInCollapsableMode()
    {
        clickElement(tglClaimsAdjCollapsed);
    }
    public void verifyExpandedStatusForClaimsAdjudicationToggleMenu()
    {
        String claimsAdjExpandedAttAct = getAttribute(attClaimsAdj, "style");
        System.out.println("Claims Adjudication toggle attribute value in collapsed mode: " + claimsAdjExpandedAttAct);
        if (claimsAdjExpandedAttAct.contains(attClaimsAdjExpandedExpStatus))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.fail("Claims Adjudication toggle menu is not in expanded mode");
        }
    }

    //    Scenario: Validate Fee Schedule Menu for admin role
    public void validateFeeScheduleSubMenus()
    {
        clickElement(mnuFeeSchedule);
        moveToElement(mnuMedicare).perform();
        Assert.assertTrue(isDisplayed(mnuMedicare));
        moveToElement(mnuMedicaid).perform();
        Assert.assertTrue(isDisplayed(mnuMedicaid));
        System.out.println("Fee Schedules sub menus status is : " + (isDisplayed(mnuMedicare) && isDisplayed(mnuMedicaid)));
    }

    //    Scenario: Validate File Management Menu for admin role
    public void validateFileManagementSubMenus(DataTable fileManagementList)
    {
        List<String> fileManagementListExp = fileManagementList.asList();
        clickElement(mnuFileManagement);
        List <WebElement> fileManagementSubMenusList = findElementsByXpath(mnuFileManagementList);
        List<String> fileManagementListAct = new ArrayList<>();

        for (WebElement fileList : fileManagementSubMenusList)
        {
            moveToElement(fileList).perform();
            String text = fileList.getText();
            fileManagementListAct.add(text);
        }
        System.out.println("Actual file management list:  " + fileManagementListAct);
        System.out.println("Expected file management list: " + fileManagementListExp);
        for (String exp: fileManagementListExp)
        {
            if(fileManagementListAct.contains(exp))
            {
                Assert.assertTrue(true);
            }
            else
            {
                Assert.fail(exp + " value is not listed in actual list");
            }
        }
    }



}