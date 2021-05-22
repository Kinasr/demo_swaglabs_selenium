package pages;

import helpers.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage extends BurgerMenu {
    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By pageTitle = By.className("title");
    private final By shoppingCartBadge = By.className("shopping_cart_badge");
    private final String addItemButtonId = "add-to-cart-";
    private final String removeItemButtonId = "remove-";

    public InventoryPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }

    public String getPageTitle() {
        return guiActions.getTextFrom(pageTitle);
    }

    public InventoryPage addItemToCart(String itemName) {
        var formattedItemName = itemName.replaceAll(" ", "-").toLowerCase();
        var addItemButton = By.id(addItemButtonId + formattedItemName);
        guiActions.clickOn(addItemButton);
        return new InventoryPage(driver);
    }

    public InventoryPage removeItemFormCart(String itemName) {
        var formattedItemName = itemName.replaceAll(" ", "-").toLowerCase();
        var removeItemButton = By.id(removeItemButtonId + formattedItemName);
        guiActions.clickOn(removeItemButton);
        return new InventoryPage(driver);
    }

    public int getNumOfItemsOnCart() {
        return Integer.parseInt(guiActions.getTextFrom(shoppingCartBadge));
    }

    public boolean isCartEmpty() {
        return guiActions.ensureElementDoesNotExist(shoppingCartBadge);
    }
}
