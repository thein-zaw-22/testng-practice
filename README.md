# TestNG Practice Project

A comprehensive Maven-based TestNG project with Selenium WebDriver for E2E testing. Configured for JDK 25 with the latest dependencies.

## Project Structure

```
testng-practice/
├── pom.xml                              # Maven configuration
├── testng.xml                           # TestNG suite configuration
├── .vscode/                             # VS Code settings
├── src/
│   ├── main/
│   │   └── java/                        # Main source code
│   └── test/
│       ├── java/
│       │   └── com/testng/practice/
│       │       ├── SampleTest.java      # Sample unit tests
│       │       └── e2e/
│       │           ├── base/
│       │           │   └── BaseTest.java          # WebDriver setup/teardown
│       │           ├── pages/
│       │           │   ├── LoginPage.java        # Login page object (all locators)
│       │           │   └── ProductsPage.java     # Products page object
│       │           └── SeleniumLocatorsTest.java # E2E test cases
│       └── resources/
│           └── selenium.properties     # Selenium configuration
├── config/                              # Configuration files
├── docs/                                # Documentation
└── README.md                            # This file
```

## Configuration

### JDK Version
- **Source**: Java 25
- **Target**: Java 25

### Dependencies
- **TestNG**: 7.10.2 (latest)
- **Selenium WebDriver**: 4.25.0 (latest)
- **WebDriver Manager**: 5.9.1 (automatic driver management)
- **SLF4J**: 2.0.12
- **Allure TestNG**: 2.25.0 (test reporting with listener)
- **AspectJ Weaver**: 1.9.22 (Allure instrumentation)
- **Maven Surefire Plugin**: 3.2.5 (test execution + Allure listener)

## Running Tests

### Run all tests (unit + E2E)
```bash
mvn test
```

### Run only unit tests
```bash
mvn test -Dtest=SampleTest
```

### Run only E2E Selenium tests
```bash
mvn test -Dtest=SeleniumLocatorsSimplifiedTest
```

### Run specific test method
```bash
mvn test -Dtest=SeleniumLocatorsSimplifiedTest#testIdLocatorNavigation
```

### Run and Generate Surefire Report
```bash
mvn clean test && mvn surefire-report:report
```

### Run and Generate Allure Report
```bash
# Step 1: Run tests (generates allure-results)
mvn clean test

# Step 2: Generate Allure HTML report
allure generate target/allure-results -o target/allure-report --clean

# Step 3: View report in browser
allure open target/allure-report

# Or do it all in one command:
mvn clean test && allure generate target/allure-results -o target/allure-report --clean && allure open target/allure-report
```

### Generate All Reports (Surefire + Allure)
```bash
mvn clean test && mvn surefire-report:report && allure generate target/allure-results -o target/allure-report --clean
```

### Clean build
```bash
mvn clean
```

### Full build and test
```bash
mvn clean install
```

## Selenium E2E Tests

### Overview
Comprehensive E2E test suite demonstrating all Selenium locator strategies using SauceDemo (https://www.saucedemo.com).

### Test Website
- **URL**: https://www.saucedemo.com
- **Purpose**: Public demo website designed for automation testing
- **Test Username**: `standard_user`
- **Test Password**: `secret_sauce`

### All Locator Strategies Demonstrated

1. **ID Locator** - `By.id()` - Find elements by HTML id attribute
   - Used for: username field, password field
   
2. **NAME Locator** - `By.name()` - Find elements by HTML name attribute
   - Used for: login button
   
3. **CLASS NAME Locator** - `By.className()` - Find elements by CSS class
   - Used for: error messages, product containers
   
4. **CSS SELECTOR** - `By.cssSelector()` - CSS selector expressions
   - Used for: attribute selectors, complex selectors
   - Example: `input[data-test='username']`, `button.submit-button`
   
5. **XPATH** - `By.xpath()` - XML path expressions
   - Absolute XPath: `/html/body/div/input`
   - Relative XPath: `//input[@id='username']`
   - Used for: complex element selection
   
6. **TAG NAME Locator** - `By.tagName()` - Find elements by HTML tag
   - Used for: all input fields, all links
   
7. **XPATH contains()** - Dynamic XPATH with text matching
   - Used for: finding products by partial name
   - Example: `//div[contains(text(), 'Backpack')]`
   
8. **Attribute Selectors** - CSS selectors with attributes
   - Used for: data attributes, type attributes

### Test Cases Included

**TC001**: ID Locator - Login with valid credentials  
**TC002**: NAME Locator - Reset and retry login  
**TC003**: CSS SELECTOR - Step by step login  
**TC004**: XPATH - Complete login workflow  
**TC005**: TAG NAME - Count input fields  
**TC006**: CLASS NAME - Get error message on invalid login  
**TC007**: XPATH contains() - Find products with dynamic XPATH  
**TC008**: CSS SELECTOR with attributes - Add product to cart  
**TC009**: ID Locator - Sort products  
**TC010**: TAG NAME - Get all links and count  
**TC011**: XPATH Multiple Elements - Get all product titles  

### Page Object Model (POM)

The tests use the Page Object Model design pattern:

- **BaseTest.java** - Base class with WebDriver initialization/cleanup
- **LoginPage.java** - All login page interactions and locators
- **ProductsPage.java** - All products page interactions and locators

Each page class demonstrates different locator strategies and best practices.

### WebDriver Management

- **Automatic Driver Management**: WebDriver Manager handles automatic Chrome/Firefox driver downloads
- **Implicit Waits**: Default 10-second implicit wait
- **Page Load Timeout**: 10 seconds
- **Window Maximization**: Browser window maximized on startup

## TestNG Features Demonstrated

### Unit Tests (SampleTest.java)
The `SampleTest.java` class demonstrates the following TestNG annotations:

- `@BeforeSuite` - Runs once before all tests in the suite
- `@BeforeTest` - Runs before each test tag
- `@BeforeClass` - Runs before the first test method of the class
- `@BeforeMethod` - Runs before each test method
- `@Test` - Marks a method as a test method
- `@AfterMethod` - Runs after each test method
- `@AfterClass` - Runs after the last test method of the class
- `@AfterTest` - Runs after each test tag
- `@AfterSuite` - Runs once after all tests in the suite

### E2E Tests
E2E tests demonstrate:
- WebDriver initialization and management
- Page Object Model pattern
- Multiple locator strategies
- Wait mechanisms
- Assertion validations
- Test reporting

## IDE Integration

### IntelliJ IDEA
- Open the project folder
- IntelliJ will automatically detect the Maven project
- Run tests using the green run button or right-click context menu
- IDEA has built-in TestNG support

### Visual Studio Code
- Install the Extension Pack for Java
- Install Extension: "TestNG Runner"
- Right-click on test class or testng.xml to run
- Use Testing sidebar for test execution

## Browser Drivers

The project uses **WebDriver Manager** to automatically download and manage browser drivers:

```bash
# Chrome driver - automatically downloaded on first run
# Firefox driver - automatically downloaded on first run
```

No need to manually download or manage driver binaries!

## VS Code Configuration

VS Code is configured with Maven and Java paths in `.vscode/settings.json`:
- Proper source paths
- Output directory configuration
- IDE metadata exclusions

## Selenium Configuration

Edit `src/test/resources/selenium.properties` to configure:
- Browser type (chrome/firefox)
- Headless mode
- Implicit/explicit waits
- Base URL
- Test credentials
- Screenshot settings

## Maven Plugins

- **Maven Compiler Plugin** (3.13.0) - Java 25 compilation
- **Maven Surefire Plugin** (3.2.5) - Test execution with Allure listener
- **Maven Failsafe Plugin** (3.2.5) - Integration tests
- **Maven JAR Plugin** (3.4.2) - JAR creation
- **Maven Clean Plugin** (3.3.2) - Clean build artifacts

## Test Reporting

### Surefire Report (HTML)
Generated automatically after test execution in `target/surefire-reports/`:
- **index.html** - Main test results summary
- **emailable-report.html** - CI/CD friendly email-ready report
- Suite-based test breakdowns with pass/fail statistics

View Surefire reports after running tests:
```bash
# Reports are auto-generated after test execution
# Open report in browser
open target/surefire-reports/index.html

# Or regenerate the report manually
mvn surefire-report:report
```

### Allure Report (Advanced Test Reporting)

Allure provides beautiful, interactive test reports with comprehensive insights into test execution.

#### Prerequisites
Install Allure CLI:
```bash
# macOS
brew install allure

# Other platforms
# Visit: https://docs.qameta.io/allure/#_installing_a_commandline
```

#### Workflow: Generate & View Allure Reports

**Step 1: Run Tests** (Allure listener is configured in testng.xml)
```bash
mvn clean test
```
This command automatically generates Allure results in `target/allure-results/` directory.

**Step 2: Generate Allure Report**
```bash
allure generate target/allure-results -o target/allure-report --clean
```

**Step 3: View Report in Browser**
```bash
# Option 1: Launch report in default browser
allure open target/allure-report

# Option 2: Open report file directly
open target/allure-report/index.html
```

#### One-Command Report Generation
```bash
# Run tests and generate report in one command
mvn clean test && allure generate target/allure-results -o target/allure-report --clean
```

#### Report Locations
- **Test Results**: `target/allure-results/` - Raw test data (JSON files)
- **HTML Report**: `target/allure-report/` - Interactive dashboard and reports

#### Allure Report Features

**📊 Overview Dashboard**
- Total tests count
- Pass/Fail/Skipped statistics
- Success rate percentage
- Test execution duration
- Test environment details

**⏱️ Test Timeline**
- Chronological test execution order
- Individual test duration
- Parallel execution visualization (if applicable)
- Step-by-step breakdown of test execution

**📋 Test Details**
- Click any test to view:
  - Full test name and description
  - Test duration in milliseconds
  - Step-by-step execution flow
  - Log messages and output
  - Test parameters
  - Associated categories and severity

**❌ Failures & Errors**
- Detailed failure information
- Exception messages and stack traces
- Step at which failure occurred
- Console logs leading to failure
- Video/screenshot attachments (when configured)

**🏷️ Categories & Severity**
- Filter tests by type (smoke, regression, etc.)
- Group by severity (blocker, critical, minor, etc.)
- Custom category organization

**📈 History & Trends**
- Test execution history across runs
- Pass/Fail rate trends
- Performance metrics over time
- Flaky test detection
- Test stability analysis

**🔄 Test Retries**
- Track retried tests
- Retry success rate
- Flakiness detection

**⚙️ Test Environment**
- Browser and driver information
- OS and JDK version
- Execution time and date
- Agent and attachment details

#### Viewing Specific Aspects

**View only failed tests:**
- Click "Failures" tab in the report
- See detailed failure logs and stack traces

**View test timeline:**
- Click "Timeline" tab
- See execution order and duration of each test

**View test history:**
- Click "History" tab
- Compare results across multiple test runs

**Export test results:**
- Use "Export" button for CI/CD integration
- Available formats: JSON, CSV

#### Common Commands

```bash
# Generate report and auto-open in browser
allure open target/allure-results

# Generate report to custom location
allure generate target/allure-results -o reports/allure --clean

# Generate report with options
allure generate target/allure-results -o target/allure-report --clean --single-file

# Start Allure report server (runs on port 4040)
allure serve target/allure-results
```

#### CI/CD Integration

Allure reports integrate seamlessly with CI/CD pipelines:
```bash
# In your CI pipeline
mvn clean test
allure generate target/allure-results -o target/allure-report --clean

# Archive the report for viewing
# The target/allure-report/ folder is your final artifact
```

#### Troubleshooting Allure Reports

**No tests showing in report:**
- Verify `allure-results/` directory contains JSON files
- Ensure TestNG listener is configured in testng.xml
- Run: `mvn clean test` to regenerate results

**Report shows empty:**
- Delete existing `target/allure-results/` directory
- Run: `mvn clean test`
- Then: `allure generate target/allure-results -o target/allure-report --clean`

**Allure CLI not found:**
```bash
# Reinstall Allure
brew uninstall allure
brew install allure

# Verify installation
allure --version
```

````

## Best Practices Implemented

✅ Page Object Model pattern for maintainability  
✅ Separate base class for common setup/teardown  
✅ Explicit locators with multiple strategies  
✅ Proper WebDriver management  
✅ Wait mechanisms for reliability  
✅ Clear test names with descriptions  
✅ Allure TestNG reporting for detailed insights  
✅ Surefire HTML reports for CI/CD integration  
✅ Comprehensive test documentation  
✅ Console logging for debugging  
✅ Automatic driver download via WebDriver Manager  
✅ VS Code workspace configuration  
✅ Maven configuration best practices
✅ AspectJ weaver configured for Allure instrumentation

## Notes

- TestNG suite configured in `testng.xml`
- Logging configured using SLF4J Simple binding
- All test outputs printed to console
- WebDriver automatically manages browser instances
- Tests use stable public demo website (SauceDemo)
- Compatible with CI/CD pipelines via Maven
