package com.kodilla.good.patterns.challenges;

public class User {

    private final String name;
    private final String surname;
    private final String nickName;
    private final String email;
    private final String address;

    public User(String name, String surname, String nickName, String email, String address) {
        this.name = name;
        this.surname = surname;
        this.nickName = nickName;
        this.email = email;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getNickName() {
        return nickName;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

}
