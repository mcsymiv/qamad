package com.qamad.steps;

import com.qamad.core.DriverFactory;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Hooks {

    private static final Logger log = LogManager.getLogger(Hooks.class.getName());

    @Before
    public void setup(Scenario scenario) {
        log.info("START Scenario: " + scenario.getName());
        if (isUiTestCase(scenario)) {
            log.info("You are using: " + System.getProperty("os.name"));
            DriverFactory.init();
        }
    }

    @After
    public void teardown(Scenario scenario) {
        log.info("END Scenario: " + scenario.getName());
        if (isUiTestCase(scenario)) {
            DriverFactory.close();
        }
    }

    private boolean isUiTestCase(Scenario scenario) {
        return scenario.getSourceTagNames()
                .stream()
                .noneMatch(tag -> tag.contains("@api"));
    }
}
