package swaglabs.tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import swaglabs.parent.BaseTest;
import swaglabs.user.User;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;
import static swaglabs.user.UserFactory.withClientPermission;
import static swaglabs.user.UserFactory.withLockedOutUserPermission;

public class LoginTest extends BaseTest {

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @TmsLink("helloworld")
    @Issue("Homeworks")
    @Test(description = "Check correct login")
    public void checkLoginWithCorrectCredentials() {
        loginPage.open();
        loginPage.login(withClientPermission());
        assertTrue(productsPage.isTitlePresent());
        assertEquals(productsPage.getTitle(), "Products",
                "Title doesn't match expected value");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][]{
                {withLockedOutUserPermission(), "Epic sadface: Sorry, this user has been locked out."},
                {new User("", "secret_sauce"), "Epic sadface: Username is required"},
                {new User("standard_user", ""), "Epic sadface: Password is required"}
        };
    }

    @Severity(SeverityLevel.NORMAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @TmsLink("helloworld")
    @Test(description = "Check error message", dataProvider = "loginData")
    public void checkIncorrectLogin(User user, String errorMsg) {
        loginPage.open();
        loginPage.login(user);
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}
