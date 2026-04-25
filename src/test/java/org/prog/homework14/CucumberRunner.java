package org.prog.homework14;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.prog.homework14.page.AlloUA;
import org.prog.homework14.steps.DBSteps;
import org.prog.homework14.steps.WebSteps;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.DriverManager;
import java.sql.SQLException;


@CucumberOptions(
        tags = "@mytest",
        glue = "org.prog.homework14.steps",
        features = "src/test/resources/features"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    private WebDriver driver;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        driver = new ChromeDriver();
        WebSteps.alloUAPage = new AlloUA(driver);

        DBSteps.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
        DBSteps.statement = DBSteps.connection.createStatement();
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        DBSteps.connection.close();
        driver.quit();
    }
}