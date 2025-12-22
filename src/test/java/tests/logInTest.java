package tests;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import base.TestBase;
import pages.LoginPage;
import utilities.ExcelUtils;

public class logInTest extends TestBase {

    /**
     * Hardcoded login data (positive & negative scenarios)
     */
    @DataProvider(name = "loginData")
    public Object[][] getLoginData() {
        return new Object[][] {
                {"wrongemail@gmail.com", "wrongpass", false},
                {"testuser@gmail.com", "wrongpass", false},
                {"validuser@gmail.com", "validpassword", true}
        };
    }

    /**
     * Login test using DataProvider
     */
    @Test(dataProvider = "loginData", groups = "login")
    public void loginTest(String username, String password, boolean expectedResult) {

        LoginPage loginPage = new LoginPage();
        loginPage.login(username, password);

        if (expectedResult) {
            // Expected successful login
            // Assertion can be added if login success indicator exists
            System.out.println("✅ Login attempted with valid credentials");
        } else {
            // Expected failure
            System.out.println("❌ Login attempted with invalid credentials");
        }
    }

    /**
     * Login test using Excel data
     */
    @DataProvider(name = "excelLoginData")
    public Object[][] excelLoginData() throws IOException {
        String path = System.getProperty("user.dir") + "/testdata/loginData.xlsx";
        return ExcelUtils.getSheetData(path, "LoginData");
    }

    /**
     * Excel-driven login test
     */
    @Test(dataProvider = "excelLoginData", groups = "login")
    public void testLoginExcel(String email, String password, String expectedResult) {

        LoginPage loginPage = new LoginPage();
        loginPage.login(email, password);

        System.out.println("🔐 Login attempted using Excel data");
    }
}
