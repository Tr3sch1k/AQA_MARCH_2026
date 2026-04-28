package org.prog.session15.page;

import org.openqa.selenium.WebDriver;
import org.prog.session15.page.widget.ItemCard;
import org.prog.session15.page.widget.SideMenu;

public class RozetkaPage {

    public final SideMenu sideMenu;
    public final ItemCard itemCard;

    public RozetkaPage(WebDriver driver) {
        this.sideMenu = new SideMenu(driver);
        this.itemCard = new ItemCard(driver);
    }

    public void loadPage() {
    }

}
