package com.example.androidi_9;


import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;



public class ListUserActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.list_users_in_recycle_view);

        recyclerView = findViewById(R.id.rvUserView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<User> userList = UserStorage.getInstance().getUsers();
        adapter = new UserListAdapter(userList);
        recyclerView.setAdapter(adapter);
    }
}







