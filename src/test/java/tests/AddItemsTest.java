package tests;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class AddItemsTest extends BaseTests {
    @Test
    public void addItemToCart() {
        var numOfItemsOnCart = new LoginPage(getDriver())
                .enterUserCredentials("standard_user", "secret_sauce")
                .login()
                .addItemToCart("Sauce Labs Backpack")
                .getNumOfItemsOnCart();
        assertEquals(numOfItemsOnCart, 1);
    }

    @Test
    public void addTowItemsToCart() {
        var numOfItemsOnCart = new LoginPage(getDriver())
                .enterUserCredentials("standard_user", "secret_sauce")
                .login()
                .addItemToCart("Sauce Labs Backpack")
                .addItemToCart("Sauce Labs Bike Light")
                .getNumOfItemsOnCart();
        assertEquals(numOfItemsOnCart, 2);
    }
}
