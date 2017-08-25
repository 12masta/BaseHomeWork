package com.pages

import com.credentials.CredentialProvider

interface LoginPage {
    DashboardPage login(CredentialProvider user)
}