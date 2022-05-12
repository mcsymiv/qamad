package com.qamad.core;

import com.qamad.config.PropertiesConfig;
import com.qamad.exception.InvalidOsNameException;
import com.qamad.types.DriverType;
import com.qamad.types.OsType;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static com.qamad.types.DriverType.CHROME;

public class DriverFactory {

    private static final Logger log = LogManager.getLogger(DriverFactory.class.getName());
    private static WebDriver driver;

    private static void createDriver(DriverType type, OsType osType) {
        String driverName = osType.equals(OsType.MAC) ? "chromedriver_m1" : "chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverName);

        if (type.equals(CHROME)) {
            driver = new ChromeDriver();
        } else {
            driver = new SafariDriver();
        }

        driver.manage().timeouts().implicitlyWait(4, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void init() {
        DriverType type = DriverType.valueOf(PropertiesConfig.getProperty("browser"));
        OsType os = defineOsType();

        if (os == null) {
            throw new InvalidOsNameException("No valid os name is provided");
        }

        createDriver(type, os);
    }

    private static OsType defineOsType() {
        String os = System.getProperty("os.name");
        log.debug("You are using: " + os);

        List<String> keys = Arrays.asList(os.toLowerCase().split(" "));

        if (keys.contains(OsType.MAC.name)) {
            return OsType.MAC;
        } else {
            return OsType.WIN;
        }
    }

    public static void close() {
        driver.quit();
    }
}
