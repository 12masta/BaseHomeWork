package com.helpers

import org.openqa.selenium.By
import org.openqa.selenium.WebElement

class SidebarHelper {
    private static By statusFilterLocator = By.xpath(".//li[@class='filter status-filter']")

    private static By listRootLocator = By.tagName("ul")

    private static By listElementLocator = By.tagName("li")

    static boolean isStatusExistInSidebar(WebElement sidebar, String statusName) {
        def statusFilter = getStatusFilterFromSidebar(sidebar)
        def statusFilterElements = statusFilter.findElement(listRootLocator).findElement(listElementLocator)
        statusFilterElements.any { it.text == statusName }
    }

    private static WebElement getStatusFilterFromSidebar(WebElement element) {
        element.findElement(statusFilterLocator)
    }
}