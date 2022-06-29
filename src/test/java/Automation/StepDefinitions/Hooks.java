package Automation.StepDefinitions;

import Automation.Utilities.Driver;
import io.cucumber.java.*;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;

import java.awt.*;
import java.io.*;

public class Hooks extends Driver {

    public String Scenario_Name;

    @Before(order = 0)
    public void setProperties() throws IOException {
        readConfig();
    }

    @Before(order = 1)
    public void before(Scenario scenario) throws IOException, AWTException {
        Scenario_Name = scenario.getName();
        System.out.println("###### Scenario:   " + Scenario_Name);

        String browser = prop.getProperty("browser").toLowerCase();
        String URL = prop.getProperty("url");

        try
        {
            openBrowser(browser, URL);
        } catch (Exception e) {
            System.out.println("Exception in launching browser:    " + e);
            Assert.fail("Exception in launching browser   :" + e);
        }

    }

    @After
    public void after(Scenario scenario) {
        try {
            String SStatus = null;
            String[] scenarioName = scenario.getName().split("-");
            boolean isFailed = scenario.isFailed();
            if (isFailed) {
                SStatus = "Fail";
                System.out.println(" !!!!! Scenario Name: " + scenario.getName() + "  Status -- " + SStatus + " !!!!!!! ");
                driver.quit();
            } else {
                SStatus = "Pass";
                System.out.println(" !!!!! Scenario Name: " + scenario.getName() + "  Status -- " + SStatus + " !!!!!!! ");
                 driver.quit();

            }
        } catch (Exception e) {
            System.out.println("Exception in after: " + e);
            Assert.fail("Exception in after: " + e);
        }
    }

    @AfterStep()
    public void getScreenShot(Scenario scenario) throws IOException {

        if(scenario.isFailed())
        {
            File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            byte[] fileContent = FileUtils.readFileToByteArray(source);
            scenario.attach(fileContent, "image/png", "Failed scenario :  " + scenario.getName());
        }
    }

}