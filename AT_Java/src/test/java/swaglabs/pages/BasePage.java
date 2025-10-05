package swaglabs.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import swaglabs.utils.PropertyEnum;
import swaglabs.utils.PropertyReader;

import java.time.Duration;

public abstract class BasePage {

    protected static final String BASE_URL = PropertyReader.getProperty(PropertyEnum.BASE_URL.getValue());

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}
