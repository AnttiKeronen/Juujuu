package com.example.androidi_9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adduseractivity);

        Button addUserButton = findViewById(R.id.addUserButton);
        addUserButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, AddUserActivity.class);
            startActivity(intent);
        });

        Button showUsersButton = findViewById(R.id.showUsersButton);
        showUsersButton.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListUserInTextViewActivity.class);
            startActivity(intent);
        });
    }
}










