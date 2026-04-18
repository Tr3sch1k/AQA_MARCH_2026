package org.prog.homeWork12;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import io.restassured.RestAssured;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
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

import java.sql.*;

public class homeWorkTest {

    private WebDriver driver;
    private WebDriverWait wait;
    private Page page;
    private Connection connection;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        ChromeOptions option = new ChromeOptions();
        option.addArguments("--disable-notifications");
        option.addArguments("--disable-popup-blocking");
        driver = new ChromeDriver(option);
        page = new Page(driver);
        driver.manage().window().maximize();
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
    }

    @Test
    public void sqlTest() throws SQLException, InterruptedException{

        page.load();
        page.clickSearchInput();
        page.setSearchValue("Iphone");
        page.acceptSearching();

//        page.createTableInDB();  // optional
        page.setValueInDB(123);



    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        driver.quit();
        page.dropTableInDB(); // optional
        connection.close();
    }
}
