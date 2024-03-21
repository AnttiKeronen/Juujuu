// UserListAdapter.java

package com.example.androidi_9;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {
    private List<User> userList;

    public UserListAdapter(List<User> userList) {
        this.userList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.user_view, parent, false);
        return new UserViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User user = userList.get(position);
        holder.textFirstName.setText(user.getFirstName());
        holder.textLastName.setText(user.getLastName());
        holder.textEmail.setText(user.getEmail());
        holder.textDegreeProgram.setText(user.getDegreeProgram());
        holder.textDegreeLevel.setText(user.getDegreeLevel()); // Näytä tutkinto-ohjelman taso
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        TextView textFirstName, textLastName, textEmail, textDegreeProgram, textDegreeLevel;

        public UserViewHolder(@NonNull View itemView) {
            super(itemView);
            textFirstName = itemView.findViewById(R.id.textFirstName);
            textLastName = itemView.findViewById(R.id.textLastName);
            textEmail = itemView.findViewById(R.id.textEmail);
            textDegreeProgram = itemView.findViewById(R.id.textDegreeProgram);
            textDegreeLevel = itemView.findViewById(R.id.textDegreeLevel);
        }
    }
}
















