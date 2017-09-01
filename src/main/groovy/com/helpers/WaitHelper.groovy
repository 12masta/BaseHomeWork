package com.helpers

import org.openqa.selenium.StaleElementReferenceException
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.ui.ExpectedConditions
import org.openqa.selenium.support.ui.FluentWait

import java.util.concurrent.TimeUnit

class WaitHelper {
    static def waitUntilTextToBePresentInElement(WebDriver driver, WebElement element) {
        def wait = new FluentWait<WebDriver>(driver)
                .withTimeout(10, TimeUnit.SECONDS)
                .pollingEvery(1, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException)
                .ignoring(StaleElementReferenceException)
        wait.until(ExpectedConditions.invisibilityOf(element))

    }

    static def waitUntilElementToBeClickable(WebDriver driver, WebElement element) {
        def wait = new FluentWait<WebDriver>(driver)
                .withTimeout(60, TimeUnit.SECONDS)
                .pollingEvery(3, TimeUnit.SECONDS)
                .ignoring(NoSuchElementException)
        wait.until(ExpectedConditions.elementToBeClickable(element))
    }
}