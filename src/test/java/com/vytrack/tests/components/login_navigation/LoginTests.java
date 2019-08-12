package com.vytrack.tests.components.login_navigation;

import com.vytrack.pages.login_navigation.LoginPage;
import com.vytrack.utilities.ConfigurationReader;
import com.vytrack.utilities.SeleniumUtils;
import com.vytrack.utilities.TestBase;
import com.vytrack.utilities.VYTrackUtil;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {


    @Test
    public void loginTest1(){
        extentLogger = report.createTest("Login as a store manager");
        LoginPage loginPage = new LoginPage();
        String username = ConfigurationReader.getProperty("storemanagerusername");
        String password = ConfigurationReader.getProperty("storemanagerpassword");
        extentLogger.info("Clicking on remember me");
        loginPage.clickRememberMe();
        loginPage.login(username, password);
        Assert.assertEquals(VYTrackUtil.getPageSubTitle(),"Dashboard");
        extentLogger.pass("Verified that page is Dashboard");
    }
    @Test
    public void negativeLoginTest1(){
        LoginPage loginPage = new LoginPage();
        extentLogger.info("Logging with user name wrongname and password wrongpassword");
        loginPage.login("wrongusername", "wrongpassword");
        Assert.assertEquals(loginPage.getErrorMessage(), "Invalid user name or password.");
        extentLogger.pass("Verify that warning message displays: Invalid user name or password");
    }
}
