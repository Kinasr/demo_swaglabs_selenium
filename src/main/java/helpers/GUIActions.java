package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.MyLogger;

import java.util.List;

public class GUIActions {
    private final WebDriver driver;
    private final WebDriverWait wait;

    public GUIActions(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 15);
    }

    public void clickOn(By by) {
        logEvents(by, LogEvent.GETTING_ELEMENT);
        WebElement element = driver.findElement(by);
        logEvents(by, LogEvent.WAITING_TO_BE_CLICKABLE);
        wait.until(ExpectedConditions.elementToBeClickable(element));
        logEvents(by, LogEvent.CLICKING);
        element.click();
    }

    public void sendTextTo(By by, String text) {
        logEvents(by, LogEvent.GETTING_ELEMENT);
        WebElement element = driver.findElement(by);
        logEvents(by, LogEvent.WAITING_TO_BE_VISIBLE);
        wait.until(ExpectedConditions.visibilityOf(element));
        logEvents(by, LogEvent.CLEARING);
        element.clear();
        logEvents(by, LogEvent.SENDING_TEXT);
        element.sendKeys(text);
    }

    public String getTextFrom(By by) {
        logEvents(by, LogEvent.GETTING_ELEMENT);
        WebElement element = driver.findElement(by);
        logEvents(by, LogEvent.WAITING_TO_BE_VISIBLE);
        wait.until(ExpectedConditions.visibilityOf(element));
        logEvents(by, LogEvent.GETTING_TEXT);
        return element.getText();
    }

    public boolean ensureElementDoesNotExist(By by) {
        logEvents(by, LogEvent.GETTING_ELEMENT);
        List<WebElement> elements = driver.findElements(by);
        return elements.isEmpty();
    }

    private void logEvents(By by, LogEvent logEvent) {
        switch (logEvent) {
            case GETTING_ELEMENT -> MyLogger.info(this.getClass().getSimpleName(),
                    "Getting the element for [" + by + "]");
            case WAITING_TO_BE_VISIBLE -> MyLogger.info(this.getClass().getSimpleName(),
                    "Waiting for [" + by + "] to be visible");
            case WAITING_TO_BE_CLICKABLE -> MyLogger.info(this.getClass().getSimpleName(),
                    "Waiting for [" + by + "] to be clickable");
            case CLICKING -> MyLogger.info(this.getClass().getSimpleName(), "Clicking on [" + by + "]");
            case SENDING_TEXT -> MyLogger.info(this.getClass().getSimpleName(), "Sending text to [" + by + "]");
            case CLEARING -> MyLogger.info(this.getClass().getSimpleName(), "Clearing [" + by + "]");
            case GETTING_TEXT -> MyLogger.info(this.getClass().getSimpleName(), "Getting the [" + by + "] text");
        }
    }

    private enum LogEvent {
        GETTING_ELEMENT, WAITING_TO_BE_CLICKABLE, WAITING_TO_BE_VISIBLE, CLICKING, SENDING_TEXT, CLEARING, GETTING_TEXT
    }
}
