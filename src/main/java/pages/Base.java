package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Base {
    private static WebDriver browser;
    private static WebDriverWait wait;

    public Base(WebDriver browser) {
        Base.browser = browser;
        wait = new WebDriverWait(browser, Duration.ofSeconds(20));
    }

    public Base(WebDriver browser, WebDriverWait wait) {
        Base.browser = browser;
        Base.wait = wait;
    }

    public static WebDriver getDriver(){
        return browser;
    }

    public static WebDriverWait getWait() {
        return wait;
    }
}
