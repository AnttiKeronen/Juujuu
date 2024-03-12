package com.example.androidi_9;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserViewHolder> {

    private List<User> mUserList;
    private LayoutInflater mInflater;

    public UserListAdapter(Context context, List<User> userList) {
        mInflater = LayoutInflater.from(context);
        mUserList = userList;
    }

    @NonNull
    @Override
    public UserViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.user_list_item, parent, false);
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

    public class UserViewHolder extends RecyclerView.ViewHolder {
        public final TextView firstNameTextView;
        public final TextView lastNameTextView;
        public final TextView emailTextView;
        public final TextView degreeTextView;

        public UserViewHolder(View itemView) {
            super(itemView);
            firstNameTextView = itemView.findViewById(R.id.textView_first_name);
            lastNameTextView = itemView.findViewById(R.id.textView_last_name);
            emailTextView = itemView.findViewById(R.id.textView_email);
            degreeTextView = itemView.findViewById(R.id.textView_degree);
        }
    }
}

