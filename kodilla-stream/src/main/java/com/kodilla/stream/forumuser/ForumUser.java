package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public class ForumUser {

    private final int uniqId;
    private final String userName;
    private final char sex;
    private final LocalDate dateOfBirth;
    private final int quantityOfPublicatedPosts;

    public ForumUser(int uniqId, String userName, char sex, LocalDate dateOfBirth, int quantityOfPublicatedPosts) {
        this.uniqId = uniqId;
        this.userName = userName;
        this.sex = sex;
        this.dateOfBirth = dateOfBirth;
        this.quantityOfPublicatedPosts = quantityOfPublicatedPosts;
    }

    public int getUniqId() {
        return uniqId;
    }

    public String getUserName() {
        return userName;
    }

    public char getSex() {
        return sex;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public int getQuantityOfPublicatedPosts() {
        return quantityOfPublicatedPosts;
    }

}
