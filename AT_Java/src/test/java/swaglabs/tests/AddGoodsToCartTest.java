package swaglabs.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import swaglabs.parent.BaseTest;

import static org.testng.Assert.assertEquals;

public class AddGoodsToCartTest extends BaseTest {

    @DataProvider
    public static Object[][] goodsNumberData() {
        return new Object[][]{
                {1},
                {3}
        };
    }

    @Test(description = "Проверка добавления товара в корзину", dataProvider = "goodsNumberData")
    public void checkAddGoodsToCart(int goodsNumber) {
        loginPage.open();
        loginPage.login("standard_user", "secret_sauce");
        for (int i = 0; i < goodsNumber; i++) {
            productsPage.addToCart(0);
        }

        assertEquals(productsPage.getNumberCart(), String.valueOf(goodsNumber));
    }
}
