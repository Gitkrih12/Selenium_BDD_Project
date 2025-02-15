package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends SeleniumUtils {

    By usernameTxt = By.id("username");
    By passwordTxt = By.name("pw");
    By loginBtn = By.name("Login");
    By createBtn = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[1]/div/div/section/div/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[1]/div/div/a/span");
    By userBtn = By.xpath("/html/body/div[4]/div[1]/section/div[1]/div/div[2]/div[2]/section[1]/div/div/section/div/div[2]/div/div/div/div[1]/div/div[2]/div/div/div[2]/div/ul/li[1]/a/div/div/span/span");


    public void enter_app_username() throws InterruptedException {
        WebElement username1 = explicitElementClickableWait(usernameTxt, 10);
        username1.sendKeys("rao@company.sandbox");
    }

    public void enter_app_password() throws InterruptedException {
        WebElement password1 = explicitElementClickableWait(passwordTxt, 10);
        password1.sendKeys("Iamkrkahach@123");
    }

    public void click_login_button() throws InterruptedException {
        explicitElementClickableWait(loginBtn, 10).click();
//        threadSleep(2000);
//        boolean status = driver.getPageSource().contains("Login Successfully");
//        Assert.assertTrue("Login was not successful", status);
    }

    public void click_create_btn() throws InterruptedException {
        explicitElementClickableWait(createBtn, 20).click();

    }
    public void click_user_btn() throws InterruptedException {
        explicitElementClickableWait(userBtn, 20).click();
        threadSleep(5000);
    }
}
//



//    //    By usernameTxt = By.name("userName");
//    By passwordTxt = By.xpath("//*[@id=\"menuList\"]/li[1]");
//    By loginBtn = By.name("Claims");
//    By enterClaim = By.xpath("//input[@name='txtClaimNo']");
//    By mainFrameName = By.cssSelector("#fraMain");
//    By clicksearchbtn = By.name("btnQuery");
//
//
//    public void enter_app_password() {
//        explicitElementClickableWait(passwordTxt, 10).click();
////        boolean status = driver.getPageSource().contains("Login Successfully");
////        Assert.assertTrue("Login was not successful", status);
//
//    }
//
//    public void click_login_button() throws InterruptedException {
//        explicitElementClickableWait(loginBtn, 10).click();
//        Thread.sleep(2000);
////        boolean status = driver.getPageSource().contains("Login Successfully");
////        Assert.assertTrue("Login was not successful", status);
//    }
//
//    public void enter_clm_number() throws Exception {
////        WebElement username1 = explicitElementClickableWait(enterclaim, 10);
////        explicitElementClickableWait(enterclaim, 10).sendKeys("25024E00381");
//        Thread.sleep(2000);
////        explicitElementClickableWait(mainFrameName, 10);
////        WebElement ele = findElement(mainFrameName);
////        explicitFrameWait(ele, 10);
//        printStatementInGreenColor("Switching to frame......", "");
//        driver.switchTo().frame(1);
//        printStatementInGreenColor("Switched to frame", "");
////        switchToFrame("fraMain");
//        WebElement el = explicitElementClickableWait(enterClaim, 10);
//        printStatementInGreenColor("Clicking on claim number", "");
//        el.sendKeys("1234567");
//        printStatementInGreenColor("Entered claim number", "1234567");
////        username1.sendKeys("25024E00381");
//    }
//
//    public void click_claimsearch_button()
//
//    {
//        explicitElementClickableWait(clicksearchbtn, 10).click();
////      boolean status = driver.getPageSource().contains("Login Successfully");
////      Assert.assertTrue("Login was not successful", status);
//    }
//}

