package com.qamad.steps;

import cucumber.api.java.en.Then;

public class MainPageSteps extends BaseSteps {

    @Then("^I see Main Page$")
    public void iSeeMainPage() {
        log.info("I see Main Page");
        mainPage.isMainPage();
    }
}
