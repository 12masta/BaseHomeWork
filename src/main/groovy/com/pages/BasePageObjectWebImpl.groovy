package com.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.PageFactory

class BasePageObjectWebImpl implements BasePageObject {
    @FindBy(id = "nav-item-dashboard")
    private WebElement navbarButtonDashboard

    @FindBy(id = "nav-item-leads")
    private WebElement navbarButtonLeads

    @FindBy(id = "user-dd")
    private WebElement navbarButtonSettings

    @FindBy(xpath = "//li[@class='settings']")
    private WebElement settingsButton

    protected WebDriver driver

    BasePageObjectWebImpl(WebDriver driver) {
        this.driver = driver
        PageFactory.initElements(driver, this)
    }

    DashboardPage goToDashboard() {
        navbarButtonDashboard.click()
        return new DashboardPageWebImpl(driver)
    }

    LeadsPage goToLeads() {
        navbarButtonLeads.click()
        return new LeadsPageWebImpl(driver)
    }

    SettingsPage goToSettings() {
        navbarButtonSettings.click()
        settingsButton.click()
        return new SettingsPageWebImpl(driver)
    }
}