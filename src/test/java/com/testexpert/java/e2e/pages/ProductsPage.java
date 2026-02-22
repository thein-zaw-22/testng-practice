package com.testexpert.java.e2e.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

/**
 * Page Object Model class for Products Page
 * Demonstrates advanced Selenium locators and interactions
 */
public class ProductsPage {

    private WebDriver driver;

    // Product locators using different strategies
    // XPATH: Finding products by various patterns
    private By productTitles = By.xpath("//div[@class='inventory_item_name ']");
    private By productPrices = By.xpath("//div[@class='inventory_item_price']");
    private By addToCartButtons = By.xpath("//button[contains(@id, 'add-to-cart')]");

    // CSS SELECTOR: Finding cart button
    private By cartButton = By.cssSelector("a.shopping_cart_link");
    private By cartCount = By.cssSelector("span.shopping_cart_badge");

    // XPATH: Finding specific product
    private By firstProductAddBtn = By.xpath("(//button[contains(@id, 'add-to-cart')])[1]");

    // ID: Sort by dropdown
    private By sortDropdown = By.id("product_sort_container");

    // XPATH: Alternate way to find sort dropdown
    private By sortDropdownXpath = By.xpath("//select[@class='product_sort_container']");

    // CLASS NAME: Product items container
    private By productItems = By.className("inventory_item");

    // XPATH with contains: Finding logout button
    private By logoutButton = By.xpath("//a[contains(text(), 'Logout')]");

    // XPATH with text(): Finding menu button
    private By menuButton = By.xpath("//button[contains(@id, 'menu')]");

    // XPATH: Product with specific name
    private By sauceLabsBackpackProduct = By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]");

    public ProductsPage(WebDriver driver) {
        this.driver = driver;
    }

    /**
     * Demonstrate XPATH: Get all product titles
     */
    public List<WebElement> getAllProductTitles() {
        List<WebElement> titles = driver.findElements(productTitles);
        System.out.println("Found " + titles.size() + " products using XPATH locator");
        return titles;
    }

    /**
     * Demonstrate XPATH: Get all product prices
     */
    public List<String> getAllProductPrices() {
        List<WebElement> prices = driver.findElements(productPrices);
        System.out.println("Found " + prices.size() + " prices using XPATH locator");
        prices.forEach(price -> System.out.println("  Price: " + price.getText()));
        return prices.stream().map(WebElement::getText).toList();
    }

    /**
     * Demonstrate XPATH: Click first product add to cart button
     */
    public void addFirstProductToCart() {
        WebElement addBtn = driver.findElement(firstProductAddBtn);
        addBtn.click();
        System.out.println("Added first product to cart using XPATH locator");
    }

    /**
     * Demonstrate XPATH: Add product by name
     */
    public void addProductToCartByName(String productName) {
        String xpathExpression = "//div[contains(text(), '" + productName
                + "')]/ancestor::div[@class='inventory_item']//button";
        WebElement addBtn = driver.findElement(By.xpath(xpathExpression));
        addBtn.click();
        System.out.println("Added product '" + productName + "' to cart using dynamic XPATH");
    }

    /**
     * Demonstrate CSS SELECTOR: Click cart button
     */
    public void clickCartByCss() {
        WebElement cart = driver.findElement(cartButton);
        cart.click();
        System.out.println("Clicked cart button using CSS SELECTOR locator");
    }

    /**
     * Demonstrate CSS SELECTOR: Get cart count
     */
    public String getCartCountByCss() {
        try {
            WebElement count = driver.findElement(cartCount);
            String cartItems = count.getText();
            System.out.println("Cart count using CSS SELECTOR: " + cartItems);
            return cartItems;
        } catch (Exception e) {
            System.out.println("Cart is empty - no badge visible");
            return "0";
        }
    }

    /**
     * Demonstrate ID: Select sort option
     */
    public void sortProductsById(String sortOption) {
        WebElement sort = driver.findElement(sortDropdown);
        sort.click();
        // Select option by value
        WebElement option = driver.findElement(By.xpath("//option[@value='" + sortOption + "']"));
        option.click();
        System.out.println("Sorted products using ID locator with option: " + sortOption);
    }

    /**
     * Demonstrate CLASS NAME: Count products
     */
    public int getProductCountByClassName() {
        List<WebElement> items = driver.findElements(productItems);
        System.out.println("Found " + items.size() + " product items using CLASS NAME locator");
        return items.size();
    }

    /**
     * Demonstrate XPATH with contains: Click logout
     */
    public void logoutUsingXpath() {
        try {
            // First click menu
            WebElement menu = driver.findElement(menuButton);
            menu.click();
            Thread.sleep(500); // Small wait for menu to appear

            // Then click logout
            WebElement logout = driver.findElement(logoutButton);
            logout.click();
            System.out.println("Logged out using XPATH with contains locator");
        } catch (Exception e) {
            System.out.println("Logout not possible: " + e.getMessage());
        }
    }

    /**
     * Demonstrate XPATH: Find product by partial name
     */
    public boolean isProductVisibleByName(String productName) {
        try {
            WebElement product = driver.findElement(By.xpath("//div[contains(text(), '" + productName + "')]"));
            System.out.println("Product '" + productName + "' found using XPATH contains");
            return product.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Demonstrate TAG NAME: Get all links on page
     */
    public int getAllLinksCount() {
        List<WebElement> links = driver.findElements(By.tagName("a"));
        System.out.println("Found " + links.size() + " links using TAG NAME locator");
        return links.size();
    }

    /**
     * Get current page title
     */
    public String getPageTitle() {
        return driver.getTitle();
    }

    /**
     * Verify products page is loaded
     */
    public boolean isProductsPageLoaded() {
        try {
            List<WebElement> titles = driver.findElements(productTitles);
            return titles.size() > 0;
        } catch (Exception e) {
            return false;
        }
    }
}
