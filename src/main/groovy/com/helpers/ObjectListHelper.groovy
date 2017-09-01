package com.helpers

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class ObjectListHelper {

    private static By listElementLocator = By.tagName("li")

    private static By nameLinkFieldLocator = By.xpath(".//a[@class='name-link']")

    static def findRow(WebElement mainContainer, String name) {
        def leads = mainContainer.findElements(listElementLocator)
        leads.remove(0)
        leads.find { it.findElement(nameLinkFieldLocator).text == name }
    }

}
