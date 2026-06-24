package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.WaitUtils;

import java.time.Duration;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField =
            By.cssSelector("input[type='email']");

    private By passwordField =
            By.cssSelector("input[type='password']");

    private By loginButton =
            By.cssSelector("button[type='submit']");

    public void login(String email, String password) {

        WaitUtils.waitForOverlayToDisappear(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));

        // 🔥 ENSURE LOGIN PAGE IS ACTUALLY LOADED
        wait.until(d -> d.findElements(emailField).size() > 0);

        type(emailField, email);
        type(passwordField, password);

        click(loginButton);
    }
}
