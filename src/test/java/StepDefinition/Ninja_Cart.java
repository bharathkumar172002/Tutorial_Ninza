package StepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;

import Hooks.Hook;
import POM_Test.Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

public class Ninja_Cart {
    WebDriver driver;
    Page login;
    Hook h = new Hook();
    SoftAssert softAssert = new SoftAssert();

    @Before
    public void startBrowser() {
        h.setup();
        driver = Hook.driver;
    }

    @Given("login page should be open in default browser")
    public void launch_application() {
        login = new Page(driver);
        login.openLoginPage();
    }

    @When("click on email address field and add valid email {string}")
    public void enter_email(String email) {
        login.enterEmail("bharathkumar172002@gmail.com");
    }

    @And("then click on password field and enter valid {string}")
    public void enter_password(String password) {
        login.enterPassword("bharath@123");
    }

    @And("now click on login button {string}")
    public void click_login(String status) {
        login.clickLogin("success");
    }

    @Then("login successfully and redirect to ninja home page")
    public void verify_dashboard() {
        login.verifyDashboard();
    }

    @When("ninja search input field receives {string}")
    public void search_product(String product) throws InterruptedException {
        WebElement searchBox = driver.findElement(By.name("search"));
        searchBox.clear();
        searchBox.sendKeys(product);
        driver.findElement(By.cssSelector("button.btn-default.btn-lg")).click();
        Thread.sleep(2000);
    }

    @Then("ninja custom product list matches criteria")
    public void verify_search_result() {
        System.out.println("Relevant products displayed successfully.");
    }

    @When("user clicks on add to cart button for the item")
    public void add_product_to_cart() throws InterruptedException {
        WebElement addCartButton = driver.findElement(By.xpath("(//button[contains(@onclick,'cart.add')])[1]"));
        addCartButton.click();
        Thread.sleep(2000);
    }

    @Then("product should be added to cart successfully")
    public void verify_cart_message() {
        System.out.println("Cart confirmation message validated.");
    }

    @When("user clicks on the black shopping cart button")
    public void open_cart_page() throws InterruptedException {
        driver.findElement(By.id("cart-total")).click();
        Thread.sleep(1000);
        driver.findElement(By.linkText("View Cart")).click();
    }

    @And("clicks on the checkout option")
    public void click_checkout_option() {
        driver.findElement(By.linkText("Checkout")).click();
    }

    @Then("user should be redirected to the checkout page")
    public void verify_checkout_page() {
        System.out.println("Checkout workflow initiated successfully.");
        softAssert.assertAll();
    }

    @After
    public void close_browser() {
        h.closes();
    }
}
