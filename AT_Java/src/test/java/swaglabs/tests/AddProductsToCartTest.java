package swaglabs.tests;

import io.qameta.allure.*;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import swaglabs.parent.BaseTest;

import static enums.PageTitles.CARTS;
import static org.testng.Assert.assertEquals;
import static swaglabs.user.UserFactory.withClientPermission;

public class AddProductsToCartTest extends BaseTest {

    @DataProvider
    public static Object[][] productsNumberData() {
        return new Object[][]{
                {1},
                {3}
        };
    }

    @Severity(SeverityLevel.NORMAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @TmsLink("Homeworks")
    @Test(description = "Check cart icon counter value",
            dataProvider = "productsNumberData")
    public void checkAddProductsToCart(int productsNumber) {
        loginPage.open();
        loginPage.login(withClientPermission());
        productsPage.addProductsToCart(productsNumber);
        assertEquals(productsPage.getNumberCart(), String.valueOf(productsNumber));
    }

    @Severity(SeverityLevel.CRITICAL)
    @Owner("Anastasiia Evchuk anastasiiaevchuk@gmail.com")
    @TmsLink("Homeworks")
    @Test(description = "Check product's number in cart", dataProvider = "productsNumberData")
    public void checkProductsInCart(int productsNumber) {
        loginPage.open();
        loginPage.login(withClientPermission());
        productsPage.addProductsToCart(productsNumber);
        productsPage.openCart();
        assertEquals(CARTS.getDisplayName(), cartPage.getCartTitleText());
        assertEquals(cartPage.getProductsNames().size(), productsNumber);
    }
}
