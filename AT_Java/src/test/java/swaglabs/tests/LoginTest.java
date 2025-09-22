package swaglabs.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import swaglabs.parent.BaseTest;

import static org.testng.Assert.assertTrue;
import static org.testng.Assert.assertEquals;

public class LoginTest extends BaseTest {

    @Test
    public void checkLoginWithCorrectCredentials() {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");

        boolean isProductDisplayed = browser.findElement(By.xpath("//*[@data-test='title']"))
                .isDisplayed();

        assertTrue(isProductDisplayed);
    }

    @Test
    public void checkLoginWithLockedOutUser() {
        loginPage.open();
        loginPage.login("locked_out_user", "secret_sauce");

        String errorMsg = browser.findElement(By.xpath("//*[@data-test='error']")).getText();
        assertEquals(errorMsg, "Epic sadface: Sorry, this user has been locked out.");
    }
}
