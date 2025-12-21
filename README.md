<<<<<<< HEAD
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
=======
# 🛒 Amazon Automation Framework – SampleProject

A robust Selenium TestNG automation framework built using **Java + POM** to automate Amazon flows such as search, product validation, add to cart, and checkout.

This framework follows **industry best practices** and is designed for **interview readiness** and **real-world automation projects**.

---

## 🔧 Tech Stack

- **Java (JDK 8+)**
- **Selenium WebDriver**
- **TestNG**
- **Maven**
- **Page Object Model (POM)**
- **Extent Reports**
- **Log4j2**
- **Git & GitHub**
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050

---

## 📁 Project Structure
<<<<<<< HEAD
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
=======

SampleProject
│
├── src/test/java
│ ├── base → TestBase (driver setup)
│ ├── factory → DriverFactory (ThreadLocal, Grid)
│ ├── pages → POM classes
│ ├── tests → TestNG test cases
│ ├── utilities → WaitUtils, ConfigReader, ScreenshotUtil
│ └── listeners → TestNG listeners
│
├── src/test/resources
│ ├── config.properties
│ └── testng.xml
│
├── reports → Extent Reports
├── screenshots → Failure screenshots
├── pom.xml
└── README.md


---

## 🚀 Features Implemented

- ✅ Page Object Model (POM)
- ✅ Parallel execution using TestNG
- ✅ Cross-browser execution (Chrome, Edge, Firefox)
- ✅ Thread-safe WebDriver using ThreadLocal
- ✅ Selenium Grid support (optional)
- ✅ Explicit waits & safe actions
- ✅ Data-driven testing (TestNG DataProvider)
- ✅ Screenshot capture on failure
- ✅ Extent HTML Reports
- ✅ TestNG Groups (Smoke / Regression)
- ✅ GitHub version control

---

## 🧪 Test Scenarios Covered

- 🔍 Search product
- 📄 Product validation
- 🛒 Add to Cart
- 🧾 Cart validation
- 🔐 Login (data-driven)
- 🚚 Checkout flow (safe till payment)
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050

---

## ▶️ How to Run Tests
<<<<<<< HEAD
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
=======

### Run via TestNG XML
```bash
mvn test

Run specific suite
mvn test -DsuiteXmlFile=smoke.xml

🧠 Configuration

Edit config.properties:

browser=chrome
headless=false
remote=false
base.url=https://www.amazon.in

📊 Reports

Extent Report generated at:

/reports/extent.html


Screenshots captured on failure:

/screenshots⚠️ Important Note

🚫 Place Order is intentionally disabled to avoid real purchases.

👩‍💻 Author

Snigdha
SDET | Automation Engineer
GitHub: https://github.com/snigdhavariganti-ctrl
>>>>>>> a3dd876ef156068d68059a139cdba17cd3017050
