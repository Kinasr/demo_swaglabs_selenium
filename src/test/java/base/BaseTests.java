package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    private WebDriver driver;

    @BeforeClass
    public void majorSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void minorSetUp() {
        driver.get("https://www.saucedemo.com/");
    }

    @AfterMethod
    public void minorTearDown() {}

    @AfterClass
    public void majorTearDown() {
        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
