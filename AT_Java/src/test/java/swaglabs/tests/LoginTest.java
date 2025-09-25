package swaglabs.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import swaglabs.parent.BaseTest;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test(description = "Проверка корректной авторизации")
    public void checkLoginWithCorrectCredentials() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        assertTrue(productsPage.isTitlePresent());
        assertEquals(productsPage.getTitle(), "Products",
                "Название заголовка не соответствует ожидаемому");
    }

    @DataProvider
    public Object[][] loginData() {
        return new Object[][] {
                {"locked_out_user", "secret_sauce", "Epic sadface: Sorry, this user has been locked out."},
                {"", "secret_sauce", "Epic sadface: Username is required"},
                {"standard_user", "", "Epic sadface: Password is required"}
        };
    }

    @Test(description = "Проверка сообщения об ошибке", dataProvider = "loginData")
    public void checkIncorrectLogin(String username, String password, String errorMsg) {
        loginPage.open();
        loginPage.login(username, password);
        assertEquals(loginPage.getErrorMsg(), errorMsg);
    }
}
