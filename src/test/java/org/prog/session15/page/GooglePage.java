package org.prog.session15.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

public class GooglePage {

    private WebDriver driver;
    private WebDriverWait wait;

    public GooglePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
    }

    public void load() {
        driver.get("https://www.google.com/");
    }

    public boolean isCookieFormDisplayed() {
        return driver.findElement(
                By.xpath("//a[contains(@href, 'cookies')]")).isDisplayed();
    }

    public void acceptCookieForm() {
        List<WebElement> cookieFormButtons =
                driver.findElements(By.xpath(
                        "//a[contains(@href, 'cookies')]/../../../..//button"));
        cookieFormButtons.get(3).click();
    }

    public void rejectCookiesForm() {
        List<WebElement> cookieFormButtons =
                driver.findElements(By.xpath(
                        "//a[contains(@href, 'cookies')]/../../../..//button"));
        cookieFormButtons.get(2).click();
    }

    public void clickSearchInput() {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
    }

    public void setSearchValue(String searchValue) {
        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys(searchValue);
    }

    public boolean searchSuggestionIsVisible() {
        try {
            List<WebElement> suggestions = getSearchSuggestions();
            return suggestions.stream().allMatch(WebElement::isDisplayed);
        } catch (Exception e) {
            return false;
        }
    }

    public List<WebElement> getSearchSuggestions() {
        return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                        By.xpath("//ul[@role='listbox']")
                )).stream()
                .filter(WebElement::isDisplayed)
                .collect(Collectors.toList());
    }
}
