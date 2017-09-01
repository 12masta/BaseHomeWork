package com.pages

interface LeadsPage {
    DashboardPage goToDashboard()

    LeadsPage goToLeads()

    NewLeadPage clickNewLead()

    SettingsPage goToSettings()

    LeadsPageWebImpl isStatusExistInSidebar(String statusName)

    LeadDetailsPage openLeadByName(String name)

    LeadsPage searchLead(String name)
}