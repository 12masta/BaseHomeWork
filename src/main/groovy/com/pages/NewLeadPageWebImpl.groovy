package com.pages

import org.apache.commons.lang3.RandomStringUtils
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class NewLeadPageWebImpl extends BasePageObjectWebImpl implements NewLeadPage, BasePageObject {
    @FindBy(id = "lead-last-name")
    private WebElement lastNameField

    @FindBy(id = "lead-company-name")
    private WebElement companyNameField

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton

    NewLeadPageWebImpl(WebDriver driver) {
        super(driver)
    }

    LeadDetailsPage createDummyLeadOnlyMandatory() {
        lastNameField.sendKeys(RandomStringUtils.random(6, ('A'..'Z').join(",")))
        companyNameField.sendKeys(RandomStringUtils.random(6, ('A'..'Z').join(",")))
        saveButton.click()
        return new LeadDetailsPageWebImpl(driver)
    }

    LeadDetailsPage createLeadWithLastName(String lastName) {
        lastNameField.sendKeys(lastName)
        companyNameField.sendKeys(RandomStringUtils.random(6, ('A'..'Z').join(",")))
        saveButton.click()
        return new LeadDetailsPageWebImpl(driver)
    }
}