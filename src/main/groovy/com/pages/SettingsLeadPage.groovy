package com.pages

interface SettingsLeadPage {
    DashboardPage goToDashboard()

    LeadsPage goToLeads()

    SettingsPage goToSettings()

    SettingsLeadPage changeLeadStatusName(String leadNameOld, String leadNameNew)

    SettingsLeadPage goToLEadStatuses()
}