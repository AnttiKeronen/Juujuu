package com.example.androidi_9;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import java.util.List;
import java.util.ArrayList;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Comparator;
import java.util.Collections;



public class AddUserActivity extends AppCompatActivity {
    private EditText editFirstName, editLastName, editEmail;
    private CheckBox bcCheckBox, msCheckBox, lciCheckBox, phdCheckBox;
    private Button addUserButton;
    private List<User> userList;
    private RadioGroup radioDegreeProgram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        editFirstName = findViewById(R.id.editFirstName);
        editLastName = findViewById(R.id.editLastName);
        editEmail = findViewById(R.id.editEmail);
        radioDegreeProgram = findViewById(R.id.radioDegreeProgram);

        bcCheckBox = findViewById(R.id.bcCheckBox);
        msCheckBox = findViewById(R.id.msCheckBox);
        lciCheckBox = findViewById(R.id.lciCheckBox);
        phdCheckBox = findViewById(R.id.phdCheckBox);

        addUserButton = findViewById(R.id.addUserButton);

        userList = loadUserList();

        addUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstName = editFirstName.getText().toString();
                String lastName = editLastName.getText().toString();
                String email = editEmail.getText().toString();
                String degreeProgram = getSelectedDegree();
                String degreeLevel = getSelectedDegreeLevel();

                User user = new User(firstName, lastName, email, degreeProgram, degreeLevel);

                userList.add(user);
                Collections.sort(userList, new Comparator<User>() {
                    @Override
                    public int compare(User user1, User user2) {
                        // Compare last names in descending order
                        return user2.getLastName().compareTo(user1.getLastName());
                    }
                });

                UserStorage.getInstance().addUser(user);
                saveUserList();

                clearFields();

                Intent intent = new Intent(AddUserActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    private List<User> loadUserList() {
        List<User> loadedUserList = new ArrayList<>();
        try {
            FileInputStream fileIn = openFileInput("users.data");
            ObjectInputStream objectIn = new ObjectInputStream(fileIn);
            loadedUserList = (List<User>) objectIn.readObject();
            objectIn.close();
            fileIn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return loadedUserList;
    }

    private String getSelectedDegree() {
        int selectedId = radioDegreeProgram.getCheckedRadioButtonId();
        RadioButton radioButton = findViewById(selectedId);
        if (radioButton != null) {
            return radioButton.getText().toString();
        } else {
            return "";
        }
    }

    private String getSelectedDegreeLevel() {
        if (bcCheckBox.isChecked()) {
            return "Bachelor";
        } else if (msCheckBox.isChecked()) {
            return "Master";
        } else if (lciCheckBox.isChecked()) {
            return "Licentiate";
        } else if (phdCheckBox.isChecked()) {
            return "Doctor";
        } else {
            return "";
        }
    }

    private void saveUserList() {
        User user = new User(
                editFirstName.getText().toString(),
                editLastName.getText().toString(),
                editEmail.getText().toString(),
                getSelectedDegree(),
                getSelectedDegreeLevel()
        );

        userList.add(user);
        UserStorage.getInstance().addUser(user);
        UserStorage.getInstance().saveUsers(this);
    }



    private void clearFields() {
        editFirstName.setText("");
        editLastName.setText("");
        editEmail.setText("");
        bcCheckBox.setChecked(false);
        msCheckBox.setChecked(false);
        lciCheckBox.setChecked(false);
        phdCheckBox.setChecked(false);
    }
}








































