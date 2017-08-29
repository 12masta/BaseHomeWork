package com.pages

import com.helpers.DropdownHelper
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class EditLeadPageWebImpl extends BasePageObjectWebImpl implements EditLeadPage {
    @FindBy(id = "lead-last-name")
    private WebElement lastNameField

    @FindBy(id = "lead-company-name")
    private WebElement companyNameField

    @FindBy(xpath = "//button[text()='Save']")
    private WebElement saveButton

    @FindBy(xpath = "//div[@class='status-select']")
    private WebElement statusField

    EditLeadPageWebImpl(WebDriver driver) {
        super(driver)
    }

    EditLeadPage editStatus(String text) {
        DropdownHelper.selectDropdownByText(statusField, text)
        this
    }

    LeadDetailsPage saveChanges() {
        saveButton.click()
        return new LeadDetailsPageWebImpl(driver)
    }
}