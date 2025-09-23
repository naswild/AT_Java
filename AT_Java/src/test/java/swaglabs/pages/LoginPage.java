package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT = By.name("user-name");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BTN = By.name("login-button");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void open() {
        driver.get(BASE_URL);
    }

    public void open(String path) {
        driver.get(BASE_URL + path);
    }

    public void login(String username, String password) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
        driver.findElement(LOGIN_BTN).click();
    }

    public String checkErrorMsg() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(ERROR)).getText();
    }
}
