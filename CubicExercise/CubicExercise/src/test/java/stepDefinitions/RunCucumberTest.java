package stepDefinitions;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import org.junit.runner.RunWith;

/**
 * Here, I have created test runner class with cucumber options, Then added the glue and the cucumber report plugin either for html or json in pretty format
 * Thus, after the test result in the following path; reports/cucumber_reports , we can access to the report and view it in browser
 *
 */
@RunWith(Cucumber.class)
@CucumberOptions(
        features = "classpath:features",
        snippets = SnippetType.CAMELCASE,
        stepNotifications = true,
        glue = {"utilities", "stepDefinitions"},
        plugin = {"html:reports/cucumber_reports/cucumber-html-report.html", "json:reports/cucumber_reports/cucumber.json", "pretty"},
        publish = true
)

public class RunCucumberTest {

}
