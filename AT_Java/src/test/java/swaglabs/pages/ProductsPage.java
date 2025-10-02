package swaglabs.pages;

import io.qameta.allure.Step;
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

    @Step("Check page title text")
    public String getTitle() {
        return driver.findElement(title).getText();
    }

    @Step("Check page title is displayed")
    public boolean isTitlePresent() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(title2)).isDisplayed();
    }

    @Step("Add product {productName} to cart")
    public void addToCart(String productName) {
        By addToCart = By.xpath(ADD_TO_CART_BTN_PATTERN.formatted(productName));
        driver.findElement(addToCart).click();
    }

    public void addToCart(int productIndex) {
        driver.findElements(ADD_TO_CART_BTN).get(productIndex).click();
    }

    @Step("Add {productNumber} products to cart")
    public void addProductsToCart(int productNumber) {
        for (int i = 0; i < productNumber; i++) {
            this.addToCart(0);
        }
    }

    @Step("Get cart icon counter value")
    public String getNumberCart() {
        return wait.until(
                ExpectedConditions.visibilityOfElementLocated(CART_BADGE)).getText();
    }

    @Step("Open cart")
    public void openCart() {
        driver.findElement(CART_LINK).click();
    }
}
