package listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import utils.DriverFactory;

public class TestListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult result) {
        WebDriver driver = DriverFactory.getDriver(); // ambil WebDriver aktif
        if (driver != null) {
            String testName = result.getName();
            String screenshotPath = "./screenshots/" + testName + ".png";
            try {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.createDirectories(Paths.get("./screenshots/"));
                Files.copy(screenshot.toPath(), Paths.get(screenshotPath));
                System.out.println("Screenshot saved at: " + screenshotPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    // Method lainnya bisa di-override jika dibutuhkan
    @Override public void onTestStart(ITestResult result) {}
    @Override public void onTestSuccess(ITestResult result) {}
    @Override public void onTestSkipped(ITestResult result) {}
    @Override public void onStart(ITestContext context) {}
    @Override public void onFinish(ITestContext context) {}
}
