package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_BTN_PATTERN =
            "//*[text() = '%s']//ancestor::div[@class = 'inventory_item']//child::button[text() = 'Add to cart']";
    private final By title = By.xpath("//*[@data-test='title']");
    private final By title2 = By.xpath("//*[text()='Products']");

    public ProductsPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.findElement(title).getText();
    }

    public boolean isTitlePresent() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(title2)).isDisplayed();
    }

    public void addToCard(String goodsName) {
        By addToCart = By.xpath(ADD_TO_CART_BTN_PATTERN.formatted(goodsName));
        driver.findElement(addToCart).click();
    }
}
