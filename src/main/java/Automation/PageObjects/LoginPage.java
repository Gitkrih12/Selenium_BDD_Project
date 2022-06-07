package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.apache.logging.log4j.LogManager;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginPage extends SeleniumUtils {

    String titleHomePage = "Welcome: Mercury Tours";
    String txtUsername = "userName";  //name
    String txtPassword = "password"; //name
    String txtSubmit = "submit";  //name

    String titleLogin = "Login: Mercury Tours";

    public void applicationHomePageValidation()
    {
        log = LogManager.getLogger(LoginPage.class.getName());

        if(getTitle().equals(titleHomePage))
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
    public void applicationLoginValidation(String UName, String pwd)
    {
        log.info("User name is entered");
        WebElement userName = findElementByName(txtUsername); //convert it to element using existing methods
        explicitVisibilityOfWait(userName,5); //pass the element to wait method
        userName.sendKeys(UName);  //perform action

        log.info("Password is entered");
        findElementByName(txtPassword).sendKeys(pwd);
        log.info("Clicked on Submit button");
        findElementByName(txtSubmit).click();

    }
    public void applicationSignInValidation()
    {
        if(getTitle().equals(titleLogin))
        {
            Assert.assertTrue(true);
        }
        else
        {
            Assert.assertTrue(false);
        }
    }

}