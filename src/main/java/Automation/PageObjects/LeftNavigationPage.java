package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class LeftNavigationPage extends SeleniumUtils {

    String mnuLeftNavigation = "//mat-nav-list[@class='mat-nav-list mat-list-base']";
    String expandedExpText = "rotate(180deg)";
    String collapsedExpText = "rotate(0deg)";
    String mnuMainItems = "//div[@class='menuitemsnames']/../..//following::span[1]";
    String mnuAccountManagement = "//div[contains(text(),'Account Management')]";
    String mnuArLedger = "//div[contains(text(),'A/R Ledger')]";
    String mnuAdjudicationList = "(//div[contains(@class,'mat-expansion-panel-body')])[1]//div[@class='menuitemschaild']";
    String mnuCheckManagement = "//div[contains(text(),'Check Management')]";
    String mnuCheckManagementList = "(//div[contains(@class,'mat-expansion-panel-body')])[6]//div[@class='menuitemschaild']";
    String mnuFeeSchedule = "//div[contains(text(),'Fee Schedule')]";
    String mnuMedicare = "//div[contains(text(),'Medicare')]";
    String mnuMedicaid = "//div[contains(text(),'Medicaid')]";
    String mnuFileManagement = "//div[contains(text(),'File Management')]";
    String mnuFileManagementList = "//div[@class='mat-expansion-panel-body ng-tns-c181-7']//div[@class='menuitemschaild']";
    String mnuMemberManagement = "//div[normalize-space()='Member Management']";
    String mnuMemberManagementList = "//div[@class='mat-expansion-panel-body ng-tns-c181-15']//div[@class='menuitemschaild']";
    String mnuQueueManagementList = "//div[@class='mat-expansion-panel-body ng-tns-c181-5']//div[@class='menuitemschaild']";
    String mnuReports = "//div[normalize-space()='Reports']";
    String mnuReportsList = "//div[contains(text(),'SSRS Reports')]";
    String mnuSettings = "//div[normalize-space()='Settings']";
    String mnuPlainLanguage = "//div[contains(text(),'Plain Language')]";
    String mnuInstructions = "//div[contains(text(),'Instructions')]";

    public void leftNavigationValidation() {
        boolean leftNavigationStatus = isDisplayed(mnuLeftNavigation);
        System.out.println("Left navigation section status is : " + leftNavigationStatus);
        Assert.assertTrue(leftNavigationStatus);
    }

    //    Scenario:  Validate expanding collapsing action for all menu's in left navigation for admin role
    public void validateExpandAndCollapseActionsForAllLeftNavigationMenus() {
        List<WebElement> menuList = findElementsByXpath(mnuMainItems);
        String actualText = null;

        //Expand validation for Adjudication and Queue management menus
        try {
            for (int i = 0; i < 2; i++) {
                actualText = menuList.get(i).getAttribute("style");
                if (actualText.contains(expandedExpText)) {
                    Assert.assertTrue(true);
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
        findElementByXpath(mnuAccountManagement).click();
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

        if (adjListAct.equals(adjListExp))
        {
            Assert.assertTrue(true);
        }

    }

    //    Scenario: Validate Check Management Menu for admin role
    public void validateCheckManagementSubMenus(DataTable checkManagementList) throws InterruptedException {

        List<String> checkManagementListExp = checkManagementList.asList();
        findElementByXpath(mnuCheckManagement).click();
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

        if (checkManagementListAct.equals(checkManagementListExp))
        {
            Assert.assertTrue(true);
        }
    }


}