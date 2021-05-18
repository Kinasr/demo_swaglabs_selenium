package pages;

import helpers.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class InventoryPage {
    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By pageTitle = By.className("title");

    public InventoryPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }

    public String getPageTitle() {
        return guiActions.getTextFrom(pageTitle);
    }
}
