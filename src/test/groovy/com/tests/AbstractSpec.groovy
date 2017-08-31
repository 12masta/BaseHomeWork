package com.tests

import com.credentials.CredentialProvider
import com.credentials.ValidCredentialProviderImpl
import com.data.User
import com.pages.LeadDetailsPage
import com.pages.LoginPage
import com.pages.LoginPageWebImpl
import io.github.bonigarcia.wdm.ChromeDriverManager
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class AbstractSpec extends Specification {
    protected WebDriver driver

    def setup() {
        ChromeDriverManager.getInstance().setup()
        driver = new ChromeDriver()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.get("https://core.futuresimple.com/users/login")
    }

    def cleanup() {
        driver.close()
    }

    def getValidUser(User user) {
        new ValidCredentialProviderImpl(user)
    }

    def createDummyLead(CredentialProvider user) {
        new LoginPageWebImpl(driver).login(user).goToLeads().clickNewLead().createDummyLeadOnlyMandatory()
    }

    def updateLead(LeadDetailsPage newLeadPage, String status) {
        newLeadPage.clickEditLead().editStatus(status).saveChanges()
    }
}