package com.example.androidi_9;

// UserStorage.java

import java.util.ArrayList;
import java.util.List;

public class UserStorage {
    private static UserStorage instance;
    private List<User> userList;

    private UserStorage() {
        userList = new ArrayList<>();
    }

    public static synchronized UserStorage getInstance() {
        if (instance == null) {
            instance = new UserStorage();
        }
        return instance;
    }

    public void addUser(User user) {
        userList.add(user);
    }

    public List<User> getUsers() {
        return userList;
    }
}




