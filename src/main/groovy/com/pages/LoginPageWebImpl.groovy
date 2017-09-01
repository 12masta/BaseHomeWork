package com.pages

import com.credentials.CredentialProvider
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.FindBy

class LoginPageWebImpl extends BasePageObjectWebImpl implements LoginPage, BasePageObject {

    @FindBy(id = "user_email")
    private WebElement userEmailField

    @FindBy(id = "user_password")
    private WebElement userPasswordField

    @FindBy(xpath = "//button")
    private WebElement logInButton

    LoginPageWebImpl(WebDriver driver) {
        super(driver)
    }

    DashboardPageWebImpl login(CredentialProvider user) {
        userEmailField.sendKeys(user.mail)
        userPasswordField.sendKeys(user.password)
        logInButton.click()
        return new DashboardPageWebImpl(driver)
    }
}