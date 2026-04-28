package org.prog.session15.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.prog.session15.enums.GooglePageElements;
import org.prog.session15.enums.WebElementState;
import org.testng.Assert;

import static org.prog.session14.enums.WebElementState.NOT_VISIBLE;
import static org.prog.session14.enums.WebElementState.VISIBLE;

@Slf4j
public class WebAtomicSteps {

    public static WebDriver driver;

    @Given("I load {string}")
    public void loadPage(String url) {
        driver.get(url);
    }

    @Given("I click {} if {} is {}")
    public void clickElementIfElementIs(GooglePageElements target,
                                        GooglePageElements condition,
                                        WebElementState state) {
        if (driver.findElement(condition.getBy()).isDisplayed() && VISIBLE.equals(state)) {
            driver.findElement(target.getBy()).click();
        } else if (!driver.findElement(condition.getBy()).isDisplayed() && NOT_VISIBLE.equals(state)) {
            driver.findElement(target.getBy()).click();
        } else {
            log.error("Condition not satisfied");
            Assertions.fail("Condition not satisfied");
        }
    }

    @Given("I click {} element")
    public void clickElement(GooglePageElements target) {
        driver.findElement(target.getBy()).click();
    }

    @Given("I set {} value to {string}")
    public void setElementText(GooglePageElements target, String value) {
        driver.findElement(target.getBy()).sendKeys(value);
    }

    @Then("Element {} is {}")
    public void checkElementIsVisible(GooglePageElements target, WebElementState state) {
        if (VISIBLE.equals(state)) {
            Assert.assertTrue(driver.findElement(target.getBy()).isDisplayed());
        } else if (NOT_VISIBLE.equals(state)) {
            Assert.assertFalse(driver.findElement(target.getBy()).isDisplayed());
        } else {
            Assertions.fail("Not implemented yet");
        }
    }
}
