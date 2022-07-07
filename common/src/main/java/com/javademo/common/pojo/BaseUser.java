package com.javademo.common.pojo;

public class BaseUser {
    public BaseUser() {
    }

    public BaseUser(String username) {
        this.username = username;
    }

    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
