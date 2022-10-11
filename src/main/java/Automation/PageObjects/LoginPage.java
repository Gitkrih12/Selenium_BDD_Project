package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends SeleniumUtils {

    String titleHomePage = "Claims Adjudication";
    String lblWelcomeToClaimsAdjNg = "//div[@class='welcome']";
    String lblWelcomeToExp = "Welcome to";
    String lblClaimsAdjExp = "Claims Adjudication";
    String lblNgExp = "NG";
    String txtUserLogin = "//body/div[@id='illusion']/span[2]/p[1]";
    String txtUserLoginExp = "User Login";
    String imgHospital = "//body/div[@id='illusion']/span[1]/img[1]";
    String txtUsername = "//input[@type='email']";
    String txtPassword = "//input[@type='password']";
    String btnLogin = "(//button/img)//preceding::b";
    String lnkUsername = "navbarDropdownMenuLink"; //id
    String imgMirra = "(//p[@class='loginUser']//following::img)[1]";
    String imgValorHealthPln = "//body/div[1]/div[2]/span[1]/img[1]";
    String imgValorHealthPlnExp = "valorlogo";
    String dsnpAdminExp = "ClaimsUser";
    String lnkForgotPassword = "//a[contains(text(),'Forgot Password?')]";
    String lblPassword = "(//span/img)[4]//following::label[1]";
    String lblPasswordExp = "Password";
    String attPwdExp = "Enter Password";
    String lblUsername = "(//span/img)[3]//following::label[1]";
    String lblUsernameExp = "Username";
    String attUnameExp = "Enter Username";
    String nonDsnpAdjExp = "NONDSNPCLAIMSADJ";
    String nonDsnpAdminExp = "NONDSNPCLAIMSUSER";
    String txtUniversalSearch = "ip1"; //Id
    String attUniversalSearchBoxExp = "Enter Valid Claim Number";
    String mnuDrawer = "//div[@class='bento-menu']";
    String icnNotification = "//a//*[@class='bi bi-bell bellicon']";
    String ddlUserOptions = "//a[@id='navbarDropdownMenuLink']/img[2]";
    String btnChangePassword = "//button[contains(text(), 'Change Password')]";
    String btnLogOut = "//button[contains(text(), 'Log Out')]";
    String lnkUsername1 = "//a[@id='navbarDropdownMenuLink']";

    boolean welcomeToClaimsAdjNg;
    String userLoginText;
    String adminUsername;
    boolean imageStatus;
    String username;
    String nonDsnpAdjUsername;
    String nonDsnpAdminUsername;
    boolean mirraImage;
    boolean healthPlanImgStatus;
    boolean forgotPwdStatus;
    String dsnpAdjHomePageUrl;
    String universalPlaceHolder;


    public void accessLoginScreen() {
        log = LogManager.getLogger();
        log.info("User is on CA Home page");

        explicitVisibilityOfElementLocatedWaitByXpath(lblWelcomeToClaimsAdjNg, 30);
        boolean homePageTitle = getTitle().equals(titleHomePage);
        Assert.assertTrue(homePageTitle);
    }

    //    Scenario: Verify the "Welcome to Claims Adjudication" text along with NG in Login page screen
    public void welcomeToClaimsAdjudicationNg() {
        welcomeToClaimsAdjNg = explicitVisibilityOfElementLocatedWaitByXpath(lblWelcomeToClaimsAdjNg, 30).getText().contains(lblWelcomeToExp) &&
                explicitVisibilityOfElementLocatedWaitByXpath(lblWelcomeToClaimsAdjNg, 10).getText().contains(lblClaimsAdjExp) &&
                explicitVisibilityOfElementLocatedWaitByXpath(lblWelcomeToClaimsAdjNg, 10).getText().contains(lblNgExp);

        log.info("User sees Welcome to Claims Adjudication text");
        System.out.println("'Welcome to claims adjudication NG' text status is : " + welcomeToClaimsAdjNg);
    }

    public void verifyWelcomeToClaimsAdjudicationText() {
        Assert.assertTrue(welcomeToClaimsAdjNg);
    }


    //    Scenario: Verify "User Login" text should display in the Login screen
    public void userLoginText() {
        userLoginText = explicitVisibilityOfElementLocatedWaitByXpath(txtUserLogin, 30).getText();
        System.out.println("Text present is : " + userLoginText);
        log.info("User sees User Login text");

    }

    public void verifyUserLoginText() {
        Assert.assertEquals(txtUserLoginExp, userLoginText);
    }

    //      Scenario: Verify the hospital pictography along with the texts displayed in Login Screen
    public void hospitalImage() {
        WebElement imageElement = explicitElementClickableWaitByXpath(imgHospital, 10);
        imageStatus = isDisplayed(imageElement);
        log.info("User sees hospital image on home page");
        System.out.println("Image status is : " + imageStatus);
    }

    public void verifyHospitalImage() {
        Assert.assertTrue(imageStatus);
    }

    //    Scenario: Verify user able to login with valid username and password for DSNP adjudicator role
    public void loginWithValidUsernameAndPasswordForDsnpAdjudicator() {
        explicitVisibilityOfElementLocatedWaitByXpath(txtUsername, 30).sendKeys(prop.getProperty("dsnpAdjUsername"));
        explicitVisibilityOfElementLocatedWaitByXpath(txtPassword, 10).sendKeys(prop.getProperty("dsnpAdjPassword"));
        explicitElementClickableWaitByXpath(btnLogin, 10).click();
        username = explicitElementClickableWaitByID(lnkUsername, 60).getText();
        System.out.println("User logged in as : " + username);
    }

    public void verifyLoginWithValidUsernameAndPasswordForDsnpAdjudicator() {
        String dsnpAdjExp = prop.getProperty("dsnpAdjExp");
        Assert.assertEquals(dsnpAdjExp, username);
    }

    public void mirraLogoOnHomePage() {
        explicitVisibilityOfElementLocatedWaitByXpath(imgMirra, 30);
        mirraImage = isDisplayed(imgMirra);
        System.out.println("Image status is : " + mirraImage);
    }

    public void verifyMirraLogoOnHomePage() {
        Assert.assertTrue(mirraImage);
    }

    //    Scenario: Verify user should be able to view the "Valor Health Plan", "Insurance focused on you." texts one after the other in Login screen
    public void valorHealthPlanImage() {
        String valorHealthPlanSrc = explicitVisibilityOfElementLocatedWaitByXpath(imgValorHealthPln, 30).getAttribute("src");
        System.out.println("Health plan image source is : " + valorHealthPlanSrc);
        healthPlanImgStatus = valorHealthPlanSrc.contains(imgValorHealthPlnExp);
    }

    public void verifyValorHealthPlanImage() {
        Assert.assertTrue(healthPlanImgStatus);
    }

    //    Scenario:  Verify user views "Login" button besides rightwards arrow symbol in Login screen
    public void loginButton() {
        System.out.println("Login button status is : " + isDisplayed(btnLogin));
    }

    public void verifyLoginButton() {
        Assert.assertTrue(isDisplayed(btnLogin));
    }


    //    Scenario: Verify user able to login with valid username and password for DSNP admin role
    public void loginWithValidUsernameAndPasswordForDsnpAdmin() {
        explicitVisibilityOfElementLocatedWaitByXpath(txtUsername, 30).sendKeys(prop.getProperty("dsnpAdminUsername"));
        explicitVisibilityOfElementLocatedWaitByXpath(txtPassword, 10).sendKeys(prop.getProperty("dsnpAdminPassword"));
        explicitElementClickableWaitByXpath(btnLogin, 10).click();
    }

    public void userLoginTextForAdmin() {
        WebElement element = explicitElementClickableWaitByID(lnkUsername, 60);
        adminUsername = element.getText();
        System.out.println("User logged in as : " + adminUsername);
    }

    public void verifyLoginWithValidUsernameAndPasswordForDsnpAdmin() {
        Assert.assertEquals(dsnpAdminExp, adminUsername);
    }

    //    Scenario: Verify user views the "Forgot Password?" text in the Login page
    public void forgotPasswordMessage() {

        forgotPwdStatus = explicitVisibilityOfElementLocatedWaitByXpath(lnkForgotPassword, 30).isDisplayed();
        log.info("User sees forgot password message");
    }

    public void verifyForgotPasswordMessage() {
        Assert.assertTrue(forgotPwdStatus);
    }

    //    Scenario: Verify user views the "Password" text besides lock icon with grey field along with the inner text
    public void verifyPasswordText() {
        log.info("User sees Password label");
        Assert.assertEquals(lblPasswordExp, getText(lblPassword));
    }

    public void verifyGreyFieldUnderPasswordText() {
        Assert.assertTrue(isDisplayed(txtPassword));
    }

    public void validateEnterPasswordText() {
        String pwdAtt = getAttribute(txtPassword, "placeholder");
        System.out.println("Attribute value is : " + pwdAtt);
        Assert.assertEquals(attPwdExp, pwdAtt);
    }

    //    Scenario: Verify user views the "Username" text besides person icon with grey field along with the inner text
    public void verifyUsernameText() {
        Assert.assertEquals(lblUsernameExp, explicitVisibilityOfElementLocatedWaitByXpath(lblUsername, 30).getText());
    }

    public void verifyGreyFieldUnderUsernameText() {
        Assert.assertTrue(isDisplayed(txtUsername));
    }

    public void validateEnterUsernameText() {
        String attUname = getAttribute(txtUsername, "placeholder");
        System.out.println("Attribute value is :  " + attUname);
        Assert.assertEquals(attUnameExp, attUname);
    }

    //    Scenario: Verify user able to login with valid username and password for non DSNP adjudicator role
    public void loginWithValidUsernameAndPasswordForNonDsnpAdjudicator() {
        explicitVisibilityOfElementLocatedWaitByXpath(txtUsername, 30).sendKeys(prop.getProperty("nonDsnpAdjUsername"));
        explicitVisibilityOfElementLocatedWaitByXpath(txtPassword, 10).sendKeys(prop.getProperty("nonDsnpAdjPassword"));
        explicitElementClickableWaitByXpath(btnLogin, 10).click();
        nonDsnpAdjUsername = explicitElementClickableWaitByID(lnkUsername, 60).getText();
        System.out.println("User logged in as : " + nonDsnpAdjUsername);

    }

    public void verifyLoginWithValidUsernameAndPasswordForNonDsnpAdjudicator() {
        Assert.assertEquals(nonDsnpAdjExp, nonDsnpAdjUsername);
    }


    //    Scenario: Verify user able to login with valid username and password for non DSNP admin role
    public void loginWithValidUsernameAndPasswordForNonDsnpAdmin() {
        explicitVisibilityOfElementLocatedWaitByXpath(txtUsername, 30).sendKeys(prop.getProperty("nonDsnpAdminUsername"));
        explicitVisibilityOfElementLocatedWaitByXpath(txtPassword, 10).sendKeys(prop.getProperty("nonDsnpAdminPassword"));
        explicitElementClickableWaitByXpath(btnLogin, 10).click();
        nonDsnpAdminUsername = explicitElementClickableWaitByID(lnkUsername, 60).getText();
        System.out.println("User logged in as : " + nonDsnpAdminUsername);
    }

    public void verifyLoginWithValidUsernameAndPasswordForNonDsnpAdmin() {
        Assert.assertEquals(nonDsnpAdminUsername, nonDsnpAdminExp);
    }

    //    Scenario: Verify user lands to the home page when logged in to the CA application for both DSNP adjudicator & admin
    public void verifyUserLoginToApplicationForDsnpAdjAndAdmin() {
        loginWithValidUsernameAndPasswordForDsnpAdjudicator();
    }

    public void userIsOnHomePageForDsnpAdjAndAdmin() {
        dsnpAdjHomePageUrl = driver.getCurrentUrl();
        System.out.println("DSNP adjudicator home page URL is : " + dsnpAdjHomePageUrl);
    }

    public void verifyIfUserIsOnHomePageForDsnpAdjAndAdmin() {
        Assert.assertTrue(dsnpAdjHomePageUrl.contains("home"));
    }

    //    Scenario: Verify user should be able to view the Universal Search Place holder in home page view
    public void userLandsOnHomePage() {
        loginWithValidUsernameAndPasswordForDsnpAdjudicator();
    }

    public void universalSearchPlaceHolderFromHeaderOptions() {
        WebElement universalSearchBox = findElementByID(txtUniversalSearch);
        Assert.assertTrue(universalSearchBox.isDisplayed());
        universalPlaceHolder = getAttribute(universalSearchBox, "placeholder");
        System.out.println("Universal placeholder value is : " + universalPlaceHolder);
    }

    public void validateUniversalSearchPlaceHolderFromHeaderOptions() {
        Assert.assertEquals(attUniversalSearchBoxExp, universalPlaceHolder);
    }

    //    Scenario: Verify user should view the App Drawer icon at the top right corner in the home page view
    public void appDrawerIconFromHeaderOptions() {
        System.out.println("Drawer icon status is : " + isDisplayed(mnuDrawer));
    }

    public void validateAppDrawerIconFromHeaderOptions() {
        Assert.assertTrue(isDisplayed(mnuDrawer));
    }

    //    Scenario: Verify user should view the Notification icon in the home page screen
    public void notificationIconFromHeaderOptions() {
        System.out.println("Notification icon status is : " + isDisplayed(icnNotification));
    }

    public void validateNotificationIconFromHeaderOptions() {
        Assert.assertTrue(isDisplayed(icnNotification));
    }

    //    Scenario: Verify user views the User Options on clicking username dropdown in the home page screen
    public void userOptionsUnderUsernameDropdown() {
        findElementByXpath(ddlUserOptions).click();
        explicitTextToBePresentInElementLocatedWait(By.xpath(btnChangePassword), 10, "Change Password");
        moveToElement(btnChangePassword).perform();
        Assert.assertTrue(isDisplayed(btnChangePassword));
        System.out.println("Change password button status is : " + isDisplayed(btnChangePassword));
        moveToElement(btnLogOut).perform();
        System.out.println("Log Out button status is : " + isDisplayed(btnLogOut));
    }

    public void validateUserOptionsUnderUsernameDropdown() {
        Assert.assertTrue(isDisplayed(btnLogOut));
    }
}
