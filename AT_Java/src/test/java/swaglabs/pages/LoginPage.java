package swaglabs.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import swaglabs.user.User;

public class LoginPage extends BasePage {

    private static final By USERNAME_INPUT = By.name("user-name");
    private static final By PASSWORD_INPUT = By.name("password");
    private static final By LOGIN_BTN = By.name("login-button");
    private static final By ERROR = By.xpath("//*[@data-test='error']");

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @Step("Open browser")
    public void open() {
        driver.get(BASE_URL);
    }

    @Step("Open browser")
    public void open(String path) {
        driver.get(BASE_URL + path);
    }

    @Step("Login with user credentials: username = {user.username}, password = ******")
    public void login(User user) {
        fillUsernameField(user.getUsername());
        fillPasswordField(user.getPassword());
        clickSubmit();
    }

    @Step("Fill username field")
    public void fillUsernameField(String username) {
        driver.findElement(USERNAME_INPUT).sendKeys(username);
    }

    @Step("Fill password field")
    public void fillPasswordField(String password) {
        driver.findElement(PASSWORD_INPUT).sendKeys(password);
    }

    @Step("Click submit")
    public void clickSubmit() {
        driver.findElement(LOGIN_BTN).click();
    }

    @Step("Check error message")
    public String getErrorMsg() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(ERROR)).getText();
    }
}
