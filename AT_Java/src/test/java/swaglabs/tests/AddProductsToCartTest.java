package swaglabs.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import swaglabs.parent.BaseTest;

import static org.testng.Assert.assertEquals;

public class AddProductsToCartTest extends BaseTest {

    @DataProvider
    public static Object[][] productsNumberData() {
        return new Object[][]{
                {1},
                {3}
        };
    }

    @Test(description = "Проверка отображения количества товаров возле иконки корзины",
            dataProvider = "productsNumberData")
    public void checkAddProductsToCart(int productsNumber) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductsToCart(productsNumber);

        assertEquals(productsPage.getNumberCart(), String.valueOf(productsNumber));
    }

    @Test(description = "Проверка количества товаров в корзине", dataProvider = "productsNumberData")
    public void checkProductsInCart(int productsNumber) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        productsPage.addProductsToCart(productsNumber);

        productsPage.openCart();
        assertEquals(cartPage.getProductsNames().size(), productsNumber);
    }
}
