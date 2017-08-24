package com.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LeadsPageWebImpl extends BasePageObjectWebImpl implements LeadsPage {

    @FindBy(id = "leads-new")
    private WebElement newLeadButton

    LeadsPageWebImpl(WebDriver driver) {
        super(driver)
    }

    NewLeadPage clickNewLead() {
        newLeadButton.click()
        return new NewLeadPageWebImpl(driver)
    }
}