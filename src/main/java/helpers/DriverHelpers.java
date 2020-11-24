package helpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;

public class DriverHelpers {

    public static WebElement waitForElement(WebDriver driver, By by){
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(7))
                .pollingEvery(Duration.ofSeconds(200))
                .ignoring(Exception.class);
        return wait.until( (WebDriver dr)->
                dr.findElement(by));
    }

    public static boolean waitForTitle(WebDriver driver, String expectedTitle) {
        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(2))
                .pollingEvery(Duration.ofSeconds(100))
                .ignoring(Exception.class);
        return wait.until((WebDriver dr) ->
                dr.getTitle().equals(expectedTitle));
    }

}