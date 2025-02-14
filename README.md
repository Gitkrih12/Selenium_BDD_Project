# Introduction

Refer this link for sample BDD cucumber framework with JUnit5
https://github.com/cucumber/cucumber-java-skeleton/

This framework can be used to automate the test cases using BDD cucumber framework with JUnit5.
The framework structure contains all the basic components required to start automation testing.

# Getting Started

Installation process
Setup java 18 or above version in your system
Download IntelliJ IDEA
Download Maven software
Download "Cucumber for Java" plugin in IntelliJ IDEA
Download "Gherkin" plugin in IntelliJ IDEA
Clone the repository from remote repository
Open the project in IntelliJ IDEA
Right-click on the TestRunner class and run the test cases

# Run tests from command line

To run the tests from command line, use the following command:
Example commands:
Run a specific runner class and tags:
mvn test -Dtest=Automation/TestRunner/JUnitTestRunnerTest -DexcludedGroups="ignore" -Dgroups="smoke | sanity"
Run another runner class:
mvn test -Dtest=Automation/TestRunner/JUnitAnotherTestRunnerTest -DexcludedGroups="ignore" -Dgroups="smoke | sanity"

Parallel mechanism:
By default, the tests are run in parallel. To run the tests in sequence, use the following command:
mvn test -Dtest=Automation/TestRunner/JUnitTestRunnerTest -DexcludedGroups="ignore" -Dgroups="smoke | sanity"
-Dcucumber.execution.parallel.enabled=false

Run tests in a specific environment:
mvn test -Dtest=Automation/TestRunner/JUnitTestRunnerTest -Denv="uat" -Dcucumber.execution.parallel.enabled=false

Retry failed test cases for a specific number of times:
Refer "rerunFailingTestsCount" tag in POM.xml file to change the retry count for failed test cases.
