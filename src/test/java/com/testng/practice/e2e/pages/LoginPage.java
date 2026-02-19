package com.testng.practice.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

/**
 * Page Object Model class for Login Page
 * Demonstrates all types of Selenium locators with explicit waits
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;
    private static final Duration WAIT_TIMEOUT = Duration.ofSeconds(20);

    // Locators using different strategies
    // 1. ID Locator
    private By usernameFieldId = By.id("user-name");
    private By passwordFieldId = By.id("password");

    // 2. NAME Locator
    private By loginButtonName = By.name("login-button");

    // 3. CLASS NAME Locator
    private By errorMessageClass = By.className("error-message-container");

    // 4. CSS SELECTOR Locators
    private By usernameInputCss = By.cssSelector("input[data-test='username']");
    private By passwordInputCss = By.cssSelector("input[data-test='password']");
    private By loginButtonCss = By.cssSelector("input.submit-button[type='submit']");

    // 5. XPATH Locators
    private By usernameXpath = By.xpath("//input[@id='user-name']");
    private By passwordXpath = By.xpath("//input[@id='password']");
    private By loginButtonXpath = By.xpath("//input[@value='Login']");
    private By errorMessageXpath = By.xpath("//h3[@data-test='error']");

    // 6. LINK TEXT Locator (for navigation links)
    private By swagLabsLogoXpath = By.xpath("//div[@class='login_logo']");

    // 7. TAG NAME Locator
    private By allInputFields = By.tagName("input");

    // Page title element
    private By pageTitle = By.xpath("//div[@class='login_logo']");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, WAIT_TIMEOUT);
    }

    /**
     * Demonstrate ID locator: Finding username field
     */
    public void enterUsernameById(String username) {
        WebElement usernameField = driver.findElement(usernameFieldId);
        usernameField.clear();
        usernameField.sendKeys(username);
        System.out.println("Entered username using ID locator: " + username);
    }

    /**
     * Demonstrate ID locator: Finding password field
     */
    public void enterPasswordById(String password) {
        WebElement passwordField = driver.findElement(passwordFieldId);
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Entered password using ID locator");
    }

    /**
     * Demonstrate NAME locator: Click login button
     */
    public void clickLoginByName() {
        WebElement loginBtn = driver.findElement(loginButtonName);
        loginBtn.click();
        System.out.println("Clicked login button using NAME locator");
    }

    /**
     * Demonstrate CSS SELECTOR: Enter username
     */
    public void enterUsernameByCss(String username) {
        WebElement usernameField = driver.findElement(usernameInputCss);
        usernameField.clear();
        usernameField.sendKeys(username);
        System.out.println("Entered username using CSS SELECTOR locator: " + username);
    }

    /**
     * Demonstrate CSS SELECTOR: Enter password
     */
    public void enterPasswordByCss(String password) {
        WebElement passwordField = driver.findElement(passwordInputCss);
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Entered password using CSS SELECTOR locator");
    }

    /**
     * Demonstrate CSS SELECTOR: Click login
     */
    public void clickLoginByCss() {
        WebElement loginBtn = driver.findElement(loginButtonCss);
        loginBtn.click();
        System.out.println("Clicked login button using CSS SELECTOR locator");
    }

    /**
     * Demonstrate XPATH: Enter username
     */
    public void enterUsernameByXpath(String username) {
        WebElement usernameField = driver.findElement(usernameXpath);
        usernameField.clear();
        usernameField.sendKeys(username);
        System.out.println("Entered username using XPATH locator: " + username);
    }

    /**
     * Demonstrate XPATH: Enter password
     */
    public void enterPasswordByXpath(String password) {
        WebElement passwordField = driver.findElement(passwordXpath);
        passwordField.clear();
        passwordField.sendKeys(password);
        System.out.println("Entered password using XPATH locator");
    }

    /**
     * Demonstrate XPATH: Click login
     */
    public void clickLoginByXpath() {
        WebElement loginBtn = driver.findElement(loginButtonXpath);
        loginBtn.click();
        System.out.println("Clicked login button using XPATH locator");
    }

    /**
     * Demonstrate CLASS NAME: Get error message
     */
    public String getErrorMessageByClass() {
        try {
            WebElement errorElement = driver.findElement(errorMessageXpath);
            String errorMessage = errorElement.getText();
            System.out.println("Error message using CLASS NAME locator: " + errorMessage);
            return errorMessage;
        } catch (Exception e) {
            System.out.println("No error message found");
            return null;
        }
    }

    /**
     * Demonstrate TAG NAME: Get all input fields count
     */
    public int getInputFieldsCountByTagName() {
        int count = driver.findElements(allInputFields).size();
        System.out.println("Number of input fields using TAG NAME locator: " + count);
        return count;
    }

    /**
     * Verify login page is loaded using XPATH
     */
    public boolean isLoginPageLoaded() {
        try {
            WebElement title = driver.findElement(pageTitle);
            System.out.println("Login page verified using XPATH locator");
            return title.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Clear all fields
     */
    public void clearAllFields() {
        driver.findElement(usernameFieldId).clear();
        driver.findElement(passwordFieldId).clear();
        System.out.println("All fields cleared");
    }

    /**
     * Get current URL
     */
    public String getCurrentUrl() {
        return driver.getCurrentUrl();
    }

    /**
     * Get page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }
}
