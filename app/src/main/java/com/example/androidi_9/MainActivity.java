package com.example.androidi_9;


import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAddUserActivity(View view) {
        Intent intent = new Intent(this, AddUserActivity.class);
        startActivity(intent);
    }

    public void openListUserActivity(View view) {
        Intent intent = new Intent(this, ListUserInRecycleViewActivity.class);
        startActivity(intent);
    }
}











