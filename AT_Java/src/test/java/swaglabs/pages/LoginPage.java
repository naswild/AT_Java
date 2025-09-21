package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    public static final By USERNAME_INPUT = By.name("user-name");
    public static final By PASSWORD_INPUT = By.name("password");
    public static final By LOGIN_BTN = By.name("login-button");

    private final WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open() {
        browser.get("https://www.saucedemo.com/");
    }

    public void login(String username, String password) {
        browser.findElement(USERNAME_INPUT).sendKeys(username);
        browser.findElement(PASSWORD_INPUT).sendKeys(password);
        browser.findElement(LOGIN_BTN).click();
    }
}
