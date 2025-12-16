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

---

## 📁 Project Structure

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

---

## ▶️ How to Run Tests

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