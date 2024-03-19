package org.prog.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.prog.cucumber.steps.CucumberGoogleSteps;
import org.prog.util.DataHolder;
import org.prog.web.WebDriverFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

@CucumberOptions(
        features = "src/test/resources/cucumber",
        glue = "org.prog.cucumber.steps",
        plugin = {"pretty",
                "json:target/cucumber-reports/Cucumber.json",
                "html:target/cucumber-report.html"
        }
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void init() {
        CucumberGoogleSteps.driver = WebDriverFactory.getDriver();
    }

    @BeforeMethod
    public void resetHolder() {
        DataHolder.getInstance().clear();
    }

    @AfterSuite
    public void tearDown() {
        CucumberGoogleSteps.driver.quit();
    }
}
