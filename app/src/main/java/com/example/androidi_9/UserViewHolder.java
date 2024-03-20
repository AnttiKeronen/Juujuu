package com.example.androidi_9;


import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import androidx.annotation.NonNull;



public class UserViewHolder extends RecyclerView.ViewHolder {
    TextView textFirstName, textLastName, textEmail, textDegreeProgram;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
        textFirstName = itemView.findViewById(R.id.textFirstName);
        textLastName = itemView.findViewById(R.id.textLastName);
        textEmail = itemView.findViewById(R.id.textEmail);
        textDegreeProgram = itemView.findViewById(R.id.textDegreeProgram);
    }
}




