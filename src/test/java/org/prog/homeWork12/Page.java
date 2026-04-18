package org.prog.homeWork12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.sql.*;


public class Page {

    private WebDriver driver;
    private WebDriverWait wait;
    private List<WebElement> searchSuggestions;
    private Connection connection;
    private Statement statement;
    private Actions actions;

    public Page(WebDriver driver) throws SQLException{
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
        this.connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/db", "root", "password");
        this.statement = connection.createStatement();
        this.actions = new Actions(driver);
    }

    public void load() {
        driver.get("https://www.allo.ua/");
    }


    public void clickSearchInput() {
        WebElement searchBox = driver.findElement(By.id("search-form__input"));
        searchBox.click();
    }

    public void setSearchValue(String searchValue) {
        WebElement searchBox = driver.findElement(By.id("search-form__input"));
        searchBox.sendKeys(searchValue);
    }

    public void acceptSearching(){
        WebElement submitButton = driver.findElement(By.className("search-form__submit-button"));
        submitButton.click();
        searchSuggestions = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(
                By.className("products-layout__item")));
    }

    public void getId(Integer number) {
        if (number < searchSuggestions.size()) {
            for (int i = 0; i < number; i++) {
                actions.moveToElement(searchSuggestions.get(i));
                actions.perform();
                int n = i+1;
                System.out.println("ID product " + n + " = " + searchSuggestions.get(i).findElement(By.className("product-sku__value")).getText());
            }
        } else {
            System.out.println("Out of bound\nSize products = " + searchSuggestions.size());

            IntStream.range(0, searchSuggestions.size()).forEach(i-> {
                WebElement e = searchSuggestions.get(i);
                actions.moveToElement(e);
                actions.perform();
                int n = i + 1;
                System.out.println("ID product " + n + " = " + e.findElement(By.className("product-sku__value")).getText());
            });
        }

    }

/// /////////////////////////////////////////////+NEW+///////////////////////////////////////////////////////////////////////////

    public void createTableInDB()  throws SQLException{
        statement.execute("Create table Phone (\n" +
                "\tProductID varchar(255) NOT NULL,\n" +
                "\tProductName varchar(255) NOT NULL\n" +
                ");");
    }

    public void setValueInDB(Integer number) throws SQLException{
        if (number < searchSuggestions.size()) {
            for (int i = 0; i < number; i++) {

                actions.moveToElement(searchSuggestions.get(i));
                actions.perform();

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

                actions.moveToElement(el);
                actions.perform();

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

    public void dropTableInDB()  throws SQLException{
        statement.execute("DROP TABLE Phone");
    }


}