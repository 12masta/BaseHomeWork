package com.pages

import com.helpers.ObjectListHelper
import com.helpers.SidebarHelper
import com.helpers.WaitHelper
import org.openqa.selenium.By
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LeadsPageWebImpl extends BasePageObjectWebImpl implements LeadsPage, BasePageObject {

    @FindBy(id = "leads-new")
    private WebElement newLeadButton

    @FindBy(id = "sidebar")
    private WebElement sidebar

    @FindBy(xpath = "//input[@class='input-medium']")
    private WebElement searchField
    @FindBy(id = "main")
    private WebElement mainContainer

    LeadsPageWebImpl(WebDriver driver) {
        super(driver)
    }

    NewLeadPage clickNewLead() {
        newLeadButton.click()
        new NewLeadPageWebImpl(driver)
    }

    LeadsPageWebImpl isStatusExistInSidebar(String statusName) {
        SidebarHelper.isStatusExistInSidebar(sidebar, statusName)
        this
    }

    LeadsPage searchLead(String name) {
        searchField.sendKeys(name)
        WaitHelper.waitUntilTextToBePresentInElement(driver, getFirstElementInLeadsList())
        this
    }

    LeadDetailsPage openLeadByName(String name) {
        ObjectListHelper.findRow(mainContainer, name).click()
        new LeadDetailsPageWebImpl(driver)
    }

    private WebElement getFirstElementInLeadsList() {
        def leads = mainContainer.findElements(By.tagName("li"))
        leads.get(1)
    }
}