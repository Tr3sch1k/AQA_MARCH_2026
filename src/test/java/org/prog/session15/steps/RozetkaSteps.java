package org.prog.session15.steps;

import io.cucumber.java.en.Given;
import org.prog.session15.page.RozetkaPage;

public class RozetkaSteps {

    public static RozetkaPage rozetkaPage;

    @Given("Load rozetka.com.ua")
    public void load_rozetka() {
        rozetkaPage.loadPage();
    }

    @Given("Open side menu {string}")
    public void open_side_menu(String menu) {
        rozetkaPage.sideMenu.selectItemCategory(menu);
    }
}
