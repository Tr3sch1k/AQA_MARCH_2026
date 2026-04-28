package org.prog.session15.page.widget;

import org.openqa.selenium.WebDriver;

public class ItemCard {

    private final WebDriver driver;

    public ItemCard(WebDriver driver) {
        this.driver = driver;
    }

    public String getPrice() {
        return "123";
    }

    public String getname() {
        return "name";
    }

    public void addToCart() {

    }
}
