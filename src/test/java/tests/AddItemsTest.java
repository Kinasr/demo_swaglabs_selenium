package tests;

import base.BaseTests;
import org.testng.annotations.*;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddItemsTest extends BaseTests {
    /**
     * Override the before class in the base to become before method.
     * Calling minorSetUp to open the site, and to ensure that we use the same driver instance.
     */
    @BeforeMethod
    @Override
    public void majorSetUp() {
        super.majorSetUp();
        minorSetUp();
    }

    /**
     * Override the minorSetUp to delete it's annotation and with keeping it's main job.
     */
    @Override
    public void minorSetUp() {
        super.minorSetUp();
    }

    /**
     * Override the after class in the base to become after method.
     */
    @AfterMethod
    @Override
    public void majorTearDown() {
        super.majorTearDown();
    }

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

    @Test
    public void addOneItemToCartThenRemoveIt() {
        var cartStatus = new LoginPage(getDriver())
                .enterUserCredentials("standard_user", "secret_sauce")
                .login()
                .addItemToCart("Sauce Labs Backpack")
                .removeItemFormCart("Sauce Labs Backpack")
                .isCartEmpty();
        assertTrue(cartStatus);
    }
}
