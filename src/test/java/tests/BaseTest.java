package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import utils.ConfigReader;
import utils.DriverFactory;

public class BaseTest {
    protected WebDriver driver;

    @BeforeClass
    public void setup() {
        String env = System.getProperty("env", "staging");
        ConfigReader.loadConfig(env);

        driver = new ChromeDriver();
        DriverFactory.setDriver(driver);
        driver.manage().window().maximize();
        driver.get(ConfigReader.get("app.url"));
    }

    @AfterClass
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
