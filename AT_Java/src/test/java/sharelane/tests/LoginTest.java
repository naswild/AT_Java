package sharelane.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import sharelane.parent.BaseTest;

import java.time.Duration;

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
        WebDriverWait wait =  new WebDriverWait(browser, Duration.ofSeconds(10));
        loginPage.open();
        loginPage.loginThruZip("12");
        WebElement errorMessage = browser.findElement(By.cssSelector(".error_message"));
        wait.until(ExpectedConditions.visibilityOf(errorMessage));
        assertEquals(errorMessage.getText(), "Oops, error on page. ZIP code should have 5 digits");
    }
}
