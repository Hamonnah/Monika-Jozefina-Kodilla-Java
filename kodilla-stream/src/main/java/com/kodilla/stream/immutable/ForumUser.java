package com.kodilla.stream.immutable;

public final class ForumUser {

    private final String userName;
    private final String realName;

    public ForumUser(String userName, String realName) {
        this.userName = userName;
        this.realName = realName;
    }

    public final String getUserName() {
        return userName;
    }

    public final String getRealName() {
        return realName;
    }
}
