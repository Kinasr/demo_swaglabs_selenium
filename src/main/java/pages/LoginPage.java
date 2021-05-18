package pages;

import helpers.GUIActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    private final WebDriver driver;
    private final GUIActions guiActions;
    private final By textFieldUsername = By.id("user-name");
    private final By textFieldPassword = By.id("password");
    private final By buttonLogin = By.id("login-button");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        guiActions = new GUIActions(driver);
    }

    public LoginPage enterUserCredentials(String username, String password) {
        guiActions.sendTextTo(textFieldUsername, username);
        guiActions.sendTextTo(textFieldPassword, password);
        return new LoginPage(driver);
    }

    public InventoryPage login() {
        guiActions.clickOn(buttonLogin);
        return new InventoryPage(driver);
    }
}
