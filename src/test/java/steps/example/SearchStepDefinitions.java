package steps.example;


import io.cucumber.java.en.*;
import pages.GooglePage;

import java.time.Duration;

import static org.assertj.core.api.Assertions.*;
import static setups.BrowserInstance.getBrowserInstance;
import static setups.BrowserInstance.getWait;

public class SearchStepDefinitions {

    GooglePage browser = new GooglePage(getBrowserInstance());

    @Given("User already on Google search page")
    public void user_already_on_google_search_page() {
        browser.loadPage();
    }
    @When("{string} enters the {string}")
    public void enters_the(String user, String keyword) {
        browser.inputKeyword(keyword);
    }
    @Then("s?he should be redirected to the result page for that {string} or {string}")
    public void s_he_should_be_redirected_to_the_result_page_for_that_or(String expected, String alt) {
        assertThat(browser.resultLink(expected, alt)).containsAnyOf(expected, alt);
    }
}
