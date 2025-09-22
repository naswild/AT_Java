package sharelane.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {

    private static final By ZIP_INPUT = By.xpath("//*[@name='zip_code']");
    private static final By CONTINUE_BTN = By.cssSelector("*[value='Continue']");

    WebDriver browser;

    public LoginPage(WebDriver browser) {
        this.browser = browser;
    }

    public void open() {
        browser.get("https://sharelane.com/cgi-bin/register.py");
    }

    public void loginThruZip(String zipCode) {
        browser.findElement(ZIP_INPUT).sendKeys(zipCode);
        browser.findElement(CONTINUE_BTN).click();
    }
}
