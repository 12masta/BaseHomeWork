package com.helpers

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class DropdownHelper {

    private static By dropdownButtonLocator = By.xpath(".//div[@class='chzn-container chzn-container-single']")

    private static By dropdownResultsLocator = By.xpath(".//ul[@class='chzn-results']")

    static def selectDropdownByText(WebElement dropdownButton, String text) {
        def dropdown = clickDropdownButton(dropdownButton)
        clickElementOnDropdown(dropdown, text)
    }

    private static def clickDropdownButton(WebElement dropdownButton) {
        def dropdown = dropdownButton.findElement(dropdownButtonLocator)
        dropdown.click()
        dropdown
    }

    private static clickElementOnDropdown(WebElement dropdown, String text) {
        def dropdownElements = dropdown.findElement(dropdownResultsLocator).findElements(By.tagName("li"))
        def elementToSelect = dropdownElements.find { it.text == text }
        elementToSelect.click()
    }
}