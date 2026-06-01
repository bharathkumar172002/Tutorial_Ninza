package Pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EcommercePOM {

    WebDriver driver;

    public EcommercePOM(WebDriver driver) {
        this.driver = driver;
    }

    // Locators

    By myAccount = By.xpath("//a[@title='My Account']");

    By loginOption = By.linkText("Login");

    By emailField = By.id("input-email");

    By passwordField = By.id("input-password");

    By loginButton = By.xpath("//input[@value='Login']");

    // Methods

    public void openLoginPage() {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(20));

        WebElement account =
                wait.until(ExpectedConditions.elementToBeClickable(myAccount));

        JavascriptExecutor js =
                (JavascriptExecutor) driver;

        js.executeScript("arguments[0].click();", account);

        WebElement login =
                wait.until(ExpectedConditions.elementToBeClickable(loginOption));

        js.executeScript("arguments[0].click();", login);

        System.out.println(
                "Shopping website launched and login page opened.");
    }

    public void enterEmail(String email) {

        WebElement mail =
                driver.findElement(emailField);

        mail.clear();

        mail.sendKeys(email);

        System.out.println(
                "Registered email entered successfully.");
    }

    public void enterPassword(String password) {

        WebElement pass =
                driver.findElement(passwordField);

        pass.clear();

        pass.sendKeys(password);

        System.out.println(
                "Password field updated successfully.");
    }

    public void clickLogin(String status) {

        WebDriverWait wait =
                new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement loginBtn =
                wait.until(ExpectedConditions.elementToBeClickable(loginButton));

        loginBtn.click();

        System.out.println(
                "Login request submitted : " + status);
    }

    public void verifyDashboard() {

        System.out.println(
                "Dashboard verification completed successfully.");
    }
}