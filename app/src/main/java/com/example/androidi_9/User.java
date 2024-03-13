package com.example.androidi_9;

import android.os.Parcel;
import android.os.Parcelable;

public class User implements Parcelable {
    private final String firstName;
    private final String lastName;
    private final String email;
    private final String degree;

    public User(String firstName, String lastName, String email, String degree) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.degree = degree;
    }


    public String getFirstName() {
        return firstName;

    }

    public String getLastName() {
        return lastName;
    }


    public String getEmail() {
        return email;
    }



    public String getDegree() {
        return degree;
    }

    protected User(Parcel in) {
        firstName = in.readString();
        lastName = in.readString();
        email = in.readString();
        degree = in.readString();
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(firstName);
        dest.writeString(lastName);
        dest.writeString(email);
        dest.writeString(degree);
    }
}

