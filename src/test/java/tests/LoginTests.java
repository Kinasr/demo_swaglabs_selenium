package tests;

import org.testng.annotations.Test;
import base.BaseTests;
import pages.LoginPage;

import static org.testng.Assert.assertEquals;

public class LoginTests extends BaseTests{

    @Test(dataProvider = "user-credentials", dataProviderClass = data_providers.DataProviders.class)
    public void loginTest(String username, String password) {
        var pageTitle = new LoginPage(getDriver())
                .enterUserCredentials(username, password)
                .login()
                .getPageTitle();
        assertEquals(pageTitle, "PRODUCTS");
    }
}
