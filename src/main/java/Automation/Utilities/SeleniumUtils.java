package Automation.Utilities;

import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;

public class SeleniumUtils extends Driver {

    // ******************************** Important notes for testers ******************************* //
    /*
    - This class "SeleniumUtils" contains generic methods which are used in page object classes
      to handle different types of Web Elements
    - This class includes various methods related to "Windows, Mouse or Keyboard actions, dropdown buttons (Select),
      Alerts, Waits, Conditions, Element actions, Getters, Locators, Java script executor, Date & Time and
      a few Generic ones.
    - Have this class extended to page object classes or any other applicable classes wherever needed in your testing process
    - This class is already extended from "Driver" class to maintain common driver for all the related
      classes
    - Important: If any new generic methods need to be added please add them under the respective category.
      Else add them under "Generic methods" section.
     */

    // ******************* Window related methods *********************** //
    public void getWindowNamesAndSwitchToNthWindow(int x) {
        try {
            int counter = 1;
            for (String handle1 : driver.getWindowHandles()) {
                if (counter == x) {
                    driver.switchTo().window(handle1);
                }
                counter++;
            }
        } catch (Exception e) {
            Assert.fail("Window not found" + "| Error - " + e);
        }
    }

    public void switchToChildWindow() throws InterruptedException {
        try {
            Set<String> list = driver.getWindowHandles();
            Iterator<String> title = list.iterator();
            String parent = title.next();
            String Child = title.next();
            driver.switchTo().window(Child);
            Thread.sleep(2000);
        } catch (Exception e) {
            Assert.fail("Switch to window failed: " + "|Error is " + e);
        }
    }

    public String getWindowHandle() {
        String windowName = null;
        try {
            return windowName = driver.getWindowHandle();
        } catch (Exception e) {
            Assert.fail("Element not found " + "| Error " + e);
            return "Window not found";
        }
    }

    public ArrayList<String> switchTo2ndWindowHandle() {
        String window1;
        String window2;
        ArrayList<String> windows = new ArrayList<String>();
        Set<String> strHandles1 = driver.getWindowHandles();
        System.out.println("No of windows : " + strHandles1.size());
        Iterator<String> i2 = strHandles1.iterator();
        while (i2.hasNext()) {
            window1 = i2.next();
            window2 = i2.next();
            System.out.println("Window1 title is : " + driver.switchTo().window(window1).getTitle());
            System.out.println("Window2 title is : " + driver.switchTo().window(window2).getTitle());
            windows.add(window1);
            windows.add(window2);
        }
        return windows;
    }

    public void switchToWindow(String window) {
        try {
            driver.switchTo().window(window);
        } catch (Exception e) {
            Assert.fail("element not found | Error - " + e);
        }
    }

    public Set<String> getWindowHandles() {
        try {
            Set<String> handles = driver.getWindowHandles();
            return handles;
        } catch (Exception e) {
            Assert.fail("Error in getting window handles" + "|Error - " + e);
            return null;
        }
    }

    public void switchToWindowWithGivenTitle(String title) {
        try {
            boolean flag = false;
            Set<String> handles1 = driver.getWindowHandles();
            for (String hd : handles1) {
                driver.switchTo().window(hd);
                System.out.println("Available title is: " + driver.getTitle());
                if (driver.getTitle().equals(title)) {
                    System.out.println("Driver switch to window with title :  " + title);
                    flag = true;
                    break;
                }
            }
            if (flag = false) {
                Assert.fail("Required window not found");
            }
        } catch (Exception e) {
            Assert.fail("Window not found | Error - " + e);
        }
    }
    // ******************* End of Window related methods ****************** //


    //******************** Mouse or Keyboard Action related methods ************************  //
    public void doubleClick(String xpath) {
        try {
            Actions action = new Actions(driver);
            action.moveToElement(driver.findElement(By.xpath(xpath))).doubleClick().perform();
        } catch (Exception e) {
            Assert.fail("Element is not found " + xpath + "Error - " + e);
        }
    }

    public void rightClick(WebElement element)
    {
        try
        {
            Actions act= new Actions(driver);
            act.moveToElement(element).contextClick().perform();
        }catch (Exception e)
        {
            Assert.fail("Element not found " + element + "Error - " + e);
        }
    }


    public void moveToElementAndClick(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Actions act = new Actions(driver);
            act.moveToElement(element).click().perform();
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "|Error - " + e);
        }
    }

    public void moveToElementAndClick(WebElement element) {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(element).click().perform();
        } catch (Exception e) {
            Assert.fail("Element not found " + element + "|Error - " + e);
        }
    }

    public Actions moveToElement(String xpath)
    {
        try
        {
            WebElement element = driver.findElement(By.xpath(xpath));
            Actions act = new Actions(driver);
            Actions ele = act.moveToElement(element);
            return ele;
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public Actions moveToElement(WebElement element)
    {
        try
        {
            Actions act = new Actions(driver);
            Actions ele = act.moveToElement(element);
            return ele;
        }catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public void dragAndDrop(String srcxpath, String destxpath) {
        try {
            WebElement src = driver.findElement(By.xpath(srcxpath));
            WebElement target = driver.findElement(By.xpath(destxpath));
            Actions act = new Actions(driver);
            act.dragAndDrop(src, target).perform();
        } catch (Exception e) {
            Assert.fail("WebElement not found " + srcxpath + "  " + destxpath + "|Error - " + e);
        }
    }

    public void dragAndDrop(WebElement src, WebElement target) {
        try {
            Actions act = new Actions(driver);
            act.dragAndDrop(src, target).perform();
        } catch (Exception e) {
            Assert.fail("WebElement not found " + src + "  " + target + "|Error - " + e);
        }
    }

    public void altKeyboardInputString(String x) {
        try {
            Actions keyAction = new Actions(driver);
            keyAction.keyDown(Keys.ALT).keyDown(Keys.SHIFT).sendKeys(x).keyUp(Keys.ALT).keyUp(Keys.SHIFT).perform();
            System.out.println("Pressed and released alt+shift + " + x + "keys");
        } catch (Exception e) {
            Assert.fail("Element not found :" + x + "|Error - " + e);
        }
    }

    public void keyboardInput(String x) {
        try {
            Actions keyAction = new Actions(driver);
            keyAction.sendKeys(x).perform();
        } catch (Exception e) {
            Assert.fail("Element not found :" + x + "|Error - " + e);
        }
    }
    //******************** End of Mouse or Keyboard Action related methods ************************  //


    //******************** Select (Dropdown) related methods ************************  //
    public void selectDropdownByVisibleText(String xpath, String text) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Select dr = new Select(element);
            dr.selectByVisibleText(text);
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "| Error - " + e);
        }
    }

    public void selectDropdownByVisibleText(WebElement element, String text) {
        try {
            Select dr = new Select(element);
            dr.selectByVisibleText(text);
        } catch (Exception e) {
            Assert.fail("Element not found " + element + "| Error - " + e);
        }
    }

    public void selectDropdownByValue(String xpath, String value) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Select sel = new Select(element);
            sel.selectByValue(value);
        } catch (Exception e) {
            Assert.fail("Element not found :" + xpath + "|Error - " + e);
        }
    }

    public void selectDropdownByValue(WebElement element, String value) {
        try {
            Select sel = new Select(element);
            sel.selectByValue(value);
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
        }
    }

    public void selectDropdownByIndex(WebElement element, String index) {
        try {
            int ind = Integer.parseInt(index);
            Select sel = new Select(element);
            sel.selectByIndex(ind);
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
        }
    }

    public void selectDropdownByIndex(String xpath, String index) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Select sel = new Select(element);
            int ind = Integer.parseInt(index);
            sel.selectByIndex(ind);
        } catch (Exception e) {
            Assert.fail("Element not found :" + xpath + "|Error - " + e);
        }
    }

    public void selectDropdownByIndex(String xpath, int index) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Select sel = new Select(element);
            sel.selectByIndex(index);
        } catch (Exception e) {
            Assert.fail("Element not found :" + xpath + "|Error - " + e);
        }
    }

    public boolean verifyTextInDropDown(String xpath, String expectedString) {
        boolean flag = false;
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Select drp = new Select(element);
            List<WebElement> drpOptions = drp.getOptions();
            for (WebElement drpo : drpOptions) {
                if (drpo.getText().equalsIgnoreCase(expectedString)) {
                    System.out.println("Value present in dropdown - " + "Expected value: " + expectedString + "Actual value: " + drpo.getText());
                    flag = true;
                }
            }
            return flag;
        } catch (Exception e) {
            Assert.fail("Element not found in dropdown:" + expectedString + "|Error - " + e);
            return false;
        }
    }

    public List<String> getAllElementsFromDropDownWithBlank(String xpath) {
        try {
            List<String> AllElementsText = new ArrayList<String>();
            List<WebElement> AllElements = new ArrayList<WebElement>();
            Select dr1 = new Select(driver.findElement(By.xpath(xpath)));
            AllElements = dr1.getOptions();
            System.out.println("Size of all options : " + AllElements.size());
            for (int i = 0; i < AllElements.size(); i++) {
                String aa = AllElements.get(i).getText();
                AllElementsText.add(aa);
            }
            System.out.println("Size of getAllElements ArrayList : " + AllElementsText.size());
            return AllElementsText;
        } catch (Exception e) {
            System.out.println("Element not found " + xpath + "| Error - " + e);
            ArrayList<String> AllElement1 = new ArrayList<String>();
            AllElement1.add("Unable to get text for all options");
            return AllElement1;
        }
    }

    public List<String> getAllElementsFromDropDownWithOutBlank(String xpath) {
        try {
            List<String> AllElementsText = new ArrayList<String>();
            List<WebElement> AllElements = new ArrayList<WebElement>();
            Select dr1 = new Select(driver.findElement(By.xpath(xpath)));
            AllElements = dr1.getOptions();
            System.out.println("Size of all options: " + AllElements.size());
            for (int i = 1; i < AllElements.size(); i++) {
                String aa = AllElements.get(i).getText();
                AllElementsText.add(aa);
            }
            System.out.println("Size of getAllElements Arraylist : " + AllElementsText.size());
            return AllElementsText;
        } catch (Exception e) {
            System.out.println("Element not found " + xpath + "|Error - " + e);
            ArrayList<String> AllElement1 = new ArrayList<String>();
            AllElement1.add("Unable to get text for all options");
            return AllElement1;
        }
    }

    public String getTextOfSelectedOptionFromDropdown(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Select dr = new Select(element);
            WebElement option = dr.getFirstSelectedOption();
            return option.getText();
        } catch (Exception e) {
            System.out.println("Element not found " + xpath + "|Error - " + e);
            return "Unable to get text of selected option from dropdown";
        }
    }

    public String getTextOfSelectedOptionFromDropdown(WebElement element) {
        try {
            Select dr = new Select(element);
            WebElement option = dr.getFirstSelectedOption();
            return option.getText();
        } catch (Exception e) {
            System.out.println("Element not found " + element + "|Error - " + e);
            return "Unable to get text of selected option from dropdown";
        }
    }

    public String getValueOfSelectedOptionFromDropdown(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Select dr = new Select(element);
            String option = dr.getFirstSelectedOption().getAttribute("value");
            return option;
        } catch (Exception e) {
            System.out.println("Element not found" + xpath + "|Error - " + e);
            return "Unable to get value of selected option from dropdown";
        }
    }
    //******************** End of Select (Dropdown) related methods ************************  //


    // ************* Alert related methods **************** //
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            System.out.println("alert is present");
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public void alertPresentAccept() {
        try {
            if (isAlertPresent() == true) {
                System.out.println("Alert present is : " + driver.switchTo().alert().getText());
                driver.switchTo().alert().accept();
            } else {
                System.out.println("Alert is not present");
            }
        } catch (Exception e) {
            Assert.fail("Exception in alert accept " + e);
        }
    }

    public void alertPresentDismiss() {
        try {
            if (isAlertPresent() == true) {
                System.out.println("Alert present is : " + driver.switchTo().alert().getText());
                driver.switchTo().alert().dismiss();
            } else {
                System.out.println("Alert is not present");
            }
        } catch (Exception e) {
            Assert.fail("Exception in alert dismiss " + e);
        }
    }

    public String getTextFromAlert() {
        try {
            String text = null;
            text = driver.switchTo().alert().getText();
            System.out.println("Alert text: " + text);
            return text;
        } catch (Exception e) {
            Assert.fail("Exception in get text from alert |Error - " + e);
            return "Unable to get text from alert";
        }
    }
    // ************* End of Alert related methods **************** //



    //************ Wait related methods *************//
    /*
    -In case of direct locators convert them to Web Elements and use these methods to pass Web Element
    -This class already has all the respective methods available for all types of locators
    -Refer "Locator methods" section of this class
    */

    public void explicitWaitForWindowsCount(int n) {
        try {
            WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(45));
            wdWait.until(ExpectedConditions.numberOfWindowsToBe(n));
        } catch (Exception e) {
            Assert.fail("Number of windows found not equal to :" + n);
        }
    }

    public void implicitWait() {
        try {
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(50));
        } catch (Exception e) {
            Assert.fail("ImplicitWait method failed");
        }
    }

    public WebElement explicitElementClickableWaitByID(String id, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.elementToBeClickable(By.id(id)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement explicitElementClickableWaitByName(String name, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.elementToBeClickable(By.name(name)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement explicitElementClickableWaitByClass(String className, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.elementToBeClickable(By.className(className)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement explicitElementClickableWaitByTagName(String tagName, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.elementToBeClickable(By.tagName(tagName)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement explicitElementClickableWaitByCSSID(String cssId, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.elementToBeClickable(By.cssSelector(cssId)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement explicitElementClickableWaitByXpath(String xpath, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement explicitElementClickableWait(WebElement element, int duration) {
        try {
            WebElement element1 = new WebDriverWait(driver, Duration.ofSeconds(duration)).
            until(ExpectedConditions.elementToBeClickable(element));
            return element1;
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
            return null;
        }
    }

    public WebElement explicitVisibilityOfWait(WebElement element, int duration) {
        try {
            WebElement element1 = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.visibilityOf(element));
            return element1;
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
            return null;
        }
    }

    public WebElement explicitVisibilityOfElementLocatedWaitByID(String id, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
            until(ExpectedConditions.visibilityOfElementLocated(By.id(id)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found :" + id + "|Error - " + e);
            return null;
        }
    }

    public WebElement explicitVisibilityOfElementLocatedWaitByName(String name, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.name(name)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found :" + name + "|Error - " + e);
            return null;
        }
    }

    public WebElement explicitVisibilityOfElementLocatedWaitByClass(String className, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.className(className)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found :" + className + "|Error - " + e);
            return null;
        }
    }

    public WebElement explicitVisibilityOfElementLocatedWaitByTagName(String tagName, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.tagName(tagName)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found :" + tagName + "|Error - " + e);
            return null;
        }
    }

    public WebElement explicitVisibilityOfElementLocatedWaitByCSSID(String cssID, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssID)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found :" + cssID + "|Error - " + e);
            return null;
        }
    }

    public WebElement explicitVisibilityOfElementLocatedWaitByXpath(String xpath, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found :" + xpath + "|Error - " + e);
            return null;
        }
    }

    public boolean explicitTextToBePresentInElementWait(WebElement element, int duration, String text) {
        try {
            boolean status = new WebDriverWait(driver, Duration.ofSeconds(duration)).
            until(ExpectedConditions.textToBePresentInElement(element, text));
            return status;
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
            return false;
        }
    }

    public boolean explicitTextToBePresentInElementLocatedWait(By element, int duration, String text) {
        try {
            boolean status = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.textToBePresentInElementLocated(element, text));
            return status;
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
            return false;
        }
    }

    public boolean explicitInvisibilityOfWait(WebElement element, int duration) {
        try {
            boolean status = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.invisibilityOf(element));
            return status;
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
            return false;
        }
    }

    public boolean explicitInvisibilityOfElementLocatedWait(By element, int duration) {
        try {
            boolean status = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.invisibilityOfElementLocated(element));
            return status;
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
            return false;
        }
    }

    public boolean explicitInvisibilityOfElementWithTextWait(By element, int duration, String text) {
        try {
            boolean status = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.invisibilityOfElementWithText(element, text));
            return status;
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
            return false;
        }
    }

    public void explicitElementClassChangesWait(String xpath, int duration, String classValue)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(new ExpectedCondition<Boolean>()
        {
            public Boolean apply(WebDriver driver)
                {
                    WebElement element = driver.findElement(By.xpath(xpath));
                    String classValueInApp = element.getAttribute("class");
                    System.out.println("class: " + classValue);
                    if(classValueInApp.equals(classValue))
                        return true;
                    else
                        return false;
                }
        });
    }

    public void explicitCountChangesWait(String xpath, int duration)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver)
            {
                int elementCount = driver.findElements(By.xpath(xpath)).size();
                System.out.println("Elements count: " + elementCount);
                if (elementCount>1)
                    return true;
                else
                    return false;
            }
        });
    }

    public void explicitCountBecome1Or2Wait(String xpath, int duration)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver)
            {
                int elementCount = driver.findElements(By.xpath(xpath)).size();
                System.out.println("Elements count: " + elementCount);
                if (elementCount == 1 || elementCount == 2)
                    return true;
                else
                    return false;
            }
        });
    }

    public List<WebElement> explicitPresenceOfAllElementsLocatedByWait(By element, int duration) {
        try {
            List <WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.presenceOfAllElementsLocatedBy(element));
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
            return null;
        }
    }

    public void explicitTillElementsVisibleWait(List<WebElement> elements, int duration) {
        try {
            WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            elements.stream()
                    .filter(WebElement::isDisplayed)
                    .findFirst()
                    .orElse(null);
        } catch (Exception e) {
            Assert.fail("Elements not found :" + elements + "|Error - " + e);
        }
    }

    public void explicitAlertPresentWait(int duration) {
        try {
            WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wdWait.until(ExpectedConditions.alertIsPresent());
        } catch (Exception e) {
            Assert.fail("Alert not found |Error - " + e);
        }
    }

    public void explicitFrameWait(String frameName, int duration) throws Exception {
        try {
            System.out.println("Navigated to switchToFrameWithName (Name) method");
            WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wdWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameName));
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public void explicitFrameWait(int frameNumber, int duration) throws Exception {
        try {
            System.out.println("Navigated to switchToFrameWithFrameNumber (Int) method");
//            System.out.println("Number of frame tags :" + driver.findElement(By.tagName("iframe")));

            WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wdWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNumber));
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public void explicitFrameWait(WebElement element, int duration) throws Exception {
        try
        {
            System.out.println("Navigated to switchToFrameWithFrameNumber (Int) method");
            WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wdWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public void switchToDefaultContent()
    {
        try
        {
            driver.switchTo().defaultContent();
        }catch (Exception e)
        {
            Assert.fail("Exception in switching to default content" + e);
            e.printStackTrace();
        }
    }

    public void switchToParentFrame()
    {
        try
        {
            driver.switchTo().parentFrame();
        }catch (Exception e)
        {
            Assert.fail("Exception in switching to parent frame" + e);
            e.printStackTrace();
        }
    }


    //Provide duration in Milli Seconds. Example - 3000
    public void threadSleep(long duration) throws InterruptedException {
        try {
            Thread.sleep(duration);
        }catch (Exception e)
        {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public void waitFor2Elements(String element1, String element2) throws Exception {
        try {
            mainLoop:
            for (int j = 0; j < 6; j++) {
                for (int i = 0; i < 45; i++) {
                    if (driver.findElement(By.xpath(element1)).isDisplayed()) {
                        System.out.println("Wait for 2 elements: Able to find element1");
                        break mainLoop;
                    }
                    if (driver.findElement(By.xpath(element2)).isDisplayed()) {
                        System.out.println("Wait for 2 elements: Able to find element2");
                        break mainLoop;
                    } //end of if
                } //end of for
                Thread.sleep(5000);
            }
        } catch (Exception e) {
            System.out.println("Element is not attached to the page document" + e.getStackTrace());
        }
    }
    //************ End of Wait related methods *************//



    // ******************* Conditional related methods ***************** //
    public boolean isElementEditable(String xpath) {
        try {

            boolean element = driver.findElement(By.xpath(xpath)).isEnabled();
            if (element == true) {
                System.out.println("Element is editable");
                return true;
            } else {
                System.out.println("Element is not editable");
                return false;
            }
        } catch (Exception e) {
            Assert.fail("Element is not found" + xpath + "| Error is " + e);
            return false;
        }
    }

    public boolean isElementDisplayed(String xpath) {
        try {

            boolean element = driver.findElement(By.xpath(xpath)).isDisplayed();
            if (element == true) {
                System.out.println("Element is displayed");
                return true;
            } else {
                System.out.println("Element is not displayed");
                return false;
            }
        } catch (Exception e) {
            Assert.fail("Element is not found" + xpath + "| Error is " + e);
            return false;
        }
    }

    public boolean isElementSelected(String xpath) {
        try {

            boolean element = driver.findElement(By.xpath(xpath)).isSelected();
            if (element == true) {
                System.out.println("Element is selected");
                return true;
            } else {
                System.out.println("Element is not selected");
                return false;
            }
        } catch (Exception e) {
            Assert.fail("Element is not found " + xpath + "| Error is " + e);
            return false;
        }
    }

    public boolean isDisplayed(String xpath) {
        try {
            boolean element = driver.findElement(By.xpath(xpath)).isDisplayed();
            return element;
        } catch (Exception e) {
            System.out.println("Element not found " + xpath + "|Error - " + e);
            return false;
        }
    }

    public boolean isDisplayed(WebElement element) {
        try {
            boolean status = element.isDisplayed();
            return status;
        } catch (Exception e) {
            System.out.println("Element not found " + element + "|Error - " + e);
            return false;
        }
    }

    public boolean isEnabled(String xpath) {
        try {
            boolean element = driver.findElement(By.xpath(xpath)).isEnabled();
            System.out.println("ISEnabled method returned: " + element);
            return element;
        } catch (Exception e) {
            System.out.println("Element not found " + xpath + "|Error - " + e);
            return false;
        }
    }

    public boolean isEnabled(WebElement element) {
        try {
            boolean status = element.isEnabled();
            return status;
        } catch (Exception e) {
            System.out.println("Element not found " + element + "|Error - " + e);
            return false;
        }
    }

    public boolean isElementPresent(String xpath, boolean expected) throws Throwable {
        boolean status = false;
        boolean actualStatus = false;
        try {
            driver.findElement(By.xpath(xpath));
            status = true;
        } catch (Exception e) {
            status = false;
        }
        if (expected == status) {
            actualStatus = true;
        } else {
            actualStatus = false;
            System.out.println("IsElement present returned :" + actualStatus);
        }
        return actualStatus;
    }

    public boolean isAttributePresent(String xpath, String attribute) {
        try {
            String attributeValue = driver.findElement(By.xpath(xpath)).getAttribute(attribute);
            System.out.println("IsAttribute present returned : " + attributeValue);
            if (attributeValue.equals("null")) {
                return false;
            } else {
                return true;
            }
        } catch (Exception e) {
            System.out.println("IsAttribute present returned false");
            return false;
        }
    }
    // ******************* End of Conditional related methods ***************** //


    // ************** Element action related methods **************** //
    public void findElementAndSendKeys(WebElement element, String text) {
        try {
            element.sendKeys(text);
        } catch (Exception e) {
            Assert.fail("element not found " + element + "|Error - " + e);
        }
    }

    //Use this method by passing xpath as a parameter to click an element
    public void clickElement(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).click();
        } catch (Exception e) {
            Assert.fail("Element not found :" + xpath + "|Error - " + e);
        }
    }

    //Use this method by passing "WebElement" directly as a parameter to click an element
    public void clickElement(WebElement element) {
        try {
            element.click();
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
        }
    }

    public void clearTextBox(String xpath) {
        try {
            driver.findElement(By.xpath(xpath)).clear();
        } catch (Exception e) {
            Assert.fail("Element not found :" + xpath + "|Error - " + e);
        }
    }

    public void clearTextBox(WebElement element) {
        try {
            element.clear();
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
        }
    }

    public void clickByClass(String classname) {
        try {
            driver.findElement(By.className(classname)).click();
        } catch (Exception e) {
            Assert.fail("element not found :" + classname + "|Error - " + e);
        }
    }

    public void quit() {
        try {
            driver.quit();
        } catch (Exception e) {
            Assert.fail("Driver is not closed" + "|Error - " + e);
        }
    }

    public void close() {
        try {
            driver.close();
        } catch (Exception e) {
            Assert.fail("Driver is not closed" + "|Error - " + e);
        }
    }

    public void sendKeysUsingKeyboardInput(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            element.sendKeys((Keys.DOWN), (Keys.ENTER));
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "|Error - " + e);
        }
    }


    public String getCurrentURL() {
        try {
            String currentURL = driver.getCurrentUrl();
            System.out.println("Current URL is : " + currentURL);
            return currentURL;
        } catch (Exception e) {
            Assert.fail("Error in getting current URL" + "|Error - " + e);
            return null;
        }
    }

    public void findElementWithXpathAndsendKeys(String xpath, String text) {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(text);
        } catch (Exception e) {
            Assert.fail("element not found" + xpath + "| Error - " + e);
        }
    }

    public void clickWithLinkText(String linkText) {
        try {
            driver.findElement(By.linkText(linkText)).click();
        } catch (Exception e) {
            Assert.fail("Element not found " + linkText + "| Error - " + e);
        }
    }

    public void clearUsingKeyClass(String xpath) throws Exception {
        try {
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            driver.findElement(By.xpath(xpath)).sendKeys(Keys.DELETE);
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "| Error - " + e);
        }
    }
    // ************** End of Element action related methods **************** //


    // ************** Get related methods **************** //
    public List<String> getAllElementsToList(String xpath) {
        try {
            List<String> AllElementsText = new ArrayList<String>();
            List<WebElement> AllElements = driver.findElements(By.xpath(xpath));
            System.out.println("Size of all elements" + AllElements.size());
            for (int i = 0; i < AllElements.size(); i++) {
                String aa = AllElements.get(i).getText();
                AllElementsText.add(aa);
            }
            System.out.println("Size of getAllElements ArrayList:" + AllElementsText.size());
            return AllElementsText;
        } catch (Exception e) {
            System.out.println("Element not found | Error - " + e);
            ArrayList<String> AllElement1 = new ArrayList<String>();
            AllElement1.add("Unable to get text for all options");
            return AllElement1;
        }
    }

    public String getAttribute(WebElement element, String attribute) {
        try {
            String att = element.getAttribute(attribute);
            return att;
        } catch (Exception e) {
            Assert.fail("Attribute not found :" + attribute + "|Error - " + e);
            return "No attribute found";
        }
    }

    public String getAttribute(String xpath, String attribute) {
        try {
            String att = driver.findElement(By.xpath(xpath)).getAttribute(attribute);
            System.out.println("Attribute returned is :" + attribute);
            return att;
        } catch (Exception e) {
            Assert.fail("Attribute not found :" + attribute + "|Error - " + e);
            return "No attribute found";
        }
    }

    public String getText(String xpath) {
        try {
            String text = driver.findElement(By.xpath(xpath)).getText();
            return text;
        } catch (Exception e) {
            Assert.fail("Element not found :" + xpath + "|Error - " + e);
            return "Unable to get string text";
        }
    }

    public String getText(WebElement element) {
        try {
            String text = element.getText();
            return text;
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
            return "Unable to get string text";
        }
    }

    public void getElementCoordinates(WebElement element) {
        try {
            System.out.println("Coordinates for element :" + element.getLocation());
        } catch (Exception e) {
            Assert.fail("Element not found :" + element + "|Error - " + e);
        }
    }

    public void navigateTo(String URL) {
        try {
            driver.get(URL);
        } catch (Exception e) {
            Assert.fail("Exception in navigateTo method :" + URL + "|Error - " + e);
        }
    }

    public void screenshot(String path, String MethodName) throws SQLException, ClassNotFoundException, IOException {
        File screenshotFile2 = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date dnow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MMddyyyyhhmmss");
        org.apache.commons.io.FileUtils.copyFile(screenshotFile2, new File(path + "\\Screenshots\\" + MethodName + " - " + ft.format(dnow) + ".jpeg"));
    }

    public List<WebElement> getAllElementsWithXpath(String xpath) {
        try {
            List<WebElement> elements = driver.findElements(By.xpath(xpath));
            return elements;
        } catch (Exception e) {
            System.out.println("Elements not found " + xpath + "|Error - " + e);
            return null;
        }
    }

    public String getElementBackgroundColor(String xpath) {
        try {
            String color2 = driver.findElement(By.xpath(xpath)).getCssValue("background-color");
            String[] hexValue = color2.replace("rgba(", "").replace(")", "").split(",");

            int hexValue1 = Integer.parseInt(hexValue[0]);
            hexValue[1] = hexValue[1].trim();
            int hexValue2 = Integer.parseInt(hexValue[1]);
            hexValue[2] = hexValue[2].trim();
            int hexValue3 = Integer.parseInt(hexValue[2]);

            String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);
            return actualColor;
        } catch (Exception e) {
            System.out.println("Element not found " + xpath + "|Error - " + e);
            return null;
        }
    }

    public WebElement getWebElement(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found" + xpath + "|Error - " + e);
            return null;
        }
    }

    public String getTagName(String xpath) {
        try {
            String tagName = driver.findElement(By.xpath(xpath)).getTagName();
            return tagName;
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "| Error - " + e);
            return null;
        }
    }

    public String getCSSValue(String xpath, String propertyName) {
        try {
            String cssValue = driver.findElement(By.xpath(xpath)).getCssValue(propertyName);
            System.out.println("IsDisplayed returned : " + cssValue);
            return cssValue;
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath);
            return "Unable to get CSS value";
        }
    }

    public int getSizeofDropDown(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            List<WebElement> options = element.findElements(By.tagName("option"));
            return options.size();
        } catch (Exception e) {
            System.out.println("Element not found " + xpath + "| Error - " + e);
            return 0;
        }
    }

    public int getXcoordinate(String xpath) {
        try {
            int xcoordinate = driver.findElement(By.xpath(xpath)).getLocation().getX();
            return xcoordinate;
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "|Error - " + e);
            return 0;
        }
    }

    public int getYcoordinate(String xpath) {
        try {
            int ycoordinate = driver.findElement(By.xpath(xpath)).getLocation().getY();
            return ycoordinate;
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "|Error - " + e);
            return 0;
        }
    }

    public int getCountOfAllElementsWithTagName(String xpath, String tagName) {
        try {
            List<WebElement> count = driver.findElement(By.xpath(xpath)).findElements(By.tagName(tagName));
            System.out.println("Number of elements in getCountOfAllElementsWithTagName " + tagName + "|Size - " + count.size());
            return count.size();
        } catch (Exception e) {
            Assert.fail("Elemnets not found in getCountOfAllElementsWithTagName " + xpath + "|Error - " + e);
            return 0;
        }
    }

    public int getCountOfElementsWithSameProperty(String xpath) {
        try {
            List<WebElement> count = driver.findElements(By.xpath(xpath));
            System.out.println("Number of elements found in getCountOfElementsWithSameProperty " + count.size());
            return count.size();
        } catch (Exception e) {
            System.out.println("element not found in getCountOfElementsWithSameProperty " + xpath + "Error -" + e);
            return 0;
        }
    }

    public int getTablerowOrColCount(String xpath) {
        try {
            List<WebElement> count = driver.findElements(By.xpath(xpath));
            int size = count.size();
            return size;
        } catch (Exception e) {
            System.out.println("Element not found " + xpath + "|Error - " + e);
            return 0;
        }
    }

    public String getTitle() {
        try {
            String title = driver.getTitle();
            System.out.println("Title is : " + title);
            return title;
        } catch (Exception e) {
            System.out.println("Unable to get title");
            return "Unable to get title";
        }
    }

    public String getColorCodeForBackground(String xpath){
        try {
            String cssValue = findElementByXpath(xpath).getCssValue("background-color");
            String colorCode = Color.fromString(cssValue).asHex().toUpperCase(Locale.ROOT);
            return colorCode;
        }catch(Exception e) {
            System.out.println("Element not found " + xpath + "|Error - " + e);
            return null;
        }
    }
    public String getColorCodeForText(String xpath){
        try {
            String cssValue = findElementByXpath(xpath).getCssValue("color");
            String colorCode = Color.fromString(cssValue).asHex().toUpperCase(Locale.ROOT);
            return colorCode;
        }catch(Exception e) {
            System.out.println("Element not found " + xpath + "|Error - " + e);
            return null;
        }
    }
    // ************** End of Get related methods **************** //


    // ****************** Generic methods  *********************//
    public void print(String printText) {
        System.out.println(printText);
    }

    public void switchToDefault() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            Assert.fail("Unable to switch to default element " + e);
        }
    }

    public List<WebElement> getAllDescendantElementsWithSameProperty(String parentElement, String childElement) {
        try {
            WebElement rootElement = driver.findElement(By.xpath(parentElement));
            List<WebElement> childElements = rootElement.findElements(By.xpath(childElement));
            return childElements;
        } catch (Exception e) {
            Assert.fail("Element not found in getAllDescendantElementsWithSameProperty" + parentElement + "|Error - " + e);
            return null;
        }
    }

    public void fileUpload(String filepath) throws AWTException, InterruptedException {
        try {
            StringSelection stringSel = new StringSelection(filepath);
            Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSel, null);

            //imitate mouse events like ENTER, CTRL+C, CTRL+V
            Robot robot = new Robot();
            robot.delay(2000);

            //Press CTRL+V
            robot.keyPress(KeyEvent.VK_CONTROL);
            robot.keyPress(KeyEvent.VK_V);
            robot.delay(2000);


            //Release CTRL+V
            robot.keyRelease(KeyEvent.VK_V);
            robot.keyRelease(KeyEvent.VK_CONTROL);
            robot.delay(2000);

            //Press ENTER
            robot.keyPress(KeyEvent.VK_ENTER);
            robot.keyRelease(KeyEvent.VK_ENTER);
            robot.delay(2000);

        } catch (Exception e) {
            Assert.fail("File could not be uploaded" + "|Error - " + e);
        }
    }

    public void deleteFile(String filePath) throws Throwable {
        try {
            File f = new File(filePath);
            if (f.delete()) {
                System.out.println(f.getName() + "file deleted");
            } else {
                System.out.println("Failed");
            }

        } catch (Exception e) {
            Assert.fail("File not deleted " + filePath + "|Error - " + e);
        }
    }
    // ****************** End of Generic methods  *********************//



    //**************** Locator methods ***************************//
    public WebElement findElementByID(String ID) {
        try {
            WebElement element = driver.findElement(By.id(ID));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement findElementByName(String Name) {
        try {
            WebElement element = driver.findElement(By.name(Name));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement findElementByClass(String Class) {
        try {
            WebElement element = driver.findElement(By.className(Class));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement findElementByTagName(String TagName) {
        try {
            WebElement element = driver.findElement(By.tagName(TagName));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement findElementByCSS(String CSSSelector) {
        try {
            WebElement element = driver.findElement(By.cssSelector(CSSSelector));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement findElementByLinkText(String LinkText) {
        try {
            WebElement element = driver.findElement(By.linkText(LinkText));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement findElementByPartialLinkText(String PartialLinkText) {
        try {
            WebElement element = driver.findElement(By.partialLinkText(PartialLinkText));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement findElementByXpath(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public List <WebElement> findElementsByID(String ID) {
        try {
            List <WebElement>  elements = new ArrayList<WebElement>();
            elements = driver.findElements(By.id(ID));
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public List <WebElement> findElementsByName(String Name) {
        try {
            List <WebElement>  elements = new ArrayList<WebElement>();
            elements = driver.findElements(By.name(Name));
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }


    public List<WebElement> findElementsByClass(String ClassName) {
        try {
            List <WebElement>  elements = new ArrayList<WebElement>();
            elements = driver.findElements(By.className(ClassName));
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public List<WebElement> findElementsByTagName(String TagName) {
        try {
            List <WebElement>  elements = new ArrayList<WebElement>();
            elements = driver.findElements(By.tagName(TagName));
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public List<WebElement> findElementsByCSS(String CSSSelector) {
        try {
            List <WebElement>  elements = new ArrayList<WebElement>();
            elements = driver.findElements(By.cssSelector(CSSSelector));
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public List<WebElement> findElementsByLinkText(String LinkText) {
        try {
            List <WebElement>  elements = new ArrayList<WebElement>();
            elements = driver.findElements(By.linkText(LinkText));
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public List<WebElement> findElementsByPartialLink(String PartialLinkText) {
        try {
            List <WebElement>  elements = new ArrayList<WebElement>();
            elements = driver.findElements(By.partialLinkText(PartialLinkText));
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public List<WebElement> findElementsByXpath(String xpath) {
        try {
            List <WebElement>  elements = new ArrayList<WebElement>();
            elements = driver.findElements(By.xpath(xpath));
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement findElementByAnyLocator(String locator) {
        WebElement element = null;
        try {
            if (driver.findElement(By.id(locator)).isDisplayed()) {
                element = driver.findElement(By.id(locator));
                return element;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.name(locator)).isDisplayed()) {
                element = driver.findElement(By.name(locator));
                return element;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.className(locator)).isDisplayed()) {
                element = driver.findElement(By.className(locator));
                return element;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.linkText(locator)).isDisplayed()) {
                element = driver.findElement(By.linkText(locator));
                return element;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.cssSelector(locator)).isDisplayed()) {
                element = driver.findElement(By.cssSelector(locator));
                return element;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.partialLinkText(locator)).isDisplayed()) {
                element = driver.findElement(By.partialLinkText(locator));
                return element;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.xpath(locator)).isDisplayed()) {
                element = driver.findElement(By.xpath(locator));
                return element;
            }
        } catch (Exception e) {

        }
        try {
            if (driver.findElement(By.tagName(locator)).isDisplayed()) {
                element = driver.findElement(By.tagName(locator));
                return element;
            }
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
        if (element == null) {
            Assert.fail("\n Locator : " + locator + " ************** Not Found");
        }
        return null;
    }

    /* Method findWebElements : To return webelements based on locator
     * @param argument : String :  Locator of the element
     */
    public List<WebElement> findElementsByAnyLocator(String locator) {
        List <WebElement> elements = null;
        try {
            elements = new ArrayList<>();
            if (driver.findElement(By.id(locator)).isDisplayed()) {
                elements = driver.findElements(By.id(locator));
                return elements;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.name(locator)).isDisplayed()) {
                elements = driver.findElements(By.name(locator));
                return elements;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.className(locator)).isDisplayed()) {
                elements = driver.findElements(By.className(locator));
                return elements;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.linkText(locator)).isDisplayed()) {
                elements = driver.findElements(By.linkText(locator));
                return elements;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.cssSelector(locator)).isDisplayed()) {
                elements = driver.findElements(By.cssSelector(locator));
                return elements;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.partialLinkText(locator)).isDisplayed()) {
                elements = driver.findElements(By.partialLinkText(locator));
                return elements;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.xpath(locator)).isDisplayed()) {
                elements = driver.findElements(By.xpath(locator));
                return elements;
            }
        } catch (Exception e) {
        }
        try {
            if (driver.findElement(By.tagName(locator)).isDisplayed()) {
                elements = driver.findElements(By.tagName(locator));
                return elements;
            }
        } catch (Exception e) {
        }
        if (elements == null) {
            Assert.fail("\n Locator : " + locator + " ************** Not Found");
        }
        return null;
    }
    // **************** End of Locator methods *********************  //



    // *********** JavascriptExecutor utility methods *********** //

    public void flash(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String bgcolor = element.getCssValue("backgroundColor");
        for (int i = 0; i < 10; i++) {
            changeColor("#000000", element, driver);// 1
            changeColor(bgcolor, element, driver);// 2
        }
    }

    public void changeColor(String color, WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.backgroundColor = '" + color + "'", element);

        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
        }
    }

    public static void drawBorder(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static void clickOnElementByJS(WebElement element, WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].click();", element);
    }

    public static void generateAlert(WebDriver driver, String message) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("alert('" + message + "')");
    }

    public static void refreshBrowserByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("history.go(0)");
    }


    public void scrollToElement(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("<<<< Scrolled till element is visible >>>>");
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
        }
    }

    public void sendKeysUsingJavaScript(String xpath, String text) {
        try {
            WebElement textBox = driver.findElement(By.xpath(xpath));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='" + text + "';", textBox);
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "| Error - " + e);
        }
    }

    public void clearUsingJavaScript(String xpath) throws Exception {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='';", element);
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "| Error - " + e);
        }
    }

    public boolean isHorizontalScrollBarPresent() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Boolean horzscrollstatus = (Boolean) js.executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
            return horzscrollstatus;
        } catch (Exception e) {
            System.out.println("Horizontal scroll bar is not present " + e);
            return false;
        }
    }

    public boolean isVerticalScrollBarPresent() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            Boolean VertScrollStatus = (Boolean) js.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
            return VertScrollStatus;
        } catch (Exception e) {
            System.out.println("Vertical scroll bar is not present " + e);
            return false;
        }
    }

    public void javascriptFunction(String methodName) {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(methodName);
        } catch (Exception e) {
            Assert.fail("Element not found :" + methodName + "|Error - " + e);
        }
    }

    public String getValueOfJavscriptTextBox(String xpath) {
        try {
            WebElement textBox = driver.findElement(By.xpath(xpath));
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String value = js.executeScript("return arguments[0].value", textBox).toString();
            System.out.println("Value of tex box is " + value);
            return value;
        } catch (Exception e) {
            Assert.fail("Element not found :" + xpath + "|Error - " + e);
            return null;
        }
    }

    public void safeJavascriptClick(WebElement element) throws Exception {
        try {
            if (element.isEnabled() && element.isDisplayed()) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            Assert.fail("Element is not attached to the page document :" + e.getStackTrace());
        } catch (Exception e) {
            Assert.fail("Element was not found in DM :" + e.getStackTrace());
        }
    }

    public void safeJavascriptClick(String xpath) throws Exception {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            if (element.isEnabled() && element.isDisplayed()) {
                JavascriptExecutor js = (JavascriptExecutor) driver;
                js.executeScript("arguments[0].click();", element);
            } else {
                System.out.println("Unable to click on element");
            }
        } catch (StaleElementReferenceException e) {
            Assert.fail("Element is not attached to the page document :" + e.getStackTrace());
        } catch (Exception e) {
            Assert.fail("Element was not found in DM :" + e.getStackTrace());
        }
    }

    public void javascriptScrollDownTillCertainPixel() {
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("window.scrollBy(0,endpixel)", "");
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public void scrollPageDown(WebDriver driver) {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public void scrollPageUp(WebDriver driver) {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public void scrollIntoView(WebElement element, WebDriver driver) {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public static void zoomPageByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("document.body.style.zoom='50%'");// zoom out by 100%
    }

    public void enterTextByJS(WebDriver driver, WebElement element, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].value='" + value + "';", element);
    }

    public static String getPageInnerText(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String pageText = js.executeScript("return document.documentElement.innerText;").toString();
        return pageText;
    }

    public void selectDropDownByJS(WebDriver driver, WebElement element, String value) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].value='" + value + "';", element);
    }

    public String getHiddenElementsText(String arg1) {
        String hiddenText = null;
        try {
            WebElement element = driver.findElement(By.xpath(arg1));
            hiddenText = (String) ((JavascriptExecutor) driver).executeScript("return arguments[0].textContent;", element);
        } catch (Exception e) {
            Assert.fail("Exception in getHiddenElementsText " + e);
        }
        return hiddenText;
    }
    // *********** End of JavascriptExecutor utility methods *********** //



    // *********** Date and Time utility methods *********** //
    public String getCurrentDate(String formatReq)
    {
        try
        {
            LocalDate ld = LocalDate.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedDate = dtf.format(ld);
            System.out.println("Current date is : " + formattedDate);
            return formattedDate;
        }catch (Exception e)
        {
            System.out.println("Exception in 'getCurrentDate' method");
            e.printStackTrace();
            return null;
        }
    }

    public String getCurrentTime(String formatReq)
    {
        try
        {
            LocalTime lt = LocalTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedTime = dtf.format(lt);
            System.out.println("Current time is : " + formattedTime);
            return formattedTime;
        }catch (Exception e)
        {
            System.out.println("Exception in 'getCurrentTime' method");
            e.printStackTrace();
            return null;
        }
    }

    public String getCurrentDateAndTime(String formatReq)
    {
        try
        {
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedDateTime = dtf.format(ldt);
            System.out.println("Current date and time is : " + formattedDateTime);
            return formattedDateTime;
        }catch (Exception e)
        {
            System.out.println("Exception in 'getCurrentDateAndTime' method");
            e.printStackTrace();
            return null;
        }
    }

    public String addDaysToCurrentDateAndGetFutureDate(String formatReq, int days)
    {
        try
        {
            LocalDate ld = LocalDate.now();
            LocalDate currentPlusDays = ld.plusDays(days);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedDate = dtf.format(currentPlusDays);
            System.out.println("Date after adding " + days + " days to current date : " + formattedDate);
            return formattedDate;
        }catch (Exception e)
        {
            System.out.println("Exception in 'addDaysToCurrentDateAndGetFutureDate' method");
            e.printStackTrace();
            return null;
        }
    }

    public String subtractDaysFromCurrentDateAndGetPastDate(String formatReq, int days) {
        try {
            LocalDate ld = LocalDate.now();
            LocalDate currentMinusDays = ld.minusDays(days);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedDate = dtf.format(currentMinusDays);
            System.out.println("Date after subtracting " + days + " days from current date : " + formattedDate);
            return formattedDate;
        } catch (Exception e) {
            System.out.println("Exception in 'subtractDaysFromCurrentDateAndGetPastDate' method");
            e.printStackTrace();
            return null;
        }

    }

    public String addDaysToSpecificDateAndGetFutureDate(String formatReq, String date, int days)
    {
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            LocalDate ld = LocalDate.parse(date, dtf);
            LocalDate specificDatePlusDays = ld.plusDays(days);


            String formattedDate = dtf.format(specificDatePlusDays);
            System.out.println("Date after adding " + days + " days to given specific date: " + formattedDate);
            return formattedDate;
        }catch (Exception e)
        {
            System.out.println("Exception in 'addDaysToSpecificDateAndGetFutureDate' method");
            e.printStackTrace();
            return null;
        }
    }

    public String subtractDaysFromSpecificDateAndGetPastDate(String formatReq, String date, int days)
    {
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            LocalDate ld = LocalDate.parse(date, dtf);
            LocalDate specificDateMinusDays = ld.minusDays(days);


            String formattedDate = dtf.format(specificDateMinusDays);
            System.out.println("Date after subtracting " + days + " days from given specific date: " + formattedDate);
            return formattedDate;
        }catch (Exception e)
        {
            System.out.println("Exception in 'subtractDaysFromSpecificDateAndGetPastDate' method");
            e.printStackTrace();
            return null;
        }
    }

    public LocalDate convertStringtoDate(String formatReq, String date)
    {
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            LocalDate stringToDate = LocalDate.parse(date, dtf);
            System.out.println("Date after converting from String to Date : " + stringToDate);
            return stringToDate;
        }catch (Exception e)
        {
            System.out.println("Exception in convertStringtoDate method");
            e.printStackTrace();
            return null;
        }

    }

    public boolean verifyIfADateIsInGivenRange(String dateFormat, String startDate, String endDate, String compareDate)
    {
        boolean compareValue = false;
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);

            LocalDate startDate1 = LocalDate.parse(startDate, dtf);
            LocalDate endDate1 = LocalDate.parse(endDate, dtf);
            LocalDate compareDate1 = LocalDate.parse(compareDate, dtf);

            boolean isAfter = compareDate1.isAfter(startDate1);
            boolean isBefore = compareDate1.isBefore(endDate1);

            if(isAfter == true && isBefore == true)
            {
                System.out.println("Compared date is within the date range");
                compareValue = true;
            }
            else
            {
                System.out.println("Compared date is not within the date range");
                compareValue = false;
            }

        }catch (Exception e)
        {
            System.out.println("Exception in verifyIfADateIsInGivenRange method");
            e.printStackTrace();
            compareValue = false;
        }
        return compareValue;
    }

    public String addMinsToSpecificDateAndGetDateAndTime(String formatReq, String date, int mins)
    {
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            LocalDateTime ldt = LocalDateTime.parse(date, dtf);
            LocalDateTime specificDatePlusMins = ldt.plusMinutes(mins);
            String formattedDate = dtf.format(specificDatePlusMins);
            System.out.println("Date after adding " + mins + " minutes from given specific date: " + formattedDate);
            return formattedDate;
        }catch (Exception e)
        {
            System.out.println("Exception in 'addMinsToSpecificDateAndGetDateAndTime' method");
            e.printStackTrace();
            return null;
        }
    }

    public String addMinsToCurrentDateAndGetDateAndTime(String formatReq, int mins)
    {
        try
        {
            LocalDateTime ldt = LocalDateTime.now();
            LocalDateTime currentDatePlusMins = ldt.plusMinutes(mins);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedDate = dtf.format(currentDatePlusMins);
            System.out.println("Date after adding " + mins + " minutes from given specific date: " + formattedDate);
            return formattedDate;
        }catch (Exception e)
        {
            System.out.println("Exception in 'addMinsToCurrentDateAndGetDateAndTime' method");
            e.printStackTrace();
            return null;
        }
    }

    public String getDateAndTimeInPreferredTimeZone(String formatReq, String timeZone)
    {
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            ZonedDateTime zdt = ZonedDateTime.now();
            String formattedLocalTime = dtf.format(zdt);
            System.out.println("Local Date and Time is : " + formattedLocalTime);

            ZonedDateTime userTimeZone = zdt.withZoneSameInstant(ZoneId.of(timeZone));
            String userTimeZone1 = dtf.format(userTimeZone);
            System.out.println("Date and Time for " + timeZone + " timezone is : " + userTimeZone1);
            return userTimeZone1;
        }catch (Exception e)
        {
            System.out.println("Exception in getDateAndTimeInPreferredTimeZone method");
            e.printStackTrace();
            return null;
        }

    }

    public String convertDateFromDBToOtherFormat(String formatReq, String dateToBeConverted, String dateFormat)
    {
        try
        {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            DateTimeFormatter convertableDtf = DateTimeFormatter.ofPattern(dateFormat);

            LocalDate ld = LocalDate.parse(dateToBeConverted, convertableDtf);
            String formattedDate = dtf.format(ld);
            System.out.println("Actual date is : " + dateToBeConverted);
            System.out.println("Date after conversion is : " + formattedDate);
            return formattedDate;
        }catch (Exception e)
        {
            System.out.println("Exception in convertDateFromDBToOtherFormat method");
            e.printStackTrace();
            return null;
        }

    }
    // *********** End of Date and Time related methods *********** //

}   //Class ends here
