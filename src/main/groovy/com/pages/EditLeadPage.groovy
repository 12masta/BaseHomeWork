package com.pages

interface EditLeadPage {
    DashboardPage goToDashboard()

    LeadsPage goToLeads()

    EditLeadPage editStatus(String value)

    LeadDetailsPage saveChanges()
}