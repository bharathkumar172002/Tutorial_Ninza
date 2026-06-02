package Hooks;

import java.time.Duration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.cucumber.java.Before; // Cucumber ka annotation
import io.cucumber.java.After;  // Cucumber ka annotation

public class Hook {

    public static WebDriver driver;

    @Before // Yeh batayega ki har test scenario se pehle ye chalega
    public void setup() {
        // Docker Linux container me Chrome bina UI ke chalane ke liye options
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=new");          // Background me bina browser window ke chalega
        options.addArguments("--no-sandbox");             // Linux/Docker environment ke liye zaroori hai
        options.addArguments("--disable-dev-shm-usage");  // Memory/Resource crash se bachayega
        options.addArguments("--window-size=1920,1080");  // Screen size set karega taaki elements sahi se dhund sake

        // Options ke sath ChromeDriver ko initialize kiya
        driver = new ChromeDriver(options);

        // Baaki aapka original timeout aur URL setup
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://tutorialsninja.com/demo/");
    }

    @After // Yeh batayega ki har test scenario ke baad browser close hoga
    public void closes() {
        if (driver != null) {
            driver.quit();
            System.out.println("Browser session closed successfully.");
        }
    }
}