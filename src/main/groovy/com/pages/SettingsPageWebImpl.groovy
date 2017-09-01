package com.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

import static com.helpers.ClickHelper.click

class SettingsPageWebImpl extends BasePageObjectWebImpl implements SettingsPage, BasePageObject {

    @FindBy(xpath = "//li[@class='leads']")
    private WebElement leadActiveButton

    SettingsPageWebImpl(WebDriver driver) {
        super(driver)
    }

    SettingsLeadPage goToLeadSettings() {
        click(leadActiveButton, driver)
        return new SettingsLeadPageWebImpl(driver)
    }
}