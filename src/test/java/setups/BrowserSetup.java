package setups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import util.Configs;

import java.util.HashMap;
import java.util.Map;

public class BrowserSetup extends BrowserInstance {
    ChromeDriver chromeDriver;
    ChromeOptions chromeOptions;
    FirefoxDriver firefoxDriver;
    FirefoxOptions firefoxOptions;
    RemoteWebDriver browser;
    WebDriver driver;
    DesiredCapabilities capabilities;


    protected void startBrowser(){

        switch (Configs.getConfig().getString("webdriver.driver")){
            case "chrome":
                chromeOptions = new ChromeOptions();
                Map<String, Object> prefs = new HashMap<>();
                prefs.put("intl.accept_languages","en-GB, en-US");
                chromeOptions.addArguments(
                        "--lang=en-GB, en_US",
                        "--start-maximized",
                        "--no-sandbox",
//                        "--headless",
                        "--user-agent='Mozilla/5.0 (X11; Linux x86_64)",
                        "--disable-dev-shm-usage");
                chromeOptions.setExperimentalOption("prefs", prefs);
                // AppleWebKit/537.36 (KHTML, like Gecko) Chrome/33.0.1750.517 Safari/537.36
                driver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
                chromeDriver = new ChromeDriver(chromeOptions);
                browser = chromeDriver;
                setBrowserInstance(chromeDriver);
                break;
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(
                        "--lang='en, en_US'",
                        "--start-maximized",
                        "--no-sandbox",
//                        "--headless",
                        "--user-agent='Mozilla/5.0 (X11; Linux x86_64)",
                        "--disable-dev-shm-usage");
                firefoxDriver = new FirefoxDriver(firefoxOptions);
                browser = firefoxDriver;
                setBrowserInstance(browser);
        }
    }

    protected void quitBrowser(){
        browser.quit();
    }

}
