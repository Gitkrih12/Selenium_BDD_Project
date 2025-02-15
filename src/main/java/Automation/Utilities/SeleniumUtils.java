package Automation.Utilities;

import io.cucumber.datatable.DataTable;
import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.Point;
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
import java.io.RandomAccessFile;
import java.security.SecureRandom;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.*;
import java.util.random.RandomGenerator;

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

    public void rightClick(WebElement element) {
        try {
            Actions act = new Actions(driver);
            act.moveToElement(element).contextClick().perform();
        } catch (Exception e) {
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

    public Actions moveToElement(String xpath) {
        try {
            WebElement element = driver.findElement(By.xpath(xpath));
            Actions act = new Actions(driver);
            Actions ele = act.moveToElement(element);
            return ele;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public Actions moveToElement(WebElement element) {
        try {
            Actions act = new Actions(driver);
            Actions ele = act.moveToElement(element);
            return ele;
        } catch (Exception e) {
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
    public void selectDropdownByVisibleText(By byLocator, String text) {
        try {
            WebElement element = driver.findElement(byLocator);
            Select dr = new Select(element);
            dr.selectByVisibleText(text);
        } catch (Exception e) {
            Assert.fail("Element not found " + byLocator + "| Error - " + e);
        }
    }

    public void selectDropdownByValue(By byLocator, String value) {
        try {
            WebElement element = driver.findElement(byLocator);
            Select sel = new Select(element);
            sel.selectByValue(value);
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
        }
    }

    public void selectDropdownByIndex(By byLocator, String index) {
        try {
            int ind = Integer.parseInt(index);
            Select sel = new Select(driver.findElement(byLocator));
            sel.selectByIndex(ind);
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
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

    public String getTextOfSelectedOptionFromDropdown(By byLocator) {
        try {
            Select dr = new Select(driver.findElement(byLocator));
            WebElement option = dr.getFirstSelectedOption();
            return option.getText();
        } catch (Exception e) {
            System.out.println("Element not found " + byLocator + "|Error - " + e);
            return "Unable to get text of selected option from dropdown";
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

    public WebElement explicitElementClickableWait(By byLocator, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.elementToBeClickable(byLocator));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement explicitElementClickableWait(WebElement element, int duration) {
        try {
            WebElement ele = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.elementToBeClickable(element));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement explicitElementVisibleWait(By byLocator, int duration) {
        try {
            WebElement element1 = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.visibilityOf(driver.findElement(byLocator)));
            return element1;
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
            return null;
        }
    }

    public WebElement explicitDropdownElementsWait(int duration, String ParentXpath, String tagName) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.presenceOfNestedElementLocatedBy(By.xpath(ParentXpath), By.tagName(tagName)));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public WebElement explicitVisibilityOfElementLocatedWait(By byLocator, int duration) {
        try {
            WebElement element = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.visibilityOfElementLocated(byLocator));
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
            return null;
        }
    }

    public boolean explicitTextToBePresentInElementWait(By byLocator, int duration, String text) {
        try {
            boolean status = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.textToBePresentInElement(
                            driver.findElement(byLocator), text));
            return status;
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
            return false;
        }
    }

    public boolean explicitElementInvisibilityWait(By byLocator, int duration) {
        try {
            boolean status = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.invisibilityOf(driver.findElement(byLocator)));
            return status;
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
            return false;
        }
    }

    public boolean explicitInvisibilityOfElementLocatedWait(By byLocator, int duration) {
        try {
            boolean status = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.invisibilityOfElementLocated(byLocator));
            return status;
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
            return false;
        }
    }

    public boolean explicitInvisibilityOfElementText(By byLocator, int duration, String text) {
        try {
            boolean status = new WebDriverWait(driver, Duration.ofSeconds(duration)).
                    until(ExpectedConditions.invisibilityOfElementWithText(byLocator, text));
            return status;
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
            return false;
        }
    }

    public void explicitElementClassChangesWait(String xpath, int duration, String classValue) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                WebElement element = driver.findElement(By.xpath(xpath));
                String classValueInApp = element.getAttribute("class");
                System.out.println("class: " + classValue);
                if (classValueInApp.equals(classValue))
                    return true;
                else
                    return false;
            }
        });
    }

    public void explicitCountChangesWait(String xpath, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
                int elementCount = driver.findElements(By.xpath(xpath)).size();
                System.out.println("Elements count: " + elementCount);
                if (elementCount > 1)
                    return true;
                else
                    return false;
            }
        });
    }

    public void explicitCountBecome1Or2Wait(String xpath, int duration) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
        wait.until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver driver) {
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
            List<WebElement> elements = new WebDriverWait(driver, Duration.ofSeconds(duration)).
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
            WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wdWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameNumber));
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public void explicitFrameWait(WebElement element, int duration) throws Exception {
        try {
            System.out.println("Navigated to switchToFrameWithFrameNumber (Int) method");
            WebDriverWait wdWait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            wdWait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(element));
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public void switchToDefaultContent() {
        try {
            driver.switchTo().defaultContent();
        } catch (Exception e) {
            Assert.fail("Exception in switching to default content" + e);
            e.printStackTrace();
        }
    }

    public void switchToParentFrame() {
        try {
            driver.switchTo().parentFrame();
        } catch (Exception e) {
            Assert.fail("Exception in switching to parent frame" + e);
            e.printStackTrace();
        }
    }

    public void switchToFrame(String frameLocator) {
        try {
//            WebElement frameEle = driver.findElement(frameLocator);
            driver.switchTo().frame(frameLocator);
        } catch (Exception e) {
            Assert.fail("Exception in switching to frame" + e);
            e.printStackTrace();
        }
    }

    //Provide duration in Milli Seconds. Example - 3000
    public void threadSleep(long duration) throws InterruptedException {
        try {
            Thread.sleep(duration);
        } catch (Exception e) {
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

    /*
        -Use this method to wait for the certain number of web elements to be displayed on a web page
        -Accepts parameters xpath, duration and count
        -Xpath should contain multiple web elements address
     */
    public List<WebElement> explicitCountToBeWait(String xpath, int duration, int count) {
        List<WebElement> elements = null;
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(duration));
            elements = wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath(xpath), count));
        } catch (Exception e) {
            Assert.fail("Unable to wait for the given count");
        }
        return elements;
    }

    //************ End of Wait related methods *************//


    // ******************* Conditional related methods ***************** //
    public boolean isElementDisplayed(By byLocator) {
        boolean status = false;
        try {
            status = driver.findElement(byLocator).isDisplayed();
            Assert.assertTrue(status);
        } catch (Exception e) {
            Assert.fail("Element is not found" + byLocator + "| Error is " + e);
            return false;
        }
        return status;
    }

    public boolean isElementSelected(By byLocator) {
        boolean status = false;
        try {

            status = driver.findElement(byLocator).isSelected();
            Assert.assertTrue(status);
        } catch (Exception e) {
            Assert.fail("Element is not found " + byLocator + "| Error is " + e);
            return false;
        }
        return status;
    }

    public boolean isDisplayed(By byLocator) {
        boolean status = false;
        try {
            status = driver.findElement(byLocator).isDisplayed();
        } catch (Exception e) {
            System.out.println("Element not found " + byLocator + "|Error - " + e);
            return false;
        }
        return status;
    }

    public boolean isAttributePresent(By byLocator, String attribute) {
        boolean status = false;
        try {
            String attributeValue = driver.findElement(byLocator).getAttribute(attribute);
            if (attributeValue != null) {
                status = true;
            }
        } catch (Exception e) {
            Assert.fail("Element not found " + byLocator + "|Error - " + e);
            return false;
        }
        return status;
    }
    // ******************* End of Conditional related methods ***************** //


    // ************** Element action related methods **************** //
    public void findElementAndSendKeys(By byLocator, String text) {
        try {
            driver.findElement(byLocator).sendKeys(text);
        } catch (Exception e) {
            Assert.fail("element not found " + byLocator + "|Error - " + e);
        }
    }

    //Use this method by passing xpath as a parameter to click an element
    public void clickElement(By byLocator) {
        try {
            driver.findElement(byLocator).click();
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
        }
    }

    public void clearTextBox(By byLocator) {
        try {
            driver.findElement(byLocator).clear();
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
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

    public void sendKeysUsingKeyboardInput(By byLocator) {
        try {
            WebElement element = driver.findElement(byLocator);
            element.sendKeys((Keys.DOWN), (Keys.ENTER));
        } catch (Exception e) {
            Assert.fail("Element not found " + byLocator + "|Error - " + e);
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

    public void clearUsingKeyClass(By byLocator) throws Exception {
        try {
            driver.findElement(byLocator).sendKeys(Keys.chord(Keys.CONTROL, "a"));
            driver.findElement(byLocator).sendKeys(Keys.DELETE);
        } catch (Exception e) {
            Assert.fail("Element not found " + byLocator + "| Error - " + e);
        }
    }
    // ************** End of Element action related methods **************** //


    // ************** Get related methods **************** //
    public List<String> getAllElementsToList(By byLocator) {
        try {
            List<String> AllElementsText = new ArrayList<String>();
            List<WebElement> AllElements = driver.findElements(byLocator);
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

    public ArrayList<String> getAllElementsToArrayList(By byLocator) {
        ArrayList<String> listOfRecords = null;
        try {
            listOfRecords = new ArrayList<>();
            List<WebElement> listOfElements = driver.findElements(byLocator);
            for (WebElement record : listOfElements) {
                listOfRecords.add(record.getText());
            }
        } catch (Exception e) {
            Assert.fail("Unable to get list of elements to arraylist");
        }
        return listOfRecords;
    }

    public ArrayList<String> scrollAndGetAllElementsToArrayList(By byLocator) {
        ArrayList<String> listOfRecords = null;
        try {
            listOfRecords = new ArrayList<>();
            List<WebElement> listOfElements = driver.findElements(byLocator);
            for (WebElement record : listOfElements) {
                scrollIntoView(record, driver);
                listOfRecords.add(record.getText());
            }
        } catch (Exception e) {
            Assert.fail("Unable to get list of elements to arraylist");
        }
        return listOfRecords;
    }

    public String getAttributeValue(By byLocator, String attributeName) {
        String attValue = null;
        try {
            attValue = driver.findElement(byLocator).getAttribute(attributeName);
            return attValue;
        } catch (Exception e) {
            Assert.fail("Attribute not found :" + attributeName + "|Error - " + e);
            return "No attribute found";
        }
    }

    public String getText(By byLocator) {
        String text = null;
        try {
            text = driver.findElement(byLocator).getText();
            return text;
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
            return "Unable to get string text";
        }
    }

    public Point getElementCoordinates(By byLocator) {
        Point coordinates = null;
        try {
            coordinates = driver.findElement(byLocator).getLocation();
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
        }
        return coordinates;
    }

    public void navigateTo(String URL) {
        try {
            driver.get(URL);
        } catch (Exception e) {
            Assert.fail("Exception in navigateTo method :" + URL + "|Error - " + e);
        }
    }

    public void screenshot(String path, String MethodName) throws SQLException, ClassNotFoundException, IOException {
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        Date dnow = new Date();
        SimpleDateFormat ft = new SimpleDateFormat("MMddyyyyhhmmss");
        org.apache.commons.io.FileUtils.copyFile(screenshotFile, new File(path + "\\Screenshots\\" + MethodName + " - " + ft.format(dnow) + ".jpeg"));
    }

    public int getSizeofDropDown(By byLocator) {
        try {
            WebElement element = driver.findElement(byLocator);
            List<WebElement> options = element.findElements(By.tagName("option"));
            return options.size();
        } catch (Exception e) {
            System.out.println("Element not found " + byLocator + "| Error - " + e);
            return 0;
        }
    }

    public int getXCoordinate(String xpath) {
        try {
            int xCoordinate = driver.findElement(By.xpath(xpath)).getLocation().getX();
            return xCoordinate;
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "|Error - " + e);
            return 0;
        }
    }

    public int getYCoordinate(String xpath) {
        try {
            int yCoordinate = driver.findElement(By.xpath(xpath)).getLocation().getY();
            return yCoordinate;
        } catch (Exception e) {
            Assert.fail("Element not found " + xpath + "|Error - " + e);
            return 0;
        }
    }

    public int getTableRowOrColCount(By byLocator) {
        int count = 0;
        try {
            List<WebElement> elements = driver.findElements(byLocator);
            count = elements.size();
            return count;
        } catch (Exception e) {
            Assert.fail("Element not found " + byLocator + "|Error - " + e);
            return 0;
        }
    }

    public String getTitle() {
        try {
            String title = driver.getTitle();
            System.out.println("Title is : " + title);
            return title;
        } catch (Exception e) {
            Assert.fail("Unable to get title" + "|Error - " + e);
            return null;
        }
    }

    public String getColorCodeForBackground(By byLocator) {
        String colorCode = null;
        try {
            String cssValue = driver.findElement(byLocator).getCssValue("background-color");
            colorCode = Color.fromString(cssValue).asHex().toUpperCase(Locale.ROOT);
            return colorCode;
        } catch (Exception e) {
            System.out.println("Element not found " + byLocator + "|Error - " + e);
            return null;
        }
    }

    public String getColorCodeForText(By byLocator) {
        try {
            String cssValue = driver.findElement(byLocator).getCssValue("color");
            String colorCode = Color.fromString(cssValue).asHex().toUpperCase(Locale.ROOT);
            return colorCode;
        } catch (Exception e) {
            Assert.fail("Unable to get color code for text" + "|Error - " + e);
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

    //This method is used to upload files in headless mode
    public void uploadFileWithJavaScriptAndSendKeys(By byLocator, String filePath) {
        try {
            WebElement element = driver.findElement(byLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].style.display='block';", element);
            driver.findElement(byLocator).sendKeys(filePath);
        } catch (Exception e) {
            Assert.fail("The file could not be uploaded");
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

    public void printStatementInGreenColor(String text, String result) {
        try {
            System.out.println(ANSI_GREEN + text + ": " + result + ANSI_RESET);
        } catch (Exception e) {
            Assert.fail("Unable to print statement in required color");
        }
    }

    public void printStatementInGreenColor(String text, boolean result) {
        try {
            System.out.println(ANSI_GREEN + text + ": " + result + ANSI_RESET);
        } catch (Exception e) {
            Assert.fail("Unable to print statement in required color");
        }
    }

    public void printStatementInGreenColor(String text, int result) {
        try {
            System.out.println(ANSI_GREEN + text + ": " + result + ANSI_RESET);
        } catch (Exception e) {
            Assert.fail("Unable to print statement in required color");
        }
    }

    public void printStatementInGreenColor(String text, List<String> result) {
        try {
            System.out.println(ANSI_GREEN + text + ": " + result + ANSI_RESET);
        } catch (Exception e) {
            Assert.fail("Unable to print statement in required color");
        }
    }

    /*
    -Compare cucumber data table and list of values from xpath
    -Cucumber data table would be converted to "String List"
    -xpath web elements would be converted to "String list" using lambda expressions
    */
    public void compare2Lists(DataTable dataTable, By byLocator) {
        List<String> fieldsExp = dataTable.asList();
        List<String> fieldsAct = driver.findElements(byLocator).
                stream().map(element -> element.getText().trim()).toList();
        printStatementInGreenColor("Fields size actual", fieldsAct.size());
        printStatementInGreenColor("Fields size expected", fieldsExp.size());
        printStatementInGreenColor("Fields actual", fieldsAct);
        printStatementInGreenColor("Fields expected", fieldsExp);
        Assert.assertEquals(fieldsExp, fieldsAct);
    }

    /*
    -Compare cucumber data table and list of values from xpath
    -Cucumber data table would be converted to "String List"
    -Would be scrolled till the elements and both the lists would be compared
    */
    public void scrollToElementsAndCompare2Lists(DataTable dataTable, By byLocator) {
        List<String> fieldsExp = dataTable.asList();
        List<WebElement> fields = driver.findElements(byLocator);
        List<String> fieldsAct = new ArrayList<>();
        for (WebElement field : fields) {
            scrollIntoView(field, driver);
            explicitElementClickableWait(field, 20);
            fieldsAct.add(field.getText());
        }
        printStatementInGreenColor("Fields size actual", fieldsAct.size());
        printStatementInGreenColor("Fields size expected", fieldsExp.size());
        printStatementInGreenColor("Fields actual", fieldsAct);
        printStatementInGreenColor("Fields expected", fieldsExp);
        Assert.assertEquals(fieldsExp, fieldsAct);
    }

    /*
    -This method is used to perform different display validations
     For example, Fields, field values, Search boxes etc.
     */
    public void elementsDisplayValidation(By byLocator) {
        List<WebElement> fieldValues = driver.findElements(byLocator);
        printStatementInGreenColor("Fields size", fieldValues.size());
        for (WebElement fieldValue : fieldValues) {
            boolean status = fieldValue.isDisplayed();
            printStatementInGreenColor("Field status is", status);
            Assert.assertTrue(status);
        }
    }

    /*
    -This method is used to perform different display validations
    For example, Fields, field values, Search boxes etc.
    -Would be scrolled to elements and validates element display status
    */
    public void scrollToElementsAndValidateDisplayStatus(By byLocator) {
        List<WebElement> fieldValues = driver.findElements(byLocator);
        printStatementInGreenColor("Fields size", fieldValues.size());
        for (WebElement fieldValue : fieldValues) {
            scrollIntoView(fieldValue, driver);
            explicitElementClickableWait(fieldValue, 10);
            boolean status = fieldValue.isDisplayed();
            printStatementInGreenColor("Field status is", status);
            Assert.assertTrue(status);
        }
    }

    // ****************** End of Generic methods  *********************//


    //**************** Locator methods ***************************//
    public WebElement findElement(By byLocator) {
        WebElement element = null;
        try {
            element = driver.findElement(byLocator);
            return element;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }

    public List<WebElement> findElements(By byLocator) {
        List<WebElement> elements = null;
        try {
            elements = driver.findElements(byLocator);
            return elements;
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
            return null;
        }
    }
    // **************** End of Locator methods *********************  //


    // *********** JavascriptExecutor utility methods *********** //

    public static void drawBorder(By byLocator, WebDriver driver) {
        WebElement element = driver.findElement(byLocator);
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        js.executeScript("arguments[0].style.border='3px solid red'", element);
    }

    public static String getTitleByJS(WebDriver driver) {
        JavascriptExecutor js = ((JavascriptExecutor) driver);
        String title = js.executeScript("return document.title;").toString();
        return title;
    }

    public static void clickOnElementByJS(By byLocator, WebDriver driver) {
        WebElement element = driver.findElement(byLocator);
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

    public void scrollToElement(By byLocator) {
        try {
            WebElement element = driver.findElement(byLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].scrollIntoView(true);", element);
            System.out.println("<<<< Scrolled till element is visible >>>>");
        } catch (Exception e) {
            Assert.fail("Element not found | Error - " + e);
        }
    }

    public void sendKeysUsingJavaScript(By byLocator, String text) {
        try {
            WebElement textBox = driver.findElement(byLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='" + text + "';", textBox);
        } catch (Exception e) {
            Assert.fail("Element not found " + byLocator + "| Error - " + e);
        }
    }

    public void clearUsingJavaScript(By byLocator) throws Exception {
        try {
            WebElement element = driver.findElement(byLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].value='';", element);
        } catch (Exception e) {
            Assert.fail("Element not found " + byLocator + "| Error - " + e);
        }
    }

    public boolean isHorizontalScrollBarPresent() {
        boolean scrollStatus = false;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            scrollStatus = (boolean) js.executeScript("return document.documentElement.scrollWidth>document.documentElement.clientWidth;");
            return scrollStatus;
        } catch (Exception e) {
            System.out.println("Horizontal scroll bar is not present " + e);
            return false;
        }
    }

    public boolean isVerticalScrollBarPresent() {
        boolean scrollStatus = false;
        try {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            scrollStatus = (Boolean) js.executeScript("return document.documentElement.scrollHeight>document.documentElement.clientHeight;");
            return scrollStatus;
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

    public String getValueOfJavscriptTextBox(By byLocator) {
        try {
            WebElement textBox = driver.findElement(byLocator);
            JavascriptExecutor js = (JavascriptExecutor) driver;
            String value = js.executeScript("return arguments[0].value", textBox).toString();
            System.out.println("Value of tex box is " + value);
            return value;
        } catch (Exception e) {
            Assert.fail("Element not found :" + byLocator + "|Error - " + e);
            return null;
        }
    }

    public void safeJavascriptClick(By byLocator) throws Exception {
        try {
            WebElement element = driver.findElement(byLocator);
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

    //Leaving this the parameter as WebElement only as this methods is used internally in this class
    public void scrollIntoView(WebElement element, WebDriver driver) {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].scrollIntoView(true);", element);
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
        }
    }

    public static void zoomPageByJS(WebDriver driver) {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("document.body.style.zoom='50%'");// zoom out by 100%
        } catch (Exception e) {
            Assert.fail("Unable to zoom page." + "|Error - " + e);
        }
    }

    public void enterTextByJS(WebDriver driver, By byLocator, String value) {
        try {
            WebElement element = driver.findElement(byLocator);
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].value='" + value + "';", element);
        } catch (Exception e) {
            Assert.fail("Unable to enter text into textbox." + "|Error - " + e);
        }
    }

    public static String getPageInnerText(WebDriver driver) {
        String pageText = null;
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            pageText = js.executeScript("return document.documentElement.innerText;").toString();
            return pageText;
        } catch (Exception e) {
            Assert.fail("Element not found" + "|Error - " + e);
            return null;
        }
    }

    public void selectDropDownByJS(WebDriver driver, WebElement element, String value) {
        try {
            JavascriptExecutor js = ((JavascriptExecutor) driver);
            js.executeScript("arguments[0].value='" + value + "';", element);
        } catch (Exception e) {
            Assert.fail("Unable to select dropdown value." + "|Error - " + e);
        }
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
    public String getCurrentDate(String formatReq) {
        try {
            LocalDate ld = LocalDate.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedDate = dtf.format(ld);
            System.out.println("Current date is : " + formattedDate);
            return formattedDate;
        } catch (Exception e) {
            Assert.fail("Exception in 'getCurrentDate' method" + e);
            return null;
        }
    }

    public String getCurrentTime(String formatReq) {
        try {
            LocalTime lt = LocalTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedTime = dtf.format(lt);
            System.out.println("Current time is : " + formattedTime);
            return formattedTime;
        } catch (Exception e) {
            Assert.fail("Exception in 'getCurrentTime' method" + e);
            return null;
        }
    }

    public String getCurrentDateAndTime(String formatReq) {
        try {
            LocalDateTime ldt = LocalDateTime.now();
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedDateTime = dtf.format(ldt);
            System.out.println("Current date and time is : " + formattedDateTime);
            return formattedDateTime;
        } catch (Exception e) {
            Assert.fail("Exception in 'getCurrentDateAndTime' method" + e);
            return null;
        }
    }

    public String addDaysToCurrentDateAndGetFutureDate(String formatReq, int days) {
        try {
            LocalDate ld = LocalDate.now();
            LocalDate currentPlusDays = ld.plusDays(days);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedDate = dtf.format(currentPlusDays);
            System.out.println("Date after adding " + days + " days to current date : " + formattedDate);
            return formattedDate;
        } catch (Exception e) {
            Assert.fail("Exception in 'addDaysToCurrentDateAndGetFutureDate' method" + e);
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
            Assert.fail("Exception in 'subtractDaysFromCurrentDateAndGetPastDate' method");
            return null;
        }
    }

    public String addDaysToSpecificDateAndGetFutureDate(String formatReq, String date, int days) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            LocalDate ld = LocalDate.parse(date, dtf);
            LocalDate specificDatePlusDays = ld.plusDays(days);

            String formattedDate = dtf.format(specificDatePlusDays);
            System.out.println("Date after adding " + days + " days to given specific date: " + formattedDate);
            return formattedDate;
        } catch (Exception e) {
            Assert.fail("Exception in 'addDaysToSpecificDateAndGetFutureDate' method" + e);
            return null;
        }
    }

    public String subtractDaysFromSpecificDateAndGetPastDate(String formatReq, String date, int days) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            LocalDate ld = LocalDate.parse(date, dtf);
            LocalDate specificDateMinusDays = ld.minusDays(days);

            String formattedDate = dtf.format(specificDateMinusDays);
            System.out.println("Date after subtracting " + days + " days from given specific date: " + formattedDate);
            return formattedDate;
        } catch (Exception e) {
            Assert.fail("Exception in 'subtractDaysFromSpecificDateAndGetPastDate' method" + e);
            return null;
        }
    }

    public String convertDateFromOneFormatToAnother(String formatAct, String formatReq, String date) {
        try {
            DateTimeFormatter inputDtf = DateTimeFormatter.ofPattern(formatAct);
            DateTimeFormatter outputDtf = DateTimeFormatter.ofPattern(formatReq);
            String stringToDate = LocalDate.parse(date, inputDtf).format(outputDtf);
            System.out.println("Date after converting from one format to another : " + stringToDate);
            return stringToDate;
        } catch (Exception e) {
            Assert.fail("Exception in convertDateFromOneFormatToAnother method" + e);
            return null;
        }
    }

    public LocalDate convertStringToDate(String formatReq, String date) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            LocalDate stringToDate = LocalDate.parse(date, dtf);
            System.out.println("Date after converting from String to Date : " + stringToDate);
            return stringToDate;
        } catch (Exception e) {
            Assert.fail("Exception in convertStringtoDate method" + e);
            return null;
        }
    }

    public boolean verifyIfADateIsInGivenRange(String dateFormat, String startDate, String endDate, String compareDate) {
        boolean compareValue = false;
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(dateFormat);

            LocalDate startDate1 = LocalDate.parse(startDate, dtf);
            LocalDate endDate1 = LocalDate.parse(endDate, dtf);
            LocalDate compareDate1 = LocalDate.parse(compareDate, dtf);

            boolean isAfter = compareDate1.isAfter(startDate1);
            boolean isBefore = compareDate1.isBefore(endDate1);

            if (isAfter && isBefore) {
                System.out.println("Compared date is within the date range");
                compareValue = true;
            } else {
                Assert.fail("Compared date is not within the date range");
            }
        } catch (Exception e) {
            Assert.fail("Exception in verifyIfADateIsInGivenRange method" + e);
        }
        return compareValue;
    }

    public String addMinsToSpecificDateAndGetDateAndTime(String formatReq, String date, int mins) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            LocalDateTime ldt = LocalDateTime.parse(date, dtf);
            LocalDateTime specificDatePlusMins = ldt.plusMinutes(mins);
            String formattedDate = dtf.format(specificDatePlusMins);
            System.out.println("Date after adding " + mins + " minutes from given specific date: " + formattedDate);
            return formattedDate;
        } catch (Exception e) {
            Assert.fail("Exception in 'addMinsToSpecificDateAndGetDateAndTime' method" + e);
            return null;
        }
    }

    public String addMinsToCurrentDateAndGetDateAndTime(String formatReq, int mins) {
        try {
            LocalDateTime ldt = LocalDateTime.now();
            LocalDateTime currentDatePlusMins = ldt.plusMinutes(mins);
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            String formattedDate = dtf.format(currentDatePlusMins);
            System.out.println("Date after adding " + mins + " minutes from given specific date: " + formattedDate);
            return formattedDate;
        } catch (Exception e) {
            Assert.fail("Exception in 'addMinsToCurrentDateAndGetDateAndTime' method" + e);
            return null;
        }
    }

    public String getDateAndTimeInPreferredTimeZone(String formatReq, String timeZone) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            ZonedDateTime zdt = ZonedDateTime.now();
            String formattedLocalTime = dtf.format(zdt);
            System.out.println("Local Date and Time is : " + formattedLocalTime);

            ZonedDateTime userTimeZone = zdt.withZoneSameInstant(ZoneId.of(timeZone));
            String userTimeZone1 = dtf.format(userTimeZone);
            System.out.println("Date and Time for " + timeZone + " timezone is : " + userTimeZone1);
            return userTimeZone1;
        } catch (Exception e) {
            Assert.fail("Exception in getDateAndTimeInPreferredTimeZone method" + e);
            return null;
        }

    }

    public String convertDateFromDBToOtherFormat(String formatReq, String dateToBeConverted, String dateFormat) {
        try {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern(formatReq);
            DateTimeFormatter convertableDtf = DateTimeFormatter.ofPattern(dateFormat);

            LocalDate ld = LocalDate.parse(dateToBeConverted, convertableDtf);
            String formattedDate = dtf.format(ld);
            System.out.println("Actual date is : " + dateToBeConverted);
            System.out.println("Date after conversion is : " + formattedDate);
            return formattedDate;
        } catch (Exception e) {
            Assert.fail("Exception in convertDateFromDBToOtherFormat method" + e);
            return null;
        }

    }
    // *********** End of Date and Time related methods *********** //

    // *********** Random String *************** //
    public String getRandomString(int length) {
        String randomString = "";
        try {
            randomString = RandomStringUtils.random(length, 'a', 'z', true, true, null, new SecureRandom());
            return randomString;
        } catch (Exception e) {
            Assert.fail("Unable to generate random string");
            return null;
        }
    }

    // *********** Create Dummy File *************** //
    public static void createDummyFile(String fileName, int sizeInBytes) {
        try {
            File file = new File(projectHomeDir + "/src/test/resources/TestData/UploadDocuments/" + fileName);
            if (!file.exists()) {
                file.createNewFile();
                RandomAccessFile raf = new RandomAccessFile(file, "rw");
                raf.setLength(sizeInBytes);
                raf.close();
            } else {
                throw new Exception(String.format("File name (%s) was already existing, No file is created", fileName));
            }
        } catch (Exception e) {
            Assert.fail("Unable to create dummy file" + e);
        }
    }

}   //Class ends here
