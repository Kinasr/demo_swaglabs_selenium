package base;

import helpers.PropertiesReader;
import helpers.WebDriverFactory;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class BaseTests {
    private WebDriver driver;

    @BeforeAll
    public void majorSetUp() {
        driver = WebDriverFactory.getDriver();
    }

    @BeforeEach
    public void minorSetUp() {
        var url = new PropertiesReader("test-configurations")
                .getProperty("base-url");
        driver.get(url);
    }

    @AfterEach
    public void minorTearDown() {}

    @AfterAll
    public void majorTearDown() {
        WebDriverFactory.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
