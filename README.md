# Amazon Search & Cart Test Automation Framework

## Overview

This repository contains a functional UI test automation framework for validating Amazon search and cart flows using **Java**, **Selenium WebDriver**, **Cucumber BDD**, **JUnit**, and **Gradle**.

The main goal of this project is to verify that a user can search for products, navigate through search result pages, select a product, and add it to the shopping cart successfully.

## Tech Stack

* Java 17
* Selenium WebDriver 4.15.0
* Cucumber Java 7.14.1
* JUnit Jupiter 5.9.1
* Gradle 8.1
* WebDriverManager 5.6.2
* Cucumber HTML Reports
* Google Chrome

## Prerequisites

Before running the project, make sure you have the following installed:

* JDK 17
* Google Chrome
* Git

Gradle does not need to be installed manually because this project includes the Gradle Wrapper.

## Installation

Clone the repository:

```bash
git clone https://github.com/Alez-Estacio/amazon-selenium-automation-framework.git
```

Navigate to the project directory:

```bash
cd amazon-selenium-automation-framework
```

## Project Structure

```text
amazon-selenium-automation-framework/
├── src/
│   ├── main/
│   └── test/
│       ├── java/
│       │   ├── pages/          # Page Objects: AmazonSearchPage, BasePage
│       │   ├── steps/          # Step Definitions and Hooks
│       │   └── runner/         # Test runner class
│       └── resources/
│           └── features/       # Gherkin feature files
├── build.gradle                # Gradle dependencies and plugins
├── gradlew                     # Gradle Wrapper for Linux/macOS
├── gradlew.bat                 # Gradle Wrapper for Windows
├── run_tests.bat               # Windows test execution script
├── settings.gradle             # Gradle project settings
└── README.md                   # Project documentation
```

## Running Tests

Run the test suite using the Gradle Wrapper:

```bash
./gradlew test
```

On Windows, you can run:

```bash
gradlew.bat test
```

You can also use the included Windows script:

```bash
run_tests.bat
```

## Running Tests from an IDE

You can execute the test suite from an IDE such as IntelliJ IDEA, Eclipse, or Visual Studio Code by running the test runner class located under:

```text
src/test/java/runner/
```

Run it as a JUnit test.

## Reports

After test execution, the default Gradle test report is generated at:

```text
build/reports/tests/test/index.html
```

Cucumber reports are generated at:

```text
target/cucumber-reports/
```

Screenshots for each step and failed scenarios are attached automatically to the test report.

## Feature Files

The scenarios are written in Gherkin and include parameterized examples for different product searches.

The feature files are located at:

```text
src/test/resources/features/
```

These scenarios are designed to be readable, reusable, and easy to maintain.

## Test Design

This project follows common UI test automation practices:

* **Page Object Model:** separates page interactions from test logic.
* **BDD with Cucumber:** describes scenarios in a business-readable format.
* **Reusable Step Definitions:** keeps steps independent and maintainable.
* **Automatic Evidence Capture:** attaches screenshots for traceability.
* **Gradle Wrapper:** standardizes build execution across environments.
* **Cucumber Reports:** provides execution results in HTML format.

## Customization

You can modify the feature file to test different products or search flows.

Main feature file:

```text
src/test/resources/features/AmazonSearch.feature
```

Selectors and browser interaction logic can be updated in the Page Object classes if the Amazon UI changes.

## Notes

This project is intended for QA automation practice and technical demonstration purposes.

Amazon is a dynamic website, so locators and flows may require maintenance if the UI, validations, or anti-automation behavior changes.

## Author

**Alezander Estacio**

QA Automation Engineer

