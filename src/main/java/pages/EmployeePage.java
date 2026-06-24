package pages;

import base.BasePage;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.Select;
import utils.WaitUtils;

public class EmployeePage extends BasePage {

    public EmployeePage(WebDriver driver) {
        super(driver);
    }

    // 🔥 Improved locators (less brittle)
    private By addEmployeeButton =
            By.xpath("//a[contains(text(),'Add')]");

    private By nameField =
            By.xpath("//input[@name='name']");

    private By emailField =
            By.xpath("//input[@name='email']");

    private By departmentField =
            By.xpath("//input[@name='department']");

    private By statusDropdown =
            By.xpath("//select[@name='status']");

    private By saveButton =
            By.xpath("//button[@type='submit']");

    private By editButton =
            By.xpath("//table/tbody/tr[1]//a[contains(text(),'Edit')]");

    private By searchField =
            By.xpath("//input[contains(@placeholder,'Search')]");

    // ---------------------------
    // BASIC ACTIONS
    // ---------------------------

    public void clickAddEmployee() {

        WaitUtils.waitForOverlayToDisappear(driver);

        click(addEmployeeButton);
    }

    public void clickEditFirstEmployee() {
        click(editButton);
    }

    // ---------------------------
    // ADD EMPLOYEE
    // ---------------------------

    public void addEmployee(String name,
                            String email,
                            String department,
                            String status) {

        type(nameField, name);
        type(emailField, email);
        type(departmentField, department);

        Select select = new Select(
                waitUtils.waitForElementVisible(statusDropdown)
        );
        select.selectByVisibleText(status);

        click(saveButton);

        // 🔥 stability wait (Angular update)
        waitUtils.waitForElementVisible(
                By.xpath("//*[contains(text(),'" + name + "')]")
        );
    }

    // ---------------------------
    // UPDATE EMPLOYEE (FIXED)
    // ---------------------------

    public void updateEmployee(String name,
                               String email,
                               String department,
                               String status) {

        // 🔥 WAIT + TYPE (no direct driver calls)
        WebElement nameInput = waitUtils.waitForElementVisible(nameField);
        nameInput.clear();
        nameInput.sendKeys(name);

        WebElement emailInput = waitUtils.waitForElementVisible(emailField);
        emailInput.clear();
        emailInput.sendKeys(email);

        WebElement deptInput = waitUtils.waitForElementVisible(departmentField);
        deptInput.clear();
        deptInput.sendKeys(department);

        Select select = new Select(
                waitUtils.waitForElementVisible(statusDropdown)
        );
        select.selectByVisibleText(status);

        // 🔥 WAIT until button clickable (fix your failure)
        waitUtils.waitForElementClickable(saveButton).click();

        // 🔥 IMPORTANT: wait for UI refresh
        waitUtils.waitForElementVisible(
                By.xpath("//*[contains(text(),'" + name + "')]")
        );
    }

    // ---------------------------
    // SEARCH
    // ---------------------------

    public void searchEmployee(String employeeName) {

        WebElement search = waitUtils.waitForElementVisible(searchField);
        search.clear();
        search.sendKeys(employeeName);
    }

    // ---------------------------
    // DELETE
    // ---------------------------

    public void deleteFirstEmployee() {

        click(By.xpath("//table/tbody/tr[1]//button[contains(text(),'Delete')]"));

        driver.switchTo().alert().accept();
    }

    public void clickDeleteByName(String employeeName) {

        By deleteBtn = By.xpath(
                "//tr[td[contains(text(),'" + employeeName + "')]]//button[contains(text(),'Delete')]"
        );

        click(deleteBtn);

        driver.switchTo().alert().accept();
    }

    // ---------------------------
    // VALIDATION
    // ---------------------------

    public boolean employeeExists(String employeeName) {

        return driver.findElements(
                By.xpath("//tr[td[contains(text(),'" + employeeName + "')]]")
        ).size() > 0;
    }

    public boolean employeeExistsInTable(String employeeName) {

        return employeeExists(employeeName);
    }

    public int getEmployeeRowCount() {

        return driver.findElements(By.xpath("//table/tbody/tr")).size();
    }
}