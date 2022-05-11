package com.qamad.steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class MainPageSteps extends BaseSteps {

    @Then("^I see Main Page$")
    public void iSeeMainPage() {
        log.info("I see Main Page");
        for (WebElement link : mainPage.getAccountLinks()) {
            Assert.assertTrue("Element " + link.getText() + " is not preset on the page",
                    link.isDisplayed());
        }
    }
}
