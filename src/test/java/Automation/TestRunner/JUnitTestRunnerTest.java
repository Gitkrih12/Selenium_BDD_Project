package Automation.TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//src/test/java/Automation/Features/",
                glue = "Automation/StepDefinitions",
                dryRun = false,
                monochrome = true,
                tags = "@55435",
                plugin = {"pretty", "html:TestReports/TestResults.html",
                          "json:TestReports/TestResults.json",
                          "junit:TestReports/TestResults.xml",
                          "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                          "rerun:TestReports/FailedScenarios.txt",
                          "timeline:TestReports/ThreadReport"
                         }
        )
public class JUnitTestRunnerTest {

}
