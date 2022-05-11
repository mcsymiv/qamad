package com.qamad.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class NavigationTopPageSteps extends BaseSteps {

    @When("^I switch to (.*) language$")
    public void iSwitchToRuLanguage(String language) {
        log.info("I switch to " + language + " language");
        navigationTopPage.switchLanguageTo(language);
    }

    @Then("^I see \"(.*)\" error message$")
    public void iSeeErrorMessage(String errorMessage) {
        log.info("I see " + errorMessage + " error message");

        Assert.assertEquals("Invalid error message",
                errorMessage,
                navigationTopPage.getErrorMesageLogin().getText());
    }

}
