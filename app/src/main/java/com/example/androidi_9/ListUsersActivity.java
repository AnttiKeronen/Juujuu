package com.example.androidi_9;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ListUsersActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        // Declaring userStorage as a local variable
        UserStorage userStorage = UserStorage.getInstance();

        recyclerView = findViewById(R.id.rvUserView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        userListAdapter = new UserListAdapter(this, userStorage.getUsers());
        recyclerView.setAdapter(userListAdapter);
    }
}








