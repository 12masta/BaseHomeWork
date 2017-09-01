package com.pages

import org.openqa.selenium.WebDriver

class DashboardPageWebImpl extends BasePageObjectWebImpl implements DashboardPage, BasePageObject {
    DashboardPageWebImpl(WebDriver driver) {
        super(driver)
    }
}