# SauceDemo Automation Framework

## 📌 Project Overview

This project is a Selenium WebDriver automation framework developed using Java, Maven, TestNG and Cucumber BDD.

The framework automates the major functional flows of the SauceDemo e-commerce application.

## 🛠️ Technology Stack

- Java
- Selenium WebDriver
- Maven
- TestNG
- Cucumber BDD
- Git & GitHub
- Jenkins
- Page Object Model
- ThreadLocal WebDriver
- Parallel Execution

## 🌐 Application

SauceDemo

https://www.saucedemo.com/

## 🏗️ Framework Architecture

                  ┌──────────────┐
                  │    GitHub    │
                  └──────┬───────┘
                         │
                         ↓
                  ┌──────────────┐
                  │   Jenkins    │
                  └──────┬───────┘
                         │
                         ↓
                  ┌──────────────┐
                  │    Maven     │
                  └──────┬───────┘
                         │
                         ↓
                  ┌──────────────┐
                  │   TestNG     │
                  └──────┬───────┘
                         │
                         ↓
                  ┌──────────────┐
                  │  Cucumber    │
                  │     BDD      │
                  └──────┬───────┘
                         │
                         ↓
                Selenium WebDriver
                         │
                 ┌───────┴───────┐
                 ↓               ↓
             Page Object      Utilities
                 │
       ┌─────────┼──────────┐
       ↓         ↓          ↓
     Login    Products     Cart
                             ↓
                         Checkout
                             ↓
                       Order Success

## 📂 Project Structure

src/main/java
├── factory
├── pages
└── utils

src/test/java
├── hooks
├── runners
├── stepDefinitions
└── utils

src/test/resources
├── config
└── features

## 🧪 Automated Modules

### Login
- Valid login
- Invalid login
- Login error validation

### Products
- Product display
- Product sorting
- Add product to cart

### Cart
- Add product
- Verify product information
- Remove product
- Continue shopping
- Cart validation

### Checkout
- Checkout information
- Successful order
- Missing customer information
- Cancel checkout
- Order confirmation

## 🚀 Execution

Run all tests:

mvn clean test

Run on Chrome:

mvn clean test -Dbrowser=chrome

Run on Firefox:

mvn clean test -Dbrowser=firefox

Run on Edge:

mvn clean test -Dbrowser=edge

## 🔄 CI/CD

The framework is integrated with Jenkins for continuous integration.

Jenkins
↓
GitHub
↓
Maven
↓
TestNG
↓
Cucumber
↓
Selenium Tests

## 📊 Reporting

Cucumber HTML reports are generated under:

target/cucumber-report.html

Failure screenshots are captured automatically and stored under the configured screenshot directory.

## ⚡ Parallel Execution

The framework supports parallel Cucumber scenario execution using TestNG DataProvider.

ThreadLocal WebDriver is used to maintain independent browser sessions between parallel executions.

## 🎯 Design Pattern

Page Object Model (POM) is used to separate:

- Test logic
- Page locators
- Page actions

Reusable Selenium operations are centralized in BasePage.

## 👨‍💻 Author

Dheena G
