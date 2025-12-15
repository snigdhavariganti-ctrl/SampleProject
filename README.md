# 🛒 Amazon Selenium TestNG Automation Framework

## 📌 Overview
This project is a **Selenium Automation Framework** built using **Java + TestNG** to automate core user flows on the **Amazon website**.
It follows the **Page Object Model (POM)** design pattern and is created mainly for **learning and interview preparation**.

⚠️ **Note:**  
This framework is for **educational purposes only**. Do **NOT** place real orders on Amazon.

---

## 🛠️ Tech Stack
- Java (JDK 8+)
- Selenium WebDriver
- TestNG
- Maven
- WebDriverManager
- Extent Reports / Allure (optional)
- Git & GitHub

---

## 📁 Project Structure
```
AmazonAutomationFramework
│
├── src/main/java
│   ├── base
│   │   └── BasePage.java
│   ├── factory
│   │   └── DriverFactory.java
│   ├── pages
│   │   ├── LoginPage.java
│   │   ├── HomePage.java
│   │   ├── ProductPage.java
│   │   ├── AddToCartPage.java
│   │   └── CheckoutPage.java
│   └── utils
│       └── RetryUtils.java
│
├── src/test/java
│   ├── base
│   │   └── BaseTest.java
│   └── tests
│       └── PurchaseTest.java
│
├── testng.xml
├── pom.xml
└── README.md
```

---

## 🧱 Framework Design
### Page Object Model (POM)
- Each web page is represented as a separate Java class
- Locators and actions are encapsulated
- Improves readability, reusability, and maintenance

### BasePage
Contains reusable Selenium methods:
- click()
- type()
- getText()
- isDisplayed()
- Explicit waits

### DriverFactory
- Manages WebDriver lifecycle
- Supports easy browser initialization
- ThreadLocal ready (parallel execution)

---

## 🚀 Test Flow Covered
- Launch Amazon
- Login
- Search Product
- Select Product
- Add to Cart
- Proceed to Checkout
- Place Order (Not recommended on real account)

---

## ▶️ How to Run Tests
### Clone Repository
```bash
git clone https://github.com/your-username/AmazonAutomationFramework.git
```

### Run Using TestNG
- Right-click testng.xml
- Run As → TestNG Suite

### Run Using Maven
```bash
mvn clean test
```

---

## 📊 Reporting
- Extent Reports / Allure supported
- Shows execution status, steps, and failures

---

## ❓ Interview Highlights
- Why POM? → Better maintainability
- Why BasePage? → Centralized reusable actions
- Why TestNG? → Parallel execution, grouping
- Why Maven? → Dependency & build management

---

## ⚠️ Disclaimer
- Do NOT use real Amazon credentials
- Avoid placing real orders
- Use dummy data only

---

## 👩‍💻 Author
Snigdha Variganti  
Automation Test Engineer

---

## 🌟 Future Enhancements
- Cross-browser execution
- Parallel testing
- Selenium Grid
- CI/CD integration
