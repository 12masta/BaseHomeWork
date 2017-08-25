package com.credentials

import com.data.User

class ValidCredentialProviderImpl implements CredentialProvider {
    private User user

    ValidCredentialProviderImpl(User user) {
        this.user = user
    }

    String getFirstName() {
        return user.firstName
    }

    String getLastName() {
        return user.lastName
    }

    String getMail() {
        return user.mail
    }

    String getPassword() {
        return user.password
    }
}