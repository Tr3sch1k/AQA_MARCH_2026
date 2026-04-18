package org.prog.session12;

import io.restassured.RestAssured;
import org.prog.session11.dto.PersonDto;
import org.prog.session11.dto.ResultsDto;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.sql.*;

//TODO: Create DB table allo_ua_goods
//TODO: Load allo.ua
//TODO: Find 3 iphones
//TODO: Get "код товара"
//TODO: Get "название"
//TODO: If this "код товара" with this "название" does not exist in DB - insert into DB else - do nothing


public class SQLTest {

    private Connection connection;

    @BeforeSuite
    public void beforeSuite() throws SQLException {
        connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
    }

    @Test
    public void sqlTestSelect() throws SQLException {
        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select * from Persons");
        while (resultSet.next()) {
            System.out.println(resultSet.getString("FirstName") +
                    " " + resultSet.getString("LastName"));
        }
    }

    @Test
    public void sqlTestInsertStatement() throws SQLException {
        Statement statement = connection.createStatement();
        int entryCount = countPersons(statement);
        statement.execute("INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) VALUES ('TestFirstName', 'TestLastName', 'TestGender', 'TestTitle', 'TestNat')");
        int entryCountPostInsert = countPersons(statement);
        Assert.assertTrue(entryCountPostInsert - entryCount == 1);
    }

    @Test
    public void sqlTestInsertPreparedStatement() throws SQLException {
        Statement statement = connection.createStatement();
        int entryCount = countPersons(statement);

        ResultsDto dto = RestAssured.given()
                .baseUri("https://randomuser.me/")
                .basePath("/api")
                .queryParam("inc", "gender,name,nat")
                .queryParam("noinfo")
                .queryParam("results", 1)
                .get()
                .as(ResultsDto.class);

        PreparedStatement preparedStatement = connection.prepareStatement(
                "INSERT INTO Persons (FirstName, LastName, Gender, Title, Nat) " +
                        "VALUES (?, ?, ?, ?, ?)");
        for (PersonDto p : dto.getResults()) {
            try {
                preparedStatement.setString(1, p.getName().getFirst());
                preparedStatement.setString(2, p.getName().getLast());
                preparedStatement.setString(3, p.getGender());
                preparedStatement.setString(4, p.getName().getTitle());
                preparedStatement.setString(5, p.getNat());
                preparedStatement.execute();
            } catch (SQLException e) {
                System.err.println("Failed to store to DB: " + p);
            }
        }

        int entryCountPostInsert = countPersons(statement);
        Assert.assertTrue(entryCountPostInsert - entryCount > 0);
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

    @AfterSuite
    public void afterSuite() throws SQLException {
        connection.close();
    }
}
