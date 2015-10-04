package com.example.csun24.petmypet;

/**
 * Created by csun24 on 10/3/2015.
 */
public class User {
    String name, phone, username, password;

    public User (String name, String phone, String username, String password) {
        this.name = name;
        this.phone = phone;
        this.username = username;
        this.password = password;
    }

    public User (String username, String password) {
        this.username = username;
        this.password = password;
    }
}
