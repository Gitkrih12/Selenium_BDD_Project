package Automation.PageObjects;

import Automation.Utilities.SeleniumUtils;
import io.cucumber.datatable.DataTable;
import org.junit.Assert;

import java.util.List;
import java.util.stream.Collectors;

public class ActivityLoggerPage extends SeleniumUtils {

    String tabActivityLogger = "//button[@id ='nav-activity-logger-tab']";
    String lstActivityLogger = "//app-activity-logger//*[@id = 'resultsGrid']//span[@ref = 'eText']";
    String btnFooterSection = "//*[@class='button-padding-left footer']//button";



    //  Scenario: Verify user able to navigate to Activity Logger tab
    public void userClicksOnActivityLogger() throws InterruptedException {
        clickElement(tabActivityLogger);
        threadSleep(1000);
    }

    public void verifyUserNavigatesToActivityLogger(String expTab){
        Assert.assertEquals(expTab, findElementByXpath(tabActivityLogger).getText());
    }

    public void userViewsActivityLoggerFields(DataTable expFields){
        List<String> fieldsExp = expFields.asList();
        List<String> ActFields = findElementsByXpath(lstActivityLogger)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size" + ActFields.size());
        System.out.println("Activity Logger Fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }

    public void userViewsFooterSectionInActivityLogger(DataTable expFooterSection){
        List<String> fieldsExp = expFooterSection.asList();
        List<String> ActFields = findElementsByXpath(btnFooterSection)
                .stream().map((e) -> e.getText().trim()).collect(Collectors.toList());
        System.out.println("Size" + ActFields.size());
        System.out.println("Footer fields should display:" + ActFields);
        System.out.println("Expected fields are: " + fieldsExp);
        Assert.assertEquals(ActFields, fieldsExp);
    }
}