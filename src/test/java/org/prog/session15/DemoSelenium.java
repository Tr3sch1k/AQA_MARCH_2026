package org.prog.session15;

import lombok.SneakyThrows;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

public class DemoSelenium {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() {
        driver = new ChromeDriver();
    }

    @SneakyThrows
    @Test
    public void demoSelenium() {
        driver.get("https://allo.ua/");
        WebElement search = driver.findElement(By.id("search-form__input"));
        search.sendKeys("iphone");
        search.submit();
        Thread.sleep(2000);
        List<WebElement> searchResults =
                driver.findElements(By.partialLinkText("Apple iPhone 1"));
        searchResults.stream()
                .filter(e -> e.getText().equals("Apple iPhone 17 Pro Max 256GB Cosmic Orange (MFYN4)"))
                .forEach(element -> {
                    element.findElement(By.xpath("..//button")).click();
                });
    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}
