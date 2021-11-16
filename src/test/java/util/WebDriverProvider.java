package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

public class WebDriverProvider {

    public static WebDriver getChromeDriver(WebDriver driver, ChromeOptions options){
        return WebDriverManager.chromedriver().capabilities(options).create();
    }
}
