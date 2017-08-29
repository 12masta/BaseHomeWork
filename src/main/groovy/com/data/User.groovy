package com.data

enum User {

    BASE_USER("Marcin", "Stanek", "stanek.marcinp@gmail.com", "qwerty12")

    String firstName
    String lastName
    String mail
    String password

    User(firstName, lastName, mail, password) {
        this.firstName = firstName
        this.lastName = lastName
        this.mail = mail
        this.password = password
    }
}