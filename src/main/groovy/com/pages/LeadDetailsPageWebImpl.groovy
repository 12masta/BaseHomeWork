package com.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LeadDetailsPageWebImpl extends BasePageObjectWebImpl implements LeadDetailsPage {

    @FindBy(xpath = "//span[@class='lead-status']")
    private WebElement leadStatus

    @FindBy(xpath = "//a[text()='Edit']")
    private WebElement editButton

    LeadDetailsPageWebImpl(WebDriver driver) {
        super(driver)
    }

    def getLeadStatus() {
        leadStatus.getText()
    }

    EditLeadPage clickEditLead() {
        editButton.click()
        return new EditLeadPageWebImpl(driver)
    }
}