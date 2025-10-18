package tests;

import base.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ConfigReader;

public class LoginTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys(ConfigReader.get("app.username"));
        driver.findElement(By.id("password")).sendKeys(ConfigReader.get("app.password"));
        driver.findElement(By.id("login-button")).click();

        // verifikasi login berhasil (harus ke halaman inventory)
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains("inventory.html"), "Login gagal, halaman tidak sesuai");
    }
}
