package org.prog.session15.enums;

import org.openqa.selenium.By;

public enum GooglePageElements {
    SEARCH_SUGGESTIONS(By.xpath("//ul[@role='listbox']")),
    SEARCH_INPUT(By.name("q")),
    COOKIES_ACCEPT_BUTTON(By.xpath("//a[contains(@href, 'cookies')]/../../../..//button[2]")),
    COOKIES_LINK(By.xpath("//a[contains(@href, 'cookies')]"));

    private By by;

    GooglePageElements(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
