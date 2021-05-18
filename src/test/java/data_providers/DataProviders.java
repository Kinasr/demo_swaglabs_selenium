package data_providers;

import org.testng.annotations.DataProvider;
import utilities.ReadFromExcel;

public class DataProviders {
    @DataProvider(name = "valid-user-credentials")
    public static Object[][] gerValidUserCredentials() {
        return ReadFromExcel.readDataFromExelSheet("user-credentials", "valid credentials");
    }

    @DataProvider(name = "invalid-user-credentials")
    public static Object[][] geInValidUserCredentials() {
        return ReadFromExcel.readDataFromExelSheet("user-credentials", "invalid credentials");
    }
}
