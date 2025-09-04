package tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.ConfigReader;
import utils.DriverManager;

public class BaseTest {

    @BeforeClass
    public void setup() {
        String env = System.getProperty("env", "staging");
        ConfigReader.loadProperties(env);
        System.out.println("Running tests on environment: " + env);
        System.out.println("Base URL: " + ConfigReader.getProperty("app.url"));
        DriverManager.getDriver().get(ConfigReader.getProperty("app.url"));
    }

    @AfterClass
    public void teardown() {
        DriverManager.quitDriver();
    }
}

