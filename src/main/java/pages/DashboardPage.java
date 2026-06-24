package pages;

import base.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import utils.WaitUtils;

public class DashboardPage extends BasePage {

    public DashboardPage(WebDriver driver) {
        super(driver);
    }

    private By logoutButton =
            By.xpath("//button[contains(.,'Logout')]");
    public void logout() {

        waitForToastToDisappear(driver);

        waitUtils.waitForElementClickable(logoutButton);

        try {
            click(logoutButton);
        } catch (ElementClickInterceptedException e) {

            waitForToastToDisappear(driver);

            click(logoutButton);
        }
    }
}