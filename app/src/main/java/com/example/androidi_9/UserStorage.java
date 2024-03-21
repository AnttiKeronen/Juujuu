package com.example.androidi_9;

import android.content.Context;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.ArrayList;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


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

    public void saveUsers(Context context) {
        try {
            FileOutputStream fileOut = context.openFileOutput("users.data", Context.MODE_PRIVATE);
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(userList);
            objectOut.close();
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void loadUsers(Context context) {
        try (FileInputStream fileIn = context.openFileInput("users.data");
             ObjectInputStream objectIn = new ObjectInputStream(fileIn)) {
            Object obj = objectIn.readObject();
            if (obj instanceof List<?>) {
                userList = (List<User>) obj;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

