package com.example.androidi_9;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


public class ListUsersInTextViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_users);

        RecyclerView recyclerView = findViewById(R.id.rvUserView);
        ListUserInRecycleViewActivity userListAdapter = new ListUserInRecycleViewActivity(this, UserStorage.getInstance().getUsers());

        recyclerView.setAdapter(userListAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
















