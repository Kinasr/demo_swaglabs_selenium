package pages;

import helpers.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BurgerMenu {
    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By burgerMenuButton = By.id("react-burger-menu-btn");
    private final By logoutButton = By.id("logout_sidebar_link");

    public BurgerMenu(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }

    public BurgerMenu openBurgerMenu() {
        guiActions.clickOn(burgerMenuButton);
        return new BurgerMenu(driver);
    }

    public LoginPage logout() {
        guiActions.clickOn(logoutButton);
        return new LoginPage(driver);
    }
}
