package listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utils.DriverManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class TestListener implements ITestListener {
    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverManager.getDriver();
        if (driver != null) {
            TakesScreenshot ts = (TakesScreenshot) driver;
            File src = ts.getScreenshotAs(OutputType.FILE);

            String screenshotDir = "./screenshots/";
            String screenshotName = result.getMethod().getMethodName() + ".png";

            try {
                Files.createDirectories(Paths.get(screenshotDir));
                Files.copy(src.toPath(), Paths.get(screenshotDir + screenshotName));
                System.out.println("Screenshot saved: " + screenshotDir + screenshotName);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
