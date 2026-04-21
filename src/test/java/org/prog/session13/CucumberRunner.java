package org.prog.session13;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.prog.session13.steps.DBSteps;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.sql.DriverManager;
import java.sql.SQLException;

//TODO: Adapt previous homework to cucumber

@CucumberOptions(
        tags = "@rest_and_db",
        glue = "org.prog.session13.steps",
        features = "src/test/resources/features"
)
public class CucumberRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        DBSteps.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
        DBSteps.statement = DBSteps.connection.createStatement();
    }

    @AfterSuite
    public void afterSuite() throws SQLException {
        DBSteps.connection.close();
    }
}
