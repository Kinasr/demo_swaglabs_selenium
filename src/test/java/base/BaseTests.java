package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

public class BaseTests {
    private WebDriver driver;

    @BeforeClass
    public void classSetUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void setUp() {
        driver.manage().deleteAllCookies();
        driver.get("https://www.saucedemo.com/");
    }

    @AfterClass
    public void classTearDown() {
//        driver.quit();
    }

    public WebDriver getDriver() {
        return driver;
    }
}
