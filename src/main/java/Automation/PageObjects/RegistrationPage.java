package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class RegistrationPage extends SeleniumUtils {

    By firstnameTxt = By.xpath("//*[@id='name_firstName']");
    By lastnameTxt = By.xpath("//*[@name=\"name_lastName\"]");
    By emailTxt = By.xpath("//*[@name=\"Email\"]");
    By titleTxt = By.xpath("//*[@id=\"Title\"]");
    By savBtn = By.xpath("//*[@name=\"save\"]");

    public void enter_firstname() throws Exception {
//        switchToFrame("0");
        explicitFrameWait(0, 10);
        WebElement firstname1 = explicitElementClickableWait(firstnameTxt, 10);
        firstname1.sendKeys("lice");

    }
    public void enter_lastName() throws InterruptedException {
        WebElement lastname1 = explicitElementClickableWait(lastnameTxt, 10);
        lastname1.sendKeys("lvoc");
    }

    public void enter_emailAddress() throws InterruptedException {
        WebElement email1 = explicitElementClickableWait(emailTxt, 10);
        email1.sendKeys("lvink@yahoo.com");
    }

    public void enter_titleName() throws InterruptedException {
        WebElement titlename1 = explicitElementClickableWait(titleTxt, 10);
        titlename1.sendKeys("user registration");
    }

    public void click_saveBtn() throws InterruptedException {
        explicitElementClickableWait(savBtn, 10).click();
        threadSleep(5000);
    }
}
