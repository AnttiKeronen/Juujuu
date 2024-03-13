package com.example.androidi_9;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import androidx.appcompat.app.AppCompatActivity;

public class AddUserActivity extends AppCompatActivity {

    private EditText firstNameEditText;
    private EditText lastNameEditText;
    private EditText emailEditText;
    private RadioGroup degreeRadioGroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.adduseractivity);

        firstNameEditText = findViewById(R.id.editFirstName);
        lastNameEditText = findViewById(R.id.editLastName);
        emailEditText = findViewById(R.id.editEmail);
        degreeRadioGroup = findViewById(R.id.radioDegreeProgram);

        Button addUserButton = findViewById(R.id.addUserButton);
        addUserButton.setOnClickListener(view -> {
            String firstName = firstNameEditText.getText().toString();
            String lastName = lastNameEditText.getText().toString();
            String email = emailEditText.getText().toString();
            String degree = ((RadioButton) findViewById(degreeRadioGroup.getCheckedRadioButtonId())).getText().toString();
            User user = new User(firstName, lastName, email, degree);
            UserStorage.getInstance().addUser(user);

            firstNameEditText.setText("");
            lastNameEditText.setText("");
            emailEditText.setText("");
            degreeRadioGroup.clearCheck();
        });

        Button showUsersButton = findViewById(R.id.showUsersButton);
        showUsersButton.setOnClickListener(view -> {
            Intent intent = new Intent(AddUserActivity.this, ListUserInTextViewActivity.class);
            startActivity(intent);
        });
    }
}





















