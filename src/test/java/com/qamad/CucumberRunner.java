package com.qamad;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/test/resources/features"},
        glue = {"com.qamad.steps"},
        plugin = {"pretty", "json:target/runner.json", "junit:target/junit.xml"})
public class CucumberRunner {
}
