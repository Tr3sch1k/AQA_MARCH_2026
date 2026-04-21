package org.prog.session13.enums;

import org.openqa.selenium.By;

public enum GooglePageElements {
    COOKIES_LINK(By.xpath("//link"));

    private By by;

    GooglePageElements(By by) {
        this.by = by;
    }

    public By getBy() {
        return by;
    }
}
