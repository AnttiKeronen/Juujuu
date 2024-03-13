package com.example.androidi_9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ListUserInRecycleViewActivity extends RecyclerView.Adapter<ListUserInRecycleViewActivity.UserViewHolder> {

    private final List<User> mUserList;
    private final LayoutInflater mInflater;

    public ListUserInRecycleViewActivity(Context context, List<User> userList) {
        mInflater = LayoutInflater.from(context);
        mUserList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.activity_list_users, parent, false);
        return new UserViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull UserViewHolder holder, int position) {
        User currentUser = mUserList.get(position);
        holder.firstNameTextView.setText(currentUser.getFirstName());
        holder.lastNameTextView.setText(currentUser.getLastName());
        holder.emailTextView.setText(currentUser.getEmail());
        holder.degreeTextView.setText(currentUser.getDegree());
    }

    @Override
    public int getItemCount() {
        return mUserList.size();
    }

    public static class UserViewHolder extends RecyclerView.ViewHolder {
        public final TextView firstNameTextView;
        public final TextView lastNameTextView;
        public final TextView emailTextView;
        public final TextView degreeTextView;

        public UserViewHolder(View itemView) {
            super(itemView);
            firstNameTextView = itemView.findViewById(R.id.textFirstName);
            lastNameTextView = itemView.findViewById(R.id.textLastName);
            emailTextView = itemView.findViewById(R.id.textEmail);
            degreeTextView = itemView.findViewById(R.id.textDegree);
        }
    }
}


