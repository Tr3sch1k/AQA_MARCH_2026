package org.prog.session13.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.prog.session11.dto.PersonDto;
import org.prog.session11.dto.ResultsDto;
import org.testng.Assert;

import java.sql.*;

@Slf4j
public class DBSteps {

    public static Connection connection;
    public static Statement statement;

    @Given("Entries count in table {string} as {string}")
    public void storeInitialCount(String tableName, String alias) throws SQLException {
        log.info("Count entries in {}", tableName);
        log.debug("Storing initial count in table {} as {}", tableName, alias);
        DataManager.DATA.put(alias, countPersons(statement));
    }

    @When("I store {string} to {string} table")
    public void storeThemToPersonsTable(String alias, String tableName) throws SQLException {
        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                        "VALUES (?, ?, ?, ?, ?)");
        ResultsDto dto = (ResultsDto) DataManager.DATA.get(alias);
        for (PersonDto p : dto.getResults()) {
            try {
                preparedStatement.setString(1, p.getName().getFirst());
                preparedStatement.setString(2, p.getName().getLast());
                preparedStatement.setString(3, p.getGender());
                preparedStatement.setString(4, p.getName().getTitle());
                preparedStatement.setString(5, p.getNat());
                preparedStatement.execute();
            } catch (SQLException e) {
                log.error("Exception while inserting initial count in table {} as {}", tableName, alias);
            }
        }
    }

    @Then("Table {string} has {int} more records than {string}")
    public void validateTableSize(String tableName, int amount, String alias) throws SQLException {
        int oldAmount = (Integer) DataManager.DATA.get(alias);
        int newAmount = countPersons(statement);
        Assert.assertTrue(newAmount - oldAmount == amount,
                "Table records count mismatch! Initial: " + oldAmount + " current: " + newAmount);
    }

    private int countPersons(Statement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery("select count(*) from Persons");
        int entryCount = 0;
        if (resultSet.next()) {
            entryCount = resultSet.getInt(1);
        } else {
            Assert.fail("Failed to retrieve entries from table");
        }
        return entryCount;
    }
}
