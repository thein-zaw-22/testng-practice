package com.testng.practice.e2e;

import com.testng.practice.e2e.base.BaseTest;
import com.testng.practice.e2e.pages.LoginPage;
import com.testng.practice.e2e.pages.ProductsPage;
import org.testng.annotations.*;
import static org.testng.Assert.*;

/**
 * E2E Test demonstrating all Selenium locator strategies
 * Uses SauceDemo website: https://www.saucedemo.com
 * 
 * Locaters Demonstrated:
 * 1. ID - By.id()
 * 2. NAME - By.name()
 * 3. CLASS NAME - By.className()
 * 4. CSS SELECTOR - By.cssSelector()
 * 5. XPATH - By.xpath()
 * 6. LINK TEXT - By.linkText() / By.partialLinkText()
 * 7. TAG NAME - By.tagName()
 * 8. CONTAINS - xpath contains()
 */
public class SeleniumLocatorsTest extends BaseTest {

    private LoginPage loginPage;
    private ProductsPage productsPage;

    // Test credentials for SauceDemo
    private static final String VALID_USERNAME = "standard_user";
    private static final String VALID_PASSWORD = "secret_sauce";
    private static final String INVALID_USERNAME = "invalid_user";
    private static final String INVALID_PASSWORD = "wrong_password";

    @BeforeTest
    @Override
    public void setUp() {
        super.setUp();
        navigateToBaseUrl();
        loginPage = new LoginPage(driver);
    }

    @Test(description = "TC001: Demonstrate ID Locator - Login with valid credentials")
    public void testLoginWithIdLocator() {
        System.out.println("\n=== Test: ID Locator Demo ===");
        assertTrue(loginPage.isLoginPageLoaded(), "Login page should be loaded");

        loginPage.enterUsernameById(VALID_USERNAME);
        loginPage.enterPasswordById(VALID_PASSWORD);
        loginPage.clickLoginByName(); // Using NAME locator for button

        // Wait for page load
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isProductsPageLoaded(), "Products page should be loaded after login");
        System.out.println("✓ ID Locator test passed");
    }

    @Test(description = "TC002: Demonstrate NAME Locator - Reset and retry login")
    public void testLoginWithNameLocator() {
        System.out.println("\n=== Test: NAME Locator Demo ===");
        navigateToBaseUrl();

        loginPage.enterUsernameById(VALID_USERNAME);
        loginPage.enterPasswordById(VALID_PASSWORD);
        // Using NAME locator to click login button
        loginPage.clickLoginByName();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isProductsPageLoaded(), "Products page should load");
        System.out.println("✓ NAME Locator test passed");
    }

    @Test(description = "TC003: Demonstrate CSS SELECTOR Locator - Step by step login")
    public void testLoginWithCssSelectorLocator() {
        System.out.println("\n=== Test: CSS SELECTOR Locator Demo ===");
        assertTrue(loginPage.isLoginPageLoaded(), "Login page should be loaded");

        // Using CSS SELECTOR for all fields
        loginPage.enterUsernameByCss(VALID_USERNAME);
        loginPage.enterPasswordByCss(VALID_PASSWORD);
        loginPage.clickLoginByCss();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isProductsPageLoaded(), "Products page should be loaded");
        System.out.println("✓ CSS SELECTOR Locator test passed");
    }

    @Test(description = "TC004: Demonstrate XPATH Locator - Complete login workflow")
    public void testLoginWithXpathLocator() {
        System.out.println("\n=== Test: XPATH Locator Demo ===");
        assertTrue(loginPage.isLoginPageLoaded(), "Login page should be loaded");

        // Using XPATH for all interactions
        loginPage.enterUsernameByXpath(VALID_USERNAME);
        loginPage.enterPasswordByXpath(VALID_PASSWORD);
        loginPage.clickLoginByXpath();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isProductsPageLoaded(), "Products page should be loaded");
        System.out.println("✓ XPATH Locator test passed");
    }

    @Test(description = "TC005: Demonstrate TAG NAME Locator - Count input fields")
    public void testTagNameLocator() {
        System.out.println("\n=== Test: TAG NAME Locator Demo ===");
        int inputCount = loginPage.getInputFieldsCountByTagName();
        assertTrue(inputCount >= 3, "Should have at least 3 input fields (username, password, login button)");
        System.out.println("✓ TAG NAME Locator test passed");
    }

    @Test(description = "TC006: Demonstrate CLASS NAME Locator - Get error message")
    public void testClassNameLocatorWithInvalidLogin() {
        System.out.println("\n=== Test: CLASS NAME Locator Demo ===");
        loginPage.clearAllFields();
        loginPage.enterUsernameById(INVALID_USERNAME);
        loginPage.enterPasswordById(INVALID_PASSWORD);
        loginPage.clickLoginByName();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String errorMessage = loginPage.getErrorMessageByClass();
        assertTrue(errorMessage != null && errorMessage.length() > 0, "Error message should be displayed");
        System.out.println("✓ CLASS NAME Locator test passed");
    }

    @Test(description = "TC007: Demonstrate XPATH contains() - Find products with dynamic XPATH")
    public void testXpathContains() {
        System.out.println("\n=== Test: XPATH contains() Demo ===");
        // Login first
        loginPage.enterUsernameById(VALID_USERNAME);
        loginPage.enterPasswordById(VALID_PASSWORD);
        loginPage.clickLoginByName();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isProductVisibleByName("Sauce Labs Backpack"),
                "Sauce Labs Backpack should be visible");
        System.out.println("✓ XPATH contains() test passed");
    }

    @Test(description = "TC008: Demonstrate CSS SELECTOR with attributes - Add product to cart")
    public void testCssSelectorWithAttributes() {
        System.out.println("\n=== Test: CSS SELECTOR with attributes Demo ===");
        // Login
        loginPage.enterUsernameById(VALID_USERNAME);
        loginPage.enterPasswordById(VALID_PASSWORD);
        loginPage.clickLoginByName();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isProductsPageLoaded(), "Products page should be loaded");

        // Add first product to cart using XPATH
        productsPage.addFirstProductToCart();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Verify cart updated using CSS SELECTOR
        String cartCount = productsPage.getCartCountByCss();
        assertEquals(cartCount, "1", "Cart should have 1 item");
        System.out.println("✓ CSS SELECTOR with attributes test passed");
    }

    @Test(description = "TC009: Demonstrate ID Locator - Sort products")
    public void testSortProductsById() {
        System.out.println("\n=== Test: Sort Products by ID Locator Demo ===");
        // Login
        loginPage.enterUsernameById(VALID_USERNAME);
        loginPage.enterPasswordById(VALID_PASSWORD);
        loginPage.clickLoginByName();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        productsPage = new ProductsPage(driver);
        assertTrue(productsPage.isProductsPageLoaded(), "Products page should be loaded");

        // Get product count
        int initialCount = productsPage.getProductCountByClassName();
        assertTrue(initialCount > 0, "Should have products visible");
        System.out.println("✓ Sort Products test passed");
    }

    @Test(description = "TC010: Demonstrate TAG NAME - Get all links and count")
    public void testTagNameForLinks() {
        System.out.println("\n=== Test: TAG NAME for Links Demo ===");
        // Login
        loginPage.enterUsernameById(VALID_USERNAME);
        loginPage.enterPasswordById(VALID_PASSWORD);
        loginPage.clickLoginByName();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        productsPage = new ProductsPage(driver);
        int linkCount = productsPage.getAllLinksCount();
        assertTrue(linkCount > 0, "Should have at least one link (cart)");
        System.out.println("✓ TAG NAME for Links test passed");
    }

    @Test(description = "TC011: Demonstrate XPATH with multiple products - Get all titles")
    public void testXpathMultipleElements() {
        System.out.println("\n=== Test: XPATH Multiple Elements Demo ===");
        // Login
        loginPage.enterUsernameById(VALID_USERNAME);
        loginPage.enterPasswordById(VALID_PASSWORD);
        loginPage.clickLoginByName();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        productsPage = new ProductsPage(driver);
        var titles = productsPage.getAllProductTitles();
        assertTrue(titles.size() > 0, "Should find product titles");
        System.out.println("Found products: ");
        titles.forEach(title -> System.out.println("  - " + title.getText()));
        System.out.println("✓ XPATH Multiple Elements test passed");
    }

    @AfterTest
    @Override
    public void tearDown() {
        super.tearDown();
    }
}
