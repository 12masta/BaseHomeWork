package com.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class CreatedLeadPageWebImpl extends BasePageObjectWebImpl implements CreatedLeadPage{

    @FindBy(xpath = "//span[@class='lead-status']")
    private WebElement leadStatus

    CreatedLeadPageWebImpl(WebDriver driver) {
        super(driver)
    }

    def getLeadStatus(){
        leadStatus.getText()
    }
}