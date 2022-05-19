package com.kitapyurdu.methods;

import com.google.common.collect.FluentIterable;
import com.kitapyurdu.driver.BaseTest;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;


public class Methods {

    WebDriver driver;
    FluentWait<WebDriver> wait;
    JavascriptExecutor jsdriver;

    public Methods() {

        driver = BaseTest.driver;
        wait = new FluentWait<>(driver);
        wait.withTimeout(Duration.ofSeconds(300)).pollingEvery(Duration.ofMillis(300)).ignoring(NoSuchElementException.class);
        jsdriver = (JavascriptExecutor) driver;
    }

    public WebElement findElement(By by) {
        return wait.until(ExpectedConditions.presenceOfElementLocated(by));
    }

    public void click(By by) {
        findElement(by).click();
    }

    public void waitBySeconds(long seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendKeys(By by, String text) {
        findElement(by).sendKeys(text);

    }

    public boolean isElementVisible(By by) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            return true;

        } catch (Exception e) {
            return false;
        }
    }


    public void scrollWithAction(By by) {
        Actions actions = new Actions(driver);
        actions.moveToElement(findElement(by)).build().perform();

    }


    public Select getSelect(By by) {
        return new Select(findElement(by));

    }


    public void selectByText(By by, String text) {
        getSelect(by).selectByVisibleText(text);

    }


}
