package org.prog.session15.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.prog.session15.page.GooglePage;
import org.testng.Assert;

@Slf4j
public class WebSteps {

    public static GooglePage googlePage;

    @Given("I load google page")
    public void loadGooglePage() {
        googlePage.load();
    }

    @Given("I accept cookies if present")
    public void acceptCookiesIfPresent() {
        if (googlePage.isCookieFormDisplayed()) {
            log.info("Cookies are present - accepting");
            googlePage.acceptCookieForm();
        } else {
            log.info("Cookies are not present - skipping");
        }
    }

    @When("I set search value to {string} First and Last name")
    public void setSearchValueToFirstLastName(String alias) {
        googlePage.clickSearchInput();
        googlePage.setSearchValue((String) DataManager.DATA.get(alias));
    }

    @Then("Search input is not empty")
    public void searchInputIsEmpty() {
        Assert.assertTrue(googlePage.searchSuggestionIsVisible());
    }
}
