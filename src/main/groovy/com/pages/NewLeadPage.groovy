package com.pages

interface NewLeadPage {
    DashboardPage goToDashboard()

    LeadsPage goToLeads()

    LeadDetailsPage createDummyLeadOnlyMandatory()

    SettingsPage goToSettings()

    LeadDetailsPage createLeadWithLastName(String lastName)
}