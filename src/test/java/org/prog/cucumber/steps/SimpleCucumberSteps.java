package org.prog.cucumber.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class SimpleCucumberSteps {

    @Given("I print {string} and {string}")
    public void mySimpleSetupStep(String value, String valueTwo) {
        System.out.println("I print " + value + valueTwo);
    }

    @When("I do something")
    public void mySimpleAction() {
        System.out.println("I execute some action");
    }

    @Then("I can see some results")
    public void simpleResults() {
        System.out.println("I can see some results");
    }
}
