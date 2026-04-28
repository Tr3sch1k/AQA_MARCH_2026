package org.prog.session15.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class WebDriverFactory {

    public static WebDriver getDriver() throws MalformedURLException {
        String envType = System.getProperty("env-type", "local-chrome");
        switch (envType) {
            case "local-chrome":
                return new ChromeDriver();
            case "local-grid-chrome":
                return new RemoteWebDriver(
                        new URL("http://localhost:4444/"),
                        new ChromeOptions());
            case "jenkins-chrome":
                return new RemoteWebDriver(
                        new URL("http://selenium-hub:4444/"),
                        new ChromeOptions());
            case "local-grid-firefox":
                return new RemoteWebDriver(
                        new URL("http://localhost:4444/"),
                        new FirefoxOptions());
            case "jenkins-firefox":
                return new RemoteWebDriver(
                        new URL("http://selenium-hub:4444/"),
                        new FirefoxOptions());
            default:
                return new EdgeDriver();
        }
    }
}
