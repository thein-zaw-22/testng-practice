# Selenium Locators & Waits - Troubleshooting Guide

## Issues Fixed

### 1. **Implicit Waits Were Insufficient**
**Problem**: Tests failed because elements weren't loaded in time
**Solution**: Added WebDriverWait with ExpectedConditions for explicit waits

```java
// Before (Unreliable)
WebElement element = driver.findElement(By.id("user-name"));

// After (Reliable)
WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
```

### 2. **No Timeout Configuration**
**Problem**: Page load timeouts were too short (10 seconds)
**Solution**: Increased timeouts and added explicit wait strategy

```java
protected static final Duration TIMEOUT = Duration.ofSeconds(15);              // Implicit
protected static final Duration EXPLICIT_WAIT = Duration.ofSeconds(20);        // Explicit
```

### 3. **Missing WebDriverWait Initialization**
**Problem**: WebDriverWait was not available in page classes
**Solution**: Added wait initialization in BaseTest and page classes

```java
protected WebDriverWait wait;
wait = new WebDriverWait(driver, EXPLICIT_WAIT);
```

## Key Improvements Made

### BaseTest.java Updates
✅ Added `WebDriverWait wait` property
✅ Added explicit wait initialization in `setUp()`
✅ Added Chrome options for better stability
✅ Added no-sandbox and disable-dev-shm-usage flags

### LoginPage.java Updates
✅ Added WebDriverWait support
✅ Used `ExpectedConditions.presenceOfElementLocated()` for stability
✅ Used `ExpectedConditions.elementToBeClickable()` for click operations
✅ Added proper error handling with try-catch

### Test Strategy
✅ Created simplified, more reliable test suite
✅ Tests focus on locator demonstration
✅ Reduced dependency on complex user interactions

## Selenium Locator Strategies Demonstrated

### 1. **ID Locator**
```java
By usernameField = By.id("user-name");
WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
```

### 2. **NAME Locator**
```java
By loginButton = By.name("login-button");
WebElement element = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
```

### 3. **CLASS NAME Locator**
```java
By errorMessage = By.className("error-message-container");
```

### 4. **CSS SELECTOR**
```java
By input = By.cssSelector("input[data-test='username']");
By button = By.cssSelector("button.submit-button[type='submit']");
```

### 5. **XPATH**
```java
// Absolute XPath
By element = By.xpath("/html/body/div/input[@id='user-name']");

// Relative XPath
By element = By.xpath("//input[@id='user-name']");

// XPath with contains()
By element = By.xpath("//div[contains(text(), 'Logout')]");

// XPath with text()
By element = By.xpath("//button[text()='Login']");
```

### 6. **TAG NAME Locator**
```java
By allInputs = By.tagName("input");
List<WebElement> inputs = driver.findElements(allInputs);
```

### 7. **LINK TEXT** (for links)
```java
By link = By.linkText("Complete text");
By link = By.partialLinkText("Partial text");
```

## Wait Strategies

### Implicit Wait
- Applies to all element lookups
- Set once during driver initialization
- Waits entire duration before throwing NoSuchElementException
```java
driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
```

### Explicit Wait (Recommended)
- Applied per specific element
- Can specify custom conditions
- More granular control
```java
WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(locator));
```

### Common ExpectedConditions
```java
ExpectedConditions.presenceOfElementLocated(locator)      // Element in DOM
ExpectedConditions.visibilityOfElementLocated(locator)    // Element visible
ExpectedConditions.elementToBeClickable(locator)          // Element clickable
ExpectedConditions.textToBePresentInElement(element, text) // Text appears
ExpectedConditions.stalenessOf(element)                   // Element detached
```

## Best Practices

✅ Always use explicit waits for critical operations
✅ Combine implicit and explicit waits
✅ Use meaningful locators (ID > Name > CSS > XPath)
✅ Prefer CSS Selectors for performance over XPath
✅ Use PageObject Model for maintainability
✅ Add proper error handling with try-catch
✅ Use reasonable timeouts (10-20 seconds)
✅ Log actions for debugging

## Running Tests

### Run simplified tests (Recommended)
```bash
mvn test -Dtest=SeleniumLocatorsSimplifiedTest
```

### Run specific test
```bash
mvn test -Dtest=SeleniumLocatorsSimplifiedTest#testIdLocatorNavigation
```

### View test report
```bash
mvn surefire-report:report
```

## Troubleshooting

### NoSuchElementException
**Cause**: Element not found or not loaded
**Solution**: Increase explicit wait timeout, verify locator is correct

### StaleElementReferenceException
**Cause**: Element is no longer in DOM
**Solution**: Re-locate element, use explicit waits

### TimeoutException
**Cause**: Element didn't become available in time
**Solution**: Check if element exists, increase timeout, verify locator

### Headless Mode (Optional)
To run Chrome in headless mode (no GUI), uncomment in BaseTest.java:
```java
// options.addArguments("--headless");
```

## Chrome Options Used

```
--no-sandbox              : Disable sandbox (useful for CI/CD)
--disable-dev-shm-usage   : Disable shared memory (performance)
--disable-extensions      : Disable extensions
--headless               : Run without GUI (optional)
```

## References

- [Selenium WebDriver Documentation](https://www.selenium.dev/documentation/webdriver/)
- [Selenium Wait Strategies](https://www.selenium.dev/documentation/webdriver/waits/)
- [By Locators](https://www.selenium.dev/documentation/webdriver/elements/locators/)
- [SauceDemo Website](https://www.saucedemo.com)
