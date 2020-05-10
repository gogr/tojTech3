package com.jenkins.utilities;

import com.jenkins.CucumberHooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Helper {
    public static WebDriverWait getWait() {

        return new WebDriverWait(CucumberHooks.getDriver(), 10);
    }

    public static void typeText(By locator, String text) {
        getWait().until(ExpectedConditions.visibilityOfElementLocated(locator)).sendKeys(text);

    }

    public static void click(By locator) {
        getWait().until(ExpectedConditions.elementToBeClickable(locator)).click();
    }

}
