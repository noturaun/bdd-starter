package setups;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.ByteArrayInputStream;

public class Hook extends BrowserSetup{
    @Before
    public void before() throws Exception {
        startBrowser();
    }


    @Attachment(value = "Screenshot", type = "image/png")
    public byte[] saveScreenshot(byte[] screenshot){
        return  screenshot;
    }

    @After
    public void after(Scenario scenario) {
        if (scenario.isFailed()){
            Allure.addAttachment(scenario.getName(), new ByteArrayInputStream(((TakesScreenshot)browser).getScreenshotAs(OutputType.BYTES)));
        }
        quitBrowser();
    }
}
