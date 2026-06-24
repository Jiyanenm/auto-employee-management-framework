# Employee Management Automation Framework

## Overview

This project is a Selenium WebDriver Automation Framework developed to automate the Employee Management Application.

The framework follows industry-standard automation practices including:

* Page Object Model (POM)
* JUnit 5 Test Framework
* Maven Build Management
* Data-Driven Testing using Excel
* Environment Configuration Management
* Explicit Wait Strategy
* Screenshot Capture Utility
* Allure Reporting
* Extent Reports
* GitHub Actions CI/CD Integration
* Test Suite Execution
* Headless Browser Execution

---

# Application Under Test

I have Built my own Employee Management Application using angular and firebase as our cloud database.
I have deployed my this CRUD Application on vercel cloud application platform.

Application URL:

https://employee-management-app-tau-ashen.vercel.app/

Features Covered:

* Login
* Add Employee
* Update Employee
* Delete Employee
* Search Employee
* Validation Testing
* Data-Driven Testing

---

# Technology Stack

| Technology         | Version |
| ------------------ | ------- |
| Java               | 17      |
| Selenium WebDriver | 4.20.0  |
| JUnit              | 5       |
| Maven              | Latest  |
| Apache POI         | 5.2.5   |
| Allure Reports     | 2.29.0  |
| Extent Reports     | 5.1.2   |
| GitHub Actions     | CI/CD   |
| Chrome Browser     | Latest  |

---

# Framework Design

Framework Structure:

src
├── main
│ ├── java
│ │ ├── base
│ │ ├── pages
│ │ └── utils
│ └── resources
│
├── test
│ ├── java
│ │ ├── test
│ │ ├── suite
│ │ └── listeners
│ └── resources
│
└── pom.xml

---

# Framework Components

## Base Layer

### BaseTest

Responsible for:

* Browser initialization
* Browser teardown
* Environment loading
* Test setup

### BasePage

Reusable methods:

* click()
* type()
* getText()
* waitForElement()
* isDisplayed()

---

# Page Objects

## LoginPage

Functions:

* Login with valid credentials
* Login with invalid credentials

## EmployeePage

Functions:

* Add Employee
* Edit Employee
* Delete Employee
* Search Employee
* Verify Employee Existence

---

# Utilities Implemented

## WaitUtils

Centralized explicit waits.

Methods:

* waitForElementVisible()
* waitForElementClickable()

Benefits:

* Improved stability
* Reduced flaky tests

---

## ScreenshotUtil

Captures screenshots during execution.

Features:

* Failure screenshots
* Manual screenshots
* CI execution support

---

## ExcelUtils

Supports Data-Driven Testing.

Capabilities:

* Read Excel files
* Multiple rows support
* Dynamic test data

---

# Data Driven Testing

Implemented using:

* Apache POI
* Excel spreadsheet

Example:

employees.xlsx

| Name     | Email                                 | Department | Status   |
| -------- | ------------------------------------- | ---------- | -------- |
| John Doe | [john@test.com](mailto:john@test.com) | IT         | Active   |
| Jane Doe | [jane@test.com](mailto:jane@test.com) | HR         | Inactive |

Test:

AddEmployeeExcelTest

Reads data directly from Excel and creates employees dynamically.

---

# Test Cases Implemented

## Authentication

* Login with valid credentials
* Login with invalid credentials

## Employee Management

* Add Employee
* Update Employee
* Delete Employee
* Search Employee
* Search Non-Existing Employee

## Data Driven

* Add Multiple Employees from Excel

---

# Environment Switching

Implemented using Maven System Properties.

Folder:

src/test/resources

Files:

config-dev.properties
config-qa.properties
config-prod.properties

Example:

config-qa.properties

base.url=https://employee-management-app-tau-ashen.vercel.app

Execution:

mvn clean test -Denv=qa

Benefits:

* No code changes between environments
* Easy deployment validation

---

# Test Suite Implementation

Package:

test.suite

Example:

TestSuite.java

Suite includes:

* LoginTest
* AddEmployeeTest
* SearchEmployeeTest
* SearchNonExistingEmployeeTest
* DeleteEmployeeTest

Execution:

mvn test -Dtest=TestSuite

Benefits:

* Smoke execution
* Regression execution
* CI execution

---

# Reporting

## Allure Reports

Generate Results:

mvn test

Generate Report:

mvn allure:report

Serve Report:

mvn allure:serve

Benefits:

* Detailed execution history
* Screenshots
* Test statistics

---

## Extent Reports

Provides:

* Pass/Fail status
* Execution summary
* Screenshots
* Test logs

Generated under:

reports/

---

# CI/CD Pipeline

GitHub Actions is configured to:

1. Checkout Source Code
2. Setup Java 17
3. Cache Maven Dependencies
4. Execute Regression Suite
5. Generate Allure Reports
6. Upload Test Artifacts

Workflow File:

.github/workflows/automation-pipeline.yml

Pipeline Trigger:

* Push to Main Branch
* Pull Requests to Main Branch

# GitHub Actions Configuration

Workflow Location:

.github/workflows/automation-pipeline.yml

Workflow:

```yaml
name: Employee Management Automation Pipeline

on:
  push:
    branches:
      - main

  pull_request:
    branches:
      - main

jobs:
  test:
    name: Regression Test Suite
    runs-on: ubuntu-latest

    steps:
      - name: Checkout Repository
        uses: actions/checkout@v4

      - name: Setup JDK 17
        uses: actions/setup-java@v4
        with:
          distribution: temurin
          java-version: 17

      - name: Cache Maven Dependencies
        uses: actions/cache@v4
        with:
          path: ~/.m2
          key: maven-${{ hashFiles('**/pom.xml') }}

      - name: Execute Test Suite
        run: mvn clean test -Denv=qa -Dtest=TestSuite

      - name: Generate Allure Report
        run: mvn allure:report

      - name: Upload Test Reports
        if: always()
        uses: actions/upload-artifact@v4
        with:
          name: automation-test-report
          path: |
            target/surefire-reports/
            target/allure-results/
```

Pipeline Features:

* Automatic execution on every push to main
* Automatic execution on pull requests
* Maven dependency caching
* Regression suite execution
* QA environment execution
* Allure report generation
* Test artifact upload
* Headless browser execution support

Pipeline Outcome:

* Faster feedback cycle
* Automated regression validation
* Continuous Integration support
* Centralized test reporting
* Improved software quality

Command running pipeline : 

---

# Maven Commands

Run All Tests

mvn clean test

Run Regression Suite

mvn clean test -Dtest=TestSuite

Run QA Environment

mvn clean test -Denv=qa

Clean Install

mvn clean install

Force Dependency Update

mvn clean install -U

Generate Allure Report

mvn allure:report

Serve Allure Report

mvn allure:serve

---

# Headless Execution

Required for CI/CD.

ChromeOptions:

options.addArguments("--headless=new");
options.addArguments("--disable-gpu");
options.addArguments("--window-size=1920,1080");

Benefits:

* Faster execution
* GitHub Actions compatible
* Lower resource usage

---

# Achievements Completed

✔ Selenium Framework Setup

✔ Page Object Model

✔ Maven Integration

✔ JUnit 5 Integration

✔ Explicit Wait Framework

✔ Excel Data-Driven Testing

✔ Screenshot Utility

✔ Allure Reporting

✔ Extent Reporting

✔ Environment Switching

✔ Test Suite Execution

✔ GitHub Actions CI/CD Pipeline

✔ Headless Browser Support

✔ Regression Suite Configuration

---

# Future Enhancements

* Cross Browser Testing
* Parallel Execution
* Docker Integration
* Selenium Grid
* Jenkins Integration
* API Automation
* Database Validation
* Performance Testing
* Cloud Execution using BrowserStack
* BDD with Cucumber

---

# Author

Nkosinathi

Automation Test Engineer | SDET

Java | Selenium | JUnit | Maven | API Testing | CI/CD | GitHub Actions
