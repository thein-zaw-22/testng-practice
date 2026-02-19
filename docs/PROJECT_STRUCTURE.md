# TestNG Practice - Organized Project Structure

## Folder Organization

### Source Code (`src/main/`)
- **`java/com/testng/practice/app/`** - Main application classes (Calculator, Services, etc.)
- **`java/com/testng/practice/utils/`** - Utility and helper classes (StringUtils, etc.)
- **`resources/`** - Configuration files, properties, etc.

### Test Code (`src/test/`)
- **`java/com/testng/practice/unit/`** - Unit tests (test individual classes)
- **`java/com/testng/practice/integration/`** - Integration tests (test component interactions)
- **`java/com/testng/practice/utils/`** - Test helpers and assertions (TestAssertions, fixtures, etc.)
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

# Run only unit tests
mvn test -Dtest=com.testng.practice.unit.*

# Run only integration tests
mvn test -Dtest=com.testng.practice.integration.*

# Run specific test class
mvn test -Dtest=CalculatorTest

# Generate test report
mvn surefire-report:report
```

## Adding New Tests

1. **Unit Test**: Add to `src/test/java/com/testng/practice/unit/`
2. **Integration Test**: Add to `src/test/java/com/testng/practice/integration/`
3. **New App Class**: Add to `src/main/java/com/testng/practice/app/`
4. **New Utility**: Add to `src/main/java/com/testng/practice/utils/`
5. **Update** `testng.xml` with new test classes if needed
