package org.prog.session10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

//TODO: re-write tests to page object model
//TODO: Add maximize window
//TODO: assert not null for "код товару" for first 3 phones in search (Use Actions)
//TODO: * - do this using stream()

public class WebTests {

    private WebDriver driver;

    private GooglePage googlePage;

    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        option.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(option);
        googlePage = new GooglePage(driver);
    }

    @Test
    public void myWebTest1() throws InterruptedException {
        googlePage.load();
        if (googlePage.isCookieFormDisplayed()) {
            googlePage.acceptCookieForm();
        }
        googlePage.clickSearchInput();
        googlePage.setSearchValue("selenium tutorial");
        Assert.assertTrue(googlePage.searchSuggestionIsVisible());
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        WebElement suggestion = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//span[text()='selenium tutorial']")
                )
        );
        Assert.assertTrue(suggestion.isDisplayed(), "suggestion list must contain 'selenium tutorial'");
    }

    // HTML -> iframe1 -> iframe2 -> iframe3 -> iframe4
    // HTML <- we start here
    // driver.switchTo().frame(frame1); -> frame1
    // driver.switchTo().frame(frame2); -> frame2
    // driver.switchTo().frame(frame3); -> frame3
    // frame3
    // driver.switchTo().defaultContent(); -> HTML
    // driver.switchTo().parentFrame(); -> frame2

    @Test
    public void myWebTest2() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        driver.get("https://www.w3schools.com/html/tryit.asp?filename=tryhtml_buttons_basic");
        WebElement cookiesForm =
                wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fast-cmp-iframe")));
        driver.switchTo().frame(cookiesForm);
        WebElement acceptButton = driver.findElement(By.className("fast-cmp-button-primary"));
        acceptButton.click();
        driver.switchTo().defaultContent();

        System.out.println("cookies OK");

        driver.switchTo().frame("iframeResult");
        WebElement iframeButton = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//button[text()='Click Me']")
                )
        );

        Assert.assertTrue(iframeButton.isDisplayed());

        driver.switchTo().defaultContent();
        WebElement runButton = driver.findElement(By.id("runbtn"));
        Assert.assertTrue(runButton.isDisplayed());
    }

    @Test
    public void myWebTest3() throws InterruptedException {
//        JavascriptExecutor executor = (JavascriptExecutor) driver;
//        WebElement runButton = driver.findElement(By.id("runbtn"));
//        executor.executeScript("arguments[0].click();", runButton);
//
//        Actions actions = new Actions(driver);
    }

    @Test
    public void myWebTest4() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://allo.ua/");
        WebElement catalog = driver.findElement(By.className("mh-catalog-btn"));
        Actions actions = new Actions(driver);
        actions.moveToElement(catalog);
        actions.perform();
        Thread.sleep(20000);
    }

    @Test
    public void myWebTest5() throws InterruptedException {
//        List<String> strings = new ArrayList<>();
//        strings.add("value 1");
//        strings.add("value 2");
//        strings.add("value 3");
//        strings.add("value 4");
//        strings.add("value 5");
//        strings.add("value 6");
//        strings.add("value 7");
//        strings.add("value 8");
//        strings.add("value 9");
//        strings.add("value 10");

        List<WebElement> googleLinks = driver.findElements(By.tagName("h3"));
        Assert.assertTrue(googleLinks.stream()
                .map(WebElement::getText)
                .anyMatch(s -> s.equals("Shadow DOM concepts - Polymer Project")));
        googleLinks.stream()
                .filter(e -> e.getText().contains("DOM"))
                .forEach(e -> {
                    System.out.println(e.getText());
                    e.click();
                });

//        String textWeWantToSee = "Shadow DOM concepts - Polymer Project";
//        List<String> headings = new ArrayList<>();
//        for (WebElement googleLink : googleLinks) {
//            headings.add(googleLink.getText());
//        }
//        Assert.assertTrue(headings.contains(textWeWantToSee));


    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }
}
