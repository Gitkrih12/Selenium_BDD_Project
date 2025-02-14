package Automation.TestRunner;

import org.junit.platform.suite.api.*;
import io.cucumber.junit.platform.engine.Constants;

import static io.cucumber.junit.platform.engine.Constants.PLUGIN_PROPERTY_NAME;
import static io.cucumber.junit.platform.engine.Constants.GLUE_PROPERTY_NAME;

@Suite
@IncludeEngines("cucumber")

/*
     Scenario1:
     Provide the feature files path under @SelectClasspathResource.
     Example: features
     No need to mention the full path here. Cucumber will detect the path automatically.

     Scenario2:
     In case of multiple subdirectories and wants to read all then provide the parent directory name.
     Example: features/Login, features/Registration, features/Profile
     in this case parent is features

     Scenario3:
     When need to read a specific subdirectory then provide the full path starting from the parent directory.
        Example: features/Login
 */
@SelectClasspathResource("features")

/*
    pretty - Formats console output in a readable format
    html: - Generates a HTML report
    json: - Generates a JSON report
    junit: - Generates a JUnit report
    com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter: - Generates an Extent report
    rerun: - Generates a file with failed scenarios
 */
@ConfigurationParameter(key = Constants.PLUGIN_PROPERTY_NAME, value = "pretty, " +
        "html:TestReports/TestResults.html, " +
        "json:TestReports/TestResults.json, " +
        "junit:TestReports/TestResults.xml, " +
        "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:, " +
        "rerun:TestReports/FailedScenarios.txt, " +
        "timeline:TestReports/ThreadReport")
/*
    dryRun - Checks if the steps are defined or not
    false - Executes the test
    true - Checks the steps are defined or not
 */
@ConfigurationParameter(key = Constants.EXECUTION_DRY_RUN_PROPERTY_NAME, value = "false")
/*
    tags - Executes the scenarios which are tagged with a specific tag
    Example: @smoke, @regression
 */
//@ConfigurationParameter(key = "cucumber.filter.tags", value = "@retry")
@IncludeTags("sanity")

/*
    Follow the process same as SelectClasspathResource
    GLUE_PROPERTY_NAME must be listed after cucumber.filter.tags only.
    Otherwise tags passed on command line won't supersede the tags mentioned in the code.
 */
@ConfigurationParameter(key = Constants.GLUE_PROPERTY_NAME, value = "Automation.StepDefinitions")
@ConfigurationParameter(key = "env", value = "${env:default}")

public class JUnitTestRunnerTest {

}
