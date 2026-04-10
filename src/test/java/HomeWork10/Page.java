package HomeWork10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Page {

    private WebDriver driver;
    private WebDriverWait wait;
    public List<WebElement> searchSuggestions;

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5L));
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
        Actions actions = new Actions(driver);
        if (number < searchSuggestions.size()) {
            for (int i = 0; i < number; i++) {
                actions.moveToElement(searchSuggestions.get(i));
                actions.perform();
                int n = i+1;
                System.out.println("ID product " + n + " = " + searchSuggestions.get(i).findElement(By.className("product-sku__value")).getText());
            }
        } else {
            System.out.println("Out of bound\nSize products = " + searchSuggestions.size());

//            searchSuggestions.stream().forEach(e-> {
//                actions.moveToElement(e);
//                actions.perform();
//                System.out.println("ID product " + " = " + e.findElement(By.className("product-sku__value")).getText());
//            });

            IntStream.range(0, searchSuggestions.size()).forEach(i-> {
                WebElement e = searchSuggestions.get(i);
                actions.moveToElement(e);
                actions.perform();
                int n = i + 1;
                System.out.println("ID product " + n + " = " + e.findElement(By.className("product-sku__value")).getText());
            });
        }

    }

    public void searchSuggestionIsNotNull() {
      Assert.assertTrue(!searchSuggestions.stream().map(WebElement::getText).anyMatch(s-> s.equals(null)));
    }

}
