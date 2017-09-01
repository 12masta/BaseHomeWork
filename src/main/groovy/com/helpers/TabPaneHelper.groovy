package com.helpers

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class TabPaneHelper {

    private static By controlGroupItemLocator = By.xpath(".//div[@class='control-group item']")

    private static By controlLabelLocator = By.tagName("label")

    private static By editButtonLocator = By.xpath(".//button[text()='Edit']")

    private static By saveButtonLocator = By.xpath(".//button[text()='Save']")

    private static By leadStatusNameFieldLocator = By.id("name")

    private static By fieldsetFieldLocator = By.tagName("fieldset")

    static def editLeadStatusName(WebElement element, String leadNameOld, String leadNameNew) {
        def controlGroupItem = findControlGroupItemByText(element, leadNameOld)
        clickEditButtonInControlGroupByText(controlGroupItem)
        def controlGroupItemUnderEdition = getFieldset(element)
        fillLeadStatusNameFieldByText(controlGroupItemUnderEdition, leadNameNew)
        clickSaveButtonInControlGroupByText(controlGroupItemUnderEdition)
    }

    private static def clickEditButtonInControlGroupByText(WebElement element) {
        element.findElement(editButtonLocator).click()
    }

    private static def clickSaveButtonInControlGroupByText(WebElement element) {
        element.findElement(saveButtonLocator).click()
    }

    private static def fillLeadStatusNameFieldByText(WebElement element, String leadNameNew) {
        def leadStatusNameField = element.findElement(leadStatusNameFieldLocator)
        leadStatusNameField.clear()
        leadStatusNameField.sendKeys(leadNameNew)
    }

    private static WebElement findControlGroupItemByText(WebElement element, String leadName) {
        def controlGroupItems = element.findElements(controlGroupItemLocator)
        controlGroupItems.find { it.findElement(controlLabelLocator).text == leadName }
    }

    private static WebElement getFieldset(WebElement element) {
        element.findElement(fieldsetFieldLocator)
    }
}