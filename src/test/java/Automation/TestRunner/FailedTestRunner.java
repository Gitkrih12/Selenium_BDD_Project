package Automation.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
                (
                features = "@TestReports/FailedScenarios.txt",
                glue = "Automation/StepDefinitions",
                dryRun = false,
                monochrome = true,
                plugin = {"pretty", "html:TestReports/TestResults.html",
                          "json:TestReports/TestResults.json",
                          "junit:TestReports/TestResults.xml",
                          "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                         }
                )
public class FailedTestRunner {

}
