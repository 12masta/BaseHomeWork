package com.tests.home.work

import com.tests.AbstractSpec
import spock.lang.Unroll

import java.lang.Void as TestCase

import static com.data.User.BASE_USER

class HomeWorkSpec extends AbstractSpec {

    @Unroll
    TestCase "Create new lead and edit status"() {
        when: "lead was created"
        def newLead = createDummyLead user
        then: "the lead status is set to New"
        newLead.leadStatus == "New"
        when: "lead was updated"
        def updatedLead = updateLead newLead, editedStatus
        then: "the lead status is set to #editedStatus"
        updatedLead.leadStatus == editedStatus
        where:
        user                    | editedStatus
        getValidUser(BASE_USER) | "Working"
    }

    @Unroll
    TestCase "Create new lead and change status name"() {
        when: "lead was created"
        def newLead = createDummyLead user
        then: "the lead status is set to #oldStatusName"
        newLead.leadStatus == oldStatusName
        when: "status was updated"
        def leadPage = updateStatusName newLead, oldStatusName, changedStatusName
        then: "status name is set to #changedStatusName"
        leadPage.isStatusExistInSidebar(changedStatusName)
        cleanup: "change status name to #oldStatusName"
        updateStatusName leadPage, changedStatusName, oldStatusName
        where:
        user                    | oldStatusName | changedStatusName
        getValidUser(BASE_USER) | "New"         | "WorkingChanged"
    }

    @Unroll
    TestCase "Create new lead and change status name on lead page"() {
        when: "lead was created"
        def newLead = createLead user, leadName
        then: "the lead status is set to #oldStatusName"
        newLead.leadStatus == oldStatusName
        when: "status was updated"
        def leadPage = updateStatusName newLead, oldStatusName, changedStatusName
        and: "the lead was opened"
        def openedLead = openLeadByName leadPage, leadName
        then: "status name is set to #changedStatusName"
        openedLead.leadStatus == changedStatusName
        cleanup: "change status name to #oldStatusName"
        updateStatusName leadPage, changedStatusName, oldStatusName
        where:
        user                    | leadName | oldStatusName | changedStatusName
        getValidUser(BASE_USER) | "Stanek" | "New"         | "WorkingChanged"
    }
}