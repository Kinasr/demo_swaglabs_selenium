package tests;

import org.testng.annotations.Test;
import base.BaseTests;
import pages.LoginPage;
import utilities.MyLogger;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests{

    @Test(dataProvider = "valid-user-credentials", dataProviderClass = data_providers.DataProviders.class)
    public void testValidLogin(String username, String password) {
        var pageTitle = new LoginPage(getDriver())
                .enterUserCredentials(username, password)
                .login()
                .getPageTitle();
        assertEquals(pageTitle, "PRODUCTS");
    }

    @Test(dataProvider = "invalid-user-credentials", dataProviderClass = data_providers.DataProviders.class)
    public void testInvalidLogin(String username, String password, String message) {
        var loginPage = new LoginPage(getDriver());
        loginPage
                .enterUserCredentials(username, password)
                .login();
        var errorMessage = loginPage
                .getErrorMessage();

        assertEquals(errorMessage, message);
    }
}
