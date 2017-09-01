package com.pages

interface SettingsPage {
    DashboardPage goToDashboard()

    LeadsPage goToLeads()

    SettingsPage goToSettings()

    SettingsLeadPage goToLeadSettings()
}