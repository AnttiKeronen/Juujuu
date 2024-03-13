package com.example.androidi_9;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ListUsersInTextViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ListUserInRecycleViewActivity userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        recyclerView = findViewById(R.id.rvUserView);
        userListAdapter = new ListUserInRecycleViewActivity(this, getUsers());
        recyclerView.setAdapter(userListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private List<User> getUsers() {
        List<User> users = new ArrayList<>();
        users.add(new User("John", "Doe", "john@example.com", "Bachelor"));
        users.add(new User("Jane", "Smith", "jane@example.com", "Master"));
        return users;
    }
}













