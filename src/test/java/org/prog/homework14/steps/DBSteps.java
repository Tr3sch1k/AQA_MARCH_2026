package org.prog.homework14.steps;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.prog.homework14.page.AlloUA;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DBSteps {
    public static Connection connection;
    public static Statement statement;


    @Given("I create DB")
    public void createTableInDB()  throws SQLException {
        statement.execute("Create table Phone (\n" +
                "\tProductID varchar(255) NOT NULL,\n" +
                "\tProductName varchar(255) NOT NULL\n" +
                ");");
    }

    @Then("I storage {int} product in DB by key {string}")
    public void storageProductinDB(Integer number, String string) throws SQLException{
        List<WebElement> searchSuggestions = (List<WebElement>) DataManager.DATA.get(string);

        if (number < searchSuggestions.size()) {
            for (int i = 0; i < number; i++) {
                WebSteps.alloUAPage.moveIt(searchSuggestions.get(i));

                String id = searchSuggestions.get(i).findElement(By.className("product-sku__value")).getText();
                String nm = searchSuggestions.get(i).findElement(By.className("product-card__title")).getText();

                if (equalsID(id)) {
                    System.out.println("Sorry. " + id + " present in DB");
                } else {
                    String sql = "INSERT INTO Phone (ProductID, ProductName) VALUES ('"+ id +"', '"+ nm +"')";
                    try {
                        statement.execute(sql);
                    } catch (Exception e) {
                        System.out.println("ERROR SVIDB " + id + " " + nm);
                    }
                }

            }
        } else {
            System.out.println("Out of bound\nSize products = " + searchSuggestions.size());
            searchSuggestions.stream().forEach(el-> {

                WebSteps.alloUAPage.moveIt(el);

                String id = el.findElement(By.className("product-sku__value")).getText();
                String nm = el.findElement(By.className("product-card__title")).getText();

                try {
                    if (equalsID(id)) {
                        System.out.println("Sorry. " + id + " present in DB");
                    } else {
                        String sql = "INSERT INTO Phone (ProductID, ProductName) VALUES ('"+ id +"', '"+ nm +"')";
                        try {
                            statement.execute(sql);
                        } catch (Exception e) {
                            System.out.println("ERROR SVIDB_Else " + id + " " + nm);
                        }
                    }
                } catch (Exception e) {
                    System.out.println("meaw????"); /// I dont know why did it. In STREAM. When i add func "equalsID"
                }
            });
        }
    }


    private boolean equalsID(String newID) throws SQLException{
        ResultSet resultSet = null;
        try {
            resultSet = statement.executeQuery("select * from Phone");
        } catch (Exception e) {
            System.out.println("sorry DB not create");
            createTableInDB();
            System.out.println("DB is creating");
        }

        try {
            resultSet = statement.executeQuery("select * from Phone");
            while (resultSet.next()) {
                if (resultSet.getString("ProductID").equals(newID)) {
                    return true;
                }
            }
        } catch (Exception e) {
            System.out.println("TablePhone = empty");
        }
        return false;
    }

}
