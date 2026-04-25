package org.prog.homework14.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;
import org.prog.homework14.page.AlloUA;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;

import org.testng.Assert;

@Slf4j
public class WebSteps {
    public static AlloUA alloUAPage;

    @Given("I load AlloUA page")
    public void loadAlloPage() {
        alloUAPage.load();
    }

    @And("I search product {string}")
    public void setSearch(String string){
        alloUAPage.clickSearchInput();
        alloUAPage.setSearchValue(string);
    }

    @And("I accept search value and save suggestions by key {string}")
    public void acceptSearch(String string){
        alloUAPage.acceptSearching(string);
    }

}
