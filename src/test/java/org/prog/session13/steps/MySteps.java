package org.prog.session13.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.prog.session13.enums.UserType;

public class MySteps {

    @Given("I request {int} random people from randomuser.me")
    public void requestUsers(int amount) {
        System.out.println("Requesting " + amount + " random people from randomuser.me");
    }

    @When("I store them to {string} DB")
    public void storeUsers(String dbName) {
        System.out.println("Storing random people from randomuser.me to " + dbName);
    }

    @Then("DB entries in {string} count increases by {long}")
    public void dbEntryCountIncreases(String dbName, long count) {
        System.out.println("DB entries count in " + dbName + " increases by " + count);
    }

    @Then("New entries have user type {}")
    public void validateUserType(UserType userType) {
        System.out.println("New entries have user type " + userType.name());
    }

    @Then("User nationalities in DB are:")
    public void validateUserNats(DataTable dataTable) {
        for (String s : dataTable.asList()) {
            System.out.println("Looking for: " + s);
        }
    }

    @Given("Add user to DB")
    public void adduserToDB(DataTable dataTable) {
        System.out.println("Adding user to DB");
        System.out.println("First Name: " + dataTable.asMap().get("firstName"));
        System.out.println("Last Name: " + dataTable.asMap().get("lastName"));
    }
}
