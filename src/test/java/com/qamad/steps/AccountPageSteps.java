package com.qamad.steps;

import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class AccountPageSteps extends BaseSteps {

    @Then("^I see Account Page$")
    public void iSeeAccountPage() {
        log.info("I see Account Page");
        for (WebElement link : accountPage.getAccountLinks()) {
            Assert.assertTrue("Element " + link.getText() + " is not preset on the page",
                    link.isDisplayed());
        }
    }
}
