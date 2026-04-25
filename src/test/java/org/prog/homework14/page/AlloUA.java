package org.prog.homework14.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.homework14.steps.DataManager;

import java.sql.*;
import java.time.Duration;

public class AlloUA {

    private WebDriver driver;
    private WebDriverWait wait;
    private Actions actions;

    public AlloUA(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        this.actions = new Actions(driver);
        this.driver.manage().window().maximize();
    }

    public void load() {
        driver.get("https://www.allo.ua/");
    }

    public void clickSearchInput() {
        WebElement searchBox = driver.findElement(By.id("search-form__input"));
        searchBox.click();
    }

    public void setSearchValue(String searchValue) {
        WebElement searchBox = driver.findElement(By.id("search-form__input"));
        searchBox.sendKeys(searchValue);
    }

    public void acceptSearching(String string){
        WebElement submitButton = driver.findElement(By.className("search-form__submit-button"));
        submitButton.click();

        DataManager.DATA.put(string, wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.className("products-layout__item"))));

    }

    public void moveIt(WebElement searchSuggestions){
        actions.moveToElement(searchSuggestions);
        actions.perform();
    }

}
