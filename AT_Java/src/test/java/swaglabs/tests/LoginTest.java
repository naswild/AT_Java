package swaglabs.tests;

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

    @Test
    public void checkLoginWithLockedOutUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Sorry, this user has been locked out.");
    }

    @Test(description = "Проверка сообщения об ошибке при пустом поле username")
    public void checkLoginWithoutUsername() {
        loginPage.open();
        loginPage.login("", "secret_sauce");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Username is required");
    }

    @Test(description = "Проверка сообщения об ошибке при пустом поле password")
    public void checkLoginWithoutPassword() {
        loginPage.open();
        loginPage.login("standard_user", "");
        assertEquals(loginPage.checkErrorMsg(), "Epic sadface: Password is required");
    }
}
