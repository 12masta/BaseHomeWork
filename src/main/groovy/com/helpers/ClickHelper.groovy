package com.helpers

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement

class ClickHelper {
    static def click(WebElement element, WebDriver driver) {
        WaitHelper.waitUntilElementToBeClickable(driver, element)
        element.click()
    }
}
