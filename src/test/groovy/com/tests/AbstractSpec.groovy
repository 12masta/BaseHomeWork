package com.tests

import com.credentials.CredentialProvider
import com.credentials.ValidCredentialProviderImpl
import com.data.User
import com.pages.LoginPage
import com.pages.LoginPageWebImpl
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import spock.lang.Specification

import java.util.concurrent.TimeUnit

class AbstractSpec extends Specification {
    protected WebDriver driver
    protected LoginPage loginPage

    def setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\selenium\\drivers\\chromedriver.exe")
        driver = new ChromeDriver()
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS)
        driver.get("https://core.futuresimple.com/users/login")
        loginPage = new LoginPageWebImpl(driver)
    }

    def cleanup() {
        driver.close()
    }

    def getValidUser(User user){
        new ValidCredentialProviderImpl(user)
    }

    def createDummyLead(CredentialProvider user){
        loginPage.login(user).goToLeads().clickNewLead().createDummyLeadOnlyMandatory()
    }
}