package test_steps;

import helpers.PropertiesReader;
import helpers.WebDriverFactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;

public class StepsBase {
    private WebDriver driver;

    @Before
    public void setUp() {
        driver = WebDriverFactory.getDriver();
        var url = new PropertiesReader("test-configurations")
                .getProperty("base-url");
        driver.get(url);
    }

    @After
    public void tearDown() {
        WebDriverFactory.quit();
    }

    public WebDriver driver() {
        return driver;
    }
}
