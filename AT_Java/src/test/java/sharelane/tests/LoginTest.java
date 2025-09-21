package sharelane.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import sharelane.parent.BaseTest;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    @Test
    public void checkLogin() {
        loginPage.open();
        loginPage.loginThruZip("12345");
        boolean isPresent = browser.findElement(By.xpath("//input[@value = 'Register']")).isDisplayed();
        assertTrue(isPresent);
    }

    @Test
    public void checkErrorLogin() {
        loginPage.open();
        loginPage.loginThruZip("12");
        String errorMsg = browser.findElement(By.cssSelector(".error_message")).getText();
        assertEquals(errorMsg, "Oops, error on page. ZIP code should have 5 digits");
    }
}
