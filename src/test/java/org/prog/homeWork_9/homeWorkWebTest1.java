package org.prog.homeWork_9;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class homeWorkWebTest1 {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @Test
    public void myWebTest1() throws InterruptedException {

        driver.get("https://www.allo.ua/");

        WebElement searchBox = driver.findElement(By.id("search-form__input"));
        searchBox.click();
        searchBox.sendKeys("samsung");

        WebElement submitButton = driver.findElement(By.className("search-form__submit-button"));
        submitButton.click();

//        Thread.sleep(1000);

        List<WebElement> searchSuggestions = wait.until(driver -> {
            List<WebElement> elements = driver.findElements(By.className("products-layout__item"));
            return elements.isEmpty() ? null : elements;});

//        List<WebElement> searchSuggestions = driver.findElements(By.className("products-layout__item"));
//        for (WebElement element : searchSuggestions) {
//            WebElement text = element.findElement(By.className("product-card__title"));
//            System.out.println(text.getAccessibleName());
//        }

        Assert.assertTrue(!searchSuggestions.isEmpty(), "Products list = null");
        Assert.assertTrue(searchSuggestions.get(0).findElement(By.className("product-card__title")).getAccessibleName() != null, "Product list = null");

    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}
