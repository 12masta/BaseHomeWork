package com.credentials

interface CredentialProvider {
    String getFirstName()
    String getLastName()
    String getMail()
    String getPassword()
}