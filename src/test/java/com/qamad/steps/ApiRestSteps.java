package com.qamad.steps;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qamad.api.Starship;
import com.qamad.config.PropertiesConfig;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;
import org.junit.Assert;

import java.io.IOException;

public class ApiRestSteps extends BaseSteps {
    private Response response;
    private String baseUrl = PropertiesConfig.getProperty("swap.baseUrl");

    @Given("^I send GET request to (.*) endpoint with (\\d+) value$")
    public void iSendGETRequestToEndpointWithValue(String path, int value) {
        log.info("I send GET request to " + path + " endpoint with " + value);
        response = RestAssured.given()
                .baseUri(baseUrl)
                .get(path);
    }

    @Then("^I check that response is returned with (\\d+) status code$")
    public void iCheckThatResponseIsReturnedWithStatusCode(int statusCode) {
        log.info("I check that response is returned with " + statusCode + " status code");
        Assert.assertEquals("Invalid status code",
                statusCode,
                response.getStatusCode());
    }

    @Then("^I check that response body contains (.*) field with (.*) value$")
    public void iCheckThatResponseBodyContainsFieldWithValue(String field, String value) throws IOException {
        log.info("I check that response body contains " + field + " field with " + value + " value");
        Starship starship = mapper.readValue(response.asString(), Starship.class);

        Assert.assertEquals("Invalid " + field + " field value",
                value,
                starship.getName());
    }
}
