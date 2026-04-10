package HomeWork10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.prog.session10.GooglePage;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class HomeWorkTests {

    private WebDriver driver;
    private WebDriverWait wait;

    private Page page;

    @BeforeSuite
    public void beforeSuite() {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        option.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(option);
        page = new Page(driver);
        driver.manage().window().maximize();
    }

    @Test
    public void myWebTest() throws InterruptedException {

        page.load();
        page.clickSearchInput();
        page.setSearchValue("samsung");
        page.acceptSearching();
        page.getId(123);
//        page.getId(3);

    }

    @AfterSuite
    public void afterSuite() {
        driver.quit();
    }

}
