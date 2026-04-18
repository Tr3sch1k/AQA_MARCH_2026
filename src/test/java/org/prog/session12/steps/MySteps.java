package org.prog.session12.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MySteps {

    @Given("I request random people from randomuser.me")
    public void requestUsers() {
        System.out.println("Requesting random people from randomuser.me");
    }

    @When("I store them to DB")
    public void storeUsers() {
        System.out.println("Storing random people from randomuser.me");
    }

    @Then("DB entry count increases")
    public void dbEntryCountIncreases() {
        System.out.println("DB entry count increases");
    }
}
