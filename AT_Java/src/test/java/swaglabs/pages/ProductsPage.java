package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProductsPage extends BasePage {

    private static final String ADD_TO_CART_BTN_PATTERN =
            "//*[text() = '%s']//ancestor::div[@class = 'inventory_item']//child::button[text() = 'Add to cart']";

    private static final By ADD_TO_CART_BTN = By.xpath("//*[text()='Add to cart']");
    private static final By CART_BADGE = By.xpath("//*[@data-test = 'shopping-cart-badge']");
    private static final By CART_LINK = By.xpath("//*[@data-test='shopping-cart-link']");
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

    public void addToCart(String productName) {
        By addToCart = By.xpath(ADD_TO_CART_BTN_PATTERN.formatted(productName));
        driver.findElement(addToCart).click();
    }

    public void addToCart(int productIndex) {
        driver.findElements(ADD_TO_CART_BTN).get(productIndex).click();
    }

    public void addProductsToCart(int productNumber) {
        for (int i = 0; i < productNumber; i++) {
            this.addToCart(0);
        }
    }

    public String getNumberCart() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(CART_BADGE)).getText();
    }

    public void openCart() {
        driver.findElement(CART_LINK).click();
    }
}
