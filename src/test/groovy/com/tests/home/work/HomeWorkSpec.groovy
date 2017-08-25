package com.tests.home.work

import com.tests.AbstractSpec
import spock.lang.Unroll

import java.lang.Void as TestCase

import static com.data.User.BASE_USER

class HomeWorkSpec extends AbstractSpec {

    @Unroll
    TestCase "Create new lead"() {
        when: "lead was created"
        def newLeadPage = createDummyLead(user)
        then: "the lead status is set to New"
        newLeadPage.leadStatus == "New"
        where:
        user                    | _
        getValidUser(BASE_USER) | _
    }
}