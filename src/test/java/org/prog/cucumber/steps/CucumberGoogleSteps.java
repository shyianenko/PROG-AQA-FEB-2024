package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.util.DataHolder;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;

public class CucumberGoogleSteps {

    public static WebDriver driver;

    @Given("I load google page")
    public void loadGooglePage() {
        driver.get("https://google.com/");
    }

    @Given("I accept cookies if present")
    public void acceptCookiesIfPresent() {
        List<WebElement> cookieButtons =
                driver.findElements(By.xpath(
                        "//a[contains(@href,'https://policies.google.com/technologies/cookies')]/../../../..//button"));
        if (!cookieButtons.isEmpty()) {
            cookieButtons.get(3).click();
        }
    }

    @When("I google for {string}")
    public void googleRandomUser(String alias) {
        WebElement searchInput = driver.findElement(By.name("q"));
        System.out.println("Searching for user : " + DataHolder.getInstance().get(alias));
        searchInput.sendKeys((String) DataHolder.getInstance().get(alias));
        searchInput.sendKeys(Keys.ENTER);
    }

    @Then("I can see at least {int} search results for {string}")
    public void checkSearchResultCount(int resultCount, String alias) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30L));
        List<WebElement> searchHeaders =
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("h3"), resultCount));

        int userNameFound = 0;
        for (WebElement element : searchHeaders) {
            if (element.getText().contains((String) DataHolder.getInstance().get(alias))) {
                userNameFound++;
            }
        }
        Assert.assertTrue(userNameFound >= resultCount,
                "Less than " + resultCount + " mentions of user found!");
    }
}
