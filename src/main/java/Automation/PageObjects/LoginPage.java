package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginPage extends SeleniumUtils {

    String Title_HomePage = "Welcome: Mercury Tours";
    String name_UserName = "userName";
    String name_Password = "password";
    String name_Submit = "submit";

    String Title_Login = "Login: Mercury Tours";

    public void Application_HomePage_Validation()
    {
        log = LogManager.getLogger(LoginPage.class.getName());

        if(getTitle().equals(Title_HomePage))
        {
            log.info("URL launched");
            Assert.assertTrue(true);
        }
        else
        {
            log.error("Unable to launch URL");
            Assert.assertTrue(false);
        }

    }
    public void Application_Login_Validation(String UName, String pwd)
    {
        log.info("User name is entered");
        WebElement userName = findElementByName(name_UserName); //convert it to element using existing methods
        explicitVisibilityOfWait(userName,5); //pass the element to wait method
        userName.sendKeys(UName);  //perform action

        log.info("Password is entered");
        findElementByName(name_Password).sendKeys(pwd);
        log.info("Clicked on Submit button");
        findElementByName(name_Submit).click();

    }
    public void Application_SignIn_Validation()
    {
        if(getTitle().equals(Title_Login))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }
    public void Application_Logout_Validation()
    {
        clickElement("//a[contains(text(), 'SIGN-OFF')]");

        if(getTitle().equals("Welcome: Mercury Tours1"))
        {
            Assert.assertTrue(true);
        }
        else
        {
            log.error("Failed to log out from application");
            Assert.assertTrue(false);
        }

    }

}