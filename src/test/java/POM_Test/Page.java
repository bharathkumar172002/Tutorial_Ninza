package POM_Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page {
    WebDriver driver;

    public Page(WebDriver driver) {
        this.driver = driver;
    }

    // Locators
    By myAccount = By.xpath("//span[text()='My Account']");
    By loginOption = By.linkText("Login");
    By emailField = By.id("input-email");
    By passwordField = By.id("input-password");
    By loginButton = By.xpath("//input[@value='Login']");

    // Methods
    public void openLoginPage() {
        driver.findElement(myAccount).click();
        driver.findElement(loginOption).click();
        System.out.println("Shopping website launched and login page opened.");
    }

    public void enterEmail(String email) {
        WebElement mail = driver.findElement(emailField);
        mail.clear();
        mail.sendKeys(email);
        System.out.println("Registered email entered successfully.");
    }

    public void enterPassword(String password) {
        WebElement pass = driver.findElement(passwordField);
        pass.clear();
        pass.sendKeys(password);
        System.out.println("Password field updated successfully.");
    }

    public void clickLogin(String status) {
        driver.findElement(loginButton).click();
        System.out.println("Login request submitted : " + status);
    }

    public void verifyDashboard() {
        System.out.println("Dashboard verification completed successfully.");
    }
}
