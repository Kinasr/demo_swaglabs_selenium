package data_providers;

import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "user-credentials")
    public static Object[][] gerUserCredentials() {
        return new Object[][] {{"standard_user", "secret_sauce"},
                {"   ", "  "}};
    }
}
