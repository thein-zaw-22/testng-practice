# TestNG Practice - Organized Project Structure

## Folder Organization

### Source Code (`src/main/`)
- **`java/com/testexpert/java/app/`** - Main application classes (Calculator, Services, etc.)
- **`java/com/testexpert/java/utils/`** - Utility and helper classes (StringUtils, etc.)
- **`resources/`** - Configuration files, properties, etc.

### Test Code (`src/test/`)
- **`java/com/testexpert/java/unit/`** - TestNG unit tests (test individual classes)
- **`java/com/testexpert/java/integration/`** - Integration tests (test component interactions)
- **`java/com/testexpert/java/junit/`** - JUnit 5 learning tests
- **`java/com/testexpert/java/utils/`** - Test helpers and assertions (TestAssertions, fixtures, etc.)
- **`jmeter/`** - JMeter test plans (e.g., `learning-basics.jmx`)
- **`resources/`** - Test data, test configs, fixtures

### Configuration (`config/`)
- External configuration files
- Environment-specific configs

### Documentation (`docs/`)
- Project documentation
- Test case documentation
- Architecture diagrams

## Benefits of This Structure

✅ **Separation of Concerns** - Clear distinction between unit and integration tests
✅ **Scalability** - Easy to add more test categories (e.g., smoke, performance)
✅ **Maintainability** - Organized packages make code easier to find and modify
✅ **Standard Maven Layout** - Follows Maven conventions and best practices
✅ **Resource Management** - Separate resources for test data and configs

## Running Tests

```bash
# Run all tests
mvn test

# Run JUnit 5 profile tests
mvn test -Pjunit

# Run JMeter profile
mvn verify -Pjmeter

# Run specific test class
mvn test -Dtest=CalculatorTest

# Generate test report
mvn surefire-report:report
```

## Adding New Tests

1. **TestNG Unit Test**: Add to `src/test/java/com/testexpert/java/unit/`
2. **JUnit 5 Test**: Add to `src/test/java/com/testexpert/java/junit/` and run with `-Pjunit`
3. **Integration Test**: Add to `src/test/java/com/testexpert/java/integration/`
4. **JMeter Plan**: Add `.jmx` to `src/test/jmeter/`
5. **New App Class**: Add to `src/main/java/com/testexpert/java/app/`
6. **New Utility**: Add to `src/main/java/com/testexpert/java/utils/`
7. **Update** `testng.xml` with new test classes if needed
