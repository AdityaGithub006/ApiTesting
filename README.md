# API Testing Framework

A streamlined API testing framework designed with Java and Maven, equipped with powerful libraries such as Rest Assured and methodologies for efficient API testing.

## Features

- **Modular Design:** Utilize the Page Object Model (POM) to organize API calls into structured modules.
- **Reusable Methods:** Leverage pre-built methods for common API testing actions, ensuring consistency.
- **TestNG Integration:** Seamlessly manage and run tests with TestNG for parallel execution and reporting.
- **JSON Handling:** Effortlessly manipulate and validate JSON responses using json-path and json libraries.
- **Rest Assured:** Utilize Rest Assured libraries for smooth API request and response management.
- **Schema Validation:** Validate JSON responses against defined schemas using json-schema-validator.
- **Data Generation:** Generate realistic test data with javafaker for a variety of testing scenarios.
- **Comprehensive Reporting:** Generate HTML reports with extentreports for clear test result visualization.
- **Data-Driven Testing:** Employ Apache POI and poi-ooxml to enable data-driven testing from Excel sources.
- **Mock API Server:** Simulate API interactions with json-server for robust testing of various scenarios.

## Getting Started

1. Clone the repository: `git clone https://github.com/yourusername/api-testing-framework.git`
2. Install dependencies: `mvn clean install`

## Usage

1. Configure test data and environment settings as needed.
2. Create TestNG test classes utilizing POM and re-usable methods.
3. Execute tests using TestNG, either through your IDE or command line.

## Tests

Sample tests showcase framework capabilities, including CRUD operations against a mock API using json-server.

## Contributing

Contributions are welcome! Feel free to submit pull requests for enhancements or issue resolutions.


