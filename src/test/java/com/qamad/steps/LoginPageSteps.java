package com.qamad.steps;

import com.qamad.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class LoginPageSteps extends BaseSteps {

    @When("^I open Login Page$")
    public void iOpenLoginPage() {
        log.info("I open Login page");
        loginPage.open();
    }

    @And("^I enter \"(.*)\" username$")
    public void iEnterUsername(String username) {
        log.info("I enter " + username + " username");
        loginPage.enterUserName(username);
    }

    @And("^I enter \"(.*)\" password$")
    public void iEnterPassword(String password) {
        log.info("I enter " + password + " password");
        loginPage.enterPassword(password);
    }

    @And("^I click on login button on Login Page$")
    public void iClickOnLoginButtonOnLoginPage() {
        log.info("I click on login button on Login Page");
        loginPage.clickLoginButton();
    }

    @Then("^I see Login Page$")
    public void iSeeLoginPage() {
        log.info("I see Login Page");
        Assert.assertTrue(loginPage.isLoginPage());
    }

    @Then("^I see elements are present on Login Page$")
    public void iSeeElementsArePresentOnLoginPage() {
        log.info("I see elements are present on Login Page");
        for (WebElement element : loginPage.getAllElements()) {
            Assert.assertTrue(element.isDisplayed());
        }
    }
}
