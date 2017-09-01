package com.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static com.helpers.TabPaneHelper.editLeadStatusName

class SettingsLeadPageWebImpl extends BasePageObjectWebImpl implements SettingsLeadPage, BasePageObject {

    @FindBy(linkText = "Lead Statuses")
    private WebElement leadStatusesTabButton

    @FindBy(id = "lead-status")
    private WebElement leadStatusField

    SettingsLeadPageWebImpl(WebDriver driver) {
        super(driver)
    }

    SettingsLeadPage goToLEadStatuses() {
        leadStatusesTabButton.click()
        this
    }

    SettingsLeadPage changeLeadStatusName(String leadNameOld, String leadNameNew) {
        editLeadStatusName(leadStatusField, leadNameOld, leadNameNew)
        this
    }
}