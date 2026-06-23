package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private By emailField = By.xpath("//input[@type='email' or contains(@placeholder,'Email')]");
    private By passwordField = By.xpath("//input[@type='password' or contains(@placeholder,'Password')]");
    private By loginButton = By.cssSelector("button[type='submit']");

    public void login(String email, String password) {
        type(emailField, email);
        type(passwordField, password);
        click(loginButton);
    }
}