package org.prog.session9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

//TODO: write test to:
// - go to allo.ua
// - search for iphone
// - assert 1st card title is not null

public class WebTests {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
    }

    @Test
    public void myWebTest1() throws InterruptedException {
        driver.get("https://www.google.com/");
        WebElement cookiesForm = driver.findElement(
                By.xpath("//a[contains(@href, 'cookies')]"));
        if (cookiesForm.isDisplayed()) {
            List<WebElement> cookieFormButtons =
                    driver.findElements(By.xpath(
                            "//a[contains(@href, 'cookies')]/../../../..//button"));
            cookieFormButtons.get(3).click();
        }

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.click();
        searchBox.sendKeys("selenium tutorial");

        List<WebElement> searchSuggestions = driver.findElements(By.xpath(
                "//ul[@role='listbox']"));
        WebElement visibleList = null;
        for (WebElement element : searchSuggestions) {
            if (element.isDisplayed()) {
                visibleList = element;
            }
        }
        Assert.assertNotNull(visibleList, "suggestions list must be visible!");
        Thread.sleep(250);
        WebElement suggestion = visibleList.findElement(By.xpath("//span[text()='selenium tutorial']"));
        Assert.assertTrue(suggestion.isDisplayed(), "suggestion list must contain 'selenium tutorial'");
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}
