package Automation.Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.awt.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.time.Duration;
import java.util.Collections;
import java.util.Properties;

public class Driver {

    public Logger log;
    public WebDriver driver = getWebDriver();
    private static DesiredCapabilities capabilities;
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>();

    public static PropertyReader prop;
    protected static String environment;

    public void readConfig() throws IOException
    {
        try
        {
            environment = System.getProperty("Environment");
            if (environment == null)
            {
                environment = "test";
            }
            String propPath = ".//src/test/resources/Config/" +environment+".properties";
            System.out.println("Environment path : " + propPath);
            prop = new PropertyReader(propPath);
        }catch (Exception e)
        {
            Assert.fail("Error in loading properties: " + e);
        }
    }


    public void openBrowser(String browser, String URL) throws MalformedURLException, AWTException
    {
        DesiredCapabilities capabilities;
        switch (browser)
        {
            case ("firefox"):
                threadDriver.set(setFirefoxDriverLocal());
                break;
            case ("chrome"):
                threadDriver.set(setChromeDriverLocal());
                break;
            case ("edge"):
                threadDriver.set(setEdgeDriverLocal());
                break;

            default:
                Assert.fail("Invalid browser [ " + browser + " ] is selected");
        }
        driver.manage().deleteAllCookies();
        driver.manage().window().maximize();
        driver.get(URL);
    }

    private WebDriver setFirefoxDriverLocal()
    {
        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("-private");

        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver(options);
        return driver;
    }


    private WebDriver setChromeDriverLocal() throws AWTException
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        options.addArguments("--headless");
        options.addArguments("window-size=1920,1080");
        options.addArguments("--disable-features=VizDisplayCompositor");
        options.addArguments("disable-infobars");
        options.addArguments("--no-sandbox");
        options.addArguments("use-fake-ui-for-media-stream=1");
        options.setExperimentalOption("useAutomationExtension", false);
        options.setExperimentalOption("excludeSwitches", Collections.singletonList("enable-automation"));

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        return driver;
    }

    public WebDriver setEdgeDriverLocal() throws AWTException
    {
        EdgeOptions options = new EdgeOptions();
        options.addArguments("InPrivate");

        WebDriverManager.edgedriver().setup();
        driver = new EdgeDriver(options);
        return driver;
    }


    public static WebDriver getWebDriver()
    {
        System.out.println("WebDriver " + threadDriver.get());
        return threadDriver.get();
    }

}
