package swaglabs.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class CartPage extends BasePage {

    private static final By PRODUCT_NAME = By.cssSelector(".inventory_item_name");

    public CartPage(WebDriver driver) {
        super(driver);
    }

    public List<String> getProductsNames() {
        List<WebElement> allProductsNames = driver.findElements(PRODUCT_NAME);
        List<String> productsNames =  new ArrayList<>();
        for (WebElement product : allProductsNames) {
            productsNames.add(product.getText());
        }

        return productsNames;
    }
}
