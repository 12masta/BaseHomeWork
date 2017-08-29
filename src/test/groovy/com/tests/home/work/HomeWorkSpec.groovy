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
        def updatedLead = updateLead newLead, status
        then: "the lead status is set to New"
        updatedLead.leadStatus == status
        where:
        user                    | status
        getValidUser(BASE_USER) | "Working"
    }
}