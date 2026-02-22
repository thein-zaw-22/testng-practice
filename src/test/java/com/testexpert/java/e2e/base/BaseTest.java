package com.testexpert.java.e2e.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;

/**
 * Base test class for E2E tests
 * Handles WebDriver initialization and teardown
 */
public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;
    protected static final String BASE_URL = "https://www.saucedemo.com";
    protected static final Duration TIMEOUT = Duration.ofSeconds(15);
    protected static final Duration EXPLICIT_WAIT = Duration.ofSeconds(20);

    @BeforeTest
    public void setUp() {
        initializeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(TIMEOUT);
        driver.manage().timeouts().pageLoadTimeout(TIMEOUT);
        wait = new WebDriverWait(driver, EXPLICIT_WAIT);
        System.out.println("WebDriver initialized successfully with explicit waits");
    }

    @AfterTest
    public void tearDown() {
        if (driver != null) {
            driver.quit();
            System.out.println("WebDriver closed successfully");
        }
    }

    /**
     * IChromeOptions options = new ChromeOptions();
     * // Uncomment next line for headless mode
     * // options.addArguments("--headless");
     * options.addArguments("--no-sandbox");
     * options.addArguments("--disable-dev-shm-usage");
     * options.addArguments("--disable-extensions");
     * driver = new ChromeDriver(options
     * Uses WebDriverManager for automatic driver management
     */
    private void initializeDriver() {
        WebDriverManager.chromedriver().setup();
        org.openqa.selenium.chrome.ChromeOptions options = new org.openqa.selenium.chrome.ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-extensions");
        driver = new ChromeDriver(options);
    }

    /**
     * Alternative method to initialize Firefox WebDriver
     */
    protected void initializeFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
    }

    /**
     * Navigate to the base URL
     */
    protected void navigateToBaseUrl() {
        driver.navigate().to(BASE_URL);
        System.out.println("Navigated to: " + BASE_URL);
    }
}
