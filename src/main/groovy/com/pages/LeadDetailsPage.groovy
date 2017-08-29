package com.pages

interface LeadDetailsPage {
    DashboardPage goToDashboard()

    LeadsPage goToLeads()

    def getLeadStatus()

    EditLeadPage clickEditLead()
}