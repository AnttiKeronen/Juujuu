package com.example.androidi_9;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button showUsersButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showUsersButton = findViewById(R.id.btnAddUser);

        showUsersButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Luo Intent-olio siirtyäksesi ListUsersActivityyn
                Intent intent = new Intent(MainActivity.this, ListUsersActivity.class);
                // Käynnistä uusi toiminto
                startActivity(intent);
            }
        });
    }
}








