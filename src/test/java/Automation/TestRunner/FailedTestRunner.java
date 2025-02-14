package Automation.TestRunner;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.platform.engine.Cucumber;
import org.junit.platform.suite.api.SelectClasspathResource;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasspathResource("Automation/TestRunner")
@Cucumber
@CucumberOptions(
        features = "@TestReports/FailedScenarios.txt",
        glue = "Automation/StepDefinitions",
        dryRun = false,
        monochrome = true,
        plugin = {
                "pretty",
                "html:TestReports/TestResults.html",
                "json:TestReports/TestResults.json",
                "junit:TestReports/TestResults.xml",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        }
)
public class FailedTestRunner {
}