package tests;

import base.BaseTests;
import helpers.ExcelReader;
import helpers.PropertiesReader;
import org.testng.annotations.*;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AddItemsTest extends BaseTests {
    private String username;
    private String password;
    private String itemName;
    private ExcelReader itemReader;

    @BeforeClass
    public void localClassSetUp() {
        PropertiesReader columnsHeaderReader = new PropertiesReader("columns-headers");
        var userCredentials =
                new ExcelReader("user-credentials", "valid credentials").getFirstRow();
        username = userCredentials.get(columnsHeaderReader.getProperty("username")).toString();
        password = userCredentials.get(columnsHeaderReader.getProperty("password")).toString();

        itemName = columnsHeaderReader.getProperty("item");
    }

    /**
     * Override the before class in the base to become before method.
     * Calling minorSetUp to open the site, and to ensure that we use the same driver instance.
     */
    @BeforeMethod
    @Override
    public void majorSetUp() {
        super.majorSetUp();
        minorSetUp();
        itemReader = new ExcelReader("items", "items");
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
        var item = itemReader.getRandomRow().get(itemName).toString();

        var numOfItemsOnCart = new LoginPage(getDriver())
                .enterUserCredentials(username, password)
                .login()
                .addItemToCart(item)
                .getNumOfItemsOnCart();
        assertEquals(numOfItemsOnCart, 1);
    }

    @Test
    public void addTowItemsToCart() {
        var item1 = itemReader.getRandomRow().get(itemName).toString();
        var item2 = itemReader.getRandomRow().get(itemName).toString();

        var numOfItemsOnCart = new LoginPage(getDriver())
                .enterUserCredentials(username, password)
                .login()
                .addItemToCart(item1)
                .addItemToCart(item2)
                .getNumOfItemsOnCart();
        assertEquals(numOfItemsOnCart, 2);
    }

    @Test
    public void addOneItemToCartThenRemoveIt() {
        var item = itemReader.getRandomRow().get(itemName).toString();

        var cartStatus = new LoginPage(getDriver())
                .enterUserCredentials(username, password)
                .login()
                .addItemToCart(item)
                .removeItemFormCart(item)
                .isCartEmpty();
        assertTrue(cartStatus);
    }

    @Test
    public void addTowItemsToCartThenRemoveOne() {
        var item1 = itemReader.getRandomRow().get(itemName).toString();
        var item2 = itemReader.getRandomRow().get(itemName).toString();

        var numOfItemsOnCart = new LoginPage(getDriver())
                .enterUserCredentials(username, password)
                .login()
                .addItemToCart(item1)
                .addItemToCart(item2)
                .removeItemFormCart(item1)
                .getNumOfItemsOnCart();
        assertEquals(numOfItemsOnCart, 1);
    }

    @Test
    public void addItemToCartThenLogoutAndLogin() {
        var item = itemReader.getRandomRow().get(itemName).toString();

        var numOfItemsOnCart = new LoginPage(getDriver())
                .enterUserCredentials(username, password)
                .login()
                .addItemToCart(item)
                .openBurgerMenu()
                .logout()
                .enterUserCredentials(username, password)
                .login()
                .getNumOfItemsOnCart();
        assertEquals(numOfItemsOnCart, 1);
    }
}